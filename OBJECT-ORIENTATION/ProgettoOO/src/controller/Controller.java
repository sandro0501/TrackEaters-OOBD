package controller;

import gui.*;

public class Controller { 
	
	Schermata_Login loginPage;
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.startLogin();
	}
	
	public void startLogin(){
		loginPage = new Schermata_Login(this);
		//accessoProprietario = loginPage.getaccessoProprietario();
		loginPage.setVisible(true);
		
	}
	
	public void startHomepage_Proprietario() {
		Homepage_Proprietario proprietarioPage = new Homepage_Proprietario(this);
		proprietarioPage.setVisible(true);
	}
	
	/* Ove presente, boolean proprietario indica se la pagina viene aperta da: 	*
	 * un proprietario (true) 													*
	 * un manager (false).														*/
	
	public void startRistorante(boolean proprietario) {
		Ristorante ristorantePage = new Ristorante(this, proprietario);
		ristorantePage.setVisible(true);
	}
	
	public void startRistoranti() {
		Ristoranti ristorantiPage = new Ristoranti(this);
		ristorantiPage.setVisible(true);
	}
	
	public void startManager(boolean proprietario) {
		Manager managerPage = new Manager(this, proprietario);
		managerPage.setVisible(true);
	}

}
