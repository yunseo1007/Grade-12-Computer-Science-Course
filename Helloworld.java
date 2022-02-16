
public class Helloworld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int number1 = 3;
		
		double a=0 , b=0, c =0;
		double positiveSum = 0;
		double negativeSum = 0;
		int zeroCount = 0;
		
		System.out.println("Enter any three numbers seperated by a space: ");
	//	a = input.nextDouble();
	//	b = input.nextDouble();
	//	c = input.nextDouble();
	
		
		if (a > 0) {
			positiveSum = positiveSum + a;
			System.out.println(positiveSum);

		}
		else if (a < 0) {
			negativeSum = negativeSum + a;
			System.out.println(negativeSum);

		}
		else if (a == 0) {
			zeroCount += 1;
			System.out.println(zeroCount);

		}



	}
	
}