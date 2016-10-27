<?php
session_start();
include("databaseconnection.php");
if(isset($_SESSION["username"]))
{
    echo "<div style='float:right' >Welcome, " . $_SESSION["username"]. "</div><br>";
    echo "<div style='float:right'> <a href='logout.php'>Logout</a>". "</div><br>";
}
?>
<html>
<head>

</head>
<body>

    <?php
    //Library.php

    function viewBorrowHistory($username) //librarian only
    {
        //TODO
        $sql = "SELECT bookID, dueDate, returnedDate FROM loanHistory WHERE usernName=" . $username;
        if ($result->num_rows > 0)
        {
            // output data of each row
            while($row = $result->fetch_assoc())
            {
                echo "bookID: " . $row["bookID"]. " - Due Date: " . $row["dueDate"]. " - Returned Date: " . $row["returnedDate"]. "<br>";
            }
        }
        else
        {
            echo "0 results";
        }
        //Hint: sql select from loanhistory table in DATABASE.
    }

    ?>


</body>

</html>
