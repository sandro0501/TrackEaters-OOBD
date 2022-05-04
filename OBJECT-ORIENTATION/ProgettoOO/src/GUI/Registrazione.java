package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
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
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class Registrazione extends JFrame {

	private JPanel RegistrazionePane;
	private Controller theController;
	private JTextField UsernameField;
	private JTextField nomeField;
	private JTextField CognomeField;
	private JTextField EmailField;
	private JTextField TelefonoField;
	private JPasswordField passwordField;


	public Registrazione(Controller c) {
		setAlwaysOnTop(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Registrazione.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto\r\n");
		theController = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		RegistrazionePane = new JPanel();
		RegistrazionePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(RegistrazionePane);
		RegistrazionePane.setLayout(null);
		
		UsernameField = new JTextField();
		UsernameField.setBounds(298, 37, 160, 20);
		RegistrazionePane.add(UsernameField);
		UsernameField.setColumns(10);
		
		nomeField = new JTextField();
		nomeField.setBounds(298, 128, 160, 20);
		RegistrazionePane.add(nomeField);
		nomeField.setColumns(10);
		
		CognomeField = new JTextField();
		CognomeField.setBounds(298, 173, 160, 20);
		RegistrazionePane.add(CognomeField);
		CognomeField.setColumns(10);
		
		EmailField = new JTextField();
		EmailField.setBounds(298, 218, 160, 20);
		RegistrazionePane.add(EmailField);
		EmailField.setColumns(10);
		
		TelefonoField = new JTextField();
		TelefonoField.setBounds(298, 263, 160, 20);
		RegistrazionePane.add(TelefonoField);
		TelefonoField.setColumns(10);
		
		JComboBox RistorantecomboBox = new JComboBox();
		RistorantecomboBox.setBounds(298, 308, 160, 22);
		RegistrazionePane.add(RistorantecomboBox);
		
		JLabel UsernameLabel = new JLabel("Username");
		UsernameLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		UsernameLabel.setBounds(298, 23, 104, 14);
		RegistrazionePane.add(UsernameLabel);
		
		JLabel PasswordLabel = new JLabel("Password");
		PasswordLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PasswordLabel.setBounds(298, 68, 104, 14);
		RegistrazionePane.add(PasswordLabel);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		NomeLabel.setBounds(298, 113, 104, 14);
		RegistrazionePane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CognomeLabel.setBounds(298, 159, 104, 14);
		RegistrazionePane.add(CognomeLabel);
		
		JLabel EmailLabel = new JLabel("Email");
		EmailLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		EmailLabel.setBounds(298, 204, 104, 14);
		RegistrazionePane.add(EmailLabel);
		
		JLabel TelefonoLabel = new JLabel("Telefono");
		TelefonoLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		TelefonoLabel.setBounds(298, 249, 104, 14);
		RegistrazionePane.add(TelefonoLabel);
		
		JLabel RistoranteLabel = new JLabel("Ristorante");
		RistoranteLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RistoranteLabel.setBounds(298, 294, 104, 14);
		RegistrazionePane.add(RistoranteLabel);
		
		JButton RegistrazioneButton = new JButton("Registra");
		RegistrazioneButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		RegistrazioneButton.setBounds(330, 399, 104, 39);
		RegistrazionePane.add(RegistrazioneButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(298, 82, 160, 20);
		RegistrazionePane.add(passwordField);
		
		JLabel PictureLabel = new JLabel("");
		PictureLabel.setBounds(10, 23, 216, 190);
		RegistrazionePane.add(PictureLabel);
		
		JTextPane RegistrazionePersonalePane = new JTextPane();
		RegistrazionePersonalePane.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RegistrazionePersonalePane.setBackground(SystemColor.control);
		RegistrazionePersonalePane.setEditable(false);
		RegistrazionePersonalePane.setText("Registrazione personale\r\nristorante\r\n");
		RegistrazionePersonalePane.setBounds(10, 233, 216, 34);
		RegistrazionePane.add(RegistrazionePersonalePane);
		
		JButton btnNewButton = new JButton("Indietro");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startPersonaleProprietario();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 407, 89, 23);
		RegistrazionePane.add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Manager", "Cameriere"}));
		comboBox.setBounds(298, 353, 160, 22);
		RegistrazionePane.add(comboBox);
		
		JLabel RuoloLabel = new JLabel("Ruolo");
		RuoloLabel.setBounds(298, 340, 46, 14);
		RegistrazionePane.add(RuoloLabel);
	}
}
