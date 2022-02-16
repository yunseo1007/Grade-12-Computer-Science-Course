import java.util.Scanner;
public class Repetition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner (System.in);
		
		// Declare the variable
		int total = 0;
		
		// repeat loop for 10 times 
		for (int i = 1; i <= 10; i++) {
			total = total + i;
		}
		// prints the total of numbers 1 up to 10
		System.out.println(total);

		}
		}
