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

    <input type="button" id="viewHistory" value="View Borrow History"</input>
    <input type="button" id="addbook" value="Add Book"</input>
    <input type="button" id="deletebook" value="Delete Book"</input>



    <script>

    //TODO need the library to save books in the shelves
    $(document).ready(function()
    {

        //ajax request to display borrowed history
        var historyButton = $("#viewHistory");
        var addBookButton = $("#addbook");
        var deleteBookButton = $("#deletebook");
        var table = document.getElementById("lib");


        //init table - 20 emtpy rows
        for(var i = 0; i < 20; i++)
        {
            var row = table.insertRow(-1);
            row.id = "row" + i;
            for(var j = 0; j < 4; j++)
            {
                var cell = row.insertCell(-1);
                cell.id = "row" + i + "col" + j;
                cell.innerHTML = "";
            }
        }

        //get the books from the database to put into table
        $.get("LibraryOfBooks.php?getBooks=true", function(data)
        {
            //TODO get it from the database
            //data is a json_array of bookID's
            result = JSON.parse(data);
            //console.log("result array is " + result[0].bid);
            for(var i = 0; i < 20; i++) //for each row
            {
                console.log(result[i]);
                for(var j = 0; j < 4; j++) //for each column
                {
                    if(result[i] == undefined)
                    {
                        return;
                    }
                    else if(result[i].sid == undefined)
                    {
                        console.log("result is undefiend");
                        cell.innerHTML = "";
                    }
                    if(result[i].sid == 0)
                    {
                        console.log("literature");
                        //literature column
                        var row = $("#row" + i);
                        var cell = $("#row" + i + "col" + j);
                        cell.innerHTML = result[i].bid;
                    }
                    else if(result[i].sid == 1)
                    {
                        console.log("science");
                        //science column
                        var row = $("#row" + i);
                        var cell = $("#row" + i + "col" + j);
                        cell.innerHTML = result[i].bid;
                    }
                }
            }

        })

        //ajax request for add book button onclick
        addBookButton.on("click", function()
        {
            bookID = prompt("Enter the book ID");
            bookTitle = prompt("Enter the book Title");
            bookAuthor = prompt("Enter the book's author");
            bookShelf = prompt("Enter the book shelf");
            console.log(bookShelf);
            if(bookShelf == "literature" || bookShelf == "science" || bookShelf == "sports" || bookShelf == "art")
            {
                $.get("Book.php?function=add&bookID=" + bookID + "&bookTitle=" + bookTitle + "&bookAuthor=" + bookAuthor + "&bookShelf=" + bookShelf,
                function(data)
                {
                    //document.write(data);
                    //alert(data);
                    if(bookShelf == "literature")
                    {
                        var found = false;
                        for(var i = 1; i < 21; i++)
                        {
                            if(found) break;
                            {
                                var cells = table.rows[i].cells;
                                if(cells[0].innerHTML == "")
                                {
                                    cells[0].innerHTML = "ID: " + bookID;
                                    cells[0].id = bookID;
                                    cells[0].onclick = function()
                                    {
                                        $.get("Book.php?function=viewShelves&bookID=" + bookID, function()
                                        {
                                            document.write(data);
                                            //TODO : Use sql join between shelves and books and show information.

                                        })
                                        //alert("ID: " + bookID + "\nTitle: " + bookTitle + "\nAuthor: " + bookAuthor);
                                    }
                                    found = true;
                                    break;
                                }

                            }

                        }

                    }
                    else if(bookShelf == "science")
                    {
                        var found = false;
                        for(var i = 1; i < 21; i++)
                        {
                            if(found) break;
                            {
                                var cells = table.rows[i].cells;
                                if(cells[1].innerHTML == "")
                                {
                                    cells[1].innerHTML = "ID: " + bookID;
                                    cells[1].id = bookID;
                                    cells[1].onclick = function()
                                    {
                                        alert("ID: " + bookID + "\nTitle: " + bookTitle + "\nAuthor: " + bookAuthor);
                                    }
                                    found = true;
                                    break;
                                }
                            }

                        }
                    }
                    else if(bookShelf == "sports")
                    {

                        var found = false;
                        for(var i = 1; i < 21; i++)
                        {
                            if(found) break;
                            {
                                var cells = table.rows[i].cells;
                                if(cells[2].innerHTML == "")
                                {
                                    cells[2].innerHTML = "ID: " + bookID;
                                    cells[2].id = bookID;
                                    cells[2].onclick = function()
                                    {
                                        alert("ID: " + bookID + "\nTitle: " + bookTitle + "\nAuthor: " + bookAuthor);
                                    }
                                    found = true;
                                    break;
                                }
                            }

                        }
                    }
                    else if(bookShelf == "art")
                    {
                        var found = false;
                        for(var i = 1; i < 21; i++)
                        {
                            if(found) break;
                            {
                                var cells = table.rows[i].cells;
                                if(cells[3].innerHTML == "")
                                {
                                    cells[3].innerHTML = "ID: " + bookID;
                                    cells[3].id = bookID;
                                    cells[3].onclick = function()
                                    {
                                        alert("ID: " + bookID + "\nTitle: " + bookTitle + "\nAuthor: " + bookAuthor);
                                    }
                                    found = true;
                                    break;
                                }
                            }

                        }
                    }
                })
            }
            else
            {
                alert("invalid shelf");

            }


        })




        //ajax request for delete book button onclick
        deleteBookButton.on("click", function()
        {
            bookID = prompt("Enter the book ID");
            bookShelf = prompt("Enter the book shelf");

            $.get("Book.php?function=delete&bookID=" + bookID,
            function(data)
            {
                //document.write(data);
                //alert(data);
                //deleteThis = $("#"+ bookID);
                deleteThis = document.getElementById(bookID);
                console.log(deleteThis);
                deleteThis.innerHTML = "";
            })
        })


        //ajax request for onclick view history button
        historyButton.on("click", function()
        {
            name = prompt("Enter username to view their history");
            $.get("Library.php?history=true&username=" + name, function(data)
            {
                alert(data);
            })
        })

    })
    </script>

    <?php

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
            echo "<br>Borrow History for " . $username . ": <br>";
            while($row = mysqli_fetch_assoc($result))
            {
                echo "bookID: " . $row["bookID"]. " - Due Date: " . $row["dueDate"]. " - Returned Date: " . $row["returnedDate"]. "<br>";
            }
        }
        else
        {
            echo "I'm sorry, we couldn't find any history";
        }
    }



    ?>


</body>

</html>
