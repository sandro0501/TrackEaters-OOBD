package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import Controller.controller;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Login extends JFrame {

	private JPanel LoginPane;
	private JTextField UsernameField;
	private controller theController;
	private JPasswordField passwordField;

	public Login(controller c) {
		theController = c;
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/resources/icon.png")));
		setResizable(false);
		setTitle("SecurRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		LoginPane = new JPanel();
		LoginPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(LoginPane);
		LoginPane.setLayout(null);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(249, 29, 160, 20);
		LoginPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		JComboBox RuoloBox = new JComboBox();
		RuoloBox.setBounds(249, 119, 160, 22);
		LoginPane.add(RuoloBox);
		
		JButton LoginNewButton = new JButton("Login");
		LoginNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		LoginNewButton.setBounds(250, 156, 90, 40);
		LoginPane.add(LoginNewButton);
		
		JButton RegistrazioneNewButton = new JButton("Registrazione");
		RegistrazioneNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.NewUser();
			}
		});
		RegistrazioneNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		RegistrazioneNewButton.setBounds(249, 227, 160, 23);
		LoginPane.add(RegistrazioneNewButton);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		UsernameLabel.setBounds(249, 15, 77, 14);
		LoginPane.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PasswordLabel.setBounds(249, 60, 74, 14);
		LoginPane.add(PasswordLabel);
		
		JLabel RuoloLabel = new JLabel("Ruolo");
		RuoloLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RuoloLabel.setBounds(249, 105, 68, 14);
		LoginPane.add(RuoloLabel);
		
		JLabel RegistrazioneLabel = new JLabel("Non ancora registrato?");
		RegistrazioneLabel.setFont(new Font("Tahoma", Font.ITALIC, 12));
		RegistrazioneLabel.setBounds(250, 206, 146, 14);
		LoginPane.add(RegistrazioneLabel);
		
		JLabel PictureLabel = new JLabel("");
		PictureLabel.setBounds(10, 16, 162, 145);
		LoginPane.add(PictureLabel);
		
		JTextPane SistemaDiTracciamentotxtpn = new JTextPane();
		SistemaDiTracciamentotxtpn.setBackground(SystemColor.control);
		SistemaDiTracciamentotxtpn.setEditable(false);
		SistemaDiTracciamentotxtpn.setText("Sistema di tracciamento contatti ristorante ");
		SistemaDiTracciamentotxtpn.setBounds(10, 172, 162, 40);
		LoginPane.add(SistemaDiTracciamentotxtpn);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(249, 74, 160, 20);
		LoginPane.add(passwordField);
	}
}
