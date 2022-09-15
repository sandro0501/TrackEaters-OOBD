package dao;

import dto.ManagerRistorante;
import java.util.ArrayList;

public interface ManagerRistoranteDAO {
	ArrayList<ManagerRistorante> getAllManager();
	ManagerRistorante getInformazioniManagerByCodRistorante(int codRistorante);
	String getTelefonoManagerByUsername(String usernameManager);
	boolean insertManager(String username, String password, String nome, String cognome, String telfono, String email, int ristoranteGestito);
	boolean updateManager(String username, String password, String nome, String cognome, String telfono, String email, int ristoranteGestito);
	boolean deleteManager(String username);
}
