package DAO;

import java.sql.*;

import javax.swing.JComboBox;

public class CiboVascaDao {

	public void recuperaId(JComboBox comboBox, Connection connessioneDB) throws SQLException{
		
		String sqlQueryId = "Select id from vasca;";
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryId);
		
		while(rs.next()) {
			comboBox.addItem((rs.getString("id")));
		}
		
	}
	
}
