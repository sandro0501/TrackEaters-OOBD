package Controller;

import java.awt.Window;

import javax.swing.*;

import GUI.*;

public class Controller {
	
	Schermata_Login loginPage;
	Homepage_Proprietario homepageProprietarioPage;
	Ristorante homepageManagerPage;
	Ristoranti iMieiRistorantiPage;
	Tavolate tavolatePage;
	Statistiche statistichePage;
	Ristorante informazioniRistorantePage;
	
	public static void main (String[] args) {
		Controller c = new Controller(); 
		c.login();
	}
	
	public void login() {
		loginPage = new Schermata_Login(this);
		loginPage.setVisible(true);
	}
	
	
	public void startLoginProprietario() {
		homepageProprietarioPage = new Homepage_Proprietario(this);
		homepageProprietarioPage.setVisible(true);
	}
	
	public void startLoginManager() {
		homepageManagerPage = new Ristorante(this);
		homepageManagerPage.setVisible(true);
	}

	
	public void startI_MieiRistorantiProprietario() {
		iMieiRistorantiPage = new Ristoranti(this);
		iMieiRistorantiPage.setVisible(true);
	}
	
	
	public void startTavolate() {
		tavolatePage = new Tavolate(this);
		tavolatePage.setVisible(true);
	}
	
	public void startStatistiche() {
		statistichePage = new Statistiche(this);
		statistichePage.setVisible(true);
	}
	
	public void startInformazioniRistorante() {
		informazioniRistorantePage = new Ristorante(this);
		informazioniRistorantePage.setVisible(true);
	}

}
