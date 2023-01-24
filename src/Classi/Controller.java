package Classi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DAO.CartellaDao;
import DAO.CentroDao;
import DAO.PersonaleDao;
import DAO.TartarugaDao;
import GUI.*;


public class Controller {

	//Dichiarazioni dei Frame
	FinestraLogin finestraPrincipale;
	MenuOperazioni menu;
	FinestraTartaruga finestraTart;
	FinestraVasca finestraVasca;
	FinestraCentro finestraCentro;
	FinestraCartella finestraCartellaMedica;
	FinestraCiboDato finestraCiboDato;
	FinestraListaTartarugheCentro finestraListaTartarugheCentro;


	private final static String url = "jdbc:postgresql://localhost:5432/DBTartarughe";
	private final static String user = "postgres";
	private final static String password = "Armandoegger1_"; //Temporanea
	
	/*Oggetti Dao*/
	PersonaleDao personaleDao = new PersonaleDao();
	TartarugaDao tartarugaDao = new TartarugaDao();
	CartellaDao cartellaDao = new CartellaDao();
	CentroDao centroDao = new CentroDao();

	static Connection connessione;
	public int SceltaPanel;

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
	//Costruttore del Controller
	public Controller() {
		finestraPrincipale = new FinestraLogin(this);
		finestraPrincipale.setVisible(true);
	}

	/**Crea e passa alla finestra del Menu
	 * @param professione **/
	public void AvviaMenu(String nomeAddetto, String professione) {
		finestraPrincipale.setVisible(false);
		menu = new MenuOperazioni(this, nomeAddetto, professione);
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
	
	public void ApriFinestraCibo() {
		menu.setVisible(false);
		finestraCiboDato = new FinestraCiboDato(this);
		finestraCiboDato.setVisible(true);
	}

	public void CreaCartella() {
		menu.setVisible(false);
		finestraCartellaMedica = new FinestraCartella(this);
		finestraCartellaMedica.setVisible(true);
	}
	
	public void CreaFinestraListaTartarugheCentro() {
		menu.setVisible(false);
		finestraListaTartarugheCentro = new FinestraListaTartarugheCentro(this);
		finestraListaTartarugheCentro.setVisible(true);
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
	
	/*Metodi per comunicare con gli oggetti DAO*/
	public boolean esistePersonaleDB(String matricola, String professione, String password) {
		
		boolean esistenza = false;
		
		try {
			esistenza = personaleDao.esistePersonale(matricola, professione, password, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return esistenza;
	}
	
	public String getNomeByMatricolaDB(String matricola) {
		String nomeAddetto = "";
		
		try {
			nomeAddetto = personaleDao.getNomeByMatricola(matricola, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nomeAddetto;
	}
	
	public ArrayList<Tartaruga> getTartarugheByCentroDB(String idCentro){
		ArrayList<Tartaruga> listaTratrarughe= new ArrayList<Tartaruga>();
		
		try {
			listaTratrarughe = tartarugaDao.getTartarugheByCentro(idCentro, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaTratrarughe;
		
	}
	
	public void getId(JComboBox comboBox){
		
		try {
			cartellaDao.recuperaId(comboBox, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int getPesoById(Object id) {
		int peso=0;
		
		try {
			peso=cartellaDao.recuperaPeso(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return peso;
	}
	
	public int getLarghezzaById(Object id) {
		int larghezza=0;
		
		try {
			larghezza=cartellaDao.recuperaLarghezza(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return larghezza;
	}
	
	public int getLunghezzaById(Object id) {
		int lunghezza=0;
		
		try {
			lunghezza=cartellaDao.recuperaLunghezza(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return lunghezza;
	}
	
	public String getTestaById(Object id) {
		String testa="";
		
		try {
			testa=cartellaDao.recuperaTesta(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return testa;
	}
	
	public String getOcchiById(Object id) {
		String occhi="";
		
		try {
			occhi=cartellaDao.recuperaOcchi(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return occhi;
	}
	
	public String getNasoById(Object id) {
		String naso="";
		
		try {
			naso=cartellaDao.recuperaNaso(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return naso;
	}
	
	public String getBeccoById(Object id) {
		String becco="";
		
		try {
			becco=cartellaDao.recuperaBecco(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return becco;
	}
	
	public String getColloById(Object id) {
		String collo="";
		
		try {
			collo=cartellaDao.recuperaCollo(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return collo;
	}
	
	public String getPinneById(Object id) {
		String pinne="";
		
		try {
			pinne=cartellaDao.recuperaPinne(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pinne;
	}
	
	public String getCodaById(Object id) {
		String coda="";
		
		try {
			coda=cartellaDao.recuperaCoda(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return coda;
	}
	
	public boolean esisteCentroDB(String centroId) {
		
		boolean esistenza = false;
		
		try {
			esistenza = centroDao.esistenzaCentro(centroId, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return esistenza;
	}
	
}
