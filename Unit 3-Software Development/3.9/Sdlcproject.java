import java.util.Scanner;

public class Sdlcproject {	
	
	// Create a printCourses() method and add parameters called record, studentNumber, and i
	public static void printCourses(int[][] record, int studentNumber, int i) {

		/* Create switch case method to print the courses that the selected student is taking 
		 followed by the student's number*/
			switch (record[studentNumber-1][i]) {

			case 1:
				System.out.print("English ");
				break;

			case 2:
				System.out.print("Math ");
				break;

			case 3:
				System.out.print("Physics ");
				break;

			case 4:
				System.out.print("Biology ");
				break;

			case 5:
				System.out.print("Chemistry ");
				break;

			case 6:
				System.out.print("Computer Science ");
				break;

			case 7:
				System.out.print("Law ");
				break;

			case 8:
				System.out.print("History ");
				break;

			case 9:
				System.out.print("Gym ");
				break;

			case 10:
				System.out.print("Business ");
				break;

			case 11:
				System.out.print("Music ");
				break;

			default:

			}
		}
	
	// Create a names() method and add a parameter called studentNumber
	public static void names(int studentNumber) {
		
		// Create an array called names which stores students' names 
		String[] names = { "Faye Hogan", "Khadeeja Robins", "Aya Schaefer", "Roza Odling", "Mya Livingston",
				"Uma Brady", "Alfie Lee", "Rodger Xu", "Joanna Fray", "Dora Casey" };
		// print out the students' names depending on the student number prompted by user with the index (studentNumber - 1)
		System.out.println("Student name: " + names[studentNumber - 1]); 
	}

	//main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		//declare variables 
		int studentNumber, select, indexCourse, i, newGrade;
		
		// Create an array called records which stores the number of courses and grades for all students
		// 10 rows (students' numbers) and 12 columns (courses and grades)
		/* 12 columns for each row: numbers in odd position(1,3,5,9,11,13) are index number of the courses,
		numbers in even position(2,4,6,8,10,12) are grades */

		int[][] records = { { 1, 62, 6, 74, 5, 69, 2, 55, 7, 56, 10, 53 },
				{ 1, 93, 8, 59, 2, 58, 10, 98, 11, 72, 4, 86 }, { 1, 60, 11, 77, 3, 99, 5, 50, 2, 50, 9, 59 },
				{ 1, 94, 9, 56, 7, 68, 3, 75, 6, 87, 5, 72 }, { 1, 73, 2, 69, 11, 100, 4, 86, 8, 84, 6, 86 },
				{ 1, 51, 3, 94, 2, 52, 4, 97, 5, 99, 7, 89 }, { 1, 64, 3, 51, 11, 50, 8, 77, 4, 75, 6, 81 },
				{ 1, 52, 2, 72, 6, 48, 9, 69, 11, 70, 5, 55 }, { 1, 92, 8, 97, 6, 84, 7, 67, 2, 73, 3, 99 },
				{ 1, 96, 5, 82, 6, 95, 10, 83, 9, 64, 4, 55 } };

		// set variable total as zero
		int total = 0;

		// Repeat a loop until the input(option) prompted by user is 4 
		do {
			
			//Print the options for users(teachers) to choose
			System.out.println("1. View Student Record");
			System.out.println("2. View Student Grades");
			System.out.println("3. Change Student Grade");
			System.out.println("4. End the program");
			select = in.nextInt(); // Receive the command from user

			// if command is equal to 1
			if (select == 1) {
				System.out.println("Enter student's number:"); // Ask user to input a student number
				studentNumber = in.nextInt(); // Receive the student number from user
				names(studentNumber); // Call the names() method
				System.out.print("Student number: ");
				System.out.println(studentNumber); // Print the student number prompted by user
				
				System.out.print("Courses: ");
				// Increment i value by 1 from 0 to 11
				for (i = 0; i <= 11; i++) {
					printCourses(records, studentNumber, i); // Call the printCourses() method
					
				}
				// print out blank lines at the end of the output before going back to the main menu
				System.out.println("\n"); 

			// if command is equal to 2
			} else if (select == 2) {
				System.out.println("Enter student's number:"); // Ask user to input a student number
				studentNumber = in.nextInt(); // Receive the student number
				names(studentNumber); // Call the names() method
				System.out.print("Student number: ");
				System.out.println(studentNumber); // Print the student number prompted by user
				// Increment i value by 1 from 0 to 11
				for (i = 0; i <= 11; i++) {
					// for every even number, figure out what the course name is and print it
					if (i % 2 == 0) {
						
						printCourses(records, studentNumber, i); // Call the printCourses() method
						
					}
				// For every odd number, print out the grade from that course right after printing the name(?)
					else if (i % 2 == 1) {
						// Print the grades for value of every odd index in array
						System.out.println(records[studentNumber - 1][i]); 
						// add grade to the total marks each time so you can get average 
						total = total + records[studentNumber - 1][i];
					}

				}
				// Declare the average which is the value of total divided by the number of courses
				double courseAverage = total / 6.0;
				System.out.println("The average is: " + courseAverage); // Print the student's average 
				// print out blank lines at the end of the output before going back to the main menu
				System.out.println("\n"); 

			}
			// if command is equal to 3
			else if (select == 3) {
				System.out.println("Enter student's number:"); // Ask a user to input a student number
				studentNumber = in.nextInt(); // Receive the student number
				// Ask a user to input the index of the course that teacher wants to change 
				System.out.println("Enter the index of the course that you want to change the grade: ");
				indexCourse = in.nextInt(); // Receive a index number of the course from the user(teacher)
				
				Boolean istakingCourse = false; // Set the boolean istakingCourse as false

				// check if the selected index is a course the student is taking
				// Increment i by 2 from 0 up to length of record array
				for (i = 0; i < records[studentNumber].length; i += 2) {
					// if the index number of the course is equal to the values in records array (?)
					if (indexCourse == records[studentNumber - 1][i]) {
						istakingCourse = true;
						// Ask the user to input the student's new percent 
						System.out.println("Enter the student's new percent: "); 
						newGrade = in.nextInt(); // Receives the new grade from user
						//if the student's new percentage is between 0 and 100
						if (newGrade >= 0 && newGrade <= 100) {
						records[studentNumber - 1][i + 1] = newGrade; // stores the new grade in the array called record
						} else {
							// print an error message if the new grade prompted by user is not between 0 and 100
							System.out.println("The percentage should be between 0 and 100.");
						}
					} 
					
					
				}
				// if the boolean istakingCourse is false
				if (istakingCourse == false) {
					/* print an error message if the index number of the course is not equal to the array 
					 * called records (by a student number)
					 */
					System.out.println("The student is not taking the course.");
					System.out.println("\n"); 
				} else {
					istakingCourse = false; // reset the boolean value
				}
			}
			// print out blank lines at the end of the output before going back to the main menu
			System.out.println("\n"); 

		} while (select != 4); //repeats a loop until the command is equal to 4
		//if the option chosen by user is equal to 4
		if (select == 4) {
			// print the exit message to user
			System.out.println("The database has been closed and the program is ended."); 
		} 
		System.out.println();
		
	}

	} // end the program

