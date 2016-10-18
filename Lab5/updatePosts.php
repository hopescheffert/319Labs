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
$isAdmin = false;
if(strcmp($user, "admin") == 0)
{
    $isAdmin = true;
}

$post = $_SESSION['post'];
$post = json_decode($post);
$postsFile = fopen("posts.txt", "w+");

while(!feof($postsFile))
{
    $p = fgets($postsFile);
    $obj = json_decode($p);
    if($obj != null)
    {
        $title = $obj->title;
        $desc = $obj->description;

        if((strcmp($title, $post->title) == 0) && (strcmp($desc, $post->description) == 0))
        {
            //TODO modify post
            //TODO use file_put_contents() to store posts back into posts.txt
            //TODO do we just change that line?
            file_put_contents("posts.txt", $post);
        }
        else
        {
            //TODO create a new entry
            $newPost;
            //TODO use file_put_contents() to store posts back into posts.txt
            file_put_contents("posts.txt", $newPost + "\n");

        }
        //TODO update session object


    }

}





?>
