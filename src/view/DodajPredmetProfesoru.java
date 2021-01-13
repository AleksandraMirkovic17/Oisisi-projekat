package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.BazaNepolozeni;
import model.BazaPredmet;
import model.BazaProfesorPredajePredmet;
import model.Ocena;
import model.Predmet;
import model.Profesor;

public class DodajPredmetProfesoru extends JDialog implements ItemListener {

	Profesor profesor;
	@SuppressWarnings("deprecation")
	public DodajPredmetProfesoru(Profesor p, IzmenaProfesorDialog parent)
	{
		super();
		setTitle("Dodaj predmet");
		setResizable(true);
		setModal(true);
		setSize(400, 400);
		
		
		
		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);
		this.profesor=p;
		
		List list = new List();
		list.setMultipleSelections(true);
		
		int brojMogucihPredmetaZaDodavanje = 0;
		
		
		for(Predmet p1 : BazaPredmet.getInstance().getPredmeti())
		{
		
			boolean dodaj=true;
			for(Predmet p2 : p.getPredmeti())
			{
				if((p1.getSifraPredmeta().equals(p2.getSifraPredmeta()))) {
					dodaj=false;
				}
			
			}
			
			if(dodaj)
			{
				String moguceDodati = p1.getSifraPredmeta() + " " + "-" + " " + p1.getNazivPredmeta();
				list.add(moguceDodati);
				++brojMogucihPredmetaZaDodavanje;
			}
		}
		
		if (brojMogucihPredmetaZaDodavanje > 0) {
			panCenter.add(list);
		}
		
		
		JButton btnOk = new JButton("Potvrdi");
		list.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				repaint();
				if (list.getSelectedItems().length > 0) {
					btnOk.setEnabled(true);
				} else {
					btnOk.setEnabled(false);
				}
			}
		});
		
		btnOk.setEnabled(false);
		btnOk.setPreferredSize(new Dimension(100, 25));
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] dodatiPredmete = list.getSelectedItems();
				if (dodatiPredmete.length == 0) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet za dodavanje!", "Upozorenje!",
							JOptionPane.WARNING_MESSAGE);
				}
				else {
				for (int i = 0; i < list.getSelectedItems().length; i++) {
					String[] splited = dodatiPredmete[i].split("-");
					String sifraPredmeta = splited[0].trim();
					for (Predmet p : BazaPredmet.getInstance().getPredmeti()) {
						if (p.getSifraPredmeta().equals(sifraPredmeta)) {
							BazaProfesorPredajePredmet.getInstance().dodajPredmet(p);
							ProfesorPredmetJTabel.getInstance().azurirajPrikaz();
							            //dodajemo i tom predmetu na spisak studenta
						}
						
					}
					
				}
	              
			}
				
		  setVisible(false);
		}
			
		});
		
		JButton btnCancel = new JButton("ODUSTANI");

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
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		repaint();
	}

}
