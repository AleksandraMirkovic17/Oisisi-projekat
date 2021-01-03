package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Student;

public class NepolozeniTablePanel extends JPanel {
	
	private NepolozeniJTable nepolozeni;
	public NepolozeniTablePanel()
	{
		setLayout(new BorderLayout());
		prikazNepolozenihPredmeta();
		
	}
	
	private void prikazNepolozenihPredmeta()
	{
		nepolozeni=NepolozeniJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(nepolozeni); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}

}
