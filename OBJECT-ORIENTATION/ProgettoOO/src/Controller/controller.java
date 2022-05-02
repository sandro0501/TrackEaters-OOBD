package Controller;

import java.awt.Window;

import javax.swing.*;

import GUI.*;

public class controller {
	
	Login ln;
	RegistrazioneManager rgm;
	HomepageProprietario hgpr;
	HomepageManager hgmg;
	IMieiRistoranti imrst;
	Personale prspg;
	
	public static void main (String[] args) {
		controller c = new controller(); 
		c.login();
	}
	
	public void login() {
		ln = new Login(this);
		ln.setVisible(true);
	}
	
	public void newUser() {
		rgm = new RegistrazioneManager(this);
		rgm.setVisible(true);
	}
	
	public void loginProprietario() {
		hgpr = new HomepageProprietario(this);
		hgpr.setVisible(true);
	}
	
	public void loginManager() {
		hgmg = new HomepageManager(this);
		hgmg.setVisible(true);
	}

	
	public void iMieiRistorantiProprietario() {
		imrst = new IMieiRistoranti(this);
		imrst.setVisible(true);
	}
	
	public void personaleProprietario() {
		prspg = new Personale(this);
		prspg.setVisible(true);
	}

}
