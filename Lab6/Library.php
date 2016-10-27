<?php
session_start();
include("databaseconnection.php");
echo strlen("1234") != 4;
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
    $usernameE = $passwordE = $confirmPE = $emailE = $phoneE = $userTypeE = $firstE = $lastE = "";
    $userType = false;
    if($_SERVER["REQUEST_METHOD"] == "POST")
    {
        if(empty($_POST["username"]))
        {
            $usernameE = "This field is required";
        }
        else
        {
            $username = test_input($_POST["username"]);
            //check for alpha NUMERIC
            if(!ctype_alnum($username))
            {
                $usernameE = "Must be alphanumeric";
            }
            else
            {
                $_SESSION["username"] = $username;
            }
        }

        if(empty($_POST["password"]))
        {
            $passwordE = "This field is required";
        }
        else
        {
            $password = test_input($_POST["password"]);
        }


        if(empty($_POST["confirm"]))
        {
            $confirmPE = "This field is required";
        }
        else
        {
            $confirmPassword = test_input($_POST["confirm"]);
        }


        if(empty($_POST["email"]))
        {
            $emailE = "This field is required";
        }
        else
        {
            $email = test_input($_POST["email"]);
            if (!filter_var($email, FILTER_VALIDATE_EMAIL)) //TODO everything but @ and . alphanumeric && !ctype_alnum($email))
            {
                $emailE = "Invalid email format";
            }

        }

        if(!empty($_POST["phone"]))
        {
            $phone = test_input($_POST["phone"]);
            if(strlen($phone) != 10 || !is_numeric($phone))
            {
                $phoneE = "Invalid phone number";
            }
        }

        if(empty($_POST["userType"]))
        {
            $userTypeE = "This field is required";
        }
        else
        {
            $userType = test_input($_POST["userType"]);
            $_SESSION["userType"] = $userType;
        }


        if(empty($_POST["firstName"]))
        {
            $firstE = "This field is required";
        }
        else
        {
            $firstName = test_input($_POST["firstName"]);

            if(!ctype_alpha($firstName))
            {
                $firstE = "Must be alphabetical";
            }

        }

        if(empty($_POST["lastName"]))
        {
            $lastE = "This field is required";
        }
        else
        {
            $lastName = test_input($_POST["lastName"]);
            if(!ctype_alpha($firstName))
            {
                $lastE = "Must be alphabetical";
            }
        }
    }

    function test_input($data)
    {
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
        Username: <input type="text" name="username" value="<?php echo $username;?>" required>
        <span class="error">* <?php echo $usernameE;?></span>
        <br><br>
        Password: <input type="password" name="password" value="<?php echo $password;?>" required>
        <span class="error">* <?php echo $passwordE;?></span>
        <br><br>
        Confirm Password: <input type="password" name="confirm" value="<?php echo $confirmPassword;?>" required>
        <span class="error">* <?php echo $confirmPE;?></span>
        <br><br>
        Email: <input type="email" name="email" value="<?php echo $email;?>" required>
        <span class="error">* <?php echo $emailE;?></span>
        <br><br>
        Phone: <input type="text" name="phone" value="<?php echo $phone;?>">
        <span class="error">* <?php echo $phoneE;?></span>
        <br><br>

        Are you a librarian? <span class="error">* <?php echo $userTypeE;?></span> <br>
        <input type="radio" name="userType"
        <?php if (isset($userType) && $userType==true) echo "checked";?> value="true" checked required> Yes <br>
        <input type="radio" name="userType"
        <?php if (isset($userType) && $userType==false) echo "checked";?>value="false"> No
        <br><br>


        First Name: <input type="text" name="firstName" value="<?php echo $firstName;?>"required>
        <span class="error">* <?php echo $firstE;?></span>
        <br><br>
        Last Name: <input type="text" name="lastName" value="<?php echo $lastName;?>"required>
        <span class="error">* <?php echo $lastE;?></span>
        <br><br>
        <input type="submit" name="submit" value="Submit">
    </form>


</body>

</html>
