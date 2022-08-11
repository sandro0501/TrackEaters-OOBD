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
import javax.swing.ImageIcon;
import java.awt.Image;

import controller.Controller;
import javax.swing.border.BevelBorder;


public class Schermata_Login extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Username;
	private JPasswordField password_Password;
	private Controller theController;
	
	public Schermata_Login(Controller c) {
		
		theController = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Schermata_Login.class.getResource("/resources/icon.png")));
		setResizable(false);
		setTitle("TrackEaters");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 601, 493);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Username = new JLabel("Username");
		etichetta_Username.setForeground(new Color(0, 0, 128));
		etichetta_Username.setFont(new Font("Segoe UI", Font.BOLD, 15));
		etichetta_Username.setBounds(356, 77, 77, 14);
		pannello_Principale.add(etichetta_Username);
		
		JLabel etichetta_Password = new JLabel("Password");
		etichetta_Password.setForeground(new Color(0, 0, 128));
		etichetta_Password.setFont(new Font("Segoe UI", Font.BOLD, 15));
		etichetta_Password.setBounds(356, 156, 74, 14);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_Ruolo = new JLabel("Sono un:");
		etichetta_Ruolo.setForeground(new Color(0, 0, 128));
		etichetta_Ruolo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		etichetta_Ruolo.setBounds(356, 230, 68, 14);
		pannello_Principale.add(etichetta_Ruolo);
		
		campo_Username = new JTextField();
		campo_Username.setBounds(356, 102, 160, 20);
		pannello_Principale.add(campo_Username);
		campo_Username.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.setBounds(356, 181, 160, 20);
		pannello_Principale.add(password_Password);
		
		JComboBox comboBox_Ruolo = new JComboBox();
		comboBox_Ruolo.setForeground(new Color(0, 0, 0));
		comboBox_Ruolo.setBackground(new Color(255, 255, 255));
		comboBox_Ruolo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		comboBox_Ruolo.setModel(new DefaultComboBoxModel(new String[] {"Proprietario", "ManagerRistorante"}));
		comboBox_Ruolo.setSelectedIndex(0);
		comboBox_Ruolo.setBounds(356, 255, 160, 22);
		pannello_Principale.add(comboBox_Ruolo);
		
		JButton bottone_Login = new JButton("LOGIN");
		bottone_Login.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/loginbutton.png")));
		bottone_Login.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Login.setBounds(356, 350, 160, 40);
		pannello_Principale.add(bottone_Login);
		bottone_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/* if (comboBox_Ruolo.getSelectedIndex()==0){
					setVisible(false);
					c.startHomepageProprietario();
				} else {
					setVisible(false);
					c.startRistorante(false);
				} */
				c.loginOperatore(campo_Username.getText(), password_Password.getText(), comboBox_Ruolo.getSelectedItem().toString());
			}
		});
		
		JLabel lblMainlogoImage = new JLabel("");
		lblMainlogoImage.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/mainlogo.png")));
		lblMainlogoImage.setBounds(20, 77, 271, 317);
		pannello_Principale.add(lblMainlogoImage);
		

		
	}
}
