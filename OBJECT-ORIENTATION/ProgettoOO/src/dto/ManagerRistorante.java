package dto;

public class ManagerRistorante extends Operatore {
	
	private String telefono;
	
	private Ristorante ristoranteGestito;
	
	public ManagerRistorante() {
		
	}

	public ManagerRistorante(String username, String password, String nome, String cognome, String email) {
		super(username, password, nome, cognome, email);
	}
	
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Ristorante getRistoranteGestito() {
		return ristoranteGestito;
	}

	public void setRistoranteGestito(Ristorante ristoranteGestito) {
		this.ristoranteGestito = ristoranteGestito;
	}

	

}
