package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BazaPredmet {

	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	private static BazaPredmet instance = null;

	public static BazaPredmet getInstance() {
		if (instance == null)
			instance = new BazaPredmet();
		return instance;

	}

	private int brojac = 0;

	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaPredmet() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV");
		this.kolone.add("ESPB");
		this.kolone.add("GODINA IZVODJENJA");
		this.kolone.add("SEMESTAR IZVODJENJA");
	}

	private void initPredmet() {

		this.predmeti = new ArrayList<Predmet>();
		Semestar s = Semestar.LETNJI;
		predmeti.add(new Predmet("EE123", "Verovatnoca", 9, 6, s));
		brojac++;
	}

	public int getBrojac() {
		return brojac;
	}

	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmet(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public int getColumnCount() {
		return 5;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public static void setInstance(BazaPredmet instance) {
		BazaPredmet.instance = instance;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int row) {
		return this.predmeti.get(row);
	}

		public String getValueAt(int row, int column) {
			    Predmet predmeti = this.predmeti.get(row); //dobavi mi ceo red
				switch (column) {
				case 0:
					return predmeti.getSifraPredmeta();
				case 1:
					return predmeti.getNazivPredmeta();
				case 2:
					return String.valueOf(predmeti.getEspb());
				case 3:
					return String.valueOf(predmeti.getGodinaStudija());
				case 4:
					String sem = new String();
					if(predmeti.getSemestar() == Semestar.LETNJI) sem="LETNJI"; else sem= "ZIMSKI";
					return sem;
				default:
					return null;
				}
			}

	public void dodajPredmet(String sifra, String naziv, int godina, int espb, char semestarc) {
		Semestar semestar;
		if (semestarc == 'L')
			semestar = Semestar.LETNJI;
		else
			semestar = Semestar.ZIMSKI;

		this.predmeti.add(new Predmet(sifra, naziv, espb, godina, semestar));
		brojac++;
	}
	
	public void izmeniPredmet(String pocetnaSifra, String sifra, String naziv, int godina, int espb, char semestarc) {
		Semestar semestar;
		if (semestarc == 'L')
			semestar = Semestar.LETNJI;
		else
			semestar = Semestar.ZIMSKI;
		
		for(Predmet p : predmeti) {
			if(pocetnaSifra.equals(p.getSifraPredmeta())){
				p.setSifraPredmeta(sifra);
				p.setNazivPredmeta(naziv);
				p.setGodinaStudija(godina);
				p.setEspb(espb);
				p.setSemestar(semestar);
			}
		}
	
	}


}
