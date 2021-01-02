package model;

import java.time.LocalDate;
import java.util.ArrayList;

enum statusStudenta {
	B, S
};

public class Student {
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private statusStudenta status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniPredmeti;
	private ArrayList<Predmet> nepolozeniPredmeti;

	// constructor using fields
		public Student1(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
				String email, String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija, statusStudenta status,
				double prosecnaOcena, ArrayList<Ocena> polozeniPredmeti,) {
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
			this.prosecnaOcena = prosecnaOcena;
			this.polozeniPredmeti = polozeniPredmeti;
		
		}
	// constructor using fields
	public Student(String prezime, String ime, LocalDate datumRodjenja, String adresaStanovanja, String kontaktTelefon,
			String email, String brIndeksa, int godinaUpisa, int trenutnaGodinaStudija, statusStudenta status,
			double prosecnaOcena, ArrayList<Ocena> polozeniPredmeti) {
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
		this.prosecnaOcena = prosecnaOcena;
		this.polozeniPredmeti = polozeniPredmeti;
	
	}

	// constructor from superclass
	public Student() {
		super();
		this.prezime = new String("Prezime");
		this.ime = "Ime";
		this.datumRodjenja = LocalDate.of(1990, 1, 1);
		this.adresaStanovanja = "Adresa stanovanja nije uneta";
		this.brIndeksa = "Broj indeksa nije unet";
		this.godinaUpisa = 0;
		this.trenutnaGodinaStudija = 0;
		this.status = statusStudenta.B;
		this.prosecnaOcena = 6.00;
		this.polozeniPredmeti = new ArrayList<Ocena>();

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

	public statusStudenta getStatus() {
		return status;
	}

	public void setStatus(statusStudenta status) {
		this.status = status;
	}

	public char getStatusChar() {
		if (this.status == statusStudenta.B) {
			return 'B';
		} else {
			return 'S';
		}
	}

	public void setStatusChar(char s) {
		if (s == 'B') {
			this.status = statusStudenta.B;
		} else {
			this.status = statusStudenta.S;
		}
	}

	public double getProsecnaOcena() {
		return prosecnaOcena;
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

	@Override
	public String toString() {
		return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", email=" + email
				+ ", brIndeksa=" + brIndeksa + ", godinaUpisa=" + godinaUpisa + ", trenutnaGodinaStudija="
				+ trenutnaGodinaStudija + ", status=" + status + ", prosecnaOcena=" + prosecnaOcena + "]";
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

}
