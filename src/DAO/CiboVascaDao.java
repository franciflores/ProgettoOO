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
	
	public void inserisciCibo(String tipo, Integer kgdato, Integer kgmangiati, String vascaid, String dataVersamento, String impiegatoVersamentoMatr, Connection connessioneDB) throws SQLException {
		
		String sqlQueryCibo = "insert into cibo(tipo, kgdato, kgmangiati, vascaid, dataversamento, impiegatoversamentomatr) values ('"+tipo+"',"+kgdato+","+kgmangiati+",'"+vascaid+"','"+dataVersamento+"', '"+impiegatoVersamentoMatr+"');";
		Statement query = connessioneDB.createStatement();
		query.executeUpdate(sqlQueryCibo);
		
		
	}
	
}
