package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BazaStudent {
	private static BazaStudent instance = null;

	public static BazaStudent getInstance() {
		if (instance == null)
			instance = new BazaStudent();
		return instance;
	}

	private int generator;

	private List<Student> studenti;
	private List<String> kolone;

	private BazaStudent() {
		generator = 0;

		

		this.kolone = new ArrayList<String>();
		initStudent();
		this.kolone.add("INDEKS");
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("STATUS");
		this.kolone.add("PROSEK");

	}

	private void initStudent() {
		this.studenti = new ArrayList<Student>();
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	private int generateIns() {
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

	public int getBrojStudenata() {
		return generator;
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
			if (student.getStatus() == StatusStudenta.B)
				status = "BUDŽETSKI";
			else
				status = "SAMOFINANSIRAJUĆI";
			return status;
		case 5:
			return Double.toString(student.getProsecnaOcena());
		default:
			return null;
		}
	}

	public void dodajStudenta(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja,
			String kontaktTelefon, String email, String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija,
			char statusc) {
		StatusStudenta status;
		if (statusc == 'S')
			status = StatusStudenta.S;
		else
			status = StatusStudenta.B;

		this.studenti.add(new Student(prezime, ime, datumRodjenja, adresaStanovanja, kontaktTelefon, email, brIndeksa,
				godinaUpisa, trenutnaGodinaStudija, status, 0, new ArrayList<Ocena>(), new ArrayList<Predmet>()));
		generateIns();
	}

	public void izmeniStudenta(String pocetniIndeks, String prezime, String ime, LocalDate datumRodjenja,
			String adresaStanovanja, String kontaktTelefon, String email, String brIndeksa, int godinaUpisa,
			int trenutnaGodinaStudija, char statusc) {
		for (Student s : studenti) {
			if (s.getBrIndeksa().equals(pocetniIndeks)) {
				s.setIme(ime);
				s.setPrezime(prezime);
				s.setDatumRodjenja(datumRodjenja);
				s.setAdresaStanovanja(adresaStanovanja);
				s.setKontaktTelefon(kontaktTelefon);
				s.setEmail(email);
				s.setBrIndeksa(brIndeksa);
				s.setGodinaUpisa(godinaUpisa);
				s.setTrenutnaGodinaStudija(trenutnaGodinaStudija);
				s.setStatusChar(statusc);
			}
		}
	}

	public void setBrojStudenata(int size) {
		// TODO Auto-generated method stub
		generator = size;
		
	}
}