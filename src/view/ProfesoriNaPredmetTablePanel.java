package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Kontejner klasa, predstavlja panel na koji će se postavljati tabela profesora
 * na nekom predmetu. Nasleđuje klasu JPanel.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class ProfesoriNaPredmetTablePanel extends JPanel {
	/**
	 * Tabela profesora na predmetu
	 */
	private ProfesoriNaPredmetuJTable profesoriNaPredmetu;

	/**
	 * Konstruktor klase
	 */
	public ProfesoriNaPredmetTablePanel() {
		setLayout(new BorderLayout());
		prikazProfesoraNaPredmetu();

	}

	/**
	 * Metoda koja postavlja tabelu profesora kao JScrollPane na panel.
	 */
	private void prikazProfesoraNaPredmetu() {
		profesoriNaPredmetu = ProfesoriNaPredmetuJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(profesoriNaPredmetu); // pravimo scrollPane da bi mogli da skrolujemo
																		// ako
		// budemo imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}

}
