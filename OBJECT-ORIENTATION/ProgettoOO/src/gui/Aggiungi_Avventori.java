package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;

public class Aggiungi_Avventori extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_DataNascita;
	private JTextField campo_NumeroDocumento;
	private JTextField campo_CittaNatale;
	private JTextField campo_CittaResidenza;
	private JTextField campo_Telefono;
	private JTextField campo_email;
	private JTextField campo_Cognome;
	private JTextField campo_ProvinciaNatale;
	private JTextField campo_ProvinciaResidenza;
	private JTextField campo_TemperaturaIngresso;
	private Controller theController;

	
	public Aggiungi_Avventori(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Aggiungi_Avventori.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 700);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		campo_Nome = new JTextField();
		campo_Nome.setBounds(27, 83, 170, 20);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setBounds(258, 83, 170, 20);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_DataNascita = new JTextField();
		campo_DataNascita.setBounds(27, 147, 170, 20);
		pannello_Principale.add(campo_DataNascita);
		campo_DataNascita.setColumns(10);
		
		campo_NumeroDocumento = new JTextField();
		campo_NumeroDocumento.setBounds(27, 220, 170, 20);
		pannello_Principale.add(campo_NumeroDocumento);
		campo_NumeroDocumento.setColumns(10);
		
		campo_CittaNatale = new JTextField();
		campo_CittaNatale.setBounds(27, 291, 170, 20);
		pannello_Principale.add(campo_CittaNatale);
		campo_CittaNatale.setColumns(10);
		
		campo_ProvinciaNatale = new JTextField();
		campo_ProvinciaNatale.setBounds(258, 291, 170, 20);
		pannello_Principale.add(campo_ProvinciaNatale);
		campo_ProvinciaNatale.setColumns(10);
		
		campo_CittaResidenza = new JTextField();
		campo_CittaResidenza.setBounds(27, 355, 170, 20);
		pannello_Principale.add(campo_CittaResidenza);
		campo_CittaResidenza.setColumns(10);
		
		campo_ProvinciaResidenza = new JTextField();
		campo_ProvinciaResidenza.setBounds(258, 355, 170, 20);
		pannello_Principale.add(campo_ProvinciaResidenza);
		campo_ProvinciaResidenza.setColumns(10);
		
		campo_email = new JTextField();
		campo_email.setBounds(27, 421, 316, 20);
		pannello_Principale.add(campo_email);
		campo_email.setColumns(10);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setBounds(27, 483, 316, 20);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		JComboBox comboBox_Greenpass = new JComboBox();
		comboBox_Greenpass.setModel(new DefaultComboBoxModel(new String[] {"Si", "No"}));
		comboBox_Greenpass.setBounds(27, 547, 170, 22);
		pannello_Principale.add(comboBox_Greenpass);
		
		campo_TemperaturaIngresso = new JTextField();
		campo_TemperaturaIngresso.setBounds(258, 548, 170, 20);
		pannello_Principale.add(campo_TemperaturaIngresso);
		campo_TemperaturaIngresso.setColumns(10);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startAvventori(proprietario);
				}
			}
		});
		bottone_Annulla.setBounds(80, 610, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Conferma = new JButton("Conferma");
		bottone_Conferma.setBounds(277, 610, 117, 40);
		pannello_Principale.add(bottone_Conferma);
		
		JLabel etichetta_Avventore = new JLabel("AVVENTORE");
		etichetta_Avventore.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Avventore.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Avventore.setBounds(137, 20, 200, 30);
		pannello_Principale.add(etichetta_Avventore);
		
		JLabel etichetta_Nome = new JLabel("Nome");
		etichetta_Nome.setBounds(27, 69, 46, 14);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome");
		etichetta_Cognome.setBounds(258, 69, 59, 14);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_DataNascita = new JLabel("Data di nascita");
		etichetta_DataNascita.setBounds(27, 131, 144, 14);
		pannello_Principale.add(etichetta_DataNascita);
		
		JLabel etichetta_NumeroDocumento = new JLabel("Numero Documento");
		etichetta_NumeroDocumento.setBounds(27, 205, 129, 14);
		pannello_Principale.add(etichetta_NumeroDocumento);
		
		JLabel etichetta_CittaNatale = new JLabel("Citt\u00E0 natale");
		etichetta_CittaNatale.setBounds(27, 277, 100, 14);
		pannello_Principale.add(etichetta_CittaNatale);
		
		JLabel etichetta_ProvinciaNatale = new JLabel("Provincia natale");
		etichetta_ProvinciaNatale.setBounds(258, 277, 100, 14);
		pannello_Principale.add(etichetta_ProvinciaNatale);
		
		JLabel etichetta_CittaResidenza = new JLabel("Citt\u00E0 residenza");
		etichetta_CittaResidenza.setBounds(27, 341, 100, 14);
		pannello_Principale.add(etichetta_CittaResidenza);
		
		JLabel etichetta_ProvinciaResidenza = new JLabel("Provincia residenza");
		etichetta_ProvinciaResidenza.setBounds(258, 341, 100, 14);
		pannello_Principale.add(etichetta_ProvinciaResidenza);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setBounds(27, 407, 46, 14);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Telefono = new JLabel("Telefono");
		etichetta_Telefono.setBounds(27, 469, 59, 14);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_GreenPass = new JLabel("GreenPass");
		etichetta_GreenPass.setBounds(27, 533, 100, 14);
		pannello_Principale.add(etichetta_GreenPass);
		
		JLabel etichetta_TemperaturaIngresso = new JLabel("Temperatura ingresso");
		etichetta_TemperaturaIngresso.setBounds(258, 533, 117, 14);
		pannello_Principale.add(etichetta_TemperaturaIngresso);
	}
}
