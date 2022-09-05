package oracledaoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.SalaDAO;
import database.ConnessioneDatabase;
import dto.Ristorante;
import dto.Sala;

public class SalaOracleImplementation implements SalaDAO {
	
	private Connection connessione = null;
	
	public SalaOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
	}

	@Override
	public ArrayList<Sala> getSaleByCodRistorante(int codRistorante) {
		ArrayList<Sala> sale = new ArrayList<Sala>();
		try {
			String queryGetSaleRistorante = "SELECT s.denominazione,s.capienzaavventori,s.dimensionemq,s.tiposala FROM SALA s JOIN RISTORANTE r ON s.ristorante=r.codristorante WHERE r.codristorante=? ORDER BY s.codsala";
			PreparedStatement stmtGetSaleRistorante = connessione.prepareStatement(queryGetSaleRistorante);
			stmtGetSaleRistorante.setInt(1, codRistorante);
			ResultSet rs = stmtGetSaleRistorante.executeQuery();
			
			while(rs.next()) {
				Sala s = new Sala(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
				sale.add(s);
			}
			
			rs.close();
			stmtGetSaleRistorante.close();	
			    
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return sale;
	}

	@Override
	public int getCodiceSalaByDenominazioneAndCapienza(String denominazione, int capienza) {
		int codSala = 0;
		
		try {
			String queryGetCodSala = "SELECT S.Codsala FROM Sala S WHERE S.Denominazione = ? AND S.CapienzaAvventori = ?";
			PreparedStatement getCodSalaStatement = connessione.prepareStatement(queryGetCodSala);
			getCodSalaStatement.setString(1, denominazione);
			getCodSalaStatement.setInt(2, capienza);
			ResultSet rs = getCodSalaStatement.executeQuery();

			if(rs.next())
				codSala = rs.getInt("CodSala");
			
			rs.close();
			getCodSalaStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		
		return codSala;
	}

	@Override
	public boolean insertSala(String denominazione, int capienza, int dimensioneMq, String tipologia, int ristorante) {
		try {
			String queryInsertSala = "INSERT INTO SALA (Denominazione,CapienzaAvventori,Dimensionemq,Tiposala,Ristorante) VALUES (?,?,?,?,?)";
			PreparedStatement insertSalaStatement = connessione.prepareStatement(queryInsertSala);
			insertSalaStatement.setString(1,denominazione);
			insertSalaStatement.setInt(2,capienza);
			insertSalaStatement.setInt(3,dimensioneMq);
			insertSalaStatement.setString(4,tipologia);
			insertSalaStatement.setInt(5,ristorante);
			
			int esitoInsert = insertSalaStatement.executeUpdate();
			if(esitoInsert==1)
				return true;
			
			insertSalaStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateSala(int codSala, String denominazione, int capienza, int dimensioneMq, String tipologia) {
		
		try {
			String queryUpdateSala = "UPDATE Sala SET Denominazione=?,CapienzaAvventori=?,DimensioneMq=?,TipoSala=? WHERE CodSala=?";
			PreparedStatement updateSalaStatement = connessione.prepareStatement(queryUpdateSala);
			updateSalaStatement.setString(1,denominazione);
			updateSalaStatement.setInt(2,capienza);
			updateSalaStatement.setInt(3,dimensioneMq);
			updateSalaStatement.setString(4,tipologia);
			updateSalaStatement.setInt(5,codSala);
			
			int esitoUpdate = updateSalaStatement.executeUpdate();

			if(esitoUpdate==1)
				return true;
			
			updateSalaStatement.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteSala(int codSala) {
		try {
			String queryDeleteSala = "DELETE FROM Sala WHERE Sala.CodSala = ?";
			PreparedStatement deleteSalaStatement = connessione.prepareStatement(queryDeleteSala);
			deleteSalaStatement.setInt(1, codSala);
			
			int esitoDelete = deleteSalaStatement.executeUpdate();
			if(esitoDelete==1)
				return true;
			
			deleteSalaStatement.close();
			
		} catch (SQLException e) { 
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return false;
	}

	@Override
	public Sala getSalaByCodice(int codSala) {
		Sala sala = null;
		try {
			String queryGetSala = "SELECT denominazione,capienzaavventori,dimensionemq,tiposala FROM SALA WHERE codSala = ?";
			PreparedStatement stmtGetSala = connessione.prepareStatement(queryGetSala);
			stmtGetSala.setInt(1, codSala);
			ResultSet rs = stmtGetSala.executeQuery();
			
			if(rs.next()) {
				sala = new Sala(rs.getString(1),rs.getInt(2),rs.getInt(3),rs.getString(4));
			}
			
			rs.close();
			stmtGetSala.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}	
		return sala;
	}

}
