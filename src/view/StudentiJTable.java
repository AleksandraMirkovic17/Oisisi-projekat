package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * Klasa koja pravi tabelu atudenata. Biće postavljena na tab na glavni prozor
 * (klasa GlavniProzor). Nasleđuje klasu JTable.
 * 
 * @author Aleksandra Mirković
 *
 */
public class StudentiJTable extends JTable {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * instanca klase
	 */
	private static StudentiJTable instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jedne instance ove klase.
	 * 
	 * @return povratna vrednost je instanca ove klase
	 */
	static public StudentiJTable getInstance() {
		if (instance == null) {
			instance = new StudentiJTable();
		}
		return instance;
	}

	/**
	 * konstruktor klase
	 */
	private StudentiJTable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelStudenti());

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
	 * Metoda koja omogućava ažuriranje prikaza tabele studenata nakon što je došlo
	 * do nekih izmena.
	 */
	public void refresTabelu() {
		AbstractTableModelStudenti model = (AbstractTableModelStudenti) this.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
