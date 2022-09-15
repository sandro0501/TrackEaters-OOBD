package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.AvventoreDAO;
import database.ConnessioneDatabase;
import dto.Avventore;
import dto.Tavolata;

public class AvventoreOracleImplementation implements AvventoreDAO {
	
	private Connection connessione = null;
	
	public AvventoreOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Avventore> getAvventoriByCodTavolata(int codTavolata) {
		ArrayList<Avventore> avventori = new ArrayList<Avventore>();
		try {
			String queryGetAvventori = "SELECT * FROM AVVENTORE A JOIN PARTECIPAZIONETAVOLATA T ON A.Numcid = T.Avventore WHERE T.Tavolata = ?";
			PreparedStatement stmtGetAvventori = connessione.prepareStatement(queryGetAvventori);
			stmtGetAvventori.setInt(1, codTavolata);
			ResultSet rs = stmtGetAvventori.executeQuery();
			
			while(rs.next()) {
				Avventore a = new Avventore(rs.getString(1),rs.getString(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),
						rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getDouble(12),rs.getString(13).charAt(0));
				
				avventori.add(a);
			}
			rs.close();
			stmtGetAvventori.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return avventori;
	}
	
	@Override
	public boolean getEsistenzaAvventoreByNumcid(String numCid) {
		try {
			String queryGetAvventori = "SELECT * FROM AVVENTORE WHERE Numcid=?";
			PreparedStatement stmtGetAvventori = connessione.prepareStatement(queryGetAvventori);
			stmtGetAvventori.setString(1, numCid);
			ResultSet rs = stmtGetAvventori.executeQuery();
			
			if(rs.next())
				return true;
			
			rs.close();
			stmtGetAvventori.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean insertAvventore(String numCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaNascita, String provNascita, String cittaResidenza, String provResidenza, String telefono,
			String email, double temperatura, char greenpass) {
		
		try {
			String queryInsertAvventore = "INSERT INTO AVVENTORE (NumCid,Nome,Cognome,DataN,Sesso,CittaN,ProvN,CittaRes,ProvRes,Telefono,Email,Temperatura,HaGreenpass)"
					+ "VALUES(?,?,?,TO_DATE(?,'dd/mm/yyyy'),?,?,?,?,?,?,?,?,?)";
			PreparedStatement insertAvventoreStatement = connessione.prepareStatement(queryInsertAvventore);
			insertAvventoreStatement.setString(1, numCid);
			insertAvventoreStatement.setString(2, nome);
			insertAvventoreStatement.setString(3, cognome);
			insertAvventoreStatement.setString(4, dataNascita);
			insertAvventoreStatement.setString(5, sesso);
			insertAvventoreStatement.setString(6, cittaNascita);
			insertAvventoreStatement.setString(7, provNascita);
			insertAvventoreStatement.setString(8, cittaResidenza);
			insertAvventoreStatement.setString(9, provResidenza);
			insertAvventoreStatement.setString(10, telefono);
			insertAvventoreStatement.setString(11, email);
			insertAvventoreStatement.setDouble(12, temperatura);
			insertAvventoreStatement.setString(13, String.valueOf(greenpass));

			int esitoInsert = insertAvventoreStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
		
			insertAvventoreStatement.close();
			
		} catch (SQLException e) {
			gestioneErroreInserimentoAvventore(e);	
		}
		return false;
	}
	
	@Override
	public boolean aggiungiAvventoreATavolata(String numCid, int codTavolata) {
		try {
			String queryAvventoreTavolata = "INSERT INTO PARTECIPAZIONETAVOLATA (Avventore, Tavolata) VALUES (?,?)";
			PreparedStatement insertAvventoreTavolataStatement = connessione.prepareStatement(queryAvventoreTavolata);
			insertAvventoreTavolataStatement.setString(1, numCid);
			insertAvventoreTavolataStatement.setInt(2,codTavolata);
			
			int esitoInsert = insertAvventoreTavolataStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertAvventoreTavolataStatement.close();
			
		} catch (SQLException e) {
			gestioneErroreInserimentoAvventore(e);	
		}
		return false;
	}

	@Override
	public boolean aggiungiAvventoreARistorante(int codRistorante, String numCid) {
		try {
			String queryAvventoreRistorante = "INSERT INTO ACCOGLIENZA (Ristorante, Avventore) VALUES (?,?)";
			PreparedStatement insertAvventoreRistoranteStatement = connessione.prepareStatement(queryAvventoreRistorante);
			insertAvventoreRistoranteStatement.setInt(1, codRistorante);
			insertAvventoreRistoranteStatement.setString(2, numCid);
			
			int esitoInsert = insertAvventoreRistoranteStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertAvventoreRistoranteStatement.close();
			
		} catch (SQLException e) {
			gestioneErroreInserimentoAvventore(e);	
		}
		return false;
	}
	
	@Override
	public boolean updateAvventore(String numcid, String nome, String cognome, String dataNascita, String sesso, String cittaNascita,
			String provNascita, String cittaResidenza, String provResidenza, String telefono, String email,
			double temperatura, char greenpass) {
		
		try {
			String queryUpdateAvventore = "UPDATE Avventore SET Nome=?,Cognome=?,Datan=TO_DATE(?,'dd/mm/yyyy'),Sesso=?,Cittan=?,Provn=?,Cittares=?,Provres=?,Telefono=?,Email=?,Temperatura=?,Hagreenpass=? WHERE Numcid=?";
			PreparedStatement updateAvventoreStmt = connessione.prepareStatement(queryUpdateAvventore);
			updateAvventoreStmt.setString(1, nome);
			updateAvventoreStmt.setString(2, cognome);
			updateAvventoreStmt.setString(3, dataNascita);
			updateAvventoreStmt.setString(4, sesso);
			updateAvventoreStmt.setString(5, cittaNascita);
			updateAvventoreStmt.setString(6, provNascita);
			updateAvventoreStmt.setString(7, cittaResidenza);
			updateAvventoreStmt.setString(8, provResidenza);
			updateAvventoreStmt.setString(9, telefono);
			updateAvventoreStmt.setString(10, email);
			updateAvventoreStmt.setDouble(11, temperatura);
			updateAvventoreStmt.setString(12, String.valueOf(greenpass));
			updateAvventoreStmt.setString(13, numcid);

			int esitoUpdate = updateAvventoreStmt.executeUpdate();
			
			if(esitoUpdate==1)
				return true;
			
			updateAvventoreStmt.close();
			
		} catch (SQLException e) {
			gestioneErroreModificaAvventore(e);
		}
		return false;
	}

	@Override
	public boolean deleteAvventore(String numCid) {
		try {
			String queryDeleteAvventore = "DELETE FROM Avventore WHERE Numcid = ?";
			PreparedStatement deleteAvventoreStatement = connessione.prepareStatement(queryDeleteAvventore);
			deleteAvventoreStatement.setString(1, numCid);
			
			int esitoDelete = deleteAvventoreStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteAvventoreStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}
	
	@Override
	public boolean deleteAvventoreFromTavolata(String numCid, int codTavolata) {
		try {
			String queryDeleteAvventore = "DELETE FROM Partecipazionetavolata WHERE Avventore=? AND Tavolata=?";
			PreparedStatement deleteAvventoreStatement = connessione.prepareStatement(queryDeleteAvventore);
			deleteAvventoreStatement.setString(1, numCid);
			deleteAvventoreStatement.setInt(2, codTavolata);
			
			int esitoDelete = deleteAvventoreStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteAvventoreStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}
	
	private void gestioneErroreInserimentoAvventore(SQLException e) {
		
		if (e.getMessage().toString().contains("SOMMA_AVVENTORI_A_TAVOLATA_LEGALE")) {
			JLabel lblErrore = new JLabel("Impossibile registrare avventore alla tavolata. Il tavolo di riferimento ha tutti i posti occupati!");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore",JOptionPane.ERROR_MESSAGE);
			
		} else if(e.getErrorCode()==12899) {
			JLabel lblErrore = new JLabel("<html>Numero della carta di identita' non valido!<br>Deve contenere al massimo 9 caratteri. Riprovare.</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Numero carta identita' non valido",JOptionPane.ERROR_MESSAGE);
			
		} else if(e.getMessage().toString().contains("DATA_NASCITA_LEGALE")) {
			JLabel lblErrore = new JLabel("<html>L' avventore non puo' partecipare alla tavolata.<br>Data di nascita successiva a data della tavolata.</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Data nascita illegale",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("NUMERO_DI_TELEFONO_AVVENTORE_LEGALE")) {
			JLabel lblErrore = new JLabel("Numero di telefono non valido! Sono ammesse cifre numeriche ed il carattere +. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Numero telefonico non valido",JOptionPane.ERROR_MESSAGE);
			
		} else if(e.getMessage().toString().contains("HAS_GREENPASS")) {
			JLabel lblErrore = new JLabel("<html>L'avventore e' sprovvisto di greenpass.<br>Puo' partecipare unicamente ad una tavolata composta da un tavolo ubicato in una sala esterna!</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Avventore sprovvisto di greenpass",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("TEMPERATURA_AVVENTORE")) {
			JLabel lblErrore = new JLabel("<html>L' avventore non puo' partecipare alla tavolata.<br>La sua temperatura corporea è oltre il limite consentito!</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Temperatura avventore illegale",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("EMAIL_LEGALE")) {
			JLabel lblErrore = new JLabel("Email non valida! Non rispetta la forma 'example@mail.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Email non valida",JOptionPane.ERROR_MESSAGE);	
			
		} else {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
	
	private void gestioneErroreModificaAvventore(SQLException e) {
		
		if(e.getMessage().toString().contains("DATA_NASCITA_LEGALE")) {
			JLabel lblErrore = new JLabel("<html>L' avventore non puo' partecipare alla tavolata.<br>Data di nascita successiva a data della tavolata.</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Data nascita illegale",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("NUMERO_DI_TELEFONO_AVVENTORE_LEGALE")) {
			JLabel lblErrore = new JLabel("Numero di telefono non valido! Sono ammesse cifre numeriche ed il carattere +. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Numero telefonico non valido",JOptionPane.ERROR_MESSAGE);
			
		} else if(e.getMessage().toString().contains("HAS_GREENPASS")) {
			JLabel lblErrore = new JLabel("<html>L'avventore e' sprovvisto di greenpass.<br>Puo' partecipare unicamente ad una tavolata composta da un tavolo ubicato in una sala esterna!</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Avventore sprovvisto di greenpass",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("TEMPERATURA_AVVENTORE")) {
			JLabel lblErrore = new JLabel("<html>L' avventore non puo' partecipare alla tavolata.<br>La sua temperatura corporea è oltre il limite consentito!</html>");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Temperatura avventore illegale",JOptionPane.ERROR_MESSAGE);
			
		} else if (e.getMessage().toString().contains("EMAIL_LEGALE")) {
			JLabel lblErrore = new JLabel("Email non valida! Non rispetta la forma 'example@mail.domain'. Riprova.");
			lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
			JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento avventore - Email non valida",JOptionPane.ERROR_MESSAGE);	
			
		} else {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
}
