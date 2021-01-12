package model;

 import java.time.LocalDate;
import java.util.*;


public class BazaProfesor {

	//singlton
	// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo jednu instancu profesora, jer ne zelimo da neko drugi sa vise strana to menja,zelimo da kontrolisemo podatke 
	private static BazaProfesor instance =null;
	
	public static BazaProfesor getInstance() {
		if(instance==null)
			instance=new BazaProfesor();
		return instance;
		
	}
	
	private long  broj_profesora=0;
	
	private List<Profesor> profesori;//konkretni objekat
	private List<String> kolone; //predstavlja nazive kolone
	
	
	private BazaProfesor()
	{
	
		this.kolone = new ArrayList<String>(); //kreiramo novu listu za kolonu
		initProfesor();
		this.kolone.add("IME");
		this.kolone.add("PREZIME");
		this.kolone.add("TITULA");
		this.kolone.add("ZVANJE");
	}

	private void initProfesor() {
		this.profesori = new ArrayList<Profesor>(); //postavljamo da je prazna lista
		//kreiramo novog profesora koja je stavljena u listu
		/*ArrayList<Predmet> predajePredmet=new ArrayList<Predmet>();
		Predmet p1=new Predmet("EE123","Verovatnoca",Semestar.LETNJI,3,new ArrayList<Profesor>(),9);
		Predmet p2=new Predmet("E12RR3","Analiza Matematicka",Semestar.LETNJI,1,new ArrayList<Profesor>(),9);
		predajePredmet.add(p1);
		predajePredmet.add(p2);
		profesori.add(new Profesor("Petar","Petrovic",LocalDate.of(1999, 5, 25),"069877633","Tolstojeva 10","petarpetrovic@gmail.com","Radnicka 17","199928277745","Prof. dr","Redovni profesor",predajePredmet));
		incBroj_Profesora(); //povecavamo broj profesora
		profesori.add(new Profesor("Nikola","Nikolic",LocalDate.of(1980, 4, 17),"069667633","Tolstojeva 1","nikolanikolic@gmail.com","Radnicka 17","1980777166111","MSc","Saradnik u nastavi",new ArrayList<Predmet>()));
		incBroj_Profesora();*/
		
		
	}
	public long incBroj_Profesora() { //kada pronadjemo nekog profesora treba da broj_profesora povecamo
		return broj_profesora++;
	}
   public long getbroj_profesora() 
   {
	   return broj_profesora;
	   
   }
   

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

	public int getColumnCount() {
		return 4;
	}
	public void setKolone(List<String> kolone) {
		this.kolone = kolone;
	}


	public static void setInstance(BazaProfesor instance) {
		BazaProfesor.instance = instance;
	}
	public String getColumnName(int index) //vrati mi naziv kolone
	{
		return this.kolone.get(index); //iz liste kolone vrati mi kolonu sa tim indexom koju sam prosledila
	}
	
	public Profesor getRow(int  row) //dobavljamo ceo red, i po indexu dobavi mi taj red tj, tog profesora, dobijamo jednog celog profesora
	{
		return this.profesori.get(row);
	}
	
	public String getValueAt(int row, int column) {
		    Profesor profesori = this.profesori.get(row); //dobavi mi ceo red i smesti mi u objekat profesori. i ukoliko smo postavili da je kolona 0 dobavice se ime profesora, da smo 1 dobavice se prezime itd..
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
	public void dodajProfesora(String ime, String prezime, LocalDate datumRodjena, String brojTelefona, String adresaStanovanja,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanjeProfesora) {
		
		this.profesori.add(new Profesor(ime,prezime,datumRodjena,brojTelefona,adresaStanovanja,email,adresaKancelarije,brLicneKarte,titula,zvanjeProfesora,new ArrayList<Predmet>()));
	}

	public void IzmeniProfesora(String ime, String prezime, LocalDate datumRodjena, String brojTelefona, String adresaStanovanja,
			String email, String adresaKancelarije, String brLicneKarte, String titula, String zvanjeProfesora) {
		
		for(Profesor p: profesori)
		{
			if(p.getBrLicneKarte().equals(brLicneKarte))
                {
                	p.setIme(ime);
                	p.setPrezime(prezime);
                	p.setDatumRodjena(datumRodjena);
                	p.setBrLicneKarte(brLicneKarte);
                	p.setAdresaStanovanja(adresaStanovanja);
                	p.setEmail(email);
                	p.setAdresaKancelarije(adresaKancelarije);
                	p.setBrLicneKarte(brLicneKarte);
                	p.setTitula(titula);
                	p.setZvanjeProfesora(zvanjeProfesora);
	 
               }
		}
	}
	
	public void izbrisiPredmet(String sifra)
	{
		for(Profesor p : profesori)
		{
			for(Predmet pp : p.getPredmeti()) {
				
				if(pp.getSifraPredmeta()==sifra)
					p.getPredmeti().remove(pp);
			}
		}
	}
}
