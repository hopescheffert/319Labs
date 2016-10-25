//---------------------------------------------------------------
//
// To RUN THIS EXAMPLE
// First, run node httpServer.js on one terminal
// Next, run node 1_ws.js on another terminal
// Next, type localhost:4000/index.html on some browser
//
//---------------------------------------------------------------
var io = require('socket.io').listen(5000);
var posts = [];
var planets = [];
var users = [];

io.sockets.on('connection', function(socket) {
 
 socket.on('login', function(username){
	users.push(username);
	socket.emit('updatePosts', posts);
	socket.emit('updatePlanets', planets);
	io.sockets.emit('updateUsers', users);
 });
 
 socket.on('submitPost', function(post){
	posts.push(post);
	io.sockets.emit('updatePosts', posts);
 });
 
 socket.on('logout', function(username){
	var index = users.indexOf(username);
	users.splice(index, 1);
	io.sockets.emit('updateUsers', users);
 });
 
 socket.on('editPost', function(newPost){
	posts[newPost.index] = {username: posts[newPost.index].username, post: newPost.text};
	io.sockets.emit('updatePosts', posts);
 });
 
 socket.on('command', function(commandText){
    //some reqular expressions
    var numRegex = /[0-9]*.?[0-9]+/
    var hexRegex = /0x[0-9a-f][0-9a-f][0-9a-f][0-9a-f][0-9a-f][0-9a-f]/;
 	// user input: addPlanet color size distancefromsun speed name
 	var examine = commandText.split(" ");
	if(examine.length == 6 && examine[0] == "addPlanet" && examine[2].match(numRegex) && examine[3].match(numRegex) && examine[4].match(numRegex)){
		//Add Planet Command was sent
	
		if(examine[1].match(hexRegex)){
            var ccolor = examine[1];
        } else if(examine[1] == "red") {
			var ccolor = 0xff0000;
		} else if (examine[1] == "blue") {
			var ccolor = 0x0000ff;
		} else if (examine[1] == "green") {
			var ccolor = 0x00ff00;
		} else if (examine[1] == "yellow") {
			var ccolor = 0xffff00;
		}  else if (examine[1] == "orange") {
			var ccolor = 0xffa500;
		} else {
            var ccolor = 0xffffff;
        }
		var csize = parseFloat(examine[2]);
		var cdistance = parseFloat(examine[3]) + 5;
		var cspeed = parseFloat(examine[4]);
		var cname = examine[5];
		
		io.sockets.emit('addPlanet', {color: ccolor, size: csize, distance: cdistance, speed: cspeed, name: cname});
		planets.push({color: ccolor, size: csize, distance: cdistance, speed: cspeed, name: cname});
	} else if (examine[0] == "removePlanet"){
		//Remove Planet command was sent
		var index = planets.indexOf(examine[1]);
		planets.splice(index, 1);
		io.sockets.emit('removePlanet', examine[1]);
	} else {
		//Command not recognized
        socket.emit('InvalidCommand');
	}
 });
 
});
