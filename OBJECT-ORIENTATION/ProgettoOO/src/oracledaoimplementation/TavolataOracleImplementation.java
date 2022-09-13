package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.TavolataDAO;
import database.ConnessioneDatabase;
import dto.Ristorante;
import dto.Sala;
import dto.Tavolata;

public class TavolataOracleImplementation implements TavolataDAO {

	private Connection connessione = null;
	
	public TavolataOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}
	
	@Override
	public ArrayList<Tavolata> getTavolateByCodTavolo(int codTavolo) {
		ArrayList<Tavolata> tavolate = new ArrayList<Tavolata>();
		try {
			String queryGetTavolate = "SELECT codtavolata,dataarrivo FROM Tavolata T WHERE t.tavolo = ? ORDER BY dataarrivo";
			PreparedStatement stmtGetTavolate = connessione.prepareStatement(queryGetTavolate);
			stmtGetTavolate.setInt(1, codTavolo);
			ResultSet rs = stmtGetTavolate.executeQuery();
			
			while(rs.next()) {
				Tavolata t = new Tavolata(rs.getInt(1),rs.getDate(2));
				tavolate.add(t);
			}
			
			rs.close();
			stmtGetTavolate.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return tavolate;
	}
	
	@Override
	public int getCodiceTavolataByDataArrivoAndTavolo(String DataArrivo, int codTavolo) {
		int codTavolata = 0;
		try {
			String queryGetTavolata = "SELECT T.CodTavolata FROM Tavolata T WHERE T.DataArrivo=TO_DATE(?,'dd/mm/yyyy') AND T.Tavolo=?";
			PreparedStatement stmtGetTavolata = connessione.prepareStatement(queryGetTavolata);
			stmtGetTavolata.setString(1, DataArrivo);
			stmtGetTavolata.setInt(2, codTavolo);
			ResultSet rs = stmtGetTavolata.executeQuery();
			
			if(rs.next()) {
				codTavolata = rs.getInt(1);
			}
			
			rs.close();
			stmtGetTavolata.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}	
		
		return codTavolata;
	}

	@Override
	public boolean insertTavolata(String dataArrivo, int codTavolo, String cameriere) {
		try {
			String queryInsertTavolata = "INSERT INTO TAVOLATA (dataarrivo,tavolo,cameriere) VALUES (TO_DATE(?,'dd/mm/yyyy'),?,?)";
			PreparedStatement insertTavolataStatement = connessione.prepareStatement(queryInsertTavolata);
			insertTavolataStatement.setString(1, dataArrivo);
			insertTavolataStatement.setInt(2,codTavolo);
			insertTavolataStatement.setString(3,cameriere);
			
			int esitoInsert = insertTavolataStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertTavolataStatement.close();
			
		} catch (SQLException e) {
			if(e.getErrorCode()==1) 
			{
				JLabel lblErrore = new JLabel("<html>Attenzione: non è possibile inserire la tavolata.<br>"
						+ " In ciascuna data, al più una tavolata può essere associata ad un dato tavolo.</html>");
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
	public boolean updateTavolata(int codTavolata, String dataArrivo, String cameriere) {
		try {
			String queryUpdateTavolata = "UPDATE Tavolata SET dataarrivo=TO_DATE(?,'dd/mm/yyyy'), cameriere=? WHERE codtavolata=?";
			PreparedStatement updateTavolataStatement = connessione.prepareStatement(queryUpdateTavolata);
			updateTavolataStatement.setString(1, dataArrivo);
			updateTavolataStatement.setString(2, cameriere);
			updateTavolataStatement.setInt(3, codTavolata);
			
			int esitoUpdate = updateTavolataStatement.executeUpdate();

			if(esitoUpdate==1)
				return true;
			
			updateTavolataStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteTavolata(int codTavolata) {
		try {
			String queryDeleteTavolata = "DELETE FROM Tavolata WHERE Codtavolata = ?";
			PreparedStatement deleteTavolataStatement = connessione.prepareStatement(queryDeleteTavolata);
			deleteTavolataStatement.setInt(1, codTavolata);
			
			int esitoDelete = deleteTavolataStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteTavolataStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	

}
