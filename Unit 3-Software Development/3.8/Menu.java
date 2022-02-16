import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu implements ActionListener{

	JMenu menu, submenu, menu2;
	JMenuItem i1, i2, i3, i4, i5;
	
	public Menu() {
		
		JFrame f = new JFrame();
		JMenuBar mb = new JMenuBar(); // Holds our menus
		
		JMenu menu = new JMenu("Menu"); // Holds our menu items
		JMenu submenu = new JMenu("Menu2"); 
		JMenu menu2 = new JMenu("Sub Menu");
		
		i1 = new JMenuItem ("Item 1"); // Button that we will access
		i1.addActionListener(this);
		i2 = new JMenuItem ("Item 2");
		i2.addActionListener(this);
		i3 = new JMenuItem ("Item 3");
		i3.addActionListener(this);
		i4 = new JMenuItem ("Item 4");
		i4.addActionListener(this);
		i5 = new JMenuItem ("Item 5");
		i5.addActionListener(this);

		
		menu.add(i1);
		menu.add(i2);
		submenu.add(i3);
		submenu.add(i4);
		menu2.add(i5);
		
		menu.add(submenu);
		
		mb.add(menu);
		mb.add(menu2);
		f.setJMenuBar(mb); // Actually setting menu bar
		f.setSize(400, 400);
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.setVisible(true);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Menu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == i1) {
			System.out.println("1");
		}else if (e.getSource() == i2) {
			System.out.println("2");
		} else if (e.getSource() == i3) {
			System.out.println("3");
		} else if (e.getSource() == i4) {
			System.out.println("4");
		} else if (e.getSource() == i5){
			System.out.println("5");
		}
	}
	

}
