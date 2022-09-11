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
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

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
	private RistorantiProprietarioFrame ristorantiProprietarioPage;
	private ModificaRistoranteFrame modificaRistorantePage;
	private AggiungiRistoranteFrame aggiungiRistorantePage;
	private HomepageGestioneRistoranteFrame gestioneRistorantePage; 
	private InfoRistoranteFrame infoRistorantePage;
	private GestioneSaleETavolateFrame gestioneSaleETavolatePage;
	private AggiungiSalaFrame aggiungiSalaPage;
	private ModificaSalaFrame modificaSalaPage;
	private GestioneTavoliFrame gestioneTavoliPage;
	private AggiungiTavoloFrame aggiungiTavoloPage;
	private ModificaTavoloFrame modificaTavoloPage;
	private GestioneTavolateFrame gestioneTavolatePage;
	private AggiungiTavolataFrame aggiungiTavolataPage;
	private ModificaTavolataFrame modificaTavolataPage;
	
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
		tavoloDAO = new TavoloOracleImplementation();

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
				rigaTabella[2] = sala.getDimensioneInMq();
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
				rigaTabella[2] = sala.getDimensioneInMq(); 
				rigaTabella[3] = sala.getTipoSala();
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneSaleETavolatePage.setModel(modellotabella);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/* metodo inserisci sala */
	public void insertSala(String denominazione, int capienza, int dimensioneMq, String tipologia) {
		boolean esitoInsert;
		int codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();

		try {
			esitoInsert = salaDAO.insertSala(denominazione, capienza, dimensioneMq, tipologia, codRistorante);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaSaleRistoranteForProprietario(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaSalaPage() {
		JTable tabellaSale = gestioneSaleETavolatePage.getTabellaSaleRistorante();
		String currentDenominazione = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 0).toString();
		int currentCapienza =  (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 1);
		int currentDimensione = (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 2);
		String currentTipologia = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 3).toString();
		
		modificaSalaPage.getCampo_Denominazione().setText(currentDenominazione);
		modificaSalaPage.getCampo_CapienzaAvventori().setValue(currentCapienza);
		modificaSalaPage.getCampo_DimensioneMq().setValue(currentDimensione);
		modificaSalaPage.getCampo_TipologiaSala().setSelectedItem(currentTipologia);
		
	}
	
	/* metodo modifica sala */
	public void updateSala(String denominazione, int capienza, int dimensioneMq, String tipologia) {
		int codSala;
		boolean esitoUpdate;
		JTable tabellaSale = gestioneSaleETavolatePage.getTabellaSaleRistorante();
		String currentDenominazione = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 0).toString();
		int currentCapienza =  (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 1);
		
		try {
			codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(currentDenominazione, currentCapienza);
			esitoUpdate = salaDAO.updateSala(codSala, denominazione, capienza, dimensioneMq, tipologia);
			
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaSaleRistoranteForProprietario(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo elimina sala*/
	public void deleteSala(String denominazione, int capienza) {
		int codSala;
		boolean esitoDelete;
		
		try {
			codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(denominazione,capienza);
			esitoDelete = salaDAO.deleteSala(codSala);
			
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaSaleRistoranteForProprietario(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che riempie la tabella dei tavoli presenti nella sala*/
	public void riempiTabellaTavoliRistorante() {

		try {
			JTable tabellaSale = gestioneSaleETavolatePage.getTabellaSaleRistorante();
			String currentDenominazione = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 0).toString();
			int currentCapienza =  (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 1);
			int codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(currentDenominazione, currentCapienza);
			int numero = 1;
			
			ArrayList<Tavolo> tavoliRistorante = tavoloDAO.getTavoliByCodSala(codSala);
			DefaultTableModel modellotabella = gestioneTavoliPage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[3];
			for(Tavolo tavolo : tavoliRistorante) {
				tavolo.setContenimentoSala(salaDAO.getSalaByCodice(codSala));
				rigaTabella[0] = numero++;
				rigaTabella[1] = tavolo.getCodice();
				rigaTabella[2] = tavolo.getNumeroMassimoDiAvventori();
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneTavoliPage.setModel(modellotabella);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/* metodo inserisci tavolo */
	public void insertTavolo(int numeroAvventori) {
		boolean esitoInsert;
		JTable tabellaSale = gestioneSaleETavolatePage.getTabellaSaleRistorante();
		String currentDenominazione = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 0).toString();
		int currentCapienza =  (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 1);
		int codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(currentDenominazione, currentCapienza);

		try {
			esitoInsert = tavoloDAO.insertTavolo(numeroAvventori, codSala);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaTavoliRistorante(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaTavoloPage() {
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		int numeroAvventori = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 2);
		
		modificaTavoloPage.getEtichetta_Codice().setText("Codice Tavolo: "+codTavolo);
		modificaTavoloPage.getCampo_NumeroAvventori().setValue(numeroAvventori);
	}
	
	/* metodo modifica tavolo */
	public void updateTavolo(int numeroAvventori) {
		boolean esitoUpdate;
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);

		try {
			esitoUpdate = tavoloDAO.updateTavolo(codTavolo,numeroAvventori);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaTavoliRistorante(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}

	/*metodo elimina tavolo*/
	public void deleteTavolo(int codTavolo) {
		boolean esitoDelete;
		try {
			esitoDelete = tavoloDAO.deleteTavolo(codTavolo);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaTavoliRistorante(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che riempie la tabella delle tavolate*/
	public void riempiTabellaTavolateRistorante() {

		try {
			JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
			SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/YYYY");
			int numero = 1;
			int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
			ArrayList<Tavolata> tavolate = tavolataDAO.getTavolateByCodTavolo(codTavolo);
			Cameriere c;
			
			DefaultTableModel modellotabella = gestioneTavolatePage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[6];
			
			for(Tavolata tavolata : tavolate) {
				c = cameriereDAO.getCameriereByCodTavoloAndDataTavolata(codTavolo, tavolata.getDataArrivo());
				tavolata.setServizioCameriere(c);
				rigaTabella[0] = numero++;
				rigaTabella[1] = codTavolo;
				rigaTabella[2] = formatoData.format(tavolata.getDataArrivo());
				rigaTabella[3] = tavolata.getOraArrivo();
				rigaTabella[4] = tavolata.getOraUscita();
				rigaTabella[5] = tavolata.getServizioCameriere().getNome()+" "+tavolata.getServizioCameriere().getCognome();
				
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneTavolatePage.setModel(modellotabella);
			
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che riempie i campi della pagina aggiungi tavolata*/
	public void riempiCampiAggiungiTavolataPage(boolean proprietario) {
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		int numAvventori = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 2);
		aggiungiTavolataPage.getEtichetta_CodTavolo().setText("Codice Tavolo: "+codTavolo+" | "+"Num. max di avventori: "+numAvventori);
		
		String currentDate = LocalDateTime.now().toString();
		java.util.Date data = null;
		try {
			data = new SimpleDateFormat("yyyy-MM-dd").parse(currentDate);
		} catch (Exception e) {
			e.printStackTrace();
		}
		aggiungiTavolataPage.getCampo_DataArrivo().setDate(data);
		
		if(proprietario) {
			int codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
			ArrayList<Cameriere> camerieri = cameriereDAO.getCamerieriRistorante(codRistorante);
			for(Cameriere c : camerieri) {
				aggiungiTavolataPage.getCampo_Cameriere().addItem(c.getNome()+" "+c.getCognome());
			}
		} else {
			int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
					managerRistorante.getRistoranteGestito().getDenominazione(),
					managerRistorante.getRistoranteGestito().getIndirizzo());
			
			ArrayList<Cameriere> camerieri = cameriereDAO.getCamerieriRistorante(codRistorante);
			for(Cameriere c : camerieri) {
				aggiungiTavolataPage.getCampo_Cameriere().addItem(c.getNome()+" "+c.getCognome());
			}
		}
	}
	
	/* metodo inserisci tavolata */
	public void insertTavolata(boolean isProprietario, String dataArrivo, String cameriere) {
		boolean esitoInsert;
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		String nomeCameriere = cameriere.substring(0, cameriere.indexOf(' '));
		String cognomeCameriere = cameriere.substring(cameriere.indexOf(' ')+1);
		int codRistorante;
		
		try {
			if(isProprietario) {
				codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
			}
			
			String cameriereTavolata = cameriereDAO.getNumcidCameriereByNomeAndCognomeAndRistorante(nomeCameriere,cognomeCameriere,codRistorante);
			
			esitoInsert = tavolataDAO.insertTavolata(dataArrivo, codTavolo, cameriereTavolata);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaTavolateRistorante(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo che riempie i campi modifica tavolata page*/
	public void riempiCampiModificaTavolataPage(boolean proprietario) {
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		int numAvventori = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 2);
		String cameriere = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 5);
		
		modificaTavolataPage.getEtichetta_CodTavolo().setText("Codice Tavolo: "+codTavolo+" | "+"Num. max di avventori: "+numAvventori);
		try {
			String dataArrivoString = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dataArrivo = dateFormat.parse(dataArrivoString);
			modificaTavolataPage.getCampo_DataArrivo().setDate(dataArrivo);
			
			if(proprietario) {
				int codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
				ArrayList<Cameriere> camerieri = cameriereDAO.getCamerieriRistorante(codRistorante);
				for(Cameriere c : camerieri) {
					modificaTavolataPage.getCampo_Cameriere().addItem(c.getNome()+" "+c.getCognome());
				}
			} else {
				int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
				
				ArrayList<Cameriere> camerieri = cameriereDAO.getCamerieriRistorante(codRistorante);
				for(Cameriere c : camerieri) {
					modificaTavolataPage.getCampo_Cameriere().addItem(c.getNome()+" "+c.getCognome());
				}
			}
		} catch (Exception e) {
			mostraErrore(e);
		}	
	}
	
	/* metodo modifica tavolata */
	public void updateTavolata(boolean isProprietario,String dataArrivo, String cameriere) {
		boolean esitoUpdate;
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codRistorante;
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String currentDataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
		String nomeCameriere = cameriere.substring(0, cameriere.indexOf(' '));
		String cognomeCameriere = cameriere.substring(cameriere.indexOf(' ')+1);
		
		try {
			if(isProprietario) {
				codRistorante = getCodRistoranteForProprietarioByTabellaRistoranti();
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
			}
			
			String cameriereTavolata = cameriereDAO.getNumcidCameriereByNomeAndCognomeAndRistorante(nomeCameriere,cognomeCameriere,codRistorante);
			int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(currentDataArrivo, codTavolo);
			esitoUpdate = tavolataDAO.updateTavolata(codTavolata, dataArrivo, cameriereTavolata);
			
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaTavolateRistorante(); //aggiorna la tabella 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	/*metodo elimina tavolata*/
	public void deleteTavolata() {
		boolean esitoDelete;
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String dataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
		
		try {
			int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(dataArrivo, codTavolo);
			esitoDelete = tavolataDAO.deleteTavolata(codTavolata);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaTavolateRistorante(); //aggiorna la tabella 
			}
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
	public void startGestioneSaleETavolateFrame(boolean isProprietario) {
		gestioneRistorantePage.dispose();
		gestioneSaleETavolatePage = new GestioneSaleETavolateFrame(this, isProprietario);
		gestioneSaleETavolatePage.setVisible(true);
	}
	
	public void mostraGestioneSaleETavolateFrame() { 
		gestioneSaleETavolatePage.setVisible(true); 
	}
	
	//starter pagina aggiungi sala 
	public void startAggiungiSalaFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		aggiungiSalaPage = new AggiungiSalaFrame(this,isProprietario);
		aggiungiSalaPage.setVisible(true);
	}
	
	//starter pagina modifica sala 
	public void startModificaSalaFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		modificaSalaPage = new ModificaSalaFrame(this, isProprietario);
		modificaSalaPage.setVisible(true);
	}
	
	//starter pagina gestione tavoli
	public void startGestioneTavoliFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		gestioneTavoliPage = new GestioneTavoliFrame(this, isProprietario);
		gestioneTavoliPage.setVisible(true);
	}
	
	public void mostraGestioneTavoliFrame() { 
		gestioneTavoliPage.setVisible(true); 
	}
	
	//starter pagina aggiungi tavolo
	public void startAggiungiTavoloFrame(boolean isProprietario) {
		gestioneTavoliPage.dispose();
		aggiungiTavoloPage = new AggiungiTavoloFrame(this, isProprietario);
		aggiungiTavoloPage.setVisible(true);
	}
	
	//starter pagina modifica tavolo
	public void startModificaTavoloFrame(boolean isProprietario) {
		modificaTavoloPage = new ModificaTavoloFrame(this, isProprietario);
		modificaTavoloPage.setVisible(true);
	}
	
	//starter pagina gestione tavolate
	public void startGestioneTavolateFrame(boolean isProprietario) {
		gestioneTavolatePage = new GestioneTavolateFrame(this, isProprietario);
		gestioneTavolatePage.setVisible(true);
	}
	
	public void mostraGestioneTavolateFrame() { 
		gestioneTavolatePage.setVisible(true); 
	}
	
	//starter pagina aggiungi tavolata
	public void startAggiungiTavolataFrame(boolean isProprietario) {
		aggiungiTavolataPage = new AggiungiTavolataFrame(this, isProprietario);
		aggiungiTavolataPage.setVisible(true);
	}
	
	//starter pagina modifica tavolata
	public void startModificaTavolataFrame(boolean isProprietario) {
		modificaTavolataPage = new ModificaTavolataFrame(this, isProprietario);
		modificaTavolataPage.setVisible(true);
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
	
	
	

	
	public void startStatistiche(boolean proprietario, boolean generale) {
		Statistiche statistichePage = new Statistiche(this, proprietario, generale);
		statistichePage.setVisible(true);
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
