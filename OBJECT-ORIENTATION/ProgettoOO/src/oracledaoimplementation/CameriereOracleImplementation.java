package oracledaoimplementation;

import java.util.ArrayList;

import dao.CameriereDAO;
import database.ConnessioneDatabase;
import dto.Cameriere;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CameriereOracleImplementation implements CameriereDAO {
	
	private Connection connessione = null;
	
	public CameriereOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Cameriere> getCamerieriRistorante(int codRistorante) {
		
		ArrayList<Cameriere> camerieri = new ArrayList<>();
		String codiceRistorante = String.valueOf(codRistorante);
		
		try {
			
			String queryCamerieriRistorante = "SELECT * FROM Cameriere C JOIN Ristorante R ON C.Ristorante=R.CodRistorante WHERE R.CodRistorante = ?";
			PreparedStatement stmtCamerieriRistorante = connessione.prepareStatement(queryCamerieriRistorante);
			stmtCamerieriRistorante.setString(1, codiceRistorante);
			ResultSet rs = stmtCamerieriRistorante.executeQuery();
			
			while(rs.next()) {
				Cameriere c = new Cameriere(rs.getString(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11));
				camerieri.add(c);
			}
			
			rs.close();
			stmtCamerieriRistorante.close();
			
		} catch (SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		return camerieri;
	}
	

}
