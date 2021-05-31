package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;
import model.BazaStudent;
/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTable model, služi za prikaz
 * svih studenata unetih u sistem. Omogućava nam da napravimo izgled/model naše
 * table.
 * @author PC
 *
 */

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Konstruktor
	 */

	public AbstractTableModelStudenti() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Vraća broj potrebnih vrsta
	 */

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getStudenti().size();
	}
	/**
	 * Vraća broj potrebnih kolona
	 */

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getColumnCount();
	}
	/**
	 * Vraća entitet koji se upisuje na preseku određene vrste i kolone.
	 * @param rowIndex vrsta
	 * @param columnIndex kolona
	 */

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}
	/**
	 * Vreća naziv kolone
	 */

	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getColumnName(arg0);
	}

}