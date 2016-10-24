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
$id = $_REQUEST["id"];

$isAdmin = false;
if(strcmp($user, "admin") == 0)
{
    $isAdmin = true;
}
//TODO if admin they can delete
$post = '{"Title" : '. $title . ', "Description" : ' . $description . ', "Time" : ' . $time . ', "ID" : '. $id . '}';
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
        $currentid = $obj->ID;

        if((strcmp($currentTitle, $title) == 0))
        {
            $modification = array('Title' => $currentTitle, 'Description' => $description, 'Time' => $time, 'ID' => $currentid);
            $entry = json_encode($modification) . "\n";

            //TODO how to remove the current line from posts.txt
            //$p = str_replace($p, '', $p);
            //file_put_contents("posts.txt", $p);
            //file_put_contents("posts.txt", str_replace($p . "\r\n", "", file_get_contents("posts.txt")));
            file_put_contents("posts.txt", $entry, FILE_APPEND);
            echo json_encode($modification);
            break;
        }
        else
        {
            $newPost = array('Title' => $title, 'Description' => $description, 'Time' => $time, 'ID' => $id);
            $entry = json_encode($newPost) . "\n";
            file_put_contents("posts.txt", $entry, FILE_APPEND);
            echo json_encode($newPost);
            break;

        }
        //update session object
        $_SESSION["post"] = $newPost;

    }

}
header('Location: http://localhost:8080/Lab7/viewPosts.php');


?>
