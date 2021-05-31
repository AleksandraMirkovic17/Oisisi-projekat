package model;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasa koja modeluje entitet ocena u informacionom sistemu.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class Ocena implements Serializable {
	/**
	 * Student kome je dodeljena ocena.
	 */
	private Student student;
	/**
	 * Predmet iz kog je student dobio ocenu.
	 */
	private Predmet predmet;
	/**
	 * Brojčana vrednost ocene.
	 */
	private int brojcanaVrednost;
	/**
	 * Datum polaganja. Predstavlja datum kada je ova ocena dobijena.
	 */
	private LocalDate datumPolaganja;

	/**
	 * Konstruktor sa parametrima. Kreira objekat klase ocena.
	 * 
	 * @param predmet predmet iz kog je student dobio ocenu nakon polaganja
	 * @param student koji je to student koji je polgao predmet i dobio ocenu
	 */
	public Ocena(Predmet predmet, Student student) {
		super();
		this.student = student;
		this.predmet = predmet;
	}

	/**
	 * Konstruktor sa parametrima. Kreira objekat klase ocena i inicijalizuje polja
	 * na prosleđene vrednosti.
	 * 
	 * @param student          koji je to student koji je polgao predmet i dobio
	 *                         ocenu
	 * @param predmet          predmet iz kog je student dobio ocenu nakon polaganja
	 * @param brojcanaVrednost brojčana vrednost ocene
	 * @param datumPolaganja   datum polaganja predmeta
	 */
	public Ocena(Student student, Predmet predmet, int brojcanaVrednost, LocalDate datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		if (brojcanaVrednost < 6 || brojcanaVrednost > 10) {
			brojcanaVrednost = 6;
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

	/**
	 * Predstava klase ocena u obliku stringa,
	 */
	@Override
	public String toString() {
		/*
		 * return "Ocena [student=" + student + ", predmet=" + predmet +
		 * ", brojcanaVrednost=" + brojcanaVrednost + ", datumPolaganja=" +
		 * datumPolaganja + "]";
		 */
		return "";
	}

}
