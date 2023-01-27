package DAO;

import java.awt.TextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Classi.CartellaMedica;
import Classi.Tartaruga;

public class TartarugaDao {

	public ArrayList<Tartaruga> getTartarugheByCentro(String idCentro, Connection connessioneDB) throws SQLException {
		 	ArrayList<Tartaruga> listaTartarughe = new ArrayList<Tartaruga>();
		 	Tartaruga tartarugaCorrente = new Tartaruga();
		 	CartellaMedica cartellaCorrente;


		 	String sqlQueryTartaruga = "select * from tartaruga, cartellamedica where tartaruga.id = cartellamedica.tartarugaid and centroid = '" + idCentro + "';";


			Statement queryTart = connessioneDB.createStatement();
			ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);


			/*Se l'oggetto result set non � vuoto allora esiste un addetto con queste caratteristiche*/
			while(rsTart.next()) {
				/*Creazione Tartaruga*/
				tartarugaCorrente.setTarga(rsTart.getString("targa"));
				tartarugaCorrente.setNomeTartaruga(rsTart.getString("nome"));

				/*Creazione Cartella associata*/
				cartellaCorrente = new CartellaMedica(tartarugaCorrente);
				cartellaCorrente.setLarghezzaTartaruga(rsTart.getInt("larghezza"));
				cartellaCorrente.setPesoTartaruga(rsTart.getInt("peso"));
				cartellaCorrente.setLunghezzaTartaruga(rsTart.getInt("lunghezza"));
				cartellaCorrente.setLuogoRitrovamento(rsTart.getString("descrizione"));
				cartellaCorrente.setSpecieTartaruga(rsTart.getString("specie"));
				tartarugaCorrente.setCartellaTartaruga(cartellaCorrente);

				/*Aggiunta alla tartaruga le info relative ai suoi arti*/
				tartarugaCorrente.setDescrizioneStatoBecco(rsTart.getString("becco"));
				tartarugaCorrente.setDescrizioneStatoCoda(rsTart.getString("coda"));
				tartarugaCorrente.setDescrizioneStatoCollo(rsTart.getString("collo"));
				tartarugaCorrente.setDescrizioneStatoNaso(rsTart.getString("naso"));
				tartarugaCorrente.setDescrizioneStatoOcchi(rsTart.getString("occhi"));
				tartarugaCorrente.setDescrizioneStatoPinne(rsTart.getString("pinne"));
				tartarugaCorrente.setDescrizioneStatoTesta(rsTart.getString("testa"));

				/*Tartaruga aggiunta in lista*/
				listaTartarughe.add(tartarugaCorrente);
			}


