/**
 * Sadži klasu za pokretanje aplikacije.
 */
package gui;

import java.util.*;

import view.GlavniProzor;
import view.ToolBar;

/**
 * Klasa iz koje se vrši inicijalno pokretanje aplikacije. Sadrži samo jednu
 * metodu: public static void main() koja dobavlja instancu glavnog prozora
 * klase GlavniProzor i omogućava njenu vidljivost.
 * 
 * @author Andrea Sabo Cibolja
 *
 */

public class main {

	public static void main(String[] args) {
		GlavniProzor glavni = GlavniProzor.getInstance(); // vraca nesto sto ce biti jedinstveno za klasu
		glavni.setVisible(true);

	}
}
