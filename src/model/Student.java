package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

enum StatusStudenta {
	B, S
};

public class Student implements Serializable{
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private String adresaStanovanja;
	private String kontaktTelefon;
	private String email;
	private String brIndeksa;
	private int godinaUpisa;
	private int trenutnaGodinaStudija;
	private StatusStudenta status;
	private double prosecnaOcena;
	private ArrayList<Ocena> polozeniPredmeti;
	private ArrayList<Predmet> nepolozeniPredmeti;

	// constructor using fields
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
		this.status = StatusStudenta.B;
		this.prosecnaOcena = 0.00;
		this.polozeniPredmeti = new ArrayList<Ocena>();
		this.nepolozeniPredmeti = new ArrayList<Predmet>();

	}
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

	public char getStatusChar() {
		if (this.status == StatusStudenta.B) {
			return 'B';
		} else {
			return 'S';
		}
	}

	public void setStatusChar(char s) {
		if (s == 'B') {
			this.status = StatusStudenta.B;
		} else {
			this.status = StatusStudenta.S;
		}
	}

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
	
	public int getUkupnoEspb() {
		int espb=0;
		if(polozeniPredmeti.size()>0) {
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
	
	@Override
	public String toString() {
		/*return "Student [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", email=" + email
				+ ", brIndeksa=" + brIndeksa + ", godinaUpisa=" + godinaUpisa + ", trenutnaGodinaStudija="
				+ trenutnaGodinaStudija + ", status=" + status + ", prosecnaOcena=" + prosecnaOcena
				+ ", polozeniPredmeti=" + polozeniPredmeti + ", nepolozeniPredmeti=" + nepolozeniPredmeti + "]";*/
		return " ";
	}


}