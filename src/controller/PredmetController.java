package controller;

import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import view.GlavniProzor;
import view.IzmenaPredmetaDialog;
import view.PredmetJTable;
import view.ProfesoriJTable;

/**
 * Klasa koja rukuje događajima koji se odnose na entitet Predmet.
 * Implementirana je kao singlton klasa.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class PredmetController {
	/**
	 * Instanca klase. Inicijalizuje se na null.
	 */
	private static PredmetController instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jednog objekta ove klase.
	 * 
	 * @return Povratna vrednost je referenca na prethodno kreirani objekat ove
	 *         klase ili novookreirani objekat ako do sada nijedan objekat još nije
	 *         instanciran.
	 */
	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	/**
	 * Konstruktor klase.
	 */
	private PredmetController() {
	}

	/**
	 * poziva funkciju iz klase BazaPredmet za dodavanje novog predmeta i vrši
	 * ažuriranje prikaza tabele predmeta
	 */
	public void dodajPredmet() {
		// azuriranje prikaza
		PredmetJTable.getInstance().refresTabelu();
	}

	/**
	 * Otvara dijalog za izmenu predmeta za selektovani predmet, pa nakon potvrde
	 * izmene poziva metodu iz klase BazaPredmet za izmenu predmeta i vrši
	 * ažuriranje prikaza tabele predmeta.
	 * 
	 * @param rowSelectedIndex redni broj predmeta u tabeli predmeta koji se menja
	 */
	public void izmeniPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Predmet predmet = BazaPredmet.getInstance().getRow(rowSelectedIndex);
		IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(predmet);
		dialog.setVisible(true);
		// azuriranje prikaza
		PredmetJTable.getInstance().refresTabelu();
	}

	/**
	 * Poziva metodu iz klase BazaPredmet za uklanjanje predmeta i vrši ažuriranje
	 * prikaza tabele predmeta. Predmet se briše direktno iz BazePredmeta, ali se
	 * prethodno briše i iz liste predmeta, ako je neki profesor predavao na njemu i
	 * iz liste položenih i nepoloženih kod Studenta.
	 * 
	 * @param red redni broj vrste u kojoj se predmet nalazi
	 */
	public void izbrisiPredmet(int red) {
		Predmet p = BazaPredmet.getInstance().getRow(red);// znamo koji je to predmet kog mi zelimo da izbrisemo
		BazaPredmet.getInstance().izbrisiPredmet(p.getSifraPredmeta());// saljemo sifru predmeta jer se oni po tome
																		// identifikuju, i u ovoj liniji vrsimo brisanje
																		// predmeta
		BazaProfesor.getInstance().izbrisiPredmet(p.getSifraPredmeta());
		BazaStudent.getInstance().izbrisiPredmet(p.getSifraPredmeta());
		PredmetJTable.getInstance().refresTabelu();// ayuriranje tabele
	}

	/**
	 * Iz liste profesora koji predaju na predmetu uklanja prosleđenog profesora.
	 * 
	 * @param profesor profesor koji se uklanja sa predmeta
	 * @param predmet  predmet sa kog želimo da uklonimo prosleđenog profesora
	 */
	public void ukloniProfesoraSaPredmetaPrekoProfesora(Profesor profesor, Predmet predmet) {
		for (int i = 0; i < BazaProfesor.getInstance().getProfesori().size(); i++) {
			if (BazaProfesor.getInstance().getProfesori().get(i).getBrLicneKarte().equals(profesor.getBrLicneKarte())) {
				for (int j = 0; j < BazaPredmet.getInstance().getPredmeti().size(); j++) {
					if (BazaPredmet.getInstance().getPredmeti().get(j).getSifraPredmeta()
							.equals(predmet.getSifraPredmeta())) {
						BazaPredmet.getInstance().getPredmeti().get(j).getProfesori()
								.remove(BazaProfesor.getInstance().getProfesori().get(i));
					}
				}
			}

		}
	}

}
