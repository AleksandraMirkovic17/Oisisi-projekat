package model;

import java.util.*;

enum Semestar {
	LETNJI, ZIMSKI
};

public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	public Semestar semestar;
	private int godinaStudija;
	private List<Profesor> profesori;
	private int espb;
	private List<Student> poloziliPredmet;
	private List<Student> nisuPoloziliPredmet;

	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Predmet(String s, String s1, int br, int god, Semestar sem) {

		this.sifraPredmeta = s;
		this.nazivPredmeta = s1;
		this.espb = br;
		this.godinaStudija = god;
		this.semestar = sem;

	}

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

	public char getSemestarChar() {
		if (this.semestar == Semestar.LETNJI) {
			return 'L';
		} else {
			return 'Z';
		}
	}

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
