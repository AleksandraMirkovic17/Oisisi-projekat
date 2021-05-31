package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Klasa koja služi za modelovanje status bara koji se postavlja na dno glavnog
 * prozora. Nasleđuje klasu JPAnel i implementira interfejs Runnable. StatusBar
 * sadrži naziv aplikacije i trenutni datum i vreme.
 * 
 * @author Andrea Sabo Cibolja
 *
 */
public class StatusBar extends JPanel implements Runnable {
	/**
	 * serijski broj
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * nit
	 */
	private Thread nit;
	/**
	 * labela sa datumom i vremenom
	 */
	private JLabel datumVreme;
	/**
	 * format prikaza datuma
	 */
	protected SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
	/**
	 * format prikaza vremena
	 */
	protected SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

	/**
	 * konstruktor klase, kreira status bar
	 */
	StatusBar() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize(); // Dimenziju koja sadrzi screenHeigh i screenWidth
		setPreferredSize(new Dimension(screenSize.width, 25));
		setLayout(new BorderLayout());

		JLabel nazivApp = new JLabel("		Studentska služba");
		add(nazivApp, BorderLayout.WEST);

		datumVreme = new JLabel();
		add(datumVreme, BorderLayout.EAST);
		nit = new Thread(this);
		nit.start();
	}

	/*
	 * https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * klasa SimpleDate format omogucava da formatiramo datum u zeljeni oblik na
	 * jednostavan nacin
	 */
	/*
	 * https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html
	 * klasa Calendar je apstraktna klasa, pozivanjem metode getInstance() ove klase
	 * dobijamo trenutno vreme
	 */
	/**
	 * nakon pokretanja niti, poziva se ova metoda i izvršava se sve dok je nit
	 * pozivaoc u životu
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		do {
			DateFormat datum = new SimpleDateFormat("HH:mm  dd.MM.yyyy.             ");
			Calendar kalendar = Calendar.getInstance();
			datumVreme.setText(datum.format(kalendar.getTime()));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (nit.isAlive());

	}

}
