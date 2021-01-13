package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class PredmetiTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3935959611551288022L;
	private PredmetJTable predmetiTable;
	public static int selektovan_red = -1;

	public PredmetiTablePanel() {
		setLayout(new BorderLayout());
		prikazPredmeta();
	}

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
		JScrollPane scrollPane = new JScrollPane(predmetiTable); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}
	public static int getSelektovan_red() {
		return selektovan_red;
	}

	public static void setSelektovan_red(int selektovan_red) {
		PredmetiTablePanel.selektovan_red = selektovan_red;
	}
	
}