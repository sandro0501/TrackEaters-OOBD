package gui;


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
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

import controller.Controller;


public class Schermata_Login extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Username;
	private JPasswordField password_Password;
	private Controller theController;
	
	public Schermata_Login(Controller c) {
		
		theController = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Schermata_Login.class.getResource("/resources/icon.png")));
		setResizable(false);
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Username = new JLabel("Username");
		etichetta_Username.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etichetta_Username.setBounds(138, 31, 77, 14);
		pannello_Principale.add(etichetta_Username);
		
		JLabel etichetta_Password = new JLabel("Password");
		etichetta_Password.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etichetta_Password.setBounds(138, 76, 74, 14);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_Ruolo = new JLabel("Ruolo");
		etichetta_Ruolo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		etichetta_Ruolo.setBounds(138, 121, 68, 14);
		pannello_Principale.add(etichetta_Ruolo);
		
		campo_Username = new JTextField();
		campo_Username.setBounds(138, 45, 160, 20);
		pannello_Principale.add(campo_Username);
		campo_Username.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.setBounds(138, 90, 160, 20);
		pannello_Principale.add(password_Password);
		
		JComboBox comboBox_Ruolo = new JComboBox();
		comboBox_Ruolo.setModel(new DefaultComboBoxModel(new String[] {"Proprietario", "Manager"}));
		comboBox_Ruolo.setSelectedIndex(0);
		comboBox_Ruolo.setBounds(138, 135, 160, 22);
		pannello_Principale.add(comboBox_Ruolo);
		
		JButton bottone_Login = new JButton("Login");
		bottone_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_Ruolo.getSelectedIndex()==0){
				setVisible(false);
				c.startHomepage_Proprietario();
			} else { 
				setVisible(false);
				c.startRistorante(false);
			}
		}
		});
		bottone_Login.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Login.setBounds(172, 172, 90, 40);
		pannello_Principale.add(bottone_Login);
	}
}
