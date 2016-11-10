<?php
session_start();
$path = '/Applications/XAMPP/xamppfiles/htdocs/lab5/phpseclib';
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

        myform.submit(function(e)
        {
            console.log("hello");
            e.preventDefault(); //use ajax instead
            console.log(user.val());
            $.get("sendmessage.php?user=" + user.val() + "&body=" + body.val() + "&reciever=" + reciever.val(),
            function(data)
            {
                alert("Message sent");
            })
        });
    })
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
    return base64_encode($cipher->encrypt($string));
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
    return $cipher->decrypt(base64_decode($string));
    //return base64_decode($cipher->encrypt($string));

}


// $rsa = new Crypt_RSA();
// $rsa->setPrivateKeyFormat(CRYPT_RSA_PRIVATE_FORMAT_PKCS1);
// $rsa->setPublicKeyFormat(CRYPT_RSA_PUBLIC_FORMAT_PKCS1);
// extract($rsa->createKey(1024)); /// makes $publickey and $privatekey available


$userFile = fopen("users.txt", "r") or die("Unable to open users.txt");
$foundpublickey = 0;
$foundprivatekey = 0;

while(!feof($userFile) && ($foundpublickey == 0 || $foundprivatekey == 0))
{
    //get whole line from userFile
    $userline = stream_get_line($userFile, NULL, "***\n");
    //decode the line from the users.txt file into an object so that we can get info
    $obj = json_decode($userline);
    if($obj != null)
    {
        $username = $obj->username;

        if((strcmp($username, $reciever) == 0))
        {
            $private_key = $obj->privatekey;
            $foundprivatekey = 1;
        }
        else if((strcmp($username, $user) == 0))
        {
            $public_key = $obj->publickey;
            $foundpublickey = 1;
        }

    }
}

// echo " private key is " . $private_key ." <BR>";
// echo " public key is " . $public_key ." <BR>";

$ciphertext = rsa_encrypt($body, $public_key);
$decipheredtext = rsa_decrypt($ciphertext, $private_key);

// echo "<br> encrypted text " . $ciphertext;
// echo "<br> decrypted text " . $decipheredtext;
$messageFile = "/Applications/XAMPP/xamppfiles/htdocs/lab5/posts.txt";
$message = array('user' => $curUser, 'reciever' => $reciever, 'body' => $ciphertext);
$entry = json_encode($message) . "\n";
file_put_contents("$messageFile, $entry, FILE_APPEND);

?>
