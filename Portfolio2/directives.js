angular.module('myApp', [])
.controller('myController', function($scope) {
    $scope.idk = ["something", "something else","even something else"];
    $scope.personinfo = [
        {
            "Name" : "Hillary Clinton",
            "Party" : "Democratic"
        },
        {
            "Name" : "Donald Trump",
            "Party" : "Republican"
        }
    ]

})
.directive('firstDirective', function() {
    return {
        restrict: 'AE', // to allow directive in element and in attributes
        replace: true, // replaces element declared on

        templateUrl: 'firstDirectiveTemplate.html',
        link: function(scope, elem, attrs)
        {
            elem.bind('mouseover', function() {
                elem.css('color','blue');
                elem.css('fontSize', '40px');
            });
            elem.bind('mouseout', function() {
                elem.css('color','red');
                elem.css('fontSize', '20px');
            });
        }

    }
})
.directive('secondDirective', function() {
    return {
        scope: true,
        restrict: 'AE', // to allow directive in element and in attributes
        replace: true, // replaces element declared on

        templateUrl: 'secondDirectiveTemplate.html',

        link: function(scope, elem, attrs)
        {
            elem.bind('click', function()
            {
                console.log(scope);
                document.body.append("Hello, my name is " + scope.personinfo[0].Name + " and I am running in the " + scope.personinfo[0].Party+  " party");
                document.body.append("Hello, my name is " + scope.personinfo[1].Name + " and I am running in the " + scope.personinfo[1].Party+  " party");

            });
        }
    };
});
