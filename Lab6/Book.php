<?php
//Book.php
session_start();
include("databaseconnection.php");


class Book
{
    function __construct($bookID, $bookTitle, $author, $availability)
    {
        //TODO?
    }

    function addBook($bookID, $bookTitle, $author) //librarian only
    {
        //TODO adds only to shelf that is not full
        //assume availability is 1 (present)
        $sql = "INSERT INTO books (bookID, bookTitle, author, availability) VALUES (" .
        $bookID . ", " . $bookTitle . ", " . $author . ", 1)";
        if(mysqli_query($conn, $sql) === FALSE)
        {
            echo "Error: " . $sql . "<br>" . mysqli_error($conn);
        }
        //adds to a shelf in the library that is not full
        //Assume shelves have capacity of 20 books and that there are 4 shelves
        //which names by “Art”, “Science”, “Sport” and “Literature”.
    }

    function deleteBook($bookID) //librarian only
    {
        //TODO check
        $sql = "DELETE FROM books WHERE bookID='" . $bookID . "'";
        if(mysqli_query($conn, $sql) === FALSE)
        {
            echo "Error deleting record: " . mysqli_error($conn);
        }
        //removes the book from the library
        //Hint : sql delete from book table in DATABASE.
    }

    function borrowBook($bookID) //student only
    {
        //TODO check
        $sql = "UPDATE books SET availability = '0' WHERE bookID='" . $bookID . "'";
        if(mysqli_query($conn, $sql) === FALSE)
        {
            echo "Error updating record: " . mysqli_error($conn);
        }
        //should be able to take a book on loan if it is available.
        //Hint : Use sql update _books table.
    }

    function returnBook($bookID) //student only
    {
        //TODO check
        $sql = "UPDATE books SET availability = '1' WHERE bookID='" . $bookID . "'";
        if(mysqli_query($conn, $sql) === FALSE)
        {
            echo "Error updating record: " . mysqli_error($conn);
        }
        //return the book and make the book available.
        //Hint : Use sql update_books table.
    }


}


?>
