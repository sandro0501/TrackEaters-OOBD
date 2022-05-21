package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class ModificaManager extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField telefonoField;
	private JTextField emailField;
	private JTextField cognomeField;
	private Controller thecontroller;
	private JTextField textField;
	private JTextField textField_1;

	
	public ModificaManager(Controller c) {
		thecontroller = c;
		setIconImage(Toolkit.getDefaultToolkit().getImage(AggiungiAvventori.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(80, 610, 117, 40);
		contentPane.add(annullaButton);
		
		JButton modificaButton = new JButton("Modifica");
		modificaButton.setBounds(277, 610, 117, 40);
		contentPane.add(modificaButton);
		
		nomeField = new JTextField();
		nomeField.setBounds(26, 121, 170, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(26, 409, 316, 20);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(26, 193, 316, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		cognomeField = new JTextField();
		cognomeField.setBounds(257, 121, 170, 20);
		contentPane.add(cognomeField);
		cognomeField.setColumns(10);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setBounds(26, 107, 46, 14);
		contentPane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setBounds(257, 107, 59, 14);
		contentPane.add(CognomeLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(26, 180, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(26, 395, 59, 14);
		contentPane.add(telefonoLabel);
		
		JLabel modificaManagerLabel = new JLabel("MODIFICA MANAGER");
		modificaManagerLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		modificaManagerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaManagerLabel.setBounds(108, 43, 257, 30);
		contentPane.add(modificaManagerLabel);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(26, 264, 316, 20);
		contentPane.add(textField);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(26, 250, 117, 14);
		contentPane.add(passwordLabel);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(26, 335, 316, 20);
		contentPane.add(textField_1);
		
		JLabel ConfermaPasswordLabel = new JLabel("Conferma password");
		ConfermaPasswordLabel.setBounds(26, 321, 117, 14);
		contentPane.add(ConfermaPasswordLabel);
		
		JComboBox ristorantecomboBox = new JComboBox();
		ristorantecomboBox.setBounds(26, 491, 316, 22);
		contentPane.add(ristorantecomboBox);
		
		JLabel ristoranteLabel = new JLabel("Ristorante");
		ristoranteLabel.setBounds(26, 477, 59, 14);
		contentPane.add(ristoranteLabel);
	}

}
