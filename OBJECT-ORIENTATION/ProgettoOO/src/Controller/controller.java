package Controller;

import java.awt.Window;

import javax.swing.*;

import GUI.*;

public class controller {
	
	Login ln;
	RegistrazioneManager rgm;
	HomepageProprietario hgpr;
	
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
	
	public void back() {
		ln.setVisible(true);
	}
	
	public void login() {
		hgpr = new HomepageProprietario(this);
		ln.setVisible(false);
		hgpr.setVisible(true);
	}
	
	public void logout() {
		ln.setVisible(true);
	}
	
	public void homeProprietario() {
		hgpr.setVisible(true);
	}

}
