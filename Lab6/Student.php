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

  <input type="button" id="borrowBook" value="Borrow Book"</input>
  <input type="button" id="returnBook" value="Return Book"</input>



  <script>
  //TODO need the library to save books in the shelves
  $(document).ready(function()
  {
    var borrowBookButton = $("#borrowBook");
    var returnBookButton = $("#returnBook");
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

    borrowBookButton.on("click", function()
    {
      bookID = prompt("Enter the book ID of the book you would like to borrow");
      $.get("Book.php?function=borrow&bookID=" + bookID)
    })

    returnBookButton.on("click", function()
    {
      bookID = prompt("Enter the book ID of the book you would like to return");
      $.get("Book.php?function=return&bookID=" + bookID)
    })
  })




  </script>

</body>

</html>
