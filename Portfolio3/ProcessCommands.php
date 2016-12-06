<?php

$commands = $_REQUEST["commands"];
// $refreshed = $_REQUEST["refreshed"];

// if(!$refreshed)
// {
//
//
// }


//run the parser with commands!

file_put_contents("commands.in", $commands);

$parse = shell_exec("./runAntlr.sh commands.in 2>&1");
echo $parse;


?>
