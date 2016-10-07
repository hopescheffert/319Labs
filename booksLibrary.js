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
    else
    {
        alert("Incorrect username or password");
        return;
    }
    console.log("lib " + lib.allBooks);
    //display library as table in html
    //do we need to pass the library to this function?
    document.getElementById("myLibrary").innerHTML = Library.prototype.displayLibrary(lib);

}
//shows the login page in html
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
//***note that this is only for these specific books and book id's (this library only)***
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
    //make table and table headers for the shelves...background is green
    s = "<table id=\"myTable\" border='1px solid black'>";
    s += "<th style='background-color:green'>Literature Shelf</th>";
    s += "<th style='background-color:green'>Science Shelf</th>";
    s += "<th style='background-color:green'>Sports Shelf</th>";
    s += "<th style='background-color:green'>Art Shelf</th>";
    for(var i = 0; i < 6; i++)
    {
        s += "<tr>";
        if(lib.literatureShelf.booksOnShelf[i] != undefined)
        {
            //TODO the onclick isn't working right...won't do an alert for some reason but is logging the desired output
            //TODO also need it to only do onclick when the book is clicked for more info...
            //right now, the onclick is being called as soon as this line executes (WRONG)
            s += "<td onclick='\"" + function() {alert(lib.literatureShelf.booksOnShelf[i].click())} + "\"'>";
            s += Library.prototype.displayBook(lib.literatureShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.scienceShelf.booksOnShelf[i] != undefined)
        {
            s += "<td onclick='\"" + alert(lib.scienceShelf.booksOnShelf[i].click()) + "\"'>";
            s += Library.prototype.displayBook(lib.scienceShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.sportsShelf.booksOnShelf[i] != undefined)
        {
            s += "<td onclick='\"" + alert(lib.sportsShelf.booksOnShelf[i].click()) + "\"'>";
            s += Library.prototype.displayBook(lib.sportsShelf.booksOnShelf[i]);
            s += "</td>";
        }

        if(lib.artShelf.booksOnShelf[i] != undefined)
        {
            s += "<td onclick='\"" + alert(lib.artShelf.booksOnShelf[i].click()) + "\"'>";
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
    //s += " onclick= \"" + bookObj.click(this) + "\"";
    s += " readonly>";
    return s;
}


//book constructor
function Book(bookid, bookType, library)
{
    this.id = bookid;
    this.type = bookType; //5 reference, 20 ordinary in this library
    this.category = "literature";
    //TODO note that reference books cannot be checked out
    this.putOnShelf(library); //assign art, science, sport, or literature
    //this.borrowedBy = undefined; //at first borrowedBy none of the students
    //USE LOCAL STORAGE in order to save presence and borrowedBy attribute for each book
    this.borrowedBy = localStorage.setItem("borrowedBy", "nobody"); //borrowedBy is the username of student who borrowed book
    //presence(1) or borrowed(0) situation of book
    this.presence = localStorage.setItem("presence", 1); //all books start with presence (1)
}
//get borrwed by attribute of book from local storage
Book.prototype.getBorrowedBy = function()
{
    return localStorage.getItem("borrowedBy");
}
//get presence attribute of book from local storage
Book.prototype.getPresence = function()
{
    return localStorage.getItem("presence");
}
//onclick function that displays book information when book is clicked on
Book.prototype.click = function()
{
    console.log("in click");
    return ("Book " + this.toString() + " is on shelf " + this.category +
    " and book has presence " + this.getPresence() + " and is borrowed by " + this.getBorrowedBy());
}

//add the book to the correct shelf based on category
//sets category attribute for Book object
Book.prototype.putOnShelf = function(library)
{
    if(this.id % 4 == 0)
    {
        this.category = "art";
        library.artShelf.booksOnShelf.push(this);
    }
    else if(this.id % 4 == 1)
    {
        this.category = "science";
        library.scienceShelf.booksOnShelf.push(this);

    }
    else if(this.id % 4 == 2)
    {
        this.category = "sport";
        library.sportsShelf.booksOnShelf.push(this);

    }
    else if(this.id % 4 == 3)
    {
        this.category = "literature";
        library.literatureShelf.booksOnShelf.push(this);

    }
}
//tostring to show books like on lab write up
Book.prototype.toString = function()
{
    if(this.type == "ordinary") //ordinary book
    {
        return "B" + this.id;
    }
    else //reference book
    {
        return "R" + this.id;
    }
}
//shelf constructor
function Shelf(category)
{
    this.category = category; //represents the shelf category
    this.booksOnShelf = []; //represents all the books on shelf
}
//to string for better understanding
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
