package dao;

public interface ProprietarioDAO {
	
	boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password);

}
