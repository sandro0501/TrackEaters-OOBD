package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class ModificaRistorante extends JFrame {

	private JPanel contentPane;
	private JTextField denominazioneField;
	private JTextField indirizzoField;
	private JTextField telefonoField;
	private JTextField cittaField;
	private JTextField capField;
	private JTextField sitoWebField;
	private JTextField emailField;
	private JTextField provinciaField;
	private Controller thecontroller;

	
	public ModificaRistorante(Controller c) {
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
		
		denominazioneField = new JTextField();
		denominazioneField.setBounds(26, 121, 170, 20);
		contentPane.add(denominazioneField);
		denominazioneField.setColumns(10);
		
		indirizzoField = new JTextField();
		indirizzoField.setBounds(26, 185, 170, 20);
		contentPane.add(indirizzoField);
		indirizzoField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(26, 258, 316, 20);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		cittaField = new JTextField();
		cittaField.setBounds(26, 329, 170, 20);
		contentPane.add(cittaField);
		cittaField.setColumns(10);
		
		capField = new JTextField();
		capField.setBounds(26, 393, 170, 20);
		contentPane.add(capField);
		capField.setColumns(10);
		
		sitoWebField = new JTextField();
		sitoWebField.setBounds(26, 521, 316, 20);
		contentPane.add(sitoWebField);
		sitoWebField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(26, 459, 316, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		provinciaField = new JTextField();
		provinciaField.setBounds(257, 329, 170, 20);
		contentPane.add(provinciaField);
		provinciaField.setColumns(10);
		
		JLabel denominazioneLabel = new JLabel("Denominazione");
		denominazioneLabel.setBounds(26, 107, 100, 14);
		contentPane.add(denominazioneLabel);
		
		JLabel indirizzoLabel = new JLabel("Indirizzo");
		indirizzoLabel.setBounds(26, 169, 144, 14);
		contentPane.add(indirizzoLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(26, 243, 129, 14);
		contentPane.add(telefonoLabel);
		
		JLabel cittaLabel = new JLabel("Citt\u00E0");
		cittaLabel.setBounds(26, 315, 100, 14);
		contentPane.add(cittaLabel);
		
		JLabel provinciaNataleLabel = new JLabel("Provincia");
		provinciaNataleLabel.setBounds(257, 315, 100, 14);
		contentPane.add(provinciaNataleLabel);
		
		JLabel cittaResidenzaLabel = new JLabel("CAP");
		cittaResidenzaLabel.setBounds(26, 379, 100, 14);
		contentPane.add(cittaResidenzaLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(26, 445, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel sitoWebLabel = new JLabel("Sito web");
		sitoWebLabel.setBounds(26, 507, 59, 14);
		contentPane.add(sitoWebLabel);
		
		JLabel modificaRistoranteLabel = new JLabel("MODIFICA RISTORANTE");
		modificaRistoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		modificaRistoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaRistoranteLabel.setBounds(108, 43, 257, 30);
		contentPane.add(modificaRistoranteLabel);
	}


}
