<!-- checkLogin.php
- read the users.txt file and then check the user/password.
- return a json object with the success/failure info
-->

<?php
$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");
//reads userx.txt to the end:
fread($userFile, filesize("users.txt"));

//get whole line from userFile
$user = fgets($userFile);
//TODO PARSE THE STRING TO GET  users/passwords/public key/private key
//EX: smitra:testPassword:ddhfh9fi3f3i:94hredbb

for($i = 0; $i < strlen($user); $i++)
{
    //charat $user
    $char = $user{$i};
    if(strcmp($char, ":") == 0)
    {

    }
}



//close the file
fclose($userFile);

 ?>
