package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import GUI.*;

public class Controller {
	
	//Dichiarazioni dei Frame
	FinestraLogin finestraPrincipale;
	
	public static void main(String[] args)
	{
		Controller c = new Controller();			
	}
	
	public Controller() {
		finestraPrincipale = new FinestraLogin(this);
		finestraPrincipale.setVisible(true);
	}
}	
