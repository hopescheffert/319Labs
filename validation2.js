function validate(){
	var email = document.forms["userinfo"]["email"].value;
	var phone = document.forms["userinfo"]["phone"].value;
	var address = document.forms["userinfo"]["address"].value;

	var emailValid = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+\.[0-9a-zA-Z]+/;
	var phoneValid = /^[0-9]{3}(-)?[0-9]{3}(-)?[0-9]{4}$/;

	var valid = true;

	if(!email.match(emailValid)){
		alert("Sorry, " + email + " is an invalid input. Please enter a valid email address.");
		valid = false;
	}

	if(!phone.match(phoneValid)){
		alert("Sorry, " + phone + " is an invalid input. Please enter a valid phone number.");
		valid = false;
	}

	if(valid){
		alert("Your data has successfully been submitted:" +
		"\nPhone: " + phone +
		"\nEmail: " + email +
		"\nAddress: " + address
		);
		return true;
	}

	return false;
}
