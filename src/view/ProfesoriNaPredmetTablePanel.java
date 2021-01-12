package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ProfesoriNaPredmetTablePanel extends JPanel {
	private ProfesoriNaPredmetuJTable profesoriNaPredmetu;

	public ProfesoriNaPredmetTablePanel() {
		setLayout(new BorderLayout());
		prikazProfesoraNaPredmetu();

	}

	private void prikazProfesoraNaPredmetu() {
		profesoriNaPredmetu = ProfesoriNaPredmetuJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(profesoriNaPredmetu); // pravimo scrollPane da bi mogli da skrolujemo ako
																// budemo imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}

}
