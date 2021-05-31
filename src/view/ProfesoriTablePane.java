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
 * profesora unetih u sistem. Nasleđuje klasu JPanel.
 * 
 * @author Aleksandra Mirković
 *
 */

public class ProfesoriTablePane extends JPanel {

	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 3934304876755044503L;
	/**
	 * tabela profesora
	 */
	private ProfesoriJTable profesoriTable;
	/**
	 * indeks selektovanog reda, inicijalna vrednost je -1, iz razloga što na
	 * početku nismo selektovali nijedan red
	 */
	public static int selektovan_red = -1;

	/**
	 * konstruktor klase
	 */
	public ProfesoriTablePane() {
		setLayout(new BorderLayout());
		prikazProfesora();
	}

	/**
	 * Metoda koja postavlja tabelu predmeta kao JScrollPane na panel. Omogućeno je
	 * i sortiranje po svim kolonoma.
	 */
	private void prikazProfesora() {
		profesoriTable = ProfesoriJTable.getInstance();
		TableRowSorter<TableModel> sortiranje = new TableRowSorter<TableModel>(profesoriTable.getModel());
		profesoriTable.setRowSorter(sortiranje);
		profesoriTable.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				ProfesoriJTable tabela = (ProfesoriJTable) e.getComponent();
				setSelektovan_red(tabela.convertRowIndexToModel(tabela.getSelectedRow()));
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				ProfesoriJTable tabela = (ProfesoriJTable) e.getComponent();
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
		JScrollPane scrollPane = new JScrollPane(profesoriTable); // pravimo scrollPane da bi mogli da skrolujemo ako
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
		ProfesoriTablePane.selektovan_red = selektovan_red;
	}

}
