package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import model.BazaPodataka;
import view.ToolBar;

/**
 * Singleton klasa koja modeluje izgled glavnog prozora. Nasleđuje klasu JFrame.
 * Podloga je za GUI. Sadržaće tabelarni prikaz svih entiteta tipa student,
 * profesor i predmet koji su uneti u sistem.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class GlavniProzor extends JFrame {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = -3488386386134502451L;
	/**
	 * linija sa alatkama
	 */
	private ToolBar toolbar;
	/**
	 * linija menija
	 */
	private MyMenuBar menu;
	/**
	 * statusna traka
	 */
	private StatusBar statusBar;
	/**
	 * panel sa tabovima
	 */
	private TabPane tabpane;
	/**
	 * instanca glavnog prozora
	 */
	private static GlavniProzor instance = null;

	/**
	 * Metoda koja omogućava kreiranje smo jedne instance(objekta) ove klase.
	 * 
	 * @return vraća instancu prethodno kreiranog objekta ili vraća novokreirani
	 *         objekat, ako nijedna instanca ove klase nije prethodno kreirana,+.
	 */
	public static GlavniProzor getInstance() {
		if (instance == null) {
			instance = new GlavniProzor();
		}
		return instance;
	};

	/**
	 * Konstruktor klase - kreira glavni prozor zadatih dimenzija, instancira meni,
	 * ToolBar, StatusBar, kao i panel sa tabovima. Unutar konstruktora se pozivaju
	 * i metode za serijalizaciju i deserijalizaciju.
	 */
	public GlavniProzor() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		BazaPodataka bp = new BazaPodataka();

		bp.citanje();
		Dimension screenSize = kit.getScreenSize(); // Dimenziju koja sadrzi screenHeigh i screenWidth
		int screenHeight = screenSize.height;
		int screenWidth = screenSize.width;
		setTitle("Studentska služba");
		setSize(screenWidth * 3 / 4, screenHeight * 3 / 4);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		tabpane = TabPane.getInstance();
		add(tabpane, BorderLayout.CENTER);
		System.out.println(tabpane.getPreferredSize());

		tabpane.setVisible(true);

		menu = MyMenuBar.getInstance();
		this.setJMenuBar(menu);

		statusBar = new StatusBar();
		add(statusBar, BorderLayout.SOUTH);
		statusBar.setVisible(true);
		statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY)); // Postavljanje granicne linije

		toolbar = new ToolBar();
		add(toolbar, BorderLayout.NORTH);
		toolbar.setVisible(true);
		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void windowClosing(WindowEvent e) {
				JFrame frame = (JFrame) e.getComponent();
				int izbor = JOptionPane.showConfirmDialog(null, "Da li ste sigurni da želite da zatvorite aplikaciju?",
						"Pitanje", JOptionPane.YES_NO_OPTION);
				if (izbor == JOptionPane.YES_OPTION) {

					try {

						bp.cuvanje();
					} catch (Exception t) {
						// TODO: handle exception
					}
					frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} else {
					frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});

		setVisible(true);

	}

}