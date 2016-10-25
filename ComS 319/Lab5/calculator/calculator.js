// CALCULATOR.JS
//
//
//

// 
var Calc = {

Model : {
	isDecimal : false,
	storedVal : undefined,
	currentVal : 0,
	currentFunc : undefined,
	memory : 0
},


View : {
  textRow : {id: "textRow", type: "text", value: "0", onclick:""},
  button0 : {id: "button0", type: "button", value: 0, onclick:""},
  button1 : {id: "button1", type: "button", value: 1, onclick:""},
  button2 : {id: "button2", type: "button", value: 2, onclick:""},
  button3 : {id: "button3", type: "button", value: 3, onclick:""},
  button4 : {id: "button4", type: "button", value: 4, onclick:""},
  button5 : {id: "button5", type: "button", value: 5, onclick:""},
  button6 : {id: "button6", type: "button", value: 6, onclick:""},
  button7 : {id: "button7", type: "button", value: 7, onclick:""},
  button8 : {id: "button8", type: "button", value: 8, onclick:""},
  button9 : {id: "button9", type: "button", value: 9, onclick:""},
  buttonadd : {id: "buttonadd", type: "button", value: "+", onclick:""},
  buttonsub : {id: "buttonsub", type: "button", value: "-", onclick:""},
  buttonmult : {id: "buttonmult", type: "button", value: "*", onclick:""},
  buttondiv : {id: "buttondiv", type: "button", value: "/", onclick:""},
  buttoneql : {id: "buttoneql", type: "button", value: "=", onclick:""},
  buttondec : {id: "buttondec", type: "button", value: ".", onclick:""},
  buttonc : {id: "buttonc", type: "button", value: "C", onclick:""},
  buttonmr : {id: "buttonmr", type: "button", value: "MR", onclick:""},
  buttonmsub : {id: "buttonmsub", type: "button", value: "M-", onclick:""},
  buttonmadd : {id: "buttonmadd", type: "button", value: "M+", onclick:""}
},

Controller : {

	numberButtonHandler : function() {
  	var temp = arguments[0];
  
  	if(temp == '.' && !Calc.Model.isDecimal) {
			Calc.View.textRow.value = Calc.View.textRow.value + temp;
			Calc.Model.isDecimal = true;
		} 
		if (temp == 'c') {
			Calc.View.textRow.value = 0;
			Calc.Model.isDecimal = false;
		} 
		if (temp != 'c' && temp != '.') {
			if(Calc.Model.currentVal == "0") {
				Calc.View.textRow.value = "";
			}	
  			Calc.View.textRow.value = Calc.View.textRow.value + temp;
  	}
  	Calc.Model.currentVal = Calc.View.textRow.value;
  	document.getElementById("textRow").value = Calc.View.textRow.value;
	},
	
	operationButtonHandler : function() {
		var temp = arguments[0];
		
		if(temp == '=' && Calc.Model.currentFunc != undefined) {
			console.log(Calc.Model.currentFunc);
			if(Calc.Model.currentFunc == '+') {
				var add = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);
				Calc.Model.storedVal = Calc.Model.storedVal + add;
			} else if(Calc.Model.currentFunc == '-') {
				var sub = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);
				Calc.Model.storedVal = Calc.Model.storedVal - sub;
			} else if(Calc.Model.currentFunc == '*') {
				var mult = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);
				Calc.Model.storedVal = Calc.Model.storedVal * mult;
			} else if(Calc.Model.currentFunc == '/') {
				var div = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);;
				Calc.Model.storedVal = Calc.Model.storedVal / div;
			}
			Calc.View.textRow.value = Calc.Model.storedVal;
			document.getElementById("textRow").value = Calc.Model.storedVal;
		} else {
			Calc.Model.currentFunc = temp;
			if(Calc.Model.isDecimal == true) {
				Calc.Model.storedVal = parseFloat(Calc.View.textRow.value);
			} else {
				Calc.Model.storedVal = parseInt(Calc.View.textRow.value);
			}
			Calc.Model.currentVal = 0;
		}	
	},
	
	memoryButtonHandler : function(){
		var temp = arguments[0];
		
		if(temp == 'mr'){
			Calc.Model.currentVal = Calc.Model.memory;
			document.getElementById("textRow").value = Calc.Model.memory;
		} else if (temp == 'm+') {
			var plus = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);
			Calc.Model.memory = Calc.Model.memory + plus;	
		} else if (temp == 'm-') {
			var minus = Calc.Model.isDecimal ? parseFloat(Calc.Model.currentVal) : parseInt(Calc.Model.currentVal);
			Calc.Model.memory = Calc.Model.memory - minus;
		}
	}
},

