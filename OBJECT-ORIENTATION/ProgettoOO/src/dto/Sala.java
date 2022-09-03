package dto;

public class Sala {
	
	private String denominazione;
	private int capienza;
	private int dimensioneInMq; 
	private String tipoSala;
	
	private Ristorante appartenenzaRistorante;

	public Sala(String denominazione, Integer capienza, Integer dimensioneInMq, String tipoSala) {
		this.denominazione = denominazione;
		this.capienza = capienza;
		this.dimensioneInMq = dimensioneInMq;
		this.tipoSala = tipoSala;
	}

	public String getDenominazione() {
		return denominazione;
	}

	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}

	public int getCapienza() {
		return capienza;
	}

	public void setCapienza(int capienza) {
		this.capienza = capienza;
	}

	public Integer getDimensioneInMq() {
		return dimensioneInMq;
	}

	public void setDimensioneInMq(Integer dimensioneInMq) {
		this.dimensioneInMq = dimensioneInMq;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public Ristorante getAppartenenzaRistorante() {
		return appartenenzaRistorante;
	}

	public void setAppartenenzaRistorante(Ristorante appartenenzaRistorante) {
		this.appartenenzaRistorante = appartenenzaRistorante;
	}
	
}
