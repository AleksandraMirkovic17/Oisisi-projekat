package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentiJTable studentiTable;

	public StudentTablePanel() {
		setLayout(new BorderLayout());
		prikazStudenta();
	}

	private void prikazStudenta() {
		studentiTable = StudentiJTable.getInstance();
		TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(studentiTable.getModel());
		studentiTable.setRowSorter(sortiranje);
		 
		JScrollPane scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
	}

}
