package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;
enum Titula {
	PROF_DR, DR
};

enum Zvanje {
	REDOVNI_PROFESOR, VANREDNI_PROFESOR,DOCENT
};

public class Profesor implements Serializable{
	public String ime;
	private String prezime;
	private LocalDate datumRodjena;
	private String brojTelefona;
	private String adresaStanovanja;
	private String email;
	private String adresaKancelarije;
	private String brLicneKarte;
	private Titula titula;
	private Zvanje zvanjeProfesora;
	private List <Predmet> predmeti;
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public Profesor(String ime, String prezime, LocalDate datumRodjena, String brojTelefona, String adresaStanovanja,
			String email, String adresaKancelarije, String brLicneKarte, Titula titula, Zvanje zvanjeProfesora,ArrayList<Predmet> predmeti) {
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
	@Override
	public String toString() {
		return "Profesor [ime=" + ime + ", prezime=" + prezime + ", datumRodjena=" + datumRodjena + ", brojTelefona="
				+ brojTelefona + ", adresaStanovanja=" + adresaStanovanja + ", email=" + email + ", adresaKancelarije="
				+ adresaKancelarije + ", brLicneKarte=" + brLicneKarte + ", titula=" + titula + ", zvanjeProfesora="
				+ zvanjeProfesora + ", predmeti=" + predmeti+ "]";
	}
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
	public String getTitulaString() {
		if (this.titula == Titula.PROF_DR) {
			return "PROF_DR";
		} else {
			return "DR";
		}
	}

	public void setTitulaString(String s) {
		if (s == "PROF_DR") {
			this.titula = Titula.PROF_DR;
		} else {
			this.titula = Titula.DR;
		}
	}
	public String getZvanjeString() {
		if (this.zvanjeProfesora == Zvanje.DOCENT) {
			return "DOCENT";
		} else if(this.zvanjeProfesora == Zvanje.REDOVNI_PROFESOR) {
			return "REDOVNI_PROFESOR";
		}
			else
				return "VANREDNI_PROFESOR";
		}

	public void setZvanjeString(String s) {
		if (s == "REDOVNI_PROFESOR") {
			this.zvanjeProfesora = Zvanje.REDOVNI_PROFESOR;
		} else if(s=="VANREDNI_PROFESOR"){
			this.zvanjeProfesora = Zvanje.VANREDNI_PROFESOR;
		}
		else
		{
			this.zvanjeProfesora=Zvanje.DOCENT;
		}
			
	}
}
