package controller;

import IzgledProzora.GlavniProzor;
import IzgledProzora.StudentiJTable;
import model.BazaStudent;

public class StudentController {

	private static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	private StudentController() {
	}

	public void dodajStudenta() {
		// izmena modela
		// BazaStudent.getInstance().dodajStudenta(prezime, ime, datumRodjenja,
		// adresaStanovanja, kontaktTelefon, email, brIndeksa, godinaUpisa,
		// trenutnaGodinaStudija, status, prosecnaOcena, polozeniPredmeti);;
		// azuriranje prikaza
		StudentiJTable.getInstance().refresTabelu();
	}
}
