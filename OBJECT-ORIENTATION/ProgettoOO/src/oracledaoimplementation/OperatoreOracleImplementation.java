package oracledaoimplementation;

import java.sql.*;

import dto.ManagerRistorante;
import dto.Operatore;
import dto.Proprietario;
import dao.OperatoreDAO;
import database.ConnessioneDatabase;


public class OperatoreOracleImplementation implements OperatoreDAO {
	
	private Connection connessione = null;
	
	public OperatoreOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Operatore getOperatore(String username, String password, String tipoOperatore) {
		try {
			String queryGetOperatore = "SELECT * FROM "+tipoOperatore+" WHERE Username = ? AND Password = ?";
			PreparedStatement getOperatore = connessione.prepareStatement(queryGetOperatore);
			getOperatore.setString(1, username);
			getOperatore.setString(2, password);
			ResultSet rs = getOperatore.executeQuery();
	
			if(rs.next())
				return estraiPOperatoreFromResultSet(rs);
			else
				//per debug
				System.out.println("Errore: nessun utente trovato nel DB.");
			
			rs.close();
			getOperatore.close();
			
		} catch (SQLException e) {
			System.out.println("Codice errore SQL: "+e.getErrorCode()); 
			System.out.println("SQL State: "+e.getSQLState()); 
			System.out.println("Messaggio: " +e.getMessage());
		}
		return null;
	}

	private Operatore estraiPOperatoreFromResultSet(ResultSet rs) throws SQLException {
		Operatore operatore = new Proprietario();
		
		operatore.setUsername(rs.getString("Username"));
		operatore.setPassword(rs.getString("Password"));
		operatore.setNome(rs.getString("Nome"));
		operatore.setCognome(rs.getString("Cognome"));
		operatore.setEmail(rs.getString("Email"));
		
		return operatore;
	}
}
