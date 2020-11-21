package IzgledProzora;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); //CTRL+C sluzi za zatvaranje otvorenog prozora
		close.setIcon(new ImageIcon(new ImageIcon("Slike/close.png").getImage().getScaledInstance(15, 15, Image.SCALE_DEFAULT)));

		file.add(myNew);
		file.addSeparator();
		file.add(close);
		
		JMenu edit = new JMenu("Edit"); 
		
		JMenuItem edit1 = new JMenuItem("Edit"); //izmena postojeceg entiteta
		edit1.setMnemonic(KeyEvent.VK_E);
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		
		JMenuItem delete = new JMenuItem ("Delete"); //brisanje postojeceg entiteta
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		
		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
	
		JMenu help = new JMenu("Help");
		
		JMenuItem help1 = new JMenuItem("Help"); //treba da sadzi detaljan opis o nacinu koriscenja aplikacije
		help1.setMnemonic(KeyEvent.VK_H);
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		help1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextArea helpTekst= new JTextArea("\t\t Detaljan opis o nacinu koriscenje aplikacije \t\t\t\n", 15,20);
				
				JScrollPane sp = new JScrollPane(helpTekst);
				JOptionPane.showMessageDialog(null, sp);
				
			}
		});
		
		JMenu about = new JMenu("About"); //prikaz verzije aplikacije i kratak opis, sazeta biografija autora
		about.setMnemonic(KeyEvent.VK_A);
		
		JMenuItem aboutApp = new JMenuItem("About app");
		aboutApp.setMnemonic(KeyEvent.VK_A);
		aboutApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		
		JMenuItem aboutStudent1 = new JMenuItem("About Student1");
		aboutStudent1.setMnemonic(KeyEvent.VK_1);
		aboutStudent1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		aboutStudent1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuItem aboutStudent2 = new JMenuItem("About Student2");
		aboutStudent2.setMnemonic(KeyEvent.VK_2);
		aboutStudent2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		
		about.add(aboutStudent1);
		about.add(aboutStudent2);
		
		//about.setMnemonic(KeyEvent.VK_A);
		//about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		//about.setIcon(new ImageIcon("Slike/about.png"));
		

		
		
		help.add(help1);
		help.add(about);
		
		add(file);
		add(edit);
		add(help);
	}
}
