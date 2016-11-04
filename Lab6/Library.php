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
            for(var i = 0; i < result.length; i++)
            {
                if(result[i].sid == 0)
                {
                    for(var j = 0; j < 20; j++)
                    {
                        r = document.getElementById("row"+j);
                        c = document.getElementById("row"+j+"col"+0);
                        if(c.innerHTML == "")
                        {
                            break;
                        }
                    }
                    var row = document.getElementById("row" + j);
                    var cell = document.getElementById("row" + j + "col" + 0);
                    if(cell.innerHTML == "")
                    {
                        cell.innerHTML = result[i].bid;
                        cell.onclick = function()
                        {
                            $.get("Book.php?function=viewShelves&bookID=" + cell.innerHTML, function(data)
                            {
                                alert(data);

                            })
                        }
                    }

                }
                else if(result[i].sid == 1)
                {
                    for(var j = 0; j < 20; j++)
                    {
                        r = document.getElementById("row"+j);
                        c = document.getElementById("row"+j+"col"+1);
                        if(c.innerHTML == "")
                        {
                            break;
                        }
                    }
                    var row = document.getElementById("row" + j);
                    var cell = document.getElementById("row" + j + "col" + 1);
                    if(cell.innerHTML == "")
                    {
                        cell.innerHTML = result[i].bid;
                        cell.onclick = function()
                        {
                            $.get("Book.php?function=viewShelves&bookID=" + cell.innerHTML, function(data)
                            {
                                alert(data);

                            })
                        }
                    }

                }
                else if(result[i].sid == 2)
                {
                    for(var j = 0; j < 20; j++)
                    {
                        r = document.getElementById("row"+j);
                        c = document.getElementById("row"+j+"col"+2);
                        if(c.innerHTML == "")
                        {
                            break;
                        }
                    }
                    var row = document.getElementById("row" + j);
                    var cell = document.getElementById("row" + j + "col" + 2);
                    if(cell.innerHTML == "")
                    {
                        cell.innerHTML = result[i].bid;
                        cell.onclick = function()
                        {
                            $.get("Book.php?function=viewShelves&bookID=" + cell.innerHTML, function(data)
                            {
                                alert(data);

                            })
                        }
                    }

                }
                else if(result[i].sid == 3)
                {
                    for(var j = 0; j < 20; j++)
                    {
                        r = document.getElementById("row"+j);
                        c = document.getElementById("row"+j+"col"+3);
                        if(c.innerHTML == "")
                        {
                            break;
                        }
                    }
                    var row = document.getElementById("row" + j);
                    var cell = document.getElementById("row" + j + "col" + 3);
                    if(cell.innerHTML == "")
                    {
                        cell.innerHTML = result[i].bid;
                        cell.onclick = function()
                        {
                            $.get("Book.php?function=viewShelves&bookID=" + cell.innerHTML, function(data)
                            {
                                alert(data);

                            })
                        }
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
                console.log(bookShelf);
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
                                    cells[0].innerHTML = bookID;
                                    cells[0].id = "row" + i + "col" + 0;
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
                                    cells[1].innerHTML = bookID;
                                    cells[1].id = "row" + i + "col" + 1;
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
                                    cells[2].innerHTML = bookID;
                                    cells[2].id = "row" + i + "col" + 2;
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
                                    cells[3].innerHTML = bookID;
                                    cells[3].id = "row" + i + "col" + 3;
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
                return;
            }


        })

        //ajax request for delete book button onclick
        deleteBookButton.on("click", function()
        {
            bookID = prompt("Enter the book ID");
            bookShelf = prompt("Enter the book shelf");
            if(bookShelf == "literature") col = 0;
            else if(bookShelf == "science") col = 1;
            else if(bookShelf == "sports") col = 2;
            else if(bookShelf == "art") col = 3;

            $.get("Book.php?function=delete&bookID=" + bookID,
            function(data)
            {
                for(var i = 0; i < 20; i++)
                {
                    row = document.getElementById("row"+i);
                    cell = document.getElementById("row"+i+"col"+col)
                    if(cell.innerHTML == bookID)
                    {
                        cell.innerHTML = "";
                    }
                }
                // deleteThis = $('[name=' + bookID + ']');//document.getElementById(bookID);
                // console.log(deleteThis);
                // deleteThis.innerHTML = "";
            })
        })


        //ajax request for onclick view history button
        historyButton.on("click", function()
        {
            name = prompt("Enter username to view their history");
            $.get("borrowHistory.php?history=true&username=" + name,
            function(data)
            {
                alert(data);
            })
        })

    })
    </script>


</body>

</html>
