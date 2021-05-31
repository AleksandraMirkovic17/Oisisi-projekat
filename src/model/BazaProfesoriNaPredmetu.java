package model;

import java.util.ArrayList;
import java.util.List;

import view.PredmetJTable;

/**
 * Klasa predstavlja bazu podataka profesora koji predaju na jednom predmetu. S
 * obzirom da za svaki predmet imamo jedinsvenu bazu profesora koji predaju na
 * njemu, ova klasa neće biti implementirana kao singlton.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class BazaProfesoriNaPredmetu {
	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	/**
	 * Instanca klase. Inicijalizuje se na null.
	 */
	private static BazaProfesoriNaPredmetu instance = null;
	/**
	 * Lista profesora koji predaju na selektovanom predmetu.
	 */
	private List<Profesor> profesori;

	/**
	 * Metoda koja omogućuje kreiranje novog objekta tipa BazaProfesoriNaPredmetu.
	 * 
	 * @return instanca novokreirane baze
	 */
	public static BazaProfesoriNaPredmetu getInstance() {
		instance = new BazaProfesoriNaPredmetu();
		return instance;

	}

	/**
	 * Ukupan broj profesora koji predaju na selektovanom predmetu.
	 */
	private int brojac = 0;
	/**
	 * Lista naziva kolona.
	 */
	private List<String> kolone;

	/**
	 * // * Privatan konstruktor bez parametara. Iz razloga što je privatan novi
	 * objekat klase može biti kreiran samo pozivanjem metode getInstance().
	 * Konstruktor inicijalizuje nazive kolona i listu profesora.
	 */
	private BazaProfesoriNaPredmetu() {

		this.kolone = new ArrayList<String>();
		initProfesor();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
	}

	/**
	 * Metoda koja omogućuje inicijalizovanje liste profesora u bazi koji predaju na
	 * selektovanom predmetu.
	 */
	private void initProfesor() {

		this.profesori = new ArrayList<Profesor>();
		int red = PredmetJTable.getInstance().getSelectedRow();
		Predmet p = BazaPredmet.getInstance().getRow(red);
		if (p.getProfesori() != null) {
			this.profesori = p.getProfesori();
		} else {
			p.setProfesori(new ArrayList<Profesor>());
			this.profesori = p.getProfesori();
		}
		brojac = this.profesori.size();
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	/**
	 * Metoda koja vraća koji je profesor poslednji dodat u listu.
	 * 
	 * @return poslednji dodat profesor u slučaju da u sistemu imamo profesore koji
	 *         predaju na selektovanom predmetu, a u slučaju da nemamo povratna
	 *         vrednost je null
	 */
	public Profesor getPoslednjiProfesor() {
		if (this.profesori.size() == 0) {
			System.out.println(this.profesori.size());
			return null;
		}
		Profesor p = this.profesori.get(this.profesori.size() - 1);
		return p;
	}

	public int getBrojac() {
		return brojac;
	}

	/**
	 * Metoda koja postavlja ukupan broj profesora na predmetu na zeljeni broj.
	 * 
	 * @param brojac zeljeni broj profesora
	 */
	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	/**
	 * Metoda koja dodaje profesora u listu, uvećava ukupan broj profesora na
	 * predmet.
	 * 
	 * @param p profesor kog želimo da dodamo
	 */
	public void dodajProfesora(Profesor p) {
		this.profesori.add(p);
		brojac++;
	}

	/**
	 * Metoda koja na osnovu rednog broja kolone dobavlja njen naziv.
	 * 
	 * @param index redni broj kolone
	 * @return naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Metoda koja na osnovu rednog broja vrste dobavlja profesora koji se tu
	 * nalazi.
	 * 
	 * @param row redni broj vrste
	 * @return profesor
	 */
	public Profesor getRow(int row) {
		return this.profesori.get(row);
	}

	/**
	 * 
	 * @return ukupan broj kolona
	 */
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}
}
