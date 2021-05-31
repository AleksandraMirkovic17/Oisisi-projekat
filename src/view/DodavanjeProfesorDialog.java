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
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ProfesorController;
import model.BazaProfesor;

import model.Profesor;

import pomocneKlase.MyFocusListener;

/**
 * Klasa koja modeluje dijalog za dodavanje novog profesora u bazu profesora.
 * Ukoliko referent u tabu Profesori odabere neku od opcija za dodavanje novog
 * entiteta (dugme Toolbar-a, stavka menija, odgovarajući akcelerator ili
 * mnemonik) otvara se dijalog koji je modalan i centriran u odnosu na glavni
 * prozor. Prikazuje se forma za unos informacija o profesoru, kao i dva dugmeta
 * za potvrdu i odustanak. Pritisak na dugme "Potvrdi" je moguće samo ako su sva
 * polja validno popunjena. Nakon dodavanja novog profesora u sistem, prikaz
 * tabele sa profesorima se osvežava i sadržaj se ažurira.
 * 
 * Nasleđuje klasu JDialog i implementira interfejs ActionListener.
 * 
 * @author PC
 *
 */

public class DodavanjeProfesorDialog extends JDialog implements ActionListener {
	/**
	 * seijski broj
	 */
	private static final long serialVersionUID = 1874286516455478054L;
	/**
	 * tekstualno polje za unos podataka
	 */
	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtKancelarija, txtBrLicneKarte;
	/**
	 * padajući meni za odabir odgovarajuće vrednosti
	 */
	JComboBox<String> titulaCombo, zvanjeCombo;

	/**
	 * Konstruktor klase
	 */
	DodavanjeProfesorDialog() {
		super();
		// podesavamo dialog prozor
		setTitle("Dodavanje profesora");
		setSize(400, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		MyFocusListener focusListener = new MyFocusListener();

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		// pravimo buttone potvrdi i odustani
		JButton btnOk = new JButton("POTVRDI");
		JButton btnCancel = new JButton("ODUSTANI");
		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);

		// ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);
		txtIme = new JTextField();
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

		txtPrezime = new JTextField();
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
		lblDatumRodjenja.setPreferredSize(dim);
		txtDatumRodjenja = new JTextField();
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
		txtAdresa = new JTextField();
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
		txtTel = new JTextField();
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
		txtEmail = new JTextField();
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
		txtKancelarija = new JTextField();
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
		txtBrLicneKarte = new JTextField();
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
		String titule[] = { "Profesor doktor", "Doktor" };
		titulaCombo = new JComboBox<String>(titule);
		lblTitula.setPreferredSize(dim);
		titulaCombo.setPreferredSize(dim);

		panTitula.add(lblTitula);
		panTitula.add(titulaCombo);

		// Zvanje
		JPanel panZvanje = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblZvanje = new JLabel("Zvanje*:");
		String zvanje[] = { "REDOVNI_PROFESOR", "VANREDNI_PROFESOR", "DOCENT" };
		zvanjeCombo = new JComboBox<String>(zvanje);
		lblZvanje.setPreferredSize(dim);
		zvanjeCombo.setPreferredSize(dim);
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
		add(panCenter, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		btnOk.setPreferredSize(new Dimension(150, 25));
		btnOk.addActionListener(this);

		btnCancel.setPreferredSize(new Dimension(150, 25));
		btnCancel.addActionListener(this);

		panBottom.add(Box.createGlue());
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(40));

		add(panBottom, BorderLayout.SOUTH);
		pack();

	}

	/**
	 * Metoda koja kupi uneti tekst iz tekstualnih polja i ComboBox-eva
	 * 
	 * @return niz pokupljenih stingova
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
	 * Metoda koja nam reaguje na pritisnuto dugme za odustanak i potvrdu unetih
	 * podataka, čime se inicira unošenje profesora sa odgovarajućim unetim podacima
	 * u sistem. Vrši se i provera da li su svi podaci ispravno uneti, kao i da li
	 * se narušava jedinstvenost ključa.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tekst[] = pokupiTekst();
		boolean dodaj = true; // flag koji nam pokazuje da li je dozvoljeno dodati profesora sa tim
								// parametrima

		// metoda getActionCommand(), vraca string koji je ispisan na kliknutom
		// JButton-u
		if (e.getActionCommand().equals("ODUSTANI")) {
			dispose();
		} else {
			if (BazaProfesor.getInstance().getProfesori().size() == 0) {
				dodaj = true;
			} else {
				for (Profesor p : BazaProfesor.getInstance().getProfesori()) {
					if (p.getBrLicneKarte().equals(tekst[7])) {
						dodaj = false;
						JOptionPane.showMessageDialog(null, "Profesor sa ovim brojem licne karte vec postoji!",
								"Upozorenje", JOptionPane.WARNING_MESSAGE);
					}
				}
			}

			if (dodaj) {
				/*
				 * REFERENCIRAN KOD ZA PARSIRANJE DATUMA >
				 * https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/
				 */
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				BazaProfesor.getInstance().dodajProfesora(tekst[1], tekst[0], LocalDate.parse(tekst[2], formatter),
						tekst[4], tekst[3], tekst[5], tekst[6], tekst[7], tekst[8], tekst[9]);
				ProfesorController.getInstance().dodajProfesora();
				setVisible(false);
			}

		}
	}

	/**
	 * Metoda koja proverava da li su sva polja ispravno popunjena. U slučaju da
	 * neki od formata nije ispoštovan vraća vrednost false.
	 * 
	 * @return boolean vrednost pokazuje da li su podaci ispravno uneti
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
