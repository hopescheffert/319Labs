//
// Allows js to be in its own file and
// html to be in its own file
//
angular.module('myApp', [])
.controller('myController', function($scope) {

  // note studentsObj is a MODEL variable and is an array of objects
  $scope.studentsObj = 
     [ {first: "John", last: "Bravo"},
       {first: "Adam", last: "West"},
       {first: "Mike", last: "Wazowski"}];
});
