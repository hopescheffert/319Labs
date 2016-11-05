<?php
// checkLogin.php
// read the database to check the user/password.
// return a json object with the success/failure info
session_start();
include("databaseconnection.php");

$succeeded = true;
$failed = false;


//current username and password from login.html
$username = $_REQUEST["username"];
$password= $_REQUEST["password"];

//TODO doesn't check librarain attribute correctly
echo "*****is librarian is" . $_REQUEST["librarian"] . "<BR>";
if($_REQUEST["librarian"] == "true")
{
    $isLibrarian = 1;
}
else
{
    $isLibrarian = 0;
}

$sql = "SELECT password, librarian FROM users WHERE userName='" .$username . "'";
$result = mysqli_query($conn, $sql);

if(mysqli_num_rows($result) > 0)
{
    // output data of each row
    while($row = mysqli_fetch_assoc($result))
    {
        //echo "id: " . $row["id"]. " - Name: " . $row["firstname"]. " " . $row["lastname"]. "<br>";
        $encrypted = MD5($password);
        if((strcmp($encrypted, $row["password"]) == 0) && ($isLibrarian == $row["librarian"]))
        {
            //found the user
            $_SESSION["username"] = $username;
            echo json_encode($succeeded);
            exit;
        }
    }

}
echo json_encode($failed);




?>
