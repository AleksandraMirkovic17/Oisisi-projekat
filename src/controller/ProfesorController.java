package controller;

import javax.swing.JOptionPane;

import model.BazaPredmet;
import model.BazaProfesor;
import model.Predmet;
import model.Profesor;
import view.GlavniProzor;
import view.IzmenaPredmetaDialog;
import view.IzmenaProfesorDialog;
import view.PredmetJTable;
import view.ProfesoriJTable;

public class ProfesorController {

	private static ProfesorController instance = null;

	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

	private ProfesorController() {
	}

	public void dodajProfesora() {

		ProfesoriJTable.getInstance().azurirajPrikaz();
	}

	public void izmeniProfesora(int red) {
		// izmena modela
		Profesor p = BazaProfesor.getInstance().getRow(red);
		IzmenaProfesorDialog dialog = new IzmenaProfesorDialog(p);
		dialog.setVisible(true);
		// azuriranje prikaza
		ProfesoriJTable.getInstance().azurirajPrikaz();
	}

	public void izbrisiProfesora(int red) {
		Profesor profesor = BazaProfesor.getInstance().getRow(red);
		for (int i = 0; i < BazaProfesor.getInstance().getProfesori().size(); i++) {
			if (BazaProfesor.getInstance().getProfesori().get(i).getBrLicneKarte().equals(profesor.getBrLicneKarte())) {
				BazaProfesor.getInstance().getProfesori().remove(i);
			}
		}
		// profesora moramo da izbrisemo i sa svakog predmeta koji je predavao
		for (int i = 0; i < BazaPredmet.getInstance().getPredmeti().size(); i++) {
			Predmet predmet = BazaPredmet.getInstance().getPredmeti().get(i);
			for (int i1 = 0; i1 < predmet.getProfesori().size(); i1++) {
				Profesor profesor1 = predmet.getProfesori().get(i1);
				if (profesor.getBrLicneKarte().equals(profesor1.getBrLicneKarte())) {
					BazaPredmet.getInstance().getPredmeti().get(i).getProfesori().remove(i1);
				}
				IzmenaPredmetaDialog.instanceIzmenaPredmeta.setTxtProfesor();
			}
			ProfesoriJTable.getInstance().azurirajPrikaz();
		}
	}
}
