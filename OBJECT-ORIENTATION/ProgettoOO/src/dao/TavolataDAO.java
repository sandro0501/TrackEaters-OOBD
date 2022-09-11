package dao;

import java.sql.Date;
import java.util.ArrayList;

import dto.Tavolata;

public interface TavolataDAO {
	ArrayList<Tavolata> getTavolateByCodTavolo(int codTavolo);
	int getCodiceTavolataByDataArrivoAndTavolo(String DataArrivo, int codTavolo);
	boolean insertTavolata(String dataArrivo, int codTavolo, String cameriere);
	boolean updateTavolata(int codTavolata, String dataArrivo, String cameriere);
	boolean deleteTavolata(int codTavolata); 
}
