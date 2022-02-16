
public class Loop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*int n = 0;
		
		while (n != 0) {
			n--;
			System.out.println(n);
		}
		// it sets condition first
		n = 4;
		
		do {
		n--;
		System.out.println(n);
		}while(n!=0);
		//it will print out at least one 
		
		int i;
		int length = 5;
		
		for (i = 1; i <= length; i++) {
			System.out.println(i);
		}
		//for loop, we know how long the loop will be.
		// while loop, we can't predict, it repeats until the condition is wrong.
	*/
		/*int n = 1;
		while (n != 5) {
			n++;
			System.out.println(n);
		}
		
		int i = 0;
		
		do {
			i++;
			System.out.println(i);
		} while (i != 3);
		*/
//		int a;
//		int length = 10;
//		for (a = 0; a <= length; a+=2) {
//			System.out.println(a);
//		}
		
		int i1,i2, product;
		for (i1 = 1; i1 < 20; i1++) {
			for (i2 = 1; i2 < 20; i2++) {
			product = i1 * i2;
			System.out.print(product + "\t");
			}
			//for nested loop, we run a inside for loop first in order.
			System.out.print(" \n");
		}
		
	}
	

}
