import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pong extends JPanel implements ActionListener {

	// Declare variables
	// Shalrah
	static JFrame f;
	JButton b, b1, b2, b3;
	static JMenu menu, menu2;
	static JMenuItem i1, i2, i3;
	JDialog dialog;
	JPanel panel, panel2;
	Timer tm;
	static JMenuBar mb;
	JTextArea ta;

	// Initialize variables
	// Yunseo & Brian
	int xPos = 60;
	int yPos = 100;
	int xDiam = 10;
	int yDiam = 10;
	int xDir = 1;
	int yDir = 1;
	int yPosLeft = 165;
	int yPosRight = 165;
	int counter = 0, counter1 = 0;
	String leftbar = "none";
	String rightbar = "none";

	// Construct the setting of the game
	public Pong() {
		// Yunseo & Brian
		super();
		// Sends a signal that triggers the Action Listener every 15 milliseconds
		tm = new Timer(15, this);
		// Starts the ball
		tm.start();

		// Shalrah
		// Add item 1 (Help) to the menu button (Help).
		menu.add(i1);
		
		// Add item 2(Pause) to the menu2 button (option).
		menu2.add(i2);
		
		// Add item 3(Play) to the menu2 button(option).
		menu2.add(i3);
		
		// Add the menu button(Help) to the menu bar.
		mb.add(menu);
		
		// Add the menu2 button(Options) to the menu bar.
		mb.add(menu2);

		// Done by Shalrah, edited by Yunseo
		// Set the menu bar into the frame
		f.setJMenuBar(mb);

		i1.addActionListener(this);
		// Add actions to items
		i2.addActionListener(this);
		i3.addActionListener(this);

		// Create a panel
		panel = new JPanel();
		
		// Set the first panel as a box layout along the frame axis
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		// Create a button called "^"
		b = new JButton("^");
		
		// Add actions to this button
		b.addActionListener(this);
		
		// Add the button to the panel
		panel.add(b);

		// Create a button called "V"
		b1 = new JButton("V");
		
		// Add actions to this button
		b1.addActionListener(this);
		
		// Add the button to the panel
		panel.add(b1);

		// Done by Shalrah, edited by Yunseo
		// Add the first panel to the frame on the left side of the frame
		f.add(panel, BorderLayout.WEST);

		// Create a second panel
		panel2 = new JPanel();
		// Set the second panel as a box layout along the frame axis
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.PAGE_AXIS));

		// Create a button called "^"
		b2 = new JButton("^");
		// Add the button to the second panel
		panel2.add(b2); 
		// Add the actions to this button
		b2.addActionListener(this); 

		// Create a button called "V"
		b3 = new JButton("V");
		// Add actions to this button
		b3.addActionListener(this); 
		// Add this button to the second panel
		panel2.add(b3); 

		// Done by Shalrah, edited by Yunseo
		// Add the second panel to the frame
		f.add(panel2, BorderLayout.EAST);

		// Create a text area
		ta = new JTextArea();
		ta.setEditable(false); // not editable
		
		// Create a second frame for 'help'.
		dialog = new JDialog(f, "Help", true);
		// Set size of the frame.
		dialog.setSize(500, 300); 
		// Add the second text area to the new frame.
		dialog.add(ta);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Shalrah
		// Create a frame called "Pong".
		f = new JFrame("Pong");
		
		// Create a menu bar.
		mb = new JMenuBar();
		
		// Add menu button called "Help".
		menu = new JMenu("Help");
		
		// Add menu item called "Help"
		i1 = new JMenuItem("Help");
		
		// Add menu2 button called "Option".
		menu2 = new JMenu("Options");
		
		// Add menu item 2 called "Pause".
		i2 = new JMenuItem("Pause");
		
		// Add menu item 3 called "Play".
		i3 = new JMenuItem("Play");

		// Yunseo
		// Create a Pong object
		Pong cp = new Pong();
		
		// Add an object called cp to the frame
		f.add(cp, BorderLayout.CENTER);
		
		// Exit the application when it receives a close window event from operating system.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Set the size of the frame
		f.setSize(500, 430);
		
		// Set the frame to not resizable
		f.setResizable(false);
		
		// Makes the frame appear on the screen
		f.setVisible(true);

	} // end of main method.

	// Establishes what you will be drawing on the panel
	public void paintComponent(Graphics g) {
		// Runs the method called paintComponent
		super.paintComponent(g);
		
		// Brian
		// Sets the colour of the ball to black
		g.setColor(Color.BLACK);
		
		// Sets the diameter and position of where the ball will be
		g.fillOval(xPos, yPos, xDiam, yDiam);
		
		// Yunseo
		// Sets the colour of the bar to blue
		g.setColor(Color.BLUE);
		
		// Sets the width, length, and position of where the bars will be
		// Set the y-coordinate as a variable for dynamic movement of the bars
		g.fillRect(40, yPosLeft, 13, 55);
		g.fillRect(300, yPosRight, 13, 55);
	}

	@Override
	public void actionPerformed(ActionEvent e) { // Start action performed method
		// TODO Auto-generated method stub

		// Yunseo
		/* If the left button at the top is clicked,
		 * and the position of the left bar inside of the frame size (top limit) */
		if (e.getSource() == b && yPosLeft >= 30) {
			
			// Set the left bar as up
			leftbar = "up";
		}
		/* If the left button at the bottom is clicked,
		 * and the position of the left bar is inside of the frame size (bottom limit) */
		if (e.getSource() == b1 && yPosLeft <= 430) {
			
			// Set the left bar as down
			leftbar = "down";
		}
		/* If the right button at the top is clicked,
		 * and the position of the right bar inside of the frame size (top limit) */
		if (e.getSource() == b2 && yPosRight >= 30) {
			
			// Set the right bar as up
			rightbar = "up";
		}
		/* If the right button at the bottom is clicked,
		 * and the position of the right bar is inside of the frame size (bottom limit) */
		if (e.getSource() == b3 && yPosRight <= 430) {
			
			// Set the right bar as down
			rightbar = "down";
		}
		// Yunseo & Brian
		// Call the method called move that takes two parameters
		move(leftbar, rightbar);
		// Call the method called repaint to redraw the component
		repaint();

		// Shalrah
		// If action is equal to the help button, display instructions.
		if (e.getSource() == i1) { 
			
			ta.setText("Players can control the game using the button prompts given to both sides,\n"
					+ "being able to slide their block up and down, to hit the ball. If the ball\n"
					+ "moves past them and hits the goal, then the that player gets a point, which\n"
					+ "should be displayed in the console, with the game then resetting to continue.\n");
			dialog.setVisible(true);// is visible.
		} // end of else if statement.

		if (e.getSource() == i2) { // if the button clicked is equal to item 2(Pause).
			// Stop the ball from moving.
			tm.stop();
			// Disable all the buttons from functioning.
			b.setEnabled(false);
			b1.setEnabled(false);
			b2.setEnabled(false);
			b3.setEnabled(false);
		} // end of if statement.

		if (e.getSource() == i3) { // if the button clicked is equal to item 3(Play).
			// Start the ball movement again.
			tm.start();
			// Enable all the buttons to function.
			b.setEnabled(true);
			b1.setEnabled(true);
			b2.setEnabled(true);
			b3.setEnabled(true);
		} // end of if statement.
		
	}
	// Yunseo
	// Reset the position of the bars and a ball 
	public void reset() {
		// Reset the position of the bars
		yPosLeft = 165;
		yPosRight = 165;
		
		// Set the left and right bars as none
		leftbar = "none";
		rightbar = "none";
		
		// Reset the position of ball
		xPos = 200;
		yPos = (int) (Math.random() * 400);
		
		// Brian
		// This will reset the speed and angle of the ball to its origin when it resets to the centre
		if (xDir > 1) {
			xDir = 1;
		}
		if (xDir < -1) {
			xDir = -1;
		}
		
	}
	// Determine the movement of a ball and bars
	public void move(String left, String right) {
		
		// Yunseo
		/* If the leftbar equals to down, move the left bar down by 2 units, 
		 * if it equals to up, move it up by 2 units */
		if (left.equals("down")) {
			yPosLeft += 2;
		}
		if (left.equals("up")) {
			yPosLeft -= 2;
		}
		/* If the rightbar equals to up, move the right bar up by 2 units, 
		 * if it equals to down, move it down by 2 units */
		if (right.equals("up")) {
			yPosRight -= 2;
		}
		
		if (right.equals("down")) {
			yPosRight += 2;
		}
		
		// If the left bar reaches the top or bottom of the frame, it does not move
		if (left.equals("none")) {
			yPosLeft += 0;
		}
		// If the right bar reaches the top or bottom, it does not move
		if (right.equals("none")) {
			yPosRight += 0;
		}
		
		// Set the limit of the top and bottom that the left bar can move
		if ((yPosLeft < 1) || (yPosLeft > 330)) {
			leftbar = "none";
		}
		
		// Set the limit of the top and bottom that the right bar can move
		if ((yPosRight < 1) || (yPosRight > 330)) {
			rightbar = "none";
		}
		
		// Yunseo
		// If the ball hits the left wall
		if (xPos <= 0) {
			// Call the reset method 
			reset();
			
			// Increment the right side's score by 1 and print it
			counter1++;
			System.out.println("Right side's score: " + counter1);


		}
		// Yunseo
		// If the ball hits the right wall
		if (xPos + xDiam >= 340) {
			// Call the reset method
			reset();
			
			// Increment the left side's score by 1 and print it
			counter++;
			System.out.println("Left side's score: " + counter);
			
		}
		/* When the ball hits the specific pixel or the ceiling of the frame, 
		 * it will reflect on a 90 degree angle */
		if (yPos <= 0 || yPos + yDiam >= 380) {
			yDir *= -1;
		}

		// Brian
		/*
		 * The ball will collide with the left side brick and increases the speed of the
		 * ball and changes the 45 degrees of where the ball will reflect off the brick
		 * by -5 degrees.
		 */
		if (xPos >= 40 && xPos <= 53 && yPos >= yPosLeft && yPos <= yPosLeft + 55) {
			xDir *= -2;
		}
		/*
		 * The ball will collide with the right side brick and increases the speed of the
		 * ball and changes the 45 degrees of where the ball will reflect off the brick
		 * by -5 degrees.
		 */
		if (xPos + xDiam <= 313 && xPos + xDiam >= 300 && yPos >= yPosRight && yPos <= yPosRight + 55) {
			xDir *= -2;
		}
		// The ball will have a capped speed when it reaches the preferred speed
		if (xPos <= 0 || xPos + xDiam >= 400) {
			xDir *= -1;
			
			// This piece of code will limit its speed when it has reached it when it bounces off the brick.
			if (xDir > 10) {
				xDir = 10;
			}
			if (xDir < -10) {
				xDir = -10;
			}
		}
		/* Allows the ball to move in the direction where it needs to be positioned along the x-axis*/
		xPos += xDir;
		/* Allows the ball to move in the direction where it needs to be positioned along the y-axis*/
		yPos += yDir;

	}
}
