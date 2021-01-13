package model;

import java.io.Serializable;
import java.util.*;

enum Semestar {
	LETNJI, ZIMSKI
};

@SuppressWarnings("serial")
public class Predmet implements Serializable{
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
    
	public Predmet(String sifraPredmeta, String nazivPredmeta, int espb,int godinaStudija, Semestar semestar) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.espb = espb;
		this.poloziliPredmet=new ArrayList<Student>();
		this.nisuPoloziliPredmet=new ArrayList<Student>();
		this.profesori= new ArrayList<Profesor>();
	}

	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,
			List<Profesor> profesori, int espb) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesori = profesori;
		this.espb = espb;
		this.poloziliPredmet=new ArrayList<Student>();
		this.nisuPoloziliPredmet=new ArrayList<Student>();
		
	}

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
