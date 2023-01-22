package DAO;

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
		 
		 	
		 	String sqlQueryTartaruga = "select * from tartaruga, cartellamedica where tartaruga.cartellaid = cartellamedica.id and centroid = '" + idCentro + "';";
		 	
		 
			Statement queryTart = connessioneDB.createStatement();
			ResultSet rsTart = queryTart.executeQuery(sqlQueryTartaruga);
			
			
			/*Se l'oggetto result set non è vuoto allora esiste un addetto con queste caratteristiche*/
			while(rsTart.next()) {
				/*Creazione Tartaruga*/
				tartarugaCorrente.setTarga(rsTart.getString("targa"));
				tartarugaCorrente.setNomeTartaruga(rsTart.getString("nome"));
				
				/*Creazione Cartella associata*/
				cartellaCorrente = new CartellaMedica(tartarugaCorrente);
				cartellaCorrente.setLarghezzaTartaruga(rsTart.getInt("larghezza"));
				cartellaCorrente.setPesoTartaruga(rsTart.getInt("peso"));
				//cartellaCorrente.setLunghezzaTartaruga(rsTart.getInt("lunghezza"));
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


}
