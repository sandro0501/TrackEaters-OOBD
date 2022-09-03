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
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Sala> getSaleByCodRistorante(int codRistorante) {
		ArrayList<Sala> sale = new ArrayList<Sala>();
		try {
			String queryGetSaleRistorante = "SELECT s.denominazione,s.capienzaavventori,s.dimensionemq,s.tiposala FROM SALA s JOIN RISTORANTE r ON s.ristorante=r.codristorante WHERE r.codristorante=?";
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

}
