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
		//buttons
		quitButton : {id: "quitButton", type: "button", value: "Quit Game", onclick:""},
		layDownACard : {id: "layDownACard", type: "button", value: "Lay Down Your Card", onclick:""},
		warLayDownButton : {id: "warLayDownButton", type: "button", value: "Go To War!", onclick:""},
		//cards
		playerDeck : {id: "playerDeck", src: "back"},
		playerCard : {id: "playerCard", src: ""},
		computerDeck : {id: "computerDeck", src: "back"},
		computerCard : {id: "computerCard", src: ""},

		//score
		playerScore : {id:"playerScore", value:"Player Score is: "},
		computerScore : {id:"computerScore", value:"Computer Score is: "},


	},

	Controller :
	{
		//onclick for quit button to end/restart the game
		quitButtonHandler : function()
		{
			alert("Sorry to see you go!");
			//restart/reset
			War.startGame();
			//hide the cards
			playerCard.style.display = "none";
			computerCard.style.display = "none";
		},
		//onclick for taking turn button aka laying down a card to be compared
		layDownACardHandler: function(playerHand, computerHand, inWarMode)
		{
			layDownACard.value = "Lay Down Your Card";


			console.log("***in warLayDownButton cardsInPlay is " + cardsInPlay);


			console.log("----in take turn---- and inWarMode is " + inWarMode);

			//lay one card from hand face up at the same time
			if(playerHand.length == 0)
			{
				//TODO in this case, the computer wins...game over
				alert("Sorry, you lose. Game is over, you ran out of cards!");
			}
			if(computerHand.length == 0)
			{
				//TODO in this case, the player wins...game over
				alert("YOU WIN! Game is over, they ran out of cards!")
			}

			//in war mode, we need to lay down our first card facing down
			//then call take turn again and lay face up
			if(inWarMode)
			{
				playerLayUp = cardsInPlay[0];
				computerLayUp = cardsInPlay[1];
				warLayDownButton.style.display = "block";
				layDownACard.style.display = "none";
				//make the on click method of "War" button
				War.View["warLayDownButton"].onclick =
				"War.Controller.warLayDownButtonHandler(playerHand, playerLayUp, " +
					+ "computerHand, computerLayUp, cardsInPlay)";
				return;
			}


			//PLAYER

			//get one card face up
			playerLayUp = playerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(playerLayUp);
			console.log("not war: player lay up is " + playerLayUp);

			//COMPUTER
			//get one card face up
			computerLayUp = computerHand.shift();
			//push to array cause the card is in play
			cardsInPlay.push(computerLayUp);
			console.log("not war: computer lay up is "  + computerLayUp);





			//lay down card FRONT like normal
			War.View.playerCard.src = playerLayUp;
			console.log(War.displayCardElement(War.View.playerCard));
			War.Controller.layCard("pCard", War.View.playerCard);

			War.View.computerCard.src = computerLayUp;
			console.log(War.displayCardElement(War.View.computerCard));
			War.Controller.layCard("cCard", War.View.computerCard);

			//COMPARISON

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
				//player wins this round and takes both cards
				console.log("cardsinplay is " + cardsInPlay);
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					playerHand.push(cardsInPlay.shift());
				}
				console.log("not war: player wins round..hand is " + playerHand);
				document.getElementById("status").innerHTML = War.displayDivElement("You win this round!");
				document.getElementById("status").style.color = "green";
				War.Controller.getScore(playerHand, computerHand);

			}
			else if(pval < cval)
			{

				//computer wins this round and takes both cards
				console.log("cardsinplay is " + cardsInPlay);
				var len = cardsInPlay.length;

				for(var i = 0; i < len; i++)
				{
					computerHand.push(cardsInPlay.shift());
				}
				console.log("not war: computer wins round..hand is " + computerHand);
				document.getElementById("status").innerHTML = War.displayDivElement("Computer wins this round");
				document.getElementById("status").style.color = "red";


				War.Controller.getScore(playerHand, computerHand);

			}
			else //they match...WAR
			{

				warMode = true;
				console.log("war needs to be called..cards in play is " + cardsInPlay);
				document.getElementById("status").innerHTML = War.displayDivElement("This is war!");
				document.getElementById("status").style.color = "blue";

				//handle war with take turn button in war mode
				War.View["layDownACard"].onclick = War.Controller.layDownACardHandler(playerHand, computerHand, warMode);
			}

		},
		warLayDownButtonHandler : function(playerHand, playerLayUp, computerHand, computerLayUp, cardsInPlay)
		{
			//lays both cards face down when user clicks the war button
			War.View.playerCard.src = "back";
			//lay card down
			War.Controller.layCard("pCard", War.View.playerCard);
			console.log("**in warlaydown playerCard is " + playerLayUp);
			//makes sure to push these cards into cardsInPlay
			cardsInPlay.push(playerHand.shift());

			//set src to back of card img
			War.View.computerCard.src = "back";
			//lay card down
			War.Controller.layCard("cCard", War.View.computerCard);
			console.log("**in warlaydown computerCard is " + computerLayUp);
			//makes sure to push these cards into cardsInPlay
			cardsInPlay.push(computerHand.shift());

			console.log("***in warLayDownButton cardsInPlay is " + cardsInPlay);

			//don't show war button, show lay down a card button
			warLayDownButton.style.display = "none";
			layDownACard.style.display = "block";
			layDownACard.value = "Go to War!";

		},
		getScore : function(playerHand, computerHand)
		{
			//update player score and computer score
			playerScore.innerHTML = playerHand.length;
			computerScore.innerHTML = computerHand.length;

		},
		layCard : function(id, cardDiv)
		{
			document.getElementById(id).innerHTML = War.displayCardElement(cardDiv);
		},


	},

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
		console.log("computerHand is " + computerHand);
		console.log("playerHand is " + playerHand);
		//TODO do we need to remove cards from deck?
		//display score to begin with
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
	//displaying card
	displayCardElement : function (element)
	{
		var s = "<img style='display: inline' ";
		s += " id=\"" + element.id + "\"";
		s += " src=/Users/hopescheffert/Documents/COMS319/WarGame/cards/" + element.src.toString() + ".gif";
		s += " height=102 width=73";
		s += " >";
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
	//displaying buttons
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

	displayDivElement : function (message)
	{
		var s = "<br><div id='status'";
		s += " <h5><b>" + message + "<b></h5>";
		s += " </div><br>";
		return s;

	},
	attachHandlers : function()
	{
		War.View["quitButton"].onclick ="War.Controller.quitButtonHandler()";
		War.View["layDownACard"].onclick ="War.Controller.layDownACardHandler(playerHand, computerHand, false)";
		War.View["warLayDownButton"].onclick = "War.Controller.warLayDownButtonHandler(playerHand, "
			+ "playerLayUp, computerHand, computerLayUp, cardsInPlay)";
	}



} // end of War;
