package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Student;
/**
 * Kontejner klasa, predstavlja panel na koji će se postavljati tabela nepoloženih predmeta kod studenta. Nasleđuje klasu JPanel.
 * @author Andrea Sabo Cibolja
 *
 */
public class NepolozeniTablePanel extends JPanel {
	
	/**
	 * Tabela nepoloženih predmeta.
	 */
	private NepolozeniJTable nepolozeni;
	/**
	 * Konstruktor klase.
	 */
	public NepolozeniTablePanel()
	{
		setLayout(new BorderLayout());
		prikazNepolozenihPredmeta();
		
	}
	/**
	 * Metoda koja postavlja tabelu nepoloženih premeta kao JScrollPane na panel.
	 */
	private void prikazNepolozenihPredmeta()
	{
		nepolozeni=NepolozeniJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(nepolozeni); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}

}
