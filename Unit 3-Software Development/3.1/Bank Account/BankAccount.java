
public abstract class BankAccount {
	// Declare variables 
private String name;
private int AccountNum;
private String password;
protected double balance;

// Set initial values with constructor
	public BankAccount (String Name, int AccountNum, String password, double balance){
		this.name = Name;
		this.AccountNum= AccountNum;
		this.password= password;
		this.balance = balance;
	}
	
	// Get the account number
	public int getAccount() {
		return this.AccountNum;
	}

	// Get the account's balance
	public double getBalance() { 
		return Math.round(this.balance * 100.00)/100.00;

	}
	// Get the account owner's name 
	public String getName() {
		return this.name;
	}
	// Get the password
	public String getPassword() {
		return this.password;
	}
	
	// abstracts for end of day Transactions (to be performed in super class) 
	public abstract void endOfDayTransactions();
	
	// abstracts for the withdrawal of cash
	public abstract void withdrawal(double money);
	
	// Add deposited amount into the balance
	public void deposit(double money) {
		this.balance += money;
	}
	
	
	


	}
	
