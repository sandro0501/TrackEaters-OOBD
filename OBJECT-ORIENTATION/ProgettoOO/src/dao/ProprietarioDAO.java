package dao;

public interface ProprietarioDAO {
	int getCodiceProprietarioFromUsername(String usernameProprietario);
	boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password);
}
