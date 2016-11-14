
var myLibrary = angular.module("myLibrary", ["ngRoute"]);
myLibrary.config(function($routeProvider)
{
    $routeProvider
    .when("/login", {
        templateUrl : "login.html",
        controller : 'libraryController'

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
myLibrary.controller('indexController', function($scope,$location){
    $location.path("/login");

});
myLibrary.controller('libraryController', function($scope, $location)
{
    $scope.login = function()
    {
        if($scope.username == "admin" && $scope.password == "admin")
        {
            //log in as a librarian
            $scope.userType = "librarian";
            alert("Success, logged in as a librarian");
            $location.path("/librarian");
        }
        else if($scope.username.startsWith("u",0))
        {
            //log in as an undergrad student
            $scope.userType = "undergrad";
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

myLibrary.controller("librarianController", function($scope)
{




});
myLibrary.controller("undergradController", function($scope)
{




});
