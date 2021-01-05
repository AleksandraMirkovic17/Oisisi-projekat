package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PredmetiTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3935959611551288022L;
	private PredmetJTable predmetiTable;

	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		prikazPredmeta();
	}

	private void prikazPredmeta() {
		predmetiTable = PredmetJTable.getInstance();
		

		TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(predmetiTable.getModel());
		predmetiTable.setRowSorter(sortiranje);
		JScrollPane scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane, BorderLayout.CENTER);
	}
	
}