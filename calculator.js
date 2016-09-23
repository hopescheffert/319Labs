// CALCULATOR.JS
//
//
//

// 
var Calc = 
{

Model : 
{
	
},


View : 
{
  textRow : {id: "textRow", type: "text", value: "", onclick:""},
  
  button7 : {id: "button7", type: "button", value: 7, onclick:""},
  button8 : {id: "button8", type: "button", value: 8, onclick:""},
  button9 : {id: "button9", type: "button", value: 9, onclick:""},
  buttonplus : {id: "buttonplus", type: "button", value: "+", onclick:""},

  button4 : {id: "button4", type: "button", value: 4, onclick:""},
  button5 : {id: "button5", type: "button", value: 5, onclick:""},
  button6 : {id: "button6", type: "button", value: 6, onclick:""},
  buttonminus : {id: "buttonminus", type: "button", value: "-", onclick:""},

  
  button1 : {id: "button1", type: "button", value: 1, onclick:""},
  button2 : {id: "button2", type: "button", value: 2, onclick:""},
  button3 : {id: "button3", type: "button", value: 3, onclick:""},
  buttonmult : {id: "buttonmult", type: "button", value: "*", onclick:""},
  
  button0 : {id: "button0", type: "button", value: 0, onclick:""},
  buttondot : {id: "buttondot", type: "button", value: ".", onclick:""},
  buttonequals : {id: "buttonequals", type: "button", value: "=", onclick:""},
  buttondiv : {id: "buttondiv", type: "button", value: "/", onclick:""},
  
  
  buttonC : {id: "buttonC", type: "button", value: "C", onclick:""},
  buttonMR : {id: "buttonMR", type: "button", value: "MR", onclick:""},
  buttonM- : {id: "buttonM-", type: "button", value: "M-", onclick:""},
  buttonM+ : {id: "buttonM+", type: "button", value: "M+", onclick:""},
  
  buttonMC : {id: "buttonMC", type: "button", value: "MC", onclick:""}
  
  },

Controller : 
{
	//TODO buttonHandler : function(that) { }
	
	
	

},

run : function() 
{
  Calc.attachHandlers();
  console.log(Calc.display());
  return Calc.display();
},


displayElement : function (element) 
{
  var s = "<input ";
  s += " id=\"" + element.id + "\"";
  s += " type=\"" + element.type + "\"";
  s += " value= \"" + element.value + "\"";
  s += " onclick= \"" + element.onclick + "\"";
  s += ">";
  return s;

},

display : function() 
{
  var s;
  s = "<table id=\"myTable\" border=2>"
  s += "<tr><td>" + Calc.displayElement(Calc.View.textRow) + "</td></tr>";
  s += "<tr><td>";
  s += Calc.displayElement(Calc.View.button7);
  s += Calc.displayElement(Calc.View.button8);
  s += "</tr></td></table>";
  return s;
},

attachHandlers : function() 
{
	//TODO ATTACH HANDLER FOR EACH BUTTON HANDLER
  Calc.View.button7.onclick = "Calc.button7Handler()"; 
  Calc.View.button6.onclick = "Calc.button6Handler()";
  Calc.View.button5.onclick = "Calc.button5Handler()";
  Calc.View.button4.onclick = "Calc.button4Handler()";
  Calc.View.button3.onclick = "Calc.button3Handler()";
  Calc.View.button2.onclick = "Calc.button2Handler()";
  Calc.View.button1.onclick = "Calc.button1Handler()";
  Calc.View.button0.onclick = "Calc.button0Handler()";
  Calc.View.button8.onclick = "Calc.button8Handler()";
  Calc.View.buttonC.onclick = "Calc.buttonCHandler()";
  

},

//BUTTON HANDLER FOR EACH BUTTON


buttonCHandler : function()
{
	//clears screen value
	Calc.view.textView.value = "";
}

buttonPlusHandler : function()
{
	//TODO puts + on textView and adds whats before and after it
}

button0Handler : function()
{
	//TODO
}
button1Handler : function()
{
	//TODO
}
button2Handler : function()
{
	//TODO
}
button3Handler : function()
{
	//TODO
}
button4Handler : function()
{
	//TODO
}
button5Handler : function()
{
	//TODO
}
button6Handler : function()
{
	//TODO
}
button7Handler : function() 
{
  //TODO
}
button8Handler : function()
{
	//TODO
}
button9Handler : function()
{
	//TODO
}
buttonDivHandler : function()
{
	//TODO
}
buttonMultHandler : function()
{
	//TODO
}
buttonEqualsHandler : function()
{
	//TODO
}
buttonMRHandler : function()
{
	//TODO
}
buttonM-Handler : function()
{
	//TODO
}
buttonM+Handler : function()
{
	//TODO
}
buttonMCHandler : function()
{
	//TODO
}
buttonDotHandler : function()
{
	//TODO
}












} // end of Calc;
