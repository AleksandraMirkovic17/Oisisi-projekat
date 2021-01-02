package controller;

import javax.swing.JOptionPane;

import IzgledProzora.GlavniProzor;
import IzgledProzora.IzmenaProfesorDialog;
import IzgledProzora.ProfesoriJTable;

import model.BazaProfesor;

import model.Profesor;


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
}
