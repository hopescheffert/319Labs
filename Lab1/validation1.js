function validateForm()
{

	var correctpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png";
	var wrongpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png";
	var valid = true;

	//first name: only alphabetical or numeric chars
	fname = document.getElementById("fName");
	if(testAlphanumeric(fname, "Must be only alphabetical or numeric characters"))
	{
		showImg(correctpic, "Correct!", "firstp");
		setCookie("firstName", fname);
	}
	else
	{ 
		showImg(wrongpic, "Wrong!", "firstp");
		valid = false;
	}
	
	// last name: only alphabetical or numeric chars
	var lname = document.getElementById("lName");
	if(testAlphanumeric(lname, "Must be only alphabetical or numeric characters"))
	{
		showImg(correctpic, "Correct!",  "lastp");
		setCookie("lastName", lname);
	}
	else
	{
		showImg(wrongpic,"Wrong!", "lastp");
		valid = false;
	}

	//gender: required
	var gender = document.getElementById("gender");
	if(document.getElementById("gender").value == "selgender")
	{
		showImg(wrongpic,"Wrong!", "genderp");
		valid = false;
	}
	else
	{
		showImg(correctpic, "Correct!", "genderp"); 
		setCookie("gender", gender);

	}

	//state: select from all given list and save selected one to JSCookies
	var state = document.getElementById("state");
	if(document.getElementById("state").value == "selstate")
	{
		showImg(wrongpic, "Wrong!", "statep");
		valid = false;
	}
	else
	{
		showImg(correctpic, "Correct!",  "statep");
		setCookie("state", state);

	}
	
	if(valid)
	{
		
		return true;
		//TODO redirect 
	}
	else return false;
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
		return false;
	}
}

function showImg(src, alt, id)
{
	
	var img = document.getElementById(id);
	img.src = src;
	img.alt = alt;
	img.style.display = "inline";
	
}
	