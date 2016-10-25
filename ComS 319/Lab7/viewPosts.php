<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
</head>
<body>

<form action="Lab7/updatePosts.php" method="get">
    New Post: <input type="text" name="post" id="post"><br>
    <input type="submit">
</form>

<?php

$file = fopen("Lab7/posts.txt", "r") or die("Unable to open posts file!");
if(filesize("Lab7/posts.txt") > 0) {
    $info = fread($file, filesize("Lab7/posts.txt"));
    $arr = explode(";", $info);
    for ($i = count($arr) - 2; $i >= 0; $i--) {

        $post = json_decode($arr[$i]);
        echo "<div>";
            echo $post->name." - ".$post->post;
            echo "    <button>Like</button>";
        echo "</div>";
        echo "<br/>";
    }
}

?>

<form action="Lab7/logout.php">
    <input type="submit" value="Logout">
</form>

</body>

<script>


</script>
</html>
