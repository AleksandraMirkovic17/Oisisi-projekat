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
import controller.StudentController;
import model.BazaNepolozeni;
import model.BazaPolozeni;
import model.BazaPredmet;
import model.BazaStudent;
import model.Ocena;
import model.Predmet;
import model.Student;
import pomocneKlase.MyFocusListener;
import pomocneKlase.SimpleDialog;

public class IzmenaStudentaDialog extends JDialog implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = 5282385078335739861L;

	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtIndeks, txtGodinaUpisa;
	JComboBox<String> trenutnaGodinaCombo, finansCombo;
	JLabel prosecnaOcena;
	Student student;

	public static IzmenaStudentaDialog instanceIzmenaStudenta;
	JButton btnPonisti;

	public IzmenaStudentaDialog(Student student) {
		super();
		setTitle("Izmena studenta");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		this.student = student;
		IzmenaStudentaDialog.instanceIzmenaStudenta = this;
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setVisible(true);

		// Prvi panel (panel1) omogucava izmenu osnovnih informacija o studentu

		JPanel panel1 = new JPanel();
		BoxLayout boxPanel1 = new BoxLayout(panel1, BoxLayout.Y_AXIS);
		panel1.setLayout(boxPanel1);
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		MyFocusListener focusListener = new MyFocusListener();

		JButton btnOk = new JButton("IZMENI");
		JButton btnCancel = new JButton("ODUSTANI");
		JButton btnDodaj = new JButton("Dodaj");
		JButton btnObrisi = new JButton("Obriši");
		JButton btnPolaganje = new JButton("Polaganje");

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);

		// prezime
		JPanel panPrezime = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblPrezime = new JLabel("Prezime*:");
		lblPrezime.setPreferredSize(dim);

		txtPrezime = new JTextField(student.getPrezime());
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

		// ime
		JPanel panIme = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIme = new JLabel("Ime*:");
		lblIme.setPreferredSize(dim);

		txtIme = new JTextField(student.getIme());
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

		// datum rodjenja
		JPanel panDatumRodjenja = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatumRodjenja = new JLabel("Datum rođenja*:");
		/*
		 * REFERENCIRAN KOD ZA FORMATIRANJE DATUMA RODJENJA:
		 * https://howtodoinjava.com/java/date-time/localdate-format-example
		 */
		LocalDate dr = student.getDatumRodjenja();
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

		txtAdresa = new JTextField(student.getAdresaStanovanja());
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

		txtTel = new JTextField(student.getKontaktTelefon().toString());
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

		txtEmail = new JTextField(student.getEmail());
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

		// Broj indeksa
		JPanel panIndeks = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblIndeks = new JLabel("Broj indeksa*:");
		lblIndeks.setPreferredSize(dim);

		txtIndeks = new JTextField(student.getBrIndeksa());
		txtIndeks.setPreferredSize(dim);
		txtIndeks.setName("txtIndeks");
		txtIndeks.addFocusListener(focusListener);
		txtIndeks.addKeyListener(new KeyListener() {

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

		panIndeks.add(lblIndeks);
		panIndeks.add(txtIndeks);

		// Godina upisa
		JPanel panGodinaUpisa = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodinaUpisa = new JLabel("Godina upisa*:");
		lblGodinaUpisa.setPreferredSize(dim);
		int gu = student.getGodinaUpisa();
		System.out.println(gu);
		String guString = "" + gu;
		txtGodinaUpisa = new JTextField(guString);
		txtGodinaUpisa.setPreferredSize(dim);
		txtGodinaUpisa.setName("txtGodinaUpisa");
		txtGodinaUpisa.addFocusListener(focusListener);
		txtGodinaUpisa.addKeyListener(new KeyListener() {

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

		panGodinaUpisa.add(lblGodinaUpisa);
		panGodinaUpisa.add(txtGodinaUpisa);

		// Trenutna godina studija
		JPanel panTrenutnaGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTrenutnaGodina = new JLabel("Trenutna godina studija*:");
		String godina[] = { "1", "2", "3", "4" };
		trenutnaGodinaCombo = new JComboBox<String>(godina);
		trenutnaGodinaCombo.setSelectedIndex(student.getTrenutnaGodinaStudija() - 1);
		lblTrenutnaGodina.setPreferredSize(dim);
		trenutnaGodinaCombo.setPreferredSize(dim);
		trenutnaGodinaCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		panTrenutnaGodina.add(lblTrenutnaGodina);
		panTrenutnaGodina.add(trenutnaGodinaCombo);

		// Nacin finansiranja
		JPanel panFinans = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblFinans = new JLabel("Način finansiranja*:");
		String finansiranje[] = { "Budžet", "Samofinansiranje" };
		finansCombo = new JComboBox<String>(finansiranje);
		lblFinans.setPreferredSize(dim);
		finansCombo.setPreferredSize(dim);
		if (student.getStatusChar() == 'B') {
			finansCombo.setSelectedIndex(0);
		} else {
			finansCombo.setSelectedIndex(1);
		}
		panFinans.add(lblFinans);
		panFinans.add(finansCombo);

		panCenter.add(panIme);
		panCenter.add(panPrezime);
		panCenter.add(panDatumRodjenja);
		panCenter.add(panAdresa);
		panCenter.add(panTel);
		panCenter.add(panEmail);
		panCenter.add(panIndeks);
		panCenter.add(panGodinaUpisa);
		panCenter.add(panTrenutnaGodina);
		panCenter.add(panFinans);
		panCenter.add(Box.createVerticalStrut(25));
		panel1.add(panCenter, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		JPanel panBottom1 = new JPanel();
		BoxLayout box1 = new BoxLayout(panBottom1, BoxLayout.X_AXIS);
		panBottom1.setLayout(box1);

		btnOk.setPreferredSize(new Dimension(150, 25));
		btnOk.addActionListener(this);
		btnOk.setEnabled(true); // na pocetku je true, kako bi mogli da sacuvamo studenta sa neizmenjenim
								// podacima

		btnCancel.setPreferredSize(new Dimension(150, 25));
		btnCancel.addActionListener(this);

		btnDodaj.setPreferredSize(new Dimension(150, 25));
		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DodavanjePredmetaStudentuDialog dialog = new DodavanjePredmetaStudentuDialog(student,
						instanceIzmenaStudenta);
				dialog.setVisible(true);
			}
		});
		btnObrisi.setPreferredSize(new Dimension(150, 25));
		btnObrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = NepolozeniJTable.getInstance().getSelectedRow(); // selektovali smo red u tabeli
				if (red != -1) {
					Object[] options = { "Da", "Ne" };

					int code = JOptionPane.showOptionDialog(instanceIzmenaStudenta,
							"Da li ste sigurni da želite da uklonite predmet?", "Uklanjanje predmeta",
							JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
					if (code == JOptionPane.YES_OPTION) {
						Predmet prr = BazaNepolozeni.getInstance().getNepolozeniPredmeti().get(red);
						BazaNepolozeni.getInstance().getNepolozeniPredmeti().remove(red);
						NepolozeniJTable.getInstance().azurirajPrikaz();
						JOptionPane.showMessageDialog(instanceIzmenaStudenta, "Predmet je obrisan!");
						for (int i = 0; i < prr.getNisuPoloziliPredmet().size(); i++) {
							if(prr.getNisuPoloziliPredmet().get(i).getBrIndeksa().equals(student.getBrIndeksa())) {
								prr.getPoloziliPredmet().remove(i);
							}
						}

					}

				} else {
					JOptionPane.showMessageDialog(instanceIzmenaStudenta,
							"Niste selektovali predmet koji želite da uklonite studentu!", "Upozorenje",
							JOptionPane.WARNING_MESSAGE);
				}

			}
		});
		btnPolaganje.setPreferredSize(new Dimension(150, 25));
		btnPolaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int red = NepolozeniJTable.getInstance().getSelectedRow();
				Predmet p = BazaNepolozeni.getInstance().getRow(red);
				if (red >= 0 && (red < BazaNepolozeni.getInstance().getInc())) {
					Ocena o = new Ocena(p, student);
					UnosOcene dialog = new UnosOcene(p, o);
					dialog.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet!", "Upozorenje!",
							JOptionPane.WARNING_MESSAGE);
				}
			}

		}

		);

		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(40));

		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(btnDodaj);
		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(btnObrisi);
		panBottom1.add(Box.createHorizontalStrut(10));
		panBottom1.add(btnPolaganje);

		panel1.add(panBottom, BorderLayout.SOUTH);

		// panel 2 - prikaz polozenih predmeta kod studenta
		PolozeniTablePanel polozeni = new PolozeniTablePanel();
		JPanel panel2 = new JPanel();
		BoxLayout boxPanel2 = new BoxLayout(panel2, BoxLayout.Y_AXIS);
		panel2.setLayout(boxPanel2);

		JPanel info = new JPanel();
		BoxLayout boxPaneInfo = new BoxLayout(info, BoxLayout.Y_AXIS);
		info.setLayout(boxPaneInfo);

		double prosecnaO = student.getProsecnaOcena();
		String s = new String("Prosečna ocena: " + String.valueOf(prosecnaO));
		prosecnaOcena = new JLabel(s);
		String s1 = new String("Ukupno ESPB: " + String.valueOf(student.getUkupnoEspb()));
		JLabel ukupnoEspb = new JLabel(s1);

		JPanel panelBtn = new JPanel();
		BoxLayout boxPanel21 = new BoxLayout(panelBtn, BoxLayout.X_AXIS);
		panelBtn.setLayout(boxPanel21);
		btnPonisti = new JButton("Poništi ocenu");

		if (student.getPolozeniPredmeti().size() == 0) {
			btnPonisti.setEnabled(false); // dugme za ponistavanje ocene u slucaju da student nema polozenih predmeta je
											// false
		}

		btnPonisti.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int red = PolozeniJTable.getInstance().getSelectedRow();
				if (red >= 0 && (red < BazaPolozeni.getInstance().getInc())) {
					Ocena o = BazaPolozeni.getInstance().getRow(red);
					PonistavanjeOcene po = new PonistavanjeOcene(o, red);
				} else {
					if (student.getPolozeniPredmeti().size() == 0) {
						JOptionPane.showMessageDialog(null, "Student nema položenih predmeta!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
						btnPonisti.setEnabled(false);
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali ocenu za poništavanje!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
		panelBtn.add(btnPonisti);
		panelBtn.add(Box.createVerticalStrut(20));

		info.add(prosecnaOcena);
		info.add(ukupnoEspb);

		panel2.add(Box.createVerticalStrut(10));
		panel2.add(Box.createHorizontalStrut(5));
		panel2.add(panelBtn, BorderLayout.NORTH);
		panel2.add(Box.createVerticalStrut(10));
		panel2.add(polozeni);
		panel2.add(Box.createHorizontalBox());
		panel2.add(info, BorderLayout.PAGE_END);

		// panel 3 - prikaz nepolozenih predmeta kod studenta

		NepolozeniTablePanel nepolozeni = new NepolozeniTablePanel();
		JPanel panel3 = new JPanel();
		BoxLayout boxPanel3 = new BoxLayout(panel3, BoxLayout.Y_AXIS);
		panel3.setLayout(boxPanel3);
		panel3.add(panBottom1, BorderLayout.NORTH);
		panel3.add(nepolozeni);

		tabbedPane.addTab("Informacije", null, panel1, "Osnovne informacije o studentu");
		tabbedPane.addTab("Položeni", null, panel2, "Spisak predmeta koje je student položio");
		tabbedPane.addTab("Nepoloženi", null, panel3, "Spisak nepoloženih predmeta kod studenta");

		add(tabbedPane, BorderLayout.CENTER);

		pack();
		setLocationRelativeTo(GlavniProzor.getInstance()); // da bi dialog bio centriran neophodno je pozvati metodu
															// setLocationRelativeTo(parent frame) posle pozivanja
															// metode pack
		provera(); // proveravamo da bismo na pocetku imali sva polja zelena i dugme "IZMENI"
					// upotrebljivo iako jos nista nismo kucali
	}

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
		tekst[6] = txtIndeks.getText().toString();
		tekst[7] = txtGodinaUpisa.getText().toString();
		tekst[8] = trenutnaGodinaCombo.getSelectedItem().toString();
		tekst[9] = finansCombo.getSelectedItem().toString();

		return tekst;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tekst[] = pokupiTekst();
		boolean izmeni = true; // flag koji nam pokazuje da li je dozvoljeno izmeniti studenta sa zeljenim
								// parametrima (brojem indeksa)

		// metoda getActionCommand(), vraca string koji je ispisan na kliknutom
		// JButton-u
		if (e.getActionCommand().equals("ODUSTANI")) {
			dispose();
		} else {
			if (!student.getBrIndeksa().equals(tekst[6])) {
				for (Student s : BazaStudent.getInstance().getStudenti()) {
					if (s.getBrIndeksa().equals(tekst[6])) {
						izmeni = false;
						JOptionPane.showMessageDialog(null, "Student sa unetim brojem indeksa već postoji!",
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
				String pocetniIndeks = student.getBrIndeksa();
				BazaStudent.getInstance().izmeniStudenta(pocetniIndeks, tekst[1], tekst[0],
						LocalDate.parse(tekst[2], formatter), tekst[3], tekst[4], tekst[5], tekst[6],
						Integer.parseInt(tekst[7]), Integer.parseInt(tekst[8]), tekst[9].charAt(0));
				// StudentiJTable.getInstance().refresTabelu();
				setVisible(false);
			}
		}

	}

	protected boolean provera() {
		String tekst[] = pokupiTekst();
		Color correct = new Color(208, 240, 192);
		Color incorrect = new Color(255, 132, 132);
		boolean ok = true;
		boolean ok1 = true;
		if (tekst[0].length() != 0) {
			if (!Pattern.matches("[a-zA-ZčČćĆđĐžŽšŠ ]*", tekst[0])) {
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
			if (!Pattern.matches("[a-zA-ZčČćĆđĐžŽšŠ ]*", tekst[1])) {
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
			if (!Pattern.matches("[a-zA-ZčČćĆđĐžŽšŠ 0-9,]*", tekst[3])) {
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
			if (!Pattern.matches("[a-z]{2,3}-[0-9]{1,3}-[0-9]{4}", tekst[6])
					&& !Pattern.matches("[a-zA-ZčČćĆđĐžŽšŠ 0-9 ]*", tekst[6]) && !Pattern.matches("[A-Z]{2,3} [0-9]{1,3}/[0-9]{4}" , tekst[6])) {
				txtIndeks.setBackground(incorrect);
				txtIndeks.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtIndeks.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[7].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[0-9]{4}", tekst[7])) {
				txtGodinaUpisa.setBackground(incorrect);
				txtGodinaUpisa.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtGodinaUpisa.setBackground(correct);
		} else {
			ok = false;
		}

		return ok;
	}

	public static IzmenaStudentaDialog getInstance() {
		return instanceIzmenaStudenta;

	}

	public void setBtnPonistiEnabled(boolean b) {
		this.btnPonisti.setEnabled(b);
	}

	public void setBtnPonistiAkoNemaPolozenih() {
		if (student.getPolozeniPredmeti().size() == 0) {
			btnPonisti.setEnabled(false);
		} else {
			btnPonisti.setEnabled(true);
		}
	}

	public void izmenaProsecneOcene() {
		double prosecnaO = student.getProsecnaOcena();
		String s = new String("Prosečna ocena: " + String.valueOf(prosecnaO));
		prosecnaOcena.setText(s);
	}

}
