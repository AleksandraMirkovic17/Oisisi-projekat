package izledProzora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class glavni_prozor extends JFrame{
	
	
	private ToolBar toolbar;
	
	public glavni_prozor() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize(); //Dimenziju koja sadrzi screenHeigh i screenWidth
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setTitle("Studentska sluzba"); 
	setSize(screenWidth * 3/4, screenHeight / 2); 
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	toolbar=new ToolBar();
	add(toolbar, BorderLayout.NORTH);
	toolbar.setVisible(true);
	setResizable(true);
	
	
	}

}
