package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Enumeracija u kojoj su nabrojani načini finansiranja jednog studenta
 * 
 * @author Andrea Sabo Cibolja
 *
 */
enum StatusStudenta {
	/**
	 * budžetski
	 */
	B,
	/**
	 * samofinansirajući
	 */
	S
};

/**
 * Klasa koja modeluje entitet student u informacionom sistemu.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class Student implements Serializable {
	/**
	 * prezime student
	 */
	private String prezime;
	/**
	 * ime studenta
	 */
	private String ime;
	/**
	 * datum rođenja studenta
	 */
	private LocalDate datumRodjenja;
	/**
	 * adresa stanovanja studenta
	 */
	private String adresaStanovanja;
	/**
	 * kontakt telefon studenta
	 */
	private String kontaktTelefon;
	/**
	 * adresa elektornske pošte studenta
	 */
	private String email;
	/**
	 * broj indeksa studenta, jedinstveno određuje svakog studenta u sistemu
	 */
	private String brIndeksa;
	/**
	 * godina upisa studenta na fakultet
	 */
	private int godinaUpisa;
	/**
	 * trenutna godina studija
	 */
	private int trenutnaGodinaStudija;
	/**
	 * način finansiranja studija
	 */
	private StatusStudenta status;
	/**
	 * prosecna ocena studenta
	 */
	private double prosecnaOcena;
	/**
	 * lista položenih predmeta studenta, tj. lista ocena
	 */
	private ArrayList<Ocena> polozeniPredmeti;
	/**
	 * lista nepoloženih predmeta studenta
	 */
	private ArrayList<Predmet> nepolozeniPredmeti;

	/**
	 * Konstruktor sa parametrima, kreira objekat tipa student i inicijalizuje polja
	 * na prosleđene vrednosti.
	 * 
	 * @param prezime               - prezime studenta
	 * @param ime                   - ime studenta
	 * @param datumRodjenja         - datum rođenja
	 * @param adresaStanovanja      - adresa stanovanja
	 * @param kontaktTelefon        - broj telefona
	 * @param email                 - adresa elekstronske pošte
	 * @param brIndeksa             - broj indeksa
	 * @param godinaUpisa           - godina upisa
	 * @param trenutnaGodinaStudija - trenutna godina studija
	 * @param status                - način finansiranja
	 * @param prosecnaOcena         - prosečna ocena
	 * @param polozeniPredmeti      - lista položenih predmeta
	 * @param nepolozeniPredmeti    -lista nepoloženih predmeta
	 */
	public Student(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija, StatusStudenta status,
			double prosecnaOcena, ArrayList<Ocena> polozeniPredmeti, ArrayList<Predmet> nepolozeniPredmeti) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.email = email;
		this.brIndeksa = brIndeksa;
		this.godinaUpisa = godinaUpisa;
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
		this.status = status;
		this.polozeniPredmeti = polozeniPredmeti;
		this.nepolozeniPredmeti = nepolozeniPredmeti;
		this.prosecnaOcena = getProsecnaOcena();
	}

	/**
	 * Prazan konstruktor. Inicijalizuje polja klase na neke predefinisane
	 * vrednosti.
	 */
	public Student() {
		super();
		this.prezime = new String("Prezime");
		this.ime = "Ime";
		this.datumRodjenja = LocalDate.of(1990, 1, 1);
		this.adresaStanovanja = "Adresa stanovanja nije uneta";
		this.brIndeksa = "Broj indeksa nije unet";
		this.godinaUpisa = 0;
		this.trenutnaGodinaStudija = 0;
		this.status = StatusStudenta.B;
		this.prosecnaOcena = 0.00;
		this.polozeniPredmeti = new ArrayList<Ocena>();
		this.nepolozeniPredmeti = new ArrayList<Predmet>();

	}

	/**
	 * Konstruktor kopije. Vrednosti polja novog objekta postavlja na vrednosti
	 * polja objekta koji mu se prosleđuje i kreira novi objekat tipa Student.
	 * 
	 * @param s objekat tipa Student čiju kopiju pravimo
	 */
	public Student(Student s) {
		super();
		this.prezime = s.getPrezime();
		this.ime = s.getIme();
		this.datumRodjenja = s.getDatumRodjenja();
		this.adresaStanovanja = s.getAdresaStanovanja();
		this.brIndeksa = s.getBrIndeksa();
		this.godinaUpisa = s.getGodinaUpisa();
		this.trenutnaGodinaStudija = s.getTrenutnaGodinaStudija();
		this.status = s.getStatus();
		this.polozeniPredmeti = s.getPolozeniPredmeti();
		this.nepolozeniPredmeti = s.getNepolozeniPredmeti();
		this.prosecnaOcena = s.getProsecnaOcena();
	}

	// getters and setters
	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public String getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(String adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBrIndeksa() {
		return brIndeksa;
	}

	public void setBrIndeksa(String brIndeksa) {
		this.brIndeksa = brIndeksa;
	}

	public int getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(int godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
	}

	public int getTrenutnaGodinaStudija() {
		return trenutnaGodinaStudija;
	}

	public void setTrenutnaGodinaStudija(int trenutnaGodinaStudija) {
		this.trenutnaGodinaStudija = trenutnaGodinaStudija;
	}

	public StatusStudenta getStatus() {
		return status;
	}

	public void setStatus(StatusStudenta status) {
		this.status = status;
	}

	/**
	 * @return status studenta u obliku tipa ,,char"
	 */
	public char getStatusChar() {
		if (this.status == StatusStudenta.B) {
			return 'B';
		} else {
			return 'S';
		}
	}

	/**
	 * Na osnovu prosleđenog znaka metoda postavlja status studenta.
	 * 
	 * @param s status studenta u obliku ,,char"
	 */
	public void setStatusChar(char s) {
		if (s == 'B') {
			this.status = StatusStudenta.B;
		} else {
			this.status = StatusStudenta.S;
		}
	}

	/**
	 * Prosečnu oceu dobavlja tako što sračuna prosek iz liste položenih predmeta
	 * 
	 * @return povratna vrednost je prosečna ocena studenta
	 */
	public double getProsecnaOcena() {
		double po = 0.0;
		double ukupno = 0.0;
		if (polozeniPredmeti.size() > 0) {
			for (int i = 0; i < polozeniPredmeti.size(); i++) {
				ukupno += polozeniPredmeti.get(i).getBrojcanaVrednost();
			}
			po = ukupno / (Double.parseDouble(String.valueOf(polozeniPredmeti.size())));
		}
		return po;

	}

	/**
	 * Metoda koja računa ukupan broj ESPB bodova, tako što sabira ESPB bodove za
	 * svaki od položenih predmeta.
	 * 
	 * @return povratna vrednost je ukupno ostvareni broj ESPB bodova studenta
	 */
	public int getUkupnoEspb() {
		int espb = 0;
		if (polozeniPredmeti.size() > 0) {
			for (int i = 0; i < polozeniPredmeti.size(); i++) {
				espb += polozeniPredmeti.get(i).getPredmet().getEspb();
			}
		}
		return espb;
	}

	public void setProsecnaOcena(double prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmeti(ArrayList<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	/**
	 * Vraća ovaj objekat u obliku stringa
	 */
	@Override
	public String toString() {
		/*
		 * return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" +
		 * datumRodjenja + ", adresaStanovanja=" + adresaStanovanja +
		 * ", kontaktTelefon=" + kontaktTelefon + ", email=" + email + ", brIndeksa=" +
		 * brIndeksa + ", godinaUpisa=" + godinaUpisa + ", trenutnaGodinaStudija=" +
		 * trenutnaGodinaStudija + ", status=" + status + ", prosecnaOcena=" +
		 * prosecnaOcena + ", polozeniPredmeti=" + polozeniPredmeti +
		 * ", nepolozeniPredmeti=" + nepolozeniPredmeti + "]";
		 */
		return " ";
	}

}