package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.ProprietarioDAO;
import database.ConnessioneDatabase;

public class ProprietarioOracleImplementation implements ProprietarioDAO {

	private Connection connessione = null;
	
	public ProprietarioOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
	
	@Override
	public int getCodiceProprietarioFromUsername(String usernameProprietario) {
		try {
			String queryGetCodice = "SELECT CodProprietario FROM Proprietario WHERE Proprietario.Username = ?";
			PreparedStatement getCodiceStmt = connessione.prepareStatement(queryGetCodice);
			getCodiceStmt.setString(1, usernameProprietario);
			ResultSet rs = getCodiceStmt.executeQuery();
	
			if(rs.next())
				return rs.getInt("CodProprietario");
			
			
			rs.close();
			getCodiceStmt.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return 0;
	}
	
	@Override
	public boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password) {
		try {
			String queryUpdateProprietario = "UPDATE Proprietario SET Username=?, Password=?, Nome=?, Cognome=?, Email=? WHERE Proprietario.Username=?";
			PreparedStatement updateProprietarioStatement = connessione.prepareStatement(queryUpdateProprietario);
			updateProprietarioStatement.setString(1, newUsername);
			updateProprietarioStatement.setString(2, password);
			updateProprietarioStatement.setString(3, nome);
			updateProprietarioStatement.setString(4, cognome);
			updateProprietarioStatement.setString(5, email);
			updateProprietarioStatement.setString(6, currentUsername);
			
			int esitoUpdate = updateProprietarioStatement.executeUpdate();
			if(esitoUpdate==1)
				return true;
			
			updateProprietarioStatement.close();
			
		} catch (SQLException e) {
			
			if(e.getErrorCode()==20011) {
				JLabel lblErrore = new JLabel("Password non valida. Deve contenere almeno 8 caratteri, una lettera ed un numero!");
				lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
			} else {
				System.out.println("Codice errore SQL: "+e.getErrorCode()); 
				System.out.println("SQL State: "+e.getSQLState()); 
				System.out.println("Messaggio: " +e.getMessage());
			}
		}
		
		return false;
	}


	@Override
	public int getNumeroAvventoriPositiviRistoranti(String dataInizio, String dataFine) {
		
		int totale = 0;
		
		try {
			
			String queryPositivi = "SELECT COUNT(C.AvventorePositivo) FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante JOIN CASO C ON C.AvventorePositivo = A.Avventore JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata WHERE T.DataArrivo BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryPositivi = connessione.prepareStatement(queryPositivi);
			stmtQueryPositivi.setString(1, dataInizio);
			stmtQueryPositivi.setString(2, dataFine);
			
			ResultSet rs = stmtQueryPositivi.executeQuery();
			
			while(rs.next())
				totale = rs.getInt(1);
			
			stmtQueryPositivi.close();
			rs.close();
			
			
		} catch(SQLException e) {
			System.out.println("Sono in positivi"); 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return totale;
	}

	@Override
	public int getNumeroTotaleAvventoriRistoranti(String dataInizio, String dataFine) {
		
		int totale = 0;
		
		try {
			
			String queryTotaleAvventori = "SELECT COUNT(ACC.Avventore) FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante JOIN AVVENTORE A ON A.NumCid = ACC.Avventore JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata WHERE T.DataArrivo BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryTotaleAvventori = connessione.prepareStatement(queryTotaleAvventori);
			stmtQueryTotaleAvventori.setString(1, dataInizio);
			stmtQueryTotaleAvventori.setString(2, dataFine);
			
			ResultSet rs = stmtQueryTotaleAvventori.executeQuery();
			
			while(rs.next())
				totale = rs.getInt(1);
			
			stmtQueryTotaleAvventori.close();
			rs.close();
			
			
		} catch(SQLException e) {
			System.out.println("Sono in totale"); 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return totale;
	}

	@Override
	public int getNumeroAvventoriInterniRistoranti(String dataInizio, String dataFine) {
		
		int totale = 0;
		
		try {
			
			String queryAvventoriInterni =  "SELECT COUNT (P.AVVENTORE) FROM TAVOLO T JOIN TAVOLATA TA ON T.CODTAVOLO = TA.TAVOLO JOIN PARTECIPAZIONETAVOLATA P ON P.TAVOLATA = TA.CODTAVOLATA JOIN SALA S ON T.SALA = S.CODSALA WHERE S.TIPOSALA = 'Interna' AND TA.DATAARRIVO BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryAvventoriInterni = connessione.prepareStatement(queryAvventoriInterni);
			stmtQueryAvventoriInterni.setString(1, dataInizio);
			stmtQueryAvventoriInterni.setString(2, dataFine);
			
			ResultSet rs = stmtQueryAvventoriInterni.executeQuery();
			
			while(rs.next())
				totale = rs.getInt(1);
			
			stmtQueryAvventoriInterni.close();
			rs.close();
			
			
		} catch(SQLException e) {
			System.out.println("Sono in interni"); 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return totale;
	}

	@Override
	public int getNumeroAvventoriEsterniRistoranti(String dataInizio, String dataFine) {
		
		int totale = 0;
		
		try {
			
			String queryAvventoriEsterni = "SELECT COUNT (P.AVVENTORE) FROM TAVOLO T JOIN TAVOLATA TA ON T.CODTAVOLO = TA.TAVOLO JOIN PARTECIPAZIONETAVOLATA P ON P.TAVOLATA = TA.CODTAVOLATA JOIN SALA S ON T.SALA = S.CODSALA WHERE S.TIPOSALA = 'Esterna' AND TA.DATAARRIVO BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryAvventoriEsterni = connessione.prepareStatement(queryAvventoriEsterni);
			stmtQueryAvventoriEsterni.setString(1, dataInizio);
			stmtQueryAvventoriEsterni.setString(2, dataFine);
			
			ResultSet rs = stmtQueryAvventoriEsterni.executeQuery();
			
			while(rs.next())
				totale = rs.getInt(1);
			
			stmtQueryAvventoriEsterni.close();
			rs.close();
			
			
		} catch(SQLException e) {
			System.out.println("Sono in esterni"); 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return totale;
	}

	
}
