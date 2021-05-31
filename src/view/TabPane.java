package view;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;

/**
 * Klasa koja služi za kreiranje tabova, koji se postavljaju na glavni prozor.
 * Nasleđuje klasu JTabbedPane.
 * 
 * @author Aleksandra Mirković, Andrea Sabo Cibolja
 *
 */

public class TabPane extends JTabbedPane {

	/**
	 * Serijski broj
	 */
	private static final long serialVersionUID = -89465387623306890L;
	/**
	 * Instanca klase
	 */
	private static TabPane instance = null;
	/**
	 * Redni broj pritisnutog taba, inicijalna vrednost se postavlja na 0, kako bi
	 * na početku imali prikazan prvi tab
	 */
	public static int pritisnutTab = 0;

	/**
	 * Metoda koja omogućuje da ova klasa bude singleton, te da postoji samo jedna
	 * instanca ove klase u svakom trenutku.
	 * 
	 * @return vraća referencu na prethodno kreirani objekat ove klase ili kreira
	 *         novi objekat ove klase
	 */
	public static TabPane getInstance() {
		if (instance == null) {
			instance = new TabPane();
		}
		return instance;
	}

	/**
	 * Panel sa tabelom u kojoj se nalaze svi profesori uneti u sistem.
	 */
	private ProfesoriTablePane profesoriTable = new ProfesoriTablePane();
	/**
	 * Panel sa tabelom u kojoj se nalaze svi predmeti uneti u sistem.
	 */
	private PredmetiTablePanel predmetiTable = new PredmetiTablePanel();
	/**
	 * Panel sa tabelom u kojoj se nalaze svi studenti uneti u sistem.
	 */
	private StudentTablePanel studentiTable = new StudentTablePanel();

	/**
	 * Konstruktor klase, postavlje panele sa studentima, profesorima i predmetima
	 * na odgovarajuće tabove.
	 */
	public TabPane() {
		ImageIcon imageIcon = new ImageIcon(
				new ImageIcon("Slike/profesori.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		ImageIcon imageIcon2 = new ImageIcon(
				new ImageIcon("Slike/predmeti.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		addTab("Studenti", new ImageIcon("Slike/studenti.png"), studentiTable, "Tabela studenata");
		addTab("Profesori", imageIcon, profesoriTable, "Tabela profesora");
		addTab("Predmeti", imageIcon2, predmetiTable, "Tabela profesora");
	}

	/**
	 * Metoda koja nam daje informaciju o tome na kom se trenutno tabu nalazimo.
	 * 
	 * @return redni broj pritisnutog taba
	 */
	public static int getPritisnutTab() {
		return TabPane.getInstance().getSelectedIndex();
	}
}
