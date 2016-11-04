<?php
//LibraryOfBooks.php
session_start();
require("databaseconnection.php");

if((isset($_GET['getBooks'])))
{
    //echo "in get book<BR>";
    global $conn;
    $sql = "SELECT bookID, shelfID FROM shelfBooks";
    $result = mysqli_query($conn, $sql);
    $ret = array();
    if(mysqli_num_rows($result))
    {
        while($row = mysqli_fetch_assoc($result))
        {
            //$books = array('bid' => $row['bookID'], 'sid' => $row['shelfID']);
            $books['bid'] = $row['bookID'];
            $books['sid'] = $row['shelfID'];

            array_push($ret, $books);
        }
        echo json_encode($ret);
    }
    else
    {
        echo "No books in the database";
    }
}



?>
