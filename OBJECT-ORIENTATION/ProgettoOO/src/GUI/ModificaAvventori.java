package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import Controller.Controller;

import Controller.Controller;

public class ModificaAvventori extends JFrame {

	private JPanel contentPane;
	private JTextField nomeField;
	private JTextField dataNascitaField;
	private JTextField numeroDocumentoField;
	private JTextField citt‡NataleField;
	private JTextField citt‡ResidenzaField;
	private JTextField telefonoField;
	private JTextField emailField;
	private JTextField cognomeField_8;
	private JTextField provinciaNataleField;
	private JTextField provinciaResidenzaField;
	private JTextField temperaturaIngressoField;
	private Controller thecontroller;

	
	public ModificaAvventori(Controller c) {
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
		nomeField.setBounds(27, 83, 170, 20);
		contentPane.add(nomeField);
		nomeField.setColumns(10);
		
		dataNascitaField = new JTextField();
		dataNascitaField.setBounds(27, 147, 170, 20);
		contentPane.add(dataNascitaField);
		dataNascitaField.setColumns(10);
		
		numeroDocumentoField = new JTextField();
		numeroDocumentoField.setBounds(27, 220, 170, 20);
		contentPane.add(numeroDocumentoField);
		numeroDocumentoField.setColumns(10);
		
		citt‡NataleField = new JTextField();
		citt‡NataleField.setBounds(27, 291, 170, 20);
		contentPane.add(citt‡NataleField);
		citt‡NataleField.setColumns(10);
		
		citt‡ResidenzaField = new JTextField();
		citt‡ResidenzaField.setBounds(27, 355, 170, 20);
		contentPane.add(citt‡ResidenzaField);
		citt‡ResidenzaField.setColumns(10);
		
		telefonoField = new JTextField();
		telefonoField.setBounds(27, 483, 316, 20);
		contentPane.add(telefonoField);
		telefonoField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(27, 421, 316, 20);
		contentPane.add(emailField);
		emailField.setColumns(10);
		
		JComboBox greenPassComboBox = new JComboBox();
		greenPassComboBox.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		greenPassComboBox.setBounds(27, 547, 170, 22);
		contentPane.add(greenPassComboBox);
		
		cognomeField_8 = new JTextField();
		cognomeField_8.setBounds(258, 83, 170, 20);
		contentPane.add(cognomeField_8);
		cognomeField_8.setColumns(10);
		
		provinciaNataleField = new JTextField();
		provinciaNataleField.setBounds(258, 291, 170, 20);
		contentPane.add(provinciaNataleField);
		provinciaNataleField.setColumns(10);
		
		provinciaResidenzaField = new JTextField();
		provinciaResidenzaField.setBounds(258, 355, 170, 20);
		contentPane.add(provinciaResidenzaField);
		provinciaResidenzaField.setColumns(10);
		
		temperaturaIngressoField = new JTextField();
		temperaturaIngressoField.setBounds(258, 548, 170, 20);
		contentPane.add(temperaturaIngressoField);
		temperaturaIngressoField.setColumns(10);
		
		JLabel NomeLabel = new JLabel("Nome");
		NomeLabel.setBounds(27, 69, 46, 14);
		contentPane.add(NomeLabel);
		
		JLabel CognomeLabel = new JLabel("Cognome");
		CognomeLabel.setBounds(258, 69, 59, 14);
		contentPane.add(CognomeLabel);
		
		JLabel dataNascitaLabel = new JLabel("Data di nascita");
		dataNascitaLabel.setBounds(27, 131, 144, 14);
		contentPane.add(dataNascitaLabel);
		
		JLabel numeroDocumentoLabel = new JLabel("Numero Documento");
		numeroDocumentoLabel.setBounds(27, 205, 129, 14);
		contentPane.add(numeroDocumentoLabel);
		
		JLabel cittaNataleLabel = new JLabel("Citt\u00E0 natale");
		cittaNataleLabel.setBounds(27, 277, 100, 14);
		contentPane.add(cittaNataleLabel);
		
		JLabel provinciaNataleLabel = new JLabel("Provincia natale");
		provinciaNataleLabel.setBounds(258, 277, 100, 14);
		contentPane.add(provinciaNataleLabel);
		
		JLabel citt‡ResidenzaLabel = new JLabel("Citt\u00E0 residenza");
		citt‡ResidenzaLabel.setBounds(27, 341, 100, 14);
		contentPane.add(citt‡ResidenzaLabel);
		
		JLabel provinciaResidenzaLabel = new JLabel("Provincia residenza");
		provinciaResidenzaLabel.setBounds(258, 341, 100, 14);
		contentPane.add(provinciaResidenzaLabel);
		
		JLabel emailLabel = new JLabel("Email");
		emailLabel.setBounds(27, 407, 46, 14);
		contentPane.add(emailLabel);
		
		JLabel telefonoLabel = new JLabel("Telefono");
		telefonoLabel.setBounds(27, 469, 59, 14);
		contentPane.add(telefonoLabel);
		
		JLabel greenPassLabel = new JLabel("GreenPass");
		greenPassLabel.setBounds(27, 533, 100, 14);
		contentPane.add(greenPassLabel);
		
		JLabel temperaturaIngressoLabel = new JLabel("Temperatura ingresso");
		temperaturaIngressoLabel.setBounds(258, 533, 117, 14);
		contentPane.add(temperaturaIngressoLabel);
		
		JLabel modificaAvventoreLabel = new JLabel("Modifica avventore");
		modificaAvventoreLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		modificaAvventoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaAvventoreLabel.setBounds(137, 20, 200, 30);
		contentPane.add(modificaAvventoreLabel);
	}

}
