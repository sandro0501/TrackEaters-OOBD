package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.RistoranteDAO;
import database.ConnessioneDatabase;
import dto.Ristorante;

public class RistoranteOracleImplementation implements RistoranteDAO {
	
	private Connection connessione = null;
	
	public RistoranteOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario) {
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			String queryGetRistoranti = "SELECT R.Denominazione, R.Indirizzo, R.Telefono, R.Citta, R.Prov, R.Cap, R.Email, R.SitoWeb  FROM Ristorante R JOIN Proprietario P ON R.Proprietario = P.CodProprietario WHERE P.Username=? ORDER BY R.CodRistorante";
			PreparedStatement stmtGetRistoranti = connessione.prepareStatement(queryGetRistoranti);
			stmtGetRistoranti.setString(1, usernameProprietario);
			ResultSet rs = stmtGetRistoranti.executeQuery();
			
			while(rs.next()) {
				Ristorante r = new Ristorante(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				ristoranti.add(r);
			}
			
			rs.close();
			stmtGetRistoranti.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return ristoranti;
	}
	
	
	

	@Override
	public Ristorante getRistoranteFromUsernameManager(String usernameManager) {
		Ristorante ristorante = null; 
		
		try {
			String queryGetRistorante = "SELECT R.Denominazione, R.Indirizzo, R.Telefono, R.Citta, R.Prov, R.Cap, R.Email, R.SitoWeb  FROM Ristorante R JOIN  ManagerRistorante M ON R.CodRistorante=M.Ristorantegestito WHERE M.Username=?";
			PreparedStatement stmtGetRistorante = connessione.prepareStatement(queryGetRistorante);
			stmtGetRistorante.setString(1, usernameManager);
			ResultSet rs = stmtGetRistorante.executeQuery();
			
			if(rs.next()) {
				ristorante = new Ristorante(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
			
			rs.close();
			stmtGetRistorante.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}	
		
		return ristorante;
	}
	
	@Override
	public int getCodiceRistoranteByDenominazioneAndIndirizzo(String denominazione, String indirizzo) {
		try {
			String queryGetCodiceRistorante = "SELECT R.CodRistorante FROM Ristorante R WHERE R.Denominazione = ? AND R.Indirizzo = ?";
			PreparedStatement stmtGetCodiceRistorante = connessione.prepareStatement(queryGetCodiceRistorante);
			stmtGetCodiceRistorante.setString(1, denominazione);
			stmtGetCodiceRistorante.setString(2, indirizzo);
			ResultSet rs = stmtGetCodiceRistorante.executeQuery();

			if(rs.next())
				return rs.getInt("CodRistorante");
			
			rs.close();
			stmtGetCodiceRistorante.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return 0;
	}
	
	@Override
	public Ristorante getRistoranteByCode(int codRistorante) {
		Ristorante ristorante = null;
		String codiceRistorante = String.valueOf(codRistorante);
		
		try {
			String queryRistoranteByCode ="SELECT R.Denominazione, R.Indirizzo, R.Telefono, R.Citta, R.Prov, R.Cap, R.Email, R.SitoWeb FROM Ristorante R WHERE R.CodRistorante=?";
			PreparedStatement stmtRistoranteByCode = connessione.prepareStatement(queryRistoranteByCode);
			stmtRistoranteByCode.setString(1, codiceRistorante);
			ResultSet rs = stmtRistoranteByCode.executeQuery();
			
			if(rs.next()) {
				ristorante = new Ristorante(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
			}
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return ristorante;
	}

	@Override
	public boolean insertRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov,
			String cap, String email, String sitoweb, int proprietario) {
		
		try {
			String queryInsertRistorante = "INSERT INTO RISTORANTE (Denominazione, Indirizzo, Telefono, Citta, Prov, Cap, Email, SitoWeb, Proprietario) VALUES (?,?,?,?,?,?,?,?,?)";
			PreparedStatement insertRistoranteStatement = connessione.prepareStatement(queryInsertRistorante);
			insertRistoranteStatement.setString(1, denominazione);
			insertRistoranteStatement.setString(2, indirizzo);
			insertRistoranteStatement.setString(3, telefono);
			insertRistoranteStatement.setString(4, citta);
			insertRistoranteStatement.setString(5, prov);
			insertRistoranteStatement.setString(6, cap);
			insertRistoranteStatement.setString(7, email);
			insertRistoranteStatement.setString(8, sitoweb);
			insertRistoranteStatement.setInt(9, proprietario);
			
			int esitoInsert = insertRistoranteStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertRistoranteStatement.close();
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
	
		return false;
	}
	
	@Override
	public boolean updateRistorante(int codRistorante,String denominazione, String indirizzo, String telefono, String citta, String prov, 
			String cap, String email, String sitoweb) {
		
		try {
			String queryUpdateRistorante = "UPDATE Ristorante SET Denominazione=?,Indirizzo=?,Telefono=?,Citta=?,Prov=?,Cap=?,Email=?,SitoWeb=? WHERE CodRistorante=?";
			PreparedStatement updateRistoranteStatement = connessione.prepareStatement(queryUpdateRistorante);
			updateRistoranteStatement.setString(1, denominazione);
			updateRistoranteStatement.setString(2, indirizzo);
			updateRistoranteStatement.setString(3, telefono);
			updateRistoranteStatement.setString(4, citta);
			updateRistoranteStatement.setString(5, prov);
			updateRistoranteStatement.setString(6, cap);
			updateRistoranteStatement.setString(7, email);
			updateRistoranteStatement.setString(8, sitoweb);
			updateRistoranteStatement.setInt(9, codRistorante);
			
			int esitoUpdate = updateRistoranteStatement.executeUpdate();
			
			if(esitoUpdate==1)
				return true;
			
			updateRistoranteStatement.close();
			
		} catch (SQLException e) {
			gestisciErroriInserimentoDati(e);
		}
		return false;
	}

	@Override
	public boolean deleteRistorante(int codRistorante) {
		try {
			String queryDeleteRistorante = "DELETE FROM Ristorante WHERE Ristorante.CodRistorante = ?";
			PreparedStatement deleteRistoranteStatement = connessione.prepareStatement(queryDeleteRistorante);
			deleteRistoranteStatement.setInt(1, codRistorante);
			
			int esitoDelete = deleteRistoranteStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteRistoranteStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}
	
	@Override
	public Ristorante getRistoranteByDenominazioneAndIndirizzo(String denominazione, String indirizzo) {
		
		Ristorante ristorante = null;
		
		try {
			String queryRistoranteByDenominazioneAndIndirizzo = "SELECT  R.Denominazione, R.Indirizzo, R.Telefono, R.Citta, R.Prov, R.Cap, R.Email, R.SitoWeb FROM Ristorante R WHERE R.denominazione= ? AND R.indirizzo = ?";
			PreparedStatement RistoranteByDenominazioneAndIndirizzo = connessione.prepareStatement(queryRistoranteByDenominazioneAndIndirizzo);
			RistoranteByDenominazioneAndIndirizzo.setString(1, denominazione);
			RistoranteByDenominazioneAndIndirizzo.setString(2, indirizzo);
			ResultSet rs = RistoranteByDenominazioneAndIndirizzo.executeQuery();
			
			if (rs.next()) {
				ristorante = new Ristorante(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
			}
			
			rs.close();
			RistoranteByDenominazioneAndIndirizzo.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return ristorante;
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

	@Override
	public int numeroPositiviRistorante(String dataInizio, String dataFine, int codRistorante) {
		
		try {
			String queryTotaleAvventori = "SELECT COUNT(C.AvventorePositivo) TOT_RISULTATI_POSITIVI FROM RISTORANTE R JOIN ACCOGLIENZA A ON R.CodRistorante = A.Ristorante JOIN CASO C ON C.AvventorePositivo = A.Avventore JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = C.AvventorePositivo JOIN TAVOLATA T ON PT.Tavolata = T.CodTavolata WHERE R.CodRistorante = ? AND T.DataArrivo BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
		
			PreparedStatement stmtQueryTotaleAvventori = connessione.prepareStatement(queryTotaleAvventori);
			stmtQueryTotaleAvventori.setInt(1, codRistorante);
			stmtQueryTotaleAvventori.setString(2, dataInizio);
			stmtQueryTotaleAvventori.setString(3, dataFine);
		
			ResultSet rs = stmtQueryTotaleAvventori.executeQuery();
		
			while(rs.next())
				return rs.getInt(1);
			
			stmtQueryTotaleAvventori.close();
			rs.close();
		
		
		} catch(SQLException e) {
		
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		
		}
		
		return 0;
	}

	@Override
	public int numeroTotaleAvventoriRistorante(String dataInizio, String dataFine, int codRistorante) {
		try {
			
			String queryTotaleAvventori = "SELECT COUNT(ACC.Avventore) TOT_GIORNALIERO_AVVENTORI FROM RISTORANTE R JOIN ACCOGLIENZA ACC ON R.CodRistorante = ACC.Ristorante JOIN AVVENTORE A ON A.NumCid = ACC.Avventore JOIN PARTECIPAZIONETAVOLATA PT ON PT.Avventore = A.NumCid JOIN TAVOLATA T ON T.CodTavolata = PT.Tavolata WHERE R.CodRistorante = ? AND T.DataArrivo BETWEEN TO_DATE(?,'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryTotaleAvventori = connessione.prepareStatement(queryTotaleAvventori);
			stmtQueryTotaleAvventori.setInt(1, codRistorante);
			stmtQueryTotaleAvventori.setString(2, dataInizio);
			stmtQueryTotaleAvventori.setString(3, dataFine);
			
			ResultSet rs = stmtQueryTotaleAvventori.executeQuery();
			
			while(rs.next())
				return rs.getInt(1);
			
			stmtQueryTotaleAvventori.close();
			rs.close();
			
			
		} catch(SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return 0;
	}

	@Override
	public int numeroAvventoriInterniRistorante(String dataInizio, String dataFine, int codRistorante) {

		try {
			
			String queryAvventoriInterni = " SELECT COUNT(P.AVVENTORE) FROM TAVOLO T JOIN TAVOLATA TA ON T.CODTAVOLO = TA.TAVOLO JOIN PARTECIPAZIONETAVOLATA P ON P.TAVOLATA = TA.CODTAVOLATA JOIN SALA S ON T.SALA = S.CODSALA WHERE S.RISTORANTE = ? AND S.TIPOSALA = 'Interna' AND TA.DATAARRIVO BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryAvventoriInterni = connessione.prepareStatement(queryAvventoriInterni);
			stmtQueryAvventoriInterni.setInt(1, codRistorante);
			stmtQueryAvventoriInterni.setString(2, dataInizio);
			stmtQueryAvventoriInterni.setString(3, dataFine);
			
			ResultSet rs = stmtQueryAvventoriInterni.executeQuery();
			
			while(rs.next())
				return rs.getInt(1);
			
			stmtQueryAvventoriInterni.close();
			rs.close();
			
			
		} catch(SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return 0;
	}

	@Override
	public int numeroAvventoriEsterniRistorante(String dataInizio, String dataFine, int codRistorante) {
		
		int totale = 0;
		
		try {
			
			String queryAvventoriEsterni ="SELECT COUNT (P.AVVENTORE) FROM TAVOLO T JOIN TAVOLATA TA ON T.CODTAVOLO = TA.TAVOLO JOIN PARTECIPAZIONETAVOLATA P ON P.TAVOLATA = TA.CODTAVOLATA JOIN SALA S ON T.SALA = S.CODSALA WHERE S.RISTORANTE = ? AND S.TIPOSALA = 'Esterna' AND TA.DATAARRIVO BETWEEN TO_DATE(?, 'dd/mm/yyyy') AND TO_DATE(?, 'dd/mm/yyyy')";
			
			PreparedStatement stmtQueryAvventoriEsterni = connessione.prepareStatement(queryAvventoriEsterni);
			stmtQueryAvventoriEsterni.setInt(1, codRistorante);
			stmtQueryAvventoriEsterni.setString(2, dataInizio);
			stmtQueryAvventoriEsterni.setString(3, dataFine);
			
			ResultSet rs = stmtQueryAvventoriEsterni.executeQuery();
			
			while(rs.next())
				totale = rs.getInt(1);
				
			
			stmtQueryAvventoriEsterni.close();
			rs.close();
			
			
		} catch(SQLException e) {
			
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
			
		}
		
		
		return totale;
	}

}
