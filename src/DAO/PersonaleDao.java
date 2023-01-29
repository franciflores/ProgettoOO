package DAO;

import java.sql.*;

public class PersonaleDao {
	
	public boolean esistePersonale(String matricola, String password,  Connection connessioneDB) throws SQLException {
		
		String sqlQuery = "Select * from personale where matricola = '" + matricola + "' and password = '" + password + "' ;";
		boolean exist = false;
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		/*Se l'oggetto result set non � vuoto allora esiste un addetto con queste caratteristiche*/
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
		
		/*Se l'oggetto result set non � vuoto allora recupero il nome dell'addetto*/
		if(rs.next()) {
			nomeAddetto = rs.getString("nome");
		}
		
		return nomeAddetto;
	}



	public String getRuoloAddetto(String matricola, Connection connessioneDB) throws SQLException {
		String ruoloAddetto = "";
		String sqlQuery = "Select professione from personale where matricola = '" + matricola + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next())
			ruoloAddetto=rs.getString("professione");
		
		return ruoloAddetto; 
	}
	
	public String getCentroAddetto(String matricola, Connection connessioneDB) throws SQLException {
		String centroIdAddetto = "";
		String sqlQuery = "Select centroid from personale where matricola = '" + matricola + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next())
			centroIdAddetto=rs.getString("centroid");
		
		return centroIdAddetto; 
	}
}
