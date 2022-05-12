package Controller;

import java.awt.Window;

import javax.swing.*;

import GUI.*;

public class Controller {
	
	Login loginPage;
	Registrazione registrazioneManagerPage;
	HomepageProprietario homepageProprietarioPage;
	HomepageManager homepageManagerPage;
	IMieiRistoranti iMieiRistorantiPage;
	Personale personalePage;
	Tavolate tavolatePage;
	Statistiche statistichePage;
	InformazioniRistorante informazioniRistorantePage;
	
	public static void main (String[] args) {
		Controller c = new Controller(); 
		c.login();
	}
	
	public void login() {
		loginPage = new Login(this);
		loginPage.setVisible(true);
	}
	
	public void startRegistrazione() {
		registrazioneManagerPage = new Registrazione(this);
		registrazioneManagerPage.setVisible(true);
	}
	
	public void startLoginProprietario() {
		homepageProprietarioPage = new HomepageProprietario(this);
		homepageProprietarioPage.setVisible(true);
	}
	
	public void startLoginManager(boolean flag) {
		homepageManagerPage = new HomepageManager(this, flag);
		homepageManagerPage.setVisible(true);
	}

	
	public void startI_MieiRistorantiProprietario() {
		iMieiRistorantiPage = new IMieiRistoranti(this);
		iMieiRistorantiPage.setVisible(true);
	}
	
	public void startPersonaleProprietario() {
		personalePage = new Personale(this);
		personalePage.setVisible(true);
	}
	
	public void startTavolate() {
		tavolatePage = new Tavolate(this);
		tavolatePage.setVisible(true);
	}
	
	public void startStatistiche() {
		statistichePage = new Statistiche(this);
		statistichePage.setVisible(true);
	}
	
	public void startInformazioniRistorante(boolean flag) {
		informazioniRistorantePage = new InformazioniRistorante(this, flag);
		informazioniRistorantePage.setVisible(true);
	}

}
