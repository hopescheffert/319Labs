//War.JS

var War = 
{

Model : 
{
	//http://www.brainjar.com/js/cards/default2.asp
	function Card(value, suit)
	{
		this.value = value;
		this.suit = suit;
	}
	function Deck()
	{
		// Jack = 11, Queen = 12, King = 13, Ace = 14
		this.names = ['2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14'];
		this.suits = ['Hearts', 'Diamonds', 'Spades', 'Clubs'];
		var deck = [];
		for(var suit = 0; s < this.suits.length; suits++)
		{
			for(var name = 0; n < this.names.length; names++)
			{
				deck.push(new Card(names + 1, this.names[name], this.suits[suit]));
				
			}
		}
		return deck;
	}

},


View: 
{
  startButton : {id: "startButton", type: "button", value: "Start", onclick:""},
  quitButton : {id: "quitButton", type: "button", value: "Quit", onclick:""},
  takeTurnButton : {id: "takeTurnButton", type: "button", value: "Lay Down A Card", onclick:""},

},

Controller: {
	buttonHandler : function(that) 
	{
		


	},
	shuffleCards : function()
	{
		
	}

},

run : function() {
  War.attachHandlers();
  console.log(War.displayAll());
  return War.displayAll();
},

displayAll : function() {
  var s;
  s = "<table id=\"myTable\" border=2>"
  s += "<tr><td>";
  s += War.displayElement(War.View.button1);
  s += "</td><td>";
  s += War.displayElement(War.View.button2);
  s += "</td><td>";
  s += War.displayElement(War.View.button3);
  s += "</td><td>";
  s += War.displayElement(War.View.button4);
  s += "</td></tr>";
  s += "<tr><td>";
  s += War.displayElement(War.View.button5);
  s += "</td><td>";
  s += War.displayElement(War.View.button6);
  s += "</td><td>";
  s += War.displayElement(War.View.button7);
  s += "</td><td>";
  s += War.displayElement(War.View.button8);
  s += "</td></tr>";
  s += "<tr><td colspan=\"4\">" + War.displayElement(War.View.label) + "</td></tr>";
  s += "</table>";
  return s;
},

displayElement : function (element) {
  var s = "<input ";
  s += " id=\"" + element.id + "\"";
  s += " type=\"" + element.type + "\"";
  s += " value= \"" + element.value + "\"";
  s += " onclick= \"" + element.onclick + "\"";
  s += ">";
  return s;

},

attachHandlers : function() 
{
   //TODO
},


} // end of War;



