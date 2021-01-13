package controller;

import model.BazaPredmet;
import model.BazaProfesor;
import model.BazaStudent;
import model.Predmet;
import model.Profesor;
import view.IzmenaPredmetaDialog;
import view.PredmetJTable;
import view.ProfesoriJTable;

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
	
	public void izmeniPredmet(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Predmet predmet = BazaPredmet.getInstance().getRow(rowSelectedIndex);
		IzmenaPredmetaDialog dialog = new IzmenaPredmetaDialog(predmet);
		dialog.setVisible(true);
		// azuriranje prikaza
		PredmetJTable.getInstance().refresTabelu();
	}
	
	public void izbrisiPredmet(int red) {
		 Predmet p=BazaPredmet.getInstance().getRow(red);//znamo koji je to predmet kog mi zelimo da izbrisemo
		 BazaPredmet.getInstance().izbrisiPredmet(p.getSifraPredmeta());//saljemo sifru predmeta jer se oni po tome identifikuju, i u ovoj liniji vrsimo brisanje predmeta
		 BazaProfesor.getInstance().izbrisiPredmet(p.getSifraPredmeta());
		 BazaStudent.getInstance().izbrisiPredmet(p.getSifraPredmeta());
		 PredmetJTable.getInstance().refresTabelu();//azuriranje tabele	

 }
	public void ukloniProfesoraSaPredmetaPrekoProfesora(Profesor profesor, Predmet predmet) {
		for(int i=0; i<BazaProfesor.getInstance().getProfesori().size(); i++) {
			if(BazaProfesor.getInstance().getProfesori().get(i).getBrLicneKarte().equals(profesor.getBrLicneKarte())) {
				for(int j=0; j<BazaPredmet.getInstance().getPredmeti().size(); j++) {
					if(BazaPredmet.getInstance().getPredmeti().get(j).getSifraPredmeta().equals(predmet.getSifraPredmeta())) {
						BazaPredmet.getInstance().getPredmeti().get(j).getProfesori().remove(BazaProfesor.getInstance().getProfesori().get(i));
					}
				}
			}
		
		}
	}

}
