package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import view.StudentiJTable;

/**
 * Klasa predstavlja bazu podataka za entitet Predmet kod svakog entiteta tipa
 * Student. Pošto svaki student ima svoju bazu položenih predmeta, klasa nije
 * implementirana kao singlton.
 * 
 * @author Aleksandra Mirković
 */
public class BazaPolozeni {
	/**
	 * Instanca klase
	 */
	private static BazaPolozeni instance = null;

	/**
	 * Metoda koja omogućava kreiranje novog objekta klase BazaPolozeni.
	 * 
	 * @return instanca klase BazaPolozeni
	 */
	public static BazaPolozeni getInstance() {
		instance = new BazaPolozeni();
		return instance;
	}

	/**
	 * Ukupan broj položenih predmeta kod selektovanog studenta.
	 */
	private int inc = 0;
	/**
	 * Lista položenih predmeta. Položeni predmeti su ustvari ocene pa je ovo
	 * zapravo lista ocena.
	 */
	private List<Ocena> polozeniPredmeti;
	/**
	 * Lista naziva kolona.
	 */
	private List<String> kolone;

	/**
	 * Konstruktor klase BazaPolozeni. Inicijalizuje nazive kolona. Poziva
	 * inicijalizaciju liste ocena. Konstruktor je privatan pa se iz tog razloga
	 * objekat klase može kreirati samo pozivanjem metode getInstance() ove klase.
	 */
	private BazaPolozeni() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}

	/**
	 * Metoda inicijalizuje lisu ocena na listu položenih predmeta selektovanog
	 * studenta.
	 */
	private void initPredmet() {

		this.polozeniPredmeti = new ArrayList<Ocena>();
		int red = StudentiJTable.getInstance().getSelectedRow();
		int model = StudentiJTable.getInstance().convertRowIndexToModel(red);
		Student s = BazaStudent.getInstance().getRow(model);
		polozeniPredmeti = s.getPolozeniPredmeti();
		for (Ocena o : polozeniPredmeti) {
			inc++;
		}
	}

	/**
	 * 
	 * @return ukupan broj položenih predmeta(ocena) selektovanog studenta
	 */
	public long getInc() { // vraca broj predmeta - ocena
		return inc;
	}

	/**
	 * Postavlja ukupan broj položenih predmeta(ocena) na prosleđenu vrednost
	 * 
	 * @param inc željeni ukupan broj položenih predmeta(ocena)
	 */
	public void setInc(int inc) {
		this.inc = inc;
	}

	public List<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmet(List<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public List<String> getKolonePolozeni() {
		return kolone;
	}

	/**
	 * 
	 * @return ukupan broj kolona
	 */
	public int getColumnCount() {
		return 5;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	/**
	 * Dobavlja naziv kolone na osnovu prosleđenog rednog broja kolona.
	 * 
	 * @param index redni broj kolona
	 * @return naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Na osnovu rednog broja vrste dobavlja objekat klase Ocena koji se tu nalazi
	 * 
	 * @param row redni broj vrste
	 * @return objekat klase Ocena
	 */
	public Ocena getRow(int row) {
		return this.polozeniPredmeti.get(row);
	}

	/**
	 * Na osnovu prosleđenog rednog broja vrste i kolone, dobavlja šta je upisano na
	 * preseku. To je vrednost određenog polja klase Ocena u obliku Stringa.
	 * 
	 * @param row    redni broj vrste
	 * @param column redni broj kolone
	 * @return vrednost polja
	 */
	public String getValueAt(int row, int column) {
		Ocena polozeniPredmeti = this.polozeniPredmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return polozeniPredmeti.getPredmet().getSifraPredmeta();
		case 1:
			return polozeniPredmeti.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(polozeniPredmeti.getPredmet().getEspb());
		case 3:
			return String.valueOf(polozeniPredmeti.getBrojcanaVrednost());
		case 4:
			LocalDate datumPolaganja = polozeniPredmeti.getDatumPolaganja();
			String datum = String.valueOf(datumPolaganja.getDayOfMonth()) + "."
					+ String.valueOf(datumPolaganja.getMonthValue()) + "." + String.valueOf(datumPolaganja.getYear())
					+ ".";
			return datum;
		default:
			return null;
		}
	}

	/**
	 * Omogućava dodavanje predemta(Ocene) u listu položenih predmeta entiteta tipa
	 * Student.
	 * 
	 * @param s     student kom se dodaje pcena
	 * @param p     predmet koji se polaže
	 * @param ocena brojčana vrednost ocene
	 * @param datum datum kada je ocena nastala
	 */
	public void dodajPredmet(Student s, Predmet p, int ocena, LocalDate datum) {

		this.polozeniPredmeti.add(new Ocena(s, p, ocena, datum));
		inc++;

	}

	/**
	 * Omogućava brisanje entiteta tipa Ocena iz liste položenih predmeta (liste
	 * ocena) Studenta.
	 * 
	 * @param row redni broj rste u kojoj se Ocena nalazi
	 */
	public void izbrisiOcenu(int row) {
		this.polozeniPredmeti.remove(row);
	}

}
