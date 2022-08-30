package oracledaoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.ManagerRistoranteDAO;
import database.ConnessioneDatabase;
import dto.ManagerRistorante;
import dto.Ristorante;

public class ManagerRistoranteOracleImplementation implements ManagerRistoranteDAO {
	
	private Connection connessione = null;
	
	public ManagerRistoranteOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public ManagerRistorante getInformazioniManagerByCodRistorante(int codRistorante) {
		ManagerRistorante manager = null;
		
		try {
			String queryGetInfoManager = "SELECT Username, Password, Nome, Cognome, Email FROM ManagerRistorante WHERE Ristorantegestito = ?";
			PreparedStatement stmtGetInfoManager = connessione.prepareStatement(queryGetInfoManager);
			stmtGetInfoManager.setInt(1, codRistorante);
			ResultSet rs = stmtGetInfoManager.executeQuery();
			
			if(rs.next()) {
				manager = new ManagerRistorante(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
			}
			
			rs.close();
			stmtGetInfoManager.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}	
		
		return manager;
	}

	@Override
	public String getTelefonoManagerByUsername(String usernameManager) {
		String telefono = null;
		
		try {
			String queryGetTelefono = "SELECT Telefono FROM ManagerRistorante WHERE Username = ?";
			PreparedStatement stmtGetTelefono = connessione.prepareStatement(queryGetTelefono);
			stmtGetTelefono.setString(1, usernameManager);
			ResultSet rs = stmtGetTelefono.executeQuery();
			
			if(rs.next()) {
				telefono = rs.getString("Telefono");
			}
			
			rs.close();
			stmtGetTelefono.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}	
		
		return telefono;
	}


}
