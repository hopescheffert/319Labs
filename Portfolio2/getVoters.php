<?php
//getVoters.php

$votersFile = fopen("/Applications/XAMPP/xamppfiles/htdocs/portfolio2/voters.json", "r") or die("Unable to open voters.json");

$currentvoter = json_decode(file_get_contents("php://input"));
echo $currentvoter;
$succeeded = true;
$failed = false;


while(!feof($votersFile))
{
    $voter = stream_get_line($votersFile, NULL, "***\n");
    $obj = json_decode($voter);
    if($obj == null)
    {
        //reached end of file
        echo json_encode($failed);
        break;
    }
    //look for the current voter's ssn in file
    if(strcmp($obj->ssn, $currentvoter->ssn) == 0)
    {
        echo json_encode($succeeded);
        break;
    }
}

// echo json_encode($failed);
fclose($votersFile);

?>
