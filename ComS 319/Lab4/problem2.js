
var direction = 1;
var speed = 1;
var x = 0;
var y = 250;

var c = document.getElementById("theCanvas");
var context = c.getContext("2d");
context.lineWidth = 4;
context.strokeStyle = '#ff0000';

var timer = setInterval(draw, 50);

function toggle(){
	if(speed == 0){
		speed = 1;
		document.getElementById("toggle").value = "Stop";
	} else{
		speed = 0;
		document.getElementById("toggle").value = "Start";
	}
}

function turnRight(){
	if(direction == 3){
		direction = 0;
	} else {
		direction++;
	}
	//Adjust position so turning doesn't look funny
	if(direction == 0)
		x += 2;
	if(direction == 1)
		y += 2;
	if(direction == 2)
		x -= 2;
	if(direction == 3)
		y -= 2;
}

function turnLeft(){
	if(direction == 0){
		direction = 3;
	} else {
		direction--;
	}
	if(direction == 0)
		x -= 2;
	if(direction == 1)
		y -= 2;
	if(direction == 2)
		x += 2;
	if(direction == 3)
		y += 2;
}

function draw(){
	context.moveTo(x,y);
	if(direction == 0){
		y = y - speed;
	} else if(direction == 1){
		x = x + speed;
	} else if(direction == 2){
		y = y + speed;
	} else{
		x = x - speed;
	}
	context.lineTo(x, y);
	context.stroke();
}