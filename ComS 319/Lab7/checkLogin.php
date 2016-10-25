<?php
/**
 * Created by PhpStorm.
 * User: jeredhoff
 * Date: 10/19/15
 * Time: 2:23 PM
 */

$name = (string)$_GET["name"];
$password = (string)$_GET["pass"];

$file = fopen("Lab7/users.txt", "r") or die("Unable to open users file!");
$info = fread($file, filesize("Lab7/users.txt"));

$login = $name." - ".$password;

if($info == $login){
    session_start();
    $_SESSION["name"] = $name;
    header('Location: http://localhost:8080/Lab7/viewPosts.php');
} else {
    header('Location: http://localhost:8080/Lab7/login2.html');
}

fclose($file);
?>