run : function() {
  Calc.attachHandlers();
  return Calc.display();
},


displayElement : function (element) {
  var s = "<input ";
  s += " id=\"" + element.id + "\"";
  s += " type=\"" + element.type + "\"";
  s += " value= \"" + element.value + "\"";
  s += " onclick= \"" + element.onclick + "\"";
  if(element.type == "button" ) s += " class=calcButt";
  s += ">";
  return s;

},

display : function() {
  var s;
  s = "<table id=\"myTable\" border=2>"
  s += "<tr><td>" + Calc.displayElement(Calc.View.textRow) + "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button7);
  s += Calc.displayElement(Calc.View.button8);
  s += Calc.displayElement(Calc.View.button9);
  s += Calc.displayElement(Calc.View.buttonadd);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button4);
  s += Calc.displayElement(Calc.View.button5);
  s += Calc.displayElement(Calc.View.button6);
  s += Calc.displayElement(Calc.View.buttonsub);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button1);
  s += Calc.displayElement(Calc.View.button2);
  s += Calc.displayElement(Calc.View.button3);
  s += Calc.displayElement(Calc.View.buttonmult);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button0);
  s += Calc.displayElement(Calc.View.buttondec);
  s += Calc.displayElement(Calc.View.buttoneql);
  s += Calc.displayElement(Calc.View.buttondiv);
  s += "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.buttonc);
  s += Calc.displayElement(Calc.View.buttonmr);
  s += Calc.displayElement(Calc.View.buttonmsub);
  s += Calc.displayElement(Calc.View.buttonmadd);
  s += "</td></tr></table>";
  return s;
},

attachHandlers : function() {
  Calc.View.button7.onclick = "Calc.Controller.numberButtonHandler('7')";
  Calc.View.button8.onclick = "Calc.Controller.numberButtonHandler('8')";
  Calc.View.button9.onclick = "Calc.Controller.numberButtonHandler('9')"; 
  Calc.View.button4.onclick = "Calc.Controller.numberButtonHandler('4')";
  Calc.View.button5.onclick = "Calc.Controller.numberButtonHandler('5')"; 
  Calc.View.button6.onclick = "Calc.Controller.numberButtonHandler('6')";
  Calc.View.button1.onclick = "Calc.Controller.numberButtonHandler('1')"; 
  Calc.View.button2.onclick = "Calc.Controller.numberButtonHandler('2')"; 
  Calc.View.button3.onclick = "Calc.Controller.numberButtonHandler('3')";
  Calc.View.button0.onclick = "Calc.Controller.numberButtonHandler('0')";
  
  Calc.View.buttondec.onclick = "Calc.Controller.numberButtonHandler('.')";
  Calc.View.buttonc.onclick = "Calc.Controller.numberButtonHandler('c')";
  
  Calc.View.buttonadd.onclick = "Calc.Controller.operationButtonHandler('+')";
  Calc.View.buttonsub.onclick = "Calc.Controller.operationButtonHandler('-')";
  Calc.View.buttonmult.onclick = "Calc.Controller.operationButtonHandler('*')";
  Calc.View.buttondiv.onclick = "Calc.Controller.operationButtonHandler('/')";
  Calc.View.buttoneql.onclick = "Calc.Controller.operationButtonHandler('=')";
  
  Calc.View.buttonmr.onclick = "Calc.Controller.memoryButtonHandler('mr')";
  Calc.View.buttonmadd.onclick = "Calc.Controller.memoryButtonHandler('m+')";
  Calc.View.buttonmsub.onclick = "Calc.Controller.memoryButtonHandler('m-')";
},



} // end of Calc;
