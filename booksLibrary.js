//booksLibrary.js

//three classes: Library, Shelf, and Book

//library constructor
function Library()
{
    //types of books: 5 reference, 20 ordinary
    //reference books cannot be checked out
    this.userType = "undergrad"; //initialize as undergrad
    this.artShelf = new Shelf("art");
    this.sportsShelf = new Shelf("sports");
    this.scienceShelf = new Shelf("science");
    console.log("science shelf " + this.scienceShelf.booksOnShelf);
    this.literatureShelf = new Shelf("literature");
    this.allBooks = [new Book(1, "ordinary", this), new Book(2, "ordinary", this), new Book(3, "reference", this), new Book(4, "ordinary", this)]; //put some books in for testing
    //construct new shelves that start empty

}

//called to log in and show the library table in the html page
Library.prototype.logIn = function(username, password)
{
    console.log("in log in")
    var username = username.value;
    var password = password.value;

    if(username == "admin" && password == "admin")
    {
        //log in as a librarian
        //var lib = new Library("librarian");
        Library.userType = "librarian";
        console.log("lib is " + lib.allBooks);

    }
    else if(username.startsWith("u",0))
    {
        //log in as an undergrad student
        var lib = new Library();
        Library.userType = "undergrad";
        console.log("library consists of " + lib.allBooks);
        console.log("user type is now " + lib.userType);

    }

    //display library as table in html
    //do we need to pass the library to this function?
    //document.getElementById("myLibrary").innerHTML = Library.prototype.displayLibrary(lib);

}

Library.prototype.createLoginPage = function()
{
    var s = "<form>";
    s += "Username <br><input id='username' type='text' name='username'>";
    s += "<br>";
    s += "Password <br><input id='password' type='password' name='password'>";
    s += "<br>";
    s += "<input id='login' type='button' value='Log In' onclick='Library.prototype.logIn(username, password)'>";
    s += "</form>";

    return s;
}
//TODO display the library as a table
Library.prototype.displayLibrary = function(lib)
{
    //insertRow()? http://www.w3schools.com/jsref/met_table_insertrow.asp
    //each column is a Shelf
    //each cell is a book (insertCell()?) http://www.w3schools.com/jsref/met_tablerow_insertcell.asp
    var s;
    s = "<table id=\"myTable\" border='1px solid black'>";
    s += "<tr><td>";

    console.log("books on shelf are " + artShelf.booksOnShelf);
    console.log("books in library are " + lib.allBooks);
    //not right but something like this?
    // for(var i = 0; i < Libary.literatureShelf.booksOnShelf.length; i++)
    // {
    //     s += Library.prototype.displayBook(Library.literatureShelf.booksOnShelf[i]);
    // }
    // s += Library.scienceShelf.booksOnShelf;
    // s += Library.sportsShelf.booksOnShelf;
    // s += Library.artShelf.booksOnShelf;


    // for(var i = 0; i < lib.allBooks.length; i ++)
    // {
    //     for(var j = 0; j < Shelf.booksOnShelf.length; j++)
    //     {
    //         s += Library.prototype.displayBook(Shelf.booksOnShelf[i]);
    //         s += "</td><td>";
    //     }
    //
    // }
    s += "</td></tr>";
    s += "</table>";
    return s;
}
//display a book for inside the library table
Library.prototype.displayBook = function(bookObj)
{
    var s = "<input ";
    s += " id=\"" + bookObj.id + "\"";
    s += " type='text'";
    s += " value= \"" + bookObj.id + "\"";
    s += " onclick= \"" + bookObj.onclick + "\"";
    s += ">";
    return s;
}


//book constructor
function Book(bookid, bookType, library)
{
    this.id = bookid;
    this.type = bookType; //5 reference, 20 ordinary in this library
    //TODO note that reference books cannot be checked out
    this.putOnShelf(this, library); //assign art, science, sport, or literature
    //this.borrowedBy = undefined; //at first borrowedBy none of the students
    //USE LOCAL STORAGE in order to save presence and borrowedBy attribute for each book
    this.borrowedBy = localStorage.setItem("borrowedBy", "nobody"); //borrowedBy is the username of student who borrowed book
    //presence(1) or borrowed(0) situation of book
    this.presence = localStorage.setItem("presence", 1); //all books start with presence (1)
}

//add the book to the correct shelf based on category
//sets category attribute for Book object
Book.prototype.putOnShelf = function(book, library)
{
    if(book.id % 4 == 0)
    {
        book.category = "art";
        library.artShelf.booksOnShelf.push(book);
    }
    else if(book.id % 4 == 1)
    {
        book.category = "science";
        //TODO Library.scienceShelf is undefined! Why can't we grab this instance of library...
        console.log("scienceShelf "+ Library.scienceShelf);
        library.scienceShelf.booksOnShelf.push(book);

    }
    else if(book.id % 4 == 2)
    {
        book.category = "sport";
        library.sportsShelf.booksOnShelf.push(book);

    }
    else if(book.id % 4 == 3)
    {
        book.category = "literature";
        library.literatureShelf.booksOnShelf.push(book);

    }
    //console.log("categorized book as " + book.category);
}

//shelf constructor
function Shelf(category)
{
    this.category = category; //represents the shelf category
    this.booksOnShelf = []; //represents all the books on this shelf
    //**different shelf for each category : art, science, sport, literature
}
