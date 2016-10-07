//booksLibrary.js EDIT

//TODO LIBRARIAN: Ability to add specific book to specific shelf.
//TODO UNDERGRADUATE STUDENT: Undergraduate student can borrow at most two books each time.
//So, a student can select on at most two books




//library constructor
function Library(username)
{
    //types of books: 5 reference, 20 ordinary
    //reference books cannot be checked out
    this.username = username;
    this.numBooksCheckedOut = 0; //user has this many books checked out
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
        var lib = new Library(username);
        lib.userType = "librarian";
        //console.log("lib is " + lib.allBooks);

    }
    else if(username.startsWith("u",0))
    {
        //log in as an undergrad student
        var lib = new Library(username);
        lib.userType = "undergrad";
        //console.log("library consists of " + lib.allBooks.toString());
    }
    else
    {
        alert("Incorrect username or password");
        return;
    }
    //display library as table in html
    document.getElementById("myLibrary").innerHTML = Library.prototype.initTable(lib);
    Library.prototype.displayLibrary(lib);

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
Library.prototype.displayLibrary = function(lib)
{
    for(var i = 0; i < 6; i++)
    {
        if(lib.literatureShelf.booksOnShelf[i] != undefined)
        {
            document.getElementById(lib.literatureShelf.booksOnShelf[i].toString()).innerHTML
            = Library.prototype.displayBook(lib.literatureShelf.booksOnShelf[i]);
            lib.attachHandlers(lib.literatureShelf.booksOnShelf[i]);
        }

        if(lib.scienceShelf.booksOnShelf[i] != undefined)
        {
            document.getElementById(lib.scienceShelf.booksOnShelf[i].toString()).innerHTML
            = Library.prototype.displayBook(lib.scienceShelf.booksOnShelf[i]);
            lib.attachHandlers(lib.scienceShelf.booksOnShelf[i]);

        }

        if(lib.sportsShelf.booksOnShelf[i] != undefined)
        {
            document.getElementById(lib.sportsShelf.booksOnShelf[i].toString()).innerHTML
            = Library.prototype.displayBook(lib.sportsShelf.booksOnShelf[i]);
            lib.attachHandlers(lib.sportsShelf.booksOnShelf[i]);

        }

        if(lib.artShelf.booksOnShelf[i] != undefined)
        {
            document.getElementById(lib.artShelf.booksOnShelf[i].toString()).innerHTML
            = Library.prototype.displayBook(lib.artShelf.booksOnShelf[i]);
            lib.attachHandlers(lib.artShelf.booksOnShelf[i]);

        }
    }
    document.getElementById(lib.scienceShelf.booksOnShelf[6].toString()).innerHTML
    = Library.prototype.displayBook(lib.scienceShelf.booksOnShelf[6]);
    lib.attachHandlers(lib.scienceShelf.booksOnShelf[6]);

    document.getElementById(lib.artShelf.booksOnShelf[6].toString()).innerHTML
    = Library.prototype.displayBook(lib.artShelf.booksOnShelf[6]);
    lib.attachHandlers(lib.artShelf.booksOnShelf[6]);



}
Library.prototype.initTable = function(lib)
{
    var s;
    //make table and table headers for the shelves...background is green
    s = "<table id=\"myTable\" border='1px solid black'>";
    s += "<th style='background-color:green'>Literature Shelf</th>";
    s += "<th style='background-color:green'>Science Shelf</th>";
    s += "<th style='background-color:green'>Sports Shelf</th>";
    s += "<th style='background-color:green'>Art Shelf</th>";

    for(var i = 0; i < 6; i++)
    {
        s += "<tr id='" + i + "'>";
        if(lib.literatureShelf.booksOnShelf[i] != undefined)
        {
            s += "<td id=\"" + lib.literatureShelf.booksOnShelf[i].toString() + "\">";
            s += "</td>";
        }

        if(lib.scienceShelf.booksOnShelf[i] != undefined)
        {
            s += "<td id=\"" + lib.scienceShelf.booksOnShelf[i].toString() + "\">";
            s += "</td>";
        }

        if(lib.sportsShelf.booksOnShelf[i] != undefined)
        {
            s += "<td id=\"" + lib.sportsShelf.booksOnShelf[i].toString() + "\">";
            s += "</td>";
        }

        if(lib.artShelf.booksOnShelf[i] != undefined)
        {
            s += "<td id=\"" + lib.artShelf.booksOnShelf[i].toString() + "\">";
            s += "</td>";
        }
        s+= "</tr>";

    }
    s += "<tr>";
    s += "<td></td><td <td id=\"" + lib.scienceShelf.booksOnShelf[6].toString() + "\">";
    s += "</td>";
    s += "<td></td><td <td id=\"" + lib.artShelf.booksOnShelf[6].toString() + "\">";
    s += "</td>";
    s += "</tr>";
    s += "</table>";
    return s;

}
Library.prototype.attachHandlers = function(book)
{
    var o = document.getElementById(book.toString());
    o.onclick = function ()
    {
        Book.prototype.click(book);
    }
}
//display a book for inside the library table
Library.prototype.displayBook = function(bookObj)
{
    var s = "<input ";
    s += " id=\"" + bookObj.toString() + "\"";
    s += " type='text'";
    s += " value= \"" + bookObj.toString() + "\"";
    s += " readonly>";
    return s;
}


