package IzgledProzora;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellRenderer;



public class ProfesoriJTable extends  JTable {

	private static ProfesoriJTable instance = null;

	static public ProfesoriJTable getInstance() {
		if (instance == null) {
			instance = new ProfesoriJTable();
		}
		return instance;
	}
	private static final long serialVersionUID = -7475213618819842792L;
   //vrsimo neku konfiguraciju 
	public ProfesoriJTable()
	{
		this.setRowSelectionAllowed(true); //selektovanje redova
		this.setColumnSelectionAllowed(true); //selektovanje kolona
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //da mozemo samo jednu koloonu da selektujemo
		this.setModel(new AbstractTableModelProfesori());
	
		
	}
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		// selektovani red ce imati drugaciju boju od ostalih
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	public void azurirajPrikaz() {
		AbstractTableModelProfesori model = (AbstractTableModelProfesori) this.getModel(); 
		model.fireTableDataChanged(); //obavestavamo da je doslo do promene podatak i da model treba da se azurira
		validate(); //ugradjena metoda
	}

}
