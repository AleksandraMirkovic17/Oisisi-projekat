package controller;

import javax.swing.JOptionPane;

import model.BazaProfesor;

import model.Profesor;
import view.GlavniProzor;
import view.IzmenaProfesorDialog;
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
	
	public void izbrisiProfesora (int red) {
		Profesor profesor = BazaProfesor.getInstance().getRow(red);
		for(int i=0; i<BazaProfesor.getInstance().getProfesori().size(); i++) {
			if(BazaProfesor.getInstance().getProfesori().get(i).getBrLicneKarte().equals(profesor.getBrLicneKarte())) {
				BazaProfesor.getInstance().getProfesori().remove(i);
			}
		}
		ProfesoriJTable.getInstance().azurirajPrikaz();
	}
}

