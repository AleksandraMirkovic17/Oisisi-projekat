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
 * unetih studenata u sistem. Nasleđuje klasu JPanel.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class StudentTablePanel extends JPanel {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * tabela studenata
	 */
	private StudentiJTable studentiTable;
	/**
	 * indeks selektovanog reda, inicijalna vrednost je -1, iz razloga što na
	 * početku nismo selektovali nijedan red
	 */
	private static int selektovanRed = -1;

	/**
	 * konstruktor klase
	 */
	public StudentTablePanel() {
		setLayout(new BorderLayout());
		prikazStudenta();
	}

	/**
	 * Metoda koja postavlja tabelu studenata kao JScrollPane na panel. Omogućeno je
	 * i sortiranje po svim kolonoma.
	 */
	private void prikazStudenta() {
		studentiTable = StudentiJTable.getInstance();
		TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(studentiTable.getModel());
		studentiTable.setRowSorter(sortiranje);
		studentiTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				StudentiJTable tabela = (StudentiJTable) e.getComponent();
				setSelektovanRed(tabela.convertRowIndexToModel(tabela.getSelectedRow()));

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				StudentiJTable tabela = (StudentiJTable) e.getComponent();
				setSelektovanRed(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
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

		JScrollPane scrollPane = new JScrollPane(studentiTable);
		add(scrollPane, BorderLayout.CENTER);
	}

	/**
	 * metoda koja postavlja selektovani red
	 * 
	 * @param selected redni broj reda
	 */
	public static void setSelektovanRed(int selected) {
		selektovanRed = selected;
	}

	/**
	 * metoda koja dobavlja broj selektovanog reda
	 * 
	 * @return vraća redni broj selektovanog reda
	 */
	public static int getSelectovanRed() {
		return selektovanRed;
	}

}
