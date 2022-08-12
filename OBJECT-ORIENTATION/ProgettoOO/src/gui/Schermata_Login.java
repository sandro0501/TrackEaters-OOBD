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
import javax.swing.JOptionPane;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


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
		etichetta_Username.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/usericon.png")));
		etichetta_Username.setForeground(new Color(0, 0, 128));
		etichetta_Username.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Username.setBounds(352, 40, 121, 27);
		pannello_Principale.add(etichetta_Username);
		
		JLabel etichetta_Password = new JLabel("Password");
		etichetta_Password.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/passwordicon.png")));
		etichetta_Password.setForeground(new Color(0, 0, 128));
		etichetta_Password.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Password.setBounds(352, 132, 108, 27);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_Ruolo = new JLabel("Sono un:");
		etichetta_Ruolo.setForeground(new Color(0, 0, 128));
		etichetta_Ruolo.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		etichetta_Ruolo.setBounds(352, 231, 108, 22);
		pannello_Principale.add(etichetta_Ruolo);
		
		JLabel lblUsernameEmpty = new JLabel("");
		lblUsernameEmpty.setForeground(new Color(47, 79, 79));
		lblUsernameEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblUsernameEmpty.setBounds(352, 93, 180, 27);
		pannello_Principale.add(lblUsernameEmpty);
		
		JLabel lblPasswordEmpty = new JLabel("");
		lblPasswordEmpty.setForeground(new Color(47, 79, 79));
		lblPasswordEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblPasswordEmpty.setBounds(352, 186, 180, 27);
		pannello_Principale.add(lblPasswordEmpty);
		
		campo_Username = new JTextField();
		campo_Username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblUsernameEmpty.setText("");
			}
		});
		campo_Username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Username.setBounds(352, 67, 180, 27);
		pannello_Principale.add(campo_Username);
		campo_Username.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblPasswordEmpty.setText("");
			}
		});
		password_Password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password_Password.setBounds(352, 159, 180, 27);
		pannello_Principale.add(password_Password);
		
		JComboBox comboBox_Ruolo = new JComboBox();
		comboBox_Ruolo.setForeground(new Color(0, 0, 0));
		comboBox_Ruolo.setBackground(new Color(255, 255, 255));
		comboBox_Ruolo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_Ruolo.setModel(new DefaultComboBoxModel(new String[] {"Proprietario", "ManagerRistorante"}));
		comboBox_Ruolo.setSelectedIndex(0);
		comboBox_Ruolo.setBounds(352, 255, 180, 27);
		pannello_Principale.add(comboBox_Ruolo);
		
		JLabel lblMainlogoImage = new JLabel("");
		lblMainlogoImage.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/mainlogo.png")));
		lblMainlogoImage.setBounds(22, 40, 271, 317);
		pannello_Principale.add(lblMainlogoImage);
		
		JButton bottone_Login = new JButton("LOGIN");
		bottone_Login.setIcon(new ImageIcon(Schermata_Login.class.getResource("/resources/loginbutton.png")));
		bottone_Login.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Login.setBounds(352, 340, 160, 40);
		pannello_Principale.add(bottone_Login);
		bottone_Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(campo_Username.getText().trim().isEmpty() && password_Password.getText().trim().isEmpty()) {
					lblUsernameEmpty.setText("* Campo username vuoto");
					lblPasswordEmpty.setText("* Campo password vuoto");	
				} else if(campo_Username.getText().trim().isEmpty()) {
					lblUsernameEmpty.setText(" * Campo username vuoto");
				} else if(password_Password.getText().trim().isEmpty()) {
					lblPasswordEmpty.setText("* Campo password vuoto");	
				} else {
					//metodo login
					c.loginOperatore(campo_Username.getText(), password_Password.getText(), comboBox_Ruolo.getSelectedItem().toString());
					
				}
			}
		});
	}
}
