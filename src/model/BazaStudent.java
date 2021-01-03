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
		ArrayList<Predmet> NepolozeniPredmeti=new ArrayList<Predmet>();
		Predmet p1=new Predmet("E123","Verovatnoca",Semestar.LETNJI,3,new ArrayList<Profesor>(),9);
		NepolozeniPredmeti.add(p1);
		Predmet p2=new Predmet("E12RR3","Analiza Matematicka",Semestar.LETNJI,1,new ArrayList<Profesor>(),9);
		NepolozeniPredmeti.add(p2);
		
		ArrayList<Ocena> polozeniP = new ArrayList<Ocena>();
		Ocena o1 = new Ocena(null, p1, 9, LocalDate.of(2018, 5, 31));
		polozeniP.add(o1);
		
		studenti.add(new Student("Markovic", "Marko", LocalDate.of(1999, 5, 25), "Kireska 5", "9231234",
				"marko@uns.ac.rs", "ra-12-2018", 2018, 3, statusStudenta.B, 0.0, polozeniP,
				NepolozeniPredmeti));
		generateIns();
		studenti.add(new Student("Ivanovic", "Ana", LocalDate.of(1998, 12, 7), "Uskocka 35", "923788234",
				"ana@uns.ac.rs", "ra-14-2018", 2018, 3, statusStudenta.S, 0.0, new ArrayList<Ocena>(),
				new ArrayList<Predmet>()));
		generateIns();
		studenti.add(new Student("Jovanov", "Dunja", LocalDate.of(1996, 7, 14), "Dusanova 13", "065432",
				"dunjajo@uns.ac.rs", "sw-123-2017", 2017, 4, statusStudenta.S, 0.0, new ArrayList<Ocena>(),
				new ArrayList<Predmet>()));
		generateIns();
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
			if (student.getStatus() == statusStudenta.B)
				status = "BUDZETSKI";
			else
				status = "SAMOFINANSIRAJUCI";
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
		statusStudenta status;
		if (statusc == 'S')
			status = statusStudenta.S;
		else
			status = statusStudenta.B;

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
}