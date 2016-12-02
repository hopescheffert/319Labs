<?php
session_start();
include("databaseconnection.php");

//for ajax request to see history
if(isset($_GET['history']))
{
    $name = $_GET["username"];
    viewBorrowHistory($name);
}

function viewBorrowHistory($username) //librarian only
{
    global $conn; //*NEEDS TO BE global
    $sql = "SELECT bookID, dueDate, returnedDate FROM loanHistory WHERE userName='" . $username ."'";
    $result = mysqli_query($conn, $sql);

    if(mysqli_num_rows($result) > 0)
    {
        // output data of each row
        echo "Borrow History for " . $username . ": ";
        while($row = mysqli_fetch_assoc($result))
        {
            echo "bookID: " . $row["bookID"]. " - Due Date: " . $row["dueDate"]. " - Returned Date: " . $row["returnedDate"] . "";
        }
    }
    else
    {
        echo "I'm sorry, we couldn't find any history";
    }
}



 ?>
