<?php

$commands = $_REQUEST["commands"];

//run the parser with commands!

$parse = shell_exec("./runAntlr.sh DrawingBoard.in 2>&1");
echo $parse;


?>
