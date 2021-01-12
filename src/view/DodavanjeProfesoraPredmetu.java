package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.StudentController;
import model.BazaNepolozeni;
import model.BazaPolozeni;
import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaProfesorPredajePredmet;
import model.BazaProfesoriNaPredmetu;
import model.Ocena;
import model.Predmet;
import model.Profesor;
import model.Student;
import java.awt.List;

public class DodavanjeProfesoraPredmetu extends JDialog implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3887024701864527674L;

	Predmet predmet;

	@SuppressWarnings("deprecation")
	public DodavanjeProfesoraPredmetu(Predmet p, IzmenaPredmetaDialog parent) {
		super();
		setTitle("Odaberi profesora");
		setResizable(true);
		setModal(true);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		this.predmet = p;

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		JPanel nemaNistaZaDodati = new JPanel();
		JLabel nemaPredmeta = new JLabel("Nema profesora koji se mogu dodati na ovaj predmet!");
		nemaNistaZaDodati.add(nemaPredmeta);
		Vector<Profesor> profesori = new Vector<Profesor>();
		int brojMogucihProfZaDodavanje = 0;

		for (Profesor pf : BazaProfesor.getInstance().getProfesori()) {
			boolean moze = true;
			if ((p.getProfesori() != null) && (p.getProfesori().size() != 0)) {
				for (Profesor pf1 : p.getProfesori()) {
					if (pf1.getBrLicneKarte().equals(pf.getBrLicneKarte())) {
						moze = false;
					}
				}
			}
			profesori.add(pf);
			brojMogucihProfZaDodavanje++;

		}

		final JList<Profesor> list = new JList<Profesor>(profesori);

		if (brojMogucihProfZaDodavanje > 0) {
			panCenter.add(list);
		} else {
			panCenter.add(nemaNistaZaDodati);
		}

		JButton btnOk = new JButton("POTVRDI");
		list.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				btnOk.setEnabled(true);
			}
		});

		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Profesor dodajProf = list.getSelectedValue();
				if (dodajProf != null) {
					for(Profesor pf : BazaProfesor.getInstance().getProfesori()) {
						if(pf.getBrLicneKarte().equals(dodajProf.getBrLicneKarte())) {
							BazaProfesoriNaPredmetu.getInstance().dodajProfesora(pf);
							ProfesoriNaPredmetuJTable.getInstance().azurirajPrikaz();
							
						}
					}
					setVisible(false);
				}
			}
		});
		JButton btnCancel = new JButton("ODUSTANI");

		btnOk.setPreferredSize(new Dimension(100, 25));


		btnCancel.setPreferredSize(new Dimension(100, 25));
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		JPanel panBottom = new JPanel();
		panBottom.add(Box.createGlue());
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnOk);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(btnCancel);
		panBottom.add(Box.createHorizontalStrut(10));
		panBottom.add(Box.createVerticalStrut(40));

		JPanel panWest = new JPanel();
		JPanel panEast = new JPanel();
		JPanel panTop = new JPanel();
		Dimension d = new Dimension(1400, 1000);
		panWest.setSize(d);
		panEast.setSize(d);
		panTop.setSize(d);

		add(panCenter, BorderLayout.CENTER);
		add(panBottom, BorderLayout.SOUTH);
		add(panWest, BorderLayout.WEST);
		add(panEast, BorderLayout.EAST);
		add(panTop, BorderLayout.BEFORE_FIRST_LINE);

	}

	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

}