import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		// Declare variables
		String FName, LName, userName, name, password, pass, newUser, line, pick, result;
		int option = 0, valid = 0, guess, check;
		double balance, bet = 0, money, bet2 = 0, bet3 = 0;
		Boolean verified = false;
		Boolean isValid = true;

		// Create ArrayList of class Account for dynamic storage of the users' accounts
		ArrayList<Account> Accounts = new ArrayList<Account>();

		// Create a myGame object
		CardGame myGame = new CardGame();

		// Run the try and catch
		try {

			// Read the file named "accounts"
			FileReader fr = new FileReader("accounts.txt");
			BufferedReader br = new BufferedReader(fr);

			// Read the user's name
			line = br.readLine();

			// Read the file until there is no more line to read
			while (line != null) {

				// Set the name in first line as a variable called name
				name = line;

				// Read the user's password and set it as a variable called pass
				line = br.readLine();
				pass = line;

				// Read the user's first name and set it as a variable called FName
				line = br.readLine();
				FName = line;

				// Read the user's last name and set it as a variable called LName
				line = br.readLine();
				LName = line;

				// Read the user's balance
				line = br.readLine();

				// Change the string into double
				balance = Double.parseDouble(line);

				// Add account to the ArrayList named Accounts
				Accounts.add(new Account(name, pass, FName, LName, balance));

				// Read the next line
				line = br.readLine();
			}
			// Close the BufferedReader
			br.close();

			// Do while loop for getting a valid account
			// Repeat a loop until the user name is not equal to -1
			do {

				// Ask the user name
				System.out.println("Enter your user name: ");
				userName = in.next();

				// If the user name is equal to "00", ask for the new user name
				if (userName.equals("00")) {
					System.out.println("Enter your new user name: ");
					newUser = in.next(); // receive the new user name

					/*
					 * Iterates through the ArrayList of accounts to check whether the new user name
					 * is valid or not
					 */
					for (int i = 0; i < Accounts.size(); i++) {

						// Check if the new user name is equal to other existing user names or either
						// "00" or "-1"
						if (newUser.equals(Accounts.get(i).getUName()) || newUser.equals("-1")
								|| newUser.equals("00")) {

							// If new user name is invalid, set isValid as false
							isValid = false;
						}
					}
					// If the new user name is valid
					if (isValid == true) {

						// Ask new account's password
						System.out.println("Enter your password: ");
						password = in.next();

						// Ask new account's first name
						System.out.println("Enter your first name: ");
						FName = in.next();

						// Ask new account's last name
						System.out.println("Enter your last name: ");
						LName = in.next();

						// Ask the amount of money that a user wants to deposit into the new account
						System.out.println("Enter the amount of money you want to deposit: ");
						balance = in.nextDouble();

						// Add new account to the end of ArrayList
						Accounts.add(new Account(newUser, password, FName, LName, balance));

						// Set verified as true
						verified = true;

						// Get the index of the ArrayList Accounts, which is starting from 0
						valid = Accounts.size() - 1;

					} else {
						// Set variable verified as false (not available to open the main menu)
						verified = false;

						// Error message
						System.out.println("This is not an available user name.");

					}

				}
				// if the user name is not equal to "00"
				else {
					// Iterates through the ArrayList of accounts and finds the index of the
					// requested account
					for (int i = 0; i < Accounts.size(); i++) {

						// Check if the user name matches existing user names in the ArrayList of
						// accounts
						if (userName.equals(Accounts.get(i).getUName())) {

							// Ask the password
							System.out.println("Enter the password: ");
							password = in.next();

							// If password is equal to the existing password in the ArrayList
							if (password.equals(Accounts.get(i).getPassword())) {

								// Set verified as true
								verified = true;

								// Store the index of account that matches
								valid = i;

							} else {
								// Error message
								System.out.println("You entered a wrong password.");
							}
						}
					}
				}
				// Reset the value for next user
				isValid = true;

				// Repeat a loop while verified is true
				while (verified == true) {

					// Before entering the main menu, notify the users if they have a high roller account (more than $10000)
					Accounts.get(valid).IsHighRoller();
					if (Accounts.get(valid).getHighRoller()) {
						
						System.out.println("You have a high roller account");
					}

					// If not, the user is regular account
					else {

					}

					// Display the options for users to choose
					System.out.println("1. Dice");
					System.out.println("2. Roulette");
					System.out.println("3. High Low Card");
					System.out.println("4. Blackjack");
					System.out.println("5. Account information");
					System.out.println("6. Exit");
					option = in.nextInt();

					// If command is equal to 1
					if (option == 1) {
						// Get a bet amount and repeat the game while the balance is positive
						while (Accounts.get(valid).getBalance() > 0) {
							System.out.println("How much money do you want to bet?");
							bet = in.nextDouble();

							// Play the game only when the bet is valid
							// If the user input -1, end the game and return to the main menu
							if (bet == -1) {
								break;
							}

							/*
							 * Check if the user is a high roller and determine whether the bet is valid or
							 * not under the limit of 100 and 1000 for each regular and high-roller account
							 */

							else if (Accounts.get(valid).isValid(bet, 100, 1000) != true) {
								// Set the invalid bet as zero so the user cannot play this game
								bet = 0;
							}

							// Play the game
							else {
								// Initialize two dices that are random integers between 1 and 6
								int dice1 = (int) Math.random() * 5 + 1;
								int dice2 = (int) Math.random() * 5 + 1;

								// Ask user to guess the result
								System.out.println("Guess the sum of two dice!");
								int guess1 = in.nextInt();

								// If the guess is correct, increase bank account by double of bet
								if (guess1 == dice1 + dice2) {
									System.out.println("Congratulations, you guessed it right!");
									Accounts.get(valid).addMoney(2 * bet);
								}
								// If not, decrease bank account by bet amount
								else {
									System.out.println("You guessed it wrong.");
									Accounts.get(valid).removeMoney(bet);
								}
								
								// Notify the user the balance amount after each round of game
								System.out.println("Your balance is now: " + Accounts.get(valid).getBalance());
								
							}
						}

					}

					// If command is equal to 2
					else if (option == 2) {
						while (Accounts.get(valid).getBalance() > 0) {

							// Initialize integer variable called ball as random number from 1 to 36
							int ball = (int) Math.random() * 35 + 1;

							// Three games for roulette

							// Ask if the user wants to play first game
							System.out.println(
									"Do you want to guess which number from 1 to 36 where a ball will land on? "
											+ "Enter y for yes, n for no: ");
							String answer1 = in.next();

							// If the user wants to play a game
							if (answer1.equals("y")) {

								// Get a bet amount
								System.out.println("How much money do you want to bet?");
								bet = in.nextDouble();

								// Check if the bet is valid

								// Return to main menu if bet is -1
								if (bet == -1) {
									break;
								}
								// Ask for a bet that has limit of 100 or 1000 depending on the user's account
								// (regular or high-roller)
								else if (Accounts.get(valid).isValid(bet, 100, 1000) != true) {
									bet = 0;
								}
								// Error message
								else if (!answer1.equals("y") && !answer1.equals("n")) {
									System.out.println("You put the wrong answer");
								}
							}

							// Ask if the user wants to play the second game
							System.out.println("Do you want to guess odd or even number where a ball will land on? \t"
									+ "Enter y for yes, n for no: ");
							String answer2 = in.next();

							if (answer2.equals("y")) {

								// Get a second bet amount
								System.out.println("How much money do you want to bet?");
								bet2 = in.nextDouble();

								// Check if the bet is valid
								if (bet2 == -1) {
									break;
								}
								// Ask for a bet that has limit of 100 or 1000 depending on the user's account
								else if (Accounts.get(valid).isValid(bet2, 100, 1000) != true) {
									bet2 = 0;
								} else if (!answer2.equals("y") && !answer2.equals("n")) {
									System.out.println("You put the wrong answer");
								}

							}
							// Ask if the user wants to play a game
							System.out.println("Do you want to guess high or low? \t Enter y for yes, n for no: ");
							String answer3 = in.next();

							if (answer3.equals("y")) {

								// Get a third bet amount
								System.out.println("How much money do you want to bet?");
								bet3 = in.nextDouble();

								if (bet3 == -1) {
									break;
								} else if (Accounts.get(valid).isValid(bet3, 100, 1000) != true) {
									bet3 = 0;
								}

							} else if (!answer3.equals("y") && !answer3.equals("n")) {
								System.out.println("You put the wrong answer");
							}
							// 1 guess which number, get number, start game, if the input number = random
							// number, account balance + 36 * bet

							// If the answer for the first game is yes and bet is valid
							if (answer1.equals("y") && bet != 0) {
								System.out.println("Guess 1 number from 1 to 36 where a ball will land on! ");
								guess = in.nextInt();

								// If the guess is correct, increase the bank account by 36 times what the user
								// bet
								if (guess == ball) {
									System.out.println("Congratulations, you guessed it right!");
									Accounts.get(valid).addMoney(36 * bet);
								} else {
									System.out.println("You guessed it wrong.");
									Accounts.get(valid).removeMoney(bet);
								}

							}

							// If the answer for the second game is yes and bet is valid
							if (answer2.equals("y") && bet2 != 0) {
								System.out.println(
										"Guess whether the number where a ball will land on will be odd or even! (o for odd, e for even): ");
								pick = in.next();

								// Set result as e if the ball is an even number
								if ((ball % 2) == 0) {
									result = "e";
								}
								// Set result as o if the ball is an odd number
								else {
									result = "o";
								}
								// If the user's guess is correct, increase bank account by double of bet amount
								if (pick.equals(result)) {
									System.out.println("Congratulations, you guessed it right!");
									Accounts.get(valid).addMoney(2 * bet2);
								}
								// If not, decrease bank account by bet amount
								else {
									System.out.println("You guessed it wrong.");
									Accounts.get(valid).removeMoney(bet2);

								}
							}
							// If the answer for the third game is yes and bet is valid
							if (answer3.equals("y") && bet3 != 0) {

								// Explain the game rule
								System.out.println("Guess the number where a ball will land on will be high or low.");
								System.out.println(
										"Low number is from 1-18 and high number is from 19-36. \tEnter h for high, l for low: ");
								pick = in.next();

								// If the ball is the number between 1 to 18, set result as l
								if (ball >= 1 && ball < 19) {
									result = "l";
								}
								// If not, set result as h
								else {
									result = "h";
								}

								// If the user's guess is correct, increase the user's balance by double of bet
								// amount
								if (pick.equals(result)) {
									System.out.println("Congratulations, you guessed it right!");
									Accounts.get(valid).addMoney(2 * bet3);

								}
								// If not, decrease the user's balance by bet amount
								else {
									System.out.println("You guessed it wrong.");
									Accounts.get(valid).removeMoney(bet3);

								}
							}
							System.out.println("Your balance is now: " + Accounts.get(valid).getBalance());

						}

					}

					// If command is equal to 3
					else if (option == 3) {
						while (Accounts.get(valid).getBalance() > 0) {
							System.out.println("How much money do you want to bet? ");
							bet = in.nextDouble();

							if (bet == -1) {
								break;
							}
							// Ask for a bet that has limit of 10 or 100 depending on the user's account
							else if (Accounts.get(valid).isValid(bet, 10, 100) != true) {
								bet = 0;
							} else {
								// Explain the rule of game to user
								System.out.println("This program lets you play the simple card game.");
								System.out.println("A card is dealt from a deck of cards.");

								// Sets the account back into ArrayList of the accounts after the game
								Accounts.set(valid, myGame.play(Accounts.get(valid), bet));
								System.out.println("Your balance is now: " + Accounts.get(valid).getBalance());

							}

						}

					}
					// If command is equal to 4
					else if (option == 4) {
						while (Accounts.get(valid).getBalance() > 0) {

							System.out.println("How much money do you want to bet? ");
							bet = in.nextDouble();

							if (bet == -1) {
								break;
							} else if (Accounts.get(valid).isValid(bet, 10, 100) != true) {
								bet = 0;
							} else {
								// Call the blackjack() method (from the CardGame class) on the myGame object
								Accounts.set(valid, myGame.blackjack(Accounts.get(valid), bet));
								System.out.println("Your balance is now: " + Accounts.get(valid).getBalance());

							}

						}

					}
					// If command is equal to 5
					else if (option == 5) {

						// Repeat a loop until the input(check) prompted by user is not equal to 4
						do {
							// Print the options for users to choose
							System.out.println("1. Check Account Balance");
							System.out.println("2. Add Money");
							System.out.println("3. Take Money");
							System.out.println("4. Exit");
							check = in.nextInt(); // Receive the value prompted by user

							// If check is equal to 1, show the user's account balance
							if (check == 1) {
								System.out.println(Accounts.get(valid).getBalance());
							}
							// If check is equal to 2, add money prompted by user to the account
							else if (check == 2) {
								System.out.println("How much money do you want to input into the account?");
								money = in.nextDouble();
								Accounts.get(valid).addMoney(money);
							}
							// If check is equal to 3, remove money prompted by user from the account
							else if (check == 3) {
								System.out.println("How much money do you want to withdraw?");
								money = in.nextDouble();
								if (money <= Accounts.get(valid).getBalance()) {
									Accounts.get(valid).removeMoney(money);
								} else {
									System.out.println("You cannot withdraw more money than you have.");
								}
							}

						} while (check != 4);

					} else if (option == 6) {
						// Return to original menu asking user name by setting verified equal to false

						verified = false;
					}

				}
				// Set verified as false to go back to the original menu asking user name
				verified = false;
			} while (!userName.equals("-1"));

			// Write the file named "accounts"
			FileWriter fw = new FileWriter("accounts.txt");
			PrintWriter pw = new PrintWriter(fw);

			// Iterates the ArrayList of the accounts writes it into the file in order
			for (int i = 0; i < Accounts.size(); i++) {
				pw.println(Accounts.get(i).getUName()); // writes the username
				pw.println(Accounts.get(i).getPassword()); // writes the password
				pw.println(Accounts.get(i).getfName()); // writes the first name
				pw.println(Accounts.get(i).getlName()); // writes the last names
				pw.println(Accounts.get(i).getBalance()); // writes the balance
			}
			// Close the PrintWriter
			pw.close();

			// Notify the user that the program ended
			System.out.println("This is the end");

		} catch (IOException e) {

		}
	}

}