import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		// Declare variables 
		int accountNum;
		int option = 0;
		String password;
		boolean check = false;
		boolean reset = false;
		double money;
		int chosenAcc = 0;
		
		BankAccount myBankAccount = null;
		
		String name[] = {"Brian Grishnin", "Yunseo Ha", "Shalrah Sultana"};
		int AccountNum[] = {1010, 2005, 3100};
		String Password[] = {"ninhsirg", "ah", "anatlus"};
		Double balance[] = {250.00, 275.50, 300.05};
		int index =0;
		
		BankAccount[] accounts = new BankAccount[3];
		accounts[0] = new Chequing("Brian Grishnin", 1010, "ninhsirg", 250.00);
		accounts[1] = new Savings("Yunseo Ha", 2005, "ah", 275.50);
		accounts[2] = new Chequing("Shalrah Sultana", 3100, "anatlus", 300.05);
		
		// Loop until the option chosen by user is equal to -1
		do {
			// Loop while the password is correct 
		do {
		
		System.out.println("Enter your account number you are searching for: ");
		accountNum = in.nextInt();
		
		// Check to confirm if it matches the account number 
		int i;
		for (i = 0; i < 3; i++) {
			if (accountNum == accounts[i].getAccount()) {

				System.out.println("Enter your account's password: ");
				password = in.next();
				// Check to confirm password matches
				if (password.equals(accounts[i].getPassword())) {
					check = true;
					chosenAcc = i;
				}
			} 
			
		}
		
		} while (check == false && option != 4);
		// check == true
		
		if (index == 1) {
			myBankAccount = new Savings(name[index],AccountNum[index],Password[index],balance[index]);
		} else {
			myBankAccount = new Chequing(name[index],AccountNum[index],Password[index],balance[index]);
		}
		
		do {
			System.out.println("1. Chack Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Logout");
			option = in.nextInt();
		
		if (option == 1) {
			System.out.println("Your balance is in bank account: $" + myBankAccount.getBalance()); 
			reset = false;
			
		} else if (option == 2) {
			System.out.println("How much money you want to withdraw?");
			money = in.nextDouble();
			//accounts[chosenAcc].withdrawal(money);
			myBankAccount.withdrawal(money);
			reset = false;
		} else if (option == 3) {
			System.out.println("How much money you want to deposit?");
			money = in.nextDouble();
			
			myBankAccount.deposit(money);
			reset = false;
			
		} else if (option == 4) {
			balance[index] = myBankAccount.getBalance();
			reset = true;
		}
		} while (reset != true);
		reset = false;
		} while (option != -1); // Exit
		
		for (int i = 0; i < 3; i++) {
			myBankAccount.endOfDayTransactions();
			System.out.println(myBankAccount.getBalance());
		}
		}
		
  	}


