package dto;

public class Tavolo {
	
	private int codice;
	private int numeroMassimoDiAvventori;
	
	private Sala contenimentoSala;
	
	public Tavolo(int codice, int numeroMassimoDiAvventori) {
		this.codice = codice;
		this.numeroMassimoDiAvventori = numeroMassimoDiAvventori;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public int getNumeroMassimoDiAvventori() {
		return numeroMassimoDiAvventori;
	}

	public void setNumeroMassimoDiAvventori(int numeroMassimoDiAvventori) {
		this.numeroMassimoDiAvventori = numeroMassimoDiAvventori;
	}

	public Sala getContenimentoSala() {
		return contenimentoSala;
	}

	public void setContenimentoSala(Sala contenimentoSala) {
		this.contenimentoSala = contenimentoSala;
	}
	
	
	

}
