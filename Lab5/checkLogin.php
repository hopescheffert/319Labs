<?php
// checkLogin.php
// read the users.txt file and then check the user/password.
// return a json object with the success/failure info
session_start();


$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");
//reads userx.txt to the end:
fread($userFile, filesize("users.txt"));

//get whole line from userFile
//$user = fgets($userFile); //TODO THIS MUST BE JSON ENCODED ARRAY (in signup.html)
$user = '{"username": "Hope", "password": "pass", "publickey": "some pub key", "privatekey": "some priv key"}';
//decode the line from the users.txt file into an object so that we can get info
$obj = json_decode($user);
echo "obj is " . $obj;
//get username and password ....do some check?
$username = $obj->username;
echo $username;
$password = $obj->password;
echo $password;

$_SESSION["username"] = $username;
//close the file
fclose($userFile);

$result = new stdClass();
$result->success = false;
//TODO check username/password?
if($username != null && $password != null)
{
    $result = true;
}

$jsonResponse = json_encode($result); //json object to return with success/failure info

echo $jsonResponse;

?>
