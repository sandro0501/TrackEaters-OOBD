package dao;
import dto.ManagerRistorante;

public interface ManagerRistoranteDAO {
	
	ManagerRistorante getInformazioniManagerByCodRistorante(int codRistorante);
	String getTelefonoManagerByUsername(String usernameManager);
}
