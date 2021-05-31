package view;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;

/**
 * 
 * Klasa koja pravi tabelu predmeta kod selektovanog profesora. Biće postavljena
 * na tab na dijalog za izmenu profesora (klasa IzmenaProfesorDialog). Nasleđuje
 * klasu JTable.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class ProfesorPredmetJTabel extends JTable {
	/**
	 * instanca klase
	 */
	private static ProfesorPredmetJTabel instance = null;

	/**
	 * Metoda koja omogućava postojanje samo jedne instance ove klase.
	 * 
	 * @return povratna vrednost je instanca ove klase
	 */
	public static ProfesorPredmetJTabel getInstance() {
		if (instance == null)
			instance = new ProfesorPredmetJTabel();

		return instance;
	}

	/**
	 * konstruktor klase
	 */
	private ProfesorPredmetJTabel() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelProfPredmet());

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
	 * Metoda koja omogućava ažuriranje prikaza tabele predmeta na kojima predaje
	 * profesornakon što je došlo do nekih izmena.
	 */
	public void azurirajPrikaz() {
		AbstractTableModelProfPredmet model = (AbstractTableModelProfPredmet) this.getModel();
		model.fireTableDataChanged(); // obavestavamo da je doslo do promene podatak i da model treba da se azurira
		validate(); // ugradjena metoda
	}

}
