package model;

import java.time.LocalDate;
import java.util.*;

/**
 * Klasa predstavlja bazu podataka za entitet Profesor u sistemu. Implementirana
 * je kao singlton.
 * 
 * @author Aleksandra Mirković
 *
 */
public class BazaProfesor {

	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu profesora, jer ne zelimo da neko drugi sa vise strana to
	// menja,zelimo da kontrolisemo podatke
	/**
	 * Instanca klase BazaProfesor. Na početku se inicijalizuje na null.
	 */
	private static BazaProfesor instance = null;

	/**
	 * Metoda koja proverava da li smo prethodno instancirali ovu klasu, ako jesmo
	 * vraća prethodno kreirani objekat a ako nismo kreira novi i postavlja
	 * instancu, a zatim vraća novokreirani objekat ove klase.
	 * 
	 * @return instanca klase
	 */
	public static BazaProfesor getInstance() {
		if (instance == null)
			instance = new BazaProfesor();
		return instance;

	}

	/**
	 * Ukupan broj profesora u sistemu.
	 */
	private long broj_profesora = 0;

	/**
	 * Lista profesora.
	 */
	private List<Profesor> profesori;// konkretni objekat
	/**
	 * Lista naziva kolona.
	 */
	private List<String> kolone; // predstavlja nazive kolone

