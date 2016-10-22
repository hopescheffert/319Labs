<?php
session_start();
// updatePosts.php
// - if the user is admin, he/she can delete any message.
// - if the post information sent by the current user (except admin) is already in the posts
// file
//     - then modify it
//     - else create a new entry
// - use file_put_contents php function to store the posts back into the posts.txt file
// - also update the session object if needed

$user = $_SESSION['username'];
$title = $_REQUEST["title"];
$description = $_REQUEST["description"];
$time = $_REQUEST["time"];

$isAdmin = false;
if(strcmp($user, "admin") == 0)
{
    $isAdmin = true;
}
//TODO if admin they can delete
$post = '{"Title" : '. $title . ', "Description" : ' . $description . ', "Time" : ' . $time . '}';
$post = json_decode($post);
$postsFile = fopen("posts.txt", "a+");
while(!feof($postsFile))
{
    $p = stream_get_line($postsFile, NULL, "\n");
    $obj = json_decode($p);
    if($obj != null)
    {
        $currentTitle = $obj->Title;
        $currentDesc = $obj->Description;
        $currentTime = $obj->Time;

        if((strcmp($currentTitle, $title) == 0))
        {
            echo "modify";
            //$modification = '{"Title" : '. $currentTitle. ', "Description" : ' . $currentDesc . ', "Time" : ' . $currentTime . '}';
            $modification = array('Title' => $currentTitle, 'Description' => $description, 'Time' => $time);
            $entry = json_encode($modification); //. "\n";
            file_put_contents("posts.txt", $entry, FILE_APPEND);
            break;
        }
        else
        {
            echo "new";
            $newPost = array('Title' => $title, 'Description' => $description, 'Time' => $time);
            //$newPost = '{"Title" : '. $title . ', "Description" : ' . $description . ', "Time" : ' . $time . '}';
            $entry = json_encode($newPost);// . "\n";
            file_put_contents("posts.txt", $entry, FILE_APPEND);
            break;

        }
        //update session object
        $_SESSION["post"] = $newPost;


    }

}





?>
