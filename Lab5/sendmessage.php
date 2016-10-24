<?php
session_start();
$path = 'phpseclib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
include_once('Crypt/RSA.php');

$curUser = $_SESSION['username'];
$user = $_REQUEST['user'];
$reciever = $_REQUEST['reciever'];
$body = $_REQUEST['body'];
?>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>


<body>
    <!-- sendmessage.php -->

    <form id='myForm'>
        Reciever: <br><input type='text' id='reciever'</input> <br>
        User: <br> <input type='text' id='user' value="<?php echo $curUser ?>" </input> <br>
        Body:<br> <textarea rows='4' id='body' cols='50'>Type your message here </textarea> <br>
        <input id='submit' type='submit'</input>
    </form>


    <script>
    $(document).ready(function()
    {
        var myform = $("#myform");
        var user = $("#user");
        var reciever = $("#reciever");
        var body = $("#body");

        myform.submit = function(e)
        {
            e.preventDefault(); //use ajax instead
            $.get("sendmessagestuff.php?user=" + user.val() + "&body=" + body.val() + "&reciever=" + reciever.val(),
            function(data)
            {
                alert("Message sent");
                //var result = JSON.parse(data);
            })
        }
    });
    </script>



</body>


</html>


<?php
//Function for encrypting with RSA
function rsa_encrypt($string, $public_key)
{
    //Create an instance of the RSA cypher and load the key into it
    $cipher = new Crypt_RSA();
    $cipher->loadKey($public_key);
    //Set the encryption mode
    $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    //Return the encrypted version
    return $cipher->encrypt($string);
}

//Function for decrypting with RSA
function rsa_decrypt($string, $private_key)
{
    //Create an instance of the RSA cypher and load the key into it
    $cipher = new Crypt_RSA();
    $cipher->loadKey($private_key);
    //Set the encryption mode
    $cipher->setEncryptionMode(CRYPT_RSA_ENCRYPTION_PKCS1);
    //Return the decrypted version
    return $cipher->decrypt($string);
}


$rsa = new Crypt_RSA();
$rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS1);
$rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);
extract($rsa->createKey(1024)); /// makes $publickey and $privatekey available
//$private_key = $privatekey;
//$public_key = $publickey;

$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");

while(!feof($userFile))
{
    //get whole line from userFile
    //$user = fgets($userFile); //THIS MUST BE JSON ENCODED (in signup.html)
    $userline = stream_get_line($userFile, NULL, "***\n");
    //decode the line from the users.txt file into an object so that we can get info
    //echo $user . "<br>";
    $obj = json_decode($userline);
    if($obj != null)
    {

        //get username and password
        $username = $obj->username;

        if((strcmp($username, $user) == 0))
        {
            $public_key = $obj->publickey;
            break;
        }
        else if((strcmp($username, $reciever) == 0))
        {
            $private_key = $obj->privatekey;
            break;
        }
    }
}
echo " private key is " . $private_key ." <BR>";
echo " public key is " . $public_key ." <BR>";

$ciphertext = rsa_encrypt($body, $public_key);
$decipheredtext = rsa_decrypt($ciphertext, $private_key);

echo "<br> encrypted text " . $ciphertext;
echo "<br> decrypted text " . $decipheredtext;

//$messagesFile = fopen("messages.txt", "r") or die("Unable to open messagesFile.txt");
$message = array('user' => $curUser, 'reciever' => $reciever, 'body' => $ciphertext);
$entry = json_encode($message) . "\n";
file_put_contents("messages.txt", $entry, FILE_APPEND);

?>
