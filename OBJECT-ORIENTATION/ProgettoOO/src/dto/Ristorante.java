package dto;

import java.util.List;

public class Ristorante {
	
	private String denominazione;
	private String indirizzo;
	private String telefono;
	private String citta;
	private String provincia;
	private String cap;
	private String email;
	private String sitoWeb;
	
	private Proprietario proprietarioRistorante;
	private List<ManagerRistorante> managersRistorante;
	private List<Cameriere> camerieriRistorante;
	private List<Avventore> accoglienzaAvventori;
	
	public Ristorante(String denominazione, String indirizzo, String telefono, String citta, String provincia,
			String cap, String email, String sitoWeb) {
		this.denominazione = denominazione;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.citta = citta;
		this.provincia = provincia;
		this.cap = cap;
		this.email = email;
		this.sitoWeb = sitoWeb;
	}

	public String getDenominazione() {
		return denominazione;
	}
	
	public void setDenominazione(String denominazione) {
		this.denominazione = denominazione;
	}
	
	public String getIndirizzo() {
		return indirizzo;
	}
	
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	public String getTelefono() {
		return telefono;
	}
	
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	public String getCitta() {
		return citta;
	}
	
	public void setCitta(String citta) {
		this.citta = citta;
	}
	
	public String getProvincia() {
		return provincia;
	}
	
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	
	public String getCap() {
		return cap;
	}
	
	public void setCap(String cap) {
		this.cap = cap;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSitoWeb() {
		return sitoWeb;
	}
	
	public void setSitoWeb(String sitoWeb) {
		this.sitoWeb = sitoWeb;
	}

	public Proprietario getProprietarioRistorante() {
		return proprietarioRistorante;
	}

	public void setProprietarioRistorante(Proprietario proprietarioRistorante) {
		this.proprietarioRistorante = proprietarioRistorante;
	}

	public List<ManagerRistorante> getManagersRistorante() {
		return managersRistorante;
	}

	public void setManagersRistorante(List<ManagerRistorante> managersRistorante) {
		this.managersRistorante = managersRistorante;
	}

	public List<Cameriere> getCamerieriRistorante() {
		return camerieriRistorante;
	}

	public void setCamerieriRistorante(List<Cameriere> camerieriRistorante) {
		this.camerieriRistorante = camerieriRistorante;
	}

	public List<Avventore> getAccoglienzaAvventori() {
		return accoglienzaAvventori;
	}

	public void setAccoglienzaAvventori(List<Avventore> accoglienzaAvventori) {
		this.accoglienzaAvventori = accoglienzaAvventori;
	}
	
}
