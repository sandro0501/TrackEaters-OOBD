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
import gui.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import java.awt.*;
import java.util.*;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

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
	private ImpostazioniProprietarioFrame impostazioniPage;
	private RistorantiProprietarioFrame ristorantiProprietarioPage;
	private AggiungiRistoranteFrame aggiungiRistorantePage;
	private ModificaRistoranteFrame modificaRistorantePage;
	private AggiungiCameriereFrame aggiungiCamerierePage;
	private ModificaCameriereFrame modificaCamerierePage;
	private AggiungiManagerFrame aggiungiManagerPage;
	private ModificaManagerFrame modificaManagerPage;
	private InfoRistoranteFrame infoRistorantePage;
	private HomepageGestioneRistoranteFrame gestioneRistorantePage; 
	private GestioneSaleETavolateFrame gestioneSaleETavolatePage;
	private GestionePersonaleFrame gestionePersonalePage;
	private AggiungiSalaFrame aggiungiSalaPage;
	private ModificaSalaFrame modificaSalaPage;
	private GestioneTavoliFrame gestioneTavoliPage;
	private AggiungiTavoloFrame aggiungiTavoloPage;
	private ModificaTavoloFrame modificaTavoloPage;
	private GestioneTavolateFrame gestioneTavolatePage;
	private AggiungiTavolataFrame aggiungiTavolataPage;
	private ModificaTavolataFrame modificaTavolataPage;
	private GestioneAvventoriFrame gestioneAvventoriPage;
	private AggiungiAvventoreFrame aggiungiAvventorePage;
	private ModificaAvventoreFrame modificaAvventorePage;
	private StatisticheProprietarioFrame statisticheProprietarioPage;
	private StatisticheRistoranteFrame statisticheRistorantePage;
	private GestioneCasiCovidFrame gestioneCasiCovidPage;
	private AggiungiCasoCovidFrame aggiungiCasoCovidPage;
	private ModificaCasoCovidFrame modificaCasoCovidPage;
	private TracciamentoAvventoreFrame tracciamentoAvventorePage;
	
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
	//business methods 
	
	public void loginOperatore(String username, String password, String tipoOperatore) {
		try {
			operatore = operatoreDAO.getOperatore(username, password, tipoOperatore);
			if(tipoOperatore.equals("Proprietario")) 
			{
				//loggato proprietario
				proprietario = new Proprietario(operatore.getUsername(),operatore.getPassword(),operatore.getNome(),
						operatore.getCognome(),operatore.getEmail());
				
				mostraEsitoCorrettoLogin(tipoOperatore, proprietario);
				startHomepageProprietarioFrame();	
			}
			else
			{
				//loggato come manager ristorante
				managerRistorante = new ManagerRistorante(operatore.getUsername(),operatore.getPassword(),operatore.getNome(),
						operatore.getCognome(),operatore.getEmail());
				
				managerRistorante.setTelefono(managerRistoranteDAO.getTelefonoManagerByUsername(managerRistorante.getUsername()));
				Ristorante r = ristoranteDAO.getRistoranteFromUsernameManager(managerRistorante.getUsername());
				managerRistorante.setRistoranteGestito(r);
				mostraEsitoCorrettoLogin(tipoOperatore, operatore);
				
				startHomepageGestioneRistoranteFrame(false);
				setHomepageGestioneRistorante(false);		
			}
		} catch (Exception e) {
			mostraErroreLogin();
		}
	}
	
	public void setHomepageProprietario(Proprietario p) {
		proprietarioPage.setLblNomeCognome(p.getNome(), p.getCognome());
		proprietarioPage.setLblUsername(p.getUsername());
		proprietarioPage.setLblEmail(p.getEmail());
	}
	
	public void setHomepageGestioneRistorante(boolean isProprietario) {
		ManagerRistorante manager = null;
	
		if(isProprietario)
		{
			JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
			String denominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
			int codRistorante = getCodiceRistoranteForProprietario();
			manager = managerRistoranteDAO.getInformazioniManagerByCodRistorante(codRistorante);
			
			gestioneRistorantePage.setLblDenominazioneRistorante("Ristorante "+"\""+denominazione+"\"");
			if(manager != null) 
			{
				gestioneRistorantePage.getLblUsernameManager().setText(manager.getUsername()+" - "+manager.getNome()+" "+manager.getCognome());
				gestioneRistorantePage.getLblEmailManager().setText(manager.getEmail());
				gestioneRistorantePage.getLblTelefonoManager().setText(managerRistoranteDAO.getTelefonoManagerByUsername(manager.getUsername()));
			}
			else //ristorante non ha manager associati
			{
				gestioneRistorantePage.getLblInfoManager().setVisible(false);
				gestioneRistorantePage.getLblUsernameManager().setVisible(false);
				gestioneRistorantePage.getLblEmailManager().setVisible(false);
				gestioneRistorantePage.getLblTelefonoManager().setVisible(false);
			}
		}
		else //set labels manager
		{
			gestioneRistorantePage.setLblDenominazioneRistorante("Ristorante "+"\""+
					managerRistorante.getRistoranteGestito().getDenominazione()+"\"");
			
			gestioneRistorantePage.getLblUsernameManager().setText(managerRistorante.getUsername()+" - "+
			managerRistorante.getNome()+" "+managerRistorante.getCognome());
			
			gestioneRistorantePage.getLblEmailManager().setText(managerRistorante.getEmail());
			gestioneRistorantePage.getLblTelefonoManager().setText(managerRistorante.getTelefono());
		}
	}

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
	
	public void modificaProprietario(String nome, String cognome, String newUsername, String email, String password) {
		boolean esitoUpdate;
		try {
			esitoUpdate = proprietarioDAO.updateProprietario(proprietario.getUsername(), nome, cognome, newUsername, email, password);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();

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
	
	public int getCodiceRistoranteForProprietario() {
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
	
	public void aggiungiRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap, 
			String email, String sitoweb) {
		boolean esitoInsert;
		int codProprietario = proprietarioDAO.getCodiceProprietarioFromUsername(proprietario.getUsername());
		try {
			esitoInsert = ristoranteDAO.insertRistorante(denominazione, indirizzo, telefono, citta, prov, cap, email, sitoweb, codProprietario);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaRistorantiDiProprietario(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
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
	
	public void modificaRistorante(String denominazione, String indirizzo, String telefono, String citta, String prov, String cap,
			String email, String sitoweb) {
		int codRistorante;
		boolean esitoUpdate;
		try {
			codRistorante = getCodiceRistoranteForProprietario();
			esitoUpdate = ristoranteDAO.updateRistorante(codRistorante, denominazione, indirizzo, telefono, citta, prov, cap, email, sitoweb);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaRistorantiDiProprietario();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}

	public void eliminaRistorante(String denominazioneRistorante, String indirizzoRistorante) {
		int codRistorante;
		boolean esitoDelete;
		try {
			codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(denominazioneRistorante, indirizzoRistorante);
			esitoDelete = ristoranteDAO.deleteRistorante(codRistorante);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaRistorantiDiProprietario(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public ArrayList<String> riempiComboBoxRistoranti(){
		ArrayList<String> listaRistorantiString = new ArrayList<>();
		try {
			ArrayList<Ristorante> listaRistoranti =  ristoranteDAO.getRistorantiByUsernameProprietario(proprietario.getUsername());
			for (Ristorante ristorante : listaRistoranti) {
				listaRistorantiString.add(ristorante.getDenominazione() +" - " + ristorante.getIndirizzo()); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
		return listaRistorantiString;
	}
	
	public void riempiTabellaCamerieriPerRistorante(boolean proprietario) {
		try {
			ArrayList<Cameriere> listaCamerieri;
			Ristorante ristorante;
			
			if (proprietario) {
				JTable tabellaRistoranti = ristorantiProprietarioPage.getTabellaRistoranti();
				String currentDenominazione = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString();
				String currentIndirizzo = tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString();
				listaCamerieri = cameriereDAO.getCamerieriRistorante(getCodiceRistoranteForProprietario());
				ristorante = ristoranteDAO.getRistoranteByDenominazioneAndIndirizzo(currentDenominazione, currentIndirizzo);
			} else {
				String currentDenominazione = managerRistorante.getRistoranteGestito().getDenominazione();
				String currentIndirizzo = managerRistorante.getRistoranteGestito().getIndirizzo();
				listaCamerieri = cameriereDAO.getCamerieriRistorante(
						ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(currentDenominazione, currentIndirizzo));
				ristorante = ristoranteDAO.getRistoranteFromUsernameManager(managerRistorante.getUsername());
			}
			ristorante.setCamerieriRistorante(listaCamerieri);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel model = infoRistorantePage.getModel();
			model.getDataVector().removeAllElements();
			String[] rigaTabella = new String[11];
			
			for (Cameriere cameriere : ristorante.getCamerieriRistorante()) {
				cameriere.setLavoratoreRistorante(ristorante);
				rigaTabella [0] = cameriere.getNumeroCid();
				rigaTabella [1] = cameriere.getNome();
				rigaTabella [2] = cameriere.getCognome();
				rigaTabella [3] = dateFormat.format(cameriere.getDataDiNascita());
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
	
	public void riempiTabellaCamerieriPerGestionePersonale() {
		try {
			ArrayList<Cameriere> listaCamerieri = cameriereDAO.getAllCamerieri();
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel modelloTabellaCamerieri = gestionePersonalePage.getModelCamerieri();
			modelloTabellaCamerieri.getDataVector().removeAllElements();
			Object[] colonnaTabella = new Object[12];
			
			for(Cameriere cameriere : listaCamerieri) {
				Ristorante ristorante = cameriere.getLavoratoreRistorante();
				colonnaTabella[0] = cameriere.getNumeroCid();
				colonnaTabella[1] = cameriere.getNome();
				colonnaTabella[2] = cameriere.getCognome();
				colonnaTabella[3] = dateFormat.format(cameriere.getDataDiNascita());
				colonnaTabella[4] = cameriere.getSesso();
				colonnaTabella[5] = cameriere.getCittaDiNascita();
				colonnaTabella[6] = cameriere.getProvinciaDiNascita();
				colonnaTabella[7] = cameriere.getCittaDiResidenza();
				colonnaTabella[8] = cameriere.getProvinciaDiResidenza();
				colonnaTabella[9] = cameriere.getTelefono();
				colonnaTabella[10] = cameriere.getEmail();
				colonnaTabella[11] = ristorante.getDenominazione() + " - " + ristorante.getIndirizzo();
				modelloTabellaCamerieri.addRow(colonnaTabella);
			}
			modelloTabellaCamerieri.fireTableDataChanged();
			gestionePersonalePage.setModelCamerieri(modelloTabellaCamerieri);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void aggiungiCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, String ristorante) {
		
		String[] splitted = ristorante.split(" - ");
		int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]); 
		boolean esitoInsert;

		try {
			esitoInsert = cameriereDAO.insertCameriere(numeroCid, nome, cognome, dataNascita, sesso, cittaDiNascita, provinciaDiNascita, 
					cittaDiResidenza, provinciaDiResidenza, telefono, email, codRistorante);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaCamerierePage() {
		JTable tabellaCameriere = gestionePersonalePage.getTabellaCamerieri();
		String currentDocumento = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 0).toString();
		String currentNome = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 1).toString();
		String currentCognome = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 2).toString();
		String currentDataNascita = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 3).toString();
		String currentSesso = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 4).toString();
		String currentCittaN = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 5).toString();
		String currentProvinciaN = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 6).toString();
		String currentCittaRes = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 7).toString();
		String currentProvinciaRes = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 8).toString();
		String currentTelefono = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 9).toString();
		if(tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 10) != null) {
			String currentEmail = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 10).toString();
			modificaCamerierePage.getCampo_Email().setText(currentEmail);
		}
		String currentRistorante = tabellaCameriere.getModel().getValueAt(tabellaCameriere.getSelectedRow(), 11).toString();
		
		modificaCamerierePage.getCampo_NumeroDocumento().setText(currentDocumento);
		modificaCamerierePage.getCampo_Nome().setText(currentNome);
		modificaCamerierePage.getCampo_Cognome().setText(currentCognome);
		modificaCamerierePage.getCampo_DataNascita().setText(currentDataNascita);
		modificaCamerierePage.getComboBox_Sesso().setSelectedItem(currentSesso);
		modificaCamerierePage.getCampo_CittaNatale().setText(currentCittaN);
		modificaCamerierePage.getComboBox_ProvinciaNatale().setSelectedItem(currentProvinciaN);
		modificaCamerierePage.getCampo_CittaResidenza().setText(currentCittaRes);
		modificaCamerierePage.getComboBox_ProvinciaResidenza().setSelectedItem(currentProvinciaRes);
		modificaCamerierePage.getCampo_Telefono().setText(currentTelefono);
		modificaCamerierePage.getComboBox_Ristorante().setSelectedItem(currentRistorante);
	}
	
	public void modificaCameriere(String numeroCid, String nome, String cognome, String dataNascita, String sesso,
			String cittaDiNascita, String provinciaDiNascita, String cittaDiResidenza, String provinciaDiResidenza,
			String telefono, String email, String ristorante) {
		
		String[] splitted = ristorante.split(" - ");
		int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);
		boolean esitoUpdate;
		
		try {
			esitoUpdate = cameriereDAO.updateCameriere(numeroCid, nome, cognome, dataNascita, sesso, cittaDiNascita, provinciaDiNascita, 
					cittaDiResidenza, provinciaDiResidenza, telefono, email, codRistorante);
			if (esitoUpdate) {
				mostraEsitoCorrettoUpdate();
			} 
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaCameriere(String numeroCid) {
		boolean esitoDelete;
		try {
			esitoDelete= cameriereDAO.deleteCameriere(numeroCid);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiTabellaManagerRistorantePerGestionePersonale() {
		try {
			ArrayList<ManagerRistorante> listaManager = managerRistoranteDAO.getAllManager();
			DefaultTableModel modelloTabellaManager = gestionePersonalePage.getModelManager();
			modelloTabellaManager.getDataVector().removeAllElements();
			Object[] colonnaTabella = new Object[6];
		
			for(ManagerRistorante manager : listaManager) {
				Ristorante ristorante = manager.getRistoranteGestito();
				colonnaTabella[0] = manager.getUsername();
				colonnaTabella[1] = manager.getNome();
				colonnaTabella[2] = manager.getCognome();
				colonnaTabella[3] = manager.getEmail();
				colonnaTabella[4] = manager.getTelefono();
				colonnaTabella[5] = ristorante.getDenominazione() + " - " + ristorante.getIndirizzo();
				modelloTabellaManager.addRow(colonnaTabella);
			}
			modelloTabellaManager.fireTableDataChanged();
			gestionePersonalePage.setModelManager(modelloTabellaManager);
		}catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void aggiungiManager(String username, String password, String nome, String cognome, 
			String telefono, String email, String ristorante) {
		boolean esitoInsert;
		String[] splitted = ristorante.split(" - ");
		int ristoranteGestito = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);

		try {
			esitoInsert = managerRistoranteDAO.insertManager(username, password, nome, cognome, telefono, email, ristoranteGestito);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaManagerRistorantePerGestionePersonale();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaManagerPage() {
		JTable tabellaManager = gestionePersonalePage.getTabellaManager();
		String currentUsername = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 0).toString();
		String currentNome = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 1).toString();
		String currentCognome = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 2).toString();
		String currentEmail;
		if(tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 3) != null) {
			currentEmail = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 3).toString();
			modificaManagerPage.getCampo_Email().setText(currentEmail);
		}
		String currentTelefono = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 4).toString();
		String currentRistoranteGestito = tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 5).toString();
		
		modificaManagerPage.getCampo_Username().setText(currentUsername);
		modificaManagerPage.getCampo_Nome().setText(currentNome);
		modificaManagerPage.getCampo_Cognome().setText(currentCognome);
		modificaManagerPage.getCampo_Telefono().setText(currentTelefono);
		modificaManagerPage.getComboBox_Ristorante().setSelectedItem(currentRistoranteGestito);
	}
	
	public void modificaManager(String username, String password, String nome, String cognome, 
			String telefono, String email, String ristorante) {
		boolean esitoInsert;
		String[] splitted = ristorante.split(" - ");
		int ristoranteGestito = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);

		try {
			esitoInsert = managerRistoranteDAO.updateManager(username, password, nome, cognome, telefono, email, ristoranteGestito);
			if(esitoInsert) {
				mostraEsitoCorrettoUpdate();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaManager(String username) {
		boolean esitoDelete;
		try {
			esitoDelete = managerRistoranteDAO.deleteManager(username);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}	
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
			int codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo
					(ristoranteOfSale.getDenominazione(),ristoranteOfSale.getIndirizzo());
			
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
	
	public void aggiungiSala(String denominazione, int capienza, int dimensioneMq, String tipologia) {
		boolean esitoInsert;
		int codRistorante = getCodiceRistoranteForProprietario();
		try {
			esitoInsert = salaDAO.insertSala(denominazione, capienza, dimensioneMq, tipologia, codRistorante);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaSaleRistoranteForProprietario(); 
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
	
	public void modificaSala(String denominazione, int capienza, int dimensioneMq, String tipologia) {
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
				riempiTabellaSaleRistoranteForProprietario();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaSala(String denominazione, int capienza) {
		int codSala;
		boolean esitoDelete;
		
		try {
			codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(denominazione,capienza);
			esitoDelete = salaDAO.deleteSala(codSala);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaSaleRistoranteForProprietario();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
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
	
	public void aggiungiTavolo(int numeroAvventori) {
		boolean esitoInsert;
		JTable tabellaSale = gestioneSaleETavolatePage.getTabellaSaleRistorante();
		String currentDenominazione = tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 0).toString();
		int currentCapienza =  (int) tabellaSale.getModel().getValueAt(tabellaSale.getSelectedRow(), 1);
		int codSala = salaDAO.getCodiceSalaByDenominazioneAndCapienza(currentDenominazione, currentCapienza);

		try {
			esitoInsert = tavoloDAO.insertTavolo(numeroAvventori, codSala);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaTavoliRistorante(); 
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
	
	public void modificaTavolo(int numeroAvventori) {
		boolean esitoUpdate;
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);

		try {
			esitoUpdate = tavoloDAO.updateTavolo(codTavolo,numeroAvventori);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaTavoliRistorante(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}

	public void eliminaTavolo(int codTavolo) {
		boolean esitoDelete;
		
		try {
			esitoDelete = tavoloDAO.deleteTavolo(codTavolo);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaTavoliRistorante();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
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
			int codRistorante = getCodiceRistoranteForProprietario();
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
	
	public void aggiungiTavolata(boolean isProprietario, String dataArrivo, String cameriere) {
		boolean esitoInsert;
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		String nomeCameriere = cameriere.substring(0, cameriere.indexOf(' '));
		String cognomeCameriere = cameriere.substring(cameriere.indexOf(' ')+1);
		int codRistorante;
		
		try {
			if(isProprietario) {
				codRistorante = getCodiceRistoranteForProprietario();
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
			}
			String cameriereTavolata = cameriereDAO.getNumcidCameriereByNomeAndCognomeAndRistorante(nomeCameriere,cognomeCameriere,codRistorante);
			
			esitoInsert = tavolataDAO.insertTavolata(dataArrivo, codTavolo, cameriereTavolata);
			if(esitoInsert) {
				mostraEsitoCorrettoInsert();
				riempiTabellaTavolateRistorante(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaTavolataPage(boolean proprietario) {
		JTable tabellaTavoli = gestioneTavoliPage.getTabellaTavoliRistorante();
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 1);
		int numAvventori = (int) tabellaTavoli.getModel().getValueAt(tabellaTavoli.getSelectedRow(), 2);
		
		modificaTavolataPage.getEtichetta_CodTavolo().setText("Codice Tavolo: "+codTavolo+" | "+"Num. max di avventori: "+numAvventori);
		try {
			String dataArrivoString = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date dataArrivo = dateFormat.parse(dataArrivoString);
			modificaTavolataPage.getCampo_DataArrivo().setDate(dataArrivo);
			
			if(proprietario) {
				int codRistorante = getCodiceRistoranteForProprietario();
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
	
	public void modificaTavolata(boolean isProprietario,String dataArrivo, String cameriere) {
		boolean esitoUpdate;
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codRistorante;
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String currentDataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
		String nomeCameriere = cameriere.substring(0, cameriere.indexOf(' '));
		String cognomeCameriere = cameriere.substring(cameriere.indexOf(' ')+1);
		
		try {
			if(isProprietario) {
				codRistorante = getCodiceRistoranteForProprietario();
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
				riempiTabellaTavolateRistorante();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}

	public void eliminaTavolata() {
		boolean esitoDelete;
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String dataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
		
		try {
			int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(dataArrivo, codTavolo);
			esitoDelete = tavolataDAO.deleteTavolata(codTavolata);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaTavolateRistorante();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}	

	public void riempiTabellaAvventoriRistorante() {
		try {
			JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
			int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
			String dataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
			int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(dataArrivo, codTavolo);
			ArrayList<Avventore> avventori = avventoreDAO.getAvventoriByCodTavolata(codTavolata);
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel modellotabella = gestioneAvventoriPage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[13];
			
			for(Avventore avventore : avventori) {
				rigaTabella[0] = avventore.getNumeroCid();
				rigaTabella[1] = avventore.getNome();
				rigaTabella[2] = avventore.getCognome();
				rigaTabella[3] = dateFormat.format(avventore.getDataDiNascita());
				rigaTabella[4] = avventore.getSesso();
				rigaTabella[5] = avventore.getCittaDiNascita();
				rigaTabella[6] = avventore.getProvinciaDiNascita();
				rigaTabella[7] = avventore.getCittaDiResidenza();
				rigaTabella[8] = avventore.getProvinciaDiResidenza();
				rigaTabella[9] = avventore.getTelefono();
				rigaTabella[10] = avventore.getEmail();
				rigaTabella[11] = avventore.getTemperaturaCorporea();
				rigaTabella[12] = avventore.getGreenpass();
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneAvventoriPage.setModel(modellotabella);
			
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void aggiungiAvventore(boolean isProprietario, String numCid, String nome, String cognome,
			String dataNascita,String sesso,String cittaNascita,String provNascita, 
			String cittaResidenza,String provResidenza,String telefono,String email,double temperatura,char greenpass) {
		
		boolean esitoInsertAvventore;
		boolean esitoInsertAvventoreTavolata;
		boolean esitoInsertAvventoreRistorante;
		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String dataArrivo = tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2).toString();
		int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(dataArrivo, codTavolo);
		int codRistorante = 0;
		
		try {
			if(isProprietario) {
				codRistorante = getCodiceRistoranteForProprietario();
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
			}
			
			if(avventoreDAO.getEsistenzaAvventoreByNumcid(numCid) == true) {
				esitoInsertAvventoreTavolata = avventoreDAO.insertAvventoreATavolata(numCid, codTavolata);
				esitoInsertAvventoreRistorante = avventoreDAO.insertAvventoreARistorante(codRistorante, numCid);
				
				if(esitoInsertAvventoreTavolata && esitoInsertAvventoreRistorante) {
					mostraEsitoCorrettoInsertAvventoreEsistente();
					riempiTabellaAvventoriRistorante(); 
				}
			}
			else
			{
				esitoInsertAvventore = avventoreDAO.insertAvventore(numCid, nome, cognome, dataNascita, sesso, cittaNascita, provNascita, 
						cittaResidenza, provResidenza, telefono, email, temperatura, greenpass);
				if(esitoInsertAvventore) {
					esitoInsertAvventoreTavolata = avventoreDAO.insertAvventoreATavolata(numCid, codTavolata);
					esitoInsertAvventoreRistorante = avventoreDAO.insertAvventoreARistorante(codRistorante, numCid);
					
					if(esitoInsertAvventoreRistorante && esitoInsertAvventoreTavolata) {
						mostraEsitoCorrettoInsert();
						riempiTabellaAvventoriRistorante();  
					} else {
						avventoreDAO.deleteAvventore(numCid);
					}
				}
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaAvventorePage() {
		JTable tabellaAvventori = gestioneAvventoriPage.getTabellaAvventoriRistorante();
		String numcid = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 0).toString();
		String nome = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 1).toString();
		String cognome = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 2).toString();
		String data = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 3).toString();
		String sesso = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 4).toString();
		String cittanascita = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 5).toString();
		String provnascita = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 6).toString();
		String cittaresidenza = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 7).toString();
		String provresidenza = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 8).toString();
		String telefono = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 9).toString();
		String email = "";
		
		if(!(tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 10) == null)) {
			email = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 10).toString();
		}
		double temperatura = (double) tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 11);
		char greenpass = tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 12).toString().charAt(0);
	
		modificaAvventorePage.getCampo_NumCid().setText(numcid);
		modificaAvventorePage.getCampo_Nome().setText(nome);
		modificaAvventorePage.getCampo_Cognome().setText(cognome);
		try {
			java.util.Date datanascita = new SimpleDateFormat("dd/MM/yyyy").parse(data);
			modificaAvventorePage.getCampo_DataNascita().setDate(datanascita);
		} catch (Exception e) {
			e.printStackTrace();
		}
		modificaAvventorePage.getCampo_Sesso().setSelectedItem(sesso);
		modificaAvventorePage.getCampo_CittaNascita().setText(cittanascita);
		modificaAvventorePage.getCampo_ProvNascita().setSelectedItem(provnascita);
		modificaAvventorePage.getCampo_CittaResidenza().setText(cittaresidenza);
		modificaAvventorePage.getCampo_ProvResidenza().setSelectedItem(provresidenza);
		modificaAvventorePage.getCampo_Telefono().setText(telefono);
		modificaAvventorePage.getCampo_Email().setText(email);
		modificaAvventorePage.getCampo_Temperatura().setValue(temperatura);
		modificaAvventorePage.getCampo_Greenpass().setSelectedItem(greenpass);	
	}
	
	public void aggiornaAvventore(String numCid,String nome,String cognome,String dataNascita,String sesso,
			String cittaNascita,String provNascita, String cittaResidenza,String provResidenza,
			String telefono,String email,double temperatura,char greenpass) {
	
		boolean esitoUpdate;
		try {
			esitoUpdate = avventoreDAO.updateAvventore(numCid, nome, cognome, dataNascita, sesso, cittaNascita, provNascita, 
					cittaResidenza, provResidenza, telefono, email, temperatura, greenpass);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
				riempiTabellaAvventoriRistorante(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaAvventore() {
		boolean esitoDelete;
		JTable tabellaAvventori = gestioneAvventoriPage.getTabellaAvventoriRistorante();
		String numCid = (String) tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 0);
	
		try {
			esitoDelete = avventoreDAO.deleteAvventore(numCid);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaAvventoriRistorante();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaAvventoreFromTavolata() {
		boolean esitoDelete;

		JTable tabellaTavolate = gestioneTavolatePage.getTabellaTavolateRistorante();
		int codTavolo = (int) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 1);
		String dataArrivo = (String) tabellaTavolate.getModel().getValueAt(tabellaTavolate.getSelectedRow(), 2);
		int codTavolata = tavolataDAO.getCodiceTavolataByDataArrivoAndTavolo(dataArrivo, codTavolo);
		JTable tabellaAvventori = gestioneAvventoriPage.getTabellaAvventoriRistorante();
		String numCid = (String) tabellaAvventori.getModel().getValueAt(tabellaAvventori.getSelectedRow(), 0);
		
		try {
			esitoDelete = avventoreDAO.deleteAvventoreFromTavolata(numCid, codTavolata);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
				riempiTabellaAvventoriRistorante(); 
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiTabellaCasiCovidRistorante(boolean isProprietario) {
		try {
			int codRistorante = 0;
			int numero = 1;
			ArrayList<Caso> casi;
			
			if (isProprietario) {
				codRistorante = this.getCodiceRistoranteForProprietario();
				casi = casoDAO.getCasiCovidByCodRistorante(codRistorante);
			} else
			{
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
						managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
				casi = casoDAO.getCasiCovidByCodRistorante(codRistorante);
			}
			
			DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			DefaultTableModel modellotabella = gestioneCasiCovidPage.getModel();
			modellotabella.getDataVector().removeAllElements();
			Object[] rigaTabella = new Object[6];
			
			for(Caso caso : casi) {
				rigaTabella[0] = numero++;
				rigaTabella[1] = caso.getCodiceCaso();
				rigaTabella[2] = dateFormat.format(caso.getDataRegistrazione()); 
				rigaTabella[3] = caso.getNumeroCID();
				rigaTabella[4] = caso.getStato();
				rigaTabella[5] = caso.getNote();
				modellotabella.addRow(rigaTabella);
			}
			modellotabella.fireTableDataChanged();
			gestioneCasiCovidPage.setModel(modellotabella);
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void aggiungiCasoCovid(String dataRegistrazione,String numCid,String stato,String note) {
		boolean esitoInsert;
		
		try {
			esitoInsert = casoDAO.insertCaso(dataRegistrazione, numCid, stato, note);
			if(esitoInsert) {
				mostraEsitoCorrettoRegistrazioneCasoCovid();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiComboBoxAvventoriGestioneCasiCovidPage(boolean isProprietario) {
		int codRistorante;
		ArrayList<Avventore> avventori;
		
		try {
			if(isProprietario) {
				codRistorante = getCodiceRistoranteForProprietario();
				avventori = avventoreDAO.getAvventoriRistorante(codRistorante);
				for(Avventore a : avventori) {
						aggiungiCasoCovidPage.getCampo_AvventorePositivo().addItem(a.getNumeroCid()+"-"+a.getNome()+" "+a.getCognome());
				}
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
				avventori = avventoreDAO.getAvventoriRistorante(codRistorante);
				for(Avventore a : avventori) {
					aggiungiCasoCovidPage.getCampo_AvventorePositivo().addItem(a.getNumeroCid()+"-"+a.getNome()+" "+a.getCognome());
				}
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void riempiCampiModificaCasoPage(boolean isProprietario) {
		int codRistorante;
		ArrayList<Avventore> avventori;
		JTable tabellaCasi = gestioneCasiCovidPage.getTabellaCasiRistorante();
		String dataReg = tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 2).toString();
		String avventorePositivo = tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 3).toString();
		String statoCaso = tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 4).toString();
		String note = "";
		if(!(tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 5) == null)) {
			note = tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(),5).toString();
		}
		
		try {	
			java.util.Date dataRegistrazione = new SimpleDateFormat("dd/MM/yyyy").parse(dataReg);
			modificaCasoCovidPage.getCampo_DataRegistrazioneCaso().setDate(dataRegistrazione);
			
			if(isProprietario) {
				codRistorante = getCodiceRistoranteForProprietario();
				avventori = avventoreDAO.getAvventoriRistorante(codRistorante);
				for(Avventore a : avventori) {
						modificaCasoCovidPage.getCampo_AvventorePositivo().addItem(a.getNumeroCid()+"-"+a.getNome()+" "+a.getCognome());
						modificaCasoCovidPage.getCampo_AvventorePositivo().setSelectedItem(avventorePositivo);
				}
			} else {
				codRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(managerRistorante.getRistoranteGestito().getDenominazione(),
						managerRistorante.getRistoranteGestito().getIndirizzo());
				avventori = avventoreDAO.getAvventoriRistorante(codRistorante);
				for(Avventore a : avventori) {
					modificaCasoCovidPage.getCampo_AvventorePositivo().addItem(a.getNumeroCid()+"-"+a.getNome()+" "+a.getCognome());
					modificaCasoCovidPage.getCampo_AvventorePositivo().setSelectedItem(avventorePositivo);
				}
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
		
		modificaCasoCovidPage.getCampo_StatoCaso().setSelectedItem(statoCaso);
		modificaCasoCovidPage.getCampo_Note().setText(note);
	}
	
	public void modificaCasoCovid(String dataRegistrazione,String numCid,String stato,String note) {
		boolean esitoUpdate;
		JTable tabellaCasi = gestioneCasiCovidPage.getTabellaCasiRistorante();
		int codCaso = (int) tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 1);
		
		try {
			esitoUpdate = casoDAO.updateCaso(codCaso, dataRegistrazione, numCid, stato, note);
			if(esitoUpdate) {
				mostraEsitoCorrettoUpdate();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void eliminaCasoCovid() {
		boolean esitoDelete;
		JTable tabellaCasi = gestioneCasiCovidPage.getTabellaCasiRistorante();
		int codCaso = (int) tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 1);
	
		try {
			esitoDelete = casoDAO.deleteCaso(codCaso);
			if(esitoDelete) {
				mostraEsitoCorrettoDelete();
			}
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void setLabelsTracciamentoAvventorePage() {
		JTable tabellaCasi = gestioneCasiCovidPage.getTabellaCasiRistorante();
		String numCid = tabellaCasi.getModel().getValueAt(tabellaCasi.getSelectedRow(), 3).toString();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			Avventore avventore = avventoreDAO.getAvventoreByNumcid(numCid);
			tracciamentoAvventorePage.getLblNumeroCartaDidentita().setText("Numero carta d'identita': "+avventore.getNumeroCid());
			tracciamentoAvventorePage.getLblNome().setText("Nome: "+avventore.getNome());
			tracciamentoAvventorePage.getLblCognome().setText("Cognome: "+avventore.getCognome());
			tracciamentoAvventorePage.getLblDataDiNascita().setText("Data di nascita: "+dateFormat.format(avventore.getDataDiNascita()));
			tracciamentoAvventorePage.getLblSesso().setText("Sesso: "+avventore.getSesso());
			tracciamentoAvventorePage.getLblCittaDiNascita().setText("Citta' di nascita: "+avventore.getCittaDiNascita());
			tracciamentoAvventorePage.getLblProvinciaDiNascita().setText("Provincia di nascita: "+avventore.getProvinciaDiNascita());
			tracciamentoAvventorePage.getLblCittaDiResidenza().setText("Citta' di residenza: "+avventore.getCittaDiResidenza());
			tracciamentoAvventorePage.getLblProvinciaDiResidenza().setText("Provincia di residenza: "+avventore.getProvinciaDiResidenza());
			tracciamentoAvventorePage.getLblTelefono().setText("Telefono: "+avventore.getTelefono());
			tracciamentoAvventorePage.getLblEmail().setText("Email: "+avventore.getEmail());
			tracciamentoAvventorePage.getLblTemperaturaRegistrata().setText("Temperatura registrata: "+String.valueOf(avventore.getTemperaturaCorporea()));
			tracciamentoAvventorePage.getLblProvvistoDiGreenpass().setText("Provvisto di Greenpass: "+String.valueOf(avventore.getGreenpass()));
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
	
	public void mostraStatisticheTestualiRistorantiProprietario(String dataInizio, String dataFine) {
		try {
			statisticheProprietarioPage.getEtichetta_TotaleAvventori().setText("Totale Avventori: " + 
					proprietarioDAO.getNumeroTotaleAvventoriRistoranti(dataInizio, dataFine));
			statisticheProprietarioPage.getEtichetta_Interni().setText("Interni: " + 
					proprietarioDAO.getNumeroAvventoriInterniRistoranti(dataInizio, dataFine));
			statisticheProprietarioPage.getEtichetta_Esterni().setText("Esterni: " + 
					proprietarioDAO.getNumeroAvventoriEsterniRistoranti(dataInizio, dataFine));
			statisticheProprietarioPage.getEtichetta_Positivi().setText("Positivi: " 
					+ proprietarioDAO.getNumeroAvventoriPositiviRistoranti(dataInizio, dataFine));	
			} catch (Exception e) {
				mostraErrore(e);
			}
	}
		
	public void mostraStatisticheTestualiPerSingoloRistorante(String dataInizio, String dataFine, String ristorante) {
		String[] splitted = ristorante.split(" - ");
		int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);  
		try {
			statisticheProprietarioPage.getEtichetta_TotaleAvventori().setText("Totale Avventori: " + 
					ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheProprietarioPage.getEtichetta_Interni().setText("Interni: "+ 
					ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheProprietarioPage.getEtichetta_Esterni().setText("Esterni: "+ 
					ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheProprietarioPage.getEtichetta_Positivi().setText("Positivi: "
					+ ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, codiceRistorante));	
		} catch (Exception e) {
			mostraErrore(e);
		}
	}
		
	public void mostraStatisticheTestualiPerSingoloRistoranteProprietario(String dataInizio, String dataFine) {
		int codiceRistorante = getCodiceRistoranteForProprietario();
		try {
			statisticheRistorantePage.getEtichetta_TotaleAvventori().setText("Totale Avventori: " 
					+ ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Interni().setText("Interni: "
					+ ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Esterni().setText("Esterni: "
					+ ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Positivi().setText("Positivi: "
					+ ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, codiceRistorante));	
			} catch (Exception e) {
				mostraErrore(e);
			}
	}
		
	public void mostraStatisticheTestualiPerSingoloRistoranteManager(String dataInizio, String dataFine) {
		try {	
			int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
					managerRistorante.getRistoranteGestito().getDenominazione(), managerRistorante.getRistoranteGestito().getIndirizzo());
			statisticheRistorantePage.getEtichetta_TotaleAvventori().setText("Totale Avventori: " + 
					ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Interni().setText("Interni: "+ 
					ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Esterni().setText("Esterni: "+ 
					ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, codiceRistorante));
			statisticheRistorantePage.getEtichetta_Positivi().setText("Positivi: "+ 
					ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, codiceRistorante));	
			} catch (Exception e) {
				mostraErrore(e);
			}	
	}
	
	public void creaGrafico(int valore1, int valore2, int totale, String testo1, String testo2) {
		DefaultPieDataset dataset = new DefaultPieDataset();
		dataset.setValue(testo1, valore1);
		dataset.setValue(testo2, valore2);
		JFreeChart grafico = ChartFactory.createPieChart("Totale: " + totale, dataset, true, true, false);
		PieSectionLabelGenerator labelGenerator = new StandardPieSectionLabelGenerator("{0} : ({2})", 
				new DecimalFormat("0"), new DecimalFormat("0%"));
		((PiePlot) grafico.getPlot()).setLabelGenerator(labelGenerator);
		
		ChartPanel pannello = new ChartPanel(grafico);
		JFrame frameGrafico = new JFrame("Grafico");
		frameGrafico.setContentPane(pannello);
		frameGrafico.setIconImage(Toolkit.getDefaultToolkit().getImage(GestionePersonaleFrame.class.getResource("/resources/icon.png")));
		frameGrafico.setSize(500,350);
		frameGrafico.setLocationRelativeTo(null);
		frameGrafico.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		frameGrafico.setResizable(false);
		frameGrafico.setAlwaysOnTop(true);
		frameGrafico.setAutoRequestFocus(true);
		frameGrafico.setVisible(true);
	}
	
	public void creaGraficoAvventoriPositiviRistoranteProprietario(String dataInizio, String dataFine) {
		int positivi = ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, getCodiceRistoranteForProprietario()); 
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, getCodiceRistoranteForProprietario());
		creaGrafico(totale-positivi, positivi , totale, "Non positivi", "Positivi");
	}
	
	public void creaGraficoAvventoriInterniEsterniRistoranteProprietario(String dataInizio, String dataFine) {
		int interni = ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, getCodiceRistoranteForProprietario());
		int esterni = ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, getCodiceRistoranteForProprietario());
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, getCodiceRistoranteForProprietario());
		creaGrafico(interni, esterni, totale, "Interni", "Esterni");
	}
	
	public void creaGraficoAvventoriPositiviRistorantePerManager(String dataInizio, String dataFine) {
		int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
				managerRistorante.getRistoranteGestito().getDenominazione(), managerRistorante.getRistoranteGestito().getIndirizzo());
		int positivi = ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, codiceRistorante); 
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante);
		creaGrafico(totale-positivi, positivi , totale, "Non positivi", "Positivi");
	}
	
	public void creaGraficoAvventoriInterniEsterniRistorantePerManager(String dataInizio, String dataFine) {
		int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(
				managerRistorante.getRistoranteGestito().getDenominazione(), managerRistorante.getRistoranteGestito().getIndirizzo());
		int interni = ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, codiceRistorante);
		int esterni = ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, codiceRistorante);
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante);
		creaGrafico(interni, esterni, totale, "Interni", "Esterni");
	}
	
	public void creaGraficoAvventoriPositiviRistorantePerProprietario(String dataInizio, String dataFine, String ristorante) {
		String[] splitted = ristorante.split(" - ");
		int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);
		int positivi = ristoranteDAO.getNumeroPositiviRistorante(dataInizio, dataFine, codiceRistorante); 
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante);
		creaGrafico(totale-positivi, positivi , totale, "Non positivi", "Positivi");
	}
	
	public void creaGraficoAvventoriInterniEsterniRistoranteProprietario(String dataInizio, String dataFine, String ristorante) {
		String[] splitted = ristorante.split(" - ");
		int codiceRistorante = ristoranteDAO.getCodiceRistoranteByDenominazioneAndIndirizzo(splitted[0], splitted[1]);
		int interni = ristoranteDAO.getNumeroAvventoriInterniRistorante(dataInizio, dataFine, codiceRistorante);
		int esterni = ristoranteDAO.getNumeroAvventoriEsterniRistorante(dataInizio, dataFine, codiceRistorante);
		int totale = ristoranteDAO.getNumeroTotaleAvventoriRistorante(dataInizio, dataFine, codiceRistorante);
		creaGrafico(interni, esterni, totale, "Interni", "Esterni");
	}
	
	public void creaGraficoAvventoriPositiviRistoranti(String dataInizio, String dataFine){
		int totale= proprietarioDAO.getNumeroTotaleAvventoriRistoranti(dataInizio, dataFine);
		int positivi = proprietarioDAO.getNumeroAvventoriPositiviRistoranti(dataInizio, dataFine);	
		creaGrafico(totale-positivi, positivi , totale, "Non positivi", "Positivi");
	}
	
	public void creaGraficoAvventoriInterniEsterniRistoranti(String dataInizio, String dataFine){
		int totale= proprietarioDAO.getNumeroTotaleAvventoriRistoranti(dataInizio, dataFine);
		int interni = proprietarioDAO.getNumeroAvventoriInterniRistoranti(dataInizio, dataFine);
		int esterni = proprietarioDAO.getNumeroAvventoriEsterniRistoranti(dataInizio, dataFine);
		creaGrafico(interni, esterni, totale, "Interni", "Esterni");
	}
		
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
	
	/*-----------------------------------------------------------------------------------------------------------------------------*/
	//metodi per la gestione dei JFrame
	
	public void startLoginFrame(){
		loginPage = new LoginFrame(this);
		loginPage.setVisible(true);
	}

	
	public void startHomepageProprietarioFrame() {
		loginPage.dispose();
		proprietarioPage = new HomepageProprietarioFrame(this); 
		setHomepageProprietario(proprietario);
		proprietarioPage.setVisible(true);
	}
	
	public void mostraHomepageProprietarioFrame() { 
		proprietarioPage.setVisible(true); 
	}
	
	public void startRistorantiProprietarioFrame() {
		proprietarioPage.dispose();
		ristorantiProprietarioPage = new RistorantiProprietarioFrame(this);
		ristorantiProprietarioPage.setVisible(true);
		riempiTabellaRistorantiDiProprietario();
	}
	
	public void startModificaRistoranteFrame() {
		ristorantiProprietarioPage.dispose();
		modificaRistorantePage = new ModificaRistoranteFrame(this);
		modificaRistorantePage.setVisible(true);
	}
	
	public void startAggiungiRistoranteFrame() {
		ristorantiProprietarioPage.dispose();
		aggiungiRistorantePage = new AggiungiRistoranteFrame(this);
		aggiungiRistorantePage.setVisible(true);
	}
	
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
	
	public void startInfoRistoranteFrame(boolean isProprietario) {
		gestioneRistorantePage.dispose();
		infoRistorantePage = new InfoRistoranteFrame(this, isProprietario);
		infoRistorantePage.setVisible(true);
	}
	
	public void startGestioneSaleETavolateFrame(boolean isProprietario) {
		gestioneRistorantePage.dispose();
		gestioneSaleETavolatePage = new GestioneSaleETavolateFrame(this, isProprietario);
		gestioneSaleETavolatePage.setVisible(true);
	}
	
	public void mostraGestioneSaleETavolateFrame() { 
		gestioneSaleETavolatePage.setVisible(true); 
	}
	 
	public void startAggiungiSalaFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		aggiungiSalaPage = new AggiungiSalaFrame(this,isProprietario);
		aggiungiSalaPage.setVisible(true);
	}
	
	public void startModificaSalaFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		modificaSalaPage = new ModificaSalaFrame(this, isProprietario);
		modificaSalaPage.setVisible(true);
	}
	
	public void startGestioneTavoliFrame(boolean isProprietario) {
		gestioneSaleETavolatePage.dispose();
		gestioneTavoliPage = new GestioneTavoliFrame(this, isProprietario);
		gestioneTavoliPage.setVisible(true);
	}
	
	public void mostraGestioneTavoliFrame() { 
		gestioneTavoliPage.setVisible(true); 
	}
	
	public void startAggiungiTavoloFrame(boolean isProprietario) {
		gestioneTavoliPage.dispose();
		aggiungiTavoloPage = new AggiungiTavoloFrame(this, isProprietario);
		aggiungiTavoloPage.setVisible(true);
	}
	
	public void startModificaTavoloFrame(boolean isProprietario) {
		modificaTavoloPage = new ModificaTavoloFrame(this, isProprietario);
		modificaTavoloPage.setVisible(true);
	}
	
	public void startGestioneTavolateFrame(boolean isProprietario) {
		gestioneTavolatePage = new GestioneTavolateFrame(this, isProprietario);
		gestioneTavolatePage.setVisible(true);
	}

	public void mostraGestioneTavolateFrame() { 
		gestioneTavolatePage.setVisible(true); 
	}
	
	public void startAggiungiTavolataFrame(boolean isProprietario) {
		aggiungiTavolataPage = new AggiungiTavolataFrame(this, isProprietario);
		aggiungiTavolataPage.setVisible(true);
	}
	
	public void startModificaTavolataFrame(boolean isProprietario) {
		modificaTavolataPage = new ModificaTavolataFrame(this, isProprietario);
		modificaTavolataPage.setVisible(true);
	}
	
	public void startGestioneAvventoriFrame(boolean isProprietario) {
		gestioneAvventoriPage = new GestioneAvventoriFrame(this, isProprietario);
		gestioneAvventoriPage.setVisible(true);
	}
		
	public void mostraGestioneAvventoriFrame() { 
		gestioneAvventoriPage.setVisible(true); 
	}
		
	public void startAggiungiAvventoreFrame(boolean isProprietario) {
		gestioneAvventoriPage.dispose();
		aggiungiAvventorePage = new AggiungiAvventoreFrame(this, isProprietario);
		aggiungiAvventorePage.setVisible(true);
	}
		
	public void startModificaAvventoreFrame(boolean isProprietario) {
		gestioneAvventoriPage.dispose();
		modificaAvventorePage = new ModificaAvventoreFrame(this, isProprietario);
		modificaAvventorePage.setVisible(true);
	}
	
	public void startImpostazioniProprietarioFrame () {
		impostazioniPage = new ImpostazioniProprietarioFrame(this);
		impostazioniPage.setVisible(true);
	}

	public void startGestionePersonaleFrame() {
		proprietarioPage.dispose();
		gestionePersonalePage = new GestionePersonaleFrame(this);
		gestionePersonalePage.setVisible(true);
	}
	
	public void mostraGestionePersonaleFrame() { 
		gestionePersonalePage.setVisible(true); 
	}
	
	public void startAggiungiCameriereFrame(boolean proprietario) {
		aggiungiCamerierePage = new AggiungiCameriereFrame(this, proprietario);
		aggiungiCamerierePage.setVisible(true);
	}
	
	public void startModificaCameriereFrame(boolean proprietario) {
		modificaCamerierePage = new ModificaCameriereFrame(this, proprietario);
		riempiCampiModificaCamerierePage();
		modificaCamerierePage.setVisible(true);
	}
	
	public void startAggiungiManagerFrame() {
		aggiungiManagerPage = new AggiungiManagerFrame(this);
		aggiungiManagerPage.setVisible(true);
	}
	
	public void startModificaManagerFrame() {
		modificaManagerPage = new ModificaManagerFrame(this);
		riempiCampiModificaManagerPage();
		modificaManagerPage.setVisible(true);
	}
	
	public void startGestioneCasiCovidFrame(boolean isProprietario) {
		gestioneCasiCovidPage = new GestioneCasiCovidFrame(this, isProprietario);
		gestioneCasiCovidPage.setVisible(true);
	}
	
	public void mostraGestioneCasiCovidFrame(boolean isProprietario) { 
		gestioneCasiCovidPage.setVisible(true);
		riempiTabellaCasiCovidRistorante(isProprietario);
	}
	
	public void startAggiungiCasoCovidFrame(boolean isProprietario) {
		aggiungiCasoCovidPage = new AggiungiCasoCovidFrame(this, isProprietario);
		aggiungiCasoCovidPage.setVisible(true);
	}

	public void startModificaCasoCovidFrame(boolean isProprietario) {
		modificaCasoCovidPage = new ModificaCasoCovidFrame(this, isProprietario);
		modificaCasoCovidPage.setVisible(true);
	}
	
	public void startTracciamentoAvventoreFrame(boolean isProprietario) {
		tracciamentoAvventorePage = new TracciamentoAvventoreFrame(this, isProprietario);
		tracciamentoAvventorePage.setVisible(true);
	}
	
	public void startStatisticheProprietario() {
		statisticheProprietarioPage = new StatisticheProprietarioFrame(this);
		statisticheProprietarioPage.setVisible(true);
	}

	public void startStatisticheRistorante(boolean proprietario) {
		statisticheRistorantePage = new StatisticheRistoranteFrame(this, proprietario);
		statisticheRistorantePage.setVisible(true);
	}
	
	/*------------------------------------------------------------------------------------------------------------------------*/
	//metodi per la gestione delle Dialog utente
	
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
	
	private void mostraEsitoCorrettoRegistrazioneCasoCovid() {
		JLabel lblEsitoInserimento = new JLabel("Caso COVID registrato correttamente!");
		lblEsitoInserimento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoInserimento,"Registrazione caso COVID effettuata",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostraEsitoCorrettoInsertAvventoreEsistente() {
		JLabel lblEsitoInserimento = new JLabel("<html>L'avventore risulta gia' registrato in uno dei ristoranti del proprietario.<br>"
				+ "E' stato aggiunto alla nuova tavolata con i dati precedentemente registrati."
				+ "<br>Per modificarli cliccare su modifica avventore!</html>");
		lblEsitoInserimento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoInserimento,"Inserimento effettuato",JOptionPane.INFORMATION_MESSAGE);
	}
	
	private void mostraEsitoCorrettoDelete() {
		JLabel lblEsitoInserimento = new JLabel("Eliminazione effettuata correttamente!");
		lblEsitoInserimento.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblEsitoInserimento,"Eliminazione effettuata",JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void mostraErrore(Exception e) {
		JLabel lblerroreDB = new JLabel("ERRORE GENERICO: "+e.getMessage()+"Riprovare.");
		lblerroreDB.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(null,lblerroreDB,"Errore",JOptionPane.ERROR_MESSAGE);
	}
	
	public void mostraErroreSelezioneDialog(JPanel pannello_Principale) {
		JLabel lblErrore = new JLabel("Attenzione: non hai selezionato una riga della tabella per cui effettuare l'operazione!");
		lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(pannello_Principale, lblErrore, "Attenzione", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostraErroreSelezionePersonale(JPanel pannello_Principale) {
		JLabel lblErrore = new JLabel("Attenzione: seleziona una due tabelle per effettuare l'operazione!");
		lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(pannello_Principale, lblErrore, "Attenzione", JOptionPane.WARNING_MESSAGE);
	}
	
	public void mostraErroreSelezioneAvventore(JPanel pannello_Principale) {
		JLabel lblErrore = new JLabel("Attenzione: non hai selezionato alcun avventore per cui associare il caso! Riprova.");
		lblErrore.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JOptionPane.showMessageDialog(pannello_Principale, lblErrore, "Attenzione", JOptionPane.WARNING_MESSAGE);
	}
	
/*---*/
}
