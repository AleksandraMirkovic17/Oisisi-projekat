package controller;

import model.BazaStudent;
import model.Student;
import view.IzmenaStudentaDialog;
import view.StudentiJTable;

public class StudentController {

	private static StudentController instance = null;

	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}

	private StudentController() {
	}

	public void dodajStudenta() {
		// izmena modela
		// BazaStudent.getInstance().dodajStudenta(prezime, ime, datumRodjenja,
		// adresaStanovanja, kontaktTelefon, email, brIndeksa, godinaUpisa,
		// trenutnaGodinaStudija, status, prosecnaOcena, polozeniPredmeti);;
		// azuriranje prikaza
		StudentiJTable.getInstance().refresTabelu();
	}

	public void izmeniStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		// izmena modela
		Student student = BazaStudent.getInstance().getRow(rowSelectedIndex);
		IzmenaStudentaDialog dialog = new IzmenaStudentaDialog(student);
		dialog.setVisible(true);
		// azuriranje prikaza
		StudentiJTable.getInstance().refresTabelu();
	}
}
