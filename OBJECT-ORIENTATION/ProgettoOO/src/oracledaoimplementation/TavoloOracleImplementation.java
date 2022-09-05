package oracledaoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	public boolean insertTavolo(int codTavolo, int maxAvventori, int codSala) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTavolo(int maxAvventori) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTavolo(int codTavolo) {
		// TODO Auto-generated method stub
		return false;
	}

}
