package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.controller;
import java.awt.Toolkit;

public class RegistrazioneManager extends JFrame {

	private JPanel RegistrazioneManagerPane;
	private controller theController;


	public RegistrazioneManager(controller c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrazioneManager.class.getResource("/resources/icon.png")));
		setTitle("SecureRisto\r\n");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 600);
		RegistrazioneManagerPane = new JPanel();
		RegistrazioneManagerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RegistrazioneManagerPane);
		RegistrazioneManagerPane.setLayout(null);
	}

}
