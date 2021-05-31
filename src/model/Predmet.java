package model;

import java.io.Serializable;
import java.util.*;

/**
 * Enumeracija vrste semestra.
 * 
 * @author Aleksandra Mirković
 *
 */
enum Semestar {
	LETNJI, ZIMSKI
};

/**
 * Klasa koja modeluje entitet predmet u informacionom sistemu.
 * 
 * @author Aleksandra Mirković
 *
 */
@SuppressWarnings("serial")
public class Predmet implements Serializable {
	/**
	 * šifra predmeta, jedinstveno identifikuje svaki predmet unet u sistem
	 */
	private String sifraPredmeta;
	/**
	 * naziv predmeta
	 */
	private String nazivPredmeta;
	/**
	 * semestar izvođenja predmeta
	 */
	public Semestar semestar;
	/**
	 * godina na kojoj se izvodi predmet
	 */
	private int godinaStudija;
	/**
	 * lista profesora koji predaju na ovom predmetu
	 */
	private List<Profesor> profesori;
	/**
	 * broj ESPB bodova koje nosi ovaj predmet nakon polaganja
	 */
	private int espb;
	/**
	 * lista studenata koji su položili ovaj predmet
	 */
	private List<Student> poloziliPredmet;
	/**
	 * lista studenata koji su slušali ovaj predmet, ili ga i dalje slušaju, ali ga
	 * još nisu položili.
	 */
	private List<Student> nisuPoloziliPredmet;

	/**
	 * Konstruktor bez parametara
	 */
	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Konstruktor sa parametrima. Inicijalizuje polja ove klase na prosleđene
	 * vrednosti i kreira objekat.
	 * 
	 * @param sifraPredmeta -šifra predmeta
	 * @param nazivPredmeta -naziv predmeta
	 * @param espb          -broj ESPB bodove koje predmet nosi
	 * @param godinaStudija -godina studija na kojoj se izvodi predmet
	 * @param semestar      -semestar izvođenja predmeta
	 */
	public Predmet(String sifraPredmeta, String nazivPredmeta, int espb, int godinaStudija, Semestar semestar) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.espb = espb;
		this.profesori = new ArrayList<Profesor>();
		this.nisuPoloziliPredmet = new ArrayList<Student>();
		this.poloziliPredmet = new ArrayList<Student>();
	}

	/**
	 * Konstruktor sa parametrima. Inicijalizuje polja ove klase na prosleđene
	 * vrednosti i kreira objekat.
	 * 
	 * @param sifraPredmeta -šifra predmeta
	 * @param nazivPredmeta -naziv predmeta
	 * @param semestar      -semestar
	 * @param godinaStudija -godina stuja izvođenja predmeta
	 * @param profesori     -lista profesora koji predaju na ovom predmetu
	 * @param espb          -broj ESPB bodova koje predmet donosi
	 */

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			List<Profesor> profesori, int espb) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesori = profesori;
		this.nisuPoloziliPredmet = new ArrayList<Student>();
		this.poloziliPredmet = new ArrayList<Student>();
		this.espb = espb;
	}

	/**
	 * Konstruktor sa parametrima. Inicijalizuje polja ove klase na prosleđene
	 * vrednosti i kreira objekat.
	 * 
	 * @param sifraPredmeta       -šifra predmeta
	 * @param nazivPredmeta       -naziv predmeta
	 * @param semestar            -semestar
	 * @param godinaStudija       -godina stuja izvođenja predmeta
	 * @param profesori           -lista profesora koji predaju na ovom predmetu
	 * @param espb                -broj ESPB bodova koje predmet donosi
	 * @param poloziliPredmet     -lista studenata koji su položili predmet
	 * @param nisuPoloziliPredmet -lista studenata koji nisu položili predmet
	 */
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			List<Profesor> profesori, int espb, List<Student> poloziliPredmet, List<Student> nisuPoloziliPredmet) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesori = profesori;
		this.espb = espb;
		this.poloziliPredmet = poloziliPredmet;
		this.nisuPoloziliPredmet = nisuPoloziliPredmet;
	}

	/**
	 * Predstava klase Predmet u obliku stringa
	 */
	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", profesori=" + profesori + ", espb=" + espb
				+ ", poloziliPredmet=" + poloziliPredmet + ", nisuPoloziliPredmet=" + nisuPoloziliPredmet + "]";
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public String getNazivPredmeta() {
		return nazivPredmeta;
	}

	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}

	public Semestar getSemestar() {
		return semestar;
	}

	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}

	/**
	 * 
	 * @return povratna vrednost je semestar održavanja predmeta u obliku stringa
	 */
	public char getSemestarChar() {
		if (this.semestar == Semestar.LETNJI) {
			return 'L';
		} else {
			return 'Z';
		}
	}

	/**
	 * Postavlja semestar predmeta na odgovarajući na osnovu prosleđenog karaktera
	 * 
	 * @param semestar semstar prikazan u obliku karaktera (tip char)
	 */
	public void setSemestarChar(char semestar) {
		if (semestar == 'L') {
			this.semestar = Semestar.LETNJI;
		} else {
			this.semestar = Semestar.ZIMSKI;
		}
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	public List<Student> getPoloziliPredmet() {
		return poloziliPredmet;
	}

	public void setPoloziliPredmet(List<Student> poloziliPredmet) {
		this.poloziliPredmet = poloziliPredmet;
	}

	public List<Student> getNisuPoloziliPredmet() {
		return nisuPoloziliPredmet;
	}

	public void setNisuPoloziliPredmet(List<Student> nisuPoloziliPredmet) {
		this.nisuPoloziliPredmet = nisuPoloziliPredmet;
	}

}
