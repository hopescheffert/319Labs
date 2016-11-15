
var myLibrary = angular.module("myLibrary", ["ngRoute"]);
myLibrary.config(function($routeProvider)
{
    $routeProvider
    .when("/login", {
        templateUrl : "login.html",
        controller : 'loginController'

    })
    .when("/librarian", {
        templateUrl : "librarian.html",
        controller : 'librarianController'

    })
    .when("/undergrad", {
        templateUrl : "undergrad.html",
        controller : 'undergradController'

    }).otherwise({ redirectTo: '/'});
});
myLibrary.controller('indexController', function($scope, $location){
    $location.path("/login");
});
myLibrary.controller('loginController', function($scope, $location, userService)
{
    $scope.login = function()
    {
        if($scope.username == "admin" && $scope.password == "admin")
        {
            //log in as a librarian
            userService.setUsername($scope.username);
            $scope.userType = "librarian";
            alert("Success, logged in as a librarian");
            $location.path("/librarian");
        }
        else if($scope.username.startsWith("u",0))
        {
            //log in as an undergrad student
            $scope.userType = "undergrad";
            userService.setUsername($scope.username);
            alert("Success, logged in as an undergrad");
            $location.path("/undergrad");
        }
        else
        {
            alert("Incorrect username or password");
            return;
        }
    }
});

myLibrary.service('userService', function()
{
    var username = "";

    return {
        getUsername: function()
        {
            return username;
        },
        setUsername: function(name)
        {
            username = name;
            console.log('hello in user serbice we set username to ' + username);

        }
    };
});


myLibrary.service('booksService', function()
{
    var books = [];
    return
    {
        getBooks: function()
        {
            return books;
        },
        addToBooks: function(book)
        {
            books.push(book);
            //use local storage to store presence and borrowed by attributes
            localStorage.setItem("p"+ b.name, 1);
            localStorage.setItem("b"+ b.name, "nobody");
        }
    };

});


myLibrary.controller("librarianController", function($scope, booksService)
{
    $scope.books = booksService.books;
    $scope.shelves = ["literature", "science", "sports", "art"];

    //initialize library with 25 books (20 ordinary and 5 reference)
    for(var i = 1; i < 21; i++)
    {
        sid = i % 4;
        if(sid == 0) s = "literature";
        else if(sid == 1) s = "science";
        else if(sid == 2) s = "sports";
        else s = "art"
        var b = {name: "B" + i, type: "ordinary", borrowedBy: "nobody", presence: 1, shelf: sid};

        // //use local storage to store presence and borrowed by attributes
        // localStorage.setItem("p"+ b.name, 1);
        // localStorage.setItem("b"+ b.name, "nobody");

        booksService.addToBooks(b);
        $scope.books.push(b);
    }
    for(var i = 1; i < 6; i++)
    {
        sid = i % 4;
        if(sid == 0) s = "literature";
        else if(sid == 1) s = "science";
        else if(sid == 2) s = "sports";
        else s = "art"
        var r = {name: "R" + i, type: "reference", borrowedBy: "nobody", presence: 1, shelf : sid};

        // //use local storage to store presence and borrowed by attributes
        // localStorage.setItem("p"+ b.name, 1);
        // localStorage.setItem("b"+ b.name, "nobody");

        booksService.addToBooks(b);
        $scope.books.push(r);
    }

    $scope.addBook = function(bookName, bookShelf, isReferenceBook)
    {
        if(isReferenceBook) t = "reference";
        else t = "ordinary";
        if(bookShelf == "literature") sid = 0;
        else if(bookShelf == "science") sid = 1;
        else if(bookShelf == "sports") sid = 2;
        else sid = 3;

        // //use local storage to store presence and borrowed by attributes
        // localStorage.setItem("p"+ b.name, 1);
        // localStorage.setItem("b"+ b.name, "nobody");

        var b = {name: bookName, type: t, borrowedBy: "nobody", presence: 1, shelf: sid};
        booksService.addToBooks(b);
        $scope.books.push(b);
    }
    $scope.displayBookInfo = function(book)
    {
        var p = "Yes";
        if(localStorage.getItem("p" + book.name) == 0) p = "No";
        var borrowedBy = localStorage.getItem("b" + book.name);
        alert("Book Name: " + book.name + "\nBook Type: " + book.type + "\nPresent: " + p + "\nBorrowed By: " + borrowedBy);
    }

});

myLibrary.controller("undergradController", function($scope, userService, booksService)
{
    //TODO how do we get access to same library?
    $scope.books = booksService.books;
    $scope.shelves = ["literature", "science", "sports", "art"];
    $scope.currentCheckedOut = 0;

    $scope.check(book)
    {
        if(book.type == "reference")
        {
            alert("Cannot check out a reference book");
        }
        else
        {
            if(document.getElementById(book.name).style.color = "white")
            {
                if($scope.currentCheckedOut == 2)
                {
                    alert("Cannot check out more than two books at a time");
                }
                else
                {
                    //check out the book
                    $scope.currentCheckedOut += 1;
                    localStorage.setItem("p" + book.name, 0);
                    localStorage.setItem("b" + book.name, userService.getUsername());
                    //TODO how to get username - service?
                    book.presence = 0;
                    book.borrowedBy = userService.getUsername();
                    document.getElementById(book.name).style.backgroundColor = "red";
                }
            }
            else
            {
                //check book back in
                localStorage.setItem("p" + book.name, 1);
                localStorage.setItem("b" + book.name, "nobody")
                book.presence = 1;
                book.borrowedBy = "nobody";
                document.getElementById(book.name).style.backgroundColor = "white";
                $scope.currentCheckedOut -= 1;
            }
        }
    }
});
