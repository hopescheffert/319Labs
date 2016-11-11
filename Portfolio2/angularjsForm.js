//Validation app
var app = angular.module('myValidationApp', []);
//Validation form controller
app.controller('formCtrl', function($scope, votes, voters)
{

    //Init custom services/factories
    var votesService = votes;
    var votersService = voters;

    //Check minimum age for DOB in form (so that if enter age under 18, form is not valid, cannot vote)
    var today = new Date();
    var minAge = 18;
    $scope.minAge = new Date(today.getFullYear() - minAge, today.getMonth(), today.getDate());
    //Object representing candidates, used in drop down menu
    $scope.candidates = [{"id": "clinton", "name": "Hillary Clinton"}, {"id": "trump", "name": "Donald Trump"},
    {"id": "johnson", "name": "Gary Johnson"}, {"id": "stein", "name": "Jill Stein"}];
    $scope.submitForm = function(isValid)
    {
        $scope.submitted = true;
        if(isValid)
        {
            var v = votersService.add($scope.user);
            votesService.vote($scope.user.Choice);
        }
        else
        {
            alert("Form not valid. Please fix the required fields");
        }
    }
});
//Custom service to handle voting - retrieving from/sending to the server
app.factory('votes', function($http)
{
    var votesObj = {};

    //Get current votes from server
    $http.get("getVotes.php").success(function(data)
    {
        votesObj = data;
        console.log(data);
    })

    //NOTE THAT AS LONG AS THEY HAVE DIFFERENT SOCIAL SECURITY NUMBERS, THEY ARE ALLOWED TO VOTE

    votesObj.vote = function(candidate)
    {
        $http.post("sendVotes.php", {'candidate': candidate, 'votes': votesObj}).then(function(response)
        {
            console.log(response.data);
            return response.data;
        })
    }
    return votesObj;

});

//Custom service to handle voters information - sending information to the server
app.factory('voters', function($http)
{
    var voterObj = {};
    voterObj.add = function(voter)
    {
        $http.post("addVoters.php", voter).then(function(response)
        {
            // console.log("after addVoters.php: ");
            if(response.data == "false")
            {
                //We found a match in voters.json file, so we can't let them vote again
                //FOUND PERSON THAT ARLEADY VOTED
                alert("You already voted, you cannot vote again!");
                return false;
            }
            else
            {
                alert("Thank you for voting!");
                //FOUND NEW VOTER
                console.log(response.data);
                return true;
            }
        })
    }

    return voterObj;
});
