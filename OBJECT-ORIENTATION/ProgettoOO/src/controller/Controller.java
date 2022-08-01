package controller;

import gui.*;

public class Controller { 
	
	public boolean accessoProprietario;
	
	public static void main(String[] args) {
		Controller c = new Controller();
		c.startLogin();
	}
	
	public void startLogin(){
		Schermata_Login loginPage = new Schermata_Login(this);
		loginPage.setVisible(true);
		accessoProprietario = loginPage.getaccessoProprietario();
	}
	
	public void startHomepage_Proprietario() {
		Homepage_Proprietario proprietarioPage = new Homepage_Proprietario(this, accessoProprietario);
		proprietarioPage.setVisible(true);
	}
	
	/*Ove presente, boolean proprietario indica se la pagina viene aperta da un proprietario 
	(true) oppure da un manager (false).*/
	
	public void startRistorante(boolean proprietario) {
		Ristorante ristorantePage = new Ristorante(this, proprietario);
		ristorantePage.setVisible(true);
	}
	
	public void startRistoranti() {
		Ristoranti ristorantiPage = new Ristoranti(this, accessoProprietario);
		ristorantiPage.setVisible(true);
	}
	
	public void startManager() {
		Manager managerPage = new Manager(this, accessoProprietario);
		managerPage.setVisible(true);
	}

}
