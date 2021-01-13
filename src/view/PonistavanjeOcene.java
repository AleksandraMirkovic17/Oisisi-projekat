package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.BazaNepolozeni;
import model.BazaPolozeni;
import model.BazaPredmet;
import model.Ocena;

public class PonistavanjeOcene extends JDialog {

	public PonistavanjeOcene(Ocena o, int row) {
		setModal(true);
		setSize(300, 250);
		setResizable(false);
		setTitle("Poništavanje ocene");

		JPanel dialogPanel1 = new JPanel();
		BoxLayout boxDialogPanel1 = new BoxLayout(dialogPanel1, BoxLayout.Y_AXIS);
		dialogPanel1.setLayout(boxDialogPanel1);

		JPanel dialogPanel2 = new JPanel();
		JLabel dialogLabel2 = new JLabel("Da li ste sigurni da želite da poništite ocenu?");
		dialogPanel2.add(dialogLabel2);

		JPanel dialogPanel3 = new JPanel();
		BoxLayout boxDialogPanel3 = new BoxLayout(dialogPanel3, BoxLayout.X_AXIS);
		dialogPanel3.setLayout(boxDialogPanel3);

		JButton da = new JButton("Da");

		da.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				BazaNepolozeni.getInstance().dodajPredmet(o.getPredmet());
				NepolozeniJTable.getInstance().azurirajPrikaz();



				BazaPolozeni.getInstance().izbrisiOcenu(row);
				PolozeniJTable.getInstance().azurirajPrikaz();
				
				for (int i1 = 0; i1 < BazaPredmet.getInstance().getPredmeti().size(); i1++) {
					for (int i2 = 0; i2 < BazaPredmet.getInstance().getPredmeti().get(i1).getPoloziliPredmet()
							.size(); i2++) {
						if ((BazaPredmet.getInstance().getPredmeti().get(i1).getSifraPredmeta()
								.equals(o.getPredmet().getSifraPredmeta()))
								&& (BazaPredmet.getInstance().getPredmeti().get(i1).getPoloziliPredmet().get(i2)
										.getBrIndeksa().equals(o.getStudent().getBrIndeksa()))) {
							BazaPredmet.getInstance().getPredmeti().get(i1).getPoloziliPredmet().remove(i2);
						}
					}
				}

				IzmenaStudentaDialog.instanceIzmenaStudenta.setBtnPonistiAkoNemaPolozenih();

				dispose();
			}
		});

		JButton ne = new JButton("Ne");
		ne.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		dialogPanel3.add(Box.createVerticalStrut(5));
		dialogPanel3.add(da);
		dialogPanel3.add(Box.createHorizontalStrut(10));
		dialogPanel3.add(ne);
		dialogPanel3.add(Box.createHorizontalStrut(5));

		dialogPanel1.add(dialogLabel2);
		dialogPanel1.add(Box.createVerticalStrut(20));
		dialogPanel1.add(dialogPanel3);
		dialogPanel1.add(Box.createVerticalStrut(20));

		add(dialogPanel1);

		pack();
		setLocationRelativeTo(IzmenaStudentaDialog.getInstance());
		setVisible(true);
	}
}
