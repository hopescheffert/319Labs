//booksLibrary.js

//three classes: Library, Shelf, and Book

//library constructor
function Library(username, password)
{
    //types of books: 5 reference, 20 ordinary
    //reference books cannot be checked out
    this.username = username;
    this.password = password;
    this.userType = "undergrad";
    this.allBooks = [];
}
Library.prototype.logIn = function(username, password)
{
    Library.username = username.value;
    Library.password = password.value;
    //var newLib = new Library(username, password);
    console.log("username is " + Library.username + " and password is " + Library.password);

    if(Library.username == "admin" && Library.password == "admin")
    {
        //log in as a librarian
        Library.userType = "librarian";
    }
    else if(Library.username.startsWith("U",0))
    {
        //log in as an undergrad student
        Library.userType = "undergrad";
    }
    console.log("user type is now " + Library.userType);

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
Library.prototype.displayLibrary = function()
{
    //insertRow()? http://www.w3schools.com/jsref/met_table_insertrow.asp
    var s;
    s = "<table id=\"myTable\" border=2>"
    s += "<tr><td>";
    for(var i = 0; i < Library.allBooks.length; i ++)
    {
        for(var j = 0; j < Shelf.booksOnShelf.length; j++)
        {
            s += Library.prototype.displayBook(Shelf.booksOnShelf[i]);
            s += "</td><td>";
        }

    }
    s += "</td></tr>";
    s += "</table>";
    return s;
}
//TODO display a book for inside the library table
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
function Book(bookid, bookType)
{
    this.id = bookid;
    this.type = bookType; //5 reference, 20 ordinary in this library
    //TODO note that reference books cannot be checked out
    this.categorizeBook(); //assign art, science, sport, or literature
    //this.borrowedBy = undefined; //at first borrowedBy none of the students
    //USE LOCAL STORAGE in order to save presence and borrowedBy attribute for each book
    this.borrowedBy = localStorage.setItem("borrowedBy", "nobody"); //borrowedBy is the username of student who borrowed book
    //presence(1) or borrowed(0) situation of book
    this.presence = localStorage.setItem("presence", 1); //all books start with presence (1)
}

//book function to categorize the book
//sets category attribute for Book object
Book.prototype.categorizeBook = function(book)
{
    if(book.id % 4 == 0)
    {
        book.category = "art";
        //add the book to the correct shelf based on category
        Shelf.prototype.addToShelf("art", book)
    }
    else if(book.id % 4 == 1)
    {
        book.category = "science";
        Shelf.prototype.addToShelf("science", book)
    }
    else if(book.id % 4 == 2)
    {
        book.category = "sport";
        Shelf.prototype.addToShelf("sport", book)
    }
    else if(book.id % 4 == 3)
    {
        book.category = "literature";
        Shelf.prototype.addToShelf("literature", book)
    }
}

Shelf.prototype.addToShelf = function(category, book)
{
    //TODO make it so this doesn't do a new shelf every time
    var shelf = new Shelf(category);
    shelf.booksOnShelf.push(book);
}

//shelf constructor
function Shelf(category)
{
    this.category = category; //represents the shelf category
    this.booksOnShelf = []; //represents all the books on this shelf
    //**different shelf for each category : art, science, sport, literature
}
