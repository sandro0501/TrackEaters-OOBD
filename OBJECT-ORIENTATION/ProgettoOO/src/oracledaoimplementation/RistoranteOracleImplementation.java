package oracledaoimplementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.RistoranteDAO;
import database.ConnessioneDatabase;
import dto.Ristorante;

public class RistoranteOracleImplementation implements RistoranteDAO {
	
	private Connection connessione = null;
	
	public RistoranteOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario) {
		ArrayList<Ristorante> ristoranti = new ArrayList<Ristorante>();
		try {
			String queryGetRistoranti = "SELECT R.Denominazione, R.Indirizzo, R.Telefono, R.Citta, R.Prov, R.Cap, R.Email, R.SitoWeb  FROM Ristorante R JOIN Proprietario P ON R.Proprietario = P.CodProprietario WHERE P.Username=?";
			PreparedStatement stmtGetRistoranti = connessione.prepareStatement(queryGetRistoranti);
			stmtGetRistoranti.setString(1, usernameProprietario);
			ResultSet rs = stmtGetRistoranti.executeQuery();
			
			while(rs.next()) {
				Ristorante r = new Ristorante(	rs.getString(1),
											  	rs.getString(2),
											  	rs.getString(3),
											  	rs.getString(4),
											 	rs.getString(5),
											 	rs.getString(6),
											 	rs.getString(7),
											 	rs.getString(8));
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
	
	
}
