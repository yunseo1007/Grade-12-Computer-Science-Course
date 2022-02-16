import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

class ActionEventDemo implements ActionListener{
	Scanner in = new Scanner(System.in);

	JFrame frame = new JFrame();
	JButton button = new JButton("Click this");
	char ch;
	public ActionEventDemo() {
		this.setGUI();
		this.setButton();
	}
	
	public void setGUI() {
		frame.setTitle("My Window"); // Setting title of JFrame
		frame.getContentPane().setLayout(null); // Setting layout
		frame.setVisible(true); // Setting visibility
		frame.setBounds(200,200,400,400); // Setting Location
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
	}
	
	public void setButton() {
		button.setBounds(130,200,100,40); // Setting location and size of button
		frame.add(button); // adding button to the frame
		button.addActionListener(this); // Registering ActionListener to the button
	}
	public static int strength() {
		return (int) (256 * Math.random());
	}
	public void actionPerformed(ActionEvent e) {
		// Change Background Colour
		frame.getContentPane().setBackground(new Color(strength(), strength(), strength()));
	}
}
public class buttonPractice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ActionEventDemo();
	}

}
//frame.getContentPane().setBackground(Color.PINK);
