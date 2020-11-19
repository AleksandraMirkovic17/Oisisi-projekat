package IzgledProzora;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class ToolBar extends JToolBar  {
		
		
		public ToolBar()
		{
			super(SwingConstants.HORIZONTAL);
			JButton btnNew = new JButton();
			btnNew.setToolTipText("PLUSIC");
			ImageIcon imageIcon = new ImageIcon(new ImageIcon("Slike/plusic.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
			btnNew.setIcon(imageIcon);
			add(btnNew);
			addSeparator();
			
			
			JButton btnNew1 = new JButton();
			btnNew1.setToolTipText("IZMENE");
			ImageIcon imageIcon1 = new ImageIcon(new ImageIcon("Slike/olovka.png").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
			btnNew1.setIcon(imageIcon1);
			add(btnNew1);
			addSeparator();
			
			JButton btnNew2 = new JButton();
			btnNew2.setToolTipText("Delet");
			ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("Slike/kanta.jpg").getImage().getScaledInstance(22, 22, Image.SCALE_DEFAULT));
			btnNew2.setIcon(imageIcon2);
			add(btnNew2);
			addSeparator();
		
		}

}
