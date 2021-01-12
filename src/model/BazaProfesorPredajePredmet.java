package model;

import java.util.ArrayList;
import java.util.List;

import view.ProfesoriJTable;

public class BazaProfesorPredajePredmet {
	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	private static BazaProfesorPredajePredmet instance = null;

	public static BazaProfesorPredajePredmet getInstance() {
		instance = new BazaProfesorPredajePredmet();
		return instance;

	}

	private int brojac = 0;

	private List<Predmet> predmeti;
	private List<String> kolone;

	private BazaProfesorPredajePredmet() {

		this.kolone = new ArrayList<String>();
		initPredmet();
		this.kolone.add("SIFRA PREDMETA");
		this.kolone.add("NAZIV");
		this.kolone.add("GODINA STUDIJA");
		this.kolone.add("SEMESTAR");
	}

	private void initPredmet() {

		this.predmeti = new ArrayList<Predmet>();
		int red = ProfesoriJTable.getInstance().getSelectedRow();
		Profesor p = BazaProfesor.getInstance().getRow(red);
		this.predmeti = p.getPredmeti();
		// **** dodati ove da ti proverava da li uopste postoje predmeti koje drzi i
		// izmeniti konstruktor tako da ne postavljas novog profesora, sa null listom
		// predmeta vec sa new List! (ovo radi u klasi dodaj Profesora)
		for (Predmet pp : predmeti) {
			brojac++;
		}
	}

	public long getBrojac() { // vraca broj predmeta
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
		return 4;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public static void setInstance(BazaProfesorPredajePredmet instance) {
		BazaProfesorPredajePredmet.instance = instance;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int row) {
		return this.predmeti.get(row);
	}

	public String getValueAt(int row, int column) {
		Predmet predmeti = this.predmeti.get(row); // dobavi mi ceo red
		switch (column) {
		case 0:
			return predmeti.getSifraPredmeta();
		case 1:
			return predmeti.getNazivPredmeta();
		case 2:
			return String.valueOf(predmeti.getGodinaStudija());
		case 3:
			String sem = new String();
			if (predmeti.getSemestar() == Semestar.LETNJI)
				sem = "LETNJI";
			else
				sem = "ZIMSKI";
			return sem;
		default:
			return null;
		}
	}
}
