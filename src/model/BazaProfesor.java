 package model;

 import java.util.*;


public class BazaProfesor {

	//singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo jednu instancu profesora, jer ne zelimo da neko drugi sa vise strana to menja 
	private static BazaProfesor instance =null;
	
	public static BazaProfesor getInstance() {
		if(instance==null)
			instance=new BazaProfesor();
		return instance;
		
	}
	
	private long  brojac=0;
	
	private List<Profesor> profesori;
	private List<String> kolone;
	
	
	private BazaProfesor()
	{
	
		this.kolone = new ArrayList<String>();
		initProfesor();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
	}

	private void initProfesor() {
		this.profesori = new ArrayList<Profesor>();
		profesori.add(new Profesor("Petar","Petrovic","Doktor","Vandredni Profesor"));
		profesori.add(new Profesor("Petar","Nestorovic","Doktor Nauka","Profesor"));
		
	}
	public long getBrojac() {
		return brojac;
	}


	public void setBrojac(long brojac) {
		this.brojac = brojac;
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

	public int getColumnCount() {
		return 4;
	}
	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}


	public static void setInstance(BazaProfesor instance) {
		BazaProfesor.instance = instance;
	}
	public String getColumnName(int index)
	{
		return this.kolone.get(index);
	}
	
	public Profesor getRow(int  row)
	{
		return this.profesori.get(row);
	}
	
	public String getValueAt(int row, int column) {
		    Profesor profesori = this.profesori.get(row); //dobavi mi ceo red
			switch (column) {
			case 0:
				return profesori.getIme();
			case 1:
				return profesori.getPrezime();
			case 2:
				return profesori.getTitula();
			case 3:
				return profesori.getZvanjeProfesora();
			default:
				return null;
			}
		}
	}

