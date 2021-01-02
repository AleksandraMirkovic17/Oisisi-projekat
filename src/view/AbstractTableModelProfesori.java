package view;


import javax.swing.table.AbstractTableModel;


import model.BazaProfesor;

//kontrolisemo nase podatke
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
	public String getColumnName(int arg0) { //sta da unesemo u zaglavlje?
		                                    // dobijamo nazive kolone 
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getColumnName(arg0);
	}

	@Override
	//koliko redova treba da se prikaze?
	//uzima iz liste koliko profesora ima i toliko redova pravi
	public int getRowCount() { 
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getProfesori().size(); 
	
	}

	@Override
	public Object getValueAt(int arg0, int arg1) { //postavlja sve tacno vrednosti
		// TODO Auto-generated method stub
		return BazaProfesor.getInstance().getValueAt(arg0, arg1); //daj mi vrednosost na tacnoj toj i toj poziciji
	}
	
}