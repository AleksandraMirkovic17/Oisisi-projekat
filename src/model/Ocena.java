package model;

public class Ocena {
	private Student student;
	private Predmet predmet;
	private int brojcanaVrednost;
	private String datumPolaganja;
	
	//constructor using fields
	public Ocena(Student student, Predmet predmet, int brojcanaVrednost, String datumPolaganja) {
		super();
		this.student = student;
		this.predmet = predmet;
		if(brojcanaVrednost<6 || brojcanaVrednost>10) {
			//greska kasnije ispisati
		}
		else this.brojcanaVrednost=brojcanaVrednost;
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

	public String getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}

	@Override
	public String toString() {
		return "Ocena [student=" + student + ", predmet=" + predmet + ", brojcanaVrednost=" + brojcanaVrednost
				+ ", datumPolaganja=" + datumPolaganja + "]";
	}
	
	
	
	

}
