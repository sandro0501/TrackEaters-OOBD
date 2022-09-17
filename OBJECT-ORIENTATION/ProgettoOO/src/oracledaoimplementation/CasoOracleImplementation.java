package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CasoDAO;
import database.ConnessioneDatabase;
import dto.Caso;


public class CasoOracleImplementation implements CasoDAO {
	
	private Connection connessione = null;
	
	public CasoOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Caso> getCasiCovidByCodRistorante(int codRistorante) {
		ArrayList<Caso> casi = new ArrayList<Caso>();
		
		try {
			String queryGetCasi = "SELECT DISTINCT C.Codcaso,C.DataRegistrazione,C.AvventorePositivo,C.Statocaso,C.Note FROM CASO C JOIN ACCOGLIENZA A ON "
					+ "C.AvventorePositivo = A.Avventore WHERE A.Ristorante=? ORDER BY C.DataRegistrazione";
			PreparedStatement stmtGetCasi = connessione.prepareStatement(queryGetCasi);
			stmtGetCasi.setInt(1, codRistorante);
			ResultSet rs = stmtGetCasi.executeQuery();
			
			while(rs.next()) {
				Caso c = new Caso(rs.getInt(1),rs.getDate(2),rs.getString(3),rs.getString(4),rs.getString(5));
				casi.add(c);
			}		
			rs.close();
			stmtGetCasi.close();		    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return casi;
	}

	@Override
	public boolean insertCaso(String dataRegistrazione, String numCid, String stato, String note) {
		try {
			String queryInsertCaso = "INSERT INTO CASO (DataRegistrazione,StatoCaso,Note,AvventorePositivo) VALUES(TO_DATE(?,'dd/mm/yyyy'),?,?,?)";
			PreparedStatement insertCasoStatement = connessione.prepareStatement(queryInsertCaso);
			insertCasoStatement.setString(1, dataRegistrazione);
			insertCasoStatement.setString(2, stato);
			insertCasoStatement.setString(3, note);
			insertCasoStatement.setString(4, numCid);
			
			int esitoInsert = insertCasoStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertCasoStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateCaso(int codiceCaso,String dataRegistrazione, String numCid, String stato, String note) {
		try {
			String queryUpdateCaso = "UPDATE caso SET dataregistrazione=TO_DATE(?,'dd/mm/yyyy'),statocaso=?,note=?,avventorepositivo=? WHERE codcaso=?";
			PreparedStatement updateCasoStatement = connessione.prepareStatement(queryUpdateCaso);
			updateCasoStatement.setString(1, dataRegistrazione);
			updateCasoStatement.setString(2, stato);
			updateCasoStatement.setString(3, note);
			updateCasoStatement.setString(4, numCid);
			updateCasoStatement.setInt(5, codiceCaso);
			
			int esitoUpdate = updateCasoStatement.executeUpdate();

			if(esitoUpdate==1)
				return true;
			
			updateCasoStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteCaso(int codiceCaso) {
		try {
			String queryDeleteCaso = "DELETE FROM Caso WHERE Codcaso = ?";
			PreparedStatement deleteCasoStatement = connessione.prepareStatement(queryDeleteCaso);
			deleteCasoStatement.setInt(1, codiceCaso);
			
			int esitoDelete = deleteCasoStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteCasoStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

}
