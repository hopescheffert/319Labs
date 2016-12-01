<?php
//Book.php
session_start();
include("databaseconnection.php");
if(isset($_SESSION["username"]))
{
    $userName = $_SESSION["username"];
}

if(($_GET['function']) == 'add')
{
    //adding book
    $bookID = $_GET["bookID"];
    $bookTitle = $_GET["bookTitle"];
    $bookAuthor = $_GET["bookAuthor"];
    $bookShelf = $_GET["bookShelf"];
    $bookObj = new Book($bookID);
    $bookObj->addBook($bookID, $bookTitle, $bookAuthor, $bookShelf);

}
else if(($_GET['function']) == 'delete')
{
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);
    $bookObj->deleteBook($bookID);

}
else if(($_GET['function']) == 'viewShelves')
{
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);
    $bookObj->viewShelves($bookID);
}
else if(($_GET['function']) == 'borrow')
{
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);
    $bookObj->borrowBook($bookID, $userName);
}
else if(($_GET['function']) == 'return')
{
    $bookID = $_GET["bookID"];
    $bookObj = new Book($bookID);
    $bookObj->returnBook($bookID);
}



class Book
{

    public function __construct($bookID)
    {
        $this->$bookID = $bookID;
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
        global $conn;

        $sql1 = "DELETE FROM books WHERE bookID='" . $bookID . "';";
        $sql1 .= "DELETE FROM shelfBooks WHERE bookID='" . $bookID . "'";
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
        echo "done deleting<BR>";
        //removes the book from the library
        //Hint : sql delete from book table in DATABASE.
    }

    public function viewShelves($bookID)
    {
        global $conn;
        $sql = "SELECT books.bookID, books.bookTitle, books.author, books.availability, shelfBooks.shelfID FROM books INNER JOIN shelfBooks ON books.bookID=shelfBooks.bookID";
        $result = mysqli_query($conn, $sql);
        if(mysqli_num_rows($result) > 0)
        {
            // output data of each row
            while($row = mysqli_fetch_assoc($result))
            {
                echo "Book ID: " . $row["bookID"]. " - Title: " . $row["bookTitle"]. " - Author: " . $row["author"]. " - Availability: " . $row["availability"]. " - Shelf ID: " . $row["shelfID"] . "\n";
            }
        }
        else
        {
            echo "ERROR in viewShelves\n";
        }
    }

    function borrowBook($bookID, $userName) //student only
    {
        global $conn;

        $sql2 = "SELECT availability FROM books WHERE bookID= '" . $bookID . "'";
        $result = mysqli_query($conn, $sql2);
        $row = mysqli_fetch_assoc($result);
        if($row["availability"] == 0)
        {
            //echo "can not borrow this book, it is already checked out \n";
            echo "false";
        }
        else
        {
            //echo "true";
            //echo "book can be borrowed! \n";
            $date = date("m/d/y");
            $sql = "UPDATE books SET availability = '0' WHERE bookID='" . $bookID . "';";
            $sql .= "INSERT INTO loanHistory(userName, bookID, dueDate) VALUES('" .$userName . "', '" . $bookID . "', '" . $date . "')";
            if(mysqli_multi_query($conn, $sql) === FALSE)
            {
                echo "Error: " . $sql . "<br>" . mysqli_error($conn);
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
        }
        //should be able to take a book on loan if it is available.
        //Hint : Use sql update_books table.
    }

    function returnBook($bookID) //student only
    {
        global $conn;
        $date = date("m/d/y");
        $sql2 = "SELECT availability FROM books WHERE bookID= '" . $bookID . "'";
        $sql2 .= "UPDATE loanHistory SET dueDate = '". $date . "' WHERE bookID='" .$bookID."'";
        $result = mysqli_query($conn, $sql2);
        $availability = mysqli_fetch_assoc($result);
        if($availability == 1)
        {
            echo "can not return this book, it is already returned \n";
        }
        else
        {
            $sql = "UPDATE books SET availability = '1' WHERE bookID='" . $bookID . "'";
            if(mysqli_query($conn, $sql) === FALSE)
            {
                echo "Error updating record: " . mysqli_error($conn);
            }
            else
            {
                echo "true";
            }
        }
        //return the book and make the book available.
        //Hint : Use sql update_books table.
    }



}


?>
