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
	
	public static void main(String[] args)
	{
		Controller c = new Controller();			
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
}	