		return listaTartarughe;
	}

	public boolean esistenzaTarga(String targa, Connection connessioneDB) throws SQLException {

		boolean exist = false;
		String sqlQuery = "select targa from tartaruga where targa = '"+targa +"';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		/*Se l'oggetto result set non e' vuoto allora esiste una targa*/
		if(rs.next()) {
			exist = true;
		}
		return exist;

	}

	public ArrayList<Tartaruga> getTartarugheByTarga(String targa, Connection connessioneDB) throws SQLException {
	 	ArrayList<Tartaruga> listaTartarughe = new ArrayList<Tartaruga>();

	 	CartellaMedica cartellaCorrente;


	 	String sqlQueryTartaruga = "select * from tartaruga, cartellamedica where tartaruga.id = cartellamedica.tartarugaid and tartaruga.targa = '" + targa + "';";


		Statement queryTart = connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);



		while(rsTart.next()) {
			Tartaruga tartarugaCorrente = new Tartaruga();

			/*Creazione Tartaruga*/
			tartarugaCorrente.setTarga(rsTart.getString("targa"));
			tartarugaCorrente.setNomeTartaruga(rsTart.getString("nome"));

			/*Creazione Cartella associata*/
			cartellaCorrente = new CartellaMedica(tartarugaCorrente);
			cartellaCorrente.setLarghezzaTartaruga(rsTart.getInt("larghezza"));
			cartellaCorrente.setPesoTartaruga(rsTart.getInt("peso"));
			cartellaCorrente.setLunghezzaTartaruga(rsTart.getInt("lunghezza"));
			cartellaCorrente.setLuogoRitrovamento(rsTart.getString("descrizione"));
			cartellaCorrente.setSpecieTartaruga(rsTart.getString("specie"));
			tartarugaCorrente.setCartellaTartaruga(cartellaCorrente);

			/*Aggiunta alla tartaruga le info relative ai suoi arti*/
			tartarugaCorrente.setDescrizioneStatoBecco(rsTart.getString("becco"));
			tartarugaCorrente.setDescrizioneStatoCoda(rsTart.getString("coda"));
			tartarugaCorrente.setDescrizioneStatoCollo(rsTart.getString("collo"));
			tartarugaCorrente.setDescrizioneStatoNaso(rsTart.getString("naso"));
			tartarugaCorrente.setDescrizioneStatoOcchi(rsTart.getString("occhi"));
			tartarugaCorrente.setDescrizioneStatoPinne(rsTart.getString("pinne"));
			tartarugaCorrente.setDescrizioneStatoTesta(rsTart.getString("testa"));

			/*Tartaruga aggiunta in lista*/
			listaTartarughe.add(tartarugaCorrente);
		}


		return listaTartarughe;
	}

	public Integer tartarugheRilasciate(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException{
		Integer nTartRilasciate = 0;

		String sqlQueryTartaruga = "Select count(cartellamedica.tartarugaid) as numerorilasciate From cartellamedica join tartaruga on cartellamedica.tartarugaid=tartaruga.id Where datachiusura>='"+dataInizio+"' and datachiusura<='"+dataFine+"' and tartaruga.rilasciata='true';";


		Statement queryTart = connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);

		while(rsTart.next()) {

			nTartRilasciate = rsTart.getInt("numerorilasciate");

		}

		return nTartRilasciate;
	}

	public Integer tartarugheMorte(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException{
		Integer nTartMorte = 0;

		String sqlQueryTartaruga = "Select count(cartellamedica.tartarugaid) as numeromorte From cartellamedica join tartaruga on cartellamedica.tartarugaid=tartaruga.id Where datachiusura>='"+dataInizio+"' and datachiusura<='"+dataFine+"' and tartaruga.morta='true';";


		Statement queryTart = connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);

		while(rsTart.next()) {

			nTartMorte = rsTart.getInt("numeromorte");

		}

		return nTartMorte;
	}

	public Integer tartarugheAmmesse(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException{
		Integer nTartAmmesse = 0;

		String sqlQueryTartaruga = "Select count (tartarugaid) as numeroammesse From cartellamedica Where cartellamedica.dataapertura >='"+dataInizio+"' and cartellamedica.dataapertura<='"+dataFine+"';";


		Statement queryTart = connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);

		while(rsTart.next()) {

			nTartAmmesse = rsTart.getInt("numeroammesse");

		}

		return nTartAmmesse;
	}

	public void morteTartaruga(Object id, Connection connessioneDB) throws SQLException{

		String queryMorte="Update tartaruga set morta='true' where id='"+id+"';";
		Statement query = connessioneDB.createStatement();
		query.executeUpdate(queryMorte);
	}

	public ArrayList<Tartaruga> getTartarugheByDate(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException {
	 	ArrayList<Tartaruga> listaTartarughe = new ArrayList<Tartaruga>();

	 	CartellaMedica cartellaCorrente;

	 	/*select * from tartaruga, cartellamedica where tartaruga.id = cartellamedica.tartarugaid and cartellamedica.dataapertura >= '2021-01-23' and cartellamedica.dataapertura <= '2023-01-23';*/


	 	String sqlQueryTartaruga = "select * from tartaruga, cartellamedica where tartaruga.id = cartellamedica.tartarugaid and cartellamedica.dataapertura >= '" + dataInizio + "'and cartellamedica.dataapertura <= '"+ dataFine +"';";


		Statement queryTart = connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);



		while(rsTart.next()) {
			Tartaruga tartarugaCorrente = new Tartaruga();

			/*Creazione Tartaruga*/
			tartarugaCorrente.setTarga(rsTart.getString("targa"));
			tartarugaCorrente.setNomeTartaruga(rsTart.getString("nome"));

			/*Creazione Cartella associata*/
			cartellaCorrente = new CartellaMedica(tartarugaCorrente);
			cartellaCorrente.setLarghezzaTartaruga(rsTart.getInt("larghezza"));
			cartellaCorrente.setPesoTartaruga(rsTart.getInt("peso"));
			cartellaCorrente.setLunghezzaTartaruga(rsTart.getInt("lunghezza"));
			cartellaCorrente.setLuogoRitrovamento(rsTart.getString("descrizione"));
			cartellaCorrente.setSpecieTartaruga(rsTart.getString("specie"));
			tartarugaCorrente.setCartellaTartaruga(cartellaCorrente);

			/*Aggiunta alla tartaruga le info relative ai suoi arti*/
			tartarugaCorrente.setDescrizioneStatoBecco(rsTart.getString("becco"));
			tartarugaCorrente.setDescrizioneStatoCoda(rsTart.getString("coda"));
			tartarugaCorrente.setDescrizioneStatoCollo(rsTart.getString("collo"));
			tartarugaCorrente.setDescrizioneStatoNaso(rsTart.getString("naso"));
			tartarugaCorrente.setDescrizioneStatoOcchi(rsTart.getString("occhi"));
			tartarugaCorrente.setDescrizioneStatoPinne(rsTart.getString("pinne"));
			tartarugaCorrente.setDescrizioneStatoTesta(rsTart.getString("testa"));

			/*Tartaruga aggiunta in lista*/
			listaTartarughe.add(tartarugaCorrente);
		}


		return listaTartarughe;
	}

	public void tartarugaEntrataNelCentro(Connection connessioneDB, String targa, String nome, boolean primoaccesso,
			boolean morta, boolean rilasciata, String vascaid, String cartellaid, int centroid) throws SQLException {


			String sqlInsertTartarugaInserita = "insert into tartaruga values ('" +targa+"','"+nome+"','"+primoaccesso+"','"+morta+"','"
			+rilasciata+"','"+vascaid+"','"+centroid+"');";

			Statement queryTart = connessioneDB.createStatement();
			int rsTart = queryTart.executeUpdate(sqlInsertTartarugaInserita);
		}

	public int getTargaMax(Connection connessioneDB) throws SQLException {
		int numTarga = 0;
		String sqlTarga ="select max(targa) from tartaruga having max(targa)>0";
		Statement queryTart= connessioneDB.createStatement();
		ResultSet rsTart = queryTart.executeQuery(sqlTarga);
		if(rsTart.next())
			numTarga = rsTart.getInt(1);
		return numTarga;
	}


	public String recuperaNome(Object id, Connection connessioneDB) throws SQLException {
		String nome="";
		String sqlQuery = "Select nome from tartaruga where id  = '" + id + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			nome = rs.getString("nome");
		}

		return nome;
	}

	public String recuperaTarga(Object id, Connection connessioneDB) throws SQLException {
		String targa="";
		String sqlQuery = "Select targa from tartaruga where id  = '" + id + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			targa = rs.getString("targa");
		}

		return targa;
	}

	public String recuperaSesso(Object id, Connection connessioneDB) throws SQLException {
		String sesso="";
		String sqlQuery = "Select sesso from cartellamedica where tartarugaid  = '" + id + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			sesso = rs.getString("sesso");
		}

		return sesso;
	}

	public String recuperaSpecie(Object id, Connection connessioneDB) throws SQLException {
		String specie="";
		String sqlQuery = "Select specie from cartellamedica where tartarugaid  = '" + id + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			specie = rs.getString("specie");
		}

		return specie;
	}

	public String recuperaLuogo(Object id, Connection connessioneDB) throws SQLException {
		String luogo="";
		String sqlQuery = "Select descrizione from cartellamedica where tartarugaid  = '" + id + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			luogo = rs.getString("descrizione");
		}

		return luogo;
	}

	public void aggiornaNomeTarga(Object id, String Nome, String Targa,  Connection connessioneDB) throws SQLException {
		String sqlQuery ="Update tartaruga set nome='"+Nome+"', targa='"+Targa+"' where id='"+id+"';";
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
	}

	public void aggiornaSessoSpecieLuogo(Object id, String Sesso, String Specie, String Luogo, Connection connessioneDB) throws SQLException {
		String sqlQuery ="Update cartellamedica set sesso='"+Sesso+"', specie='"+Specie+"', descrizione='"+Luogo+"' where tartarugaid='"+id+"';";
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
	}

	public void elimina(Object id, Connection connessioneDB) throws SQLException{
		String sqlQuery="Delete from cartellamedica where tartarugaid='"+id+"';";
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
		String sqlQuery2="Delete from tartaruga where id='"+id+"';";
		rs = query.executeUpdate(sqlQuery2);
	}

	}
