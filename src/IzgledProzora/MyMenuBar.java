package IzgledProzora;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MyMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//pravimo konstruktor bez parametara klase MyMenuBar
	
	public MyMenuBar()
	{
		JMenu file = new JMenu("File");
		JMenuItem myNew = new JMenuItem("New"); //dodavanje novog entiteta u sistem
		//postavljanje akcelaratora /*REFERENCIRAN KOD https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#mnemonic*/
		myNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); //CTRL+N sluzi za dodavanje novog entiteta
		
		myNew.setIcon(new ImageIcon(new ImageIcon("Slike/plus.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));
		JMenuItem close = new JMenuItem ("Close"); //zatvaranje aplikacije
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //CTRL+C sluzi za zatvaranje otvorenog prozora
		
		file.add(myNew);
		file.addSeparator();
		file.add(close);
		
		JMenu edit = new JMenu("Edit"); 
		JMenuItem edit1 = new JMenuItem("Edit"); //izmena postojeceg entiteta
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		JMenuItem delete = new JMenuItem ("Delete"); //brisanje postojeceg entiteta
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
	
		JMenu help = new JMenu("Help");
		JMenuItem help1 = new JMenuItem("Help"); //treba da sadzi detaljan opis o nacinu koriscenja aplikacije
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		JMenuItem about = new JMenuItem("About"); //prikaz verzije aplikacije i kratak opis, sazeta biografija autora
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		help.add(help1);
		help.add(about);
		
		add(file);
		add(edit);
		add(help);
	}
}
