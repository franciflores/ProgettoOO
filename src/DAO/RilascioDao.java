package DAO;

import java.sql.*;

import javax.swing.JComboBox;

public class RilascioDao {

	public void recuperaIdTartViva(JComboBox comboBox, Connection connessioneDB) throws SQLException{
			
			String sqlQueryId = "select id from tartaruga where morta='false' and rilasciata = 'false';";
			
			Statement query = connessioneDB.createStatement();
			ResultSet rs = query.executeQuery(sqlQueryId);
			
			while(rs.next()) {
				comboBox.addItem((rs.getString("id")));
			}
			
			
		}
	
	public boolean recuperaDataChiusura(Connection connessioneDB, String id) throws SQLException{
		
		boolean risultato=false;
		
		String sqlQueryId = "select dataChiusura from cartellamedica where cartellamedica.tartarugaid='"+ id +"' and dataChiusura is not null;";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryId);
		
		/*Esiste una dataChiusura?*/
		if(rs.next()) {
			risultato = true;
		}
		return risultato;
		
	}

	public void rilascio(Object id, Connection connessioneDB) throws SQLException{
		
		String sqlQuery= "Update tartaruga set rilasciata='true' where id='"+id.toString()+"';";
		Statement query = connessioneDB.createStatement();
		query.executeUpdate(sqlQuery);
	}
}
