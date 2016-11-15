<?php
session_start();
// signup.php
//does the encryption and decryption
$path = 'Exercise05_js_ajax/phpseclib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
include_once('Exercise05_js_ajax/phpseclib/Crypt/RSA.php');
if(isset($_POST["username"]))
{
	$curUser = $_POST["username"];
	$_SESSION['username'] = $curUser;
	echo "<br>user is ". $curUser;
}
else {
  die("current user is null");
}
if(isset($_POST["password"]))
{
	$curPass = $_POST["password"];
	$_SESSION['password'] = $curPass;
}


$rsa = new Crypt_RSA();
$rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS1);
$rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);
extract($rsa->createKey(1024)); /// makes $publickey and $privatekey available
//echo "<script> var privatekey = " . $privatekey . "</script>";
//echo "<script> var publickey = " . $publickey . "</script>";
//Private key
$private_key = $privatekey;
$public_key = $publickey;
// echo "private " . $private_key . " ";
// echo "public " . $public_key;

$userFile = "/Applications/XAMPP/xamppfiles/htdocs/Lab5/users.txt";

if($curUser != null)
{
	$user = array('username' => $curUser, 'password' => $curPass, 'publickey' => $public_key, 'privatekey' => $private_key);
	$entry = json_encode($user) . "***\n";
	echo "here";
	file_put_contents($userFile, $entry, FILE_APPEND);
	header('Location: login.html');

}
else {
	echo "current user is null";
}


?>
