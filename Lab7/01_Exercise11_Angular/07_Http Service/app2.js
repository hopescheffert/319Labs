angular.module('myApp2', [])
.controller('myController', function($scope, $http) { 

   $scope.fetchData = function() {
     $http ({
         method : 'get',
         url : 'data.json'

      }). then (function(response) {
                  $scope.data = response.data;
                },
                function(response) {
                  $scope.data = "error";
                }
      );
   }
})
