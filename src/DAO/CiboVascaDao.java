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

	public Integer getCiboVersato(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException {
		
		Integer kgDatoTot = 0;
		String sqlQuery = "select sum(kgdato) as kgdatotot from cibo where dataversamento >= '"+dataInizio+"' and dataversamento <= '"+dataFine+"';";
		
		Statement queryCibo = connessioneDB.createStatement();
		ResultSet rsCibo = queryCibo.executeQuery(sqlQuery);
		
		while(rsCibo.next()) {
			
			kgDatoTot = rsCibo.getInt("kgdatotot");
			
		}
		return kgDatoTot;
	}

	public Integer getCiboMangiato(String dataInizio, String dataFine, Connection connessioneDB) throws SQLException {
		Integer kgMangiatoTot = 0;
		String sqlQuery = "select sum(kgmangiati) as kgdmangiatotot from cibo where dataversamento >= '"+dataInizio+"' and dataversamento <= '"+dataFine+"';";
		
		Statement queryCibo = connessioneDB.createStatement();
		ResultSet rsCibo = queryCibo.executeQuery(sqlQuery);
		
		while(rsCibo.next()) {
			
			kgMangiatoTot = rsCibo.getInt("kgdmangiatotot");
			
		}
		return kgMangiatoTot;
	}
	
}
