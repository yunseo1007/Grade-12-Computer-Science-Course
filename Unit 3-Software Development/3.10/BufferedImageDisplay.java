import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class BufferedImageDisplay implements ActionListener{

	JFrame f;
	JButton b;
	JLabel label;
	ImageIcon image;
	String[] images = {"pic1.png", "pic2.png", "pic3.png"};
	BufferedImage bi;
	int count = 0;
	
	public BufferedImageDisplay() throws IOException {
		f = new JFrame("Demo");
		b = new JButton("Press");
		b.addActionListener(this);
		f.add(b, BorderLayout.SOUTH);
		
		bi = ImageIO.read(new File(images[0]));
		
		image = new ImageIcon(bi);
		label = new JLabel();
		label.setIcon(image);
		
		f.add(label, BorderLayout.CENTER);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		new BufferedImageDisplay();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == b) {
			count++;
			try {
				bi = ImageIO.read(new File(images[count % 3]));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			image = new ImageIcon(bi);
			label.setIcon(image);
		}
	}

}
