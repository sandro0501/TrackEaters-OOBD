package dao;

import java.util.ArrayList;

import dto.Avventore;

public interface AvventoreDAO {
	ArrayList<Avventore> getAvventoriByCodTavolata(int codTavolata);
	boolean getEsistenzaAvventoreByNumcid(String numCid);
	boolean insertAvventore(String numCid, String nome, String cognome, String dataNascita, String sesso, String cittaNascita, String provNascita, String cittaResidenza, String provResidenza, String telefono, String email, double temperatura, char greenpass);
	boolean aggiungiAvventoreATavolata(String numCid, int codTavolata);
	boolean aggiungiAvventoreARistorante(int codRistorante, String numCid);
	boolean updateAvventore(String numcid, String nome, String cognome, String dataNascita, String sesso, String cittaNascita, String provNascita, String cittaResidenza, String provResidenza, String telefono, String email, double temperatura, char greenpass);
	boolean deleteAvventore(String numCid); 
	boolean deleteAvventoreFromTavolata(String numCid, int codTavolata);
}
