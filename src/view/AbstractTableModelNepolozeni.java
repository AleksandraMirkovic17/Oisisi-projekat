package view;

import javax.swing.table.AbstractTableModel;

import model.BazaNepolozeni;

/**
 * Klasa koja nasleđuje apstraktnu klasu AbstractTable model, služi za prikaz
 * nepoloženih predmeta kod studenta. Omogućava nam da napravimo izgled/model naše
 * table.
 * @author Andrea Sabo Cibolja
 *
 */


public class AbstractTableModelNepolozeni  extends AbstractTableModel {

	 /**
	 * Serijski broj
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Konstruktor klase
	 */

	public AbstractTableModelNepolozeni()
	   {
		   
	   }
		/**
		 * Vraća broj kolona iz baze nepoloženih predmeta.
		 */
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			
			return BazaNepolozeni.getInstance().getColumnCount();
		}
		/**
		 * Vraća naziv kolone.
		 */

		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getColumnName(arg0);
		}
		/**
		 * Vraća broj vrsta iz baze nepoloženih predmeta.
		 */
		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getNepolozeniPredmeti().size();
		
		}
		/**
		 * vraća vrednost u određenom polju, na preseku određene kolone i reda
		 * @param arg0 broj vrste
		 * @param arg1 broj kolone
		 */

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getValueAt(arg0, arg1);
		}
		

}