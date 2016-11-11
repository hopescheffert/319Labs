<?php
//sendVotes.php

//NOTE the file path may change

// $file = fopen("/Applications/XAMPP/xamppfiles/htdocs/portfolio2/votes.json", "r") or die("Unable to open votes.json");
// $line = stream_get_line($file, NULL);
// $votes = json_encode($line);
//
// fclose($file);

$params = json_decode(file_get_contents("php://input"));
$votes = $params->votes;
// $candidate = file_get_contents("php://input");
$candidate = $params->candidate;
if(strcmp($candidate, "clinton") == 0)
{
    $votes->clinton += 1;
}
else if(strcmp($candidate, "trump") == 0)
{
    $votes->trump += 1;

}
else if(strcmp($candidate, "johnson") == 0)
{
    $votes->johnson += 1;

}
else if(strcmp($candidate, "stein") == 0)
{
    $votes->stein += 1;

}
$votesFile = "/Applications/XAMPP/xamppfiles/htdocs/portfolio2/votes.json";
file_put_contents($votesFile, json_encode($votes));
// fclose($votesFile);
// echo json_encode($votes);


$votesFile = fopen("/Applications/XAMPP/xamppfiles/htdocs/portfolio2/votes.json", "r") or die("Unable to open votes.json");
$votes = stream_get_line($votesFile, NULL);
echo json_encode($votes);

?>
