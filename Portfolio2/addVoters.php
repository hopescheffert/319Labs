<?php
//addVoters.php

$currentvoter = json_decode(file_get_contents("php://input"));
$currentvoter = json_encode($currentvoter);
$path = "/Applications/XAMPP/xamppfiles/htdocs/portfolio2/voters.json";
$votersFile = fopen($path, "r") or die("Unable to open voters.json");



$found = false;
while(!feof($votersFile))
{
    $voter = stream_get_line($votersFile, NULL, "***\n");
    $obj = json_decode($voter);
    echo $obj->ssn;
    if($voter == null)
    {
        //reached end of file
        $found = false;
        break;
    }
    //look for the current voter
    if(strcmp($obj->ssn, $currentvoter->ssn) == 0)
    {
        $found = true;
        break;
    }
}

if(!$found)
{
    $line = json_encode($currentvoter) . "***\n";
    file_put_contents($path, $line, FILE_APPEND);
    echo json_encode($currentvoter);
}
// else {
//     echo json_encode(false);
// }

?>