//book constructor
function Book(bookid, bookType, library)
{
    this.id = bookid;
    this.type = bookType; //5 reference, 20 ordinary in this library
    this.category = "literature";
    this.library = library;
    this.putOnShelf(library); //assign art, science, sport, or literature
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

//onclick function for when book is clicked
Book.prototype.click = function(book)
{
    if(book.library.userType == "librarian") //it's a librarian so clicking on the book should display book information
    {
        alert("Book " + book.toString() + " is on shelf " + book.category +
        " and book has presence " + book.getPresence() + " and is borrowed by " + book.getBorrowedBy());
    }
    else //it's an undergrad so clicking the book should result in checking that book out
    {
        if(book.library.numBooksCheckedOut < 2) //allowed to check out another book
        {
            console.log("in click presence is " + book.getPresence());

            if(book.getPresence() == 1 && book.getBorrowedBy() == "nobody")
            {
                //the book has not been checked out or borrowed by anyone so let the undergrad check it out
                book.checkOutBook(book);
            }

            else if(book.getBorrowedBy() == book.library.username) //if they already have the book, check it back in
            {
                book.checkBookIn(book);
            }
            else
            {
                alert("There are no copies of " + book.toString() + " left, it has been checked out by: " + book.getBorrowedBy());
            }
        }
        else
        {
            alert("I'm sorry, but you can only check out 2 books at a time");
        }

        //TODO undergrad can borrow at most two books at once
    }

}
//checks in the book:
//changes borrwedBy to nobody
//changes presence to 1 (availabe)
Book.prototype.checkBookIn = function(book)
{
    //change the borrowedBy to nobody
    book.borrowedBy = localStorage.setItem("borrowedBy", "nobody");

    //change the presence attribute to 1 (available)
    book.presence = localStorage.setItem("presence", 1);
    book.library.numBooksCheckedOut -= 1;
    console.log("in checkbookin presence should be 1 but is " + book.getPresence());


    document.getElementById(book.toString()).style.backgroundColor = "white";


}

//checks out the book:
//changes borrwedBy to username
//changes presence to 0 (borrowed)
Book.prototype.checkOutBook = function(book)
{
    if(book.type == "ordinary")
    {
        //change the borrowedBy to that users username
        book.borrowedBy = localStorage.setItem("borrowedBy", book.library.username);
        //change the presence attribute to 0 (borrowed)
        book.presence = localStorage.setItem("presence", 0);
        book.library.numBooksCheckedOut += 1;
        console.log("in check out presence shoudld be 0 but is " + book.getPresence());

        document.getElementById(book.toString()).style.backgroundColor = "red";
    }
    else //cannot borrow a reference book
    {
        alert("I'm sorry, but you cannot check out a reference book");
    }

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
