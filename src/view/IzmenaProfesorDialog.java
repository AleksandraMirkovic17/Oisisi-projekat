package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.PredmetController;
import controller.ProfesorController;
import model.BazaNepolozeni;
import model.BazaProfesor;
import model.BazaProfesorPredajePredmet;
import model.BazaProfesoriNaPredmetu;
import model.Predmet;
import model.Profesor;
import pomocneKlase.MyFocusListener;

/**
 * Klasa koja modeluje dijalog za izmenu i prikaz informacija prethodno unetog profesora. Dijalog
 * prikazuje 2 taba, jedan za prikaz i izmenu podataka o profesoru a drugi o
 * predmetima na kojima profesor predaje.
 * 
 * @author Aleksandra Mirković
 *
 */

public class IzmenaProfesorDialog extends JDialog implements ActionListener {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Tekstualno polje u koje se unose odgovarajući podaci o profesoru
	 */
	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtKancelarija, txtBrLicneKarte;
	/**
	 * ComboBox sa enum konstantama, od kojih se bira jedna od titula
	 */
	JComboBox<String> titulaCombo;
	/**
	 * ComboBox sa enum vrednosima, od kojih se bira zvanje profesora
	 */
	JComboBox<String> zvanjeCombo;
	/**
	 * Profesor kog želimo da izmenimo
	 */
	Profesor profesor;

	/**
	 * Referenca na instancu ove klase
	 */
	public static IzmenaProfesorDialog instanceIzmenaProfesor;

	/**
	 * Konstruktor klase
	 * 
	 * @param profesor objekat klase profesor kome želi da promenimo neki od polja
	 */
	public IzmenaProfesorDialog(Profesor profesor) {
		super();
		setTitle("Izmena profesora");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		this.profesor = profesor;
		IzmenaProfesorDialog.instanceIzmenaProfesor = this;
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setVisible(true);

		JPanel panel1 = new JPanel();
		BoxLayout boxPanel1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		panel1.setLayout(boxPanel1);
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		MyFocusListener focusListener = new MyFocusListener();

		JButton btnOk = new JButton("IZMENI");
		JButton btnCancel = new JButton("ODUSTANI");
		JButton btnDodaj = new JButton("Dodaj predmet");
		JButton btnUkloni = new JButton("Ukloni predmet");

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);

		// ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		txtIme = new JTextField(profesor.getPrezime());
		txtIme.setPreferredSize(dim);
		txtIme.setName("txtIme");
		txtIme.addFocusListener(focusListener);
		txtIme.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panIme.add(lblIme);
		panIme.add(txtIme);

