
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
myLibrary.controller('loginController', function($scope, $location, userService, booksService)
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


  //initialize library with 25 books (20 ordinary and 5 reference)
  for(var i = 1; i < 21; i++)
  {
    sid = i % 4;
    if(sid == 0) s = "literature";
    else if(sid == 1) s = "science";
    else if(sid == 2) s = "sports";
    else s = "art"
    var b = {name: "B" + i, type: "ordinary", borrowedBy: "nobody", presence: 1, shelf: sid};

    booksService.addToBooks(b);
  }
  for(var i = 1; i < 6; i++)
  {
    sid = i % 4;
    if(sid == 0) s = "literature";
    else if(sid == 1) s = "science";
    else if(sid == 2) s = "sports";
    else s = "art"
    var r = {name: "R" + i, type: "reference", borrowedBy: "nobody", presence: 1, shelf : sid};
    booksService.addToBooks(r);
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
    }
  };
});


myLibrary.service('booksService', function()
{
  var books = [];
  var rows = []; //holds arrays of 4 book objects (represents one row for displaying in views)
  var count = 0;
  var r = []; //4 book objects

  return  {
    getBooks: function()
    {
      return books;
    },
    getRows: function()
    {
      return rows;
    },
    getIncompleteRow: function()
    {
      console.log("incomplete row")
      return r;
    },
    addToBooks: function(book)
    {
      books.push(book);
      if(count == 4)
      {
        rows.push(r);
        r = [];
        r[0] = book;
        count = 0;
      }
      else
      {
        if(book.shelf == 0) r[0] = book;
        else if(book.shelf == 1) r[1] = book;
        else if(book.shelf == 2) r[2] = book;
        else r[3] = book;
        count++;
      }
      //use local storage to store presence and borrowed by attributes
      //but check first if it has already been stored - don't reset it
      if(localStorage.getItem("p" + book.name) == undefined)
      {
        localStorage.setItem("p"+ book.name, 1);
      }
      if(localStorage.getItem("b" + book.name) == undefined)
      {
        localStorage.setItem("b"+ book.name, "nobody");
      }
    }
  };

});

myLibrary.controller("librarianController", function($scope, booksService)
{
  $scope.books = booksService.getBooks();
  $scope.rows = booksService.getRows();
  $scope.incompleteRow = booksService.getIncompleteRow();
  $scope.shelves = ["literature", "science", "sports", "art"];

  $scope.addBook = function(bookName, bookShelf, isReferenceBook)
  {
    if(isReferenceBook) t = "reference";
    else t = "ordinary";
    if(bookShelf == "literature") sid = 0;
    else if(bookShelf == "science") sid = 1;
    else if(bookShelf == "sports") sid = 2;
    else sid = 3;
    var b = {name: bookName, type: t, borrowedBy: "nobody", presence: 1, shelf: sid};
    booksService.addToBooks(b);
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
  $scope.books = booksService.getBooks();
  $scope.rows = booksService.getRows();
  $scope.incompleteRow = booksService.getIncompleteRow();
  $scope.shelves = ["literature", "science", "sports", "art"];
  $scope.currentCheckedOut = 0;

  $scope.check = function(book)
  {
    if(book.type == "reference")
    {
      alert("Cannot check out a reference book");
    }
    else
    {
      if(localStorage.getItem("p" + book.name) == 1) //&& document.getElementById(book.name).style.backgroundColor = "white")
      {
        //trying to check the book out
        if($scope.currentCheckedOut == 2) //not allowed
        {
          alert("Cannot check out more than two books at a time");
        }
        else
        {
          console.log("presence is " + localStorage.getItem("p" + book.name) + " and borrowed by is "  + localStorage.getItem("b" + book.name));
          if(localStorage.getItem("p" + book.name) == 0 && localStorage.getItem("b" + book.name) != userService.getUsername())
          {
            //someone already has the book
            console.log("someone has this book already");
            alert("Someone has already checked out this book");
          }
          else if(localStorage.getItem("p" + book.name) == 1)
          {
            //check out the book
            console.log("need to check out");
            $scope.currentCheckedOut += 1;
            localStorage.setItem("p" + book.name, 0);
            localStorage.setItem("b" + book.name, userService.getUsername());
            console.log("now " + book.name + " has presence " +localStorage.getItem("p" + book.name)+ " and has borrowed by " + localStorage.getItem("b" + book.name));
            book.presence = 0;
            book.borrowedBy = userService.getUsername();
            document.getElementById(book.name).style.backgroundColor = "red";
          }

        }
      }
      else if(document.getElementById(book.name).style.backgroundColor = "red" && localStorage.getItem("p" + book.name) == 0 && localStorage.getItem("b" + book.name) == userService.getUsername())
      {
        //user is trying to check book back in
        localStorage.setItem("p" + book.name, 1);
        localStorage.setItem("b" + book.name, "nobody")
        console.log("need to check back in");
        console.log("now " + book.name + " has presence " +localStorage.getItem("p" + book.name)+ " and has borrowed by " + localStorage.getItem("b" + book.name));
        book.presence = 1;
        book.borrowedBy = "nobody";
        document.getElementById(book.name).style.backgroundColor = "white";
        $scope.currentCheckedOut -= 1;
      }
    }
  }
});
