package dao;

import java.sql.Date;
import java.util.ArrayList;
import dto.Cameriere;

public interface CameriereDAO {
	
	public ArrayList<Cameriere> getCamerieriRistorante(int codRistorante);
	public ArrayList<Cameriere> getAllCamerieri();
	boolean insertCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso, String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza, String telefono, String email, int codRistorante);
	boolean deleteCameriere(String numeroCid);
	public boolean updateCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, int codRistorante);
}
