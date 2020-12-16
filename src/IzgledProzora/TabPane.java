package IzgledProzora;

import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;




public class TabPane extends JTabbedPane{

	private static TabPane instance = null;
	public static int pritisnutTab = 0;

	public static TabPane getInstance() {
		if (instance == null) {
			instance = new TabPane();
		}
		return instance;
	}
	private ProfesoriTablePane profesoriTable = new ProfesoriTablePane();
	private PredmetiTablePanel predmetiTable = new PredmetiTablePanel();
	private StudentTablePanel studentiTable = new StudentTablePanel();
	
	public TabPane()
	{
		ImageIcon imageIcon = new ImageIcon(new ImageIcon("Slike/profesori.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		ImageIcon imageIcon2 = new ImageIcon(new ImageIcon("Slike/predmeti.png").getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT));
		addTab("Studenti", new ImageIcon("Slike/studenti.png"), studentiTable, "Tabela studenata");
		addTab("Profesori", imageIcon, profesoriTable, "Tabela profesora");
		addTab("Predmeti", imageIcon2, predmetiTable, "Tabela profesora");
	}
}

