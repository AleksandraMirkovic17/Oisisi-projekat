package controller;

import IzgledProzora.GlavniProzor;
import IzgledProzora.ProfesoriJTable;
import model.BazaProfesor;

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
}
