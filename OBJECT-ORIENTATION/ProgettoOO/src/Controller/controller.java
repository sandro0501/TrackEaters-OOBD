package Controller;

import java.awt.Window;

import javax.swing.*;

import GUI.*;

public class controller {
	
	Login loginPage;
	Registrazione registrazioneManagerPage;
	HomepageProprietario homepageProprietarioPage;
	HomepageManager homepageManagerPage;
	IMieiRistoranti iMieiRistorantiPage;
	Personale personalePage;
	Tavolate tavolatePage;
	
	public static void main (String[] args) {
		controller c = new controller(); 
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
	
	public void startLoginManager() {
		homepageManagerPage = new HomepageManager(this);
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

}
