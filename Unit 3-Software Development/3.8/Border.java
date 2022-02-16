import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Border extends JFrame implements ActionListener {
	JButton button1, button2, button3, button4, button5;
	int north, east, south, west;


	public Border() {
		super(); // Initialize the Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Sets up the command to automatically close the window
		this.setSize(300, 300); // Sets the initial size of the frame

		this.button1 = new JButton("Number 1");
		this.button2 = new JButton("Number 2");
		this.button3 = new JButton("Number 3");
		this.button4 = new JButton("Number 4");
		this.button5 = new JButton("Number 5");

		this.add(button1, BorderLayout.PAGE_START); // Places the button in the page start area of the layout
		this.add(button2, BorderLayout.PAGE_END); // Places the button in the page end area of the layout
		this.add(button3, BorderLayout.LINE_START);
		this.add(button4, BorderLayout.LINE_END);
		this.add(button5, BorderLayout.CENTER);
		

		// This leaves the remaining three zones blank, thus the space.
		this.button1.addActionListener(this);
		this.button2.addActionListener(this);
		this.button3.addActionListener(this);
		this.button4.addActionListener(this);
		this.button5.addActionListener(this);


		this.setVisible(true);
	}	public static int strength() {
		return (int) (255 * Math.random());
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Border main = new Border();
		new Border();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.button1) {
			north++;
		System.out.println("You moved 1 step to the north.");
		System.out.println("Your coordinate: " + "(" + (east - west) + "," + (north - south) + ")");
		System.out.println("Your distance from the origin: " + Math.sqrt(Math.pow((east - west),2) + Math.pow(north - south, 2)));
		} else if (e.getSource() == this.button2) {
			south++;
			System.out.println("You moved 1 step to the south.");
			System.out.println("Your coordinate: " + "(" + (east - west) + "," + (north - south) + ")");
			System.out.println("Your distance from the origin: " + Math.sqrt(Math.pow((east - west),2) + Math.pow(north - south, 2)));

		} else if (e.getSource() == this.button3) {
			west++;
			System.out.println("You moved 1 step to the west.");
			System.out.println("Your coordinate: " + "(" + (east - west) + "," + (north - south) + ")");
			System.out.println("Your distance from the origin: " + Math.sqrt(Math.pow((east - west),2) + Math.pow(north - south, 2)));

		} else if (e.getSource() == this.button4) {
			east++;
			System.out.println("You moved 1 step to the east.");
			System.out.println("Your coordinate: " + "(" + (east - west) + "," + (north - south) + ")");
			System.out.println("Your distance from the origin: " + Math.sqrt(Math.pow((east - west),2) + Math.pow(north - south, 2)));

		} else if (e.getSource() == this.button5) {
			north = 0;
			south = 0;
			west = 0;
			east = 0;
			System.out.println("You are at the origin.");

			button5.setBackground(new Color(strength(), strength(), strength()));
		}
		this.setVisible(true);
	}

}
