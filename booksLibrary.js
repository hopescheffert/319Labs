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
    this.literatureShelf = new Shelf("literature");
    this.allBooks = [];
    //initialize library with 25 books (20 ordinary and 5 reference)
    for(var i = 0; i < 21; i ++)
    {
        this.allBooks.push(new Book(i, "ordinary", this));
    }
    for(var i = 21; i < 26; i++)
    {
        this.allBooks.push(new Book(i, "reference", this));
    }

}

//called to log in and show the library table in the html page
Library.prototype.logIn = function(username, password)
{
    var username = username.value;
    var password = password.value;

    if(username == "admin" && password == "admin")
    {
        //log in as a librarian
        var lib = new Library();
        lib.userType = "librarian";
        //console.log("lib is " + lib.allBooks);

    }
    else if(username.startsWith("u",0))
    {
        //log in as an undergrad student
        var lib = new Library();
        lib.userType = "undergrad";
        //console.log("library consists of " + lib.allBooks.toString());
    }
    else {
        alert("Incorrect username or password");
    }
    console.log("lib " + lib.allBooks);
    //display library as table in html
    //do we need to pass the library to this function?
    document.getElementById("myLibrary").innerHTML = Library.prototype.displayLibrary(lib);

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
//display the library as a table
//TODO note that this is only for these specific books and book id's
Library.prototype.displayLibrary = function(lib)
{
    //each column is a Shelf, each cell is a book on that shelf
    console.log("literature shelf is : " + lib.literatureShelf.booksOnShelf);
    console.log("science shelf is : " + lib.scienceShelf.booksOnShelf);
    console.log("sports shelf is : " + lib.sportsShelf.booksOnShelf);
    console.log("art shelf is : " + lib.artShelf.booksOnShelf);
    console.log("lengths are " + lib.literatureShelf.booksOnShelf.length  + " " +
    lib.scienceShelf.booksOnShelf.length + " " + lib.sportsShelf.booksOnShelf.length + " " +
    lib.artShelf.booksOnShelf.length);

    var s;
    s = "<table id=\"myTable\" border='1px solid black'>";
    s += "<th style='background-color:green'>Literature Shelf</th>";
    s += "<th style='background-color:green'>Science Shelf</th>";
    s += "<th style='background-color:green'>Sports Shelf</th>";
    s += "<th style='background-color:green'>Art Shelf</th>";
    for(var i = 0; i < 6; i++)
    {
        s += "<tr id='row" + i +"'>";
        if(lib.literatureShelf.booksOnShelf[i] != undefined)
        {
            s += "<td>";
            s += Library.prototype.displayBook(lib.literatureShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.scienceShelf.booksOnShelf[i] != undefined)
        {
            s += "<td>";
            s += Library.prototype.displayBook(lib.scienceShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.sportsShelf.booksOnShelf[i] != undefined)
        {
            s += "<td>";
            s += Library.prototype.displayBook(lib.sportsShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.artShelf.booksOnShelf[i] != undefined)
        {
            s += "<td>";
            s += Library.prototype.displayBook(lib.artShelf.booksOnShelf[i]);
            s += "</td>";
        }
        s+= "</tr>";

    }
    s += "<tr>";
    s += "<td></td><td>";
    s += Library.prototype.displayBook(lib.scienceShelf.booksOnShelf[6]);
    s += "</td>";
    s += "<td></td><td>";
    s += Library.prototype.displayBook(lib.artShelf.booksOnShelf[6]);
    s += "</td>";
    s += "</tr>";
    s += "</table>";
    return s;
}
//display a book for inside the library table
Library.prototype.displayBook = function(bookObj)
{
    var s = "<input ";
    s += " id=\"" + bookObj.id + "\"";
    s += " type='text'";
    s += " value= \"" + bookObj.toString() + "\"";
    s += " onclick= \"" + bookObj.prototype.click(this) + "\"";
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
Book.prototype.click = function(that)
{
    alert("This book: " + that.toString());
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
Book.prototype.toString = function()
{
    //return "[Book id: " + this.id + ", Book type: " + this.type + "]";
    if(this.type == "ordinary")
    {
        return "B" + this.id;
    }
    else {
        return "R" + this.id;
    }
}
//shelf constructor
function Shelf(category)
{
    this.category = category; //represents the shelf category
    this.booksOnShelf = []; //represents all the books on this shelf
    //**different shelf for each category : art, science, sport, literature
}
Shelf.prototype.toString = function()
{
    var ret = "{";
    for(var i = 0; i < this.booksOnShelf.length; i++)
    {
        ret += this.booksOnShelf[i].toString();
    }
    ret += "}";
    return ret;
}
