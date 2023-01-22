package DAO;

import java.sql.*;

public class PersonaleDao {
	
	public boolean esistePersonale(String matricola, String ruolo, Connection connessioneDB) throws SQLException {
		
		String sqlQuery = "Select * from personale where professione = '" + ruolo + "' and matricola = '" + matricola + "';";
		boolean exist = false;
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		/*Se l'oggetto result set non è vuoto allora esiste un addetto con queste caratteristiche*/
		if(rs.next()) {
			exist = true;
		}
		
		return exist;
		
	}
	
	public String getNomeByMatricola(String matricola, Connection connessioneDB) throws SQLException {
		String nomeAddetto = "";
		String sqlQuery = "Select nome from personale where matricola = '" + matricola + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		/*Se l'oggetto result set non è vuoto allora recupero il nome dell'addetto*/
		if(rs.next()) {
			nomeAddetto = rs.getString("nome");
		}
		
		return nomeAddetto;
	}

}
