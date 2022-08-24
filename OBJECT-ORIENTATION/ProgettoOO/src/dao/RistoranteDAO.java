package dao;

import java.util.ArrayList;

import dto.Ristorante;

public interface RistoranteDAO {
	
	 ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario);
	 boolean insertRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, String email, String sitoweb, int proprietario);
	 boolean deleteRistorante(String denominazione);
	 
}
