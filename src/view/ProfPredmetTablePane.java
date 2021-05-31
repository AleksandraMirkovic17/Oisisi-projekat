package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Kontejner klasa, predstavlja panel na koji će se postavljati tabela svih
 * predmeta na kojima predaje jedan profesor. Nasleđuje klasu JPanel.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class ProfPredmetTablePane extends JPanel {
	/**
	 * tabela predmeta kod selektovanog profesora
	 */
	private ProfesorPredmetJTabel predmetiProf;

	/**
	 * konstruktor klase
	 */
	public ProfPredmetTablePane() {
		setLayout(new BorderLayout());
		prikazPredmeta();

	}

	/**
	 *
	 * Metoda koja postavlja tabelu predmeta kao JScrollPane na panel.
	 */
	private void prikazPredmeta() {
		predmetiProf = ProfesorPredmetJTabel.getInstance();
		JScrollPane scrollPane = new JScrollPane(predmetiProf); // pravimo scrollPane da bi mogli da skrolujemo ako
																// budemo imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}

}
