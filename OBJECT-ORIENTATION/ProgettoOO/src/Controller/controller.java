package Controller;

import GUI.*;

public class controller {
	
	public static void main (String[] args) {
		controller c = new controller(); 
		
	}
	
	public controller() {
		Login ln = new Login(this);
		ln.setVisible(true);
	}

}
