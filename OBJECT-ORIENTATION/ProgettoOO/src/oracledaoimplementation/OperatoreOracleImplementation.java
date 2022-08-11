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
	public Operatore getOperatore(String username, String password, String ruoloOperatore) {
		try {
			String queryGetOperatore = "SELECT * FROM ? WHERE Username = ? AND Password = ?";
			PreparedStatement getOperatore = connessione.prepareStatement(queryGetOperatore);
			getOperatore.setString(1, ruoloOperatore);
			getOperatore.setString(2, username);
			getOperatore.setString(3, password);
			ResultSet rs = getOperatore.executeQuery();
			
			if(rs.next())
            {
				if (ruoloOperatore == "Proprietario")
					return estraiProprietarioFromResultSet(rs);
				else
					return estraiManagerRistoranteFromResultSet(rs);
            }

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	private Operatore estraiProprietarioFromResultSet(ResultSet rs) throws SQLException {
		Proprietario proprietario = new Proprietario();
		
		proprietario.setUsername(rs.getString("Username"));
		proprietario.setPassword(rs.getString("Password"));
		proprietario.setNome(rs.getString("Nome"));
		proprietario.setCognome(rs.getString("Cognome"));
		proprietario.setEmail(rs.getString("Email"));
		
		return proprietario;
	}
	
	private Operatore estraiManagerRistoranteFromResultSet(ResultSet rs) throws SQLException {
		ManagerRistorante managerRistorante = new ManagerRistorante();
		
		managerRistorante.setUsername(rs.getString("Username"));
		managerRistorante.setPassword(rs.getString("Password"));
		managerRistorante.setNome(rs.getString("Nome"));
		managerRistorante.setCognome(rs.getString("Cognome"));
		managerRistorante.setEmail(rs.getString("Email"));
		managerRistorante.setTelefono("Telefono");
		
		return managerRistorante;
	}
}
