package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * Enumeracija svih titula koje profesor u informacionom sistemu može da ima
 * 
 * @author Aleksandra Mirković
 *
 */
enum Titula {
	PROF_DR, DR
};

/**
 * Enumeracija svih zvanja koja profesor može da ima
 * 
 * @author Aleksandra Mirković
 *
 */
enum Zvanje {
	REDOVNI_PROFESOR, VANREDNI_PROFESOR, DOCENT
};

/**
 * Klasa koja modeluje entitet profesor u informacionom sistemu.
 * 
 * @author Aleksandra Mirković
 *
 */
public class Profesor implements Serializable {
	/**
	 * ime profesora
	 */
	public String ime;
	/**
	 * prezime profesora
	 */
	private String prezime;
	/**
	 * datum rođenja profesora
	 */
	private LocalDate datumRodjena;
	/**
	 * broj telefona profesora
	 */
	private String brojTelefona;
	/**
	 * adresa stanovanja profesora
	 */
	private String adresaStanovanja;
	/**
	 * adresa elektronske pošte
	 */
	private String email;
	/**
	 * adresa kancelarije profesora
	 */
	private String adresaKancelarije;
	/**
	 * broj lične karte profesora, polje koje jedinstveno određuje profesora
	 */
	private String brLicneKarte;
	/**
	 * titula profesora
	 */
	private Titula titula;
	/**
	 * zvanje profesora
	 */
	private Zvanje zvanjeProfesora;
	/**
	 * lista predmeta na kojima profesor predaje
	 */
	private List<Predmet> predmeti;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	/**
	 * Konstruktor klase sa parametrima. Inicijalizuje vrednosti polja na prosleđene
	 * vrednosti.
	 * 
	 * @param ime               -ime profesora
	 * @param prezime           -prezime profesora
	 * @param datumRodjena      -datum rođenja profesora
	 * @param brojTelefona      -broj telefona profesora
	 * @param adresaStanovanja  - adresa stanovanja profesora
	 * @param email             -adresa elektronske pošte
	 * @param adresaKancelarije - adresa kancelarija
	 * @param brLicneKarte      -broj lične karte profesora
	 * @param titula            -titula
	 * @param zvanjeProfesora   -zvanje profesora
	 * @param predmeti          -lista predmeta a kojima profesor predaje
	 */
	public Profesor(String ime, String prezime, LocalDate datumRodjena, String brojTelefona, String adresaStanovanja,
			String email, String adresaKancelarije, String brLicneKarte, Titula titula, Zvanje zvanjeProfesora,
			ArrayList<Predmet> predmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjena = datumRodjena;
		this.brojTelefona = brojTelefona;
		this.adresaStanovanja = adresaStanovanja;
		this.email = email;
		this.adresaKancelarije = adresaKancelarije;
		this.brLicneKarte = brLicneKarte;
		this.titula = titula;
		this.zvanjeProfesora = zvanjeProfesora;
		this.predmeti = predmeti;
	}

	/**
	 * Predstava klase u obliku stringa
	 */
	@Override
	public String toString() {
		return "\t\t" + ime + " " + prezime + "\t\t";
	}

	/**
	 * Konstruktor bez parametara
	 */
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public LocalDate getDatumRodjena() {
		return datumRodjena;
	}

	public void setDatumRodjena(LocalDate datumRodjena) {
		this.datumRodjena = datumRodjena;
	}

	public String getBrojTelefona() {
		return brojTelefona;
	}

	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(String adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public String getBrLicneKarte() {
		return brLicneKarte;
	}

	public void setBrLicneKarte(String brLicneKarte) {
		this.brLicneKarte = brLicneKarte;
	}

	public Titula getTitula() {
		return titula;
	}

	public void setTitula(Titula titula) {
		this.titula = titula;
	}

	public Zvanje getZvanjeProfesora() {
		return zvanjeProfesora;
	}

	public void setZvanjeProfesora(Zvanje zvanjeProfesora) {
		this.zvanjeProfesora = zvanjeProfesora;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	/**
	 * @return povratna vrednost metode je titula u obliku stringa
	 */
	public String getTitulaString() {
		if (this.titula == Titula.PROF_DR) {
			return "PROF_DR";
		} else {
			return "DR";
		}
	}

	/**
	 * Postavlja titulu profesora na odgovarajuću, na osnovu prosleđenog stringa.
	 * 
	 * @param s -titula profesora u obliku stringa
	 */
	public void setTitulaString(String s) {
		if (s == "PROF_DR") {
			this.titula = Titula.PROF_DR;
		} else {
			this.titula = Titula.DR;
		}
	}

	/**
	 * 
	 * @return zvanje profesora u obliku stringa
	 */
	public String getZvanjeString() {
		if (this.zvanjeProfesora == Zvanje.DOCENT) {
			return "DOCENT";
		} else if (this.zvanjeProfesora == Zvanje.REDOVNI_PROFESOR) {
			return "REDOVNI_PROFESOR";
		} else
			return "VANREDNI_PROFESOR";
	}

	/**
	 * Postavlja zvanje profesora na odgovarajuće, na osnovu prosleđenog stringa.
	 * 
	 * @param s -zvanje profesora u obliku stringa
	 */
	public void setZvanjeString(String s) {
		if (s == "REDOVNI_PROFESOR") {
			this.zvanjeProfesora = Zvanje.REDOVNI_PROFESOR;
		} else if (s == "VANREDNI_PROFESOR") {
			this.zvanjeProfesora = Zvanje.VANREDNI_PROFESOR;
		} else {
			this.zvanjeProfesora = Zvanje.DOCENT;
		}

	}
}
