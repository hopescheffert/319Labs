<?php //session_start()?>

<!-- <!DOCTYPE html>
<hmtl>
<body>
<table id='myTable' border=2>
    <th>User</th>
    <th>Post Body</th>
    <th>Time</th>
    <!-- <tr><button id='button0' onclick='prompt("Update Your Post")'>Update Post</button></tr>

</body>

</html> -->


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
        //echo $phpObject[$i]->Body . "    ";
    }
    else break;

}
//$jsonData = '{"User": "TEST", "Reciever": "TEST", "Body": "Hello there"}';
//ex. Title, description, time posted

//loop through object and create html rows with a link to update post
//---that will use javascript to bring up a prompt to get the message from the user
//and then make an ajax call to updatePosts.php to do the update
echo "<table id='myTable' border=2>";
echo "<th>User</th>";
echo "<th>Post Body</th>";
echo "<th>Time</th>";

//TODO make update post button do ajax post call to updatePosts.php to do update
//then only refreshes the table, not the entire page
for($j = 0; $j < count($phpObject); $j++)
{
    echo "<tr>";
    $button = "<button id='button". $j."' onclick=\"prompt('Update Your Post');\">Update Post</button>";
    //$button = addslashes($button);
    echo "<td>". $phpObject[$j]->User . "</td>";
    echo "<td>" . $phpObject[$j]->Body ."<br>". $button ."</td>";
    echo "<td>" .$phpObject[$j]->Time. "</td>";
    echo "</tr>";
}
echo "</table>";



 ?>
 <script>



 </script>
