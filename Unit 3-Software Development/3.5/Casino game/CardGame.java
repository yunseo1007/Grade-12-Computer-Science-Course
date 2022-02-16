import java.util.ArrayList;
import java.util.Scanner;

public class CardGame {

	Scanner in = new Scanner(System.in);

	// Get a new deck of cards, and store a reference to it in the variable, deck
	Deck deck = new Deck();

	// The current card, which the user sees
	Card currentCard;

	/*
	 * The next card in the deck. The user tries to predict whether this is higher
	 * or lower than the current card.
	 */
	Card nextCard;

	// Create ArrayList of Card for dynamic storage of player cards and dealer cards
	ArrayList<Card> playerCards = new ArrayList<Card>();
	ArrayList<Card> dealerCards = new ArrayList<Card>();

	// Declare variables
	private int playerScore, dealerScore;
	String ans;
	Card playerCard;
	Card dealerCard;
	int counter;
	boolean blackjack = false;

	// Run the High Low Card game
	public Account play(Account currAccount, double bet) {

		// Shuffle the deck into a random order before starting the game
		deck.reset();
		
		// Set the currentCard as one of the available cards from the deck
		currentCard = deck.deal();

		// Explain the rule of high low card game to the user
		System.out.println("You need to guess if the next card will be higher or lower until you go through all "
				+ deck.deck.length + " cards.");
		System.out.println();

		
		// Display the first card to the user
		System.out.println("The first card is the " + currentCard);

		// Count the number of cards that have been used
		counter = 1;

		// Repeat a loop while deck is not empty and the player's balance is positive
		do {
			// Keep incrementing counter by 1 as the loop starts
			counter++;

			/*
			 * 'H' if the user predicts that the next card will be higher, 'L' if the user
			 * predicts that it will be lower
			 */
			System.out.println("Will the next card be higher (H) or lower (L)? ");
			System.out.println("Enter O if you want to exit the game");

			// Get the user's prediction, 'H' or 'L' (or 'h' or 'l')
			char guess = in.next().charAt(0);
			guess = Character.toUpperCase(guess);

			// Ask for the user's guess and print error message until it matches either H or L
			while (guess != 'H' && guess != 'L' && guess != 'O') {
				System.out.print("Please respond with H or L: ");
				guess = in.next().charAt(0);
				guess = Character.toUpperCase(guess);

			}
			// If the user input 'O', return to the main menu
			if (guess == 'O') {
				break;
			}

			// Get the next card and show it to the user
			nextCard = deck.deal();
			System.out.println("The next card is " + nextCard);

			// Check the user's prediction

			// If the next card is equal to current card in value
			if (nextCard.getNum() == currentCard.getNum()) {
				// Value stays same
				System.out.println("The value is the same as the previous card.");

			}

			// If the next card is higher than current card in value
			else if (nextCard.getNum() > currentCard.getNum()) {

				// If the user guessed correctly, add initial bet amount to account balance
				if (guess == 'H') {
					System.out.println("Your prediction was correct.");
					currAccount.addMoney(bet);

				}
				// If not, subtract initial bet amount from the account balance
				else {
					System.out.println("Your prediction was incorrect.");
					currAccount.removeMoney(bet);

				}
			}

			// If the next card is lower than current card in value
			else {
				// If the user guessed correctly, add initial bet amount to account balance
				if (guess == 'L') {
					System.out.println("Your prediction was correct.");
					currAccount.addMoney(bet);

				}
				// If not, subtract initial bet amount from the account balance
				else {
					System.out.println("Your prediction was incorrect.");
					currAccount.removeMoney(bet);
				}

			}

			// To set up for the next iteration of the loop, set nextCard as currentCard
			currentCard = nextCard;

			System.out.println();

			// Notify the users that the number of cards that are dealt
			System.out.println("Card " + counter);

		} while (deck.canYouDeal() && currAccount.getBalance() > 0);

		System.out.println();
		System.out.println("The game is over.");

		// Return the player's account that has been changed
		return currAccount;

	}

