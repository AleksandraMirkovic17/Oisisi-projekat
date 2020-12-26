package pomocneKlase;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class MyFocusListener implements FocusListener {

	boolean focusRequested = false;

	@Override
	public void focusGained(FocusEvent arg0) {

		JTextField txt = (JTextField) arg0.getComponent();
		txt.setBackground(Color.WHITE);
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextField txt = (JTextField) arg0.getComponent();

		// polja je obavezna za unos:
		if (txt.getName().equals("txtPrezime")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite prezime...")) {
				if (!focusRequested) {
					txt.setText("Unesite prezime...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtIme")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite ime...")) {
				if (!focusRequested) {
					focusRequested = true;
					txt.setText("Unesite ime...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtDatumRodjenja")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite datum rodjenja...")) {
				if (!focusRequested) {
					txt.setText("Unesite datum rodjenja...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtAdresa")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite adresu...")) {
				if (!focusRequested) {
					txt.setText("Unesite adresu...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtTel")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite kontakt telefon...")) {
				if (!focusRequested) {
					txt.setText("Unesite kontakt telefon...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtEmail")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite e-mail...")) {
				if (!focusRequested) {
					txt.setText("Unesite e-mail...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}

		} else if (txt.getName().equals("txtIndeks")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite broj indeksa...")) {
				if (!focusRequested) {
					txt.setText("Unesite broj indeksa...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		} else if (txt.getName().equals("txtGodinaUpisa")) {
			if (txt.getText().trim().equals("") || txt.getText().trim().equals("Unesite godinu upisa...")) {
				if (!focusRequested) {
					txt.setText("Unesite godinu upisa...");
					txt.requestFocus();
					txt.setForeground(Color.RED);
					focusRequested = true;
				}
			} else {
				focusRequested = false;
				txt.setForeground(Color.BLACK);
			}
		}

	}

}
