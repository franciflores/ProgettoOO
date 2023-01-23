package DAO;

import java.sql.*;
import java.util.ArrayList;

import javax.swing.JComboBox;

import Classi.Tartaruga;
import Classi.CartellaMedica;

public class CartellaDao {
	
	public void recuperaTarghe(JComboBox comboBox, Connection connessioneDB) throws SQLException{
		
		String sqlQueryTarghe = "Select tartarugatarga from cartellamedica;";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQueryTarghe);
		
		while(rs.next()) {
			comboBox.addItem((rs.getString("tartarugatarga")));
		}
		
	}
	
	public int recuperaPeso(Object targa, Connection connessioneDB) throws SQLException{
		int peso=0;
		String sqlQuery = "Select peso from cartellamedica where tartarugatarga = '" + targa + "';";
		
		Statement query = connessioneDB.createStatement();
		ResultSet rs = query.executeQuery(sqlQuery);
		
		if(rs.next()) {
			peso = rs.getInt("peso");
		}
		
		return peso;
	}
	
}
