package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BazaStudent {
	private static BazaStudent instance =null;
	
	public static BazaStudent getInstance() {
		if(instance==null)
			instance=new BazaStudent();
		return instance;	
	}
	
	private long generator;

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudent() {
		generator = 0;
	
		initStudent();

		this.kolone = new ArrayList<String>();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");

	}

	private void initStudent() {
		this.studenti = new ArrayList<Student>();
		studenti.add(new Student("Markovic", "Marko", LocalDate.of(1999, 5, 25), "Kireska 5", "9231234", "marko@uns.ac.rs", "RA756", 2018, 3, statusStudenta.B, 8.5, null));
		generateIns();
		studenti.add(new Student("Ivanovic", "Ana", LocalDate.of(1998, 12, 7), "Uskocka 35", "923788234", "ana@uns.ac.rs", "RA758", 2018, 3, statusStudenta.S, 7.5, null));
		generateIns();
		studenti.add(new Student("Jovanov", "Dunja", LocalDate.of(1996, 7, 14), "Dusanova 13", "065432", "dunjajo@uns.ac.rs", "E56", 2017, 4, statusStudenta.S, 8.5, null));
        generateIns();
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	private long generateIns() {
		return ++generator;
	}

	public int getColumnCount() {
		return 6;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getBrIndeksa();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return Integer.toString(student.getTrenutnaGodinaStudija());
		case 4:
			String status = new String();
			if(student.getStatus() == statusStudenta.B) status="BUDZETSKI"; else status= "SAMOFINANSIRAJUCI";
			return status;
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}

	/*public void dodajIgrac(String ime, String prezime, String klub) {
		this.igraci.add(new Igrac(generateId(), ime, prezime, klub));
	}

	public void izbrisiIgraca(long id) {
		for (Igrac i : igraci) {
			if (i.getId() == id) {
				igraci.remove(i);
				break;
			}
		}
	}

	public void izmeniIgraca(long id, String ime, String prezime, String klub) {
		for (Igrac i : igraci) {
			if (i.getId() == id) {
				i.setIme(ime);
				i.setPrezime(prezime);
				i.setKlub(klub);
			}
		}
	}*/
}
