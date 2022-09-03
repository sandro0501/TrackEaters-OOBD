package controller;

import dto.Avventore;
import dto.Cameriere;
import dto.Caso;
import dto.ManagerRistorante;
import dto.Operatore;
import dto.Proprietario;
import dto.Ristorante;
import dto.Sala;
import dto.Tavolata;
import dto.Tavolo;

import dao.*;
import oracledaoimplementation.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionListener;

import gui.*;

import java.util.*;
import java.sql.*;
import database.ConnessioneDatabase;

public class Controller { 
	
	private AvventoreDAO avventoreDAO;
	private CameriereDAO cameriereDAO;
	private CasoDAO casoDAO;
	private ManagerRistoranteDAO managerRistoranteDAO;
	private OperatoreDAO operatoreDAO;
	private ProprietarioDAO proprietarioDAO;
	private RistoranteDAO ristoranteDAO;
	private SalaDAO salaDAO;
	private TavolataDAO tavolataDAO;
	private TavoloDAO tavoloDAO;
	
	private LoginFrame loginPage;
	private HomepageProprietarioFrame proprietarioPage;
	private ImpostazioniProprietarioFrame impostazioniProprietarioPage;
	private RistorantiProprietarioFrame ristorantiProprietarioPage;
	private ModificaRistoranteFrame modificaRistorantePage;
	private AggiungiRistoranteFrame aggiungiRistorantePage;
	private HomepageGestioneRistoranteFrame gestioneRistorantePage; 
	private InfoRistoranteFrame infoRistorantePage;
	private GestioneSaleETavolateFrame gestioneSaleETavolatePage;
	
	private Operatore operatore;
	private Proprietario proprietario;
	private ManagerRistorante managerRistorante;
	

