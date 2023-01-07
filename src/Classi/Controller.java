package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;

import GUI.*;

public class Controller {
	
	//Dichiarazioni dei Frame
	FinestraLogin finestraPrincipale;
	MenuOperazioni menu;
	FinestraTartaruga finestraTart;
	FinestraVasca finestraVasca;
	FinestraCentro finestraCentro;
	FinestraAddetto finestraAddetto;
	
	private final static String url = "jdbc:postgresql://localhost:5432/DBTartarughe";
	private final static String user = "postgres";
	private final static String password = "Armandoegger1_"; //Temporanea
	
	static Connection connessione;
	
	public static void main(String[] args)
	{
		try {
			connessione = DriverManager.getConnection(url, user, password);
			Controller c = new Controller();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
	}
	
	public Controller() {
		finestraPrincipale = new FinestraLogin(this);
		finestraPrincipale.setVisible(true);
	}
	
	public void ShowMenu() {
		finestraPrincipale.setVisible(false);
		menu = new MenuOperazioni(this);
		menu.setVisible(true);
	}
	
	public void RitornoMenu(JFrame frameCorrente) {
		frameCorrente.setVisible(false);
		menu.setVisible(true);
	}
	
	public void FinestraPrecedente(JFrame frameCorrente, JFrame framePrecedente) {
		frameCorrente.setVisible(false);
		framePrecedente.setVisible(true);
	}
	
	/*Schermate Crea*/
	public void ShowTartarugaFrame() {
		menu.setVisible(false);
		finestraTart = new FinestraTartaruga(this);
		finestraTart.setVisible(true);
	}
	
	public void ShowVascaFrame() {
		menu.setVisible(false);
		finestraVasca = new FinestraVasca(this);
		finestraVasca.setVisible(true);
	}
	
	public void ShowCentroFrame() {
		menu.setVisible(false);
		finestraCentro = new FinestraCentro(this);
		finestraCentro.setVisible(true);
	}
	
	public void ShowAddettoFrame() {
		menu.setVisible(false);
		finestraAddetto = new FinestraAddetto(this);
		finestraAddetto.setVisible(true);
	}
}	
