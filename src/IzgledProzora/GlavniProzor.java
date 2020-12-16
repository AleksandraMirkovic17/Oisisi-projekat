package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import IzgledProzora.ToolBar;


public class GlavniProzor extends JFrame {
	
	private ToolBar toolbar;
	private MyMenuBar menu;
	private StatusBar statusBar;
	private TabPane tabpane;
	
	private static GlavniProzor instance=null;
	
	public static GlavniProzor getInstance()
	{
		if(instance==null)
		{
			instance=new GlavniProzor();
		}
		return instance;
     };
	

	public GlavniProzor() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize(); //Dimenziju koja sadrzi screenHeigh i screenWidth
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setTitle("Studentska sluzba"); 
	setSize(screenWidth * 3/4, screenHeight / 2); 

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	tabpane = new TabPane();
	add(tabpane, BorderLayout.CENTER);
	System.out.println(tabpane.getPreferredSize());
	
	tabpane.setVisible(true);
	
	menu=MyMenuBar.getInstance();
	this.setJMenuBar(menu);
	
	statusBar = new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	statusBar.setVisible(true);
	statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //Postavljanje granicne linije 
	
	toolbar=new ToolBar();
	add(toolbar, BorderLayout.NORTH);  
	toolbar.setVisible(true);
	setResizable(true);
	
	}
	

}
