<?php
session_start(); // Note that this must be the first thing you do.

echo " <h1> This is the next page</h1> <hr><br>";

// STORE SOME VALUE
$_SESSION["myShoppingCart"] = array("Rocket"=> 3, "Oxygen" => 100);

// TODO: CHECK IF THE favcolor has been stored from the LAST HTTP
// request
echo "<h2>Do check if favcolor has been stored</h2><br>";
var_dump($_SESSION);
var_dump($GLOBALS);

// HERE WE CLICK AGAIN AND MAKE ANOTHER HTTP REQUEST!
// HOWEVER SESSION WILL BE STORED but then we destroy the session
echo "<a href=\"05_3_endsession.php\">Click here to go to next page</a>";
echo "<hr><br>";

?>

