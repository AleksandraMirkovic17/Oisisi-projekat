package IzgledProzora;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import IzgledProzora.ToolBar;


public class GlavniProzor extends JFrame {
	
	private ToolBar toolbar;
	private MyMenuBar menu;
	private StatusBar statusBar;
	private TabPane tabpane;
	
	private static GlavniProzor instance=null;
	private JTable tabelaStudent;
	 
	public static GlavniProzor getInstance()
	{
		if(instance==null)
		{
			instance=new GlavniProzor();
		}
		return instance;
     };
	

	public GlavniProzor() {
	Toolkit kit = Toolkit.getDefaultToolkit();
	Dimension screenSize = kit.getScreenSize(); //Dimenziju koja sadrzi screenHeigh i screenWidth
	int screenHeight = screenSize.height;
	int screenWidth = screenSize.width;
	setTitle("Studentska sluzba"); 
	setSize(screenWidth * 3/4, screenHeight / 2); 

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
	
	tabpane = new TabPane();
	add(tabpane, BorderLayout.CENTER);
	System.out.println(tabpane.getPreferredSize());
	
	tabpane.setVisible(true);
	
	menu=MyMenuBar.getInstance();
	this.setJMenuBar(menu);
	
	statusBar = new StatusBar();
	add(statusBar, BorderLayout.SOUTH);
	statusBar.setVisible(true);
	statusBar.setBorder(BorderFactory.createLineBorder(Color.GRAY)); //Postavljanje granicne linije 
	
	toolbar=new ToolBar();
	add(toolbar, BorderLayout.NORTH);  
	toolbar.setVisible(true);
	setResizable(true);
	}

/*	private void inicijalizujAkcije() {
		JPanel panelTop = new JPanel();
		JButton btnDodaj = new JButton("Dodaj");
		JButton btnIzbrisi = new JButton("Izbrisi");
		JButton btnIzmeni = new JButton("Izmeni");

		panelTop.add(btnDodaj);
		panelTop.add(btnIzbrisi);
		panelTop.add(btnIzmeni);

		this.add(panelTop, BorderLayout.NORTH);

		btnDodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IgraciController.getInstance().dodajIgraca();
			}
		});

		btnIzbrisi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IgraciController.getInstance().izbrisiIgraca(tabelaIgraca.getSelectedRow());
			}
		});

		btnIzmeni.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				IgraciController.getInstance().izmeniIgraca(tabelaIgraca.getSelectedRow());
			}
		});
	}

	private void prikaziTabeluIgraca() {
		tabelaIgraca = new IgraciJTable();

		JScrollPane scrollPane = new JScrollPane(tabelaIgraca);
		add(scrollPane, BorderLayout.CENTER);

		this.azurirajPrikaz(null, -1);
	}
*/
	

}
