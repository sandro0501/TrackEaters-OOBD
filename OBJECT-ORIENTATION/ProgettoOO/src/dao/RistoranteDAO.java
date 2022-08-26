package dao;

import java.util.ArrayList;

import dto.Ristorante;

public interface RistoranteDAO {
	
	 ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario);
	 int getCodiceRistoranteByDenominazioneAndIndirizzo(String denominazione, String indirizzo);
	 boolean insertRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, String email, String sitoweb, int proprietario);
	 boolean updateRistorante(int codRistorante, String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, String email, String sitoweb);
	 boolean deleteRistorante(int codRistorante); 
}
