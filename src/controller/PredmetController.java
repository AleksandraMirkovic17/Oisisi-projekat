package controller;

import IzgledProzora.PredmetJTable;
import IzgledProzora.ProfesoriJTable;
import model.BazaPredmet;
import model.Predmet;

public class PredmetController {

	private static PredmetController instance = null;

	public static PredmetController getInstance() {
		if (instance == null) {
			instance = new PredmetController();
		}
		return instance;
	}

	private PredmetController() {
	}

	public void dodajPredmet() {
		// azuriranje prikaza
		PredmetJTable.getInstance().refresTabelu();
	}
	public void izbrisiPredmet(int red) {
		 Predmet p=BazaPredmet.getInstance().getRow(red);//znamo koji je to predmet kog mi zelimo da izbrisemo
		 BazaPredmet.getInstance().izbrisiPredmet(p.getSifraPredmeta()); //saljemo sifru predmeta jer se oni po tome identifikuju, i u ovoj liniji vrsimo brisanje predmeta
		 PredmetJTable.getInstance().refresTabelu();//ayuriranje tabele	
 }
}
