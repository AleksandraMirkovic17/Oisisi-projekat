package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfPredmetTablePane  extends JPanel{
	private ProfesorPredmetJTabel predmetiProf;
	public ProfPredmetTablePane()
	{
		setLayout(new BorderLayout());
		prikazNepolozenihPredmeta();
		
	}
	
	private void prikazNepolozenihPredmeta()
	{
		predmetiProf=ProfesorPredmetJTabel.getInstance();
		JScrollPane scrollPane = new JScrollPane(predmetiProf); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}


}
