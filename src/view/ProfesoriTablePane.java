package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class ProfesoriTablePane extends JPanel{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3934304876755044503L;
	private ProfesoriJTable profesoriTable;
	public ProfesoriTablePane()
	{
		setLayout(new BorderLayout());
		prikazProfesora();
	}
	
	private void prikazProfesora()
	{
		profesoriTable=ProfesoriJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(profesoriTable); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}

	
}