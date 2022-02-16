import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Dialog implements ActionListener{

	JFrame frame, frame2;
	JDialog dialog;
	JPanel panel;
	JButton button, button2;
	
	public Dialog() {
		JFrame frame = new JFrame();
		JFrame frame2 = new JFrame();
		dialog = new JDialog(frame2, "Dialog Example", true);
		dialog.setLayout(new FlowLayout());
		panel = new JPanel();
		panel.setSize(200, 200);
		frame.setSize(300,300);
		button = new JButton ("OK 1");
		button.addActionListener(this);
		panel.add(button);
		frame.add(panel, BorderLayout.NORTH);
		button2 = new JButton ("OK 2");
		button2.addActionListener(this);

		dialog.add(new JLabel("Click Button to Continue"));
		dialog.add(button2);
		dialog.setSize(300, 300);
		dialog.setVisible(true);
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dialog();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == button) {
			dialog.setVisible(true);
			frame.setVisible(false);
		}
		else if (e.getSource() == button2) {
			dialog.setVisible(false);
			frame.setVisible(true);
		}
	}

}
