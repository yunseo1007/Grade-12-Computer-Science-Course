import java.util.Scanner;
public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner (System.in);

		
		// variables for the code
		int i;
		int counter = 0;
		int sum = 0;
		int marks = 0;
		
		// initialize the array
		int[] studentScore = new int[15];
		
		do {
			System.out.println("Enter the scores out of 10 on the test or negative to break: ");
			marks = input.nextInt();
			// enters any number that is not a negative
			// if number is negative, loop will stop. 
			if (marks < 0) {
				break;
			}
			else if (marks > 10) {
				System.out.println("Score must be out of 10 ");

			}
			else {
				studentScore[marks]++;
				counter++;
				//counts total of scores
				sum+= marks;
			}
		} while (marks >=0);
		System.out.println("Score\t# of Occurances");
		// prints all scores and occurrences when the input is negative
		for (i = 0; i< 10; i++) {
			//prints all score
			System.out.println(i + "\t" + studentScore[i]);
		}
		System.out.println("The mean score is " + (sum/counter));
	}
}