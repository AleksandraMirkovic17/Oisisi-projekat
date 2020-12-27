package IzgledProzora;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

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
		JScrollPane scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
	}

}
