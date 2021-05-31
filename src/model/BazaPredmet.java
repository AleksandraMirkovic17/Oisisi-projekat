package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import view.StudentiJTable;

/**
 * Klasa predstavlja bazu podataka za entitet Predmet u sistemu. Implementirana
 * je kao singlton.
 * 
 * @author Aleksandra Mirković
 *
 */

public class BazaPredmet {

	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	/**
	 * Instanca klase. Inicijalizuje se na null.
	 */
	private static BazaPredmet instance = null;

	/**
	 * Metoda koja omogućava da postoji samo jedna instanca klase. Ako je klasa već
	 * instancirana vraća objekat klase, a u slučaju da još uvek nije instancirana
	 * vraća novokreirani objekat ove klase.
	 * 
	 * @return instanca klase
	 */
	public static BazaPredmet getInstance() {
		if (instance == null)
			instance = new BazaPredmet();
		return instance;

	}

	/**
	 * Ukupan broj predmeta u sistemu.
	 */
	private int brojac = 0;
	/**
	 * Lista predmeta unetih u sistem.
	 */
	private List<Predmet> predmeti;
	/**
	 * Lista naziva kolona
	 */
	private List<String> kolone;

	/**
	 * Konstruktor klase. Inicijalizuje nazive kolone na odgovarajuće.
	 */
	private BazaPredmet() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR IZVODJENJA");
	}

	/**
	 * Inicijalizuje neke predmete. Kreira nove objekte klase Predmet i postavlja ih
	 * u bazu predmeta. Ova metoda omogućava hard-code unos podataka.
	 */
	private void initPredmet() {
		this.predmeti = new ArrayList<Predmet>();
		Semestar s = Semestar.LETNJI;
		Profesor pr = new Profesor("Nikola", "Nikolic", LocalDate.of(1980, 4, 17), "069667633", "Tolstojeva 1",
				"nikolanikolic@gmail.com", "Radnicka 17", "1980777166111", Titula.DR, Zvanje.DOCENT,
				new ArrayList<Predmet>());
		Predmet p1 = new Predmet("EE123", "Verovatnoca", Semestar.LETNJI, 3, new ArrayList<Profesor>(), 9);
		Predmet p2 = new Predmet("E12RR3", "Analiza Matematicka", Semestar.LETNJI, 1, new ArrayList<Profesor>(), 9);
		List<Profesor> prof = new ArrayList<Profesor>();
		prof.add(pr);
		p1.setProfesori(prof);
		predmeti.add(p1);
		predmeti.add(p2);
		brojac++;
	}

	/**
	 * 
	 * @return ukupan broj predmeta u sistemu
	 */
	public long getBrojac() { // vraca broj predmeta
		return brojac;
	}

	/**
	 * Postavlja ukupan broj predmeta na prosleđenu vrednost
	 * 
	 * @param brojac željeni ukupan broj predmeta
	 */
	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<String> getKolone() {
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

	public static void setInstance(BazaPredmet instance) {
		BazaPredmet.instance = instance;
	}

	/**
	 * Na osnovu prosleđenog rednog broja kolone dobavlja njen naziv.
	 * 
	 * @param index redni broj kolone
	 * @return naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Na osnovu rednog broja vrste, dobavlja objekat klase Predmet koji je tu
	 * upisan.
	 * 
	 * @param row redni broj vrste
	 * @return predmet
	 */
	public Predmet getRow(int row) {
		return this.predmeti.get(row);
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
		Predmet predmeti = this.predmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return predmeti.getSifraPredmeta();
		case 1:
			return predmeti.getNazivPredmeta();
		case 2:
			return String.valueOf(predmeti.getEspb());
		case 3:
			return String.valueOf(predmeti.getGodinaStudija());
		case 4:
			String sem = new String();
			if (predmeti.getSemestar() == Semestar.LETNJI)
				sem = "LETNJI";
			else
				sem = "ZIMSKI";
			return sem;
		default:
			return null;
		}
	}

	/**
	 * Metoda koja kreira novi objekat klase Predmet, na osnovu prosleđenih
	 * parametara i ubacuje ga u bazu predmeta.
	 * 
	 * @param sifra     šifra predmeta, jedinstveni identifikator predmeta
	 * @param naziv     naziv predmeta
	 * @param godina    godina izvođenja predmeta
	 * @param espb      broj ESPB bodova koje predmet donosi
	 * @param semestarc semestar izvođenja predmeta kao karakter
	 */
	public void dodajPredmet(String sifra, String naziv, int godina, int espb, char semestarc) {
		Semestar semestar;
		if (semestarc == 'L')
			semestar = Semestar.LETNJI;
		else
			semestar = Semestar.ZIMSKI;

		this.predmeti.add(new Predmet(sifra, naziv, espb, godina, semestar));
		brojac++;
	}

	/**
	 * * Metoda koja omogućuje izmenu nekog entiteta tipa Profesor iz baze
	 * profesora. Nove vrednosti se postavljaju na prosleđene vrednosti.
	 * 
	 * @param pocetnaSifra početna šifra predmeta (pre izmene). Korisno je u slučaju
	 *                     kada želimo da promenimo šifru predmeta. Tada nećemo moći
	 *                     da pronađemo predmet na osnovu nove šifre, već ga prvo
	 *                     nalazimo pod starom šifrom i menjamo mu podatke.
	 * 
	 * @param sifra        nova šifra predmeta, jedinstveni identifikator predmeta
	 * @param naziv        novi naziv predmeta
	 * @param godina       nova godina izvođenja predmeta
	 * @param espb         novi broj ESPB bodova koje predmet donosi
	 * @param semestarc    novi semestar izvođenja predmeta kao karakter
	 */
	public void izmeniPredmet(String pocetnaSifra, String sifra, String naziv, int godina, int espb, char semestarc) {
		Semestar semestar;
		if (semestarc == 'L')
			semestar = Semestar.LETNJI;
		else
			semestar = Semestar.ZIMSKI;

		for (Predmet p : predmeti) {
			if (pocetnaSifra.equals(p.getSifraPredmeta())) {
				p.setSifraPredmeta(sifra);
				p.setNazivPredmeta(naziv);
				p.setGodinaStudija(godina);
				p.setEspb(espb);
				p.setSemestar(semestar);
			}
		}
	}

	/**
	 * Metoda koja na osnovu prosleđene šifre predmeta uklanja predmet iz baze
	 * predmeta.
	 * 
	 * @param sifraPredmeta šifra predmeta koji treba da se obriše
	 */
	public void izbrisiPredmet(String sifraPredmeta) {
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta() == sifraPredmeta) {
				predmeti.remove(p);
				break;
			}
		}
	}

}
