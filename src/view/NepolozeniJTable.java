
package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * Klasa koja pravi tabelu nepoloženih predmeta kod studenata. Biće postavljena
 * kao tab u klasi IzmenaStudenta. Nasleđuje klasu JTable.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class NepolozeniJTable extends JTable {
	/**
	 * instanca klase
	 */
	private static NepolozeniJTable instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jedne instance ove klase.
	 * 
	 * @return povratna vrednost je instanca ove klase
	 */
	public static NepolozeniJTable getInstance() {
		if (instance == null)
			instance = new NepolozeniJTable();

		return instance;
	}

	/**
	 * Konstruktor klase
	 */
	private NepolozeniJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelNepolozeni());

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
	 * Metoda koja omogućava ažuriranje prikaza tabele nepoloženih predmeta nakon što je došlo do nekih izmena.
	 */
	public void azurirajPrikaz() {
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) this.getModel();
		model.fireTableDataChanged(); // obavestavamo da je doslo do promene podatak i da model treba da se azurira
		validate(); // ugradjena metoda
	}

}
