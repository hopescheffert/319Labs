<?php
//Book.php
session_start();
include("databaseconnection.php");
global $conn;

$bookID = $_GET["bookID"];
$bookTitle = $_GET["bookTitle"];
$bookAuthor = $_GET["bookAuthor"];
$bookShelf = $_GET["bookShelf"];

//TODO cannot call addBook() ?





class Book
{
    public function __construct($bookID, $bookTitle, $bookAuthor, $bookShelf)
    {
        $this->$bookID = $bookID;
        $this->$bookTitle = $bookTitle;
        $this->$bookAuthor = $bookAuthor;
        $this->$bookShelf = $bookShelf;
    }

    public function addBook($bookID, $bookTitle, $bookAuthor, $bookShelf) //librarian only
    {
        //adds to a shelf in the library that is not full
        //Assume shelves have capacity of 20 books and that there are 4 shelves
        //which names by “Art”, “Science”, “Sport” and “Literature”

        if(strcmp($bookShelf, "literature"))
        {
            $shelfID = 0;
        }
        else if(strcmp($bookShelf, "science"))
        {
            $shelfID = 1;
        }
        else if(strcmp($bookShelf, "sports"))
        {
            $shelfID = 2;
        }
        else if(strcmp($bookShelf, "art"))
        {
            $shelfID = 3;
        }
        else
        {
            echo "Invalid shelf";
            return;
        }

        //assume availability is 1 (present)
        //add book to books table
        $sql1 = "INSERT INTO books (bookID, bookTitle, author, availability) VALUES (" . $bookID . ", " . $bookTitle . ", " . $author . ", 1)";
        //also add to shelves table
        $sql2 = "INSERT INTO shelves (shelfID, shelfName, bookID) VALUES (" .$shelfID . ", " . $bookShelf . ", " . $bookID . ", 1)";
        if(mysqli_query($conn, $sql1) === FALSE)
        {
            echo "Error: " . $sql1 . "<br>" . mysqli_error($conn);
        }
        else if(mysqli_query($conn, $sql2) === FALSE)
        {
            echo "Error: " . $sql2 . "<br>" . mysqli_error($conn);
        }

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
$bookObj = new Book;
$bookObj->addBook($bookID, $bookTitle, $bookAuthor, $bookShelf);






?>
