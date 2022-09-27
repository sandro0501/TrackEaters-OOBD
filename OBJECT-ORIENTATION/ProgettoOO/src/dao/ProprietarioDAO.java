package dao;

import java.sql.Date;

public interface ProprietarioDAO {
	int getCodiceProprietarioFromUsername(String usernameProprietario);
	boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password);
	public int getNumeroAvventoriPositiviRistoranti(String dataInizio, String dataFine);
	public int getNumeroTotaleAvventoriRistoranti(String dataInizio, String dataFine);
	public int getNumeroAvventoriInterniRistoranti(String dataInizio, String dataFine);
	public int getNumeroAvventoriEsterniRistoranti(String dataInizio, String dataFine);
}
