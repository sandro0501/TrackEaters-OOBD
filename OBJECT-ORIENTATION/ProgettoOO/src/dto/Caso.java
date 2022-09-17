package dto;

import java.sql.Date;

public class Caso {
	
	private int codiceCaso;
	private Date dataRegistrazione;
	private String numeroCID;
	private String stato;
	private String note;
	
	private Avventore avventorePositivo;
	private Cameriere camerierePositivo;
	private Operatore tracciamentoOperatore;
	
	public Caso(int codiceCaso, Date dataRegistrazione, String numeroCID, String stato, String note) {
		this.codiceCaso = codiceCaso;
		this.dataRegistrazione = dataRegistrazione;
		this.numeroCID = numeroCID;
		this.stato = stato;
		this.note = note;
	}
	
	public int getCodiceCaso() {
		return codiceCaso;
	}
	
	public void setCodiceCaso(int codiceCaso) {
		this.codiceCaso = codiceCaso;
	}


	public Date getDataRegistrazione() {
		return dataRegistrazione;
	}

	public void setDataRegistrazione(Date dataRegistrazione) {
		this.dataRegistrazione = dataRegistrazione;
	}

	public String getNumeroCID() {
		return numeroCID;
	}

	public void setNumeroCID(String numeroCID) {
		this.numeroCID = numeroCID;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Avventore getAvventorePositivo() {
		return avventorePositivo;
	}

	public void setAvventorePositivo(Avventore avventorePositivo) {
		this.avventorePositivo = avventorePositivo;
	}

	public Cameriere getCamerierePositivo() {
		return camerierePositivo;
	}

	public void setCamerierePositivo(Cameriere camerierePositivo) {
		this.camerierePositivo = camerierePositivo;
	}

	public Operatore getTracciamentoOperatore() {
		return tracciamentoOperatore;
	}

	public void setTracciamentoOperatore(Operatore tracciamentoOperatore) {
		this.tracciamentoOperatore = tracciamentoOperatore;
	}

	
}
