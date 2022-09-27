package dao;

import java.sql.Date;
import java.util.ArrayList;
import dto.Cameriere;

public interface CameriereDAO {
	public ArrayList<Cameriere> getAllCamerieri();
	boolean insertCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso, String cittaDiNascita, 
			String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza, String telefono, String email, int codRistorante);
	
	public boolean updateCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, int codRistorante);
	
	
	boolean deleteCameriere(String numeroCid);
	ArrayList<Cameriere> getCamerieriRistorante(int codRistorante);
	Cameriere getCameriereByCodTavoloAndDataTavolata(int codTavolo, Date dataTavolata);
	String getNumcidCameriereByNomeAndCognomeAndRistorante(String nome, String cognome, int codRistorante);
}
