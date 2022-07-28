package gui;


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

public class Aggiunigi_Modifica_Ristorante extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Denominazione;
	private JTextField campo_Indirizzo;
	private JTextField campo_Telefono;
	private JTextField campo_Citta;
	private JTextField campo_Cap;
	private JTextField campo_SitoWeb;
	private JTextField campo_Email;
	private JTextField campo_Provincia;

	
	public Aggiunigi_Modifica_Ristorante() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Aggiungi_Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 700);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Ristorante = new JLabel("RISTORANTE");
		etichetta_Ristorante.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Ristorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Ristorante.setBounds(108, 43, 257, 30);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel etichetta_Denominazione = new JLabel("Denominazione");
		etichetta_Denominazione.setBounds(26, 107, 100, 14);
		pannello_Principale.add(etichetta_Denominazione);
		
		JLabel etichetta_Indirizzo = new JLabel("Indirizzo");
		etichetta_Indirizzo.setBounds(26, 169, 144, 14);
		pannello_Principale.add(etichetta_Indirizzo);
		
		JLabel etichetta_Telefono = new JLabel("Telefono");
		etichetta_Telefono.setBounds(26, 243, 129, 14);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_Citta = new JLabel("Citt\u00E0");
		etichetta_Citta.setBounds(26, 315, 100, 14);
		pannello_Principale.add(etichetta_Citta);
		
		JLabel etichetta_Provincia = new JLabel("Provincia");
		etichetta_Provincia.setBounds(257, 315, 100, 14);
		pannello_Principale.add(etichetta_Provincia);
		
		JLabel etichetta_Cap = new JLabel("CAP");
		etichetta_Cap.setBounds(26, 379, 100, 14);
		pannello_Principale.add(etichetta_Cap);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setBounds(26, 445, 46, 14);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_SitoWeb = new JLabel("Sito web");
		etichetta_SitoWeb.setBounds(26, 507, 59, 14);
		pannello_Principale.add(etichetta_SitoWeb);
		
		campo_Denominazione = new JTextField();
		campo_Denominazione.setBounds(26, 121, 170, 20);
		pannello_Principale.add(campo_Denominazione);
		campo_Denominazione.setColumns(10);
		
		campo_Indirizzo = new JTextField();
		campo_Indirizzo.setBounds(26, 185, 170, 20);
		pannello_Principale.add(campo_Indirizzo);
		campo_Indirizzo.setColumns(10);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setBounds(26, 258, 316, 20);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		campo_Citta = new JTextField();
		campo_Citta.setBounds(26, 329, 170, 20);
		pannello_Principale.add(campo_Citta);
		campo_Citta.setColumns(10);
		
		campo_Provincia = new JTextField();
		campo_Provincia.setBounds(257, 329, 170, 20);
		pannello_Principale.add(campo_Provincia);
		campo_Provincia.setColumns(10);
		
		campo_Cap = new JTextField();
		campo_Cap.setBounds(26, 393, 170, 20);
		pannello_Principale.add(campo_Cap);
		campo_Cap.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setBounds(26, 459, 316, 20);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		campo_SitoWeb = new JTextField();
		campo_SitoWeb.setBounds(26, 521, 316, 20);
		pannello_Principale.add(campo_SitoWeb);
		campo_SitoWeb.setColumns(10);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setBounds(80, 610, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setBounds(277, 610, 117, 40);
		pannello_Principale.add(bottone_Aggiungi);
	}

}
