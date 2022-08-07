package dto;

import java.util.List;

public class Proprietario extends Operatore {
	
	private List<Ristorante> ristorantiAmministrati;

	public Proprietario(String username, String password, String nome, String cognome, String email) {
		super(username, password, nome, cognome, email);
	}

	public List<Ristorante> getRistorantiAmministrati() {
		return ristorantiAmministrati;
	}

	public void setRistorantiAmministrati(List<Ristorante> ristorantiAmministrati) {
		this.ristorantiAmministrati = ristorantiAmministrati;
	}
	
}
