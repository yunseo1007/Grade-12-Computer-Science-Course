import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class CirclePanel extends JPanel implements ActionListener{
	
	Timer tm;
	
	int xPos = 10; 
	int yPos = 10;
	int xDiam = 50;
	int yDiam = 50; 
	int xDir = 1;
	int yDir = 1;
	
	public CirclePanel() {
		super();
		tm = new Timer(15, this); // Sends a signal that triggers the Action Listener every 15 milliseconds
		tm.start();
	}
	
	// Establishes what you will be drawing on your panel(?)
	public void paintComponent(Graphics g) { 
		super.paintComponent(g);
		g.setColor(Color.GREEN);
		g.fillOval(xPos, yPos, xDiam, yDiam);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame frame = new JFrame("Circle enlarger"); // Frame that holds JPanel
		CirclePanel co = new CirclePanel();
		frame.add(co);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 300);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		move();
		repaint();
		
	}
	
	public void move() {
		if (xPos == 0 || xPos+xDiam == 275) {
			xDir *= -1;
		}
		if (yPos == 0 || yPos+yDiam == 300) {
			yDir *= -1;
		}

		xPos += xDir;
		yPos += yDir;
		
		
		
	}

}
