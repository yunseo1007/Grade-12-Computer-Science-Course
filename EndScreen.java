import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;

public class EndScreen extends JPanel {

	// Declare variables
	// Shalrah
	static JFrame fEnd;
	JPanel panel;
	// Yunseo
	JButton btnExit, btnPlayAgain;

	public EndScreen() throws IOException {

		// Shalrah
		fEnd = new JFrame();

		panel = new JPanel();

		// Set the first panel as a BoxLayout along the frame axis
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		panel.setBounds(200, 400, 900, 900);

		// Create a button called "Exit"
		btnExit = new JButton("Exit");
		btnExit.setSize(50, 110);

		// Yunseo
		// Adding action listener for exit button when it is clicked
		btnExit.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnExitActionPerformed(evt);
			}
		});
		// Shalrah
		// Adding button to panel
		panel.add(btnExit);

		// Create a button called "Play Again"
		btnPlayAgain = new JButton("Play Again");
		btnPlayAgain.setSize(50, 110); // set size of the button 

		// Yunseo
		// Adding action listener for play again button when it is clicked
		btnPlayAgain.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnPlayAgainActionPerformed(evt);
			}
		});
		// Shalrah
		// Add "Play Again" button to the panel
		panel.add(btnPlayAgain);

		// Yunseo 
		// Read the text file named "HiScore"
		FileReader fr = new FileReader("HiScore.txt");
		BufferedReader br = new BufferedReader(fr);
		
		// Read the first line (name) and store it into the variable called HiScore 
		String HiScore = br.readLine();
		
		// Read the second line (high score) and initialize variable 
		HiScore = br.readLine();
		
		// Read the third line (user's score) and store it into the variable called score
		String score = br.readLine();
		
		// Close the BufferedReader
		br.close();
		// Initialize label
		JLabel label = new JLabel("High score:" + HiScore + " Score:" + score);

		// Add the label to the frame
		fEnd.add(label);
		// Add panel to the frame and arrange it to south
		fEnd.add(panel, BorderLayout.SOUTH);
		
		// Shalrah
		// Compiling the frame
		fEnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fEnd.pack();
		fEnd.setVisible(true);
		fEnd.setSize(200, 200);

	}
	// Yunseo
	/* When the play again button is clicked, the end screen will close 
	 * and game screen (FlappyBird frame) will pop up
	 */
	private void btnPlayAgainActionPerformed(java.awt.event.ActionEvent evt) {
		FlappyBird fb;
		try {
			fb = new FlappyBird();
			fEnd.dispose();
			fb.main(null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Yunseo
	// When the exit button is clicked, it will close the entire application
	private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {
		System.exit(0);
	}

}
