<?php

// var_dump is your friend! prints out info in an object/array
var_dump($GLOBALS);
echo "<hr>";


// print_r is print recursive - also used to print info
// can be used to RETURN a string with second parameter true
echo print_r($_FILES, true);

echo "<hr>";

// this one's job is to convert a PHP object to a JSON string
echo json_encode($_FILES);

?>
