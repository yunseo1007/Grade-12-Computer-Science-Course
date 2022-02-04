import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FlappyBird extends JPanel implements ActionListener {

	// Declare variables
	// Shalrah
	static JFrame f;
	Boolean started = true;
	JButton b;
	static JMenu menu;
	static JMenuItem i1;
	JDialog dialog;
	JPanel panel;
	static JMenuBar mb;
	JTextArea ta, ta2, ta3;
	// Yunseo
	int pipeXPos;
	int gapPos;
	// Yunseo & Brian
	Timer tm;

	// Initialize variables
	// Brian
	int birdXPos = 60;
	int birdYPos = 100;
	int xDiam = 20;
	int yDiam = 20;
	int xDir = 0;
	int yDir = 1;
	boolean up = false;
	// Yunseo
	static int WIDTH = 800;
	static int HEIGHT = 800;
	Pipe myPipe = new Pipe(pipeXPos, gapPos, started);
	ArrayList<Pipe> Pipes = new ArrayList<Pipe>();
	int score = -2;

	public FlappyBird() throws IOException {
		// Yunseo
		super();
		// Sends a signal that triggers the Action Listener every 200 milliseconds
		tm = new Timer(200, this);
		// Starts the game
		tm.start();

		// Generate 4 starting pipe locations with their x-position, gap position, and
		// visibility
		Pipes.add(new Pipe(80, 3, false));
		Pipes.add(new Pipe(280, 3, false));
		Pipes.add(new Pipe(480, 3, true));
		Pipes.add(new Pipe(680, 3, true));

		// Shalrah
		// Create main screen frame
		f = new JFrame("Flappy Bird");

		// Create a menu bar.
		mb = new JMenuBar();
		// Add menu button called "Help".
		menu = new JMenu("Help");
		// Add menu item called "Help"
		i1 = new JMenuItem("Help");

		// Add actions to items
		i1.addActionListener(this);

		// Add item 1 (Help) to the menu button (Help).
		menu.add(i1);
		// Add the menu button(Help) to the menu bar.
		mb.add(menu);

		// Set the menu bar into the frame
		f.setJMenuBar(mb);

		// Create a panel
		panel = new JPanel();

		// Set the first panel as a boxlayout along the frame x-axis
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		// Set the size of the panel
		panel.setBounds(100, 200, 900, 900);
		// Set color of the panel
		panel.setBackground(Color.black);

		// Create a button called "Jump"
		b = new JButton("Jump");
		// Set size of the button
		b.setSize(50, 110);
		// Add actions to this button
		b.addActionListener(this);

		// Create a text area
		ta = new JTextArea();
		ta.setEditable(false); // not editable

		// Brian
		// Read the text file named "HiScore"
		FileReader fr = new FileReader("HiScore.txt");
		BufferedReader br = new BufferedReader(fr);
		// Read the first line (name)
		String fileScore = br.readLine();
		// Initialize variable to high score in text file
		fileScore = br.readLine();
		// Create the second text area to indicate high score
		ta2 = new JTextArea("High Score:" + fileScore);
		// Close the BufferedReader
		br.close();
		ta2.setEditable(false); // not editable
		// Add second text area to panel
		panel.add(ta2);

		// Shalrah
		// Create a blank text area
		ta3 = new JTextArea();
		ta3.setEditable(false);
		panel.add(ta3); // not editable.

		// Add the button called "Jump" to the panel
		panel.add(b);

		// Add the panel to the frame on the bottom of the frame
		f.add(panel, BorderLayout.SOUTH);

		// Create a second frame for 'help'.
		dialog = new JDialog(f, "Help", true);
		dialog.setSize(500, 300); // set size of the frame.
		dialog.add(ta); // add the second text area to the new frame.

		// Layout of the frame.
		f.pack();

	} // end of method.

	// Establishes what you will be drawing on the panel
	public void paintComponent(Graphics g) {
		// Yunseo & Brian
		// Runs the method called paintComponent
		super.paintComponent(g);

		// Brian
		// Sets the colour of the bird to black
		g.setColor(Color.BLACK);

		// Sets the diameter and position of where the bird will be
		g.fillOval(birdXPos, birdYPos, xDiam, yDiam);

		// Yunseo
		// Sets the colour of the pipes to green
		g.setColor(Color.GREEN);

		// Iterates through the ArrayList of pipes to get property of each pipe
		for (int i = 0; i < Pipes.size(); i++) {

			// Gets x-position of pipe
			pipeXPos = Pipes.get(i).getXPos();

			// Gets gap position of pipe
			gapPos = Pipes.get(i).getGapPos();

			// Checks if the pipe is visible
			boolean display = Pipes.get(i).getDisplay();

			// Checks if bird collided with current pipe and paints current pipe on screen
			if (display) {

				// If the bird collides with the pipe, it will determine the high score and ends
				// the game
				if (myPipe.collision(birdXPos, pipeXPos, gapPos, birdYPos)) {
					try {
						HighScore(score);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}

				// Paint the pipes on the frame based on the gap position
				if (gapPos == 1) {
					g.fillRect(pipeXPos, 0, 55, 500);
					g.fillRect(pipeXPos, 700, 55, 100);

				} else if (gapPos == 2) {
					g.fillRect(pipeXPos, 0, 55, 400);
					g.fillRect(pipeXPos, 600, 55, 200);
				} else if (gapPos == 3) {
					g.fillRect(pipeXPos, 0, 55, 300);
					g.fillRect(pipeXPos, 500, 55, 300);

				} else if (gapPos == 4) {
					g.fillRect(pipeXPos, 0, 55, 200);
					g.fillRect(pipeXPos, 400, 55, 400);

				} else if (gapPos == 5) {
					g.fillRect(pipeXPos, 0, 55, 100);
					g.fillRect(pipeXPos, 300, 55, 500);

				} else if (gapPos == 6) {
					g.fillRect(pipeXPos, 0, 55, 0);
					g.fillRect(pipeXPos, 200, 55, 600);

				}
			}
		}

	}

	// Brian
	// Determines the movement of the bird
	public void moveBird(boolean up) {
		/*
		 * If the bird moves up, it will reverse its direction from falling
		 */
		if (up == (true)) {
			yDir -= 10;
		}
		// If the bird hits the floor it will stay there while the game still runs
		else if (birdYPos >= 700) {
			yDir = 0;
		}
		// This code increases the birds speed over time when falling
		else {
			yDir += 2;
		}
		// Allows the bird to move in the direction where it needs to be positioned
		// along the y-axis
		birdYPos += yDir;
		if (birdYPos > 700) {
			birdYPos = 700;

		}
	}

	// Yunseo
	// Determines the movement of the pipes shown on the frame
	public void movePipes() {

		// Iterates through the x-position of the pipes and moves them to the left
		for (int i = 0; i < Pipes.size(); i++) {

			// Get the x-position of each pipe and move it to the left by 5 pixels
			int XPos = Pipes.get(i).getXPos();
			XPos -= 5;

			// Check if x position of pipe is 0
			if (XPos == 0) {
				// If it is, add a new pipe to the end of the ArrayList
				int random = (int) (Math.random() * 5 + 1);
				Pipes.get(i).setXPos(XPos);

				// When a pipe is added, it will appear from the right side of the frame with a
				// random gap position
				Pipes.add(new Pipe(900, random, true));
			}
			// Check if x position of pipe in ArrayList is less than 0 (out of the frame)
			else if (XPos < 0) {
				// Remove the pipe and increment the score by 1
				Pipes.remove(i);
				score++;
			} else {
				Pipes.get(i).setXPos(XPos);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Shalrah
		// Frame name
		f = new JFrame("FlappyBird");

		// Create the object called fb.
		FlappyBird fb = new FlappyBird();

		// Set background of the frame to white.
		f.setBackground(Color.WHITE);

		// Add an object called fb to the frame
		f.add(fb, BorderLayout.CENTER);

		// Exit the application when it receives a close window event from operating
		// system.
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Set the size of the frame
		f.setSize(WIDTH, HEIGHT);

		// Set the frame to not resizable
		f.setResizable(false);

		// Makes the frame appear on the screen
		f.setVisible(true);

	} // end of main method.

	// Handles all the actions of a component
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		// Yunseo
		// Call the method named movePipes to determine movement of pipes
		movePipes();

		// Brian
		// Call the method named movePipes to determine movement of a bird
		moveBird(up);

		// Yunseo & Brian
		// Call the repaint method to redraw the component
		repaint();

		// Shalrah
		if (e.getSource() == i1) { // if action is equal to the help button.
			// then display instructions.
			ta.setText("The main objective is, if you hit a pipe or the ground, the game ends.\n" + "\n"
					+ "1.Click the button 'jump' to allow your bird to fly and to start the game.\n"
					+ "2.The faster you tap, the higher you go. Each tap represents a wing flap\n"
					+ "and a higher flight. Once you stop, you drop towards the ground.\n"
					+ "3.Each time you pass a tube you get a point.");
			dialog.setVisible(true);// is visible.
		} // end of else if statement.

		// Brian
		// When the button is clicked, this will start the game and allow the bird to jump
		if (e.getSource() == b) {
			up = true;

		} else {
			up = false;
		}

	}

	// Yunseo
	// Checks if the user beats the high score, then updates the final high score
	// with the user's name in the text file and ends the game
	public void HighScore(int score) throws IOException {

		// Read the text file named "HiScore"
		FileReader fr = new FileReader("HiScore.txt");
		BufferedReader br = new BufferedReader(fr);

		// Read the name of the user who has the current high score and store it into the variable
		String name = br.readLine();

		// Declare variable
		String output;

		// Read the high score and store it into the variable
		String Score = br.readLine();

		// Change the string into integer and store it into the variable called highScore
		int highScore = Integer.parseInt(Score);

		// Close the BufferedReader
		br.close();

		// Write the text file named "HiScore"
		FileWriter fw = new FileWriter("HiScore.txt");
		PrintWriter pw = new PrintWriter(fw);

		/*
		 * If the score is greater than the highScore, then it will pop up the end
		 * screen and update the name and score
		 */
		if (score > highScore) {

			// Shows a dialog asking user's name to update file with an alert saying they
			// beat the score
			output = JOptionPane.showInputDialog("You have beaten the high score! Please enter your name: ");
			// Write the user's name
			pw.println(output);
			// Write the user's score as the high score
			pw.println(score);

		}
		/*
		 * If the user's score ties the high score, the record in the file will not be
		 * changed and pop up the end screen
		 */
		else if (score == highScore) {
			// Write the user's name
			pw.println(name);
			// Write the same high score (high score did not change)
			pw.println(highScore);

		}
		/*
		 * If the user's score is less than high score, the record in the file will not
		 * be changed and pop up the end screen
		 */
		else {
			pw.println(name);
			pw.println(highScore);

		}
		// Write the user's score
		pw.println(score);
		// Close the PrintWriter
		pw.close();
		// Create a endScreen object
		EndScreen endScreen = new EndScreen();
		// Close the JFrame window
		f.dispose();
	}

}
