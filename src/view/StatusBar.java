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

public class StatusBar extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Thread nit;
	private JLabel datumVreme;

	protected SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, d MMM yyyy");
	protected SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");

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

