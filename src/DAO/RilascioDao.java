package DAO;

import java.sql.*;

import javax.swing.JComboBox;

public class RilascioDao {

public void recuperaId(JComboBox comboBox, Connection connessioneDB) throws SQLException{
		
		String sqlQueryId = "Select cartellamedica.tartarugaid from cartellamedica join tartaruga on cartellamedica.tartarugaid=tartaruga.id where tartaruga.morta= 'false' and tartaruga.rilasciata='false';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryId);
		
		while(rs.next()) {
			comboBox.addItem((rs.getString("tartarugaid")));
		}
		
	}

public void rilascio(Object id, Connection connessioneDB) throws SQLException{
	
	String sqlQuery= "Update tartaruga set rilasciata='true' where id='"+id+"';";
	Statement query = connessioneDB.createStatement();
	query.executeUpdate(sqlQuery);
}
}
