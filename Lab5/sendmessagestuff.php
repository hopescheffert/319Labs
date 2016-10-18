<?php
session_start();
$path = 'phpseclib';
set_include_path(get_include_path() . PATH_SEPARATOR . $path);
include_once('Crypt/RSA.php');
$curUser = $_SESSION['username'];
$curPass = $_SESSION['password'];

?>
<html>

<body>
    <!-- sendmessage.php -->

    <form id='myForm'>
        Reciever: <br><input type='text' id='reciever'</input> <br>
        User: <br> <input type='text' id='user' value="<?php echo $curUser ?>" </input> <br>
        Body:<br> <textarea rows='4' id='body' cols='50'>Type your message here </textarea> <br>
        <input id='submit' type='submit'</input>
    </form>


    <script>

    var reciever = document.getElementById('reciever').value;
    var user = document.getElementById('user').value;
    var body = document.getElementById('body').value;
    var submitbutton = document.getElementById('submit');

    submitbutton.onsubmit = function()
    {
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
        $private_key = $privatekey;
        $public_key = $publickey;

        $body = "some text here";
        $ciphertext = rsa_encrypt($body, $public_key);
        $decipheredtext = rsa_decrypt($ciphertext, $private_key);

        //echo sprintf("<h4>Plaintext for RSA encryption:</h4><p>%s</p><h4>After encryption:</h4><p>%s</p><h4>After decryption:</h4><p>%s</p>", $body, $ciphertext, $decipheredtext);
        echo $body;
        echo "<br>" . $ciphertext;
        echo "<br>" . $decipheredtext;
        ?>
    }


    </script>


</body>


</html>
