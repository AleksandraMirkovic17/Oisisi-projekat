package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -491100101152257518L;
	private static ToolBar instance=null;	
	public static ToolBar getInstance()
	{
		if(instance==null)
		{
			instance=new ToolBar();
		}
		return instance;
     };
		public ToolBar()
		{
			super(SwingConstants.HORIZONTAL);
			JButton btnNew = new JButton();
			btnNew.setToolTipText("PLUS");
			btnNew.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if(TabPane.getInstance().getSelectedIndex()==0) {
						DodavanjeStudentaDialog dialog=new DodavanjeStudentaDialog();
						dialog.setVisible(true);
					}
					if(TabPane.getInstance().getSelectedIndex()==1)
					{
					  DodavanjeProfesorDialog dialog=new DodavanjeProfesorDialog();
					  dialog.setVisible(true);
					}
				}
			});
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("Slike/plus.png").getImage());
			btnNew.setIcon(imageIcon);
			add(btnNew);
			addSeparator();
			
			
			JButton btnIzmeni = new JButton();
			btnIzmeni.setToolTipText("IZMENE");
			ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("Slike/olovka.png").getImage());
			btnIzmeni.setIcon(imageIcon1);
			add(btnIzmeni);
			addSeparator();
			
			JButton btnIzbrisi = new JButton();
			btnIzbrisi.setToolTipText("IZBRISI");
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("Slike/kanta.png").getImage());
			btnIzbrisi.setIcon(imageIcon2);
			add(btnIzbrisi);
			addSeparator();
			
			JButton btnPretrazi = new JButton();
			btnPretrazi.setToolTipText("PRETRAZI");
			ImageIcon imageIcon22 = new ImageIcon(new ImageIcon("Slike/lupa.png").getImage());
			btnPretrazi.setIcon(imageIcon22);
			add(btnPretrazi);
			addSeparator();
			
			JTextField pretraga=new JTextField();
			pretraga.setPreferredSize(new Dimension(50,30));
			add(Box.createHorizontalStrut(700));
			add(pretraga);
			add(Box.createHorizontalStrut(10));
			add(btnPretrazi);
			addSeparator();
			
			
		}
}
