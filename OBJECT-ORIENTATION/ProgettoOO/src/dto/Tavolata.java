package dto;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

public class Tavolata {
	
	private int codiceTavolata;
	private Date dataArrivo;
	private Time oraArrivo = Time.valueOf("20:00:00");
	private Time oraUscita = Time.valueOf("22:00:00");

	private Tavolo composizioneTavolo;
	private List<Avventore> partecipazioneAvventore; 
	private Cameriere servizioCameriere; 
	
	
	public Tavolata(Integer codiceTavolata, Date dataArrivo) {
		super();
		this.codiceTavolata = codiceTavolata;
		this.dataArrivo = dataArrivo;
	}

	public int getCodiceTavolata() {
		return codiceTavolata;
	}

	public void setCodiceTavolata(int codiceTavolata) {
		this.codiceTavolata = codiceTavolata;
	}
	
	public Tavolata(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Date getDataArrivo() {
		return dataArrivo;
	}
	
	public void setDataArrivo(Date dataArrivo) {
		this.dataArrivo = dataArrivo;
	}

	public Time getOraArrivo() {
		return oraArrivo;
	}

	public Time getOraUscita() {
		return oraUscita;
	}
	
	public Tavolo getComposizioneTavolo() {
		return composizioneTavolo;
	}

	public void setComposizioneTavolo(Tavolo composizioneTavolo) {
		this.composizioneTavolo = composizioneTavolo;
	}

	public List<Avventore> getPartecipazioneTavolata() {
		return partecipazioneAvventore;
	}

	public void setPartecipazioneTavolata(List<Avventore> partecipazioneAvventore) {
		this.partecipazioneAvventore = partecipazioneAvventore;
	}
	
	public Cameriere getServizioCameriere() {
		return servizioCameriere;
	}

	public void setServizioCameriere(Cameriere servizioCameriere) {
		this.servizioCameriere = servizioCameriere;
	}

}
