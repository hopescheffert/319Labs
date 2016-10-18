<?php
// checkLogin.php
// read the users.txt file and then check the user/password.
// return a json object with the success/failure info
session_start();
// header('Content-Type: application/json');


$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");


// $response = new stdClass();
// $response->success = true;
$succeeded = true;
$failed = false;


//current username and password from login.html
$curUser = $_REQUEST["username"];
// echo $curUser . "<br>";
$curPass = $_REQUEST["password"];
// echo $curPass . "<br>";

while(!feof($userFile))
{
    //get whole line from userFile
    //$user = fgets($userFile); //THIS MUST BE JSON ENCODED (in signup.html)
    $user = stream_get_line($userFile, NULL, "***");
    //decode the line from the users.txt file into an object so that we can get info
    echo $user . "<br>";
    $obj = json_decode($user);
    if($obj == null)
    {
        //reached end of file
        // $response->success = false;
        echo "failed because object is null <br>" . json_encode($failed) ."<br>";
        break;
    }
    //get username and password ....do some check?
    $username = $obj->username;
    echo "username is " . $username . "<br>";

    $password = $obj->password;
    echo "password is ".$password. "<br>";


    if((strcmp($username, $curUser) == 0)  && (strcmp($password, $curPass) == 0))
    {
        // $response->success = true;
        $_SESSION["username"] = $username;
        $_SESSION["password"] = $password;
        echo "succeeded! " . json_encode($succeeded);
        break;
    }
}
// echo "failed because couldn't find in user file <br>" . json_encode($failed);

//close the file
fclose($userFile);


?>
