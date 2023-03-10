package DAO;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;


public class CartellaDao {
	
	public void recuperaId(JComboBox comboBox, Connection connessioneDB) throws SQLException{
		
		String sqlQueryId = "Select tartarugaid from cartellamedica where dataChiusura is null;";
		
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
	
	public void aggiornaCartellaPesoLarghezzaLunghezza(Object id, JSpinner peso, JSpinner larghezza, JSpinner lunghezza, Connection connessioneDB) throws SQLException{
		String sqlQuery = "Update cartellamedica set peso='"+peso.getValue()+"', larghezza='"+larghezza.getValue()+"', lunghezza='"+lunghezza.getValue()+"' where tartarugaid= '"+ id +"';";
		
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
	}
	
	public void aggiornaCartellaValutazione(Object id, JComboBox testa, JComboBox occhi, JComboBox naso, JComboBox collo, JComboBox becco, JComboBox pinne, JComboBox coda, Connection connessioneDB) throws SQLException{
		String sqlQuery = "Update cartellamedica set testa='"+ testa.getSelectedItem()+"', occhi='"+occhi.getSelectedItem()+"', naso='"+naso.getSelectedItem()+"', collo='"+collo.getSelectedItem()+"', becco='"+becco.getSelectedItem()+"', pinne='"+pinne.getSelectedItem()+"', coda='"+coda.getSelectedItem()+"'where tartarugaid='"+id+"';";
		
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
	}
	
	public void chiudiCartella(Object id, String data, Connection connessioneDB) throws SQLException{
		String sqlQuery = "Update cartellamedica set dataChiusura='"+data+"' where  tartarugaid= '"+id+"';";
		
		Statement query = connessioneDB.createStatement();
		int rs = query.executeUpdate(sqlQuery);
	}

	public void CreaCartella(String specie, Integer valorePeso, Integer valoreLarghezza, Integer valoreLunghezza, String luogo, String condTesta, String condOcchi,
			String condNaso, String condCollo, String condPinne, String condCoda, String sesso, String condBecco, String ultimaTargaId, String ultimaTartarugaId, String matricola, Connection connessioneDB) throws SQLException {
		
        LocalDate dataObj = LocalDate.now();
        DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String data = dataObj.format(formattazioneData);
		
		String sqlQuery = "INSERT INTO cartellamedica(dataapertura, dataritrovamento, peso, larghezza, specie, sesso, descrizione, testa, pinne, occhi, naso, becco, collo, coda, personaleid, targaid, tartarugaid, lunghezza)" 
				+ "VALUES('"+data+"','"+data+"', "+valorePeso+", "+valoreLarghezza+",'"+specie+"','"+sesso+"','"+luogo+"','"+condTesta+"','"+condPinne+"','"+condOcchi+"','"+condNaso+"','"+condBecco+"','"+condCollo+"','"+condCoda+"','"+matricola+"','"+ultimaTargaId+"',"+ultimaTartarugaId+","+valoreLunghezza+");";
		
		Statement queryCart = connessioneDB.createStatement();
		queryCart.executeUpdate(sqlQuery);
	}
	
	public String ultimaCartellaInserita(Connection connessioneDB) throws SQLException {
		String id = null;
		
		String sqlQuery = "Select id from cartellamedica;";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		/*Ciclo fino all'ultimo id*/
		while(rs.next()) {
			id = rs.getString("id");
		}
		
		return id;
	}
	
	public String getSessoByIdTartaruga(String idTartarugaByTarga, Connection connessioneDB) throws SQLException {
		String sesso="";
		String sqlQuery = "Select sesso from cartellamedica where tartarugaid  = '" + idTartarugaByTarga + "';";

		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);

		if(rs.next()) {
			sesso = rs.getString("sesso");
		}

		return sesso;
	}
	
}
