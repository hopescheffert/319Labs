//War.JS

//http://www.brainjar.com/js/cards/default2.asp

var War =
{

	Model :
	{
		//create a card object
		//Ex. value="2", suit= "c" for 2 of Clubs
		makeCard : function(val, suit)//, img)
		{
			this.val = val;
			this.suit = suit;
			this.toString   = War.Model.cardToString;
		},
		cardToString : function()
		{
			return this.val +  this.suit;
		},
		//create a deck of 52 cards
		makeDeck : function()
		{
			// Jack = 11, Queen = 12, King = 13, Ace = 14
			this.rank = [2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14];
			this.suits = ['h', 'd', 's', 'c'];

			var deck = [];
			for(var suit = 0; suit < this.suits.length; suit++)
			{

				for(var r = 0; r < this.rank.length; r++)
				{
					var c = new War.Model.makeCard(this.rank[r], this.suits[suit]);
					deck.push(c.toString());
				}
			}
			return deck;
		},
		//shuffle deck
		shuffleCards : function(cards)
		{
			//shuffle 3 times
			for(var i = 0; i < 2; i++)
			{
				//TODO FIX FROM TESTING go through cards and randomly switch around
				for(var j = 1; j < cards.length; j++)
				{
					var r = Math.floor(Math.random() * cards.length);
					var temp = cards[j];
					cards[j] = cards[r];
					cards[r] = temp;
				}
			}
			//returns shuffled cards

			return cards;
		},

		dealPlayers : function(deck)
		{
			playerHand = [];
			computerHand = [];

			//shuffle the deck first to ensure its randomly dealing cards
			deck = War.Model.shuffleCards(deck);
			var len = deck.length;
			for(var i = 0; i < len; i++)
			{
				if(i % 2 == 0)
				{
					//push one card to the hand
					playerHand.push(deck[i]);
				}
				else
				{
					computerHand.push(deck[i]);
				}

			}

		}

	},


	View :
	{
		startButton : {id: "startButton", type: "button", value: "Start Game", onclick:""},
		quitButton : {id: "quitButton", type: "button", value: "Quit Game", onclick:""},
		takeTurnButton : {id: "takeTurnButton", type: "button", value: "Lay Down A Card", onclick:""},
		playerDeck : {id: "playerDeck", src: "/Users/hopescheffert/Documents/COMS319/WarGame/cards/back.gif"},
		playerCardUp : {id: "playerCardUp", src: ""},
		computerDeck : {id: "computerDeck", src: "/Users/hopescheffert/Documents/COMS319/WarGame/cards/back.gif"},
		computerCardUp : {id: "computerCardUp", src: ""},

	},

	Controller :
	{
		//onclick for start button to begin the game
		startButtonHandler : function()
		{
			//makes deck and shuffles the cards
			deck = War.Model.makeDeck();
			deck = War.Model.shuffleCards(deck);

			//deal cards
			War.Model.dealPlayers(deck);
			console.log("computerHand is " + computerHand);
			console.log("playerHand is " + playerHand);
			//TODO do we need to remove cards from deck?
			//display score to begin with
			War.Controller.getScore(playerHand, computerHand);

		},
		//onclick for quit button to end/restart the game
		quitButtonHandler : function()
		{
			//TODO stops game...resets everything?
		},
		//onclick for taking turn button aka laying down a card to be compared
		takeTurnButtonHandler: function(playerHand, computerHand)
		{
			//lay one card from hand face up at the same time
			if(playerHand.length == 0)
			{
				//TODO in this case, the computer wins...game over
				alert("game is over, you ran out of cards!");
			}
			if(computerHand.length == 0)
			{
				//TODO in this case, the player wins...game over
				alert("game is over, they ran out of cards!")
			}

			//PLAYER
			var cardsInPlay = [];
			//lay one card face up
			var playerLayUp = playerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(playerLayUp);
			console.log("not war: player lay up is " + playerLayUp);


			//TODO display this card on the board?
			War.View["playerCardUp"].src = "/Users/hopescheffert/Documents/COMS319/WarGame/cards/" + playerLayUp + ".gif";
			var card = document.createElement("div");
			console.log(War.displayCardElement(playerCardUp));
			War.displayCardElement(playerCardUp);
		    //card.innerHTML = "<img src=/Users/hopescheffert/Documents/COMS319/WarGame/cards/" + playerLayUp + ".gif height=102 width=73</img>";

			//COMPUTER
			//lay one card face up
			var computerLayUp = computerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(computerLayUp);
			console.log("not war: computer lay up is "  + computerLayUp);
			//TODO display this card on the board?
			//computerCardUp = War.displayCardElement(computerLayUp);


			var pval = Number(playerLayUp.substring(0,1));
			if(pval == 1) pval = Number(playerLayUp.substring(0,2));
			var cval = Number(computerLayUp.substring(0,1));
			if(cval == 1) cval = Number(computerLayUp.substring(0,2));

			//TODO ***************** val is "undefined" ****************
			//temporary fix: substring
			console.log("player card up val: " + pval);
			console.log("computer card up val: " + cval);

			//these cards now need to be compared
			if(pval > cval)
			{
				//TODO player wins this round and takes both cards
				console.log("cardsinplay is " + cardsInPlay);
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					playerHand.push(cardsInPlay.shift());
				}
				console.log("not war: player wins round..hand is " + playerHand);

				War.Controller.getScore(playerHand, computerHand);

			}
			else if(pval < cval)
			{

				//TODO computer wins this round and takes both cards
				console.log("cardsinplay is " + cardsInPlay);
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					computerHand.push(cardsInPlay.shift());
				}
				console.log("not war: computer wins round..hand is " + computerHand);

				War.Controller.getScore(playerHand, computerHand);

			}
			else //they match...WAR
			{
				//TODO WAR
				console.log("war needs to be called..cards in play is " + cardsInPlay);
				War.Controller.war(playerHand, computerHand, cardsInPlay);
			}


		},
		war : function(playerHand, computerHand, cardsInPlay)
		{
			//in war: each player lays down one card face down and one card face up
			//check end cases
			if(playerHand.length == 0)
			{
				//TODO in this case, the computer wins...game over
				alert("game is over, you ran out of cards!");

			}
			else if(playerHand == 1)
			{
				//TODO in this case, they cannot layDown, just layUp

			}
			if(computerHand.length == 0)
			{
				//TODO in this case, the player wins...game over
				alert("game is over, they ran out of cards!");

			}
			else if(computerHand == 1)
			{
				//TODO in this case, they cannot layDown, just layUp
				//so call take turn button
				War.Controller.takeTurnButton(playerHand, computerHand);
			}

			//PLAYER
			//lay one card face down
			var playerLayDown = playerHand.shift();
			cardsInPlay.push(playerLayDown);
			console.log("war: player lay down is " + playerLayDown);

			//TODO display this card on the board?
			//playerCardDown = War.displayCardElement(playerLayDown);

			//lay one card face up
			var playerLayUp = playerHand.shift();
			cardsInPlay.push(playerLayUp);
			console.log("war: player lay up is " + playerLayUp);

			//TODO display this card on the board?
			//playerCardUp = War.displayCardElement(playerLayUp);

			//COMPUTER
			//lay one card face down
			var computerLayDown = computerHand.shift();
			cardsInPlay.push(computerLayDown);
			console.log("war: computer lay down is " + computerLayDown);

			//TODO display this card on the board?
			//computerCardDown = War.displayCardElement(computerLayDown);

			//lay one card face up
			var computerLayUp = computerHand.shift();
			cardsInPlay.push(computerLayUp);
			console.log("war: computer lay up is " + computerLayUp);

			//TODO display this card on the board?
			//computerCardUp = War.displayCardElement(computerLayUp);


			var pval = Number(playerLayUp.substring(0,1));
			if(pval == 1) pval = Number(playerLayUp.substring(0,2));
			var cval = Number(computerLayUp.substring(0,1));
			if(cval == 1) cval = Number(computerLayUp.substring(0,2));

			//this layUp card now needs to be compared with opponents layUp card
			if(pval > cval)
			{

				//TODO player wins this round and takes all cards from war
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					playerHand.push(cardsInPlay.shift());
				}
				console.log("war: player wins round with hand " + playerHand);

				console.log("cardsinplay is " + cardsInPlay);

				War.Controller.getScore(playerHand, computerHand);

			}
			else if(pval < cval)
			{

				//TODO computer wins this round and takes all cards from war
				var len = cardsInPlay.length;
				for(var i = 0; i < len; i++)
				{
					computerHand.push(cardsInPlay.shift());
				}
				console.log("war: computer wins round with hand " + computerHand);

				console.log("cardsinplay is " + cardsInPlay);

				War.Controller.getScore(playerHand, computerHand);

			}
			else
			{
				//TODO WAR
				console.log("war: war again");

				War.Controller.war(playerHand, computerHand, cardsInPlay);
			}



		},
		getScore : function(playerHand, computerHand)
		{
			//show player score and computer score
			document.getElementById("playerScore").innerHTML = playerHand.length;
			document.getElementById("computerScore").innerHTML = computerHand.length;

		}

	},

	run : function()
	{
		War.attachHandlers();
		console.log(War.displayAll());
		return War.displayAll();
	},

	displayAll : function()
	{
		var s= "<h1>Welcome to War!<h1>";
		s += War.displayInputElement(War.View.startButton);
		s+= "<br>";
		s += War.displayInputElement(War.View.takeTurnButton);
		s+= "<br>";
		s += War.displayInputElement(War.View.quitButton);
		s+= "<br>";
		s += War.displayCardElement(War.View.playerDeck);
		// s += War.displayCardElement(War.View.playerCardUp);
		return s;
	},
	//displaying card
	displayCardElement : function (element)
	{
		var s = "<br><br><img ";
		s += " id=\"" + element.id + "\"";
		//TODO why wont it show other elements with diff cards 
		s += " src=/Users/hopescheffert/Documents/COMS319/WarGame/cards/back.gif";
		s += " height=102 width=73 align='left'";
		s += ">";
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
	// displayDivElement : function (element, playerHand, computerHand)
	// {
	// 	var s = "<div ";
	// 	s += " id=\"" + element.id;
	// 	s += " value=Your Score: \"" + this.playerHand.length + " cards <br>" +
	// 								"Computer Score:  " + this.computerHand.length + " cards <br>" + element.value + "\"";
	// 	s += "</div>";
	// 	return s;
	//
	// },

	attachHandlers : function()
	{
		War.View["startButton"].onclick ="War.Controller.startButtonHandler()";
		War.View["quitButton"].onclick ="War.Controller.quitButtonHandler()";
		War.View["takeTurnButton"].onclick ="War.Controller.takeTurnButtonHandler(playerHand, computerHand)";
	}



} // end of War;
