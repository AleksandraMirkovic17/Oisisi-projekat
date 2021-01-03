package view;
import javax.swing.table.AbstractTableModel;

import model.BazaNepolozeni;
import model.Student;



public class AbstractTableModelNepolozeni  extends AbstractTableModel {

	 public AbstractTableModelNepolozeni()
	   {
		   
	   }
   
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			
			return BazaNepolozeni.getInstance().getColumnCount();
		}

		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getColumnName(arg0);
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getNepolozeniPredmeti().size();
		
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return BazaNepolozeni.getInstance().getValueAt(arg0, arg1);
		}
		

}