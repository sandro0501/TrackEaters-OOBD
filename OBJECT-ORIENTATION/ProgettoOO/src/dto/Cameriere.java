package dto;

import java.sql.Date;

public class Cameriere {
	
	private String numeroCid;
	private String nome;
	private String cognome;
	private Date dataDiNascita;
	private String sesso;
	private String cittaDiNascita;
	private String provinciaDiNascita;
	private String cittaDiResidenza;
	private String provinciaDiResidenza;
	private String telefono;
	private String email;
	
	private Ristorante lavoratoreRistorante;

	public Cameriere(String numeroCid, String nome, String cognome, Date dataDiNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email) {
		this.numeroCid = numeroCid;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.sesso = sesso;
		this.cittaDiNascita = cittaDiNascita;
		this.provinciaDiNascita = provinciaDiNascita;
		this.cittaDiResidenza = cittaDiResidenza;
		this.provinciaDiResidenza = provinciaDiResidenza;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNumeroCid() {
		return numeroCid;
	}

	public void setNumeroCid(String numeroCid) {
		this.numeroCid = numeroCid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getSesso() {
		return sesso;
	}

	public void setSesso(String sesso) {
		this.sesso = sesso;
	}

	public String getCittaDiNascita() {
		return cittaDiNascita;
	}

	public void setCittaDiNascita(String cittaDiNascita) {
		this.cittaDiNascita = cittaDiNascita;
	}

	public String getProvinciaDiNascita() {
		return provinciaDiNascita;
	}

	public void setProvinciaDiNascita(String provinciaDiNascita) {
		this.provinciaDiNascita = provinciaDiNascita;
	}

	public String getCittaDiResidenza() {
		return cittaDiResidenza;
	}

	public void setCittaDiResidenza(String cittaDiResidenza) {
		this.cittaDiResidenza = cittaDiResidenza;
	}

	public String getProvinciaDiResidenza() {
		return provinciaDiResidenza;
	}

	public void setProvinciaDiResidenza(String provinciaDiResidenza) {
		this.provinciaDiResidenza = provinciaDiResidenza;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Ristorante getLavoratoreRistorante() {
		return lavoratoreRistorante;
	}

	public void setLavoratoreRistorante(Ristorante lavoratoreRistorante) {
		this.lavoratoreRistorante = lavoratoreRistorante;
	}
	
	
	

}
