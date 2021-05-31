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

/**
 * Klasa koja rukuje događajima koji se odnose na entitet Profesor.
 * Implementirana je kao singlton klasa.
 * 
 * @author Aleksandra Mirković
 *
 */
public class ProfesorController {
	/**
	 * Instanca klase. Inicijalizuje se na null.
	 */
	private static ProfesorController instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jednog objekta ove klase.
	 * 
	 * @return Povratna vrednost je referenca na prethodno kreirani objekat ove
	 *         klase ili novookreirani objekat ako do sada nijedan objekat još nije
	 *         instanciran.
	 */
	public static ProfesorController getInstance() {
		if (instance == null) {
			instance = new ProfesorController();
		}
		return instance;
	}

	/**
	 * Konstruktor klase.
	 */
	private ProfesorController() {
	}

	/**
	 * poziva funkciju iz klase BazaPredmet za dodavanje novog profesora i vrši
	 * ažuriranje prikaza tabele profesora
	 */
	public void dodajProfesora() {

		ProfesoriJTable.getInstance().azurirajPrikaz();
	}

	/**
	 * Otvara dijalog za izmenu profesora za selektovanog profesora, pa nakon
	 * potvrde izmene poziva metodu iz klase BazaProfesor za izmenu profesora i vrši
	 * ažuriranje prikaza tabele profesora.
	 * 
	 * @param red redni broj vrste u kojoj se nalazi profesor kog je potrebno
	 *            menjati
	 */
	public void izmeniProfesora(int red) {
		// izmena modela
		if (red < 0)
			return;

		Profesor p = BazaProfesor.getInstance().getRow(red);
		System.out.println(p.toString());

		IzmenaProfesorDialog dialog = new IzmenaProfesorDialog(p);
		dialog.setVisible(true);
		// azuriranje prikaza
		ProfesoriJTable.getInstance().azurirajPrikaz();
	}

	/**
	 * Poziva metodu iz klase BazaProfesor za uklanjanje profesora i vrši ažuriranje
	 * prikaza tabele profesora. Profesor se briše direktno iz BazeProfesora, ali se
	 * prethodno briše i iz liste profesora, ako postojineki predmet na kome je
	 * predavao ovaj profesor.
	 * 
	 * @param red redni broj vrste u kojoj se profesor nalazi
	 */
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
				if (IzmenaPredmetaDialog.instanceIzmenaPredmeta != null)
					IzmenaPredmetaDialog.instanceIzmenaPredmeta.setTxtProfesor();
			}
			ProfesoriJTable.getInstance().azurirajPrikaz();
		}
	}
}
