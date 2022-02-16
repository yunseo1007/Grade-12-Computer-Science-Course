import java.awt.*;
import javax.swing.*;
public class Panel {

	public Panel() {
		JPanel panel = new JPanel();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		panel.setSize(100,200);
		panel.setBackground(Color.GRAY);
		// Panel cannot exist on its own, must be included onto a Frame
		
		JButton b1 = new JButton("Button 1");
		b1.setSize(80, 30);
		b1.setBackground(Color.YELLOW);
		
		panel.add(b1);
		
		JButton b2 = new JButton("Button 2");
		b2.setSize(80, 30);
		b2.setBackground(Color.GREEN);

		panel.add(b2);

		JPanel panel2 = new JPanel();
		panel2.setSize(100,200);
		panel2.setBackground(Color.RED);

		JButton b3 = new JButton("Button 3");
		b3.setSize(80, 30);
		b3.setBackground(Color.BLUE);

		panel2.add(b3);
		
		JFrame frame = new JFrame();
		frame.setSize(400, 400);
		frame.add(panel, BorderLayout.LINE_START);
		frame.add(panel2, BorderLayout.LINE_END);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Panel();
	}

}
