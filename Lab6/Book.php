<?php
//Book.php
session_start();
include("databaseconnection.php");

if(($_GET['function']) == 'add')
{
    //adding book
    echo "adding<br>";
    $bookID = $_GET["bookID"];
    $bookTitle = $_GET["bookTitle"];
    $bookAuthor = $_GET["bookAuthor"];
    $bookShelf = $_GET["bookShelf"];
    $bookObj = new Book($bookID);//, $bookTitle, $bookAuthor, $bookShelf);
    $bookObj->addBook($bookID, $bookTitle, $bookAuthor, $bookShelf);

}
else if(($_GET['function']) == 'delete')
{
    echo "deleting<br>";
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);//, $bookTitle, $bookAuthor, $bookShelf);
    $bookObj->deleteBook($bookID);

}
else if(($_GET['function']) == 'viewShelves')
{
    echo "viewing shelves<BR>";
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);//, $bookTitle, $bookAuthor, $bookShelf);
    $bookObj->viewShelves($bookID);
}


// $bookObj = new Book($bookID)//, $bookTitle, $bookAuthor, $bookShelf);
// $bookObj->addBook($bookID, $bookTitle, $bookAuthor, $bookShelf);
// $bookObj->deleteBook($bookID);
// $bookObj->viewShelves($bookID);

class Book
{

    public function __construct($bookID)//, $bookTitle, $bookAuthor, $bookShelf)
    {
        $this->$bookID = $bookID;
        // $this->$bookTitle = $bookTitle;
        // $this->$bookAuthor = $bookAuthor;
        // $this->$bookShelf = $bookShelf;
    }

    public function addBook($bookID, $bookTitle, $bookAuthor, $bookShelf) //librarian only
    {
        global $conn;

        //adds to a shelf in the library that is not full
        //Assume shelves have capacity of 20 books and that there are 4 shelves
        //which names by “Art”, “Science”, “Sport” and “Literature”
        if(strcmp($bookShelf, "literature") == 0)
        {
            $shelfID = 0;
        }
        else if(strcmp($bookShelf, "science") == 0)
        {
            $shelfID = 1;
        }
        else if(strcmp($bookShelf, "sports") == 0)
        {
            $shelfID = 2;
        }
        else if(strcmp($bookShelf, "art") == 0)
        {
            $shelfID = 3;
        }

        //assume availability is 1 (present)
        //add book to books table
        $sql1 = "INSERT INTO books (bookID, bookTitle, author, availability) VALUES ('" . $bookID . "', '" . $bookTitle . "', '" . $bookAuthor . "', '1');";
        //also add to shelves table

        $sql1 .= "INSERT INTO shelfBooks (shelfID, bookID) VALUES ('" .$shelfID . "', '" . $bookID . "');";
        $sql1 .= "INSERT INTO shelves (shelfID, shelfName) VALUES ('" .$shelfID . "', '" . $bookShelf . "')";
        if(mysqli_multi_query($conn, $sql1) === FALSE)
        {
            echo "Error: " . $sql1 . "<br>" . mysqli_error($conn);
        }
        else
        {
            while(mysqli_next_result($conn))
            {
                if(mysqli_more_results($conn))
                {
                    printf("________");
                }
            }
        }
        echo "done adding<BR>";
    }

    public function deleteBook($bookID) //librarian only
    {
        //TODO check
        global $conn;

        $sql = "DELETE FROM books WHERE bookID='" . $bookID . "'";
        if(mysqli_query($conn, $sql) === FALSE)
        {
            echo "Error deleting record: " . mysqli_error($conn);
        }
        //removes the book from the library
        //Hint : sql delete from book table in DATABASE.
    }

    public function viewShelves($bookID)
    {
        //TODO Use sql join between shelves and books and show information.
        global $conn;
        $sql = "SELECT books.bookID, books.bookTitle, books.author, books.availability, shelves.shelfID, shelves.shelfName FROM books INNER JOIN shelves ON books.bookID=shelves.bookID";
        $result = mysqli_query($conn, $sql);
        if(mysqli_num_rows($result) > 0)
        {
            // output data of each row
            while($row = mysqli_fetch_assoc($result))
            {
                echo "Book ID: " . $row["bookID"]. " - Title: " . $row["bookTitle"]. " - Author: " . $row["author"]. " - Availability: " . $row["availability"]. " - Shelf ID: " . $row["shelfID"] . " - Shelf Name: ". $row["shelfName"] . "<br>";
            }
        }
        else
        {
            echo "<BR>ERROR in viewShelves<BR>";
        }
    }

    function borrowBook($bookID) //student only
    {
        //TODO check that it works
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
        //TODO check that it works
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
