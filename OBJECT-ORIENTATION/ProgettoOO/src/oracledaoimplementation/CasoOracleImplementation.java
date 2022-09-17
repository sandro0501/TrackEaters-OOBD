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
			String queryGetCasi = "SELECT DISTINCT C.DataRegistrazione,C.AvventorePositivo,C.Statocaso,C.Note FROM CASO C JOIN ACCOGLIENZA A ON "
					+ "C.AvventorePositivo = A.Avventore WHERE A.Ristorante=? ORDER BY C.DataRegistrazione";
			PreparedStatement stmtGetCasi = connessione.prepareStatement(queryGetCasi);
			stmtGetCasi.setInt(1, codRistorante);
			ResultSet rs = stmtGetCasi.executeQuery();
			
			while(rs.next()) {
				Caso c = new Caso(rs.getDate(1),rs.getString(2),rs.getString(3),rs.getString(4));
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

}
