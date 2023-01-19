package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import GUI.*;

public class Controller {

	//Dichiarazioni dei Frame
	public int SceltaPanel;
	FinestraLogin finestraPrincipale;
	MenuOperazioni menu;
	FinestraTartaruga finestraTart;
	FinestraVasca finestraVasca;
	FinestraCentro finestraCentro;
	FinestraCartella finestraCartellaMedica;
	

	private final static String url = "jdbc:postgresql://localhost:5432/DBTartarughe";
	private final static String user = "postgres";
	private final static String password = "Armandoegger1_"; //Temporanea

	static Connection connessione;

	public static void main(String[] args)
	{
		//try {
		//	connessione = DriverManager.getConnection(url, user, password);
			Controller c = new Controller();
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		}

//}
	//Costruttore del Controller
	public Controller() {
		finestraPrincipale = new FinestraLogin(this);
		finestraPrincipale.setVisible(true);
	}

	/**Crea e passa alla finestra del Menu**/
	public void AvviaMenu() {
		finestraPrincipale.setVisible(false);
		menu = new MenuOperazioni(this);
		menu.setVisible(true);
	}

	/**Torniamo alla finestra del Menu**/
	public void RitornoMenu(JFrame frameCorrente) {
		frameCorrente.setVisible(false);
		menu.setVisible(true);
	}

	/**Serve a tornare alla finestra Precedente**/
	public void FinestraPrecedente(JFrame frameCorrente, JFrame framePrecedente) {
		frameCorrente.setVisible(false);
		framePrecedente.setVisible(true);
	}

	public int DialogTartarughe() {
		 return JOptionPane.showConfirmDialog(null,"La Tartaruga è già stata nel centro?","Opzione",0,3);
	}

	//Apri finestraTartarughe
	public void ShowTartarugaFrame() {
		menu.setVisible(false);
		finestraTart = new FinestraTartaruga(this,SceltaPanel,menu);
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


	public void ProceduraTerminata(JFrame frame) {
		JOptionPane.showConfirmDialog(frame, "Congratulazioni, inserimento completato!", "Procedura Terminata", JOptionPane.OK_OPTION);
	}

	public void CreaCartella() {
		menu.setVisible(false);
		finestraCartellaMedica = new FinestraCartella(this);
		finestraCartellaMedica.setVisible(true);
	}


	public void CreaCartella(String specie, Float peso, Float lunghezza, Float larghezza) throws SQLException {
		Statement st = connessione.createStatement();
		st.executeUpdate("INSERT INTO  cartellemediche(specietartaruga, lunghezzatartaruga, larghezzatartaruga, pesotartaruga) VALUES \n"
				+ "('"+specie+"', '"+lunghezza+"', '"+larghezza+"', '"+peso+"')");
	}

	//Chiude il Menu e torna al login (Resetta la finestra di Login)
	public void RitornoAlLogin() {
		menu.dispose();
		finestraPrincipale = null;
		finestraPrincipale = new FinestraLogin(this);
		finestraPrincipale.setVisible(true);
	}
	public void ShowCartellaFrame() {
		menu.setVisible(false);
		finestraCartellaMedica = new FinestraCartella(this);
		finestraCartellaMedica.setVisible(true);
	}
	
	
}
