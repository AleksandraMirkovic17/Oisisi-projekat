package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

/**
 * 
 * Klasa koja pravi tabelu profesora. Biće postavljena na tab na glavni prozor
 * (klasa GlavniProzor). Nasleđuje klasu JTable.
 * 
 * @author Aleksandra Mirković
 *
 */

public class ProfesoriJTable extends JTable {
	/**
	 * instanca klase
	 */
	private static ProfesoriJTable instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jedne instance ove klase.
	 * 
	 * @return povratna vrednost je instanca ove klase
	 */
	static public ProfesoriJTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriJTable();
		}
		return instance;
	}

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = -7475213618819842792L;

	// vrsimo neku konfiguraciju
	/**
	 * konstruktor klase
	 */
	public ProfesoriJTable() {

		this.setRowSelectionAllowed(true); // selektovanje redova
		this.setColumnSelectionAllowed(true); // selektovanje kolona
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // da mozemo samo jednu koloonu da selektujemo
		this.setModel(new AbstractTableModelProfesori());

	}

	/**
	 * Metoda koja omogućuje da se nakon selektovanja nekog reda taj red promeni
	 * boju
	 */
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);

		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}

	/**
	 * Metoda koja omogućava ažuriranje prikaza tabele profesora nakon što je došlo
	 * do nekih izmena.
	 */
	public void azurirajPrikaz() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) this.getModel();
		model.fireTableDataChanged(); // obavestavamo da je doslo do promene podatak i da model treba da se azurira
		validate(); // ugradjena metoda
	}

}
