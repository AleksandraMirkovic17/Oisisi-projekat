package IzgledProzora;


import javax.swing.table.AbstractTableModel;


import model.BazaProfesor;

public class AbstractTableModelProfesori extends AbstractTableModel {

	

   public AbstractTableModelProfesori()
   {
	   
   }

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getColumnCount();
	}

	@Override
	public String getColumnName(int arg0) {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getColumnName(arg0);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getProfesori().size();
	
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getValueAt(arg0, arg1);
	}
	
}
