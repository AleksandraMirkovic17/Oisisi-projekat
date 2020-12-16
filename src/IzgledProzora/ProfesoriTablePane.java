package IzgledProzora;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;



public class ProfesoriTablePane extends JPanel{
 
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
