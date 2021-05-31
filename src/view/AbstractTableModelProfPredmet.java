package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorPredajePredmet;

/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTable model, služi za
 * modelovanje prikaza svih predmeta koje predaje profesor. Omogućava nam da
 * napravimo izgled/model naše table.
 * 
 * @author PC
 *
 */

public class AbstractTableModelProfPredmet extends AbstractTableModel {
	/**
	 * Konstruktor klase
	 */

	public AbstractTableModelProfPredmet() {

	}

	/**
	 * Vraća broj kolona koje je neophodno izmodelovati.
	 */

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return BazaProfesorPredajePredmet.getInstance().getColumnCount();
	}
	/**
	 * Vraća naziv kolone koju ćemo izmodelovati
	 */

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getColumnName(arg0);
	}

	/**
	 * Vraća broj vrsta koje je potrebno izmodelovati.
	 */
	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getPredmeti().size();

	}
	/**
	 * Vraća entitet koji se nalazi na preseku određe vrste i kolone.
	 * @param arg0 broj vrste
	 * @param arg1 broj kolone
	 */

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getValueAt(arg0, arg1);
	}

}
