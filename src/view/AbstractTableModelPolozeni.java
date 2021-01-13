package view;

import javax.swing.table.AbstractTableModel;

import model.BazaPolozeni;

public class AbstractTableModelPolozeni extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelPolozeni() {

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getColumnName(arg0);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getPolozeniPredmeti().size();

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaPolozeni.getInstance().getValueAt(arg0, arg1);
	}
}
