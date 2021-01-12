package model;

import java.io.Serializable;
import java.time.LocalDate;

public class Ocena implements Serializable{
	private Student student;
	private Predmet predmet;
	private int brojcanaVrednost;
	private LocalDate datumPolaganja;
    
	
	
	
	
	
	

	public Ocena(Predmet predmet,Student student) {
		super();
		this.student = student;
		this.predmet = predmet;
	}



	// constructor using fields
	public Ocena(Student student, Predmet predmet, int brojcanaVrednost, LocalDate datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		if (brojcanaVrednost < 6 || brojcanaVrednost > 10) {
			// greska kasnije ispisati
		} else
			this.brojcanaVrednost = brojcanaVrednost;
		     this.datumPolaganja = datumPolaganja;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public int getBrojcanaVrednost() {
		return brojcanaVrednost;
	}

	public void setBrojcanaVrednost(int brojcanaVrednost) {
		this.brojcanaVrednost = brojcanaVrednost;
	}

	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(LocalDate datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	@Override
	public String toString() {
		return "Ocena [student=" + student + ", predmet=" + predmet + ", brojcanaVrednost=" + brojcanaVrednost
				+ ", datumPolaganja=" + datumPolaganja + "]";
	}

}