		// prezime
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);

		txtPrezime = new JTextField(profesor.getIme());
		txtPrezime.setPreferredSize(dim);
		txtPrezime.setName("txtPrezime");
		txtPrezime.addFocusListener(focusListener);
		txtPrezime.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panPrezime.add(lblPrezime);
		panPrezime.add(txtPrezime);
		// datum rodjenja

		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*:");
		LocalDate dr = profesor.getDatumRodjena();
		String formattedDate = dr.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		lblDatumRodjenja.setPreferredSize(dim);

		txtDatumRodjenja = new JTextField(formattedDate);
		txtDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja.setName("txtDatumRodjenja");
		txtDatumRodjenja.setToolTipText("Neophodan format: dd/mm/gggg");
		txtDatumRodjenja.addFocusListener(focusListener);
		txtDatumRodjenja.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
			}
		});
		panDatumRodjenja.add(lblDatumRodjenja);
		panDatumRodjenja.add(txtDatumRodjenja);

		// adresa stanovanja
		JPanel panAdresa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblAdresa = new JLabel("Adresa*:");
		lblAdresa.setPreferredSize(dim);
		txtAdresa = new JTextField(profesor.getAdresaStanovanja());
		txtAdresa.setPreferredSize(dim);
		txtAdresa.setName("txtAdresa");
		txtAdresa.addFocusListener(focusListener);
		txtAdresa.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panAdresa.add(lblAdresa);
		panAdresa.add(txtAdresa);

		// broj telefona
		JPanel panTel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTel = new JLabel("Broj telefona*:");
		lblTel.setPreferredSize(dim);
		txtTel = new JTextField(profesor.getBrojTelefona());
		txtTel.setPreferredSize(dim);
		txtTel.setName("txtTel");
		txtTel.addFocusListener(focusListener);
		txtTel.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panTel.add(lblTel);
		panTel.add(txtTel);

		// E-mail adresa
		JPanel panEmail = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEmail = new JLabel("E-mail adresa*:");
		lblEmail.setPreferredSize(dim);
		txtEmail = new JTextField(profesor.getEmail());
		txtEmail.setPreferredSize(dim);
		txtEmail.setName("txtEmail");
		txtEmail.addFocusListener(focusListener);
		txtEmail.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panEmail.add(lblEmail);
		panEmail.add(txtEmail);

		// Adresa kancelarije
		JPanel panKancelarija = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKancelarija = new JLabel("Adresa kancelarije*:");
		lblKancelarija.setPreferredSize(dim);
		txtKancelarija = new JTextField(profesor.getAdresaKancelarije());
		txtKancelarija.setPreferredSize(dim);
		txtKancelarija.setName("txtKancelarija");
		txtKancelarija.addFocusListener(focusListener);
		txtKancelarija.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panKancelarija.add(lblKancelarija);
		panKancelarija.add(txtKancelarija);

		// Broj licne karte
		JPanel panBrLicneKarte = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblBrLicneKarte = new JLabel("Broj licne karte*:");
		lblBrLicneKarte.setPreferredSize(dim);
		txtBrLicneKarte = new JTextField(profesor.getBrLicneKarte());
		txtBrLicneKarte.setPreferredSize(dim);
		txtBrLicneKarte.setName("txtBrLicneKarte");
		txtBrLicneKarte.addFocusListener(focusListener);
		txtBrLicneKarte.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panBrLicneKarte.add(lblBrLicneKarte);
		panBrLicneKarte.add(txtBrLicneKarte);

		// Titula
		JPanel panTitula = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTitula = new JLabel("Titula*:");
		String titule[] = { "PROF_DR", "Doktor" };
		titulaCombo = new JComboBox<String>(titule);
		lblTitula.setPreferredSize(dim);
		titulaCombo.setPreferredSize(dim);
		if (profesor.getTitulaString() == "PROF_DR") {
			titulaCombo.setSelectedIndex(0);
		} else {
			titulaCombo.setSelectedIndex(1);
		}
		panTitula.add(lblTitula);
		panTitula.add(titulaCombo);
		titulaCombo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panTitula.add(lblTitula);
		panTitula.add(titulaCombo);

		// Zvanje
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*:");
		String zvanje[] = { "REDOVNI_PROFESOR", "VANREDNI_PROFESOR", "DOCENT" };
		zvanjeCombo = new JComboBox<String>(zvanje);
		lblZvanje.setPreferredSize(dim);
		zvanjeCombo.setPreferredSize(dim);
		if (profesor.getZvanjeString() == "PROF_DR") {
			zvanjeCombo.setSelectedIndex(0);
		} else if (profesor.getZvanjeString() == "VANREDNI_PROFESOR") {
			zvanjeCombo.setSelectedIndex(1);
		} else {
			zvanjeCombo.setSelectedIndex(2);
		}
		panZvanje.add(lblZvanje);
		panZvanje.add(zvanjeCombo);
		zvanjeCombo.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		panZvanje.add(lblZvanje);
		panZvanje.add(zvanjeCombo);

		panCenter.add(panIme);
		panCenter.add(panPrezime);
		panCenter.add(panDatumRodjenja);
		panCenter.add(panAdresa);
		panCenter.add(panTel);
		panCenter.add(panEmail);
		panCenter.add(panKancelarija);
		panCenter.add(panBrLicneKarte);
		panCenter.add(panTitula);
		panCenter.add(panZvanje);
		panCenter.add(Box.createVerticalStrut(25));
		panel1.add(panCenter, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		btnOk.setPreferredSize(new Dimension(150, 25));
		btnOk.addActionListener(this);
		btnOk.setEnabled(true); // na pocetku je true kako bismo mogli da sacuvamo profesora sa neizenjenim
								// podacima

		btnCancel.setPreferredSize(new Dimension(150, 25));
		btnCancel.addActionListener(this);

		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(40));

		panel1.add(panBottom, BorderLayout.SOUTH);

		btnDodaj.setPreferredSize(new Dimension(150, 25));
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodajPredmetProfesoru dialog = new DodajPredmetProfesoru(profesor);
				dialog.setVisible(true);
			}
		});
		btnUkloni.setPreferredSize(new Dimension(150, 25));
		btnUkloni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = ProfesorPredmetJTabel.getInstance().getSelectedRow(); // selektovali smo red u tabeli
				Predmet predmet = BazaProfesorPredajePredmet.getInstance().getRow(red);
				if (red != -1) {
					Object[] options = { "Da", "Ne" };

					int code = JOptionPane.showOptionDialog(instanceIzmenaProfesor, "Da li ste sigurni?",
							"Ukloni predmet", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
							options[0]);
					if (code == JOptionPane.YES_OPTION) {
						PredmetController.getInstance().ukloniProfesoraSaPredmetaPrekoProfesora(profesor, predmet);
						BazaProfesorPredajePredmet.getInstance().getPredmeti().remove(red);
						ProfesorPredmetJTabel.getInstance().azurirajPrikaz();
						if (IzmenaPredmetaDialog.instanceIzmenaPredmeta != null) {
							IzmenaPredmetaDialog.instanceIzmenaPredmeta.azurirajPoslednjegProfesora();
						}
						JOptionPane.showMessageDialog(instanceIzmenaProfesor, "Predmet je obrisan!");
					}

				} else {
					JOptionPane.showMessageDialog(instanceIzmenaProfesor,
							"Niste selektovali predmet koji želite da uklonite profesoru!", "Upozorenje",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});

		JPanel panBottom1 = new JPanel();
		BoxLayout box1 = new BoxLayout(panBottom1, BoxLayout.X_AXIS);
		panBottom1.setLayout(box1);
		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(btnDodaj);
		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(btnUkloni);
		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(Box.createVerticalStrut(40));

		JPanel panel2 = new JPanel();
		ProfPredmetTablePane predaje = new ProfPredmetTablePane();
		BoxLayout boxPanel3 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(boxPanel3);

		panel2.add(panBottom1, BorderLayout.NORTH);
		panel2.add(predaje);

		tabbedPane.addTab("Informacije", null, panel1, "Osnovne informacije o profesoru");
		tabbedPane.addTab("Predmeti", null, panel2, "Predmeti koje profesor predaje");
		add(tabbedPane, BorderLayout.CENTER);
		pack();
		setLocationRelativeTo(GlavniProzor.getInstance());
		provera();
	}

	/**
	 * Metoda koja omogućava kupljenje teksta iz tekstualnih polja i ComboBox-eva
	 * 
	 * @return povratna vrednost su pokupljeni stringovi
	 */
	public String[] pokupiTekst() {
		String tekst[] = new String[10];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtIme.getText().toString();
		tekst[1] = txtPrezime.getText().toString();
		tekst[2] = txtDatumRodjenja.getText().toString();
		tekst[3] = txtAdresa.getText().toString();
		tekst[4] = txtTel.getText().toString();
		tekst[5] = txtEmail.getText().toString();
		tekst[6] = txtKancelarija.getText().toString();
		tekst[7] = txtBrLicneKarte.getText().toString();
		tekst[8] = titulaCombo.getSelectedItem().toString();
		tekst[9] = zvanjeCombo.getSelectedItem().toString();

		return tekst;

	}

	/**
	 * Metoda iz interfejsa ActionLister, omogućava reakciju na pritisnute dugmiće
	 * ,,Odustani" ili ,,Potvrdi". Poziva metodu proveri(), a zatim inicira izmenu
	 * atributa objekta profesor.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tekst[] = pokupiTekst();
		boolean izmeni = true; // flag koji nam pokazuje da li je dozvoljeno dodati profesora sa tim
								// parametrima

		// metoda getActionCommand(), vraca string koji je ispisan na kliknutom
		// JButton-u
		if (e.getActionCommand().equals("ODUSTANI")) {
			dispose();
		} else {
			if (!profesor.getBrLicneKarte().equals(tekst[7])) {
				for (Profesor p : BazaProfesor.getInstance().getProfesori()) {
					if (p.getBrLicneKarte().equals(tekst[7])) {
						izmeni = false;
						JOptionPane.showMessageDialog(null, "Profesor sa ovim brojem licne karte vec postoji!",
								"Upozorenje", JOptionPane.WARNING_MESSAGE);
					}
				}
			}

			if (izmeni) {
				/*
				 * REFERENCIRAN KOD ZA PARSIRANJE DATUMA >
				 * https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
				 */
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				String brLicne = profesor.getBrLicneKarte();
				BazaProfesor.getInstance().IzmeniProfesora(brLicne, tekst[0], tekst[1],
						LocalDate.parse(tekst[2], formatter), tekst[4], tekst[3], tekst[5], tekst[6], tekst[7],
						tekst[8], tekst[9]);
				ProfesoriJTable.getInstance().azurirajPrikaz();
				// ProfesorController.getInstance().dodajProfesora();
				setVisible(false);
			}

		}
	}

	/**
	 * Proverava da li smo ispravno uneli parametre prilikom menjanja.
	 * 
	 * @return vraća True ako je naš celokupni unos po pravilima ili False ako nije.
	 */
	protected boolean provera() {
		String tekst[] = pokupiTekst();
		Color correct = new Color(208, 240, 192);
		Color incorrect = new Color(255, 132, 132);
		boolean ok = true;
		boolean ok1 = true;
		if (tekst[0].length() != 0) {
			if (!Pattern.matches("[a-zA-ZćĆčČšŠđĐžŽ ]*", tekst[0])) {
				txtIme.setBackground(incorrect);
				txtIme.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtIme.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[1].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-ZćĆčČšŠđĐžŽ ]*", tekst[1])) {
				txtPrezime.setBackground(incorrect);
				txtPrezime.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtPrezime.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[2].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.][0-9]{4}", tekst[2])) {
				txtDatumRodjenja.setBackground(incorrect);
				txtDatumRodjenja.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtDatumRodjenja.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[3].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-ZćĆčČšŠđĐžŽ 0-9,]*", tekst[3])) {
				txtAdresa.setBackground(incorrect);
				txtAdresa.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtAdresa.setBackground(correct);

		} else {
			ok = false;
		}
		if (tekst[4].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("^[0-9/-]*", tekst[4])) {
				txtTel.setBackground(incorrect);
				txtTel.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtTel.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[5].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("^(.+)@(.+)", tekst[5])) {
				txtEmail.setBackground(incorrect);
				txtEmail.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtEmail.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[6].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-ZćĆčČšŠđĐžŽ 0-9,]*", tekst[6])) {
				txtKancelarija.setBackground(incorrect);
				txtKancelarija.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtKancelarija.setBackground(correct);

		} else {
			ok = false;
		}
		if (tekst[7].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[0-9]{9}", tekst[7])) {
				txtBrLicneKarte.setBackground(incorrect);
				txtBrLicneKarte.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtBrLicneKarte.setBackground(correct);
		} else {
			ok = false;
		}

		return ok;
	}
}
