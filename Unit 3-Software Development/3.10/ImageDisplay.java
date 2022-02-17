import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageDisplay implements ActionListener{
	JFrame f;
	JButton b;
	ImageIcon image;
	JLabel label;
	int count = 0;
	public ImageDisplay() {
		f = new JFrame("Demo");
		image = new ImageIcon("pic3.png");
		label = new JLabel(image);
		f.add(label, BorderLayout.CENTER);
		
		b = new JButton("Press");
		b.addActionListener(this);
		f.add(b, BorderLayout.SOUTH);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new ImageDisplay();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b) {
			count++;
			
			if (count % 3 == 0) {
				image = new ImageIcon("pic1.png");
				label = new JLabel(image);
				f.add(label, BorderLayout.CENTER);

			}
			else if (count % 3 == 1) {
				image = new ImageIcon("pic2.png");
				label = new JLabel(image);
				f.add(label, BorderLayout.CENTER);

			}
			else if (count % 3 == 2) {
				image = new ImageIcon("pic3.png");
				label = new JLabel(image);
				f.add(label, BorderLayout.CENTER);

			}
			
			f.setVisible(true);
			
		}
	}

}