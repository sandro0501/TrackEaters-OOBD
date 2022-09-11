package dao;

import java.sql.Date;
import java.util.ArrayList;
import dto.Cameriere;

public interface CameriereDAO {
	
	ArrayList<Cameriere> getCamerieriRistorante(int codRistorante);
	Cameriere getCameriereByCodTavoloAndDataTavolata(int codTavolo, Date dataTavolata);
	String getNumcidCameriereByNomeAndCognomeAndRistorante(String nome, String cognome, int codRistorante);

}
