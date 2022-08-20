package dao;

import java.util.ArrayList;

import dto.Ristorante;

public interface RistoranteDAO {
	
	 ArrayList<Ristorante> getRistorantiByUsernameProprietario(String usernameProprietario);

}
