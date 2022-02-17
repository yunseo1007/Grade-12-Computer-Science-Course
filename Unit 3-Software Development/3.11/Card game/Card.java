
public class Card implements Comparable<Card> {
	private int num; // 1 = ace, 11 = Jack, 12 = Queen, 13 = King
	private int suit; // 1 = Diamond, 2 = Club, 3 = Heart, 4 = Spade
	private Boolean isFaceUP;

// Creates a card with specified suit and value.
public Card(int num, int suit) {
	this.num = num;
	this.suit = suit;
	this.isFaceUP = false;
}
/*Creates a Joker, with 1 as the associated value.
 "new Card()" is equivalent to "new Card(1,Card.4)".*/
public Card() {
	this.suit = 4;
	this.num = 1;
}

public String Card(int theNum, int theSuit) {
	String result = "";
	if (theSuit != 1 && theSuit != 2 && theSuit != 3 && theSuit != 4 && theSuit != 5) {
		result = "Illigal playing card suit";
	}
	if (theSuit != 5 && (theNum < 1 || theNum > 13)) {
		result = "Illigal playing card suit";
	}
	return result;
}

//Returns the number of this card
public int getNum() {
	return this.num;
}
//Returns the suit of this card 
public int getSuit() {
	return this.suit;
}
//Returns a Boolean to check if the card is face up
public Boolean isFaceUP() {
	return this.isFaceUP;
}
public void flip() {
	 this.isFaceUP = !this.isFaceUP;

}
//Returns a String representation of this 
public String toString() {
	
	String result = "";

	
	if (this.isFaceUP) {
	//result += this.num + " of " + this.suit;
		
	// get the number
	// 1 = ace, 11 = Jack, 12 = Queen, 13 = King
		if(this.num == 1) {
			result += "ace";
		}else if (this.num == 11) {
			result += "Jack";
		}else if (this.num == 12) {
			result += "Queen";
		}else if (this.num == 13) {
			result += "King";
		}
		else {
			result += this.num;
		}
		
	// get the suit
	// 1 = Diamond, 2 = Club, 3 = Heart, 4 = Spade
		switch(this.suit) {
		case 1:
			result += " of Diamonds";
			break;
		
		case 2:
			result += " of Clubs";
			break;
			
		case 3:
			result += " of Hearts";
			break;
		
		case 4: 
			result += " of Spades";
			break;
			
		case 5:
			result += "Joker";
			
		
		default:
			
		}
		
	}else {
		result += "This card is face down.";
	}
	
	return result;
}
@Override
public int compareTo(Card o) {
	// TODO Auto-generated method stub
	int result = this.num - o.num;
	if (result == 0) {
		result = this.suit - o.suit;
	}
	return result;
}

}