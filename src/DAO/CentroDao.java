package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CentroDao {
	
	public boolean esistenzaCentro(String centroId, Connection connessioneDB) throws SQLException {
		
		boolean exist = false;
		String sqlQuery = "select id from centro where id = '"+centroId +"';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		/*Se l'oggetto result set non � vuoto allora esiste un addetto con queste caratteristiche*/
		if(rs.next()) {
			exist = true;
		}
		return exist;
		
	}

}
