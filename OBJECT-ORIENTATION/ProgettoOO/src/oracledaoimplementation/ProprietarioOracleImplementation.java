package oracledaoimplementation;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.ProprietarioDAO;
import database.ConnessioneDatabase;

public class ProprietarioOracleImplementation implements ProprietarioDAO {

	private Connection connessione = null;
	
	public ProprietarioOracleImplementation() {
		try {
			connessione = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password) {
		try {
			String queryUpdateProprietario = "UPDATE Proprietario SET Username=?, Password=?, Nome=?, Cognome=?, Email=? WHERE Proprietario.Username=?";
			PreparedStatement updateProprietarioStatement = connessione.prepareStatement(queryUpdateProprietario);
			updateProprietarioStatement.setString(1, newUsername);
			updateProprietarioStatement.setString(2, password);
			updateProprietarioStatement.setString(3, nome);
			updateProprietarioStatement.setString(4, cognome);
			updateProprietarioStatement.setString(5, email);
			updateProprietarioStatement.setString(6, currentUsername);
			
			int esitoUpdate = updateProprietarioStatement.executeUpdate();
			if(esitoUpdate==1)
				return true;
			
			updateProprietarioStatement.close();
			
		} catch (SQLException e) {
			
			if(e.getErrorCode()==20011) {
				JLabel lblErrore = new JLabel("Password non valida. Deve contenere almeno 8 caratteri, una lettera ed un numero!");
				lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
				JOptionPane.showMessageDialog(null,lblErrore,"Errore inserimento dati",JOptionPane.ERROR_MESSAGE);	
			} else {
				e.printStackTrace();
			}
		}
		
		return false;
	}
	
}
