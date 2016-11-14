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
    })

    //NOTE THAT AS LONG AS THEY HAVE DIFFERENT SOCIAL SECURITY NUMBERS, THEY ARE ALLOWED TO VOTE

    votesObj.vote = function(candidate)
    {
        $http.post("sendVotes.php", {'candidate': candidate, 'votes': votesObj}).then(function(response)
        {
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

/*We need to manually start angular as we need to
wait for the google charting libs to be ready*/
google.setOnLoadCallback(function () {
    angular.bootstrap(document.getElementById('pie'), ['myApp']);
});
google.load('visualization', '1', {packages: ['corechart']});


angular.module('myApp',[]).
controller("indexctrl",function($scope, $http) {
    var votesObj = {};
    var clintonVotes = 0;
    var trumpVotes = 0;
    var johnsonVotes = 0;
    var steinVotes = 0;
    var done = false;

    //set up the basic chart
    $scope.data1 = new google.visualization.DataTable();
    $scope.data1.addColumn("string","Candidate")
    $scope.data1.addColumn("number","Votes")

    //watch any changes to data1
    //if any change noticed - change graph
    $scope.$watch("data1",function(newValue,oldValue){
        var options = {'title':'Current Election Results',
                     'width':400,
                     'height':400};
        var googleChart = new
        google.visualization.PieChart(document.getElementById('pie'));
        googleChart.draw(newValue, options);
    }, true
);

//Make a request to get data and then wait using a "promise"
var myPromise = new Promise(function(resolve, reject) {
    $http.get("getVotes.php",{cache: true})
    .success(function(data) {
        resolve(data);
    });

});
//Once get the data, save it for the graph
myPromise.then(function(data) {
    votesObj = data;
    clintonVotes = votesObj.clinton;
    trumpVotes = votesObj.trump;
    johnsonVotes = votesObj.johnson;
    steinVotes = votesObj.stein;

    modifyGraph();
    // this function makes $watch work
    $scope.$apply(function(){});
})


// This is where the graph data is modified
function modifyGraph() {
    $scope.data1.addRow(["Clinton",clintonVotes]);
    $scope.data1.addRow(["Trump",trumpVotes]);
    $scope.data1.addRow(["Johnson",johnsonVotes]);
    $scope.data1.addRow(["Stein",steinVotes]);

}
}) // end of controller
