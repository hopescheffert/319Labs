angular.module('myApp', [])
.controller('myController', function($scope) {
   $scope.idk = ["something", "something else","again something else"];
   $scope.personinfo = [
       {
            "Name" : "Hope",
            "Address" : "450 Pine Rd"
        },{
            "Name" : "Jacob Neyens",
            "Address" : "300 Davis Ct"
        }
    ]

})
.directive('firstDirective', function() {
  return {
    restrict: 'AE', // to allow directive in element and in attributes
    replace: true, // replaces element declared on

    templateUrl: 'firstDirectiveTemplate.html'
  }
})
.directive('secondDirective', function() { // note NAME does not use -
  return {
    restrict: 'AE', // to allow directive in element and in attributes
    replace: true, // replaces element declared on

    templateUrl: 'secondDirectiveTemplate.html',

    // link: function(scope, elem, attrs) {
    //   elem.bind('mouseover', function() {
    //     elem.css('cursor', 'pointer');
    //     elem.css('color','green');
    //     elem.css('fontSize', '40px');
    //   });
    //   elem.bind('mouseout', function() {
    //     elem.css('color','red');
    //     elem.css('fontSize', '20px');
    //   });
    // } // end of link
  };
});
