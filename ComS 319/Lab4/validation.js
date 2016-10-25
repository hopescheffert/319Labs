document.onload = function(){i
	if(document.URL.contains("?")){
		console.log("test");
		submitted();
	}}
	

function validate(){
	var name = document.forms["userinfo"]["name"].value;
	var address = document.forms["userinfo"]["address"].value;
	var email = document.forms["userinfo"]["email"].value;
	var phone = document.forms["userinfo"]["phone"].value;
	
	var nameRegex = /^[0-9a-zA-Z ]+$/;
	var emailRegex = /^[0-9a-zA-Z]+@[0-9a-zA-Z]+\.[0-9a-zA-Z]+/;
	var phoneRegex = /^[0-9]{3}(-)?[0-9]{3}(-)?[0-9]{4}$/;
	
	var valid = true;
	
	if(!name.match(nameRegex)){
		alert("Sorry, " + name + " is an invalid input. Your name must consist of only letters and numbers.");
		valid = false;
	}
	
	if(!email.match(emailRegex)){
		alert("Sorry, " + email + " is an invalid input. Please enter a valid email address.");
		valid = false;
	}
	
	if(!phone.match(phoneRegex)){
		alert("Sorry, " + phone + " is an invalid input. Please enter a valid phone number.");
		valid = false;
	}
	
	if(valid){
		alert("Your data has successfully been submitted:" + 
		"\nName: " + name +
		"\nGender: " + document.forms["userinfo"]["gender"].value +
		"\nAddress: " + address +
		"\nEmail: " + email +
		"\nPhone: " + phone
		);
		return true;
	}

	return false;
}