<?php
session_start();
include("databaseconnection.php");
if(isset($_SESSION["username"]))
{
    $curUser = $_SESSION["username"];
    echo "<div style='float:right' >Welcome, " . $curUser. "</div><br>";
    echo "<div style='float:right'> <a href='logout.php'>Logout</a>". "</div><br>";
}
?>
<html>
<head>

</head>
<body>

    <input type="button" value="View Borrow History" onclick="<?php viewBorrowHistory($curUser); ?>" </input>

    <?php
    //Library.php
    function viewBorrowHistory($username) //librarian only
    {
        //TODO
        $sql = "SELECT bookID, dueDate, returnedDate FROM loanHistory WHERE userName='" . $username ."'";
        $result = mysqli_query($conn, $sql);

        if(mysqli_num_rows($result) > 0)
        {
            // output data of each row
            echo "Borrow History: \n";
            while($row = mysqli_fetch_assoc($result))
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
