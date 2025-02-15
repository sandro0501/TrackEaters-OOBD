package dao;

import java.util.ArrayList;
import dto.Ristorante;

public interface RistoranteDAO {
	 ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario);
	 Ristorante getRistoranteFromUsernameManager(String usernameManager);
	 Ristorante getRistoranteByDenominazioneAndIndirizzo(String denominazione, String indirizzo);
	 Ristorante getRistoranteByCode(int codRistorante);
	 int getCodiceRistoranteByDenominazioneAndIndirizzo(String denominazione, String indirizzo);
	 
	 boolean insertRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, 
			 String email, String sitoweb, int proprietario);
	 
	 boolean updateRistorante(int codRistorante, String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, 
			 String email, String sitoweb);
	 
	 boolean deleteRistorante(int codRistorante);
	 public int getNumeroPositiviRistorante(String dataInizio, String dataFine, int codRistorante);
	 public int getNumeroTotaleAvventoriRistorante(String dataInizio, String dataFine, int codRistorante);
	 public int getNumeroAvventoriInterniRistorante(String dataInizio, String dataFine, int codRistorante);
	 public int getNumeroAvventoriEsterniRistorante(String dataInizio, String dataFine, int codRistorante);
	 
	 
}
