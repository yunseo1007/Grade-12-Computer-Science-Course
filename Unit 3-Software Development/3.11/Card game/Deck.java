
public class Deck {

	Card[] deck; // an array of deck
	
	public Deck () {
		// An array of 52 cards. The deck contains 52 cards. 
		deck = new Card[52];
		int num, suit; // Declare the variables that represent cards. 
		
		// Determine the cards in deck in random order
		for (num = 1; num <= 13; num++) {
			for (suit = 1; suit <= 4; suit++) {
				deck[(num - 1) * 4 + suit - 1] = new Card(num, suit);
			}
			
		}
		
		}
	public Card deal () {
		Card result; 
		//keep looping until the card is available to use
		do {
			result = this.deck[(int) (Math.random()* 51)];
		}while (result.isFaceUP());
		
		result.flip();
		
		return result; 
		}
	
	// Shuffle the cards in the deck into a random order
	public void reset () {
		int num, suit;
		
		for (num = 1; num <= 13; num++) {
			for (suit = 1; suit <= 4; suit++) {
				deck[(num-1) * 4 + (suit - 1)] = new Card(num, suit);
			}
		}
	}
	// determine the left card that user can use from the deck
	public Boolean canYouDeal() {
		Boolean result= false;
		int i;
		for (i = 0; i < deck.length; i++) {
			if(!this.deck[i].isFaceUP()) {
				result = true;
			} 
		}
		
		return result;

	}
}
