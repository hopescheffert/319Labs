//War.JS

var War =
{

	Model :
	{
		//create a card object
		//Ex. value="2", suit= "c" for 2 of Clubs
		makeCard : function(val, suit)
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
			//make a card with each rank and suit and push it to our deck
			for(var suit = 0; suit < this.suits.length; suit++)
			{

				for(var r = 0; r < this.rank.length; r++)
				{
					var c = new War.Model.makeCard(this.rank[r], this.suits[suit]);
					deck.push(c);
				}
			}
			return deck;
		},
		//shuffle cards
		shuffleCards : function(cards)
		{
			//shuffle 3 times
			for(var i = 0; i < 3; i++)
			{
				for(var j = 0; j < cards.length; j++)
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
		//deal half deck to computerHand and other half to playerHand
		dealPlayers : function(deck)
		{
			//arrays representing the cards in each player's hand
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
		//buttons
		quitButton : {id: "quitButton", type: "button", value: "Quit Game", onclick:""},
		layDownACard : {id: "layDownACard", type: "button", value: "Lay Down Your Card", onclick:""},
		warLayDownButton : {id: "warLayDownButton", type: "button", value: "Go To War!", onclick:""},
		//cards
		playerDeck : {id: "playerDeck", src: "back"},
		playerCard : {id: "playerCard", src: ""},
		computerDeck : {id: "computerDeck", src: "back"},
		computerCard : {id: "computerCard", src: ""},

	},

	Controller :
	{
		//onclick for quit button to end/restart the game
		quitButtonHandler : function()
		{
			alert("Sorry to see you go!");
			//restart/reset
			War.startGame();
			//hide the cards from game you just quit
			playerCard.style.display = "none";
			computerCard.style.display = "none";
		},
		//onclick for laying down a card
		layDownACardHandler: function(playerHand, computerHand, inWarMode)
		{
			//make sure button is lay down your card
			layDownACard.value = "Lay Down Your Card";

			//lay one card from hand face up at the same time
			if(playerHand.length == 0)
			{
				//in this case, the computer wins...game over
				alert("Sorry, you lose. Game is over, you ran out of cards!");
				War.Controller.quitButtonHandler();
			}
			if(computerHand.length == 0)
			{
				//in this case, the player wins...game over
				alert("YOU WIN! Game is over, they ran out of cards!")
				War.Controller.quitButtonHandler();
			}

			//in war mode, we call warLayDownButton to lay down first card facing down
			if(inWarMode)
			{
				//get the current cards that are in war
				playerLayUp = cardsInPlay[0];
				computerLayUp = cardsInPlay[1];
				//show war button, hide lay down card button
				warLayDownButton.style.display = "block";
				layDownACard.style.display = "none";
				//make the on click method of "War" button
				War.View["warLayDownButton"].onclick =
				"War.Controller.warLayDownButtonHandler(playerHand, playerLayUp, " +
					+ "computerHand, computerLayUp, cardsInPlay)";
				//wait for user to click next button
				return;
			}


			//PLAYER
			//get one card from deck lay face up
			playerLayUp = playerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(playerLayUp);

			//COMPUTER
			//get one card from deck lay face up
			computerLayUp = computerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(computerLayUp);


			//Player lay down card like normal
			//make sure the src is for the specified card
			War.View.playerCard.src = playerLayUp;
			//show on page
			War.Controller.layCard("pCard", War.View.playerCard);
			//Computer: repeat above
			War.View.computerCard.src = computerLayUp;
			War.Controller.layCard("cCard", War.View.computerCard);

			//COMPARISON
			//set pval and cval to the value of the cards so we can compare
			var pval = playerLayUp.val;
			var cval = computerLayUp.val;

			//now compare card values
			if(pval > cval)
			{
				//in this case, player wins this round and takes both cards
				//add the cards in play (those won) to players hand
				var len = cardsInPlay.length;
				for(var i = 0; i < len; i++)
				{
					playerHand.push(cardsInPlay.shift());
				}
				//show player they just won, set color so it sticks out
				document.getElementById("status").innerHTML = War.displayDivElement("You win this round!");
				document.getElementById("status").style.color = "green";
				//update the score
				War.Controller.getScore(playerHand, computerHand);

			}
			else if(pval < cval)
			{

				//in this case, computer wins this round and takes both cards
				//add the cards in play (those won) to computers hand
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					computerHand.push(cardsInPlay.shift());
				}
				//show player they just lost that round
				document.getElementById("status").innerHTML = War.displayDivElement("Darn, computer wins this round!");
				document.getElementById("status").style.color = "red";
				//update score
				War.Controller.getScore(playerHand, computerHand);

			}
			else //they match...Go to War!
			{
				//set condition
				warMode = true;
				//tell user they need to go to war
				document.getElementById("status").innerHTML = War.displayDivElement("This is war!");
				document.getElementById("status").style.color = "blue";

				//handle war with lay down card -in war mode-
				War.View["layDownACard"].onclick = War.Controller.layDownACardHandler(playerHand, computerHand, warMode);
			}

		},
		//lays both cards face down when user clicks the go to war button
		warLayDownButtonHandler : function(playerHand, playerLayUp, computerHand, computerLayUp, cardsInPlay)
		{
			//set the src attribute to a picture of the back of a card
			War.View.playerCard.src = "back";
			//lay card down
			War.Controller.layCard("pCard", War.View.playerCard);
			//makes sure to push these cards into cardsInPlay
			cardsInPlay.push(playerHand.shift());

			//set the src attribute to a picture of the back of a card
			War.View.computerCard.src = "back";
			//lay card down
			War.Controller.layCard("cCard", War.View.computerCard);
			//makes sure to push these cards into cardsInPlay
			cardsInPlay.push(computerHand.shift());

			//don't show war button, show lay down a card button
			warLayDownButton.style.display = "none";
			layDownACard.style.display = "block";
			layDownACard.value = "Go to War!";

		},
		//updates current score
		getScore : function(playerHand, computerHand)
		{
			//update player score and computer score
			playerScore.innerHTML = playerHand.length;
			computerScore.innerHTML = computerHand.length;

		},
		//shows the card in the id given (updates the view)
		layCard : function(id, cardDiv)
		{
			document.getElementById(id).innerHTML = War.displayCardElement(cardDiv);
		},


	},
	//called to start the program in the view
	run : function()
	{
		//create this array to keep track of cards in play
		cardsInPlay = [];
		War.startGame();
		War.attachHandlers();
		return War.displayAll();
	},
	//begin the game
	startGame : function()
	{
		//makes deck and shuffles the cards
		deck = War.Model.makeDeck();
		deck = War.Model.shuffleCards(deck);

		//deal cards
		War.Model.dealPlayers(deck);

		//display score to begin with (26, 26)
		War.Controller.getScore(playerHand, computerHand);

	},
	displayAll : function()
	{
		var s= "<br>";
		s += War.displayInputElement(War.View.layDownACard);
		s += War.displayWarButton(War.View.warLayDownButton);
		s += "<br>";
		s += "<br><h5>Your Deck</h5>";
		s += War.displayCardElement(War.View.playerDeck) + "				";
		s += "<div style='display: inline' id='pCard' height=102 width=73></div>";
		s += "<br><h5>Computer Deck</h5>";
		s += War.displayCardElement(War.View.computerDeck) + "				";
		s += "<div style='display: inline' id='cCard' height=102 width=73></div> <br>";
		s += War.displayInputElement(War.View.quitButton);
		return s;
	},
	//displaying card string
	displayCardElement : function (element)
	{
		//*****************************change "path" var to path of cards folder**********************
		var path = "/Users/hopescheffert/Documents/COMS319/WarGame/cards/";
		var s = "<img style='display: inline' ";
		s += " id=\"" + element.id + "\"";
		s += " src=" + path + element.src.toString() + ".gif";
		s += " height=102 width=73";
		s += " >";
		return s;

	},
	//displaying buttons string
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
	//displaying war button initailly -hidden-
	displayWarButton : function (element)
	{
		var s = "<input ";
		s += " id=\"" + element.id + "\"";
		s += " type=\"" + element.type + "\"";
		s += " value= \"" + element.value + "\"";
		s += " onclick= \"" + element.onclick + "\"";
		s += "hidden>";
		return s;

	},
	//writes to page to id "status"
	displayDivElement : function (message)
	{
		var s = "<br><div id='status'";
		s += " <h5><b>" + message + "<b></h5>";
		s += " </div><br>";
		return s;

	},
	//attaches button handlers
	attachHandlers : function()
	{
		War.View["quitButton"].onclick ="War.Controller.quitButtonHandler()";
		War.View["layDownACard"].onclick ="War.Controller.layDownACardHandler(playerHand, computerHand, false)";
		War.View["warLayDownButton"].onclick = "War.Controller.warLayDownButtonHandler(playerHand, "
			+ "playerLayUp, computerHand, computerLayUp, cardsInPlay)";
	}



} // end of War;