	// Run the Blackjack game
	public Account blackjack(Account currAccount, double bet) {

		// return the account instead of working with method from the account class
		/*
		 * Set the cards for player and dealer as one of the available cards from the
		 * deck and display them to the user
		 */
		playerCard = deck.deal();
		System.out.println("The first card is the " + playerCard);

		dealerCard = deck.deal();
		System.out.println("The first card for the dealer is the " + dealerCard);

		// Add each card to the ArrayList of playerCards and ArrayList of dealerCards
		playerCards.add(playerCard);
		dealerCards.add(dealerCard);

		// Score of the player and dealer will be the first index of the ArrayList in value
		playerScore = playerCards.get(0).getNum();
		dealerScore = dealerCards.get(0).getNum();

		// Initialize integer variable counter as 0
		int counter = 0;

		/*
		 * Repeat the game until the player does not want another card or either
		 * playerScore or dealerScore is higher than 21
		 */
		do {
			// Ask if the user want another card
			System.out.println("Do you want another card? (y for yes, n for no)");
			ans = in.next();

			// If the user said yes, deal out card to both player and dealer and update their score
			if (ans.equals("y")) {

				nextCard = deck.deal();
				System.out.println("The card is the " + nextCard);

				// Add card to the ArrayList of playerCards
				playerCards.add(nextCard);

				nextCard = deck.deal();
				System.out.println("Dealer card is the " + nextCard);

				// Add card to the ArrayList of dealerCards
				dealerCards.add(nextCard);

				// Increment counter by 1 for each time they get a new card
				counter++;

				// Increment their score by their new cards in value
				playerScore += playerCards.get(counter).getNum();
				dealerScore += dealerCards.get(counter).getNum();

			}
			// Display both player score and dealer score
			System.out.println("Player score: " + playerScore);
			System.out.println("Dealer score: " + dealerScore);

			// To set up for the next iteration of the loop, set nextCard as currentCard
			currentCard = nextCard;

		} while ((ans.equals("y")) && playerScore < 21 && dealerScore < 21);

		// Iterates through the ArrayList of the playerCards to find if the user has an ace
		for (int i = 0; i < playerCards.size(); i++) {
			// If the user has an ace
			if (playerCards.get(i).getNum() == 1) {
				/*
				 * Iterates through the ArrayList of the playerCards to find if the user has one
				 * of the two black Jacks (Clubs and Spades)
				 */
				for (int j = 0; j < playerCards.size(); j++) {
					if ((playerCards.get(j).getSuit() == 2 || playerCards.get(j).getSuit() == 4)
							&& (playerCards.get(j).getNum() == 11)) {
						// Set blackjack as true only if the user has both ace and one of the two black Jacks
						blackjack = true;
					} else {
						blackjack = false;
					}
				}
			} else {
				blackjack = false;
			}
		}
		// Compare the scores between player and dealer

		// If player score > 21, subtract bet amount from the account balance
		if (playerScore > 21) {
			System.out.println("Sorry, you lose!");
			currAccount.removeMoney(bet);

		}
		// If player has blackjack card, player wins double of what they bet
		else if (blackjack) {
			System.out.println("Blackjack!");
			currAccount.addMoney(bet * 2);

		}
		// If dealerScore is higher than 21, add bet amount to account balance
		else if (dealerScore > 21) {
			System.out.println("Congratulations, you win!");
			currAccount.addMoney(bet);
		}
		// If playerScore is closer to 21 than dealerScore or hits 21 but less than 21,
		// player wins
		else if ((21 - playerScore) < (21 - dealerScore) || (playerScore == 21)) {
			System.out.println("Congratulations, you win!");

			// Add bet amount to account balance
			currAccount.addMoney(bet);

		}
		// If dealerScore is closer to 21 than playerScore or hits 21 but less than 21,
		// dealer wins
		else if ((21 - playerScore) > (21 - dealerScore) || (dealerScore == 21) || (playerScore > 21)) {
			System.out.println("Sorry, you lose!");
			// Subtract bet amount from the account balance
			currAccount.removeMoney(bet);

		}
		// Reset the ArrayList to play the game again
		playerCards.clear();
		dealerCards.clear();

		return currAccount;

	}

}
