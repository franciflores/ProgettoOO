package DAO;

import java.sql.*;

import javax.swing.JComboBox;


public class CartellaDao {
	
	public void recuperaId(JComboBox comboBox, Connection connessioneDB) throws SQLException{
		
		String sqlQueryId = "Select tartarugaid from cartellamedica;";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryId);
		
		while(rs.next()) {
			comboBox.addItem((rs.getString("tartarugaid")));
		}
		
	}
	
	public int recuperaPeso(Object id, Connection connessioneDB) throws SQLException{
		int peso=0;
		String sqlQuery = "Select peso from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			peso = rs.getInt("peso");
		}
		
		return peso;
	}
	
	public int recuperaLarghezza(Object id, Connection connessioneDB) throws SQLException{
		int larghezza=0;
		String sqlQuery = "Select larghezza from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			larghezza = rs.getInt("larghezza");
		}
		
		return larghezza;
	}
	
	public int recuperaLunghezza(Object id, Connection connessioneDB) throws SQLException{
		int lunghezza=0;
		String sqlQuery = "Select lunghezza from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			lunghezza = rs.getInt("lunghezza");
		}
		
		return lunghezza;
	}
	
	public String recuperaTesta(Object id, Connection connessioneDB) throws SQLException{
		String testa="";
		String sqlQuery = "Select testa from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			testa = rs.getString("testa");
		}
		
		return testa;
	}
	
	public String recuperaOcchi(Object id, Connection connessioneDB) throws SQLException{
		String occhi="";
		String sqlQuery = "Select occhi from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			occhi = rs.getString("occhi");
		}
		
		return occhi;
	}
	
	public String recuperaNaso(Object id, Connection connessioneDB) throws SQLException{
		String naso="";
		String sqlQuery = "Select naso from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			naso = rs.getString("naso");
		}
		
		return naso;
	}
	
	public String recuperaBecco(Object id, Connection connessioneDB) throws SQLException{
		String becco="";
		String sqlQuery = "Select becco from cartellamedica where tartarugaid  = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			becco = rs.getString("becco");
		}
		
		return becco;
	}
	
	public String recuperaCollo(Object id, Connection connessioneDB) throws SQLException{
		String collo="";
		String sqlQuery = "Select collo from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			collo = rs.getString("collo");
		}
		
		return collo;
	}
	
	public String recuperaPinne(Object id, Connection connessioneDB) throws SQLException{
		String pinne="";
		String sqlQuery = "Select pinne from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			pinne = rs.getString("pinne");
		}
		
		return pinne;
	}
	
	public String recuperaCoda(Object id, Connection connessioneDB) throws SQLException{
		String coda="";
		String sqlQuery = "Select coda from cartellamedica where tartarugaid = '" + id + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			coda = rs.getString("coda");
		}
		
		return coda;
	}
	
}
