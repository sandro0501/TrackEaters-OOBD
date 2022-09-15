package dao;

import java.util.ArrayList;

import dto.Sala;

public interface SalaDAO {
	 ArrayList<Sala> getSaleByCodRistorante(int codRistorante);
	 int getCodiceSalaByDenominazioneAndCapienza(String denominazione, int capienza);
	 Sala getSalaByCodice(int codSala);
	 boolean insertSala(String denominazione, int capienza, int dimensioneMq, String tipologia, int ristorante);
	 boolean updateSala(int codSala, String denominazione, int capienza, int dimensioneMq, String tipologia);
	 boolean deleteSala(int codSala); 
}
