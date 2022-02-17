import java.util.*;

import com.sun.net.httpserver.Authenticator.Result;
public class Hand {

	private ArrayList<Card> hand; //stores and holds all cards
	public int handSize; // number of Cards in hand
	
	public Hand () {
		this.hand = new ArrayList();
	}
	// adds one single card to hand
	public void addCard (Card c) {
		this.hand.add(c);
		/*if (this.handSize < this.hand.length) {
			
		}
		//card dealt is added to array
		this.hand[handSize] = c;
		//increase Hand Size
		this.handSize++;\
		*/
	}
	public Card removeCard (int i) {
		Card result = null;
		if (i < this.hand.size()) {
			result = this.hand.remove(i);
		}
		return result;
	}
	public int getSize() {
		int result = this.hand.size();
		return result;
	}
	public String toString() {
	String result = "";
	int i;
	for (i = 0; i < this.hand.size(); i++) {
		result+= (i+1) + ". " + this.hand.get(i) + "\n";
	}
	return result;
	}
	public void emptyHand() {
		while (this.getSize()> 0) {
			this.removeCard(0);
		}
	}
}
