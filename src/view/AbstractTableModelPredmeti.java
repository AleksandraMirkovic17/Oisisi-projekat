package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPredmet;

/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTable model, služi za prikaz
 * svih predmeta unetih u sistem. Omogućava nam da napravimo izgled/model naše
 * table.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class AbstractTableModelPredmeti extends AbstractTableModel {
	/**
	 * Konstruktor klase
	 */

	public AbstractTableModelPredmeti() {

	}

	/**
	 * metoda koja vraća broj konona
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPredmet.getInstance().getColumnCount();
	}
	/**
	 * metoda koja vraća nayiv određene kolone
	 */

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaPredmet.getInstance().getColumnName(arg0);
	}
	/**
	 * metoda koja vraća broj vrsta
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPredmet.getInstance().getPredmeti().size();

	}
	/**
	 * metoda koja vraća određeni predmet na preseku vrste i kolone
	 * @param arg0 broj vrste
	 * @param arg1 broj kolone
	 */

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaPredmet.getInstance().getValueAt(arg0, arg1);
	}

}