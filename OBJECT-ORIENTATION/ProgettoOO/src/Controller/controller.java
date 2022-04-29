package Controller;

import GUI.*;

public class controller {
	
	Login ln;
	RegistrazioneManager rgm;
	
	public static void main (String[] args) {
		controller c = new controller(); 
		
	}
	
	public controller() {
		ln = new Login(this);
		rgm = new RegistrazioneManager(this);
		ln.setVisible(true);
	}
	
	public void NewUser() {
		ln.setVisible(false);
		rgm.setVisible(true);
	}

}
