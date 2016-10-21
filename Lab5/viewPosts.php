<?php
session_start();
// viewPosts.php
// - use file_get_contents php function to get data from posts.txt; convert to php object
// (using json_decode/json_encode php functions)
// - loop thru this object and create html rows with a link to update post (that will use
// javascript to bring up a prompt to get the message from the user and then make an ajax
// call to updatePosts.php to do the update) and then refreshes only the table (and not the
// rest of the page).
// - can store the post object in the session object.
//
// TODO Every post is editable and updatable.

$data = file_get_contents("posts.txt");
$jsonData = explode("\n", $data);
for($i = 0; $i < count($jsonData); $i++)
{
    if(json_decode($jsonData[$i]) != null)
    {
        $phpObject[$i] = json_decode($jsonData[$i]);
        // echo $phpObject[$i]->Body;
    }
    else break;

}
//$jsonData = '{"User": "TEST", "Reciever": "TEST", "Body": "Hello there"}';
//$jsonObj = json_encode($jsonData);
// $phpObject = json_decode($jsonData);
// echo $phpObject->Body;
//ex. Title, description, time posted

//loop through object and create html rows with a link to update post
//---that will use javascript to bring up a prompt to get the message from the user
//and then make an ajax call to updatePosts.php to do the update
echo "<table id='myTable'>";
for($j = 0; $j < count($phpObject); $j++)
{
    echo "<tr>";
    $button = "<button id='button' >Update Post</button>";//onclick='alert(\\Hello\\);'
    echo "<td>". $phpObject[$j]->Body . " " . $button . ' </td>';
    echo "</tr>";
}
echo "</table>";



 ?>
