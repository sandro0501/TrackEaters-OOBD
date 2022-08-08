package controller;

import java.sql.*;

import database.ConnessioneDatabase;
import gui.*;

public class Controller { 
	
	public static void main(String[] args) {
		Controller c = new Controller();
		
/* test connessione database 
		try {
			Connection conn = ConnessioneDatabase.getIstanzaConnessione().getConnessione();
			System.out.println("Connessione al database riuscita");
			Statement stmt = conn.createStatement();
			ResultSet rs;
			String query = "SELECT * FROM RISTORANTE";
			rs = stmt.executeQuery(query);
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnsNumber = rsmd.getColumnCount(); 
			while(rs.next())
			{
				for(int i=1; i<=columnsNumber; i++){
					System.out.print(rs.getString(i) + "|");
				}
				  System.out.println();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
*/
		c.startLogin();
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
	
	public void startAggiungiManager(boolean proprietario) {
		Aggiungi_Manager aggiungiManagerPage = new Aggiungi_Manager(this, proprietario);
		aggiungiManagerPage.setVisible(true);
	}
	
	public void startAggiungiRistorante() {
		Aggiungi_Ristorante aggiungiPage = new Aggiungi_Ristorante(this);
		aggiungiPage.setVisible(true);
	}
	
	public void startAggiuniSala(boolean proprietario) {
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
	
	public void startHomepageProprietario() {
		Homepage_Proprietario proprietarioPage = new Homepage_Proprietario(this);
		proprietarioPage.setVisible(true);
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
	
	public void startModificaManager(boolean proprietario) {
		Modifica_Manager modificaManagerPage = new Modifica_Manager(this, proprietario);
		modificaManagerPage.setVisible(true);
	}
	
	public void startModificaRistorante() {
		Modifica_Ristorante modificaRistorantePage = new Modifica_Ristorante(this);
		modificaRistorantePage.setVisible(true);
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
	
	public void startRistorante(boolean proprietario) {
		Ristorante ristorantePage = new Ristorante(this, proprietario);
		ristorantePage.setVisible(true);
	}
	
	public void startRistoranti() {
		Ristoranti ristorantiPage = new Ristoranti(this);
		ristorantiPage.setVisible(true);
	}
	
	public void startSale(boolean proprietario) {
		Sale salePage = new Sale(this, proprietario);
		salePage.setVisible(true);
	}
	
	public void startLogin(){
		Schermata_Login loginPage = new Schermata_Login(this);
		loginPage.setVisible(true);
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
	
	
	
	
	
	
	
	
	

}
