import java.util.Scanner;
import java.lang.String;
public class Addition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
/*		int number1;
		int number2;
		int sum;
		
		System.out.println("Enter the first number: ");
		number1 = in.nextInt();
		System.out.println("Enter the second number: ");
		number2 = in.nextInt();
		
		sum = number1 + number2;
		System.out.printf("Sum is %d\n" , sum);
		System.out.println(sum);
*/
		String name;
		
		System.out.println("Enter your last name: ");
		
		name = in.nextLine();
		
		System.out.print("Your last name is ");
		System.out.print(name);
	}

}
