package Controller;

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
	
	public void NewUser() {
		rgm = new RegistrazioneManager(this);
		ln.setVisible(false);
		rgm.setVisible(true);
	}
	
	public void back() {
		rgm.setVisible(false);
		ln.setVisible(true);
	}
	
	public void login() {
		hgpr = new HomepageProprietario(this);
		ln.setVisible(false);
		hgpr.setVisible(true);
	}

}
