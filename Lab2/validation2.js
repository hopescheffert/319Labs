function validate(){
	var email = document.getElementById("emailin").value; //document.forms["userinfo"]["email"].value;
	var phone = document.forms["userinfo"]["phone"].value;
	var address = document.forms["userinfo"]["address"].value;

	var emailValid = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;
	var phoneValid = /^[0-9]{3}(-)?[0-9]{3}(-)?[0-9]{4}$/;
	var stateValid = /^[a-z]{2}$/ig;
	var cityValid = /^[0-9a-zA-Z]+$/;
	
	
	
	var correctpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png";
	var wrongpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png";

	var valid = true;
	
	//check email
	if(!email.match(emailValid)){
		showImg(wrongpic, "Wrong!", "emailp");
		alert("Sorry, " + email + " is an invalid input. Please enter a valid email address.");
		valid = false;
		
	}
	else showImg(correctpic, "Correct!", "emailp");
	
	//check phone number
	if(!phone.match(phoneValid)){
		showImg(wrongpic, "Wrong!", "phonep");
		alert("Sorry, " + phone + " is an invalid input. Please enter a valid phone number.");
		valid = false;
	}
	else showImg(correctpic, "Correct!", "phonep");
	
	
	address = address.trim();
	var comma = address.indexOf(',');
	var city = address.slice(0, comma);
	var stateCode = address.substring(comma + 2, comma + 4);
	

	//check address must have city and state
	if(!city.match(cityValid)| !stateCode.match(stateValid))
	{
		showImg(wrongpic, "Wrong!", "addressp");
		alert("Sorry, " + address + " is an invalid input. Please enter a valid address (City, State Code)");
		valid = false;
	}
	else
	{
		showImg(correctpic, "Correct!", "addressp");
		//save to HTML local storage
		localStorage.setItem("address", address);
	}
	
	//go through cookies and delete each one
	var cookieString = document.cookie.split(';');
	for(var i = 0; i < cookieString.length; i++)
	{
		deleteCookie(cookieString[i]);
	}	
	
	
	
	if(valid)
	{
		setTimeout(function() { window.location.href= "lab2googlemap.html";}, 1000);

		return true;
		
	}

	return false;
}

function deleteCookie(name)
{
    document.cookie = name + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
};

function showImg(src, alt, id)
{
	
	var img = document.getElementById(id);
	img.src = src;
	img.alt = alt;
	img.style.display = "inline";
	
}