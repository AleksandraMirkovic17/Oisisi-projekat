package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class StudentTablePanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private StudentiJTable studentiTable;
	private static int selektovanRed = -1;

	public StudentTablePanel() {
		setLayout(new BorderLayout());
		prikazStudenta();
	}

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
	
	public static void setSelektovanRed(int selected) {
		selektovanRed = selected;
	}

}
