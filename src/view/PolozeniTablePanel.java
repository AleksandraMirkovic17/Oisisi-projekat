package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PolozeniTablePanel extends JPanel {
	private static final long serialVersionUID = 3934304876755044503L;
	private PolozeniJTable polozeni;

	public PolozeniTablePanel() {
		setLayout(new BorderLayout());
		prikazPolozenihPredmeta();
	}

	private void prikazPolozenihPredmeta() {
		polozeni = PolozeniJTable.getInstance();
		JScrollPane scrollPane = new JScrollPane(polozeni); // pravimo scrollPane da bi mogli da skrolujemo ako budemo
															// imali vise redova
		add(scrollPane, BorderLayout.CENTER);
	}

}