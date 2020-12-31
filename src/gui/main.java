package gui;

import java.util.*; 

import IzgledProzora.GlavniProzor;
import IzgledProzora.ToolBar;

public class main  {

	public static void main(String[] args)
	{
		GlavniProzor glavni= GlavniProzor.getInstance(); //vraca nesto sto ce biti jdinstveno za klasu 
		glavni.setVisible(true);

	}
}

