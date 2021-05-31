package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa koja omogućuje serijalizaciju i deserijalizaciju svih unetih entiteta u
 * sistem. Sadrži listu svih objekata klase Student, Profesor i Predmet. Liste
 * se učitavaju iz fajla a zatim nakon rada nad njim, nova lista se takođe čuva
 * u fajl.
 * 
 * @author Andrea Sabo Cibolja, Aleksandra Mirković
 *
 */
public class BazaPodataka {
	/**
	 * Lista svih unetih entiteta tipa Student u sistem.
	 */
	List<Student> studenti;
	/**
	 * Lista svih unetih entiteta tipa Profesor u sistem.
	 */
	List<Profesor> profesori;
	/**
	 * Lista svih unetih entiteta tipa Predmet u sistem.
	 */
	List<Predmet> predmeti;
	/**
	 * Instanca klase.
	 */
	private static BazaPodataka instance = null;

	/**
	 * Omogućava kreiranje novog objekta ove klase, ako klasa nije još instancirana
	 * ili vraća referencu na postojeći objekat, ako je klasa prethodn instancirana.
	 * 
	 * @return instanca klase
	 */
	public static BazaPodataka getInstance() {
		if (instance == null) {
			return new BazaPodataka();
		} else
			return instance;
	}

	/**
	 * Konstruktor klase. Inicijalizuje polja klase na prazne liste.
	 */
	public BazaPodataka() {
		studenti = BazaStudent.getInstance().getStudenti();
		profesori = BazaProfesor.getInstance().getProfesori();
		predmeti = BazaPredmet.getInstance().getPredmeti();
	}

	/**
	 * Metoda koja se poziva odmah pri otvaranju aplikacije, učitava liste sačuvanih
	 * objekata klase Student, Profesor i Predmet.
	 */
	@SuppressWarnings({ "unchecked", "static-access" })
	public void citanje() {
		ObjectInputStream o = null;
		try {
			o = new ObjectInputStream(new BufferedInputStream(new FileInputStream("podaci1.raw")));
			BazaStudent.getInstance().setStudenti((List<Student>) o.readObject());
			BazaProfesor.getInstance().setProfesori((List<Profesor>) o.readObject());
			BazaPredmet.getInstance().setPredmet((List<Predmet>) o.readObject());

			BazaStudent.getInstance().setBrojStudenata(BazaStudent.getInstance().getStudenti().size());
			BazaProfesor.getInstance().setBroj_Profesora(BazaProfesor.getInstance().getProfesori().size());
			BazaPredmet.getInstance().setBrojac(BazaPredmet.getInstance().getPredmeti().size());

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				o.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

	/**
	 * Metoda se poziva prilikom zatvaranja aplikacije, čuva modifikovane liste
	 * objekata klase Student, Profesor i Predmet u fajl.
	 */
	public void cuvanje() {
		ObjectOutputStream os = null;
		try {
			studenti = BazaStudent.getInstance().getStudenti();
			profesori = BazaProfesor.getInstance().getProfesori();
			predmeti = BazaPredmet.getInstance().getPredmeti();

			os = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("podaci1.raw")));
			os.writeObject(studenti);
			os.writeObject(profesori);
			os.writeObject(predmeti);

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				os.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
