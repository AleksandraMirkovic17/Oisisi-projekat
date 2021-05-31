package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;

//kontrolisemo nase podatke
/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTable model, služi za prikaz
 * svih profesora unetih u sistem. Omogućava nam da napravimo izgled/model naše
 * table.
 * @author Aleksandra Mirković
 */
public class AbstractTableModelProfesori extends AbstractTableModel {

	/**
	 * Konstruktor klase.
	 */
	public AbstractTableModelProfesori() {

	}
	/**
	 * Vraća broj kolona.
	 */

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getColumnCount();
	}
	/**
	 * Vraća naziv kolone. Govori šta da unesemo u zaglavlje.
	 */

	@Override
	public String getColumnName(int arg0) { // sta da unesemo u zaglavlje?
											// dobijamo nazive kolone
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getColumnName(arg0);
	}
	/**
	 * Vraća broj redova koji su potrebni za modelovanje prikaza.
	 */

	@Override
	// koliko redova treba da se prikaze?
	// uzima iz liste koliko profesora ima i toliko redova pravi
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getProfesori().size();
	}
	
	/**
	 * Vraća šta se nalazi u preseku vrste i kolone.
	 * @param arg0 broj kolone
	 * @param arg1 broj vrste
	 */

	@Override
	public Object getValueAt(int arg0, int arg1) { // postavlja sve tacno vrednosti
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getValueAt(arg0, arg1); // daj mi vrednosost na tacnoj toj i toj poziciji
	}

}