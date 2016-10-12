function validate(){
	var email = document.forms["userinfo"]["email"].value;
	var phone = document.forms["userinfo"]["phone"].value;
	var address = document.forms["userinfo"]["address"].value;

	var emailValid = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+\.[0-9a-zA-Z]+/;
	var phoneValid = /^[0-9]{3}(-)?[0-9]{3}(-)?[0-9]{4}$/;
	var addressValid = /^[A-Za-z]+,[ ]?[A-Za-z]+\{2,}$/;
	var alphaNumericValid = /^[0-9a-zA-Z]+$/;
	
	
	
	var correctpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/correct.png";
	var wrongpic = "/Users/hopescheffert/Documents/COMS319/Lab2/Exercise02_jsFormCanvas/wrong.png";

	var valid = true;

	if(!email.match(emailValid)){
		showImg(wrongpic, "Wrong!", "emailp");
		alert("Sorry, " + email + " is an invalid input. Please enter a valid email address.");
		valid = false;
		
	}
	else showImg(correctpic, "Correct!", "emailp");
	
	if(!phone.match(phoneValid)){
		showImg(wrongpic, "Wrong!", "phonep");
		alert("Sorry, " + phone + " is an invalid input. Please enter a valid phone number.");
		valid = false;
	}
	else showImg(correctpic, "Correct!", "phonep");
	
	
	// address = address.trim();
// 	var comma = address.indexOf(',');
// 	var city = address.slice(0, comma);
// 	var stateCode = address.substring(comma + 2, comma + 4);
	

	
	//must have city and state
	if(!address.match(addressValid))
	{
		showImg(wrongpic, "Wrong!", "emailp");
		alert("Sorry, " + address + " is an invalid input. Please enter a valid address (City, State Code)");
		valid = false;
	}
	else showImg(correctpic, "Correct!", "addressp");
		
	if(valid)
	{
		return true;
	}

	return false;
}

function showImg(src, alt, id)
{
	
	var img = document.getElementById(id);
	img.src = src;
	img.alt = alt;
	img.style.display = "inline";
	
}