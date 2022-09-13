package oracledaoimplementation;

import java.awt.Font;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.ManagerRistoranteDAO;
import dao.RistoranteDAO;
import database.ConnessioneDatabase;
import dto.ManagerRistorante;
import dto.Ristorante;

public class ManagerRistoranteOracleImplementation implements ManagerRistoranteDAO {
	
	private Connection connessione = null;
	
	public ManagerRistoranteOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
	
	@Override
	public ArrayList<ManagerRistorante> getAllManager(){
		
		ArrayList<ManagerRistorante> listaManager = new ArrayList<>();
		Ristorante ristorante = null;
		RistoranteDAO ristoranteDAO = new RistoranteOracleImplementation();
		
		try {
			String queryAllManager = "SELECT Username, Password, Nome, Cognome, Email, Telefono, Ristorantegestito  FROM Managerristorante ";
			PreparedStatement stmtAllManager = connessione.prepareStatement(queryAllManager);
			ResultSet rs = stmtAllManager.executeQuery();
			
			while (rs.next()) {
				ManagerRistorante m = new ManagerRistorante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				m.setTelefono(rs.getString(6));
				ristorante = ristoranteDAO.getRistoranteByCode(rs.getInt(7));
				m.setRistoranteGestito(ristorante);
				listaManager.add(m);
			}
			
			rs.close();
			stmtAllManager.close();
			
		} catch (SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return listaManager;
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

	@Override
	public boolean insertManager(String username, String password, String nome, String cognome, String telefono, String email, int ristoranteGestito) {
		int esitoInsert;
		
		try {
			
			String insertManager = "INSERT INTO Managerristorante (Username, Password, Nome, Cognome, Email, Telefono, RistoranteGestito) VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmtInsertManager = connessione.prepareStatement(insertManager);
			stmtInsertManager.setString(1, username);
			stmtInsertManager.setString(2, password);
			stmtInsertManager.setString(3, nome);
			stmtInsertManager.setString(4, cognome);
			stmtInsertManager.setString(5, email);
			stmtInsertManager.setString(6, telefono);
			stmtInsertManager.setInt(7, ristoranteGestito);
			
			esitoInsert = stmtInsertManager.executeUpdate();
			
			if(esitoInsert==1) 
				return true;
			
			stmtInsertManager.close();
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
		
		return false;
	}

	@Override
	public boolean updateManager(String username, String password, String nome, String cognome,
			String telfono, String email, int ristoranteGestito) {
		
		int esitoUpdate;
		
		try {
			String updateManager = "UPDATE Managerristorante SET Password=?, Nome=?, Cognome=?, Telefono=?, Email=?, RistoranteGestito=? WHERE Username=?";
			PreparedStatement stmtUpdateManager = connessione.prepareStatement(updateManager);
			
			stmtUpdateManager.setString(1, password);
			stmtUpdateManager.setString(2, nome);
			stmtUpdateManager.setString(3, cognome);
			stmtUpdateManager.setString(4, telfono);
			stmtUpdateManager.setString(5, email);
			stmtUpdateManager.setInt(6, ristoranteGestito);
			stmtUpdateManager.setString(7, username);
			
			esitoUpdate = stmtUpdateManager.executeUpdate();
			
			if (esitoUpdate==1)
				return true;
			
			stmtUpdateManager.close();
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
		
		return false;
	}

	@Override
	public boolean deleteManager(String username) {
		
		int esitoDelete;
		
		try {
			
			String deleteManager = "DELETE FROM ManagerRistorante M WHERE M.Username=?";
			PreparedStatement stmtDeleteManager = connessione.prepareStatement(deleteManager);
			stmtDeleteManager.setString(1, username);
			
			esitoDelete = stmtDeleteManager.executeUpdate();
			
			if (esitoDelete==1)
				return true;
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
		
		return false;
	}
	
	private void gestisciErroriInserimentoDati(SQLException e) {
		if(e.getErrorCode()==20010) 
		{
			JLabel lblErrore = new JLabel("Numero di telefono non valido! Sono ammesse cifre numeriche ed il carattere +. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else if (e.getErrorCode()==20012) 
		{
			JLabel lblErrore = new JLabel("CAP non valido! Sono ammesse al massimo 5 cifre numeriche. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else if (e.getMessage().toString().contains("SITO_WEB_LEGALE"))
		{
			JLabel lblErrore = new JLabel("Sito web non valido! Non rispetta la forma 'www.example.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);
		} 
		else if (e.getMessage().toString().contains("EMAIL_LEGALE"))
		{
			JLabel lblErrore = new JLabel("Email non valida! Non rispetta la forma 'example@mail.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
		} 
		else 
		{
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}


}
