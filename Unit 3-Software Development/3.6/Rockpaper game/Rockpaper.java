import java.io.*;
import java.util.Scanner;

public class Rockpaper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		// Declare variables
		int win = 0, lose = 0, draw = 0;

		// Run the try and catch
		try {
			// Read the text file named "Score"
			FileReader fr = new FileReader("Score.txt");
			BufferedReader br = new BufferedReader(fr);
			// Read the number of wins and initialize the variable
			String wins = br.readLine();
			// Read the number of draws and initialize the variable
			String draws = br.readLine();
			// Read the number of losses and initialize the variable
			String losses = br.readLine();

			// Display the player's results before running a new game
			System.out.println("Your previous record!");
			System.out.println("Number of wins: " + wins);
			System.out.println("Number of losses: " + losses);
			System.out.println("Number of draws: " + draws);

			// Close the BufferedReader
			br.close();

			System.out.println("Welcome to Rock Paper Scissors! You can pick one of the three.");

			// Repeat a loop for 3 rounds of game
			do {
				// Print the options for players to choose 
				System.out.println("1. Rock \t2. Paper\t3. Scissors");
				// Receive the choice from user and store it in the variable called choice
				int choice = in.nextInt();
				// Initialize the variable with the random number from 1 to 3
				int result = (int) Math.round(Math.random() * 2) + 1;
				// If choice from user is equal to result, increment the variable draw by 1
				if (choice == result) {
					System.out.println("It is a tie!");
					draw++;
				}
				// If the choice is less the result
				else if (choice < result) {
					// Check if the difference between choice and result is 1 
					if (result - choice == 1) {
						// If choice is rock, increment lose by 1 (result is paper)
						if (choice == 1) {
							System.out.println("Paper eats rock. You lose!");
							lose++;
						}
						// If the choice is not a rock, then it is paper (result is scissor) 
						else {
							System.out.println("Scissors cut the paper. You lose!");
							// Increment lose by 1
							lose++;
						}
					}
					// If difference between choice and result is 2, increment win by 1
					else {
						System.out.println("Rock crushes scissors. You win!");
						win++;
					}
				}
				// If the choice is greater than the result
				else {
					// If choice is 2 (paper), the result will be 1 (rock)
					if (choice == 2) {
						System.out.println("Paper eats rock. You win!");
						// Increment win by 1
						win++;
					}
					// If choice is not 2 (paper)
					else {
						// If the result is 1 (rock), choice is 3 (scissors) 
						if (result == 1) {
							System.out.println("Rock crushes scissors. You lose!");
							// Increment lose by 1
							lose++;
						}
						// If the choice is greater than 3 (scissors), print error message and increment lose by 1
						else if (choice > 3) {
							System.out.println("You put the wrong answer. You lose!");
							lose++;
						}
						// If the choice is equal to 3 (scissors), result is 2 (paper) and player wins
						else {
							System.out.println("Scissors cut the paper. You win!");
							win++;
						}
					}
				}
			} while ((draw + win + lose) != 3);
			
			// Write the file named "Score" 
			FileWriter fw = new FileWriter("Score.txt");
			PrintWriter pw = new PrintWriter(fw);

			pw.println(win); // writes the number of wins
			pw.println(draw); // writes the number of draws
			pw.println(lose); // writes the number of losses

			// Close the PrintWriter
			pw.close();
			System.out.println("You've set a new current score. ");

		} catch (IOException e) {

		}
	}
}
