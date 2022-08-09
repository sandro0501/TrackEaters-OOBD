package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;

public class Modifica_Cameriere extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_DataNascita;
	private JTextField campo_NumeroDocumento;
	private JTextField campo_CittaNatale;
	private JTextField campo_CittaResidenza;
	private JTextField campo_Telefono;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JTextField campo_ProvinciaNatale;
	private JTextField campo_ProvinciaResidenza;
	private Controller theController;

	
	public Modifica_Cameriere(Controller c, boolean proprietario) {
		
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
		
		campo_Nome = new JTextField();
		campo_Nome.setBounds(26, 121, 170, 20);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setBounds(257, 121, 170, 20);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_DataNascita = new JTextField();
		campo_DataNascita.setBounds(26, 185, 170, 20);
		pannello_Principale.add(campo_DataNascita);
		campo_DataNascita.setColumns(10);
		
		campo_NumeroDocumento = new JTextField();
		campo_NumeroDocumento.setBounds(26, 258, 170, 20);
		pannello_Principale.add(campo_NumeroDocumento);
		campo_NumeroDocumento.setColumns(10);
		
		campo_CittaNatale = new JTextField();
		campo_CittaNatale.setBounds(26, 329, 170, 20);
		pannello_Principale.add(campo_CittaNatale);
		campo_CittaNatale.setColumns(10);
		
		campo_ProvinciaNatale = new JTextField();
		campo_ProvinciaNatale.setBounds(257, 329, 170, 20);
		pannello_Principale.add(campo_ProvinciaNatale);
		campo_ProvinciaNatale.setColumns(10);
		
		campo_CittaResidenza = new JTextField();
		campo_CittaResidenza.setBounds(26, 393, 170, 20);
		pannello_Principale.add(campo_CittaResidenza);
		campo_CittaResidenza.setColumns(10);
		
		campo_ProvinciaResidenza = new JTextField();
		campo_ProvinciaResidenza.setBounds(257, 393, 170, 20);
		pannello_Principale.add(campo_ProvinciaResidenza);
		campo_ProvinciaResidenza.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setBounds(26, 459, 316, 20);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setBounds(26, 521, 316, 20);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		JLabel etichetta_Cameriere = new JLabel("CAMERIERE");
		etichetta_Cameriere.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Cameriere.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Cameriere.setBounds(108, 43, 257, 30);
		pannello_Principale.add(etichetta_Cameriere);
		
		JLabel etichetta_Nome = new JLabel("Nome");
		etichetta_Nome.setBounds(26, 107, 46, 14);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome");
		etichetta_Cognome.setBounds(257, 107, 59, 14);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_DataNascita = new JLabel("Data di nascita");
		etichetta_DataNascita.setBounds(26, 169, 144, 14);
		pannello_Principale.add(etichetta_DataNascita);
		
		JLabel etichetta_NumeroDocumento = new JLabel("Numero Documento");
		etichetta_NumeroDocumento.setBounds(26, 243, 129, 14);
		pannello_Principale.add(etichetta_NumeroDocumento);
		
		JLabel etichetta_CittaNatale = new JLabel("Citt\u00E0 natale");
		etichetta_CittaNatale.setBounds(26, 315, 100, 14);
		pannello_Principale.add(etichetta_CittaNatale);
		
		JLabel etichetta_ProvinciaNatale = new JLabel("Provincia natale");
		etichetta_ProvinciaNatale.setBounds(257, 315, 100, 14);
		pannello_Principale.add(etichetta_ProvinciaNatale);
		
		JLabel etichetta_CittaResidenza = new JLabel("Citt\u00E0 residenza");
		etichetta_CittaResidenza.setBounds(26, 379, 100, 14);
		pannello_Principale.add(etichetta_CittaResidenza);
		
		JLabel etichetta_ProvinciaResidenza = new JLabel("Provincia residenza");
		etichetta_ProvinciaResidenza.setBounds(257, 379, 100, 14);
		pannello_Principale.add(etichetta_ProvinciaResidenza);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setBounds(26, 445, 46, 14);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Telefono = new JLabel("Telefono");
		etichetta_Telefono.setBounds(26, 507, 59, 14);
		pannello_Principale.add(etichetta_Telefono);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startCamerieri(proprietario);
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
