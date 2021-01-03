package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import view.StudentiJTable;

public class BazaPolozeni {

	private static BazaPolozeni instance = null;

	public static BazaPolozeni getInstance() {
		if (instance == null)
			instance = new BazaPolozeni();
		return instance;

	}

	private int inc = 0;

	private List<Ocena> polozeniPredmeti;
	private List<String> kolone;

	private BazaPolozeni() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("Sifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Ocena");
		this.kolone.add("Datum");
	}

	private void initPredmet() {

		this.polozeniPredmeti = new ArrayList<Ocena>();
		int red = StudentiJTable.getInstance().getSelectedRow();
		Student s = BazaStudent.getInstance().getRow(red);
		polozeniPredmeti = s.getPolozeniPredmeti();
		for (Ocena o : polozeniPredmeti) {
			inc++;
		}
	}

	public long getInc() { // vraca broj predmeta - ocena
		return inc;
	}

	public void setInc(int inc) {
		this.inc = inc;
	}

	public List<Ocena> getPolozeniPredmeti() {
		return polozeniPredmeti;
	}

	public void setPolozeniPredmet(List<Ocena> polozeniPredmeti) {
		this.polozeniPredmeti = polozeniPredmeti;
	}

	public List<String> getKolonePolozeni() {
		return kolone;
	}

	public int getColumnCount() {
		return 5;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Ocena getRow(int row) {
		return this.polozeniPredmeti.get(row);
	}

	public String getValueAt(int row, int column) {
		Ocena polozeniPredmeti = this.polozeniPredmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return polozeniPredmeti.getPredmet().getSifraPredmeta();
		case 1:
			return polozeniPredmeti.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(polozeniPredmeti.getPredmet().getEspb());
		case 3:
			return String.valueOf(polozeniPredmeti.getBrojcanaVrednost());
		case 4:
			LocalDate datumPolaganja = polozeniPredmeti.getDatumPolaganja();
			String datum = String.valueOf(datumPolaganja.getDayOfMonth()) + "."
					+ String.valueOf(datumPolaganja.getMonthValue()) + "." + String.valueOf(datumPolaganja.getYear())
					+ ".";
			return datum;
		default:
			return null;
		}
	}
	public void dodajPredmet(Student s, Predmet p, int ocena, LocalDate datum) {
		this.polozeniPredmeti.add(new Ocena(s,p,ocena,datum));
		inc++;

	}

}
