<?php
// checkLogin.php
// read the users.txt file and then check the user/password.
// return a json object with the success/failure info
session_start();

$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");

$response = new stdClass();
$response->success = false;

//current username and password from login.html
$curUser = $_REQUEST["username"];
$curPass = $_REQUEST["password"];

while(!feof($userFile))
{
    //get whole line from userFile
    $user = fgets($userFile); //THIS MUST BE JSON ENCODED (in signup.html)

    //decode the line from the users.txt file into an object so that we can get info
    $obj = json_decode($user);
    if($obj == null)
    {
        //reached end of file
        echo json_encode($response);
        break;
    }
    //get username and password ....do some check?
    $username = $obj->username;
    //echo "username is " . $username . "<br>";

    $password = $obj->password;
    //echo "password is ".$password. "<br>";


    if((strcmp($username, $curUser) == 0)  && (strcmp($password, $curPass) == 0))
    {
        $response->success = true;
        $_SESSION["username"] = $username;
        echo json_encode($response);
        break;
    }

}

//close the file
fclose($userFile);


?>
