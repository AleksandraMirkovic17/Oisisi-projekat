package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.WindowConstants;

import pomocneKlase.SimpleDialog;

public class MyMenuBar extends JMenuBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MyMenuBar instance = null;
	private static GlavniProzor parent;

	public static MyMenuBar getInstance() {
		if (instance == null) {
			instance = new MyMenuBar();
		}
		return instance;
	}

	public MyMenuBar() {
		JMenu file = new JMenu("File");

		JMenuItem myNew = new JMenuItem("New"); // dodavanje novog entiteta u sistem
		// postavljanje akcelaratora /*REFERENCIRAN KOD
		// https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#mnemonic*/
		myNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // CTRL+N sluzi za dodavanje
																							// novog entiteta
		myNew.setMnemonic(KeyEvent.VK_N);
		myNew.setIcon(new ImageIcon("Slike/plus.png"));
		myNew.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog();
					dialog.setVisible(true);
				}
				if (TabPane.getInstance().getSelectedIndex() == 1) {
					DodavanjeProfesorDialog dialog = new DodavanjeProfesorDialog();
					dialog.setVisible(true);
				}
			}
		});

		JMenuItem close = new JMenuItem("Close"); // zatvaranje aplikacije
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // CTRL+C sluzi za
																							// zatvaranje otvorenog
																							// prozora
		close.setIcon(new ImageIcon("Slike/close.png"));
		close.setIcon(new ImageIcon("Slike/iks.png"));

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int odabir = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),
						"Da li ste sigurni da zelite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION);

				if (odabir == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

		file.add(myNew);
		file.addSeparator();
		file.add(close);
		file.setMnemonic(KeyEvent.VK_F);

		JMenu edit = new JMenu("Edit");

		JMenuItem edit1 = new JMenuItem("Edit"); // izmena postojeceg entiteta
		edit1.setMnemonic(KeyEvent.VK_E);
		edit1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
		edit1.setIcon(new ImageIcon("Slike/olovka.png"));

		JMenuItem delete = new JMenuItem("Delete"); // brisanje postojeceg entiteta
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delete.setIcon(new ImageIcon("Slike/kanta.png"));

		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
		edit.setMnemonic(KeyEvent.VK_E);

		JMenu help = new JMenu("Help");

		JMenuItem help1 = new JMenuItem("Help"); // treba da sadzi detaljan opis o nacinu koriscenja aplikacije
		help1.setMnemonic(KeyEvent.VK_H);
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		help1.setIcon(new ImageIcon("Slike/help.png"));
		help1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextArea helpTekst = new JTextArea("\t\t Detaljan opis o nacinu koriscenja aplikacije \t\t\n\n"
						+ "STUDENTI\n"
						+ "1. Dodavanje novog entiteta je moguce preko precice na tastauri Ctrl+N, preko dugmeta + na Tool bar-u ili File -> New"
						+ "\n\nPROFESORI\n"
						+ "1. Dodavanje novog entiteta je moguce preko precice na tastauri Ctrl+N, preko dugmeta + na Tool bar-u ili File -> New\"\r\n"
						+ "", 20, 60);
				Font f = new Font("Arial", Font.BOLD, 14);
				helpTekst.setFont(f);
				JScrollPane sp = new JScrollPane(helpTekst); // postavljamo panel koji ima mogucnost skrolovanja
				JOptionPane.showMessageDialog(null, sp); // iskacuci prozor informativnog karaktera

			}
		});

		JMenu about = new JMenu("About"); // prikaz verzije aplikacije i kratak opis, sazeta biografija autora
		about.setMnemonic(KeyEvent.VK_A);

		JMenuItem aboutApp = new JMenuItem("About app");
		aboutApp.setMnemonic(KeyEvent.VK_A);
		aboutApp.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		aboutApp.setIcon(new ImageIcon("Slike/app.png"));
		aboutApp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Simple dialog - kod preuzet
				SimpleDialog sd = new SimpleDialog(parent, "App info", true); // parent je frame u kome radimo
				sd.setBackground(new Color(216, 191, 216));
				Label lapp = new Label("Aplikacija Studentska sluzba, verzija 1.0");
				Font f = new Font("Arial", Font.ITALIC, 12);
				lapp.setFont(f);
				sd.add(lapp, BorderLayout.NORTH);
				sd.setSize(230, 70);
				sd.setVisible(true);

			}
		});

		// informacije koje treba da se ispisu o Studentu 1
		JMenuItem aboutStudent1 = new JMenuItem("About Student1");
		aboutStudent1.setMnemonic(KeyEvent.VK_1);
		aboutStudent1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
		aboutStudent1.setIcon(new ImageIcon("Slike/User.png"));
		aboutStudent1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// postavljamo modalni dialog koji ce prikayivati neke informacije o Studentu 1
				SimpleDialog sd = new SimpleDialog(parent, "Informacije o studentu 1", true);
				Label ls1 = new Label("Student 1: Andrea Sabo Cibolja");
				Font f = new Font("Sherif", Font.BOLD, 15);
				ls1.setFont(f);
				ls1.setAlignment(WIDTH);
				ls1.setBackground(new Color(216, 191, 216));

				JLabel ls1info = new JLabel("<html>Rodjena 25.6.1999. godine u Subotici. "
						+ "Student trece godine Fakulteta tehnickih nauka u Novom Sadu, "
						+ "na smeru Racunarstvo i automatika.</html>");
				ls1info.setBackground(new Color(255, 204, 255));

				sd.add(ls1, BorderLayout.NORTH);
				sd.add(ls1info, BorderLayout.CENTER);
				sd.setVisible(true);
			}
		});

		// Informacije o studentu 2
		JMenuItem aboutStudent2 = new JMenuItem("About Student2");
		aboutStudent2.setMnemonic(KeyEvent.VK_2);
		aboutStudent2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
		aboutStudent2.setIcon(new ImageIcon("Slike/User.png"));
		aboutStudent2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDialog sd = new SimpleDialog(parent, "Informacije o studentu 2", true);
				Label ls2 = new Label("Student 2: Aleksandra Mirkovic");
				Font f = new Font("Sherif", Font.BOLD, 15);
				ls2.setFont(f);
				ls2.setAlignment(WIDTH);
				ls2.setBackground(new Color(216, 191, 216));

				// Koriscenjem JLabel i dodavanjem tagova <html> tekst se prelama kada je to
				// potrebno
				JLabel ls2info = new JLabel("<html>Rodjena 17.6.1999. godine u Novom Sadu. "
						+ "Student trece godine Fakulteta tehnickih nauka u Novom Sadu, "
						+ "na smeru Racunarstvo i automatika.</html>");
				ls2info.setBackground(new Color(255, 204, 255));

				sd.add(ls2, BorderLayout.NORTH);
				sd.add(ls2info, BorderLayout.CENTER);
				sd.setVisible(true);
			}
		});

		about.add(aboutApp);
		about.addSeparator();
		about.add(aboutStudent1);
		about.add(aboutStudent2);
		about.setMnemonic(KeyEvent.VK_A);
		about.setIcon(new ImageIcon("Slike/about.png"));

		help.add(help1);
		help.add(about);
		help.setMnemonic(KeyEvent.VK_H);

		add(file);
		add(edit);
		add(help);
	}

}
