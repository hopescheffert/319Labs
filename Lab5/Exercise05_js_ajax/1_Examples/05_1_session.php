<?php
session_start(); // THIS MUST BE THE FIRST THING YOU DO

// THE PURPOSE OF THIS FILE IS TO SHOW HOW SESSION CAN BE USED
// TO STORE DATA ACROSS USER HTTP REQUESTS!
// THE FIRST REQUEST WAS TO THIS FILE.

// IF YOU DID NOT WANT TO SAVE SESSION - COMMENT OUT session_start()

$_SESSION["favcolor"] = "green";


// HERE WE MAKE ANOTHER REQUEST. We need to check if we have access
// to the favcolor information that is saved on THIS page.
//
echo "<h1> Welcome to a simple page</h1>
<hr><br>
<a href=\"05_2_nextPage.php\">Click here to go to next page</a>";

?>

