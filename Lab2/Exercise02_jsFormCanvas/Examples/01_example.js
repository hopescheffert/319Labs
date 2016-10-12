// The purpose of this javascript file is to write a few simple methods


// Shows simple method
function addTwoNumbers(a,b) { 
	var number; // Note number is a LOCAL variable
  number = a+b; 
	alert('Sum of ' + a + "+" + b + " is: " + number);
}


// Method that returns a value
function subTwoNumbers(a,b) {
	var number; // Note number is a LOCAL variable
  number = a-b; 
  return number;
}

// Method that uses a condition and (returns an array)
function statsOfItems(myArray) {
   var i, min, max, sum;
   max = myArray[0];
   min = myArray[0];
   sum = 0;
   for (i=1; i < myArray.length; i++) {
     if (myArray[i] > max) { max = myArray[i]; } 
     if (myArray[i] < min) { min = myArray[i]; } 
     sum += myArray[i];
   }
   return [min, max, sum, sum/myArray.length];
}

