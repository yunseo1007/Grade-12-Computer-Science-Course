// checking account
public class Chequing extends BankAccount{
	public Chequing(String Name, int AccountNum, String password, double balance) {
		super(Name, AccountNum, password, balance);
		// TODO Auto-generated constructor stub
	}
	
	// pay fee of $25 dollars at the end of day
	public void endOfDayTransactions (){
		this.balance-= 25;
			
		}
	
	// Override
	// if checking account - withdraw freely
	public void withdrawal(double money) {
		// TODO Auto-generated method stub
		
		this.balance-= money;
	}
	
}
