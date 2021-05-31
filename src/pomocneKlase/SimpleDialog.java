package pomocneKlase;

/*REFERENCIRAN KOD: Preuzet sa materijala sa  vezbi 4 */

import java.awt.Frame;

import javax.swing.JDialog;

/**
 * Klasa koja omogućuje modelovanje jednostavnog dijaloga za specifične potrebe
 * raznih metoda. REFERENCIRAN KOD: Preuzet sa materijala sa vežbi 4.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class SimpleDialog extends JDialog {
	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 3591599721565020284L;

	/**
	 * Konstruktor klase.
	 * 
	 * @param parent roditelj koji je pozvao otvaranje ovog dijaloga
	 * @param title  naslov
	 * @param modal  ,,zastavica" koja pokazuje da li je dijalog modalan ili nije
	 */
	public SimpleDialog(Frame parent, String title, boolean modal) {
		super(parent, title, modal);

		setSize(250, 250);
		setLocationRelativeTo(parent);

	}

}
