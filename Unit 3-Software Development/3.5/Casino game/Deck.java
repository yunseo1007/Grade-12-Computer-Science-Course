public class Deck {

	Card[] deck; // an array of deck

	public Deck() {
		// An array of 52 cards. The deck contains 52 cards.
		deck = new Card[52];
		
		// Declare the variables that represent cards.
		int num, suit; 

		// Determine the cards in deck in random order
		for (num = 1; num <= 13; num++) {
			for (suit = 1; suit <= 4; suit++) {
				deck[(num - 1) * 4 + suit - 1] = new Card(num, suit);
			}

		}

	}

	// Find the available card that is not dealt 
	public Card deal() {
		Card result;
		// Keep looping until the card is available to use
		do {
			result = this.deck[(int) (Math.random() * 52)];
		} while (result.isFaceUP());

		result.flip();

		return result;
	}

	// Shuffle the cards in the deck into a random order
	public void reset() {
		int num, suit;

		for (num = 1; num <= 13; num++) {
			for (suit = 1; suit <= 4; suit++) {
				deck[(num - 1) * 4 + (suit - 1)] = new Card(num, suit);
			}
		}
	}

	// Determine the left card that user can use from the deck
	public Boolean canYouDeal() {
		Boolean result1 = false;
		int i;
		for (i = 0; i < deck.length; i++) {
			if (!this.deck[i].isFaceUP()) {
				result1 = true;
			}
		}

		return result1;

	}
}
