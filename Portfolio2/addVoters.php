<?php
//addVoters.php
//NOTE the file path may change
$currentvoter = json_decode(file_get_contents("php://input"));
$path = "/Applications/XAMPP/xamppfiles/htdocs/portfolio2/voters.json";
$votersFile = fopen($path, "r") or die("Unable to open voters.json");

//NOTE THAT AS LONG AS THEY HAVE DIFFERENT SOCIAL SECURITY NUMBERS, THEY ARE ALLOWED TO VOTE
$found = false;
while(!feof($votersFile) && !$found)
{
    $obj = stream_get_line($votersFile, NULL, "***\n");
    $voter = json_decode($obj);
    //$obj = json_decode($voter);
    if($voter == null)
    {
        //reached end of file
        $line = json_encode($currentvoter) . "***\n";
        file_put_contents($path, $line, FILE_APPEND);
        echo json_encode($currentvoter);
        $found = false;
        break;
    }
    //look for the current voter
    if(strcmp($voter->ssn, $currentvoter->ssn) == 0)
    {
        $found = true;
        echo "false";
        return;
    }
}
?>
