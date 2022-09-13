package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.TavoloDAO;
import database.ConnessioneDatabase;
import dto.Sala;
import dto.Tavolo;

public class TavoloOracleImplementation implements TavoloDAO {
	
	private Connection connessione = null;
	
	public TavoloOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Tavolo> getTavoliByCodSala(int codSala) {
		ArrayList<Tavolo> tavoli = new ArrayList<Tavolo>();
		try {
			String queryGetTavoli = "SELECT t.codtavolo, t.maxavventori FROM tavolo t JOIN sala s ON t.sala=s.codsala WHERE s.codsala =? ORDER BY t.codtavolo";
			PreparedStatement stmtGetTavoli = connessione.prepareStatement(queryGetTavoli);
			stmtGetTavoli.setInt(1, codSala);
			ResultSet rs = stmtGetTavoli.executeQuery();
			
			while(rs.next()) {
				Tavolo t = new Tavolo(rs.getInt(1),rs.getInt(2));
				tavoli.add(t);
			}
			
			rs.close();
			stmtGetTavoli.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return tavoli;
	}

	@Override
	public boolean insertTavolo(int maxAvventori, int codSala) {
		try {
			String queryInsertTavolo = "INSERT INTO TAVOLO (Maxavventori,Sala) VALUES (?,?)";
			PreparedStatement insertTavoloStatement = connessione.prepareStatement(queryInsertTavolo);
			insertTavoloStatement.setInt(1,maxAvventori);
			insertTavoloStatement.setInt(2,codSala);
			
			int esitoInsert = insertTavoloStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertTavoloStatement.close();
			
		} catch (SQLException e) {
			if(e.getErrorCode()==20017) 
			{
				JLabel lblErrore = new JLabel("<html>Attenzione: non è possibile aggiungere il nuovo tavolo.<br>"
						+ "Capienza massima di avventori della sala di riferimento superata!</html>");
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
		return false;
	}

	@Override
	public boolean updateTavolo(int codTavolo, int maxAvventori) {
		try {
			String queryUpdateTavolo = "UPDATE Tavolo SET Maxavventori=? WHERE Codtavolo=?";
			PreparedStatement updateTavoloStatement = connessione.prepareStatement(queryUpdateTavolo);
			updateTavoloStatement.setInt(1,maxAvventori);
			updateTavoloStatement.setInt(2,codTavolo);
			
			int esitoUpdate = updateTavoloStatement.executeUpdate();

			if(esitoUpdate==1)
				return true;
			
			updateTavoloStatement.close();
			
		} catch (SQLException e) {
			if(e.getErrorCode()==20016) 
			{
				JLabel lblErrore = new JLabel("<html>Attenzione: non è possibile modificare il tavolo.<br>"
						+ "Il valore del numero di avventori per il tavolo deve essere minore o uguale alla capienza della sala!</html>");
				lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null,lblErrore,"Errore modifica dati",JOptionPane.ERROR_MESSAGE);	
			}
			else 
			{
				System.out.println("Codice errore SQL: "+e.getErrorCode()); 
				System.out.println("SQL State: "+e.getSQLState()); 
				System.out.println("Messaggio: " +e.getMessage());
			}
		}
		return false;
	}

	@Override
	public boolean deleteTavolo(int codTavolo) {
		try {
			String queryDeleteTavolo = "DELETE FROM Tavolo WHERE Tavolo.Codtavolo = ?";
			PreparedStatement deleteTavoloStatement = connessione.prepareStatement(queryDeleteTavolo);
			deleteTavoloStatement.setInt(1, codTavolo);
			
			int esitoDelete = deleteTavoloStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteTavoloStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

}
