<?php

$commands = $_REQUEST["commands"];
echo $commands;

$file = "commands.in";
file_put_contents($file, $commands);

//TODO run the parser with commands!

$cmd1 = "antlr4 DrawingBoard.g4";
$cmd2 = "javac *.java";
$cmd3 = "grun DrawingBoard start -tree < " . $file;

$result1 = exec($cmd1);
// if(strlen($result1) > 0)
{
    echo $result1;
}
$result2 = exec($cmd2);
// if(strlen($result2) > 0)
{
    echo $result2;
}
$result3 = exec($cmd3);
echo $result3;





?>
