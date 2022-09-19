package dao;

import java.sql.Date;

public interface ProprietarioDAO {
	int getCodiceProprietarioFromUsername(String usernameProprietario);
	boolean updateProprietario(String currentUsername, String nome, String cognome, String newUsername, String email, String password);
	public int numeroPositivi(String dataInizio, String dataFine);
	public int numeroTotaleAvventori(String dataInizio, String dataFine);
	public int numeroAvventoriInterni(String dataInizio, String dataFine);
	public int numeroAvventoriEsterni(String dataInizio, String dataFine);
}
