
public class Main {

	public static int[] selectionSort(int[] arr) {
		int i, j, min;
		int n = arr.length;
		int minimum;

		for (i = 0; i < n - 1; i++) {

			min = i;
			for (j = i + 1; j < n; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}

			}
			// first minimum element
			minimum = arr[min];
			arr[min] = arr[i];
			arr[i] = minimum;

		}
		return arr;
	}

	public static void printArray(int arr[]) {

		int n = arr.length;
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();

	}

	public static int[] bubbleSort(int[] arr) {
		int n = arr.length;
		int temp = 0;
		int i, j;
		for (i = 0; i < n; i++) {
			for (j = 1; j < (n - 1); j++) {
				if (arr[j - 1] > arr[j]) {
					temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
					
				}
			}
		}
		return arr;

	}
	public static void printBubble(int arr[]) {
          
        bubbleSort(arr);//sorting array elements using bubble sort  
        int i;
        for(i=0; i < arr.length; i++){  
              System.out.print(arr[i] + " ");
	}
	}
	
	public static int[] InsertionSort(int arr[]) {
		int n = arr.length;
		int i;
		for (i = 1; i < n; i++) {
			int key = arr[i];
			int j = i - 1;
			
			
			while (j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j = j - 1;
				
			}
			arr[j + 1] = key;
		}
		return arr;
	}
	public static void printInsertion(int arr[]) {
		int n = arr.length;
		int i;
		for (i = 0; i < n; i++) {
			System.out.println(arr[i] + " ");
			
			System.out.println();
		}
	}
	public static int[] mergeSort(int[] arr) {
		int mid = arr.length / 2;
		int i, j, k;
		int[] left, right;
		
		// stops splitting if the array is of size 1
		if (arr.length <= 1) {
			return arr; 
		}
		if (arr.length > 1) {
			// split the array in half
			// put 1 half into the left
		left = new int[mid];
		for (i = 0; i < mid; i++) {
			left[i] = arr[i];
		}
		// put 1 half into the right
		right = new int[arr.length-mid];
		for (i = 0; i < arr.length-mid; i++) {
			right[i] = arr[mid + i];
		}
		// recursion to split more 
		mergeSort(left);
		mergeSort(right);
		
		i = 0; // index position for the left array
		j = 0; // index position for the right array
		k = 0; // index position for the arr array
		
		//merge components back into the array
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				arr[k] = left[i];
				k++;
				i++;
			}
			else {
				arr[k] = right[j];
				k++;
				j++;
			}
		}
		// add in remaining component
		while (i < left.length) {
			arr[k] = left[i];
			k++;
			i++;
		}
		while (j < right.length) {
			arr[k] = right[j];
			k++;
			j++;
		}
		
		}
		return arr;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = { 64, 25, 12, 22, 11 };

		System.out.println("Selection sort array");
		long startTime = System.nanoTime();

		int[] ans = selectionSort(arr);
		long endTime =  System.nanoTime();

		printArray(ans);
		long timeElasped = endTime - startTime;
		System.out.println(timeElasped);
		
		System.out.println("Bubble sort array");

		startTime = System.nanoTime();
		ans = bubbleSort(arr);
		endTime =  System.nanoTime();

		printArray(ans);
		timeElasped = endTime - startTime;

		System.out.println();

		System.out.println(timeElasped);

		startTime = System.nanoTime();

		ans = InsertionSort(arr);
		endTime =  System.nanoTime();

		System.out.println("Insertion sort array");
		printArray(ans);
		timeElasped = endTime - startTime;

		System.out.println(timeElasped);
		
		int[] arr2 = { 64, 25, 12, 22, 11 };
		System.out.println("Merge sort array");

		startTime = System.nanoTime();

		ans = mergeSort(arr2);
		endTime =  System.nanoTime();

		printArray(ans);
		timeElasped = endTime - startTime;

		System.out.println(timeElasped);

	}

}
