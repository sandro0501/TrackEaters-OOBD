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
	
	public static void main (String[] args) {
		controller c = new controller(); 
		
	}
	
	public controller() {
		ln = new Login(this);
		ln.setVisible(true);
	}
	

	
	public void newUser() {
		rgm = new RegistrazioneManager(this);
		ln.setVisible(false);
		rgm.setVisible(true);
	}
	
	public void loginProprietario() {
		hgpr = new HomepageProprietario(this);
		ln.setVisible(false);
		hgpr.setVisible(true);
	}
	
	public void loginManager() {
		hgmg = new HomepageManager(this);
		ln.setVisible(false);
		hgmg.setVisible(true);
	}
	
	public void logout() {
		ln.setVisible(true);
	}
	
	public void homeProprietario() {
		hgpr.setVisible(true);
	}
	
	public void iMieiRistorantiProprietario() {
		imrst = new IMieiRistoranti(this);
		imrst.setVisible(true);
	}

}
