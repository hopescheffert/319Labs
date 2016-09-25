//War.JS

//http://www.brainjar.com/js/cards/default2.asp

var War =
{

	Model :
	{
		//create a card object
		//Ex. value="2", suit= "Clubs", img= "2c" for 2 of Clubs with the 2 of clubs image
		makeCard : function(val, suit)//,img)
		{

			this.val = val;
			this.suit = suit;
			//this.img = img;	//"<img id='" + this.img + "' src='/Users/hopescheffert/Documents/COMS319/WarGame/cards/" +this.img+ ".gif'</img>";
		},
		//create a deck of 52 cards
		makeDeck : function()
		{
			// Jack = 11, Queen = 12, King = 13, Ace = 14
			this.names = ['2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14'];
			this.suits = ['h', 'd', 's', 'c'];

			var deck = [];
			for(var suit = 0; suit < this.suits.length; suit++)
			{
				for(var name = 0; name < this.names.length; name++)
				{
					deck.push(War.Model.makeCard(this.names[name], this.suits[suit])); //this.suits[suit]));//, name+this.suits[suit]);
					//this.deck.push(War.Model.makeCard(name + 2, this.suits[suit])); //, name+this.suits[suit]));
				}

			}

			console.log("in makeDeck deck is " + deck);
			return deck;
		},
		//shuffle deck
		shuffleCards : function(cards)
		{
			//shuffle 3 times
			for(var i = 0; i < 3; i++)
			{
				//go through cards and randomly switch around
				for(var j = 0; j < cards.length; j++)
				{
					var r = Math.floor(Math.random() * cards.length);
					var temp = cards[j];
					cards[j] = cards[r];
					cards[r] = temp;
				}
			}
			//returns shuffled cards
			console.log("in shuffleCards" + cards);
			return cards;
		},

		dealPlayer : function(deck)
		{
			this.hand = [];
			//shuffle the deck first to ensure its randomly dealing cards
			deck = War.Model.shuffleCards(deck);
			console.log("in dealPlayer deck is " + deck);
			for(var i = 0; i < deck.length/2; i++)
			{
				//push one card to the hand
				this.hand.push(deck[i]);
				//remove that card from the deck
				deck.shift();
			}
			//returns one player's hand, also will decrement the deck by 26 cards after called once
			return this.hand;
		}

	},


	View :
	{
		startButton : {id: "startButton", type: "button", value: "Start Game", onclick:""},
		quitButton : {id: "quitButton", type: "button", value: "Quit Game", onclick:""},
		takeTurnButton : {id: "takeTurnButton", type: "button", value: "Lay Down A Card", onclick:""},
		score : {id: "score", value: ""},
		playerCardDown : {id: "playerCardDown", src: "/Users/hopescheffert/Documents/COMS319/WarGame/cards/back.gif"},
		playerCardUp : {id: "playerCardUp", src: ""},
	},

	Controller :
	{
		//onclick for start button to begin the game
		startButtonHandler : function()
		{
			console.log("in startButtonHandler");
			//makes deck and shuffles the cards
			deck = War.Model.makeDeck();
			deck = War.Model.shuffleCards(deck);
			//deal computer 26 cards
			computerHand = [];
			computerHand = War.Model.dealPlayer(deck);
			//deal player 26 cards
			playerHand = [];
			playerHand = War.Model.dealPlayer(deck);
			console.log("playerHand is " + playerHand);
			//display score to begin with
			War.Controller.getScore(playerHand, computerHand);

		},
		//onclick for quit button to end/restart the game
		quitButtonHandler : function()
		{
			//TODO stops game...resets everything?
		},
		//onclick for taking turn button aka laying down a card...to be compared
		takeTurnButtonHandler: function(hand)
		{
			//lay one card from hand face down, the other face up.
			if(hand.length < 0)
			{
				//TODO in this case, the opponent wins...game over
				console.log("game is over");
			}
			//lay one card face down
			var layDown = hand.shift();
			console.log("lay down is " + layDown);
			//TODO display this card on the board?
			playerCardDown = War.displayCardElement(layDown);
			//lay one card face up
			var layUp = hand.shift();
			//TODO display this card on the board?
			playerCardUp = War.displayCardElement(layUp);

			//this layUp card now needs to be compared with opponents layUp card
			// if(hand.layUp.value > computerHand.layUp.value)
			// {
			//     //TODO player wins this round and takes all four cards
			//
			// }
			// else if(hand.layUp.value < computerHand.layUp.value)
			// {
			//     //TODO computer wins this round and takes all four cards
			// }
			// else
			// {
			//     //TODO WAR (call takeTurnHandler again?)
			// }


		},
		getScore : function(playerHand, computerHand)
		{
			//show player score and computer score
			War.View["score"].value = "Your Score: " + playerHand.length + " cards <br>" +
			"Computer Score:  " + computerHand.length + " cards <br>";

		}

	},

	run : function()
	{
		War.attachHandlers();
		return War.displayAll();
	},

	displayAll : function()
	{
		var s= "<h1>Welcome to War!<h1>";
		s += War.displayDivElement(War.View.score);
		s += "<br>";
		s += War.displayInputElement(War.View.startButton);
		s+= "<br>";
		s += War.displayInputElement(War.View.takeTurnButton);
		s+= "<br>";
		s += War.displayInputElement(War.View.quitButton);
		s+= "<br>";
		return s;
	},
	//displaying card
	displayCardElement : function (card)
	{
		var s = "<img ";
		s += " id=\"" + card.val +card.suit + "\"";
		s += " src=/Users/hopescheffert/Documents/COMS319/WarGame/cards/\"" + card.img + "\"";
		s += " height=102 width=73";
		s += "</img>";
		return s;

	},
	//displaying buttons
	displayInputElement : function (element)
	{
		var s = "<input ";
		s += " id=\"" + element.id + "\"";
		s += " type=\"" + element.type + "\"";
		s += " value= \"" + element.value + "\"";
		s += " onclick= \"" + element.onclick + "\"";
		s += ">";
		return s;

	},
	//displaying a div element: SCORE
	displayDivElement : function (element)
	{
		var s = "<div ";
		s += " id=\"" + element.id + "\"";
		s += " value= \"" + element.value + "\"";
		s += ">";
		return s;

	},

	attachHandlers : function()
	{
		War.View["startButton"].onclick ="War.Controller.startButtonHandler()";
		War.View["quitButton"].onclick ="War.Controller.quitButtonHandler()";
		War.View["takeTurnButton"].onclick ="War.Controller.takeTurnButtonHandler(playerHand)";
		War.View["score"].value = "War.Controller.getScore(playerHand, computerHand)";
	}



} // end of War;
