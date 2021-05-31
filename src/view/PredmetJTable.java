package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * Klasa koja pravi tabelu predmeta. Biće postavljena na tab na glavni prozor
 * (klasa GlavniProzor). Nasleđuje klasu JTable.
 * 
 * @author Aleksandra Mirković
 *
 */

public class PredmetJTable extends JTable {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 199113098313326605L;

	/**
	 * instanca klase
	 */
	private static PredmetJTable instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jedne instance ove klase.
	 * 
	 * @return povratna vrednost je instanca ove klase
	 */
	public static PredmetJTable getInstance() {
		if (instance == null) {
			instance = new PredmetJTable();
		}
		return instance;
	}

	/**
	 * Konstruktor klase
	 */
	private PredmetJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());

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
 * Metoda koja omogućava ažuriranje prikaza tabele predmeta nakon što je došlo do nekih izmena.
 */
	public void refresTabelu() {
		AbstractTableModelPredmeti model = (AbstractTableModelPredmeti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}

}
