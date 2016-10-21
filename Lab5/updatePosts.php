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
//$post = $_SESSION['post'];
$post = json_decode($post);
echo $title ." " . $description . " " . $time . "<br>";
$postsFile = fopen("posts.txt", "a+");
while(!feof($postsFile))
{
    $p = stream_get_line($postsFile, NULL, "***\n");
    $obj = json_decode($p);
    if($obj != null)
    {
        $updatedTitle = $obj->Title;
        $updatedDesc = $obj->Description;
        $updatedTime = $obj->Time;
        echo $updatedTitle ." " . $updatedDesc . " " . $updatedTime;

        if((strcmp($updatedTitle, $post->Title) == 0) && (strcmp($updatedDesc, $post->Description) == 0))
        {
            //TODO modify post
            //TODO do we just change that line?
            //$newPost = '{"Title" : '. $updatedTitle . ', "Description" : ' . $updatedDesc . ', "Time" : ' . $updatedTime . '}';
            $entry = json_encode($post) . "***\n";
            file_put_contents("posts.txt", $post, FILE_APPEND);
            break;
        }
        else
        {
            //TODO create a new entry
            $newPost = '{"Title" : '. $updatedTitle. ', "Description" : ' . $updatedDesc . ', "Time" : ' . $updatedTime . '}';
            $entry = json_encode($newPost) . "***\n";
            file_put_contents("posts.txt", $newPost, FILE_APPEND);

            break;
        }
        echo "didnt find";
        //update session object
        $_SESSION["post"] = $newPost;


    }

}





?>
