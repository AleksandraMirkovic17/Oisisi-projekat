package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import controller.StudentController;
import model.BazaStudent;


public class DodavanjeStudentaDialog extends JDialog implements ActionListener {

		/**
	 * 
	 */
	private static final long serialVersionUID = 5282385078335739861L;
	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtIndeks, txtGodinaUpisa;
	JComboBox<String> trenutnaGodinaCombo, finansCombo;
	
	
	DodavanjeStudentaDialog() {
			super();
			setTitle("Dodavanje studenta");
			setSize(400,400);
			setLocationRelativeTo(null);
	        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
			setVisible(true);
			setResizable(false);
		
			JPanel panCenter=new JPanel();
			BoxLayout boxCenter=new BoxLayout(panCenter, BoxLayout.Y_AXIS);
			panCenter.setLayout(boxCenter);
		    
	        
			//dimenzije labela i tekstualnih komponenti
			Dimension dim=new Dimension(150,20);

			
			//prezime
			JPanel panPrezime=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblPrezime=new JLabel("Prezime*:");
	        lblPrezime.setPreferredSize(dim);

	        txtPrezime=new JTextField();
	        txtPrezime.setPreferredSize(dim);

	        panPrezime.add(lblPrezime);
	        panPrezime.add(txtPrezime);
	       
	        //ime
	        JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblIme=new JLabel("Ime*:");
	        lblIme.setPreferredSize(dim);
	        txtIme=new JTextField();
	        txtIme.setPreferredSize(dim);
	        panIme.add(lblIme);
	        panIme.add(txtIme);
	        
	        //datum rodjenja
	        JPanel panDatumRodjenja=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblDatumRodjenja=new JLabel("Datum rodjenja*:");
	        lblDatumRodjenja.setPreferredSize(dim);
	        txtDatumRodjenja=new JTextField();
	        txtDatumRodjenja.setPreferredSize(dim);
	        panDatumRodjenja.add(lblDatumRodjenja);
	        panDatumRodjenja.add(txtDatumRodjenja);
	        
	        //adresa stanovanja
	        JPanel panAdresa=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblAdresa=new JLabel("Adresa*:");
	        lblAdresa.setPreferredSize(dim);
	        txtAdresa=new JTextField();
	        txtAdresa.setPreferredSize(dim);
	        panAdresa.add(lblAdresa);
	        panAdresa.add(txtAdresa);
	        
	        //broj telefona
	        JPanel panTel=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblTel=new JLabel("Broj telefona*:");
	        lblTel.setPreferredSize(dim);
	        txtTel=new JTextField();
	        txtTel.setPreferredSize(dim);
	        panTel.add(lblTel);
	        panTel.add(txtTel);

	        //E-mail adresa
	        JPanel panEmail=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblEmail=new JLabel("E-mail adresa*:");
	        lblEmail.setPreferredSize(dim);
	        txtEmail=new JTextField();
	        txtEmail.setPreferredSize(dim);
	        panEmail.add(lblEmail);
	        panEmail.add(txtEmail);
	        
	        //Broj indeksa
	        JPanel panIndeks=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblIndeks=new JLabel("Broj indeksa*:");
	        lblIndeks.setPreferredSize(dim);
	        txtIndeks=new JTextField();
	        txtIndeks.setPreferredSize(dim);
	        panIndeks.add(lblIndeks);
	        panIndeks.add(txtIndeks);
	        
	        //Godina upisa
	        JPanel panGodinaUpisa=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblGodinaUpisa=new JLabel("Godina upisa*:");
	        lblGodinaUpisa.setPreferredSize(dim);
	        txtGodinaUpisa=new JTextField();
	        txtGodinaUpisa.setPreferredSize(dim);
	        panGodinaUpisa.add(lblGodinaUpisa);
	        panGodinaUpisa.add(txtGodinaUpisa);
	        
	        //Trenutna godina studija
	        JPanel panTrenutnaGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel lblTrenutnaGodina = new JLabel("Trenutna godina studija*:");
			String godina[] = { "	", "1", "2", "3", "4" };
			trenutnaGodinaCombo = new JComboBox<String>(godina);
			lblTrenutnaGodina.setPreferredSize(dim);
			trenutnaGodinaCombo.setPreferredSize(dim);
			panTrenutnaGodina.add(lblTrenutnaGodina);
			panTrenutnaGodina.add(trenutnaGodinaCombo);
			
			//Nacin finansiranja
	        JPanel panFinans = new JPanel(new FlowLayout(FlowLayout.LEFT));
			JLabel lblFinans = new JLabel("Nacin finansiranja*:");
			String finansiranje[] = { "	", "Budzet", "Samofinansiranje" };
			finansCombo = new JComboBox<String>(finansiranje);
			lblFinans.setPreferredSize(dim);
			finansCombo.setPreferredSize(dim);
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
	        add(panCenter,BorderLayout.CENTER);
	       
	      
			
			JPanel panBottom=new JPanel();
			BoxLayout box=new BoxLayout(panBottom, BoxLayout.X_AXIS);
			panBottom.setLayout(box);
			
			JButton btnOk=new JButton("POTVRDI");
			btnOk.setPreferredSize(new Dimension(150,25));
			btnOk.addActionListener(this);

			
			JButton btnCancel=new JButton("ODUSTANI");
			btnCancel.setPreferredSize(new Dimension(150,25));
			btnCancel.addActionListener(this);
			
			panBottom.add(Box.createGlue());
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(btnOk);
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(btnCancel);
			panBottom.add(Box.createHorizontalStrut(10));
			panBottom.add(Box.createVerticalStrut(40));			

			add(panBottom,BorderLayout.SOUTH);
			pack();
			
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

			if (e.getActionCommand().equals("ODUSTANI")) {
				dispose();
			} else {
				/*REFERENCIRAN KOD ZA PARSIRANJE DATUMA > https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/*/
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				BazaStudent.getInstance().dodajStudenta(tekst[1], tekst[0], LocalDate.parse(tekst[2], formatter), tekst[3], tekst[4], tekst[5],
							tekst[6], Integer.parseInt(tekst[7]), Integer.parseInt(tekst[8]), tekst[9].charAt(0));
				StudentController.getInstance().dodajStudenta();
				setVisible(false);	
		}

		}}


