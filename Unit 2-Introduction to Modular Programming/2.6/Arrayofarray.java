
public class Arrayofarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// int[][] classMarks = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
	/*	int i1,i2;
		for (i1 = 0; i1 < classMarks.length; i1++) {
			for (i2 = 0; i2 < classMarks[0].length; i2++) {
				classMarks[i1][i2] = 1;
				System.out.print(classMarks[i1][i2] + "\t");
			}
			System.out.println("\n");
			
		}
		
		
		int[][] RagArray = {{4,3,7}, {5,2}, {7,8,1,4}};
		
		int sum = 0;
		int row, col;
		
		for (row = 0; row <RagArray.length; row++) {
			for (col = 0; col < RagArray[row].length; col++) {
				sum = sum + RagArray[row][col];
			}
			System.out.println(sum);
			sum = 0;

		}
		
		
		
		
		
		
		// initialize an array 
		int [][] values = {{1,2}, {2,4}};
		
		// declare variables
		int i,j;
		
		// loop for printing all values in array 
		for (i = 0; i < values.length; i++) {
			for (j = 0; j < values[0].length; j++) {
			
				// print values in column separated by a blank space
				System.out.print(values[i][j] + " ");

			
			}
			// separate rows separated by a new line
			System.out.println("\n");
		}
		*/
		int a[][] = {{4,2,7}, {3,9,1}};
		int i,j;
		
		for (i = a[0].length - 1; i >= 0; i--) {
			for (j = a.length - 1; j >= 0; j--) {
				System.out.print(a[j][i]);
			}
			System.out.println("\n");
		}
	
	}

}