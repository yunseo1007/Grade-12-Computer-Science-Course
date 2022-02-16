import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class textArea implements ActionListener{

	JFrame frame;
	JTextArea ta;
	JButton b = new JButton("Clear");
	public textArea() {
		frame = new JFrame();
		frame.setSize(400, 400);
		b.addActionListener(this);
		JTextField tf = new JTextField(10);
		ta = new JTextArea();
		frame.add(ta, BorderLayout.CENTER);
		frame.add(b, BorderLayout.SOUTH);
		
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new textArea();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String line;
		if (e.getSource() == b) {
			line = ta.getText();
			System.out.println(line);
			ta.setText("");
			
		}
	}

}
