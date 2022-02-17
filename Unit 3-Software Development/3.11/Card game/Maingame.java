import java.util.ArrayList;
import java.util.Scanner;

public class Maingame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


		// The next card in the deck. The user tries to predict whether this is higher or lower than the current card.
		int correctGuesses; // The number of correct predictions the user has made. At the end of the game, this will be the user's score. 
		ArrayList<Card> playerCards = new ArrayList<Card>();
		Account currAccount = new Account ("user", "pass", "yunseo", "ha", 100);
		double bet = 2.0;
		Account newaCCOUNT = play(currAccount, bet);
		
	}
	// end main()
	

	
	public static Account play(Account currAccount, double bet) {

		Scanner in = new Scanner(System.in);
		Deck deck = new Deck(); /* Get a new deck of cards, 
	    and store a reference to it in the variable, deck. */
		
		Card currentCard; //The current card, which the user sees. 
		
		Card nextCard;
		// define a sample account
		 
		// the next card will be higher, 'L' if the user predicts that it will be lower. 
		deck.deal(); // Shuffle the deck into a random order before starting the game. 

		currentCard = deck.deal();
		System.out.println("The first card is the " + currentCard);
		boolean deckempty = false;
		// while deck is not empty 
		do { // Loop ends when user's prediction is wrong. 
			/* Get the user's prediction, 'H' or 'L' (or 'h' or 'l'). */
			
			
			System.out.print("Will the next card be higher (H) or lower (L)? ");
			char guess = in.next().charAt(0); // The user's guess. 'H' if the user predicts that
			guess = Character.toUpperCase(guess);
		// it stops at here
			while (guess != 'H' && guess != 'L') {

				System.out.print("Please respond with H or L: ");
			
			guess = in.next().charAt(0);
			guess = Character.toUpperCase(guess);
			
			}
			
			
			/* Get the next card and show it to the user. */
			
			nextCard = deck.deal();
			System.out.println("The next card is " + nextCard);
			
			/* Check the user's prediction. */
			
			if (nextCard.getNum() == currentCard.getNum()) {
				System.out.println("The value is the same as the previous card.");
				// value stays same
			} 
			else if (nextCard.getNum() > currentCard.getNum()) {
				if (guess == 'H') {
					System.out.println("Your prediction was correct.");
					currAccount.addMoney(bet);

					// increase bank account by bet amount
					
				}
				else { 
						System.out.println("Your prediction was incorrect.");
						// decrease bank account by bet amount
						currAccount.removeMoney(bet);

					} 
			}
			 	else { // nextCard is lower
					if (guess == 'L') {
			 		System.out.println("Your prediction was correct.");
					// increase bank account by bet amount
					currAccount.addMoney(bet);

				}
					else {
						System.out.println("Your prediction was incorrect.");
						// decrease bank account by bet amount
						currAccount.removeMoney(bet);
					}
					
			}
			
			/* To set up for the next iteration of the loop, the nextCard becomes the currentCard,
			 * since the currentCard has to be the card that the user sees, and the nextCard will be
			 * set to the next card in the deck after the user makes his prediction. */
			
			// if bank account balance <= 0, break, set bank account to 0
				
				
			// if deck has no more cards, deckempty = true

			currentCard = nextCard;
			System.out.println();
			System.out.println("The card is " + currentCard);
			
		} while (deck.canYouDeal().equals(true) && currAccount.getBalance() > 0);
		
		System.out.println();
		System.out.println("The game is over.");
		return currAccount;
	
		
	}
}
// end class Maingame