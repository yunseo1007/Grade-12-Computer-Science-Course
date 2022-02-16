import javax.swing.*;

public class gui {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("My First GUI"); // Creates a Frame with a title "My First GUI" 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets up the command to automatically close the window 
		frame.setSize(300,300); // Sets the initial size of the frame 
		JButton button1 = new JButton("Button 1"); // Creates a button add a label to the button called "button1"
		JButton button2 = new JButton("Button 2");

		frame.getContentPane().add(button1); // Adds the button1 to the frame 
		frame.getContentPane().add(button2);

		frame.setVisible(true); // Makes the entire window visible to the user
	}

}
