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
<style>
.error {color: #FF0000;}
</style>
</head>
<body>

    <?php
    //Library.php

    $username = $password = $confirmPassword = $email = $phone = $firstName = $lastName = $err ="";
    $userType = false;
    if($_SERVER["REQUEST_METHOD"] == "POST")
    {
        if(empty($_POST["username"]))
        {
            $err = "This field is required";
        }
        else $username = test_input($_POST["username"]);
        $_SESSION["username"] = $username;

        if(empty($_POST["password"]))
        {
            $err = "This field is required";
        } else $password = test_input($_POST["password"]);
        if(empty($_POST["confirm"]))
        {
            $err = "This field is required";
        } else $confirmPassword = test_input($_POST["confirm"]);
        if(empty($_POST["email"]))
        {
            $err = "This field is required";
        } else $email = test_input($_POST["email"]);
        $phone = test_input($_POST["phone"]);
        if(empty($_POST["userType"]))
        {
            $err = "This field is required";
        } else $userType = test_input($_POST["userType"]);
        $_SESSION["userType"] = $userType;
        if(empty($_POST["firstName"]))
        {
            $err = "This field is required";
        } else $firstName = test_input($_POST["firstName"]);
        if(empty($_POST["lastName"]))
        {
            $err = "This field is required";
        } else $lastName = test_input($_POST["lastName"]);
    }

    function test_input($data) {
        $data = trim($data);
        $data = stripslashes($data);
        $data = htmlspecialchars($data);
        return $data;
    }

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
    <p><span class="error">* required field.</span></p>
    <form method="post" action="<?php echo htmlspecialchars($_SERVER["PHP_SELF"]);?>">
        Username: <input type="text" name="username" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        Password: <input type="password" name="password" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        Confirm Password: <input type="password" name="confirm" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        Email: <input type="email" name="email" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        Phone: <input type="text" name="phone">
        <br><br>
        Are you a librarian? <span class="error">* <?php echo $err;?></span> <br>
        <input type="radio" name="userType" value="true" checked required> Yes <br>
        <input type="radio" name="userType" value="false"> No
        <br><br>
        First Name: <input type="text" name="firstName" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        Last Name: <input type="text" name="lastName" required>
        <span class="error">* <?php echo $err;?></span>
        <br><br>
        <input type="submit" name="submit" value="Submit">
    </form>


</body>

</html>
