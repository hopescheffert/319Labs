<?php
session_start();
//Library.php
require("databaseconnection.php");
if(isset($_SESSION["username"]))
{
    $curUser = $_SESSION["username"];
    echo "<div style='float:right' >Welcome, " . $curUser. "</div><br>";
    echo "<div style='float:right'> <a href='logout.php'>Logout</a>". "</div><br>";
}
?>
<html>
<head>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

</head>
<body>
    <div id="myLibrary">
        <table id="lib" border='1px solid black'>
            <th style='background-color:green'>Literature Shelf</th>
            <th style='background-color:green'>Science Shelf</th>
            <th style='background-color:green'>Sports Shelf</th>
            <th style='background-color:green'>Art Shelf</th>
        </table>
    </div>

    <!-- <input type="button" id="borrowBook" value="Borrow Book"</input>
    <input type="button" id="returnBook" value="Return Book"</input> -->



    <script>
    //TODO need the library to save books in the shelves
    $(document).ready(function()
    {

        //ajax request to display borrowed history
        // var borrowBookButton = $("#borrowBook");
        // var returnBookButton = $("#returnBook");
        var table = document.getElementById("lib");

        //init table - 20 empty rows
        for(var i = 0; i < 20; i++)
        {
            var row = table.insertRow(-1);
            row.id = "row" + i;
            for(var j = 0; j < 4; j++)
            {
                var cell = row.insertCell(-1);
                cell.id = "row" + i + "col" + j;
                $.get("Student.php?getBook", function()
                {
                    //TODO get it from the database
                    cell.innerHTML = data;
                })
            }

        }
      })

      // clickAction.on("click", function()
      // {
      //
      //
      // })


    </script>

    <?php

    function borrowBook()
    {

    }

    function returnBook()
    {

    }

    function getBook()
    {
        global $conn;

    }


    ?>


</body>

</html>
