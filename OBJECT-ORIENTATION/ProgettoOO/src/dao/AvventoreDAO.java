package dao;

import java.util.ArrayList;
import dto.Avventore;

public interface AvventoreDAO {
	ArrayList<Avventore> getAvventoriByCodTavolata(int codTavolata);
	ArrayList<Avventore> getAvventoriRistorante(int codRistorante);
	Avventore getAvventoreByNumcid(String numCid);
	boolean getEsistenzaAvventoreByNumcid(String numCid);
	
	boolean insertAvventore(String numCid, String nome, String cognome, String dataNascita, String sesso, String cittaNascita, 
			String provNascita, String cittaResidenza, String provResidenza, String telefono, String email, double temperatura, char greenpass);
	
	boolean insertAvventoreATavolata(String numCid, int codTavolata);
	boolean insertAvventoreARistorante(int codRistorante, String numCid);
	
	boolean updateAvventore(String numcid, String nome, String cognome, String dataNascita, String sesso, String cittaNascita, 
			String provNascita, String cittaResidenza, String provResidenza, String telefono, String email, double temperatura, char greenpass);
	
	boolean deleteAvventore(String numCid); 
	boolean deleteAvventoreFromTavolata(String numCid, int codTavolata);
}
