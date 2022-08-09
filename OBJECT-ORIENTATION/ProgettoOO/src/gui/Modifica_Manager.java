package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

import controller.Controller;

public class Modifica_Manager extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_Telefono;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JPasswordField password_ConfermaPassword;
	private JPasswordField password_Password;
	private Controller theController;

	
	public Modifica_Manager(Controller c) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 700);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Manager = new JLabel("MANAGER");
		etichetta_Manager.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Manager.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Manager.setBounds(108, 43, 257, 30);
		pannello_Principale.add(etichetta_Manager);
		
		JLabel etichetta_Nome = new JLabel("Nome");
		etichetta_Nome.setBounds(26, 107, 46, 14);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome");
		etichetta_Cognome.setBounds(257, 107, 59, 14);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setBounds(26, 180, 46, 14);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Password = new JLabel("Password");
		etichetta_Password.setBounds(26, 250, 117, 14);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_ConfermaPassword = new JLabel("Conferma password");
		etichetta_ConfermaPassword.setBounds(26, 321, 117, 14);
		pannello_Principale.add(etichetta_ConfermaPassword);
		
		JLabel etichetta_Telefono = new JLabel("Telefono");
		etichetta_Telefono.setBounds(26, 395, 59, 14);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_Ristorante = new JLabel("Ristorante");
		etichetta_Ristorante.setBounds(26, 477, 59, 14);
		pannello_Principale.add(etichetta_Ristorante);
		
		campo_Nome = new JTextField();
		campo_Nome.setBounds(26, 121, 170, 20);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setBounds(257, 121, 170, 20);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setBounds(26, 193, 316, 20);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.setBounds(26, 264, 316, 20);
		pannello_Principale.add(password_Password);
		
		password_ConfermaPassword = new JPasswordField();
		password_ConfermaPassword.setBounds(26, 335, 316, 20);
		pannello_Principale.add(password_ConfermaPassword);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setBounds(26, 409, 316, 20);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		JComboBox comboBox_Ristorante = new JComboBox();
		comboBox_Ristorante.setBounds(26, 491, 316, 22);
		pannello_Principale.add(comboBox_Ristorante);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startManager();
				}
			}
		});
		bottone_Annulla.setBounds(80, 610, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Conferma = new JButton("Conferma");
		bottone_Conferma.setBounds(277, 610, 117, 40);
		pannello_Principale.add(bottone_Conferma);
	}
}
