package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JComboBox;

public class VascaDao {
	

public ArrayList<String> recuperaVascaId(Connection connessioneDB) throws SQLException{
		
		String sqlQueryId = "Select id from vasca where piena= 'false';";
		ArrayList<String> vascheDisponibili = new ArrayList<String>();
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryId);
		
		while(rs.next()) {
			vascheDisponibili.add(rs.getString("id"));
		}
		return vascheDisponibili;
		
	}

}
