
// Savings account
public class Savings extends BankAccount{
	
	public Savings(String name, int accountNum, String password, Double balance) {
		// TODO Auto-generated constructor stub
		super(name, accountNum, password, balance);

	}
	// it will increase amount of your account by 5%
	public void endOfDayTransactions () {

		this.balance = this.balance * 1.05;
	}
	// It will require a fee of 0.5% of each withdrawal 
	public void withdrawal (double money) {

		double fee = money * 1.005;
		super.balance -= fee;

		}


}
