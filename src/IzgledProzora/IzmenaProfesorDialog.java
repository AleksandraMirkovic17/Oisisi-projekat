package IzgledProzora;

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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.ProfesorController;
import model.BazaProfesor;
import model.Profesor;
import pomocneKlase.MyFocusListener;

public  class IzmenaProfesorDialog extends JDialog implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtKancelarija, txtBrLicneKarte,txtTitula,txtZvanje;
	Profesor profesor;
	public IzmenaProfesorDialog(Profesor profesor)
	{
		super();
		setTitle("Izmena profesora");
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setModal(true);
		this.profesor = profesor;
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

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);
		
		//ime
        JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lblIme=new JLabel("Ime*:");
        lblIme.setPreferredSize(dim);
        txtIme=new JTextField(profesor.getIme());
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
		
		
	
	//prezime
	JPanel panPrezime=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblPrezime=new JLabel("Prezime*:");
    lblPrezime.setPreferredSize(dim);

    txtPrezime=new JTextField(profesor.getPrezime());
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
    //datum rodjenja
    
    JPanel panDatumRodjenja=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblDatumRodjenja=new JLabel("Datum rodjenja*:");
    
    LocalDate dr = profesor.getDatumRodjena();
	String formattedDate = dr.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	lblDatumRodjenja.setPreferredSize(dim);

	txtDatumRodjenja = new JTextField(formattedDate);
   
    txtDatumRodjenja=new JTextField(profesor.getDatumRodjena().toString());
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
    
    //adresa stanovanja
    JPanel panAdresa=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblAdresa=new JLabel("Adresa*:");
    lblAdresa.setPreferredSize(dim);
    txtAdresa=new JTextField(profesor.getAdresaStanovanja());
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
    
    //broj telefona
    JPanel panTel=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblTel=new JLabel("Broj telefona*:");
    lblTel.setPreferredSize(dim);
    txtTel=new JTextField(profesor.getBrojTelefona());
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

    //E-mail adresa
    JPanel panEmail=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblEmail=new JLabel("E-mail adresa*:");
    lblEmail.setPreferredSize(dim);
    txtEmail=new JTextField(profesor.getEmail());
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
    
    //Adresa kancelarije
    JPanel panKancelarija=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblKancelarija=new JLabel("Adresa kancelarije*:");
    lblKancelarija.setPreferredSize(dim);
    txtKancelarija=new JTextField(profesor.getAdresaKancelarije());
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
    
    //Broj licne karte
    JPanel panBrLicneKarte=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblBrLicneKarte=new JLabel("Broj licne karte*:");
    lblBrLicneKarte.setPreferredSize(dim);
    txtBrLicneKarte=new JTextField(profesor.getBrLicneKarte());
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
    
    
    //Titula
    JPanel panTitula=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblTitula=new JLabel("Titula*:");
    lblTitula.setPreferredSize(dim);
    txtTitula=new JTextField(profesor.getTitula());
    txtTitula.setPreferredSize(dim);
    txtTitula.setName("txtTitula");
    txtTitula.addFocusListener(focusListener);
    txtTitula.addKeyListener(new KeyListener() {

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
    panTitula.add(txtTitula);
    
    //Zvanje
    JPanel panZvanje=new JPanel(new FlowLayout(FlowLayout.LEFT));
    JLabel lblZvanje=new JLabel("Zvanje*:");
    lblZvanje.setPreferredSize(dim);
    txtZvanje=new JTextField(profesor.getZvanjeProfesora());
    txtZvanje.setPreferredSize(dim);
    txtZvanje.setName("txtZvanje");
    txtZvanje.addFocusListener(focusListener);
    txtZvanje.addKeyListener(new KeyListener() {

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
    panZvanje.add(txtZvanje);
    

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
    panel1.add(panCenter,BorderLayout.CENTER);
   
  
	
	JPanel panBottom=new JPanel();
	BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
	panBottom.setLayout(box);
	
	
	btnOk.setPreferredSize(new Dimension(150,25));
	btnOk.addActionListener(this);
	btnOk.setEnabled(true); //na pocetku je true kako bismo mogli da sacuvamo profesora sa neizenjenim podacima

	

	btnCancel.setPreferredSize(new Dimension(150,25));
	btnCancel.addActionListener(this);


	panBottom.add(Box.createHorizontalStrut(10));
	panBottom.add(btnOk);
	panBottom.add(Box.createHorizontalStrut(10));
	panBottom.add(btnCancel);
	panBottom.add(Box.createHorizontalStrut(10));
	panBottom.add(Box.createVerticalStrut(40));
	
	panel1.add(panBottom, BorderLayout.SOUTH);
	
	
	JPanel panel2=new JPanel();
	
	tabbedPane.addTab("Informacije", null,panel1,"Osnovne informacije o profesoru");
	tabbedPane.addTab("Predmeti", null,panel2,"Predmeti koje profesor predaje");
	add(tabbedPane,BorderLayout.CENTER);
	pack();
	setLocationRelativeTo(GlavniProzor.getInstance());
	provera();
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
		tekst[6] = txtKancelarija.getText().toString();
		tekst[7]= txtBrLicneKarte.getText().toString();
		tekst[8] = txtTitula.getText().toString();
		tekst[9] = txtZvanje.getText().toString();
		
		
		return tekst;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tekst[] = pokupiTekst();
		boolean izmeni = true; // flag koji nam pokazuje da li je dozvoljeno dodati profesora sa tim parametrima

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
			/*REFERENCIRAN KOD ZA PARSIRANJE DATUMA > https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/*/
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
			String brLicne=profesor.getBrLicneKarte();
			BazaProfesor.getInstance().IzmeniProfesora(tekst[1], tekst[0], LocalDate.parse(tekst[2], formatter), tekst[4], tekst[3], tekst[5],
						tekst[6], brLicne, tekst[8],tekst[9]);
			//ProfesorController.getInstance().dodajProfesora();
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
			if (!Pattern.matches("[a-zA-Z ]*", tekst[0])) {
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
			if (!Pattern.matches("[a-zA-Z ]*", tekst[1])) {
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
			if (!Pattern.matches("[a-zA-Z 0-9,]*", tekst[3])) {
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
			if (!Pattern.matches("[a-zA-Z 0-9,]*", tekst[3])) {
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
		if (tekst[8].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-Z0-9_ .]*", tekst[7])) {
				txtTitula.setBackground(incorrect);
				txtTitula.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtTitula.setBackground(correct);
		} else {
			ok = false;
		}			 
		if (tekst[9].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-Z0-9_ .]*", tekst[7])) {
				txtZvanje.setBackground(incorrect);
				txtZvanje.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtZvanje.setBackground(correct);
		} else {
			ok = false;
		
		}
		return ok;
  }
}
