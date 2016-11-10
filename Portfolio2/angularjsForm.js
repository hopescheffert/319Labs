var app = angular.module('myValidationApp', []);

app.controller('formCtrl', function($scope, votes, voters)
{

    //init custom services/factories
    var votesService = votes;
    var votersService = voters;

    //check minimum age for DOB in form (so that if enter age under 18, not valid)
    var today = new Date();
    var minAge = 18;
    $scope.minAge = new Date(today.getFullYear() - minAge, today.getMonth(), today.getDate());
    //object representing candidates, used in drop down menu
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
//custom service to handle voting - retrieving from and sending to the server
app.factory('votes', function($http)
{
    var votesObj = {};

    //get current votes from server
    $http.get("getVotes.php").success(function(data)
    {
        votesObj = data;
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

//custom service to handle voters information - retrieving from and sending to the server
app.factory('voters', function($http)
{
    var voterObj = {};
    voterObj.add = function(voter)
    {
        $http.post("addVoters.php", voter).then(function(response)
        {
            console.log("after addVoters.php: ");
            if(response.data == "false")
            {
                //NOTE we found a match in voters.json file, so we can't let them vote again

                console.log("FOUND ONE THAT ARLEADY VOTED");
                alert("You already voted, you cannot vote again!");
                return false;
            }
            else
            {
                alert("Thank you for voting!");
                console.log("FOUND NEW VOTER");
                console.log(response.data);
                return true;
            }
        })
    }

    return voterObj;
});
