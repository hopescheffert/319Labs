<?php
session_start();
// inInbox.php
// - use file_get_contents to get json data from messages.txt.
// - Next, convert json to php object (json_decode/json_encode)
// - loop thru object:
//     If the To part is related to the current username create html rows with after decrypting the body of the message.

$messages = file_get_contents("/Applications/XAMPP/htdocs/Lab5/messages.txt");
$messageData = explode("\n", $messages);


for($i = 0; $i < count($messageData); $i++)
{
    if(json_decode($messageData[$i]) != null)
    {
      $messageObject[$i] = json_decode($messageData[$i]);
        //TODO decrypt the body of the message
        //TODO create html rows?
    }
    else break;
}

echo json_encode($messageObject, true);

 ?>
