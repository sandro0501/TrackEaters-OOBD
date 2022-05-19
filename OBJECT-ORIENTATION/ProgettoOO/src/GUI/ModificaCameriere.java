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

public class ModificaCameriere extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField dataNascitaField;
	private JTextField numeroDocumentoField;
	private JTextField cittÓNataleField;
	private JTextField cittÓResidenzaField;
	private JTextField telefonoField;
	private JTextField emailField;
	private JTextField cognomeField_8;
	private JTextField provinciaNataleField;
	private JTextField provinciaResidenzaField;
	private Controller thecontroller;

	
	public ModificaCameriere(Controller c) {
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
		
		JButton aggiungiButton = new JButton("Modifica");
		aggiungiButton.setBounds(277, 610, 117, 40);
		contentPane.add(aggiungiButton);
		
		nomeField = new JTextField();
		nomeField.setBounds(26, 121, 170, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		dataNascitaField = new JTextField();
		dataNascitaField.setBounds(26, 185, 170, 20);
		contentPane.add(dataNascitaField);
		dataNascitaField.setColumns(10);
		
		numeroDocumentoField = new JTextField();
		numeroDocumentoField.setBounds(26, 258, 170, 20);
		contentPane.add(numeroDocumentoField);
		numeroDocumentoField.setColumns(10);
		
		cittÓNataleField = new JTextField();
		cittÓNataleField.setBounds(26, 329, 170, 20);
		contentPane.add(cittÓNataleField);
		cittÓNataleField.setColumns(10);
		
		cittÓResidenzaField = new JTextField();
		cittÓResidenzaField.setBounds(26, 393, 170, 20);
		contentPane.add(cittÓResidenzaField);
		cittÓResidenzaField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(26, 521, 316, 20);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(26, 459, 316, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		cognomeField_8 = new JTextField();
		cognomeField_8.setBounds(257, 121, 170, 20);
		contentPane.add(cognomeField_8);
		cognomeField_8.setColumns(10);
		
		provinciaNataleField = new JTextField();
		provinciaNataleField.setBounds(257, 329, 170, 20);
		contentPane.add(provinciaNataleField);
		provinciaNataleField.setColumns(10);
		
		provinciaResidenzaField = new JTextField();
		provinciaResidenzaField.setBounds(257, 393, 170, 20);
		contentPane.add(provinciaResidenzaField);
		provinciaResidenzaField.setColumns(10);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setBounds(26, 107, 46, 14);
		contentPane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setBounds(257, 107, 59, 14);
		contentPane.add(CognomeLabel);
		
		JLabel dataNascitaLabel = new JLabel("Data di nascita");
		dataNascitaLabel.setBounds(26, 169, 144, 14);
		contentPane.add(dataNascitaLabel);
		
		JLabel numeroDocumentoLabel = new JLabel("Numero Documento");
		numeroDocumentoLabel.setBounds(26, 243, 129, 14);
		contentPane.add(numeroDocumentoLabel);
		
		JLabel cittaNataleLabel = new JLabel("Citt\u00E0 natale");
		cittaNataleLabel.setBounds(26, 315, 100, 14);
		contentPane.add(cittaNataleLabel);
		
		JLabel provinciaNataleLabel = new JLabel("Provincia natale");
		provinciaNataleLabel.setBounds(257, 315, 100, 14);
		contentPane.add(provinciaNataleLabel);
		
		JLabel cittÓResidenzaLabel = new JLabel("Citt\u00E0 residenza");
		cittÓResidenzaLabel.setBounds(26, 379, 100, 14);
		contentPane.add(cittÓResidenzaLabel);
		
		JLabel provinciaResidenzaLabel = new JLabel("Provincia residenza");
		provinciaResidenzaLabel.setBounds(257, 379, 100, 14);
		contentPane.add(provinciaResidenzaLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(26, 445, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(26, 507, 59, 14);
		contentPane.add(telefonoLabel);
		
		JLabel modificaCameriereLabel = new JLabel("MODIFICA CAMERIERE");
		modificaCameriereLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		modificaCameriereLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaCameriereLabel.setBounds(108, 43, 257, 30);
		contentPane.add(modificaCameriereLabel);
	}


}
