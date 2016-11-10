angular.module('myApp', [])
.controller('myController', function($scope, $http) { 
   $scope.fetchData = function() {
     console.log("Clicked Button")
     $http.get('data.json').
         then(function(response) {
           $scope.data = response.data;
           console.log(response.data)
         }, function() {
           $scope.data = "error";
           console.log(response.data)
         });

   }
})
