package model;

import java.util.ArrayList;
import java.util.List;

import view.ProfesoriJTable;

/**
 * Klasa predstavlja bazu podataka predmeta na kojima predaje jedan profesor. S
 * obzirom da za svakog profesora imamo jedinstvenu bazu predmeta, ova klasa
 * neće biti implementirana kao singlton.
 * 
 * @author Aleksandra Mirković
 *
 */
public class BazaProfesorPredajePredmet {
	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	/**
	 * trenutna instanca klasa, na poćetku se inicijalizuje na null
	 */
	private static BazaProfesorPredajePredmet instance = null;

	/**
	 * metoda kojom kreiramo novu bazu predmeta za određenog profesora
	 * 
	 * @return novokreirana instaca klase BazaProfesorPredajePredmet
	 */
	public static BazaProfesorPredajePredmet getInstance() {

		instance = new BazaProfesorPredajePredmet();

		return instance;

	}

	/**
	 * Broj predmeta. Početna vrednost je nula jer na početku nemamo nijedan
	 * predmet.
	 */
	private int brojac = 0;

	/**
	 * Lista predmeta na kojima predaje određeni profesor.
	 */
	private List<Predmet> predmeti;
	/**
	 * Lista naziva kolona.
	 */
	private List<String> kolone;

	/**
	 * Privatni konstruktor klase. Iz razloga što je privatan novi objekat ove klase
	 * može se kreirati samo pozivanjem metode getInstance(). Konstruktor
	 * inicijalizuje i postavlja nazive kolona.
	 */
	private BazaProfesorPredajePredmet() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SEMESTAR");
	}

	/**
	 * Metoda koja se poziva u konstruktoru, od selektovanog profesora uzima se
	 * lista predmeta na kojima se predaje radi mogućnosti prikazivanja u tabeli.
	 */
	private void initPredmet() {

		this.predmeti = new ArrayList<Predmet>();
		int red = ProfesoriJTable.getInstance().getSelectedRow();
		int model = ProfesoriJTable.getInstance().convertRowIndexToModel(red);
		System.out.printf("Red je %d", red);
		Profesor p = BazaProfesor.getInstance().getRow(model);
		this.predmeti = p.getPredmeti();
		// **** dodati ove da ti proverava da li uopste postoje predmeti koje drzi i
		// izmeniti konstruktor tako da ne postavljas novog profesora, sa null listom
		// predmeta vec sa new List! (ovo radi u klasi dodaj Profesora)
		for (Predmet pp : predmeti) {
			brojac++;
		}
	}

	/**
	 * 
	 * @return broj predmeta na kojima predaje profesor
	 */
	public long getBrojac() { // vraca broj predmeta
		return brojac;
	}

	/**
	 * Postavlja ukupan broj predmeta na prosleđenu vrednost.
	 * 
	 * @param brojac broj predmeta
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
	 * @return broj potrebnih kolona
	 */
	public int getColumnCount() {
		return 4;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	/**
	 * 
	 * @param instance instanca klase
	 */
	public static void setInstance(BazaProfesorPredajePredmet instance) {
		BazaProfesorPredajePredmet.instance = instance;
	}

	/**
	 * Na osnovu prosleđenoj rednog broja kolone vraća njen naziv.
	 * 
	 * @param index redni broj kolone
	 * @return naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Na osnovi prosleđenog rednog broja vrste vraća predmet koji se tamo nalazi.
	 * 
	 * @param row redni broj vrste
	 * @return predmet
	 */
	public Predmet getRow(int row) {
		return this.predmeti.get(row);
	}

	/**
	 * Metoda koja vraća šta se nalazi na preseku određene vrednosti vrste i kolone.
	 * U pitanju je vrednost nekog polja kod entiteta tipa predmet.
	 * 
	 * @param row    redni broj vrste
	 * @param column redni broj kolone
	 * @return vrednost
	 */
	public String getValueAt(int row, int column) {
		Predmet predmeti = this.predmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return predmeti.getSifraPredmeta();
		case 1:
			return predmeti.getNazivPredmeta();
		case 2:
			return String.valueOf(predmeti.getGodinaStudija());
		case 3:
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
	 * Metoda omogućuje dodavanje predmeta u listu predmeta.
	 * 
	 * @param p predmet
	 */
	public void dodajPredmet(Predmet p) {
		this.predmeti.add(p);
	}

	/**
	 * Metoda omogućuje brisanje određenog predmeta kod određenog profesora.
	 * 
	 * @param sifraPredmeta jedinstvaeni identifikator predmeta
	 * @param brLicneKarte  jedinstvei identifikator profesora
	 * @param p             profesor
	 */
	public void izbrisiPredmet(String sifraPredmeta, String brLicneKarte, Profesor p) {

		predmeti = p.getPredmeti();
		System.out.println();
		for (Predmet p1 : predmeti) {
			if (p1.getSifraPredmeta() == sifraPredmeta) {
				// predmeti.remove(p1);
				break;
			}

		}

	}

	/**
	 * Metoda omogućuje brisanje predmeta kod profesora.
	 * 
	 * @param profesor profesor
	 * @param sifra    šifra predmeta
	 */
	public void izbrisiPredmet1(Profesor profesor, String sifra) {
		// TODO Auto-generated method stub
		predmeti = profesor.getPredmeti();

		System.out.println("OVDE SAM KUCKO " + predmeti);
		for (Predmet p : predmeti) {
			if (p.getSifraPredmeta().equals(sifra)) {
				profesor.getPredmeti().remove(p);
				break;
			}

		}
	}
}
