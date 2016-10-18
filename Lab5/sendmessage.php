<?php
session_start();
// sendmessage.php
// - Create a simple UI with a text file for Receiver part, User(fill with current username) and
// Body part, with submit button.
// -TODO  When User clicks on submit, the message should be encrypted by Receiver PublicKey
// and store information (contain Sender username, Receiver and body of message) in
// messages.txt file. Each item should contain the information as in this example
//User:Alice; Receiver: BOB; Body: dshgkfjsghfjksghjkf
//$jsonData = array('User'=> "Alice", 'Reciever'=> "Bob", 'Body'=> "dshgkfjsghfjksghjkf");

// - Make sure that you store the encrypted message in messages.txt file.

// TODO Each Message should contain at least a Sender, Receiver, and Body part
// Use only AJAX to get/create Message
$curUser = $_SESSION['username'];

echo "Reciever: <br><input type='text' id='reciever'</input> <br>";
echo "User: <br> <input type='text' id='user' value='".$curUser."' </input> <br>";
echo "Body:<br> <textarea rows='4' cols='50'>Type your message here </textarea> <br>";
echo "<input type='submit'</input>";
//TODO $post = {"User": xxxx, "Reciever":xxxx , "Body": xxxxx};

//script for submit button
echo "<script>";
echo "document.getElementById('submit').onclick=function(){";
echo "document.getElementById('reciever')";
//TODO onclick should encrypt the message with Reciever's public key and store
//user, reciever, body in messages.txt
echo "});";

echo "</script>";


 ?>
