package dao;

import java.util.ArrayList;
import dto.Tavolo;

public interface TavoloDAO {
	ArrayList<Tavolo> getTavoliByCodSala(int codSala);
	boolean insertTavolo(int maxAvventori, int codSala);
	boolean updateTavolo(int codTavolo, int maxAvventori);
	boolean deleteTavolo(int codTavolo); 
}
