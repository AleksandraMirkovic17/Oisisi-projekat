package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controller.PredmetController;
import controller.ProfesorController;
import controller.StudentController;
import model.BazaStudent;
import model.Student;
import model.BazaNepolozeni;
import model.BazaPredmet;
import model.BazaProfesor;

public class ToolBar extends JToolBar {
	/**
	 * 
	 */
	private static final long serialVersionUID = -491100101152257518L;

	private static ToolBar instance = null;

	public static ToolBar getInstance() {
		if (instance == null) {
			instance = new ToolBar();
		}
		return instance;
	}

	public ToolBar() {
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("DODAJ");
		btnNew.addActionListener(new ActionListener() { // dodali smo akciju koja ce da pozove diaolg dodavanje
														// studenta, profesora..
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					DodavanjeStudentaDialog dialog = new DodavanjeStudentaDialog();
					dialog.setVisible(true);
				}
				if (TabPane.getInstance().getSelectedIndex() == 1) {
					DodavanjeProfesorDialog dialog = new DodavanjeProfesorDialog();
					dialog.setVisible(true);
				}
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					DodavanjePredmetaDialog dialog = new DodavanjePredmetaDialog();
					dialog.setVisible(true);
				}
			}
		});
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Slike/plus.png").getImage());
		btnNew.setIcon(imageIcon);
		add(btnNew);
		addSeparator();

		JButton btnIzmeni = new JButton();
		btnIzmeni.setToolTipText("IZMENE");

		btnIzmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					int red = StudentiJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaStudent.getInstance().getStudenti().size())) {
						int model = StudentiJTable.getInstance().convertRowIndexToModel(red);
						Student student = BazaStudent.getInstance().getRow(model);
						StudentController.getInstance().izmeniStudenta(model);

					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali studenta!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}

				}
				// izmena profesora

				if (TabPane.getInstance().getSelectedIndex() == 1) {

					int red = ProfesoriJTable.getInstance().getSelectedRow();
					System.out.println(red);
					if (red >= 0 && (red < BazaProfesor.getInstance().getProfesori().size())) {
						int model = ProfesoriJTable.getInstance().convertRowIndexToModel(red);
						ProfesorController.getInstance().izmeniProfesora(model);

					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali profesora!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}

				}
				/* izmena predmeta */
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					int red = PredmetJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaPredmet.getInstance().getPredmeti().size())) {
						PredmetController.getInstance().izmeniPredmet(red);
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali predmet!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});

		ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("Slike/olovka.png").getImage());
		btnIzmeni.setIcon(imageIcon1);

		add(btnIzmeni);
		addSeparator();

		JButton btnIzbrisi = new JButton();
		btnIzbrisi.setToolTipText("IZBRISI");
		btnIzbrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// u slucaju da smo na tabu studenti
				if (TabPane.getInstance().getSelectedIndex() == 0) {
					int red = StudentiJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaStudent.getInstance().getBrojStudenata())) {
						int model=StudentiJTable.getInstance().convertRowIndexToModel(red);
						String ispis = "Da li ste sigurni da zelide da izbrisete studenta "
								+ BazaStudent.getInstance().getRow(model).getBrIndeksa() + " "
								+ BazaStudent.getInstance().getRow(model).getIme() + " "
								+ BazaStudent.getInstance().getRow(model).getPrezime() + "?";
						int code = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), ispis, "Brisanje studenta",
								JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							StudentController.getInstance().izbrisiStudenta(model);
							;
							JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Student je obrisan!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali studenta za brisanje!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				// u slucaju da smo na tabu profesori
				if (TabPane.getInstance().getSelectedIndex() == 1) {
					int red = ProfesoriJTable.getInstance().getSelectedRow();
					if (red >= 0 && (red < BazaProfesor.getInstance().getbroj_profesora())) {
						int model = ProfesoriJTable.getInstance().convertRowIndexToModel(red);
						String ispis = "Da li ste sigurni da zelide da izbrisete profesora "
								+ BazaProfesor.getInstance().getRow(model).getTitula() + " "
								+ BazaProfesor.getInstance().getRow(model).getIme() + " "
								+ BazaProfesor.getInstance().getRow(model).getPrezime() + "?";
						int code = JOptionPane.showConfirmDialog(GlavniProzor.getInstance(), ispis, "Brisanje studenta",
								JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							ProfesorController.getInstance().izbrisiProfesora(model);
							JOptionPane.showMessageDialog(GlavniProzor.getInstance(), "Profesor je obrisan!");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Niste selektovali profesora za brisanje!", "Upozorenje!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				if (TabPane.getInstance().getSelectedIndex() == 2) {
					int red = PredmetJTable.getInstance().getSelectedRow(); // selektovali smo red u tabeli
					// provera da li smo dobro selektovali red
					if (red >= 0 && (red < BazaPredmet.getInstance().getBrojac())) {
						// REFERENCIRAN KOD ZA DIJALOG YES/NO: vezbe4 MyWindowListener
						int code = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni da zelite da izbrisete predmet?", "Brisanje predmeta",
								JOptionPane.YES_NO_OPTION);
						if (code == JOptionPane.YES_OPTION) {
							PredmetController.getInstance().izbrisiPredmet(red);
							JOptionPane.showMessageDialog(null, "Predmet je obrisan!");
						}
						if (code == JOptionPane.NO_OPTION) {
							JOptionPane.showMessageDialog(null, "Predmet nije obrisan!");
						}

					} else {
						JOptionPane.showMessageDialog(null,
								"Niste selektovali red! Morate da selektujete red u tabeli Predmet!", "Upozorenje",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			}

		});

		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("Slike/kanta.png").getImage());
		btnIzbrisi.setIcon(imageIcon2);
		add(btnIzbrisi);
		addSeparator();

		JButton btnPretrazi = new JButton();
		btnPretrazi.setToolTipText("PRETRAZI");
		ImageIcon imageIcon22 = new ImageIcon(new ImageIcon("Slike/lupa.png").getImage());
		btnPretrazi.setIcon(imageIcon22);
		add(btnPretrazi);
		addSeparator();

		JTextField pretraga = new JTextField();
		pretraga.setPreferredSize(new Dimension(50, 30));
		add(Box.createHorizontalStrut(700));
		add(pretraga);
		add(Box.createHorizontalStrut(10));
		add(btnPretrazi);
		addSeparator();

	}
}
