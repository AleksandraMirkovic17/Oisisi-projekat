package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import controller.PredmetController;
import model.BazaPredmet;
import model.Predmet;
import pomocneKlase.MyFocusListener;

public class DodavanjePredmetaDialog extends JDialog implements ActionListener {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	JTextField txtSifra, txtNaziv, txtGodina, txtEspb;
	JComboBox<String> semestarCombo;

	DodavanjePredmetaDialog() {
		super();
		setTitle("Dodavanje predmeta");
		setSize(400, 400);
		setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
		setResizable(false);

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		MyFocusListener focusListener = new MyFocusListener();

		JButton btnOk = new JButton("POTVRDI");
		JButton btnCancel = new JButton("ODUSTANI");

		// dimenzije labela i tekstualnih komponenti
		Dimension dim = new Dimension(150, 20);

		// sifra
		JPanel panSifra = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSifra = new JLabel("Sifra predmeta*:");
		lblSifra.setPreferredSize(dim);

		txtSifra = new JTextField();
		txtSifra.setPreferredSize(dim);
		txtSifra.setName("txtSifra");
		txtSifra.addFocusListener(focusListener);
		txtSifra.addKeyListener(new KeyListener() {

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

		panSifra.add(lblSifra);
		panSifra.add(txtSifra);

		// naziv
		JPanel panNaziv = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNaziv = new JLabel("Naziv*:");
		lblNaziv.setPreferredSize(dim);

		txtNaziv = new JTextField();
		txtNaziv.setPreferredSize(dim);
		txtNaziv.setName("txtNaziv");
		txtNaziv.addFocusListener(focusListener);
		txtNaziv.addKeyListener(new KeyListener() {

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

		panNaziv.add(lblNaziv);
		panNaziv.add(txtNaziv);

		// Espb bodova
		JPanel panEspb = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblEspb = new JLabel("ESPB*:");
		lblEspb.setPreferredSize(dim);

		txtEspb = new JTextField();
		txtEspb.setPreferredSize(dim);
		txtEspb.setName("txtEspb");
		txtEspb.addFocusListener(focusListener);
		txtEspb.addKeyListener(new KeyListener() {

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

		panEspb.add(lblEspb);
		panEspb.add(txtEspb);

		// godina na kojoj se slusa predmet
		JPanel panGodina = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGodina = new JLabel("Godina*:");
		lblGodina.setPreferredSize(dim);

		txtGodina = new JTextField();
		txtGodina.setPreferredSize(dim);
		txtGodina.setName("txtGodina");
		txtGodina.addFocusListener(focusListener);
		txtGodina.addKeyListener(new KeyListener() {

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

		panGodina.add(lblGodina);
		panGodina.add(txtGodina);

		// Semetar
		JPanel panSemestar = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel lblSemestar = new JLabel("Semestar*:");
		String semestar[] = { "ZIMSKI", "LETNJI" };
		semestarCombo = new JComboBox<String>(semestar);
		lblSemestar.setPreferredSize(dim);
		semestarCombo.setPreferredSize(dim);
		semestarCombo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (provera()) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		panSemestar.add(lblSemestar);
		panSemestar.add(semestarCombo);

		panCenter.add(panSifra);
		panCenter.add(panNaziv);
		panCenter.add(panGodina);
		panCenter.add(panSemestar);
		panCenter.add(panEspb);
		panCenter.add(Box.createVerticalStrut(25));
		add(panCenter, BorderLayout.CENTER);

		JPanel panBottom = new JPanel();
		BoxLayout box = new BoxLayout(panBottom, BoxLayout.X_AXIS);
		panBottom.setLayout(box);

		btnOk.setPreferredSize(new Dimension(150, 25));
		btnOk.addActionListener(this);
		btnOk.setEnabled(false);

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
		setModal(true);
		pack();
		setLocationRelativeTo(GlavniProzor.getInstance()); // da bi dialog bio centriran neophodno je pozvati metodu
															// setLocationRelativeTo(parent frame) posle pozivanja
															// metode pack

	}

	public String[] pokupiTekst() {
		String tekst[] = new String[5];
		for (int i = 0; i < tekst.length; i++) {
			tekst[i] = new String();
		}
		tekst[0] = txtSifra.getText().toString();
		tekst[1] = txtNaziv.getText().toString();
		tekst[2] = txtGodina.getText().toString();
		tekst[3] = txtEspb.getText().toString();
		tekst[4] = semestarCombo.getSelectedItem().toString();
		return tekst;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String tekst[] = pokupiTekst();
		boolean dodaj = true; // flag koji nam pokazuje da li je dozvoljeno dodati predmet sa tim parametrima

		// metoda getActionCommand(), vraca string koji je ispisan na kliknutom
		// JButton-u
		if (e.getActionCommand().equals("ODUSTANI")) {
			dispose();
		} else {
			if (BazaPredmet.getInstance().getPredmeti().size() == 0) {
				dodaj = true;
			} else {
				for (Predmet p : BazaPredmet.getInstance().getPredmeti()) {
					if (p.getSifraPredmeta().equals(tekst[0])) {
						dodaj = false;
						JOptionPane.showMessageDialog(null, "Predmet sa unetom sifrom vec postoji!", "Upozorenje",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
			if (dodaj) {
				BazaPredmet.getInstance().dodajPredmet(tekst[0], tekst[1], Integer.parseInt(tekst[2]),
						Integer.parseInt(tekst[3]), tekst[4].charAt(0));
				PredmetController.getInstance().dodajPredmet();
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
			if (!Pattern.matches("[a-zA-Z0-9]*", tekst[0])) {
				txtSifra.setBackground(incorrect);
				txtSifra.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtSifra.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[1].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[a-zA-Z0-9 ]*", tekst[1])) {
				txtNaziv.setBackground(incorrect);
				txtNaziv.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtNaziv.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[2].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[0-9]{1,2}", tekst[2])) {
				txtGodina.setBackground(incorrect);
				txtGodina.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtGodina.setBackground(correct);
		} else {
			ok = false;
		}
		if (tekst[3].length() != 0) {
			ok1 = true;
			if (!Pattern.matches("[0-9]{1,2}", tekst[3])) {
				txtEspb.setBackground(incorrect);
				txtEspb.setForeground(Color.black);
				ok1 = false;
				ok = false;
			}
			if (ok1)
				txtEspb.setBackground(correct);
		} else {
			ok = false;
		}

		return ok;
	}

}