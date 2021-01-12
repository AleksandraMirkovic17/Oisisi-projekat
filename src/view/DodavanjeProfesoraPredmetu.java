package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ListModel;

import controller.StudentController;
import model.BazaNepolozeni;
import model.BazaPolozeni;
import model.BazaPredmet;
import model.BazaProfesor;
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

		List list = new List();
		int brojMogucihProfZaDodavanje = 0;

		for(Profesor pf : BazaProfesor.getInstance().getProfesori()) {
			boolean moze = true;
			if((p.getProfesori()!=null)&&(p.getProfesori().size()!=0)) {
			for(Profesor pf1 : p.getProfesori()) {
				if(pf1.getBrLicneKarte().equals(pf.getBrLicneKarte())) {
					moze=false;
				}
			}}
		
			String dodaj = pf.getIme() +" "+pf.getPrezime();
			list.add(dodaj);
			
			brojMogucihProfZaDodavanje++;
		
		}
		if (brojMogucihProfZaDodavanje > 0) {
			panCenter.add(list);
		} else {
			panCenter.add(nemaNistaZaDodati);
		}

		JButton btnOk = new JButton("POTVRDI");
		list.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				repaint();
				if (list.getSelectedItem()!=null) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});

		btnOk.setEnabled(false);
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dodatiProfesora = list.getSelectedItem();
				if (dodatiProfesora!=null) {
					JOptionPane.showMessageDialog(null, "Niste selektovali profesora!", "Upozorenje!",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		JButton btnCancel = new JButton("ODUSTANI");

		btnOk.setPreferredSize(new Dimension(100, 25));
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String dodatiProfesora = list.getSelectedItem();
				for(Profesor p : BazaProfesor.getInstance().getProfesori()) {
					//if(p.getBrLicneKarte()==dodati.)
				}
				
				setVisible(false);
			}
		});

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