package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.controller;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegistrazioneManager extends JFrame {

	private JPanel RegistrazioneManagerPane;
	private controller theController;
	private JTextField UsernameField;
	private JTextField nomeField;
	private JTextField CognomeField;
	private JTextField EmailField;
	private JTextField TelefonoField;
	private JPasswordField passwordField;


	public RegistrazioneManager(controller c) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrazioneManager.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto\r\n");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		RegistrazioneManagerPane = new JPanel();
		RegistrazioneManagerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RegistrazioneManagerPane);
		RegistrazioneManagerPane.setLayout(null);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(298, 37, 160, 20);
		RegistrazioneManagerPane.add(UsernameField);
		UsernameField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(298, 137, 160, 20);
		RegistrazioneManagerPane.add(nomeField);
		nomeField.setColumns(10);
		
		CognomeField = new JTextField();
		CognomeField.setBounds(298, 193, 160, 20);
		RegistrazioneManagerPane.add(CognomeField);
		CognomeField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setBounds(298, 247, 160, 20);
		RegistrazioneManagerPane.add(EmailField);
		EmailField.setColumns(10);
		
		TelefonoField = new JTextField();
		TelefonoField.setBounds(298, 303, 160, 20);
		RegistrazioneManagerPane.add(TelefonoField);
		TelefonoField.setColumns(10);
		
		JComboBox RistorantecomboBox = new JComboBox();
		RistorantecomboBox.setBounds(298, 361, 160, 22);
		RegistrazioneManagerPane.add(RistorantecomboBox);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		UsernameLabel.setBounds(298, 23, 104, 14);
		RegistrazioneManagerPane.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PasswordLabel.setBounds(298, 71, 104, 14);
		RegistrazioneManagerPane.add(PasswordLabel);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NomeLabel.setBounds(298, 122, 104, 14);
		RegistrazioneManagerPane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CognomeLabel.setBounds(298, 179, 104, 14);
		RegistrazioneManagerPane.add(CognomeLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		EmailLabel.setBounds(298, 233, 104, 14);
		RegistrazioneManagerPane.add(EmailLabel);
		
		JLabel TelefonoLabel = new JLabel("Telefono");
		TelefonoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TelefonoLabel.setBounds(298, 289, 104, 14);
		RegistrazioneManagerPane.add(TelefonoLabel);
		
		JLabel RistoranteLabel = new JLabel("Ristorante");
		RistoranteLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RistoranteLabel.setBounds(298, 347, 104, 14);
		RegistrazioneManagerPane.add(RistoranteLabel);
		
		JButton RegistrazioneButton = new JButton("Registrati");
		RegistrazioneButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		RegistrazioneButton.setBounds(330, 399, 104, 39);
		RegistrazioneManagerPane.add(RegistrazioneButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 85, 160, 20);
		RegistrazioneManagerPane.add(passwordField);
		
		JLabel PictureLabel = new JLabel("");
		PictureLabel.setBounds(10, 23, 216, 190);
		RegistrazioneManagerPane.add(PictureLabel);
		
		JTextPane Registrazione_ManagerPane = new JTextPane();
		Registrazione_ManagerPane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		Registrazione_ManagerPane.setBackground(SystemColor.control);
		Registrazione_ManagerPane.setEditable(false);
		Registrazione_ManagerPane.setText("Registrazione manager \r\nristorante");
		Registrazione_ManagerPane.setBounds(10, 233, 216, 34);
		RegistrazioneManagerPane.add(Registrazione_ManagerPane);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.login();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 407, 89, 23);
		RegistrazioneManagerPane.add(btnNewButton);
	}

}
