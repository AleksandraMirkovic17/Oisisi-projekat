package view;

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
import java.io.File;

import javax.swing.ImageIcon;
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

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.BazaPodataka;
import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaStudent;
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
		BazaPodataka bp = new BazaPodataka();

		bp.citanje();

		JMenuItem myNew = new JMenuItem("New"); // dodavanje novog entiteta u sistem
		// postavljanje akcelaratora /*REFERENCIRAN KOD
		// https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html#mnemonic*/
		myNew.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK)); // CTRL+N sluzi za dodavanje
																							// novog entiteta
		myNew.setMnemonic(KeyEvent.VK_N);
		myNew.setIcon(new ImageIcon("Slike" + File.separator + "plus.png"));
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
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog();
					dialog.setVisible(true);
				}
			}
		});

		JMenuItem close = new JMenuItem("Close"); // zatvaranje aplikacije
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK)); // CTRL+C sluzi za
																							// zatvaranje otvorenog
																							// prozora
		close.setIcon(new ImageIcon("Slike" + File.separator + "iks.png"));
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int odabir = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(),
						"Da li ste sigurni da želite da zatvorite aplikaciju?", "Zatvaranje aplikacije",
						JOptionPane.YES_NO_OPTION);

				if (odabir == JOptionPane.YES_OPTION) {
					try {
						bp.cuvanje();

					} catch (Exception t) {

					}
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
		edit1.setIcon(new ImageIcon("Slike" + File.separator + "olovka.png"));
		edit1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					int red = StudentiJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaStudent.getInstance().getBrojStudenata())) {
						int model=StudentiJTable.getInstance().convertRowIndexToModel(red);
						StudentController.getInstance().izmeniStudenta(model);
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali studenta!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				if (TabPane.getInstance().getSelectedIndex() == 1) {
					int red = ProfesoriJTable.getInstance().getSelectedRow();
					System.out.println(red);
					if (red >= 0 && (red < BazaProfesor.getInstance().getbroj_profesora())) {
						int model=ProfesoriJTable.getInstance().convertRowIndexToModel(red);
						ProfesorController.getInstance().izmeniProfesora(model);
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali profesora!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}

				}
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					int red = PredmetJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red <= BazaPredmet.getInstance().getPredmeti().size())) {
						int model=PredmetJTable.getInstance().convertRowIndexToModel(red);
						PredmetController.getInstance().izmeniPredmet(model);
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali predmet!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}

			}
		});

		JMenuItem delete = new JMenuItem("Delete"); // brisanje postojeceg entiteta
		delete.setMnemonic(KeyEvent.VK_D);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));
		delete.setIcon(new ImageIcon("Slike" + File.separator + "kanta.png"));
		delete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// u slucaju da smo na tabu studenti
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					int red = StudentiJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaStudent.getInstance().getBrojStudenata())) {
						int model=StudentiJTable.getInstance().convertRowIndexToModel(red);
						String ispis = "Da li ste sigurni da želite da izbrišete studenta "
								+ BazaStudent.getInstance().getRow(model).getBrIndeksa() + " "
								+ BazaStudent.getInstance().getRow(model).getIme() + " "
								+ BazaStudent.getInstance().getRow(model).getPrezime() + "?";
						int code = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), ispis, "Brisanje studenta",
								JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							StudentController.getInstance().izbrisiStudenta(model);
							JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Student je obrisan!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali studenta za brisanje!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				// u slucaju da smo na tabu profesori
				if (TabPane.getInstance().getSelectedIndex() == 1) {
					int red = ProfesoriJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaProfesor.getInstance().getbroj_profesora())) {
						int model=ProfesoriJTable.getInstance().convertRowIndexToModel(red);
						String ispis = "Da li ste sigurni da želite da izbrišete profesora "
								+ BazaProfesor.getInstance().getRow(model).getTitula() + " "
								+ BazaProfesor.getInstance().getRow(model).getIme() + " "
								+ BazaProfesor.getInstance().getRow(model).getPrezime() + "?";
						int code = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), ispis,
								"Brisanje profesora", JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							ProfesorController.getInstance().izbrisiProfesora(model);
							JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Profesor je obrisan!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali profesora za brisanje!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					int red = PredmetJTable.getInstance().getSelectedRow(); // selektovali smo red u tabeli
					// provera da li smo dobro selektovali red
					if (red >= 0 && (red < BazaPredmet.getInstance().getBrojac())) {
						// REFERENCIRAN KOD ZA DIJALOG YES/NO: vezbe4 MyWindowListener
						int model=PredmetJTable.getInstance().convertRowIndexToModel(red);
						int code = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da želite da izbrisete predmet?", "Brisanje predmeta",
								JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							PredmetController.getInstance().izbrisiPredmet(model);
							JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
						}
						if (code == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null, "Predmet nije obrisan!");
						} else {
							JOptionPane.showMessageDialog(null,
									"Niste selektovali red! Morate da selektujete red u tabeli Predmet!", "Upozorenje",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				}

			}
		});

		edit.add(edit1);
		edit.addSeparator();
		edit.add(delete);
		edit.setMnemonic(KeyEvent.VK_E);

		JMenu help = new JMenu("Help");

		JMenuItem help1 = new JMenuItem("Help"); // treba da sadzi detaljan opis o nacinu koriscenja aplikacije
		help1.setMnemonic(KeyEvent.VK_H);
		help1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H, ActionEvent.CTRL_MASK));
		help1.setIcon(new ImageIcon("Slike"+File.separator+"help.png"));
		help1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JTextArea helpTekst = new JTextArea("\t\t Detaljan opis o načnu korišćenja aplikacije \t\t\n\n"
						+ "\t\t NAČIN KORIŠĆENJA APLIKACIJE \n\nTABELA STUDENATA\n\n"
						+ "1.	Dodavanje studenta je moguće pomoću dugmeta na tool baru ili preko File -> New.\n\r\n"
						+ "2.	Izmena studenta moguća je iz pomoću dugmeta na tool baru ili preko Edit-> Edit. \n\r\n"
						+ "3.	Brisanje studenta moguće je pomoću dugmeta na tool baru ili preko Edit -> Delete.\n\r\n"
						+ "	Validacija unosa:\n" + "Datum je u formatu - DD\\MM\\GGGG. \r\n"
						+ "	Broj telefona može sadržati bilo koju cifru i znakove / i -.\r\n"
						+ " Indeks može da sadrži bilo koja slova i brojeve npr E123,"
						+ " ali je ако se upotrebljavaju znaci '/' i '-' neophodno je da indeks bude u prvilnom formatu npr. sw-141-2016 ili RA 142/2019\r\n"
						+ " Indeks mora da bude jedinstven za svakog studenta. "
						+ " Email – bilo_šta@bilo_šta.\r\n"
						+ "	Sva polja u dialogu moraju biti popunjena da bi mogli da dodate studenta, u slučaju da ste nešto"
						+ "pogrešno uneli to polje će da bude crveno. Tek kada sva polja budu zelena moguće je dodati studenta.\n\n\n\r\n"
						+ "TABELA PREDMETA\n\r\n"
						+ "1.	Dodavanje predmeta moguće je pomoću dugmeta na tool baru ili preko File->New\r\n"
						+ "2.	Izmena predmeta moguće je pomoću dugmeta na tool baru ili preko Edit->Edit r\n"
						+ "3.	Brisanje predmeta moguće je pomoću dugmeta na tool baru ili preko Edit->Delete\r\n"
						+ "4.	Dodavanje profesora na predmet moguće je u dialogu izmeni, pritskom na dugme '+' pored profesora, ali samo ako nema nijednog profesora koji predaje predmet."
						+ "\nU suprotnom, u tom polju stoji upisan profesor koji je poslednji dodat na predmet.\r\n"
						+ "Validacija unosa:\r\n"
						+ "Šifra predmeta mora da bude jedinstvena za svaki predmet."
						+ "Sva polja u dialogu moraju biti popunjena i zelena da bi mogli da dodate predmet\n\n\n\r\n"
						+ "TABELA PROFESORA\n\r\n"
						+ "1.	Dodavanje profesora je moguće pomoću dugmeta na tool baru\n\r\n"
						+ "2.	Izmena profesora je moguća je pomoću dugmeta na tool baru ili preko Edit->Edit\n\r\n"
						+ "3.	Brisanje profesora je moguća pomoću digmeta na tool baru ili preko Edit->Delete \n\r\n"
						+ "	Validacija unosa:\r\nBroj lične karte - 9 cifara\n\r\n"
						+ " Datum rođenja u formatu – DD\\MM\\GGGG\n\r\n"
						+ " Sva polja u dialogu moraju biti korektno popunjena da bi mogli da dodate profesora\n\n\n\r\n"
						+ "Prečice:\n" + "ctrl + N – Dodavanje novog entiteta u tabelu na koju smo pozicionirani\r\n"
						+ "ctrl + E – Izmena selektovanog entiteta\r\n"
						+ "ctrl + D – Brisanje selektovanog entiteta\r\n"
					    + "ctrl + H – Prikaz dialoga za pomoć\r\n"
						+ "ctrl + A – Informacija o verziji aplikacije\r\n"
						+ "ctrl + 1 – Informacije o studentu 1\r\n"
						+ "ctrl + 2 – Informacije o studentu 2\r\n"
						+ "ctrl + C - Zatvaranje aplikacije\r\n"
						+ "\n\n***NAPOMENA:Podrazumeva se da kada želimo da radimo određene izmene ili dodajemo određene entitete\n da smo u odgovarajućem tabu i da smo selektovali određeni entitet ako je to potrebno!!!",
						20, 60);
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
		aboutApp.setIcon(new ImageIcon("Slike" + File.separator + "app.png"));
		aboutApp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// Simple dialog - kod preuzet
				SimpleDialog sd = new SimpleDialog(parent, "Informacije o aplikaciji", true); // parent je frame u kome
																								// radimo
				sd.setBackground(new Color(216, 191, 216));
				Label lapp = new Label("Aplikacija Studentska služba, verzija 3.0");
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
		aboutStudent1.setIcon(new ImageIcon("Slike" + File.separator + "User.png"));
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

				JLabel ls1info = new JLabel("<html>Rođena 25.6.1999. godine u Subotici. "
						+ "Student treće godine Fakulteta tehničkih nauka u Novom Sadu, "
						+ "na smeru Računarstvo i automatika.</html>");
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
		aboutStudent2.setIcon(new ImageIcon("Slike" + File.separator + "User.png"));
		aboutStudent2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SimpleDialog sd = new SimpleDialog(parent, "Informacije o studentu 2", true);
				Label ls2 = new Label("Student 2: Aleksandra Mirković");
				Font f = new Font("Sherif", Font.BOLD, 15);
				ls2.setFont(f);
				ls2.setAlignment(WIDTH);
				ls2.setBackground(new Color(216, 191, 216));

				// Koriscenjem JLabel i dodavanjem tagova <html> tekst se prelama kada je to
				// potrebno
				JLabel ls2info = new JLabel("<html>Rođena 17.6.1999. godine u Novom Sadu. "
						+ "Student treće godine Fakulteta tehničkih nauka u Novom Sadu, "
						+ "na smeru Računarstvo i automatika.</html>");
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
		about.setIcon(new ImageIcon("Slike" + File.separator + "about.png"));

		help.add(help1);
		help.add(about);
		help.setMnemonic(KeyEvent.VK_H);

		add(file);
		add(edit);
		add(help);

	}
}