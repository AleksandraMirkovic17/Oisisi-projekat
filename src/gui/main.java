package gui;

import java.util.*;

import view.GlavniProzor;
import view.ToolBar;

public class main  {

	public static void main(String[] args)
	{
		GlavniProzor glavni= GlavniProzor.getInstance(); //vraca nesto sto ce biti jedinstveno za klasu 
		glavni.setVisible(true);

	}
}

