<!-- inInbox.php
- use file_get_contents to get json data from messages.txt.
- Next, convert json to php object (json_decode/json_encode)
- loop thru object:
    If the To part is related to the current username create html rows with after decrypting the body of the message. -->


<?php
//$jsonData = file_get_contents("messages.txt");
//example:
$jsonData = array('User'=> "Alice", 'Reciever'=> "Bob", 'Body'=> "some text here");
$jsonObj = json_encode($jsonData);
$phpObject = json_decode($jsonObj);

// echo "json object " . $jsonObj;
// echo "php object ";
// print_r($phpObject);

//loop through object
//TODO If the To part is related to the current username create html rows with after decrypting the body of the message

echo $phpObject{'Reciver'}

for($i = 0; $i < count($phpObject); $i++)
{
    if(strcmp($phpObject{'Reciever'}, $username) == 0)
    {
        //TODO decrypt the body of the message
        //TODO create html rows
    }
}


 ?>
