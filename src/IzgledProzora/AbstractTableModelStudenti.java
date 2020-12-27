package IzgledProzora;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesor;
import model.BazaStudent;

public class AbstractTableModelStudenti extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractTableModelStudenti() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getColumnCount();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getValueAt(rowIndex, columnIndex);
	}

	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaStudent.getInstance().getColumnName(arg0);
	}

}
