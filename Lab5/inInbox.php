<!-- inInbox.php
- use file_get_contents to get json data from messages.txt.
- Next, convert json to php object (json_decode/json_encode)
- loop thru object:
    If the To part is related to the current username create html rows with after decrypting the body of the message. -->


<?php
//$jsonData = file_get_contents("messages.txt");
//example User:Alice; Receiver: BOB; Body: dshgkfjsghfjksghjkf

$jsonData = array('User'=> "Alice", 'Reciever'=> "Bob", 'Body'=> "some text here");
$jsonObj = json_encode($jsonData);
$phpObject = json_decode($jsonObj);

// echo "json object " . $jsonObj;
// echo "php object ";
// print_r($phpObject);

//loop through object
//If the To part is related to the current username create html rows with after decrypting the body of the message




 ?>
