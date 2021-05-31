package controller;

import model.BazaNepolozeni;
import model.BazaStudent;
import model.Student;
import model.Predmet;
import view.IzmenaStudentaDialog;
import view.NepolozeniJTable;
import view.StudentiJTable;

/**
 * Klasa koja rukuje događajima koji se odnose na entitet Student.
 * Implementirana je kao singlton klasa.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class StudentController {
	/**
	 * Instanca klase. Inicijalizuje se na null.
	 */
	private static StudentController instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jednog objekta ove klase.
	 * 
	 * @return Povratna vrednost je referenca na prethodno kreirani objekat ove
	 *         klase ili novookreirani objekat ako do sada nijedan objekat još nije
	 *         instanciran.
	 */
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	/**
	 * Konstruktor klase.
	 */
	private StudentController() {
	}

	/**
	 * poziva funkciju iz klase BazaStudent za dodavanje novog studenta i vrši
	 * ažuriranje prikaza tabele studenata
	 */
	public void dodajStudenta() {
		// izmena modela
		// BazaStudent.getInstance().dodajStudenta(prezime, ime, datumRodjenja,
		// adresaStanovanja, kontaktTelefon, email, brIndeksa, godinaUpisa,
		// trenutnaGodinaStudija, status, prosecnaOcena, polozeniPredmeti);;
		// azuriranje prikaza
		StudentiJTable.getInstance().refresTabelu();
	}

	/**
	 * Otvara dijalog za izmenu studenta za selektovanog studenta, pa nakon potvrde
	 * izmene poziva metodu iz klase BazaStudent za izmenu studenta i vrši
	 * ažuriranje prikaza tabele studenata.
	 * 
	 * @param rowSelectedIndex predstavlja redni broj vrste u kojoj se nalazi
	 *                         student čiju izmenu treba da odradimo
	 */
	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return; // u slučaju kada je indeks manje od 0 nemamo dobru informaciju o tome kog
					// studenta treba da izmenimo pa samo izađemo iz funkcije
		}
		// izmena modela
		Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
		System.out.println(student);
		IzmenaStudentaDialog dialog = new IzmenaStudentaDialog(student);

		dialog.setVisible(true);
		// azuriranje prikaza
		StudentiJTable.getInstance().refresTabelu();
	}

	/**
	 * Poziva metodu iz klase BazaStudent za uklanjanje studenta i vrši ažuriranje
	 * prikaza tabele studenata. Predmet se briše direktno iz BazeStudenata.
	 * 
	 * 
	 * @param rowSelectedIndex selektovani red u kom se nalazi student koji se briše
	 */
	public void izbrisiStudenta(int rowSelectedIndex) {
		Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
		for (int i = 0; i < BazaStudent.getInstance().getStudenti().size(); i++) {
			if (BazaStudent.getInstance().getStudenti().get(i).getBrIndeksa().equals(student.getBrIndeksa())) {
				BazaStudent.getInstance().getStudenti().remove(i);
			}
		}
		StudentiJTable.getInstance().refresTabelu();
	}

	/**
	 * Omogućuje dodavanje novog nepoloženog predmeta u listu nepoloženih predmeta
	 * studenta, zatim ažurara tabelu studenata.
	 * 
	 * @param student student kom se dodaje predmet
	 * @param predmet predmet koji se dodaje
	 */
	public void dodajPredmetStudentu(Student student, Predmet predmet) {
		student.getNepolozeniPredmeti().add(predmet);
		NepolozeniJTable.getInstance().azurirajPrikaz();
		StudentiJTable.getInstance().refresTabelu();
	}

	/**
	 * Omogućuje brisanje predmeta iz liste nepoloženih predmeta studenta.
	 * 
	 * @param student                   student kome se briše predmet
	 * @param rowSlectedIndexNepolozeni redni broj vrste iz tabele nepoloženih
	 *                                  predemta, predstavlja redni broj vrste u
	 *                                  kojoj se nalazi predmet koji se uklanja
	 */
	public void ukloniPredmetStudentu(Student student, int rowSlectedIndexNepolozeni) {
		Predmet predmet = BazaNepolozeni.getInstance().getRow(rowSlectedIndexNepolozeni);
		for (int i = 0; i < student.getNepolozeniPredmeti().size(); i++) {
			if (student.getNepolozeniPredmeti().get(i).getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
				student.getNepolozeniPredmeti().remove(i);
				break;
			}
		}
		StudentiJTable.getInstance().refresTabelu();
		// NepolozeniJTable.getInstance().azurirajPrikaz();
	}

}
