import java.util.*;

public class Account {

	private String uName;
	private String password;
	private String fName;
	private String lName;
	private double Balance;

	public Account(String user, String password, String fName, String lName, double balance) {
		this.uName = user;
		this.password = password;
		this.fName = fName;
		this.lName = lName;
		this.Balance = balance;
	}

	public String getUName() {
		return this.uName;
	}

	public String getPassword() {
		return this.password;
	}

	public String getfName() {
		return this.fName;
	}

	public String getlName() {
		return this.lName;
	}

	public double getBalance() {
		return this.Balance;
	}

	public boolean IsHighRoller() {
		if (this.Balance >= 10000) {
			return true;
		} else {
			return false;
		}
	}

	public void addMoney(double money) {
		this.Balance += money;
	}

	public void removeMoney(double money) {
		this.Balance -= money;
	}

	public boolean isValid(double bet, double lowLimit, double HighLimit) {
		if (bet == -1) {
			return false;
		} else if (this.IsHighRoller() && bet > HighLimit) {

			System.out.println("You have a limit of $" + HighLimit + " per bet.");
			return false;
		} else if (!this.IsHighRoller() && bet > lowLimit) {
			System.out.println("You have a limit of $" + lowLimit + " per bet.");
			return false;
		} else if (bet > this.Balance) {
			System.out.println("You can't bet money below $0");
			return false;
		} else if (bet <= 0) {
			System.out.println("You can't bet $0 or money below $0");
			return false;
		}else {
			return true;
		}
	}
	public void setBalance(double amount) {
		this.Balance = amount;
	}
}

/*
 * public void getAccount(String userName) { this.uName = userName;
 * Accounts.add(this.uName); }
 * 
 * public boolean validID (String newName) {
 * 
 * for (int i = 0; i < Accounts.size(); i++) { if (newName == this.uName ||
 * newName.equals("00") || newName.equals("-1")) { invalid = i; } else { invalid
 * = -1; } } if (invalid == -1) { return true; } else { return false; } }
 */
