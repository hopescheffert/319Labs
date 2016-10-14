<?php
// checkLogin.php
// read the users.txt file and then check the user/password.
// return a json object with the success/failure info



// $userFile = fopen("users.txt", "r") or die("Unable to open users.txt");
// //reads userx.txt to the end:
// fread($userFile, filesize("users.txt"));
//
// //get whole line from userFile
// $user = fgets($userFile); //TODO THIS MUST BE JSON ENCODED ARRAY (in signup.html)
// //decode the line from the users.txt file into an object so that we can get info
// $obj = json_decode($user);
// //get username and password ....do some check?
// $username = $obj->{'username'};
// $password = $obj->{'password'};
//
//
$result = new stdClass();
$result->success = false;
// //TODO check username/password?
// //if(they are okay) $result = true;
// //else $result = false;

$jsonResponse = json_encode($result); //json object to return with success/failure info


//close the file
//fclose($userFile);

echo $jsonResponse;



 ?>
