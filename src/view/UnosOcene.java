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

import model.BazaNepolozeni;
import model.BazaPolozeni;
import model.BazaPredmet;
import model.BazaStudent;
import model.Ocena;
import model.Predmet;
import model.Student;
import pomocneKlase.MyFocusListener;

public class UnosOcene extends JDialog implements ActionListener{
	
	JTextField txtSifra, txtNaziv, txtDatum;
	JComboBox<String> ocena;
	Predmet predmet;
	Ocena o;

	

	public UnosOcene(Predmet predmet,Ocena o) {
		super();
		setTitle("Unos ocena");
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);
		setModal(true);

		this.predmet = predmet;
		this.o=o;
		
	
		
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		MyFocusListener focusListener = new MyFocusListener();
		
		JButton btnOk = new JButton("POTVRDI");
		JButton btnCancel = new JButton("ODUSTANI");

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);
		//sifra
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Sifra predmeta*:");
		lblSifra.setPreferredSize(dim);

		txtSifra = new JTextField(predmet.getSifraPredmeta());
		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		txtSifra.setEditable(false); //stavljamo da nase polje sifra ne moze da bude menjano
		txtSifra.addFocusListener(focusListener);
		
		panSifra.add(lblSifra);
		panSifra.add(txtSifra);
		
		//naziv
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNaziv = new JLabel("Naziv predmeta*:");
		lblNaziv.setPreferredSize(dim);

		txtNaziv = new JTextField(predmet.getNazivPredmeta());
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		txtNaziv.setEditable(false); //stavljamo da nase polje naziv ne moze da bude menjano
		txtNaziv.addFocusListener(focusListener);
		
		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);
		
		//Ocena
		JPanel panOcena = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblOcena = new JLabel("Ocena*:");
		lblOcena.setPreferredSize(dim);
	
		ocena = new JComboBox<String>();
		ocena.setPreferredSize(dim);
		ocena.addItem("6");
		ocena.addItem("7");
		ocena.addItem("8");
		ocena.addItem("9");
		ocena.addItem("10");
		ocena.setSelectedItem(null);
	
	
	    
	    panOcena.add(lblOcena);
	    panOcena.add(ocena);
	    
	    //Datum
	    JPanel panDatum = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblDatum = new JLabel("Datum*:");
		lblDatum.setPreferredSize(dim);

		txtDatum = new JTextField();
		txtDatum.setPreferredSize(dim);
		txtDatum.setName("txtDatum");
		txtDatum.setToolTipText("Neophodan format: dd/mm/gggg");
		txtDatum.addFocusListener(focusListener);
		txtDatum.addKeyListener(new KeyListener() {

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
		
		panDatum.add(lblDatum);
		panDatum.add(txtDatum);


		panCenter.add(panSifra);
		panCenter.add(panNaziv);
		panCenter.add(panOcena);
		panCenter.add(panDatum);
		panCenter.add(panDatum);
		add(panCenter, BorderLayout.CENTER);
		
		
		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		btnOk.setPreferredSize(new Dimension(150, 25));
		btnOk.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						String tekst[] = pokupiTekst();
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
						
						String ocene =(String) ocena.getSelectedItem();
						int ocena = Integer.parseInt(ocene);
						o.setBrojcanaVrednost(ocena);
						
						
						BazaPolozeni.getInstance().dodajPredmet(o.getStudent(), o.getPredmet(), o.getBrojcanaVrednost(), LocalDate.parse(tekst[3], formatter));
						 PolozeniJTable.getInstance().azurirajPrikaz();
						BazaNepolozeni.getInstance().izbrisiPredmet(predmet.getSifraPredmeta(),o.getStudent());
						
						
				
					     NepolozeniJTable.getInstance().azurirajPrikaz();
					     PolozeniJTable.getInstance().azurirajPrikaz();
					     IzmenaStudentaDialog.instanceIzmenaStudenta.setBtnPonistiEnabled(true);
						setVisible(false);
						
					}
			
				});
		btnOk.setEnabled(false);

		btnCancel.setPreferredSize(new Dimension(150, 25));
		btnCancel.addActionListener(new ActionListener()
				{

					@Override
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						
					}
			
				});
		
		panBottom.add(Box.createGlue());
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(40));

		add(panBottom, BorderLayout.SOUTH);
		setModal(true);
		pack();
		setLocationRelativeTo(GlavniProzor.getInstance());
	}

	public String[] pokupiTekst() {
		String tekst[] = new String[10];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtSifra.getText().toString();
		tekst[1] = txtNaziv.getText().toString();
		tekst[2] = ocena.getSelectedItem().toString();
		tekst[3] = txtDatum.getText().toString();
	

		return tekst;

	}
	protected boolean provera() {
		String tekst[] = pokupiTekst();
		Color correct = new Color(208, 240, 192);
		Color incorrect = new Color(255, 132, 132);
		boolean ok = true;
		boolean ok1 = true;
		if (tekst[3].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("^(0[1-9]|[12][0-9]|3[01])[- /.](0[1-9]|1[012])[- /.][0-9]{4}", tekst[3])) {
				txtDatum.setBackground(incorrect);
				txtDatum.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtDatum.setBackground(correct);
		} else {
			ok = false;
		}

		return ok;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
