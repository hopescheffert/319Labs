<?php
/**
 * Created by PhpStorm.
 * User: Blane
 * Date: 10/24/2015
 * Time: 5:30 PM
 */
session_start();

$numFile = fopen("Lab7/number.txt", "r") or die("Unable to open number file!");
$number = (int)fread($numFile, filesize("Lab7/number.txt"));
$number = $number + 1;
fclose($numFile);

$numFile = fopen("Lab7/number.txt", "w") or die("Unable to open number file!");
fwrite($numFile, $number);
fclose($numFile);

$post = array('name' => $_SESSION["name"], 'post' => $_GET["post"], 'number' => $number);

$file = fopen("Lab7/posts.txt", "a+") or die("Unable to open posts file!");

fwrite($file, json_encode($post).";");

header('Location: http://localhost:8080/Lab7/viewPosts.php');
