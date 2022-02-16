public class Account {

	// Declare the variables
	private String uName;
	private String password;
	private String fName;
	private String lName;
	private double Balance;
	private boolean highRoller = false;

	// Set initial values with constructor
	public Account(String user, String password, String fName, String lName, double balance) {
		this.uName = user;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.Balance = balance;
	}

	// Get the username of the account
	public String getUName() {
		return this.uName;
	}

	// Get the password of the account
	public String getPassword() {
		return this.password;
	}

	// Get the first name of the account
	public String getfName() {
		return this.fName;
	}

	// Get the last name of the account
	public String getlName() {
		return this.lName;
	}

	// Get the balance of the account
	public double getBalance() {
		return this.Balance;
	}
	
	// Get the value of high roller to check if the user is high roller
	public boolean getHighRoller() {
		return this.highRoller;
	}
	
	
	// Check if the user has a high-roller account
	public boolean IsHighRoller() {
		if (this.Balance >= 10000) {
			return true;
		} else {
			return false;
		}
	}

	// Add money to the balance of the account
	public void addMoney(double money) {
		this.Balance += money;
	}

	// Remove money from the balance of the account
	public void removeMoney(double money) {
		this.Balance -= money;
	}

	// To find whether the bet prompted by the user is valid or not
	public boolean isValid(double bet, double lowLimit, double HighLimit) {

		// Invalid if the bet is equal to -1
		if (bet == -1) {
			return false;
		}
		// Invalid if the user is high roller and the bet exceeds their limit
		else if (this.highRoller && bet > HighLimit) {

			System.out.println("You have a limit of $" + HighLimit + " per bet.");
			return false;

		}
		// Invalid if the user has regular account and bet exceeds their limit
		else if (!this.highRoller && bet > lowLimit) {
			System.out.println("You have a limit of $" + lowLimit + " per bet.");
			return false;
		}
		// Invalid if their bet is higher than their balance
		else if (bet > this.Balance) {
			System.out.println("You can't bet more money than you have");
			return false;
		}
		// Invalid if their bet is equal to zero or negative
		else if (bet <= 0) {
			System.out.println("You can't bet $0 or money below $0");
			return false;
		}
		// Otherwise the bet is valid
		else {
			return true;
		}
	}

}