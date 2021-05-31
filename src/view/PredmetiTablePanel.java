package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 * Kontejner klasa, predstavlja panel na koji će se postavljati tabela svih
 * unetih predmeta. Nasleđuje klasu JPanel.
 * 
 * @author Aleksandra Mirković
 *
 */

public class PredmetiTablePanel extends JPanel {

	/**
	 * indeks selektovanog reda, inicijalna vrednost je -1, iz razloga što na
	 * početku nismo selektovali nijedan red
	 */
	public static int selektovan_red = -1;
	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 3935959611551288022L;
	/**
	 * tabela predmeta
	 */
	private PredmetJTable predmetiTable;

	/**
	 * konstruktor klase
	 */
	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		prikazPredmeta();
	}

	/**
	 * Metoda koja postavlja tabelu predmeta kao JScrollPane na panel. Omogućeno je
	 * i sortiranje po svim kolonoma.
	 */
	private void prikazPredmeta() {
		predmetiTable = PredmetJTable.getInstance();

		TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(predmetiTable.getModel());
		predmetiTable.setRowSorter(sortiranje);
		predmetiTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				PredmetJTable tabela = (PredmetJTable) e.getComponent();
				setSelektovan_red(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				PredmetJTable tabela = (PredmetJTable) e.getComponent();
				setSelektovan_red(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JScrollPane scrollPane = new JScrollPane(predmetiTable); // pravimo scrollPane da bi mogli da skrolujemo ako
																	// budemo imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}
	/**
	 * Metoda koja dobavlja redni broj selektovanog reda.
	 * 
	 * @return povratna vrednost je redni broj selektovanog reda
	 */

	public static int getSelektovan_red() {
		return selektovan_red;
	}

	/**
	 * Metoda koja postavlja selektovani red na željeni.
	 * 
	 * @param selektovan_red željeni redni broj reda
	 */
	public static void setSelektovan_red(int selektovan_red) {
		PredmetiTablePanel.selektovan_red = selektovan_red;
	}
}
