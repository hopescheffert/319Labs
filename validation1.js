<script>


function validateForm()
{
	//first name: only alphabetical or numeric chars
	var fname = document.getElementById("fName");
	if(testAlphanumeric(fname, "Must be only alphabetical or numeric characters"));
	{
		createImageElement("correct.png", 100, 100, "fName");
	}
	else
	{
		createImageElement("wrong.png", 100, 100, "fName");

	}
	setCookie("firstName", fname);
	
	//last name: only alphabetical or numeric chars
	var lname = document.getElementById("lName");
	if(testAlphanumeric(lname, "Must be only alphabetical or numeric characters"));
	{
		createImageElement("correct.png", 100, 100, "lName");
	}
	else
	{
		createImageElement("wrong.png", 100, 100, "lName");

	}
	setCookie("lastName", lname);

	//gender: required
	var gender = document.getElementById("gender");
	if(gender.checked == true)
	{
		createImageElement("correct.png", 100, 100, "gender"); 
	}
	else
	{
		createImageElement("wrong.png", 100, 100, "gender");
	}
	setCookie("gender", gender);

	//state: select from all given list and save selected one to JSCookies
	var state = document.getElementById("state");
	if(state.checked == true)
	{
		createImageElement("correct.png", 100, 100, "state"); 
	}
	else
	{
		createImageElement("wrong.png", 100, 100, "state");
	}
	setCookie("state", state);
		
}

function setCookie(cname, cvalue) 
{
    var d = new Date();
    d.setTime(d.getTime() + (30*24*60*60*1000));
    var expires = "expires="+ d.toUTCString();
    document.cookie = cname + "=" + cvalue + "; " + expires;
}

function testAlphanumeric(inputtext, alertMsg)
{
	var alphaExp = /^[0-9a-zA-Z]+$/;
	if(inputtext.value.match(alphaExp))
	{
		return true;
	}
	else
	{
	document.getElementById('p5').innerText = alertMsg;
	inputtext.focus();
	return false;
}

function createImageElement(src, width, height, id)
{
	document.createElement("IMG");
	img.src = src;
	img.width = width;
	img.height = height;
	document.getElementById(id).appendChild(img);
}








</script>