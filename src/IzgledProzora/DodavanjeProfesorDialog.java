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

import controller.ProfesorController;
import model.BazaProfesor;

public class DodavanjeProfesorDialog extends JDialog implements ActionListener {

  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1874286516455478054L;
	JTextField txtIme, txtPrezime, txtDatumRodjenja, txtAdresa, txtTel, txtEmail, txtKancelarija, txtBrLicneKarte,txtTitula,txtZvanje;
	
	
	DodavanjeProfesorDialog() {
			super();
			setTitle("Dodavanje profesora");
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

			//ime
	        JPanel panIme=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblIme=new JLabel("Ime*:");
	        lblIme.setPreferredSize(dim);
	        txtIme=new JTextField();
	        txtIme.setPreferredSize(dim);
	        panIme.add(lblIme);
	        panIme.add(txtIme);
	        
			//prezime
			JPanel panPrezime=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblPrezime=new JLabel("Prezime*:");
	        lblPrezime.setPreferredSize(dim);

	        txtPrezime=new JTextField();
	        txtPrezime.setPreferredSize(dim);

	        panPrezime.add(lblPrezime);
	        panPrezime.add(txtPrezime);
	       
	       
	        
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
	        
	        //Adresa kancelarije
	        JPanel panKancelarija=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblKancelarija=new JLabel("Adresa kancelarije*:");
	        lblKancelarija.setPreferredSize(dim);
	        txtKancelarija=new JTextField();
	        txtKancelarija.setPreferredSize(dim);
	        panKancelarija.add(lblKancelarija);
	        panKancelarija.add(txtKancelarija);
	        
	        //Broj licne karte
	        JPanel panBrLicneKarte=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblBrLicneKarte=new JLabel("Broj licne karte*:");
	        lblBrLicneKarte.setPreferredSize(dim);
	        txtBrLicneKarte=new JTextField();
	        txtBrLicneKarte.setPreferredSize(dim);
	        panBrLicneKarte.add(lblBrLicneKarte);
	        panBrLicneKarte.add(txtBrLicneKarte);
	        
	        
	        //Titula
	        JPanel panTitula=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblTitula=new JLabel("Titula*:");
	        lblTitula.setPreferredSize(dim);
	        txtTitula=new JTextField();
	        txtTitula.setPreferredSize(dim);
	        panTitula.add(lblTitula);
	        panTitula.add(txtTitula);
	        
	        //Zvanje
	        JPanel panZvanje=new JPanel(new FlowLayout(FlowLayout.LEFT));
	        JLabel lblZvanje=new JLabel("Zvanje*:");
	        lblZvanje.setPreferredSize(dim);
	        txtZvanje=new JTextField();
	        txtZvanje.setPreferredSize(dim);
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

			if (e.getActionCommand().equals("ODUSTANI")) {
				dispose();
			} else {
				/*REFERENCIRAN KOD ZA PARSIRANJE DATUMA > https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/*/
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
				BazaProfesor.getInstance().dodajProfesora(tekst[1], tekst[0], LocalDate.parse(tekst[2], formatter), tekst[3], tekst[4], tekst[5],
							tekst[6], tekst[7], tekst[8],tekst[9]);
				ProfesorController.getInstance().dodajProfesora();
				setVisible(false);	
		}

		
	}

}
