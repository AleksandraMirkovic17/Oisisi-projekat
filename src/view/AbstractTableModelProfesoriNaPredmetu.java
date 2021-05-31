package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorPredajePredmet;
import model.BazaProfesoriNaPredmetu;

/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTableModel, služi za prikaz
 * svih profesora na određenom predmetu. Omogućava nam da napravimo izgled/model
 * naše table.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class AbstractTableModelProfesoriNaPredmetu extends AbstractTableModel {

	/**
	 * Konstruktor
	 */
	public AbstractTableModelProfesoriNaPredmetu() {

	}

	/**
	 * Metoda koja vraća broj kolona koje je potrebno da postavimo na našu tabelu.
	 */

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return BazaProfesoriNaPredmetu.getInstance().getColumnCount();
	}
	/**
	 * Metoda koja nam vraća naziv kolone.
	 */

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaProfesoriNaPredmetu.getInstance().getColumnName(arg0);
	}
	/**
	 * Metoda koja vraća broj potrebnih vrsta.
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesoriNaPredmetu.getInstance().getProfesori().size();

	}
	/**
	 * Metoda koja vraća šta se nalazi na preseku određene vrste i kolone.
	 * @param arg0 broj vrste
	 * @param arg1 broj kolone
	 */

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		// return BazaProfesoriNaPredmetu.getInstance().getValueAt(arg0, arg1);
		return null;
	}

}
