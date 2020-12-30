package controller;

import IzgledProzora.PredmetJTable;

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
}
