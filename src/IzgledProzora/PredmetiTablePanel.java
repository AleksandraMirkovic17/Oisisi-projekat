package IzgledProzora;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PredmetiTablePanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3935959611551288022L;
	private PredmetJTable predmetiTable;
	
	public PredmetiTablePanel()
	{
		setLayout(new BorderLayout());
		prikazPredmeta();
	}
	private void prikazPredmeta()
	{
		predmetiTable=new PredmetJTable();
		JScrollPane scrollPane = new JScrollPane(predmetiTable);
		add(scrollPane,BorderLayout.CENTER);
	}
	
}
