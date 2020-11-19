package gui;
import java.util.*; 

enum Semestar {LETNJI,ZIMSKI};
 
public class Predmet {
	private String sifraPredmeta;
	private String nazivPredmeta;
	public Semestar semestar;
	private int godinaStudija;
	private List<Profesor> profesori;
	private int espb;
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
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, int godinaStudija,int espb) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.profesori = new ArrayList<Profesor>();
		this.espb = espb;
	}

	
	
	

}
