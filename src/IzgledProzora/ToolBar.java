package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar  {
		
		
		public ToolBar()
		{
			super(SwingConstants.HORIZONTAL);
			JButton btnNew = new JButton();
			btnNew.setToolTipText("PLUSIC");
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("Slike/plus.png").getImage());
			btnNew.setIcon(imageIcon);
			add(btnNew);
			addSeparator();
			
			
			JButton btnNew1 = new JButton();
			btnNew1.setToolTipText("IZMENE");
			ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("Slike/olovka.png").getImage());
			btnNew1.setIcon(imageIcon1);
			add(btnNew1);
			addSeparator();
			
			JButton btnNew2 = new JButton();
			btnNew2.setToolTipText("IZBRISI");
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("Slike/kanta.png").getImage());
			btnNew2.setIcon(imageIcon2);
			add(btnNew2);
			addSeparator();
			
			JButton btnNew22 = new JButton();
			btnNew22.setToolTipText("Search");
			ImageIcon imageIcon22 = new ImageIcon(new ImageIcon("Slike/lupa.png").getImage());
			btnNew22.setIcon(imageIcon22);
			add(btnNew22);
			addSeparator();
			
			JTextField pretraga=new JTextField();
			pretraga.setPreferredSize(new Dimension(50,30));
			add(Box.createHorizontalStrut(700));
			add(pretraga);
			add(Box.createHorizontalStrut(10));
			add(btnNew22);
			addSeparator();
		}
}