	private Controller() {
		System.setProperty("sun.java2d.uiScale","1.0"); //fix dpi scaling gui
	
		avventoreDAO = new AvventoreOracleImplementation();
		cameriereDAO = new CameriereOracleImplementation();
		casoDAO = new CasoOracleImplementation();
		managerRistoranteDAO = new ManagerRistoranteOracleImplementation();
		operatoreDAO = new OperatoreOracleImplementation();
		proprietarioDAO = new ProprietarioOracleImplementation();
		ristoranteDAO = new RistoranteOracleImplementation();
		salaDAO = new SalaOracleImplementation();
		tavolataDAO = new TavolataOracleImplementation();

	}
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.startLoginFrame();
	}
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/
	//metodi di gestione
	
	//metodo login
	public void loginOperatore(String username, String password, String tipoOperatore) {
		try {
			operatore = operatoreDAO.getOperatore(username, password, tipoOperatore);
			if(tipoOperatore.equals("Proprietario")) 
			{
				//loggato come proprietario
				proprietario = new Proprietario(operatore.getUsername(),operatore.getPassword(),operatore.getNome(),operatore.getCognome(),operatore.getEmail());
				mostraEsitoCorrettoLogin(tipoOperatore, proprietario);
				startHomepageProprietarioFrame();	
			}
			else
			{
				//loggato come manager ristorante
				managerRistorante = new ManagerRistorante(operatore.getUsername(),operatore.getPassword(),operatore.getNome(),operatore.getCognome(),operatore.getEmail());
				managerRistorante.setTelefono(managerRistoranteDAO.getTelefonoManagerByUsername(managerRistorante.getUsername()));
				Ristorante r = ristoranteDAO.getRistoranteFromUsernameManager(managerRistorante.getUsername());
				managerRistorante.setRistoranteGestito(r);
				mostraEsitoCorrettoLogin(tipoOperatore, operatore);
				
				//avvio homepage managerRistorante
				startHomepageGestioneRistoranteFrame(false);
				setHomepageGestioneRistorante(false);		
			}
		} catch (Exception e) {
			mostraErroreLogin();
		}
	}
	
	//metodo che setta homepage proprietario con dati
	public void setHomepageProprietario(Proprietario p) {
		proprietarioPage.setLblNomeCognome(p.getNome(), p.getCognome());
		proprietarioPage.setLblUsername(p.getUsername());
		proprietarioPage.setLblEmail(p.getEmail());
	}
	
	//metodo update proprietario
	public void updateProprietario(String nome, String cognome, String newUsername, String email, String password) {
		boolean esitoUpdate;
		
		try {
			esitoUpdate = proprietarioDAO.updateProprietario(proprietario.getUsername(), nome, cognome, newUsername, email, password);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				//setta di nuovo la homepage del proprietario
				operatore = operatoreDAO.getOperatore(newUsername, password, "Proprietario");
				proprietario.setUsername(operatore.getUsername());
				proprietario.setPassword(operatore.getPassword());
				proprietario.setNome(operatore.getNome());
				proprietario.setCognome(operatore.getCognome());
				proprietario.setEmail(operatore.getEmail());
				setHomepageProprietario(proprietario);
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/* metodo riempi tabella ristoranti proprietario */
	public void riempiTabellaRistorantiDiProprietario() {
		
		try {
			ArrayList<Ristorante> listaRistoranti = ristoranteDAO.getRistorantiByUsernameProprietario(proprietario.getUsername());
			proprietario.setRistorantiAmministrati(listaRistoranti);
			DefaultTableModel model = ristorantiProprietarioPage.getModel();
			model.getDataVector().removeAllElements();
			String[] rigaTabella = new String[8];
			
			for(Ristorante ristorante : proprietario.getRistorantiAmministrati()) {
				ristorante.setProprietarioRistorante(proprietario);
				rigaTabella[0] = ristorante.getDenominazione();
				rigaTabella[1] = ristorante.getIndirizzo();
				rigaTabella[2] = ristorante.getTelefono();
				rigaTabella[3] = ristorante.getCitta();
				rigaTabella[4] = ristorante.getProvincia();
				rigaTabella[5] = ristorante.getCap();
				rigaTabella[6] = ristorante.getEmail();
				rigaTabella[7] = ristorante.getSitoWeb();
				model.addRow(rigaTabella);
			}
			
			model.fireTableDataChanged();
			ristorantiProprietarioPage.setModel(model);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	
	/*Metodo che riempie la tabella dei camerieri nella infoRistorantePage*/
	public void riempiTabellaCamerieriPerRistorante(Boolean proprietario) {
		
		try {
			ArrayList<Cameriere> listaCamerieri;
			Ristorante ristorante;
			
			if (proprietario) {
				JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
				String currentDenominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
				String currentIndirizzo = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
				listaCamerieri = cameriereDAO.getCamerieriRistorante(getCodRistoranteForProprietarioByTabellaRistoranti());
				ristorante = ristoranteDAO.getRistoranteByDenominazioneAndIndirizzo(currentDenominazione, currentIndirizzo);
			} else {
				String currentDenominazione = managerRistorante.getRistoranteGestito().getDenominazione();
				String currentIndirizzo = managerRistorante.getRistoranteGestito().getIndirizzo();
				listaCamerieri = cameriereDAO.getCamerieriRistorante(ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(currentDenominazione, currentIndirizzo));
				ristorante = ristoranteDAO.getRistoranteFromUsernameManager(managerRistorante.getUsername());
			}
			
			ristorante.setCamerieriRistorante(listaCamerieri);
			DefaultTableModel model = infoRistorantePage.getModel();
			model.getDataVector().removeAllElements();
			String[] rigaTabella = new String[11];
			
			for (Cameriere cameriere : ristorante.getCamerieriRistorante()) {
				cameriere.setLavoratoreRistorante(ristorante);
				rigaTabella [0] = cameriere.getNumeroCid();
				rigaTabella [1] = cameriere.getNome();
				rigaTabella [2] = cameriere.getCognome();
				rigaTabella [3] = cameriere.getDataDiNascita().toString();
				rigaTabella [4] = cameriere.getSesso();
				rigaTabella [5] = cameriere.getCittaDiNascita();
				rigaTabella [6] = cameriere.getProvinciaDiNascita();
				rigaTabella [7] = cameriere.getCittaDiResidenza();
				rigaTabella [8] = cameriere.getProvinciaDiResidenza();
				rigaTabella [9] = cameriere.getTelefono();
				rigaTabella [10] = cameriere.getEmail();
				model.addRow(rigaTabella);
			}
			
			model.fireTableDataChanged();
			infoRistorantePage.setModel(model);
			
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	
	/*metodo che recupera il codice del ristorante selezionato dalla tabella per il proprietario*/
	public int getCodRistoranteForProprietarioByTabellaRistoranti() {
		int codRistorante = 0;
		JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
		String currentDenominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
		String currentIndirizzo = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
		
		try {
			codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(currentDenominazione,currentIndirizzo);
		} catch (Exception e) {
			mostraErrore(e);
		}
		
		return codRistorante;
	}
	
	/* metodo inserisci ristorante */
	public void insertRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, String email, String sitoweb) {
		boolean esitoInsert;
		int codProprietario = proprietarioDAO.getCodiceProprietarioFromUsername(proprietario.getUsername());

		try {
			esitoInsert = ristoranteDAO.insertRistorante(denominazione, indirizzo, telefono, citta, prov, cap, email, sitoweb, codProprietario);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaRistorantiDiProprietario(); //aggiorna la tabella dei ristoranti
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo elimina ristorante*/
	public void deleteRistorante(String denominazioneRistorante, String indirizzoRistorante) {
		int codRistorante;
		boolean esitoDelete;
		
		try {
			codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(denominazioneRistorante, indirizzoRistorante);
			esitoDelete = ristoranteDAO.deleteRistorante(codRistorante);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaRistorantiDiProprietario(); //aggiorna la tabella dei ristoranti del proprietario
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che riempie textfield modifica ristorante con campi della tabella*/
	public void riempiCampiModificaRistorantePage() {
		JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
		String currentDenominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
		String currentIndirizzo = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
		String currentTelefono = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 2).toString();
		String currentCitta = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 3).toString();
		String currentProvincia = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 4).toString();
		String currentCap = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 5).toString();
		String currentEmail = "";
		String currentSitoWeb = "";
		
		if(!(tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 6) == null)) {
			currentEmail = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 6).toString();
		}
		if(!(tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 7) == null)) {
			currentSitoWeb = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 7).toString();
		}
		
		modificaRistorantePage.getCampo_Denominazione().setText(currentDenominazione);
		modificaRistorantePage.getCampo_Indirizzo().setText(currentIndirizzo);
		modificaRistorantePage.getCampo_Telefono().setText(currentTelefono);
		modificaRistorantePage.getCampo_Citta().setText(currentCitta);
		modificaRistorantePage.getCampo_Provincia().setSelectedItem(currentProvincia);
		modificaRistorantePage.getCampo_Cap().setText(currentCap);
		modificaRistorantePage.getCampo_Email().setText(currentEmail);
		modificaRistorantePage.getCampo_SitoWeb().setText(currentSitoWeb);
	}
	
	/*metodo update ristorante*/
	public void updateRistorante(String denominazione,String indirizzo, String telefono, String citta,String prov,String cap,String email,String sitoweb) {
		int codRistorante;
		boolean esitoUpdate;
		
		try {
			codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
			esitoUpdate = ristoranteDAO.updateRistorante(codRistorante, denominazione, indirizzo, telefono, citta, prov, cap, email, sitoweb);
			
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaRistorantiDiProprietario(); //aggiorna la tabella dei ristoranti del proprietario
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che setta homepage gestione ristorante per manager e proprietario*/
	public void setHomepageGestioneRistorante(boolean isProprietario) {
		ManagerRistorante manager = null;
		
		if(isProprietario)
		{
			JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
			String denominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
			int codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
			manager = managerRistoranteDAO.getInformazioniManagerByCodRistorante(codRistorante);
			
			gestioneRistorantePage.setLblDenominazioneRistorante("Ristorante "+"\""+denominazione+"\"");
			if(manager != null) 
			{
				gestioneRistorantePage.getLblUsernameManager().setText(manager.getUsername()+" - "+manager.getNome()+" "+manager.getCognome());
				gestioneRistorantePage.getLblEmailManager().setText(manager.getEmail());
				gestioneRistorantePage.getLblTelefonoManager().setText(managerRistoranteDAO.getTelefonoManagerByUsername(manager.getUsername()));
			}
			else //il ristorante non ha manager
			{
				gestioneRistorantePage.getLblInfoManager().setVisible(false);
				gestioneRistorantePage.getLblUsernameManager().setVisible(false);
				gestioneRistorantePage.getLblEmailManager().setVisible(false);
				gestioneRistorantePage.getLblTelefonoManager().setVisible(false);
			}
		}
		else //loggato come manager
		{
			gestioneRistorantePage.setLblDenominazioneRistorante("Ristorante "+"\""+managerRistorante.getRistoranteGestito().getDenominazione()+"\"");
			gestioneRistorantePage.getLblUsernameManager().setText(managerRistorante.getUsername()+" - "+managerRistorante.getNome()+" "+managerRistorante.getCognome());
			gestioneRistorantePage.getLblEmailManager().setText(managerRistorante.getEmail());
			gestioneRistorantePage.getLblTelefonoManager().setText(managerRistorante.getTelefono());
		}
	}

	/*metodo che setta informazioni ristorante page per manager e proprietario*/
	public void setInformazioniRistorante(boolean isProprietario) {
		Ristorante ristorante = null;
		if (isProprietario) {
			JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
			String denominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
			String indirizzo = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
			ristorante = ristoranteDAO.getRistoranteByDenominazioneAndIndirizzo(denominazione, indirizzo);
			setLabelsInformazioniRistorante(ristorante);
		} else {
			setLabelsInformazioniRistorante(managerRistorante.getRistoranteGestito());
		}
	}

	private void setLabelsInformazioniRistorante(Ristorante ristorante) {
		infoRistorantePage.setNome(ristorante.getDenominazione());
		infoRistorantePage.setIndirizzo(ristorante.getIndirizzo());
		infoRistorantePage.setCitta(ristorante.getCitta());
		infoRistorantePage.setProvincia(ristorante.getProvincia());
		infoRistorantePage.setCap(ristorante.getCap());
		infoRistorantePage.setTelefono(ristorante.getTelefono());
		infoRistorantePage.setEmail(ristorante.getEmail());
		infoRistorantePage.setSitoWeb(ristorante.getSitoWeb());
	}
	
	public void riempiTabellaSaleRistoranteForProprietario() {
		JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
		String denominazioneRistorante = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
		String indirizzoRistorante = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
		
		try {
			int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(denominazioneRistorante, indirizzoRistorante);
			Ristorante ristoranteOfSale = ristoranteDAO.getRistoranteByDenominazioneAndIndirizzo(denominazioneRistorante, indirizzoRistorante);
			ArrayList<Sala> saleRistorante = salaDAO.getSaleByCodRistorante(codRistorante);
			DefaultTableModel modellotabella = gestioneSaleETavolatePage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[4];
					
			for(Sala sala : saleRistorante) {
				sala.setAppartenenzaRistorante(ristoranteOfSale);	
				rigaTabella[0] = sala.getDenominazione();
				rigaTabella[1] = sala.getCapienza();
				if(sala.getDimensioneInMq().equals(0)) {
					rigaTabella[2] = "-";
				} else {
					rigaTabella[2] = sala.getDimensioneInMq();
				}
					rigaTabella[3] = sala.getTipoSala();
					modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneSaleETavolatePage.setModel(modellotabella);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiTabellaSaleRistoranteForManager() {
		Ristorante ristoranteOfSale = managerRistorante.getRistoranteGestito();
		try {
			int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(ristoranteOfSale.getDenominazione(),ristoranteOfSale.getIndirizzo());
			ArrayList<Sala> saleRistorante = salaDAO.getSaleByCodRistorante(codRistorante);
			DefaultTableModel modellotabella = gestioneSaleETavolatePage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[4];
			for(Sala sala : saleRistorante) {
				sala.setAppartenenzaRistorante(ristoranteOfSale);	
				rigaTabella[0] = sala.getDenominazione();
				rigaTabella[1] = sala.getCapienza();
				if(sala.getDimensioneInMq().equals(0)) {
					rigaTabella[2] = "-";
				} else {
					rigaTabella[2] = sala.getDimensioneInMq(); 
				}
				rigaTabella[3] = sala.getTipoSala();
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneSaleETavolatePage.setModel(modellotabella);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
		
	
	

	/*-----------------------------------------------------------------------------------------------------------------------------*/
	/*STARTER*/
	
	//starter login
	public void startLoginFrame(){
		loginPage = new LoginFrame(this);
		loginPage.setVisible(true);
	}
		
	//starter proprietario
	public void startHomepageProprietarioFrame() {
		loginPage.dispose();
		proprietarioPage = new HomepageProprietarioFrame(this); 
		setHomepageProprietario(proprietario);
		proprietarioPage.setVisible(true);
	}
	
	public void mostraHomepageProprietarioFrame() { 
		proprietarioPage.setVisible(true); 
	}
	
	//starter ristoranti proprietario
	public void startRistorantiProprietarioFrame() {
		proprietarioPage.dispose();
		ristorantiProprietarioPage = new RistorantiProprietarioFrame(this);
		ristorantiProprietarioPage.setVisible(true);
		riempiTabellaRistorantiDiProprietario();
	}
	
	//starter pagina modifica ristorante
	public void startModificaRistoranteFrame() {
		ristorantiProprietarioPage.dispose();
		modificaRistorantePage = new ModificaRistoranteFrame(this);
		modificaRistorantePage.setVisible(true);
	}
	
	//starter pagina aggiungi risotrante
	public void startAggiungiRistoranteFrame() {
		ristorantiProprietarioPage.dispose();
		aggiungiRistorantePage = new AggiungiRistoranteFrame(this);
		aggiungiRistorantePage.setVisible(true);
	}
	
	//starter pagina gestione ristorante (per manager e ristorante)
	public void startHomepageGestioneRistoranteFrame(boolean isProprietario) {
		if(isProprietario) 
		{
			ristorantiProprietarioPage.dispose();
			gestioneRistorantePage = new HomepageGestioneRistoranteFrame(this, isProprietario);
			gestioneRistorantePage.setVisible(true);
		}
		else
		{
			loginPage.dispose();
			gestioneRistorantePage = new HomepageGestioneRistoranteFrame(this, isProprietario);
			gestioneRistorantePage.setVisible(true);
		}
	}
	
	public void mostraGestioneRistoranteFrame() { 
		gestioneRistorantePage.setVisible(true); 
	}
	
	//starter pagina informazioni ristorante
	public void startInfoRistoranteFrame(boolean isProprietario) {
		gestioneRistorantePage.dispose();
		infoRistorantePage = new InfoRistoranteFrame(this, isProprietario);
		infoRistorantePage.setVisible(true);
	}
	
	//starter pagina gestione sale
	public void startGestioneSaleETavolateFrame(boolean proprietario) {
		gestioneRistorantePage.dispose();
		gestioneSaleETavolatePage = new GestioneSaleETavolateFrame(this, proprietario);
		gestioneSaleETavolatePage.setVisible(true);
	}
	
	public void startAggiungiAvventori(boolean proprietario) {
		Aggiungi_Avventori aggiungiAvventoriPage = new Aggiungi_Avventori(this, proprietario);
		aggiungiAvventoriPage .setVisible(true);
	}
	
	public void startAggiungiCameriere(boolean proprietario) {
		Aggiungi_Cameriere aggiungiCamerierePage = new Aggiungi_Cameriere(null, proprietario);
		aggiungiCamerierePage.setVisible(true);
	}
	
	public void startAggiungiCaso(boolean proprietario) {
		Aggiungi_Caso aggiungiCasoPage = new Aggiungi_Caso(this, proprietario);
		aggiungiCasoPage.setVisible(true);
	}
	
	public void startAggiungiManager() {
		Aggiungi_Manager aggiungiManagerPage = new Aggiungi_Manager(this);
		aggiungiManagerPage.setVisible(true);
	}
	
	public void startAggiungiSala(boolean proprietario) {
		Aggiungi_Sala aggiungiSalaPage = new Aggiungi_Sala(this, proprietario);
		aggiungiSalaPage.setVisible(true);
	}
	
	public void startAggiungiTavolata(boolean proprietario) {
		Aggiungi_Tavolata aggiungiTavolataPage = new Aggiungi_Tavolata(this, proprietario);
		aggiungiTavolataPage.setVisible(true);
	}
	
	public void startAggiungiTavolo(boolean proprietario) {
		Aggiungi_Tavolo aggiungiTavoloPage = new Aggiungi_Tavolo(this, proprietario);
		aggiungiTavoloPage.setVisible(true);
	}
	
	public void startAvventori(boolean proprietario) {
		Avventori avventoriPage = new Avventori(this, proprietario);
		avventoriPage.setVisible(true);
	}
	
	public void startCamerieri(boolean proprietario) {
		Camerieri camerieriPage = new Camerieri(this, proprietario);
		camerieriPage.setVisible(true);
	}
	
	public void startCasi(boolean proprietario) {
		Casi casiPage = new Casi(this, proprietario);
		casiPage.setVisible(true);
	}
	
	public void startImpostazioni () {
		ImpostazioniProprietarioFrame impostazioniPage = new ImpostazioniProprietarioFrame(this);
		impostazioniPage.setVisible(true);
	}
	
	public void startManager() {
		Manager managerPage = new Manager(this);
		managerPage.setVisible(true);
	}
	
	public void startModificaAvventori(boolean proprietario) {
		Modifica_Avventori modificaAvventoriPage = new Modifica_Avventori(this, proprietario);
		modificaAvventoriPage.setVisible(true);
	}
	
	public void startModificaCameriere(boolean proprietario) {
		Modifica_Cameriere modificaCamerierePage = new Modifica_Cameriere(this, proprietario);
		modificaCamerierePage.setVisible(true);
	}
	
	public void startModificaCaso(boolean proprietario) {
		Modifica_Caso modificaCasoPage = new Modifica_Caso(this, proprietario);
		modificaCasoPage.setVisible(true);
	}
	
	public void startModificaManager() {
		Modifica_Manager modificaManagerPage = new Modifica_Manager(this);
		modificaManagerPage.setVisible(true);
	}
	
	public void startModificaSala(boolean proprietario) {
		Modifica_Sala modificaSalaPage = new Modifica_Sala(this, proprietario);
		modificaSalaPage.setVisible(true);
	}
	
	public void startModificaTavolata(boolean proprietario) {
		Modifica_Tavolata modificaTavolataPage = new Modifica_Tavolata(this, proprietario);
		modificaTavolataPage.setVisible(true);
	}
	
	public void startModificaTavolo(boolean proprietario) {
		Modifica_Tavolo modificaTavoloPage = new Modifica_Tavolo(this, proprietario);
		modificaTavoloPage.setVisible(true);
	}
	
	public void startStatistiche(boolean proprietario, boolean generale) {
		Statistiche statistichePage = new Statistiche(this, proprietario, generale);
		statistichePage.setVisible(true);
	}
	
	public void startTavolate(boolean proprietario) {
		Tavolate tavolatePage = new Tavolate(this, proprietario);
		tavolatePage.setVisible(true);
	}
	
	public void startTavoli(boolean proprietario) {
		Tavoli tavoliPage = new Tavoli(this, proprietario);
		tavoliPage.setVisible(true);
	}
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	//gestione delle message dialog utente 
	
	private void mostraEsitoCorrettoLogin(String tipoOperatore, Operatore operatore) {
		JLabel lblEsitoLogin = new JLabel("Login effettuato correttamente! Benvenuto, "+operatore.getUsername()+" - "+tipoOperatore);
		lblEsitoLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoLogin,"Login",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostraErroreLogin() {
		JLabel lblerroreLogin = new JLabel("ERRORE LOGIN: credenziali errate, utente inesistente o errore col DB.");
		lblerroreLogin.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblerroreLogin,"Errore Login",JOptionPane.ERROR_MESSAGE);
	}
	
	private void mostraEsitoCorrettoUpdate() {
		JLabel lblEsitoUpdate = new JLabel("Modifiche effettuate correttamente!");
		lblEsitoUpdate.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoUpdate,"Modifiche effettuate",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostraEsitoCorrettoInsert() {
		JLabel lblEsitoInserimento = new JLabel("Inserimento effettuato correttamente!");
		lblEsitoInserimento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoInserimento,"Inserimento effettuato",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostraEsitoCorrettoDelete() {
		JLabel lblEsitoInserimento = new JLabel("Eliminazione effettuata correttamente!");
		lblEsitoInserimento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoInserimento,"Eliminazione effettuata",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostraErrore(Exception e) {
		JLabel lblerroreDB = new JLabel("ERRORE GENERICO: "+e.getMessage());
		lblerroreDB.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblerroreDB,"Errore",JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostraErroreSelezioneDialog(JPanel pannello_Principale) {
		JLabel lblErrore = new JLabel("Attenzione: non hai selezionato una riga della tabella per cui effettuare l'operazione!");
		lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(pannello_Principale, lblErrore, "Attenzione", JOptionPane.WARNING_MESSAGE);
	}
	
/*------------------------------------------------------------------------------------------------------------------------*/
	
	//mostra data e ora
	public void mostraDataEOra(JLabel lblDataEOra) {
		Thread clock = new Thread() {
			public void run() {
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int giorno = cal.get(Calendar.DAY_OF_MONTH);
						int mese = cal.get(Calendar.MONTH)+1;
						int anno = cal.get(Calendar.YEAR);
						int seconds = cal.get(Calendar.SECOND);
						int minutes = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						String minuti = String.format("%02d", minutes);
						String secondi = String.format("%02d", seconds);
						String ore = String.format("%02d", hour);
						
						lblDataEOra.setText(giorno+"/"+mese+"/"+anno+" - "+ore+":"+minuti+":"+secondi);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
		};
		clock.start();
	}
	
/*------------------------------------------------------------------------------------------------------------------------*/	

}
