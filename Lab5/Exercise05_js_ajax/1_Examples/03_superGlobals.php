<?php 

// THE PURPOSE OF THIS FILE IS TO SHOW SUPER GLOBAL VARIABLES!
// THESE ARE VARIABLES THAT ARE ALWAYS ACCESSIBLE IN ALL PHP FILES
// THERE ARE NINE OF THEM.

// GLOBALS (Has all global variables + all below variables as well)
// _SERVER, (server information) 
// _ENV, (shell environment information)
// _POST, _GET, _REQUEST (request information)
// _FILES (file uploaded information)
// _COOKIE, _SESSION

$x = "Hello!";
$y = 3.14;
$z = true;

// TODO: see how the above three globals are listed in the globals!
// var_dump is a really useful function to know!

echo "<h1>globals</h1> <br>"; var_dump($GLOBALS); echo "<hr>";
echo "<h1>server</h1> <br>"; var_dump($_SERVER); echo "<hr>";
echo "<h1>env </h1><br>"; var_dump($_ENV); echo "<hr>";
echo "<h1>files</h1> <br>"; var_dump($_FILES); echo "<hr>";
echo "<h1>get </h1><br>"; var_dump($_GET); echo "<hr>";
echo "<h1>post</h1> <br>"; var_dump($_POST); echo "<hr>";
echo "<h1>request</h1> <br>"; var_dump($_REQUEST); echo "<hr>";
echo "<h1>cookie </h1><br>"; var_dump($_COOKIE); echo "<hr>";
echo "<h1>session </h1><br>"; var_dump($_SESSION); echo "<hr>";

?>
