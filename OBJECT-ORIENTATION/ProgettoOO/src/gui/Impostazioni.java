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

public class Impostazioni extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JPasswordField password_ConfermaPassword;
	private JPasswordField password_Password;
	private Controller theController;

	
	public Impostazioni(Controller c) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 458);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Impostazioni = new JLabel("IMPOSTAZIONI");
		etichetta_Impostazioni.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Impostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Impostazioni.setBounds(108, 43, 257, 30);
		pannello_Principale.add(etichetta_Impostazioni);
		
		JLabel etichetta_Nome = new JLabel("Nome");
		etichetta_Nome.setBounds(36, 101, 46, 14);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome");
		etichetta_Cognome.setBounds(267, 101, 59, 14);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_Email = new JLabel("Username");
		etichetta_Email.setBounds(36, 170, 76, 14);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Password = new JLabel("Password");
		etichetta_Password.setBounds(36, 240, 117, 14);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_ConfermaPassword = new JLabel("Conferma password");
		etichetta_ConfermaPassword.setBounds(36, 307, 117, 14);
		pannello_Principale.add(etichetta_ConfermaPassword);
		
		campo_Nome = new JTextField();
		campo_Nome.setBounds(36, 115, 170, 20);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setBounds(267, 115, 170, 20);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setBounds(36, 183, 401, 20);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.setBounds(36, 254, 401, 20);
		pannello_Principale.add(password_Password);
		
		password_ConfermaPassword = new JPasswordField();
		password_ConfermaPassword.setBounds(36, 321, 401, 20);
		pannello_Principale.add(password_ConfermaPassword);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startHomepageProprietario();
				}
			}
		});
		bottone_Annulla.setBounds(36, 368, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Conferma = new JButton("Conferma");
		bottone_Conferma.setBounds(320, 368, 117, 40);
		pannello_Principale.add(bottone_Conferma);
	}
}
