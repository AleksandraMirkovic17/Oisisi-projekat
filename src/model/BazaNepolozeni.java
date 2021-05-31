package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import view.StudentiJTable;
import view.ToolBar;

/**
 * Klasa predstavlja bazu podataka za entitet Predmet kod svakog entiteta tipa
 * Student. Pošto svaki student ima svoju bazu nepoloženih predmeta, klasa nije
 * implementirana kao singlton.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class BazaNepolozeni {

	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	/**
	 * Instanca klase
	 */
	private static BazaNepolozeni instance = null;

	/**
	 * Metoda koja omogućava kreiranje novog objekta klase BazaNepolozeni.
	 * 
	 * @return instanca klase BazaNepolozeni
	 */
	public static BazaNepolozeni getInstance() {

		instance = new BazaNepolozeni();
		return instance;
	}

	/**
	 * Ukupan broj nepoloženih predmeta kod selektovanog studenta.
	 */
	private int inc = 0;
	/**
	 * Lista nepoloženih predmeta studenta.
	 */
	private List<Predmet> nepolozeniPredmeti;
	/**
	 * Lista naziva kolona.
	 */
	private List<String> kolone;

	/**
	 * Konstruktor klase BazaNepolozeni. Inicijalizuje nazive kolona. Poziva
	 * inicijalizaciju liste predmeta. Konstruktor je privatan pa se iz tog razloga
	 * objekat klase može kreirati samo pozivanjem metode getInstance() ove klase.
	 */
	public BazaNepolozeni() {

		this.kolone = new ArrayList<String>();
		initnepolozeni();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR IZVODJENJA");

	}

	/**
	 * Metoda inicijalizuje lisu predmeta na listu nepoloženih predmeta selektovanog
	 * studenta.
	 */
	private void initnepolozeni() {
		this.nepolozeniPredmeti = new ArrayList<Predmet>();
		int red = StudentiJTable.getInstance().getSelectedRow();
		int model = StudentiJTable.getInstance().convertRowIndexToModel(red);
		Student d = BazaStudent.getInstance().getRow(model);

		nepolozeniPredmeti = d.getNepolozeniPredmeti();

		for (Predmet p : nepolozeniPredmeti) {
			inc++;
		}

	}

	/**
	 * 
	 * @return ukupan broj nepoloženih predmeta selektovanog studenta
	 */
	public long getInc() { // vraca broj predmeta
		return inc;
	}

	/*
	 * public String getIndex(String s) { return s; }
	 */

	public void setInc(int inc) {
		this.inc = inc;
	}

	public List<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmet(List<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	public List<String> getKoloneNepolozeni() {
		return kolone;
	}

	/**
	 * 
	 * @return broj kolona
	 */
	public int getColumnCount() {
		return 5;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public static void setInstance(BazaNepolozeni instance) {
		BazaNepolozeni.instance = instance;
	}

	/**
	 * Na osnovu rednog broja kolone dobavlja njen naziv
	 * 
	 * @param index redni broj kolone
	 * @return naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Na osnovu prosleđenog rednog broja vrste dobavlja objekat klase Predmet koji
	 * se tu nalazi.
	 * 
	 * @param row redni broj vrste
	 * @return objekat klase Predmet
	 */
	public Predmet getRow(int row) {
		return this.nepolozeniPredmeti.get(row);
	}

	/**
	 * Na osnovu prosleđenog rednog broja vrste i kolone, dobavlja šta je upisano na
	 * preseku. To je vrednost određenog polja klase Predmet u obliku Stringa.
	 * 
	 * @param row    redni broj vrste
	 * @param column redni broj kolone
	 * @return vrednost polja
	 */
	public String getValueAt(int row, int column) {
		Predmet nepolozeniPredmeti = this.nepolozeniPredmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return nepolozeniPredmeti.getSifraPredmeta();
		case 1:
			return nepolozeniPredmeti.getNazivPredmeta();
		case 2:
			return String.valueOf(nepolozeniPredmeti.getEspb());
		case 3:
			return String.valueOf(nepolozeniPredmeti.getGodinaStudija());
		case 4:
			String sem = new String();
			if (nepolozeniPredmeti.getSemestar() == Semestar.LETNJI)
				sem = "LETNJI";
			else
				sem = "ZIMSKI";
			return sem;
		default:
			return null;
		}
	}

	/**
	 * Omogućava brisanje entiteta tipa Predmet iz liste nepoloženih predmeta
	 * Studenta.
	 * 
	 * @param sifraPredmeta šifra predmeta kog želimo da obrišemo
	 * @param d             student kome se briše predmet
	 */
	public void izbrisiPredmet(String sifraPredmeta, Student d) {

		nepolozeniPredmeti = d.getNepolozeniPredmeti();
		for (Predmet p : nepolozeniPredmeti) {
			if (p.getSifraPredmeta() == sifraPredmeta) {

				nepolozeniPredmeti.remove(p);
				break;
			}
		}

	}

	/**
	 * Omogućava dodavanje novog predmeta u listu nepoloženih predmeta studenta.
	 * 
	 * @param p predmet koji se dodaje studentu
	 */
	public void dodajPredmet(Predmet p) {
		this.nepolozeniPredmeti.add(p);
	}
}