	/**
	 * Konstruktor klase BazaPtufesor. Inicijalizuje broj profesora na 0 i popunjava
	 * listu naziva kolona. Konstruktor je privatan pa se iz tog razloga može
	 * pozvati samo iz metode getInstance().
	 */
	private BazaProfesor() {

		this.kolone = new ArrayList<String>(); // kreiramo novu listu za kolonu
		initProfesor();
		this.kolone.add("PREZIME");
		this.kolone.add("IME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
	}

	/**
	 * Inicijalizacija liste profesora. Metoda omogućuje tzv. hard-code unos
	 * entiteta profesor u sistem.
	 */
	private void initProfesor() {
		this.profesori = new ArrayList<Profesor>(); // postavljamo da je prazna lista
		// kreiramo novog profesora koja je stavljena u listu
		ArrayList<Predmet> predajePredmet = new ArrayList<Predmet>();
		Predmet p1 = new Predmet("EE123", "Verovatnoca", Semestar.LETNJI, 3, new ArrayList<Profesor>(), 9);
		Predmet p2 = new Predmet("E12RR3", "Analiza Matematicka", Semestar.LETNJI, 1, new ArrayList<Profesor>(), 9);
		predajePredmet.add(p1);
		predajePredmet.add(p2);
		profesori.add(new Profesor("Petar", "Petrovic", LocalDate.of(1999, 5, 25), "069877633", "Tolstojeva 10",
				"petarpetrovic@gmail.com", "Radnicka 17", "199928277745", Titula.PROF_DR, Zvanje.REDOVNI_PROFESOR,
				predajePredmet));
		incBroj_Profesora(); // povecavamo broj profesora
		profesori.add(new Profesor("Nikola", "Nikolic", LocalDate.of(1980, 4, 17), "069667633", "Tolstojeva 1",
				"nikolanikolic@gmail.com", "Radnicka 17", "1980777166111", Titula.PROF_DR, Zvanje.VANREDNI_PROFESOR,
				new ArrayList<Predmet>()));
		incBroj_Profesora();

	}

	/**
	 * Povećava ukupan broj profesora za jedan.
	 * 
	 * @return uvećani ukupan broj profesora koji su uneti u sistem
	 */
	public long incBroj_Profesora() { // kada pronadjemo nekog profesora treba da broj_profesora povecamo
		return broj_profesora++;
	}

	/**
	 * 
	 * @return ukupan broj profesora u sistemu
	 */
	public long getbroj_profesora() {
		return broj_profesora;

	}

	/**
	 * Postavlja ukupan broj profesora u sistemu na željenu vrednost.
	 * 
	 * @param broj_profesora željeni broj profesora u sistemu
	 */
	public void setBroj_Profesora(long broj_profesora) {
		this.broj_profesora = broj_profesora;
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public List<String> getKolone() {
		return kolone;
	}

	/**
	 * 
	 * @return ukupan broj kolona
	 */
	public int getColumnCount() {
		return 4;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	/**
	 * Postavlja instancu na željenu prosleđenu vrednost.
	 * 
	 * @param instance instanca klase
	 */
	public static void setInstance(BazaProfesor instance) {
		BazaProfesor.instance = instance;
	}

	/**
	 * Na osnovu rednog broja kolone dobavlja naziv kolone.
	 * 
	 * @param index redni broj kolone
	 * @return naziv kolone
	 */
	public String getColumnName(int index) // vrati mi naziv kolone
	{
		return this.kolone.get(index); // iz liste kolone vrati mi kolonu sa tim indexom koju sam prosledila
	}

	/**
	 * Na osnovu rednog broja vrste dobavlja profesora koji se tu nalazi.
	 * 
	 * @param row redni broj vrste
	 * @return profesor
	 */
	public Profesor getRow(int row) // dobavljamo ceo red, i po indexu dobavi mi taj red tj, tog profesora, dobijamo
									// jednog celog profesora
	{
		return this.profesori.get(row);
	}

	/**
	 * Na osnovu rednog broja vrste i rednog broja kolone dobavlja vrednost polja
	 * profesora koja je tu upisana.
	 * 
	 * @param row    redni broj vrste
	 * @param column redni broj kolone
	 * @return vrednost polja
	 */
	public String getValueAt(int row, int column) {
		Profesor profesori = this.profesori.get(row); // dobavi mi ceo red i smesti mi u objekat profesori. i ukoliko
														// smo postavili da je kolona 0 dobavice se ime profesora, da
														// smo 1 dobavice se prezime itd..
		switch (column) {
		case 0:
			return profesori.getIme();
		case 1:
			return profesori.getPrezime();
		case 2:
			String titula = new String();
			if (profesori.getTitula() == Titula.DR)
				titula = "DR";
			else
				titula = "PROF_DR";
			return titula;
		case 3:
			String zvanje = new String();
			if (profesori.getZvanjeProfesora() == Zvanje.DOCENT)
				zvanje = "DOCENT";
			else if (profesori.getZvanjeProfesora() == Zvanje.REDOVNI_PROFESOR)
				zvanje = "REDOVNI_PROFESOR";
			else
				zvanje = "VANREDNI_PROFESOR";
			return zvanje;
		default:
			return null;
		}
	}

	/**
	 * * Metoda koja kreira novi objekat klase Profesor, na osnovu prosleđenih
	 * parametara i ubacuje ga u bazu profesora.
	 * 
	 * @param ime               ime profesora
	 * @param prezime           prezime profesora
	 * @param datumRodjena      datum rođenja profesora
	 * @param brojTelefona      broj telefona profesora
	 * @param adresaStanovanja  adresa stanovanja profesora
	 * @param email             adresa elektronske pošte profesora
	 * @param adresaKancelarije adresa kancelarije profesora
	 * @param brLicneKarte      broj lične karte profesora, predstavlja jedinstveni
	 *                          identifikator za profesora
	 * @param titula            titula profesora
	 * @param zvanjeProfesora   zvanje profesora
	 */
	public void dodajProfesora(String ime, String prezime, LocalDate datumRodjena, String brojTelefona,
			String adresaStanovanja, String email, String adresaKancelarije, String brLicneKarte, String titula,
			String zvanjeProfesora) {
		Titula t;
		if (titula == "PROF_DR") {
			t = Titula.PROF_DR;
		} else {
			t = Titula.DR;
		}

		Zvanje z;
		if (zvanjeProfesora == "REDOVNI_PROFESOR") {
			z = Zvanje.REDOVNI_PROFESOR;
		} else if (zvanjeProfesora == "VANREDNI_PROFESOR") {
			z = Zvanje.VANREDNI_PROFESOR;
		} else {
			z = Zvanje.DOCENT;
		}
		this.profesori.add(new Profesor(ime, prezime, datumRodjena, brojTelefona, adresaStanovanja, email,
				adresaKancelarije, brLicneKarte, t, z, new ArrayList<Predmet>()));
	}

	/**
	 * * Metoda koja omogućuje izmenu nekog entiteta tipa Profesor iz baze
	 * profesora. Nove vrednosti se postavljaju na prosleđene vrednosti.
	 * 
	 * @param brLicne           početni broj lične karte profesora, služi nam za
	 *                          pronalaženje profesora čije podatke želimo da
	 *                          izmenimo,jer u slučaju ako želimo da izmenimo i broj
	 *                          lične karte, na osnovu novog prosleđenog broja lične
	 *                          karte nećemo moći da pronađemo profesora čije
	 *                          podatke želimo da izmenimo
	 * @param ime               novo ime profesora
	 * @param prezime           novo prezime profesora
	 * @param datumRodjena      novi datum rođenja profesora
	 * @param brojTelefona      novi broj telefona profesora
	 * @param adresaStanovanja  nova adresa stanovanja profesora
	 * @param email             nova adresa elektronske pošte profesora
	 * @param adresaKancelarije nova adresa kancelarije profesora
	 * @param brLicneKarte      novi broj lične karte profesora, predstavlja
	 *                          jedinstveni identifikator za profesora
	 * @param titula            nova titula profesora
	 * @param zvanjeProfesora   novo zvanje profesora
	 */
	public void IzmeniProfesora(String brLicne, String ime, String prezime, LocalDate datumRodjena, String brojTelefona,
			String adresaStanovanja, String email, String adresaKancelarije, String brLicneKarte, String titula,
			String zvanjeProfesora) {

		for (Profesor p : profesori) {
			if (p.getBrLicneKarte().equals(brLicne)) {
				p.setIme(ime);
				p.setPrezime(prezime);
				p.setDatumRodjena(datumRodjena);
				p.setBrLicneKarte(brLicneKarte);
				p.setAdresaStanovanja(adresaStanovanja);
				p.setEmail(email);
				p.setAdresaKancelarije(adresaKancelarije);
				p.setBrLicneKarte(brLicneKarte);
				p.setTitulaString(titula);
				p.setZvanjeString(zvanjeProfesora);

			}
		}
	}

	/**
	 * Metoda omogućuje brisanje predmeta sa prosleđenom šifrom kod svakog
	 * profesora.
	 * 
	 * @param sifra šira predmeta za brisanje
	 */
	public void izbrisiPredmet(String sifra) {
		for (Profesor p : profesori) {
			for (Predmet pp : p.getPredmeti()) {

				if (pp.getSifraPredmeta() == sifra)
					p.getPredmeti().remove(pp);
			}
		}
	}

	/**
	 * Metoda omogućuje brisanje određenog predmeta samo kod određenog profesora.
	 * 
	 * @param p1    profesor kom želimo da obrišemo premdet
	 * @param sifra šifra predmeta za brisanje
	 */
	public void izbrisiPredmet1(Profesor p1, String sifra) {

		System.out.println();
		for (Profesor p : profesori) {

			if (p1.getBrLicneKarte().equals(p.getBrLicneKarte())) {
				for (Predmet p11 : p.getPredmeti()) {
					if (p11.getSifraPredmeta().equals(sifra)) {
						System.out.println(p1.toString());
						System.out.println(p.toString());
						p.getPredmeti().remove(p11);
						break;
					}
				}
			}
		}

	}
}
