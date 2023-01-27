package Classi;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;

import DAO.RilascioDao;
import DAO.CartellaDao;
import DAO.CentroDao;
import DAO.PersonaleDao;
import DAO.TartarugaDao;
import DAO.CiboVascaDao;
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
	FinestraStoriaTartaruga finestraStoriaTartaruga;
	FinestraStatistiche finestraStatistiche;
	FinestraRilascio finestraRilascio;
	FinestraModifica finestraModifica;
	int centroCorrente;




	private final static String url = "jdbc:postgresql://localhost:5432/DBTartarughe";
	private final static String user = "postgres";

	//private final static String password = "super"; //Temporanea
	private final static String password = "Armandoegger1_"; //Temporanea
	//private final static String password = "2597gendobus"; //Temporanea

	/*Oggetti Dao*/
	PersonaleDao personaleDao = new PersonaleDao();
	TartarugaDao tartarugaDao = new TartarugaDao();
	CartellaDao cartellaDao = new CartellaDao();
	CentroDao centroDao = new CentroDao();
	CiboVascaDao ciboVascaDao = new CiboVascaDao();
	RilascioDao rilascioDao= new RilascioDao();

	static Connection connessione;
	public int SceltaPanel;
	private String matricolaPersonale;

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
	public void AvviaMenu(String nomeAddetto,String ruoloAddetto, String matricolaPersonale) {
		this.matricolaPersonale = matricolaPersonale;
		finestraPrincipale.setVisible(false);
		menu = new MenuOperazioni(this, nomeAddetto, ruoloAddetto);
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
	public void ShowTartarugaFrame() throws SQLException {
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
		finestraCiboDato = new FinestraCiboDato(this, matricolaPersonale);
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

	public void CreaFinestraStoriaTartarughe() {
		menu.setVisible(false);
		finestraStoriaTartaruga = new FinestraStoriaTartaruga(this);
		finestraStoriaTartaruga.setVisible(true);
	}

	public void CreaFinestraStatistiche() {
		menu.setVisible(false);
		finestraStatistiche = new FinestraStatistiche(this);
		finestraStatistiche.setVisible(true);
	}

	public void CreaFinestraModifica() {

		menu.setVisible(false);
		finestraModifica = new FinestraModifica(this);
		finestraModifica.setVisible(true);
	}

	public void CreaRilascio() {
		menu.setVisible(false);
		finestraRilascio = new FinestraRilascio(this);
		finestraRilascio.setVisible(true);
	}

	/*Metodi per comunicare con gli oggetti DAO*/
	public boolean esistePersonaleDB(String matricola, String password) {

		boolean esistenza = false;

		try {
			esistenza = personaleDao.esistePersonale(matricola, password, connessione);
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

	public String getRuoloAddettoDB(String matricola) {
		String ruoloAddetto = "";

		try {
			ruoloAddetto = personaleDao.getRuoloAddetto(matricola, connessione);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ruoloAddetto;
	}

	public int getCentroAddettoDB(int centro, String matricola) {
		int centroAddetto = 0;

		try {
			centroAddetto = personaleDao.getCentroAddetto(matricola, centro, connessione);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return centroAddetto;
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

	public ArrayList<Tartaruga> getTartarugheByTargaDB(String targa){
		ArrayList<Tartaruga> listaTratrarughe= new ArrayList<Tartaruga>();

		try {
			listaTratrarughe = tartarugaDao.getTartarugheByTarga(targa, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTratrarughe;

	}


	public ArrayList<Tartaruga> getTartarugheByDateDB(String dataInizio, String dataFine){
		ArrayList<Tartaruga> listaTratrarughe= new ArrayList<Tartaruga>();

		try {
			listaTratrarughe = tartarugaDao.getTartarugheByDate(dataInizio, dataFine, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listaTratrarughe;

	}



public void getIdVasca(JComboBox comboBox){

		try {
			ciboVascaDao.recuperaId(comboBox, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public void setPesoLarghezzaLunghezzaCartella(Object id, JSpinner peso, JSpinner larghezza, JSpinner lunghezza) {
		try {
			cartellaDao.aggiornaCartellaPesoLarghezzaLunghezza(id, peso, larghezza, lunghezza, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setValutazioneCartella(Object id, JComboBox testa, JComboBox occhi, JComboBox naso, JComboBox collo, JComboBox becco, JComboBox pinne, JComboBox coda) {
		try {
			cartellaDao.aggiornaCartellaValutazione(id, testa, occhi, naso, collo, becco, pinne, coda, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setDataChiusura(Object id) {
		try {
			cartellaDao.chiudiCartella(id, connessione);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setMorte(Object id) {
		try {
			tartarugaDao.morteTartaruga(id, connessione);
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void getIdRilascio(JComboBox combobox) {
		try {
			rilascioDao.recuperaId(combobox, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void setRilascio(Object id) {
		try {
			rilascioDao.rilascio(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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

	public boolean esistenzaTargaDB(String targa) {
		boolean esistenza = false;

		try {
			esistenza = tartarugaDao.esistenzaTarga(targa, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esistenza;
	}

	public Integer tartarugheRilasciateDB(String dataInizio, String dataFine){
		Integer nTartRilasciate = 0;

		try {
			nTartRilasciate = tartarugaDao.tartarugheRilasciate(dataInizio, dataFine,connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nTartRilasciate;
	}

	public Integer tartarugheMorteDB(String dataInizio, String dataFine){
		Integer nTartMorte = 0;

		try {
			nTartMorte = tartarugaDao.tartarugheMorte(dataInizio, dataFine,connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nTartMorte;
	}

	public Integer tartarugheAmmesseDB(String dataInizio, String dataFine){
		Integer nTartAmmesse = 0;

		try {
			nTartAmmesse = tartarugaDao.tartarugheAmmesse(dataInizio, dataFine,connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return nTartAmmesse;
	}

	public void inserisciCiboDB(String tipo, Integer kgdato, Integer kgmangiati, String dataVersamento, String vascaid, String impiegatoVersamentoMatr) {
		try {
			ciboVascaDao.inserisciCibo(tipo, kgdato, kgmangiati, dataVersamento, vascaid, impiegatoVersamentoMatr,connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Integer getCiboVersatoDB(String dataInizio, String dataFine) {

		Integer kgCiboVersato = 0;

		try {
			kgCiboVersato = ciboVascaDao.getCiboVersato(dataInizio, dataFine, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kgCiboVersato;
	}
	public Integer getCiboMangiatoDB(String dataInizio, String dataFine) {
		Integer kgCiboMangiato= 0;

		try {
			kgCiboMangiato = ciboVascaDao.getCiboMangiato(dataInizio, dataFine, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return kgCiboMangiato;
	}


	public void InvioTartaruga(String targa, String nome, boolean primoaccesso, boolean morta,
	boolean rilasciata, String vascaid, String cartellaid, int centroid) throws SQLException {

		tartarugaDao.tartarugaEntrataNelCentro(connessione, targa, nome, primoaccesso, morta, rilasciata, vascaid, cartellaid, centroid);

	}
	public int getCentroCorrente() {
		return centroCorrente;
	}
	public void setCentroCorrente(int centroCorrente) {
		this.centroCorrente = centroCorrente;
	}

	public int getTargaMaxDB() throws SQLException {
		return tartarugaDao.getTargaMax(connessione);
	}
		
	public String getNomeById(Object id) {
		String nome="";

		try {
			nome=tartarugaDao.recuperaNome(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nome;
	}

	public String getTargaById(Object id) {
		String targa="";

		try {
			targa=tartarugaDao.recuperaTarga(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return targa;
	}

	public String getSpecieById(Object id) {
		String specie="";

		try {
			specie=tartarugaDao.recuperaSpecie(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return specie;
	}


	public String getLuogoById(Object id) {
		String luogo="";

		try {
			luogo=tartarugaDao.recuperaLuogo(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return luogo;
	}

	public void setNomeTarga(Object id, String nome, String targa) {
		try {
			tartarugaDao.aggiornaNomeTarga(id, nome, targa, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setSessoSpecieLuogo(Object id, String specie, String luogo, JRadioButton btn1, JRadioButton btn2) {

		if(btn1.isSelected()) {
			String sesso="Maschio";
		try {
			tartarugaDao.aggiornaSessoSpecieLuogo(id, sesso, specie, luogo, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		} else if(btn2.isSelected()) {
			String sesso="Femmina";
			try {
				tartarugaDao.aggiornaSessoSpecieLuogo(id, sesso, specie, luogo, connessione);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selezionaBottone(Object id, JRadioButton btn1, JRadioButton btn2) {
		String sesso="";

		try {
			sesso=tartarugaDao.recuperaSesso(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (sesso.equals("Maschio")) {
			btn1.setSelected(true);
		} else if (sesso.equals("Femmina")){
			btn2.setSelected(true);
		}
	}

	public void eliminaTartaruga(Object id) {
		try {
			tartarugaDao.elimina(id, connessione);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
