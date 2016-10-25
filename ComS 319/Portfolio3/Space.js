//
// Skybox using Three.js.  Try changing the images below,
// or mapping onto a sphere or something instead of a cube.
//
/*
var path ="../images/space/";
var imageNames = [
                  path + "px.jpg",
                  path + "nx.jpg",
                  path + "py.jpg",
                  path + "ny.jpg",
                  path + "pz.jpg",
                  path + "nz.jpg"
                  ];
*/

function planet(psize, pdistance, pcolor, pspeed, pname){
	this.size = psize;
	this.distance = pdistance;
	this.color = pcolor;
	this.speed = pspeed;
	this.name = pname;
}

var planetsList = [];
var planetObjects = [];
var scene = new THREE.Scene();
var controlsEnabled = true;

function addPlanet(size, distance, color, speed, name){
	var o = new planet(size, distance, color, speed, name);
  planetsList.push(o);
	var obj = new THREE.SphereGeometry(1, 128, 128);
	var material = new THREE.MeshPhongMaterial( { color: o.color, specular: 0x222222, shininess: 70} );
	var plan = new THREE.Mesh(obj, material);
	plan.translateZ(o.distance);
    console.log(o.size);
	plan.scale.set(o.size, o.size, o.size);
	planetObjects.push(plan);
	scene.add(plan);
}

function removePlanet(name) {
	for( var i = 0; i < planetsList.length; i++) {
		if(planetsList[i].name == name){
				var index = i;
		}
	}
	console.log(planetObjects[index] + " " + index);
	scene.remove(planetObjects[index]);
	planetsList.splice(index, 1);
	planetObjects.splice(index, 1);
}

var axis = 'z';
var paused = false;
var camera;

var animate = true;

var material;

//translate keypress events to strings
//from http://javascript.info/tutorial/keyboard-events
function getChar(event) {
if (event.which == null) {
 return String.fromCharCode(event.keyCode) // IE
} else if (event.which!=0 && event.charCode!=0) {
 return String.fromCharCode(event.which)   // the rest
} else {
 return null // special key
}
}

//borrowed from my comsci 336 homework
function cameraControl(c, ch)
{
  var distance = c.position.length();
  var q, q2;
  
  switch (ch)
  {
  // camera controls
  case '(':
	addPlanet(1, 13, 0xff0000, 1, "blane");
	break;
  case 'w':
    c.translateZ(-2);
    return true;
  case 'a':
    c.translateX(-2);
    return true;
  case 's':
    c.translateZ(2);
    return true;
  case 'd':
    c.translateX(2);
    return true;
  case 'r':
    c.translateY(2);
    return true;
  case 'f':
    c.translateY(-2);
    return true;
  case 'j':
    // need to do extrinsic rotation about world y axis, so multiply camera's quaternion
    // on left
    q = new THREE.Quaternion().setFromAxisAngle(new THREE.Vector3(0, 1, 0),  5 * Math.PI / 180);
    q2 = new THREE.Quaternion().copy(c.quaternion);
    c.quaternion.copy(q).multiply(q2);
    return true;
  case 'l':
    q = new THREE.Quaternion().setFromAxisAngle(new THREE.Vector3(0, 1, 0),  -5 * Math.PI / 180);
    q2 = new THREE.Quaternion().copy(c.quaternion);
    c.quaternion.copy(q).multiply(q2);
    return true;
  case 'i':
    // intrinsic rotation about camera's x-axis
    c.rotateX(5 * Math.PI / 180);
    return true;
  case 'k':
    c.rotateX(-5 * Math.PI / 180);
    return true;
  case 'O':
    c.lookAt(new THREE.Vector3(0, 0, 0));
    return true;
  case 'S':
    c.fov = Math.min(80, c.fov + 5);
    c.updateProjectionMatrix();
    return true;
  case 'W':
    c.fov = Math.max(5, c.fov  - 5);
    c.updateProjectionMatrix();
    return true;

    // alternates for arrow keys
  case 'J':
    c.translateZ(-distance);
      console.log(distance);
    q = new THREE.Quaternion().setFromAxisAngle(new THREE.Vector3(0, 1, 0),  5 * Math.PI / 180);
    q2 = new THREE.Quaternion().copy(c.quaternion);
    c.quaternion.copy(q).multiply(q2);
    c.translateZ(distance);
    return true;
  case 'L':
    c.translateZ(-distance);
    q = new THREE.Quaternion().setFromAxisAngle(new THREE.Vector3(0, 1, 0),  -5 * Math.PI / 180);
    q2 = new THREE.Quaternion().copy(c.quaternion);
    c.quaternion.copy(q).multiply(q2);
    c.translateZ(distance);
    return true;
  case 'I':
    c.translateZ(-distance);
    c.rotateX(-5 * Math.PI / 180);
    c.translateZ(distance);
    return true;
  case 'K':
    c.translateZ(-distance);
    c.rotateX(5 * Math.PI / 180);
    c.translateZ(distance);
    return true;
  case 'p':
    if(animate) {
      animate = false;
    } else animate = true;
    break;
  }
  return false;
}

function handleKeyPress(event)
{
	if(!$("#newCommand").is(':focus')) {
  	var ch = getChar(event);
  	if (cameraControl(camera, ch)) return;
  }
}

function start()
{
  window.onkeypress = handleKeyPress;
  
  camera = new THREE.PerspectiveCamera( 45, 1.5, 0.1, 100000 );
  camera.position.x = 50;
  camera.position.y = 10;
  camera.position.z = 0;
  camera.lookAt(new THREE.Vector3(0, 0, 0));
  
  var ourCanvas = document.getElementById('theCanvas');
  var renderer = new THREE.WebGLRenderer({canvas: ourCanvas});
  
  var sphere = new THREE.SphereGeometry(1, 128, 128);
  var basicMaterial = new THREE.MeshBasicMaterial( { color: 0xffff00 } );
  material = new THREE.MeshPhongMaterial( { color: 0xffffff, specular: 0x222222, shininess: 70} );

  var sun = new THREE.Mesh( sphere, basicMaterial );
  sun.scale.set(5, 5, 5);

  var light = new THREE.PointLight(0xffffff, 1.0);
  light.position.set(0, 0, 0);

  // Add it to the scene
  scene.add( sun );
  scene.add( light );

  var render = function () {
    requestAnimationFrame( render );

    if(animate) {
      sun.rotateY(5 * Math.PI / 180);
	  for(var i = 0; i < planetsList.length; i++){
			orbitOrigin(planetObjects[i], planetsList[i].speed, planetsList[i].distance);
	  }
    }
    renderer.render(scene, camera);
  };

  render();
}

//borrowed from my 336 homework
function orbitOrigin(object, speed, distance){
  var offset = object.position.length();
  var correction = .005;
  object.lookAt(new THREE.Vector3(0, 0, 0));
  object.translateZ(-distance);
  var q = new THREE.Quaternion().setFromAxisAngle(new THREE.Vector3(0, 1, 0), -speed * Math.PI / 180);
  var q2 = new THREE.Quaternion().copy(object.quaternion);
  object.quaternion.copy(q).multiply(q2);
  if(offset > distance) {
    object.translateZ(distance + correction);
  } else {
    object.translateZ(distance - correction);
  }
}