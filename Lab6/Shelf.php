<?php
//Shelf.php
session_start();
include("databaseconnection.php");




function addBook($bookID, $bookTitle, $author) //librarian only
{
    //TODO

    //adds to a shelf in the library that is not full
    //Assume shelves have capacity of 20 books and that there are 4 shelves
    //which names by “Art”, “Science”, “Sport” and “Literature”.
}

function librarianViewAllShelves() //librarian only
{
    //TODO

    //by clicking on the book, the details of that book should be show on the same page.
    //Hint : Use sql join between shelves and books and show information.
}
function studentViewAllShelves() //student only
{
    //TODO

    //by clicking on the book id of a book, the details of that book should be show on the same page.
    //Hint : Use sql join between shelves and books
}


?>
