package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.TableModel;

import view.StudentiJTable;
import view.ToolBar;

public class BazaNepolozeni {


			// singlton
			// sablon koji nam omogucava da imamo jednu instancu necega, mi zelimo da imamo
			// jednu instancu predmeta, jer ne zelimo da neko drugi sa vise strana to menja
		
	private static BazaNepolozeni instance = null;

	public static BazaNepolozeni getInstance() {
			
			instance = new BazaNepolozeni();
		     return instance;
	      }
	
			private int inc = 0;
			private List<Predmet> nepolozeniPredmeti;
			private List<String> kolone;
			public BazaNepolozeni() {
                
				
	
				
				this.kolone = new ArrayList<String>();
				initnepolozeni();
				this.kolone.add("SIFRA PREDMETA");
				this.kolone.add("NAZIV");
				this.kolone.add("ESPB");
				this.kolone.add("GODINA IZVODJENJA");
				this.kolone.add("SEMESTAR IZVODJENJA");
				

			}
			private void initnepolozeni() {
				this.nepolozeniPredmeti = new ArrayList<Predmet>();
				int red = StudentiJTable.getInstance().getSelectedRow();
				Student d = BazaStudent.getInstance().getRow(red);
			
				nepolozeniPredmeti=d.getNepolozeniPredmeti();
				
				for(Predmet p : nepolozeniPredmeti)
				{
				     inc++;
				}
				
			}
            
			public long getInc() { //vraca broj predmeta
				return inc;
			}
            public String getIndex(String s)
            {
               return s;
            }
			public void setInc(int inc) {
				this.inc = inc;
			}

			public List<Predmet> getNepolozeniPredmeti() {
				return nepolozeniPredmeti;
			}

			public void setNepolozeniPredmet(List<Predmet> nepolozeniPredmeti) {
				this.nepolozeniPredmeti = nepolozeniPredmeti;
			}

			public List<String> getKoloneNepolozeni() {
				return kolone;
			}

			public int getColumnCount() {
				return 5;
			}

			public void setKolone(List<String> kolone) {
				this.kolone = kolone;
			}
      
		
			public static void setInstance(BazaNepolozeni instance) {
				BazaNepolozeni.instance = instance;
			}
			public String getColumnName(int index) {
				return this.kolone.get(index);
			}

			public Predmet getRow(int row) {
				return this.nepolozeniPredmeti.get(row);
			}
			public String getValueAt(int row, int column) {
				Predmet nepolozeniPredmeti = this.nepolozeniPredmeti.get(row); // dobavi mi ceo red
				switch (column) {
				case 0:
					return nepolozeniPredmeti.getSifraPredmeta();
				case 1:
					return nepolozeniPredmeti.getNazivPredmeta();
				case 2:
					return String.valueOf(nepolozeniPredmeti.getEspb());
				case 3:
					return String.valueOf(nepolozeniPredmeti.getGodinaStudija());
				case 4:
					String sem = new String();
					if (nepolozeniPredmeti.getSemestar() == Semestar.LETNJI)
						sem = "LETNJI";
					else
						sem = "ZIMSKI";
					return sem;
				default:
					return null;
				}
         }
			public void izbrisiPredmet(String sifraPredmeta,Student d) {
				
				nepolozeniPredmeti=d.getNepolozeniPredmeti();
				for(Predmet p : nepolozeniPredmeti)
				{
					if(p.getSifraPredmeta()==sifraPredmeta)
					{
						
						nepolozeniPredmeti.remove(p);
						break;
					}
				}
				
			}
			
			public void dodajPredmet(Predmet p) {
				this.nepolozeniPredmeti.add(p);
			}
	}
