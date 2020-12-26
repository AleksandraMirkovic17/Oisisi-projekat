package IzgledProzora;

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
		profesoriTable=new ProfesoriJTable();
		JScrollPane scrollPane = new JScrollPane(profesoriTable);
		add(scrollPane,BorderLayout.CENTER);
	}

	
}
