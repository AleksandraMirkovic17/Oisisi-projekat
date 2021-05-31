package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 * Kontejner klasa, predstavlja panel na koji će se postavljati tabela položenih predmeta kod studenta. Nasleđuje klasu JPanel.
 * @author Aleksandra Mirković
 *
 */
public class PolozeniTablePanel extends JPanel {
	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 3934304876755044503L;
	/**
	 * tebela položenih predmeta
	 */
	private PolozeniJTable polozeni;
	/**
	 * konstruktor klase
	 */
	public PolozeniTablePanel() {
		setLayout(new BorderLayout());
		prikazPolozenihPredmeta();
	}
	/**
	 * Metoda koja postavlja tabelu nepoloženih premeta kao JScrollPane na panel.
	 */
	private void prikazPolozenihPredmeta() {
		polozeni = PolozeniJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(polozeni); // pravimo scrollPane da bi mogli da skrolujemo ako budemo
															// imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}

}