<?php
//getVotes.php



$votesFile = fopen("/Applications/XAMPP/xamppfiles/htdocs/portfolio2/votes.json", "r") or die("Unable to open votes.json");


//$votes = "{'clinton': " . $clintonCount . ", 'trump': " . $trumpCount. ", 'johnson': " . $johnsonCount . ", 'stein': " . $steinCount . "}";
$votes = stream_get_line($votesFile, NULL);
echo $votes;


?>
