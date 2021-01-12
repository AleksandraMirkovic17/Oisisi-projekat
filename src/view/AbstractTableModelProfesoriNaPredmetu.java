package view;

import javax.swing.table.AbstractTableModel;

import model.BazaProfesorPredajePredmet;
import model.BazaProfesoriNaPredmetu;

public class AbstractTableModelProfesoriNaPredmetu extends AbstractTableModel {

	public AbstractTableModelProfesoriNaPredmetu() {

	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub

		return BazaProfesoriNaPredmetu.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaProfesoriNaPredmetu.getInstance().getColumnName(arg0);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesoriNaPredmetu.getInstance().getProfesori().size();

	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		//return BazaProfesoriNaPredmetu.getInstance().getValueAt(arg0, arg1);
		return null;
	}

}
