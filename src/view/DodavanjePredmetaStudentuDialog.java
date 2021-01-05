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
import model.BazaPredmet;
import model.Ocena;
import model.Predmet;
import model.Student;
import java.awt.List;

public class DodavanjePredmetaStudentuDialog extends JDialog implements ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3887024701864527674L;

	Student student;

	@SuppressWarnings("deprecation")
	public DodavanjePredmetaStudentuDialog(Student s, IzmenaStudentaDialog parent) {
		super();
		setTitle("Dodavanje predmeta");
		setResizable(true);
		setModal(true);
		setSize(400, 400);
		setLocationRelativeTo(parent);

		this.student = s;

		// setLayout(new BorderLayout(2,4));

		JPanel panCenter = new JPanel();
		BoxLayout boxCenter = new BoxLayout(panCenter, BoxLayout.Y_AXIS);
		panCenter.setLayout(boxCenter);

		JPanel nemaNistaZaDodati = new JPanel();
		JLabel nemaPredmeta = new JLabel("Nema nepolozenih predmeta!");
		nemaNistaZaDodati.add(nemaPredmeta);

		List list = new List();
		list.setMultipleSelections(true);

		int brojMogucihPredmetaZaDodavanje = 0;

		for (Predmet p : BazaPredmet.getInstance().getPredmeti()) {
			boolean dodaj = true;
			// proveravamo da li se predmet nalazi u listi polozenih predmeta
			for (Ocena o : s.getPolozeniPredmeti()) {
				if (p.getSifraPredmeta().equals(o.getPredmet().getSifraPredmeta())) {
					dodaj = false;
				}
			}
			// proveravamo da li se predmet vec nalazi u listi nepolozenih predmeta
			for (Predmet p1 : s.getNepolozeniPredmeti()) {
				if (p.getSifraPredmeta().equals(p1.getSifraPredmeta())) {
					dodaj = false;
				}
			}
			// proveravamo da li je student na odgovarajucoj godini studija
			if (s.getTrenutnaGodinaStudija() < p.getGodinaStudija()) {
				dodaj = false;
			}
			if (dodaj) {
				String moguceDodati = p.getSifraPredmeta() + " " + "-" + " " + p.getNazivPredmeta();
				list.add(moguceDodati);
				++brojMogucihPredmetaZaDodavanje;
			}
		}

		if (brojMogucihPredmetaZaDodavanje > 0) {
			panCenter.add(list);
		} else {
			panCenter.add(nemaNistaZaDodati);
		}
		JButton btnOk = new JButton("DODAJ");
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
		btnOk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] dodatiPredmete = list.getSelectedItems();
				if (dodatiPredmete.length == 0) {
					JOptionPane.showMessageDialog(null, "Niste selektovali predmet za dodavanje!", "Upozorenje!",
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
				String[] dodatiPredmete = list.getSelectedItems();
				for (int i = 0; i < list.getSelectedItems().length; i++) {
					String[] splited = dodatiPredmete[i].split("-");
					String sifraPredmeta = splited[0].trim();
					for (Predmet p : BazaPredmet.getInstance().getPredmeti()) {
						if (p.getSifraPredmeta().equals(sifraPredmeta)) {
							StudentController.getInstance().dodajPredmetStudentu(student, p);
						}
					}
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
