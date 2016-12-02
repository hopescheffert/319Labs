<?php

$commands = $_REQUEST["commands"];
echo $commands;

// $file = "commands.in";
// file_put_contents($file, $commands);
//
// $path = "/Users/hopescheffert/Documents/COMS319/Portfolio3/";
//
// //TODO run the parser with commands!
//$move = "mv commands.in " . $path;
$move = "cd /Users/hopescheffert/Documents/COMS319/Portfolio3/";
$moveresult = shell_exec($move);
echo "move result is " . $moveresult;

$antlr = "pwd";//"antlr4 DrawingBoard.g4";
$compile = "javac *.java";
$grun = "grun DrawingBoard start -tree < " . "DrawingBoard.in";

$result1 = shell_exec($antlr);
// if(strlen($result1) > 0)
{
    echo "from antlr4 " . $result1;
}
$result2 = shell_exec($compile);
// if(strlen($result2) > 0)
{
    echo "from compile " .$result2;
}
$result3 = shell_exec($grun);
echo "from grun " . $result3;


?>
