package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorPredajePredmet;

public class AbstractTableModelProfesoriNaPredmetu extends AbstractTableModel {

	public AbstractTableModelProfesoriNaPredmetu() {

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return BazaProfesorPredajePredmet.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getColumnName(arg0);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getPredmeti().size();

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaProfesorPredajePredmet.getInstance().getValueAt(arg0, arg1);
	}

}
