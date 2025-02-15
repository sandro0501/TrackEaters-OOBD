package dao;

import java.util.ArrayList;
import dto.Caso;

public interface CasoDAO {
	ArrayList<Caso> getCasiCovidByCodRistorante(int codRistorante); 
	boolean insertCaso(String dataRegistrazione,String numCid,String stato,String note);
	boolean updateCaso(int codiceCaso,String dataRegistrazione,String numCid,String stato,String note);
	boolean deleteCaso(int codiceCaso);
}
