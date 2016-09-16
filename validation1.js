function validateForm()
{
	//first name: only alphabetical or numeric chars
	var fname = document.getElementById("fName");
	console.log("hello");
	if(testAlphanumeric(fname, "Must be only alphabetical or numeric characters"))
	{
		//document.write("okay");
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png", "Correct!", 40, 40, "fName");
	}
	else
	{ 
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png", "Wrong!", 40, 40, "fName");

	}
	setCookie("firstName", fname);
	
	//last name: only alphabetical or numeric chars
	var lname = document.getElementById("lName");
	if(testAlphanumeric(lname, "Must be only alphabetical or numeric characters"))
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png","Correct!", 100, 100, "lName");
	}
	else
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png","Wrong!", 100, 100, "lName");
	}
	setCookie("lastName", lname);

	//gender: required
	var gender = document.getElementById("gender");
	if(gender.checked == true)
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png","Correct!", 100, 100, "gender"); 
	}
	else
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png","Wrong!", 100, 100, "gender");
	}
	setCookie("gender", gender);

	//state: select from all given list and save selected one to JSCookies
	var state = document.getElementById("state");
	if(state.checked == true)
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png","Correct!", 100, 100, "state"); 
	}
	else
	{
		createImageElement("/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png","Wrong!", 100, 100, "state");
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
		alert(alertMsg);
		//document.getElementById("fName").innerText = alertMsg;
		//inputtext.focus();
		return false;
	}
}

function createImageElement(src, alt, width, height, id)
{
	document.createElement("img");
	img.src = src;
	img.alt = alt;
	img.width = width;
	img.height = height;
	document.getElementById(id).appendChild(img);
}