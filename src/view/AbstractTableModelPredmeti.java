package view;


import javax.swing.table.AbstractTableModel;


import model.BazaPredmet;


public class AbstractTableModelPredmeti  extends AbstractTableModel {

	 public AbstractTableModelPredmeti()
	   {
		   
	   }

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return BazaPredmet.getInstance().getColumnCount();
		}

		@Override
		public String getColumnName(int arg0) {
			// TODO Auto-generated method stub
			return BazaPredmet.getInstance().getColumnName(arg0);
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return BazaPredmet.getInstance().getPredmeti().size();
		
		}

		@Override
		public Object getValueAt(int arg0, int arg1) {
			// TODO Auto-generated method stub
			return BazaPredmet.getInstance().getValueAt(arg0, arg1);
		}
		

}

