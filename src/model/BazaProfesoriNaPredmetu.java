package model;

import java.util.ArrayList;
import java.util.List;

import view.PredmetJTable;

public class BazaProfesoriNaPredmetu {
	// singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
	// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
	private static BazaProfesoriNaPredmetu instance = null;

	private List<Profesor> profesori;

	public static BazaProfesoriNaPredmetu getInstance() {
		instance = new BazaProfesoriNaPredmetu();
		return instance;

	}

	private int brojac = 0;

	private List<String> kolone;

	private BazaProfesoriNaPredmetu() {

		this.kolone = new ArrayList<String>();
		initProfesor();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
	}

	private void initProfesor() {

		this.profesori = new ArrayList<Profesor>();
		int red = PredmetJTable.getInstance().getSelectedRow();
		Predmet p = BazaPredmet.getInstance().getRow(red);
		if (p.getProfesori() != null) {
			this.profesori = p.getProfesori();
		} else {
			p.setProfesori(new ArrayList<Profesor>());
			this.profesori = p.getProfesori();
		}
		brojac = this.profesori.size();
	}

	public List<Profesor> getProfesori() {
		return profesori;
	}

	public void setProfesori(List<Profesor> profesori) {
		this.profesori = profesori;
	}

	public Profesor getPoslednjiProfesor() {
		if(this.profesori.size()== 0)
	      {
			System.out.println(this.profesori.size());
		return null;
	      }
		Profesor p = this.profesori.get(this.profesori.size() - 1);
		return p;
	}

	public int getBrojac() {
		return brojac;
	}

	public void setBrojac(int brojac) {
		this.brojac = brojac;
	}

	public List<String> getKolone() {
		return kolone;
	}

	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}

	public void dodajProfesora(Profesor p) {
		this.profesori.add(p);
		brojac++;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Profesor getRow(int row) {
		return this.profesori.get(row);
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 2;
	}
}
