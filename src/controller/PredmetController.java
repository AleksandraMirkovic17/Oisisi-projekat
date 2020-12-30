package controller;

import IzgledProzora.IzmenaPredmetaDialog;
import IzgledProzora.IzmenaStudentaDialog;
import IzgledProzora.PredmetJTable;
import IzgledProzora.StudentiJTable;
import model.BazaPredmet;
import model.BazaStudent;
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
}
