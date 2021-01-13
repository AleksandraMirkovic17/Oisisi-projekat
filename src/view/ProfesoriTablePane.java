package view;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;



public class ProfesoriTablePane extends JPanel{
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 3934304876755044503L;
	private ProfesoriJTable profesoriTable;
	public static int selektovan_red = -1;
	public ProfesoriTablePane()
	{
		setLayout(new BorderLayout());
		prikazProfesora();
	}
	
	private void prikazProfesora()
	{
		profesoriTable=ProfesoriJTable.getInstance();
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
		JScrollPane scrollPane = new JScrollPane(profesoriTable); //pravimo scrollPane da bi mogli da skrolujemo ako budemo imali vise redova
		add(scrollPane,BorderLayout.CENTER);
	}
	public static int getSelektovan_red() {
		return selektovan_red;
	}

	public static void setSelektovan_red(int selektovan_red) {
		ProfesoriTablePane.selektovan_red = selektovan_red;
	}

	
}
