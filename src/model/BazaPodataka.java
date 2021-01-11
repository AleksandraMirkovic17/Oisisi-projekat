package model;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BazaPodataka {
	List<Student> studenti;
	List<Profesor> profesori;
	List<Predmet> predmeti;
	
	public BazaPodataka() {
		studenti = BazaStudent.getInstance().getStudenti();
		profesori = BazaProfesor.getInstance().getProfesori();
	    predmeti = BazaPredmet.getInstance().getPredmeti();
	}
	
	public void citanje() {
		ObjectInputStream o = null;
		try {
			o = new ObjectInputStream(new BufferedInputStream(new FileInputStream("podaci.raw")));
			BazaStudent.getInstance().setStudenti((List<Student>)o.readObject());
			BazaProfesor.getInstance().setProfesori((List<Profesor>)o.readObject());
			BazaPredmet.getInstance().setPredmet((List<Predmet>)o.readObject());

			BazaStudent.getInstance().setBrojStudenata(BazaStudent.getInstance().getStudenti().size());
			BazaProfesor.getInstance().setBroj_Profesora(BazaProfesor.getInstance().getProfesori().size());
			//BazaPredmet.getInstance().se DODATI
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}finally {
			try {
				o.close();
			}catch (Exception e) {
				// TODO: handle exception
			}	
		}
	}
	
}

