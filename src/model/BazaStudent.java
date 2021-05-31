package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Klasa predstavlja bazu podataka za entitet Student. Implementirana je kao
 * singlton.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class BazaStudent {
	/**
	 * Instanca klase BazaStudent. Inicijalizuje se na null.
	 */
	private static BazaStudent instance = null;

	/**
	 * Metoda koja vraća postojeću instancu klase BazaStudent u slučaju kada smo je
	 * već kreirali ili kreira novu.
	 * 
	 * @return povratna vrednost je referenca na objekat klase BazaStudent
	 */
	public static BazaStudent getInstance() {
		if (instance == null)
			instance = new BazaStudent();
		return instance;
	}

	/**
	 * broj studenata u sistemu
	 */
	private int generator;
	/**
	 * Lista entiteta tipa Student
	 */
	private List<Student> studenti;
	/**
	 * Lista naziva kolona
	 */
	private List<String> kolone;

	/**
	 * Konstruktor klase BazaStudent. Inicijalizuje broj studenata na 0 i popunjava
	 * listu naziva kolona.
	 */
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

	/**
	 * Metoda za inicijalizaciju nekoliko studenata hard-core unos, služi za
	 * hard-code unos nekoliko entiteta
	 */
	private void initStudent() {
		this.studenti = new ArrayList<Student>();
		ArrayList<Predmet> NepolozeniPredmeti = new ArrayList<Predmet>();
		Predmet p1 = new Predmet("EE123", "Verovatnoca", Semestar.LETNJI, 3, new ArrayList<Profesor>(), 9);
		NepolozeniPredmeti.add(p1);
		Predmet p2 = new Predmet("E12RR3", "Analiza Matematicka", Semestar.LETNJI, 1, new ArrayList<Profesor>(), 9);
		NepolozeniPredmeti.add(p2);

		ArrayList<Ocena> polozeniP = new ArrayList<Ocena>();
		ArrayList<Ocena> polozeniP1 = new ArrayList<Ocena>();
		Ocena o1 = new Ocena(null, p1, 9, LocalDate.of(2018, 5, 31));
		Ocena o2 = new Ocena(null, p1, 6, LocalDate.of(2019, 5, 7));
		polozeniP.add(o1);
		polozeniP1.add(o2);

		studenti.add(new Student("Markovic", "Marko", LocalDate.of(1999, 5, 25), "Kireska 5", "9231234",
				"marko@uns.ac.rs", "ra-12-2018", 2018, 3, StatusStudenta.B, 0.0, polozeniP, NepolozeniPredmeti));
		generateIns();
		studenti.add(new Student("Ivanovic", "Ana", LocalDate.of(1998, 12, 7), "Uskocka 35", "923788234",
				"ana@uns.ac.rs", "ra-14-2018", 2018, 3, StatusStudenta.S, 0.0, polozeniP1, new ArrayList<Predmet>()));
		generateIns();
		studenti.add(new Student("Jovanov", "Dunja", LocalDate.of(1996, 7, 14), "Dusanova 13", "065432",
				"dunjajo@uns.ac.rs", "sw-123-2017", 2017, 4, StatusStudenta.S, 0.0, new ArrayList<Ocena>(),
				new ArrayList<Predmet>()));
		generateIns();
	}

	public List<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}

	/**
	 * Metoda koja se poziva nakon dodavanja novog entiteta tipa student u bazu,
	 * povećava broj studenata u bazi.
	 * 
	 * @return ukupan broj studenata
	 */
	private int generateIns() {
		return ++generator;
	}

	/**
	 * @return povratna vrednost je ukupan broj kolona
	 */
	public int getColumnCount() {
		return 6;
	}

	/**
	 * Metoda koja na osnovu rednog broja kolona dobavlja njen naziv.
	 * 
	 * @param index -redni broj kolone
	 * @return povratna vrednost je naziv kolone
	 */
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	/**
	 * Metoda koja na osnovu rednog broja vrste dobavlja studenta koji se nalazi u
	 * toj vrsti.
	 * 
	 * @param rowIndex -redni broj vrste
	 * @return povratna vrednost je student čiji su podaci upisani u tu vrstu
	 */
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}

	public int getBrojStudenata() {
		return generator;
	}

	/**
	 * Metoda koja vraća šta se nalazi na preseku određene vrednosti vrste i kolone.
	 * U pitanju je vrednost nekog polja kod entiteta tipa student.
	 * 
	 * @param row    redni broj vrste
	 * @param column redni broj kolone
	 * @return povratna vrednost je vrednost nekog polja entiteta tipa student
	 */
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

	/**
	 * Metoda koja kreira novi objekat klase Student, na osnovu prosleđenih
	 * parametara i ubacuje ga u bazu studenata.
	 * 
	 * @param prezime               prezime studenta
	 * @param ime                   ime studenta
	 * @param datumRodjenja         datum rođenja studenta
	 * @param adresaStanovanja      adresa stanovanja studenta
	 * @param kontaktTelefon        broj telefona studenta
	 * @param email                 adresa elektronske pošte studenta
	 * @param brIndeksa             broj indeksa studenta
	 * @param godinaUpisa           godina upisa studenta
	 * @param trenutnaGodinaStudija trenutna godina studija studenta
	 * @param statusc               način finansiranja studenta u obliku karaktera
	 */
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

	/**
	 * Metoda koja omogućuje izmenu nekog entiteta tipa Student iz baze studenata.
	 * Nove vrednosti se postavljaju na prosleđene vrednosti.
	 * 
	 * @param pocetniIndeks         početni indeks studenta, služi nam za
	 *                              pronalaženje studenta čije podatke želimo da
	 *                              izmenimo,jer u slučaju ako želimo da izmenimo i
	 *                              broj indeksa, na osnovu novog broja indeksa
	 *                              nećemo moći da pronađemo studenta čije podatke
	 *                              želimo da izmenimo
	 * @param prezime               novo prezime studenta
	 * @param ime                   novo ime studenta
	 * @param datumRodjenja         novi datum rođenja studenta
	 * @param adresaStanovanja      nova adresa stanovanja studenta
	 * @param kontaktTelefon        novi broj telefona studenta
	 * @param email                 nova adresa elektronske pošte studenta
	 * @param brIndeksa             novi broj indeksa studenta
	 * @param godinaUpisa           nova godina upisa studenta
	 * @param trenutnaGodinaStudija nova trenutna godina studija studenta
	 * @param statusc               novi način finansiranja studenta u obliku
	 *                              karaktera
	 */
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

	/**
	 * Metoda postavlja ukupan broj studenata u bazi na prosleđeni broj
	 * 
	 * @param size -novi ukupan broj studenata
	 */
	public void setBrojStudenata(int size) {
		// TODO Auto-generated method stub
		generator = size;

	}

	/**
	 * Metoda koja se poziva pre brisanja nekog premdeta iz baze predmeta. Briše
	 * obrisani predmet kod svakog studenta koji je taj predmet imao u svojoj listi
	 * nepoloženih predmeta.
	 * 
	 * @param sifra šifra obrisanog predmeta
	 */
	public void izbrisiPredmet(String sifra) {
		for (Student t : studenti) {
			for (Predmet pp : t.getNepolozeniPredmeti()) {

				if (pp.getSifraPredmeta() == sifra)
					t.getNepolozeniPredmeti().remove(pp);
			}
		}
	}
}