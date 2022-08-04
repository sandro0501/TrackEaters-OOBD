package controller;

import gui.*;

public class Controller { 
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.startLogin();
	}
	
	public void startLogin(){
		Schermata_Login loginPage = new Schermata_Login(this);
		loginPage.setVisible(true);
	}
	
	public void startHomepage_Proprietario() {
		Homepage_Proprietario proprietarioPage = new Homepage_Proprietario(this);
		proprietarioPage.setVisible(true);
	}
	
	public void startRistorante(boolean proprietario) {
		Ristorante ristorantePage = new Ristorante(this, proprietario);
		ristorantePage.setVisible(true);
	}
	
	public void startRistoranti() {
		Ristoranti ristorantiPage = new Ristoranti(this);
		ristorantiPage.setVisible(true);
	}
	
	public void startAggiungi_Ristorante() {
		
	}
	
	public void startManager() {
		Manager managerPage = new Manager(this);
		managerPage.setVisible(true);
	}
	
	public void startStatistiche(boolean proprietario, boolean generale) {
		Statistiche statistichePage = new Statistiche(this, proprietario, generale);
		statistichePage.setVisible(true);
	}

}
