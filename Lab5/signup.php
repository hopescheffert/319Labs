<?php
session_start();
header('Location: login.html');
// signup.php
//does the encryption and decryption
$path = 'phpseclib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
include_once('Crypt/RSA.php');

$curUser = $_REQUEST['username'];
$curPass = $_REQUEST['password'];

$_SESSION['username'] = $curUser;
$_SESSION['password'] = $curPass;

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
$userFile = fopen("users.txt", "a+") or die("Unable to open users.txt");

if($curUser != null)
{
	$user = array('username' => $curUser, 'password' => $curPass, 'publickey' => $public_key, 'privatekey' => $private_key);
	$entry = json_encode($user) . "***\n";
	file_put_contents($userFile, $entry, FILE_APPEND);
}

?>
