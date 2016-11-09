<?php
//sendVotes.php
// $v = "{'clinton': " . $clintonCount . ", 'trump': " . $trumpCount. ", 'johnson': " . $johnsonCount . ", 'stein': " . $steinCount . "}";
// $votes = json_encode($v);
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
echo json_encode($votes);

?>
