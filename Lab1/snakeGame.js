//alter these to determine where the snake starts
// up ^  0
// right --> 1
// down 2
// left <-- 3
var direction = 1;
var speed = 3;
var x = 0;
var y = 300;

//building the canvas
var canvas = document.getElementById("Canvas");
var context = canvas.getContext("2d");
//make the snake
context.lineWidth = 5;
context.strokeStyle = '#ff0000';
//make snake draw every 50 ms
var timer = setInterval(draw, 50);

//go clockwise
function turnRight()
{
	if(direction == 3)
	{
		direction = 0;
	}
	else
	{
		direction++;
	}
}
//go counterclockwise
function turnLeft()
{
	if(direction == 0)
	{
		direction = 3;
	}
	else
	{
		direction--;
	}
}

//drawing the path of the snake
function draw()
{
	context.moveTo(x,y);
	if(direction == 0)
	{
		y = y - speed;
	}
	else if(direction == 1)
	{
		x = x + speed;
	}
	else if(direction == 2)
	{
		y = y + speed;
	}
	else //direction == 3
	{
		x = x - speed;
	}
	context.lineTo(x, y);
	context.stroke();
}

//the start/stop toggle button
function toggle()
{
	if(speed == 0) 
	{
		speed = 3; //start snake and set button to stop
		document.getElementById("toggle").value = "Stop";
	}
	else 
	{
		speed = 0; //stop the snake and set button to start
		document.getElementById("toggle").value = "Start";
	}
}