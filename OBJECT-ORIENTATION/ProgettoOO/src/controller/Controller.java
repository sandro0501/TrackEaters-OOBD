package controller;

import gui.*;

public class Controller { 
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.startLogin();
	}
	public void startAggiungi_Avventori(boolean proprietario) {
		Aggiungi_Avventori aggiungiAvventoriPage = new Aggiungi_Avventori(this, proprietario);
	}
	
	public void startAggiungi_Cameriere(boolean proprietario) {
		Aggiungi_Cameriere aggiungiCamerierePage = new Aggiungi_Cameriere(null, proprietario);
	}
	
	public void startAggiungi_Caso(boolean proprietario) {
		Aggiungi_Caso aggiungiCasoPage = new Aggiungi_Caso(this, proprietario);
	}
	
	public void startAggiungi_Manager(boolean proprietario) {
		Aggiungi_Manager aggiungiManagerPage = new Aggiungi_Manager(this, proprietario);
	}
	
	public void startAggiungi_Ristorante() {
		Aggiungi_Ristorante aggiungiPage = new Aggiungi_Ristorante(this);
		aggiungiPage.setVisible(true);
	}
	
	public void startAggiuni_Sala(boolean proprietario) {
		Aggiungi_Sala aggiungiSalaPage = new Aggiungi_Sala(this, proprietario);
	}
	
	public void startAggiungi_Tavolata(boolean proprietario) {
		Aggiungi_Tavolata aggiungiTavolataPage = new Aggiungi_Tavolata(this, proprietario);
	}
	
	public void startAggiungi_Tavolo(boolean proprietario) {
		Aggiungi_Tavolo aggiungiTavoloPage = new Aggiungi_Tavolo(this, proprietario);
	}
	
	public void startAvventori(boolean proprietario) {
		Avventori avventoriPage = new Avventori(this, proprietario);
	}
	
	public void startCamerieri(boolean proprietario) {
		Camerieri camerieriPage = new Camerieri(this, proprietario);
	}
	
	public void startCasi(boolean proprietario) {
		Casi casiPage = new Casi(this, proprietario);
	}
	
	public void startHomepage_Proprietario() {
		Homepage_Proprietario proprietarioPage = new Homepage_Proprietario(this);
		proprietarioPage.setVisible(true);
	}
	
	public void startManager() {
		Manager managerPage = new Manager(this);
		managerPage.setVisible(true);
	}
	
	public void startModificaAvventori(boolean proprietario) {
		Modifica_Avventori modificaAvventoriPage = new Modifica_Avventori(this, proprietario);
	}
	
	public void startModificaCameriere(boolean proprietario) {
		Modifica_Cameriere modificaCamerierePage = new Modifica_Cameriere(this, proprietario);
	}
	
	public void startModificaCaso(boolean proprietario) {
		Modifica_Caso modificaPage = new Modifica_Caso(this, proprietario);
	}
	
	public void startModificaManager(boolean proprietario) {
		Modifica_Manager modificaPage = new Modifica_Manager(this, proprietario);
	}
	
	public void startModificaRistorante() {
		Modifica_Ristorante modificaPage = new Modifica_Ristorante(this);
	}
	
	public void startModificaSala(boolean proprietario) {
		Modifica_Sala modificaPage = new Modifica_Sala(this, proprietario);
	}
	
	public void startModificaTavolata(boolean proprietario) {
		Modifica_Tavolata modificaPage = new Modifica_Tavolata(this, proprietario);
	}
	
	public void startModificaTavolo(boolean proprietario) {
		Modifica_Tavolo modificaPage = new Modifica_Tavolo(this, proprietario);
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
	}
	
	public void startTavoli(boolean proprietario) {
		Tavoli tavolatePage = new Tavoli(this, proprietario);
	}
	
	
	
	
	
	
	
	
	

}
