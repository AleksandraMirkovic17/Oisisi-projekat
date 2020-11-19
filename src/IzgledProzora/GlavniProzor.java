package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import IzgledProzora.ToolBar;

public class GlavniProzor extends JFrame {
	
private ToolBar toolbar;
	
	public GlavniProzor() {
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