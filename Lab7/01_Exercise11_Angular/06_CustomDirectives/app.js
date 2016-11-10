angular.module('myApp', [])
.controller('myController', function($scope) { 
   $scope.bye = "Bye, bye... bye, bye... to you and you and you";
})
.directive('helloWorld', function() {
  return {
    restrict: 'AE', // to allow directive in element and in attributes
    replace: true, // replaces element declared on
      
    template: '<p style="background-color:{{color}}">Hello World',
      
    link: function(scope, elem, attrs) {
      elem.bind('mouseover', function() {
        elem.css('cursor', 'pointer');
        elem.css('color','green');
        elem.css('fontSize', '40px');
      });
      elem.bind('mouseout', function() {
        elem.css('color','red');
        elem.css('fontSize', '20px');
      });
    } // end of link
  }
})
.directive('byeWorld', function() { // note NAME does not use -
  return {
    restrict: 'AE', // to allow directive in element and in attributes
    replace: true, // replaces element declared on
      
    templateUrl: 'byeTemplate.html', // NOTE HOW WE TIE TO TEMPLATE FILE
      
    link: function(scope, elem, attrs) {
      elem.bind('mouseover', function() {
        elem.css('cursor', 'pointer');
        elem.css('color','green');
        elem.css('fontSize', '40px');
      });
      elem.bind('mouseout', function() {
        elem.css('color','red');
        elem.css('fontSize', '20px');
      });
    } // end of link
  };
});
