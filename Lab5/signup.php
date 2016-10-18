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


// //Function for encrypting with RSA
// function rsa_encrypt($string, $public_key)
// {
//     //Create an instance of the RSA cypher and load the key into it
//     $cipher = new Crypt_RSA();
//     $cipher->loadKey($public_key);
//     //Set the encryption mode
//     $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
//     //Return the encrypted version
//     return $cipher->encrypt($string);
// }
//
// //Function for decrypting with RSA
// function rsa_decrypt($string, $private_key)
// {
//     //Create an instance of the RSA cypher and load the key into it
//     $cipher = new Crypt_RSA();
//     $cipher->loadKey($private_key);
//     //Set the encryption mode
//     $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
//     //Return the decrypted version
//     return $cipher->decrypt($string);
// }

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
if($curUser != null)
{
	//$user = '{"username" : ' . $curUser . ', "password" :' . $curPass . ', "publickey" : ' . $public_key . ', "privatekey" : ' . $private_key . '}\n';
	$user = array('username' => $curUser, 'password' => $curPass, 'publickey' => $public_key, 'privatekey' => $private_key);
	$entry = json_encode($user) . "***\n";
	file_put_contents("users.txt", $entry, FILE_APPEND);
}

?>
