package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPolozeni;

/**
 * Apstraktna klasa za prikaz položenih predmeta kod studenta.
 * 
 * @author Aleksandra Mirković
 *
 */

public class AbstractTableModelPolozeni extends AbstractTableModel {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Konstruktor klase
	 */
	public AbstractTableModelPolozeni() {

	}
	
	/**
	 * Vraća broj kolona
	 */
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getColumnCount();
	}
	
	/**
	 * Vraća naziv kolone
	 */
	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getColumnName(arg0);
	}
	
	/**
	 * Vraća broj vrsta
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getPolozeniPredmeti().size();

	}
	
	/**
	 * Vraća predmet na preseku kolone i vrste.
	 * @param arg0 broj vrste
	 * @param arg1 broj kolone
	 */

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getValueAt(arg0, arg1);
	}
}
