
var myLibrary = angular.module("myLibrary", ["ngRoute"]);
myLibrary.config(function($routeProvider)
{
    $routeProvider
    .when("/", {
        templateUrl : "login.html"
    })
    .when("/librarian", {
        templateUrl : "librarian.html"
    })
    .when("/undergrad", {
        templateUrl : "undergrad.html"
    })
});
myLibrary.controller('libraryController', function($scope)
{
    $scope.login = function()
    {
        console.log($scope.username + " "+ $scope.password);
        if($scope.username == "admin" && $scope.password == "admin")
        {
            //log in as a librarian
            $scope.userType = "librarian";
        }
        else if($scope.username.startsWith("u",0))
        {
            //log in as an undergrad student
            $scope.userType = "undergrad";
        }
        else
        {
            alert("Incorrect username or password");
            return;
        }
    }
})
