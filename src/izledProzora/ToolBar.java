package izledProzora;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import javax.swing.SwingConstants;

public class ToolBar extends JToolBar  {
	
	
	public ToolBar()
	{
		super(SwingConstants.HORIZONTAL);
		JButton btnNew = new JButton();
		btnNew.setToolTipText("New");
		btnNew.setIcon(new ImageIcon("Slike/plusic.png"));
		add(btnNew);
		addSeparator();
		
		
		JButton btnNew1 = new JButton();
		btnNew1.setToolTipText("Opetn");
		btnNew1.setIcon(new ImageIcon("Slike/olovka.png"));
		add(btnNew1);
		addSeparator();
		
		JButton btnNew2 = new JButton();
		btnNew2.setToolTipText("Delet");
		btnNew2.setIcon(new ImageIcon("Slike/kanta.png"));
		add(btnNew2);
		addSeparator();
	}

}
