<?php
//getVotes.php
//NOTE the file path may change

$votesFile = fopen("/Applications/XAMPP/xamppfiles/htdocs/portfolio2/votes.json", "r") or die("Unable to open votes.json");
$votes = stream_get_line($votesFile, NULL);
echo $votes;


?>
