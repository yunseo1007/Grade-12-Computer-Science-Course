import java.io.*;
import java.util.Scanner;

public class Database {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		// Declare variables
		int option, total = 0, available = 0;
		boolean check = false;
		
		// Run the try and catch
		try {
		
		// Read the file named "grades" 
		FileReader fr = new FileReader("grades.txt");
		BufferedReader br = new BufferedReader(fr);
		
		// Declare the array of students' names and grades
		String [] names = new String[10];
		int [] grades = new int[10];
		// Declare the variable
		String line;

		// Iterates through the students' names and grades in file and stores them in each array 
		for (int i = 0; i < 10; i ++) {
			// Read student's name
			line = br.readLine(); 
			// Store it inside the array
			names[i] = line; 
			// Read student's grade
			line = br.readLine();
			// Change the string into integer and store it into the array
			grades[i] = Integer.parseInt(line);
		}
		// Close the BufferedReader
		br.close();
		
		// Repeat a loop until the input(option) prompted by user is equal to 4
		do {
			
			// Print the options for users(teachers) to choose
			System.out.println("1. See Class and Grades");
			System.out.println("2. See Average");
			System.out.println("3. Change Student Grade");
			System.out.println("4. Close");
			option = in.nextInt(); // Receive the command from user
			
			// If command is equal to 1
			if (option == 1) {
				
				// Iterates through the each array of names and grades and prints each one  
				for (int i = 0; i < 10; i ++) {
					System.out.print("Name " + names[i]);
					System.out.println("\tGrade " + grades[i]);
				}
			} 
			// If command is equal to 2
			else if (option == 2) {
				
				// Adds all the marks of each student and calculates the average grade of the class
				for (int i = 0; i < 10; i++) {
					// Initialize variable store as the grades of each student
					int score = grades[i];
					// Total all the grades 
					total += score;
				}
				// Calculate and print average
				double average = total / 10.0;
				System.out.println("The class average is: " + average);
				
			} 
			// If command is equal to 3
			else if (option == 3) {
				// Ask user to input the students name to change the grade
				System.out.println("Enter student's name: ");
				String name = in.next(); // Receive the name 
				
				int i;

				// Iterates through the array of names and finds index of the name 
				for (i = 0; i < 10; i++) {
					
					// Check if the student's name spelled correctly
					if (name.equals(names[i])) {
						// Returns true if the name is found 
						check = true; 
						available = i; 
					} 
					
				}
				// If student's name is found, ask the student's new grade
				if (check == true) {
					
					System.out.println("Enter new student's grade: ");
					int grade = in.nextInt(); // Receive the new grade
					
					// Replace the value of the student's grade with new grade
					grades[available] = grade;
				
				} else {
					// Error message
					System.out.println("There is no student who has that name.");

				}
			}

		} while (option != 4);
		
		System.out.println("The program has ended.");
		
		// Write the file named "grades" 
		FileWriter fw = new FileWriter("grades.txt");
		PrintWriter pw = new PrintWriter(fw);

		// Iterates the array of each course and grade and writes it into the file in order 
		for (int i = 0; i < 10; i++) {
			pw.println(names[i]); // writes the names

			pw.println(grades[i]); // writes the altered grades

		}
		// Close the PrintWriter
		pw.close();

		}catch(IOException e) {
			
		}
	}

}
