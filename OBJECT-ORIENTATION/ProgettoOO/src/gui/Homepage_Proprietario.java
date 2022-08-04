package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

import controller.Controller;

public class Homepage_Proprietario extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	
	public Homepage_Proprietario(Controller c) {
		
		theController = c;
				
		setResizable(false);
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage_Proprietario.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JTextPane testo_BenvenutoNomeCognome = new JTextPane();
		testo_BenvenutoNomeCognome.setBounds(10, 11, 200, 72);
		testo_BenvenutoNomeCognome.setEditable(false);
		testo_BenvenutoNomeCognome.setBackground(SystemColor.control);
		testo_BenvenutoNomeCognome.setFont(new Font("Tahoma", Font.BOLD, 12));
		testo_BenvenutoNomeCognome.setText("Benvenuto\r\nNome Cognome\r\nusername - mail@mail.it");
		pannello_Principale.add(testo_BenvenutoNomeCognome);
		
		JLabel etichetta_TracciamentoContattiCovid = new JLabel("TRACCIAMENTO CONTATTI COVID-19");
		etichetta_TracciamentoContattiCovid.setBounds(273, 94, 490, 52);
		etichetta_TracciamentoContattiCovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_TracciamentoContattiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		pannello_Principale.add(etichetta_TracciamentoContattiCovid);
		
		JButton bottone_IMieiRistoranti = new JButton("I miei ristoranti");
		bottone_IMieiRistoranti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistoranti();
				
			}
		});
		bottone_IMieiRistoranti.setBounds(104, 205, 130, 50);
		bottone_IMieiRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pannello_Principale.add(bottone_IMieiRistoranti);
		
		JButton bottone_Manager = new JButton("Manager");
		bottone_Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startManager();
			}
		});
		bottone_Manager.setBounds(338, 205, 130, 50);
		bottone_Manager.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pannello_Principale.add(bottone_Manager);
		
		JButton bottone_Statistiche = new JButton("Statistiche");
		bottone_Statistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startStatistiche(true, true);
			}
		});
		bottone_Statistiche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Statistiche.setBounds(572, 205, 130, 50);
		pannello_Principale.add(bottone_Statistiche);
		
		JButton bottone_Impostazioni = new JButton("Impostazioni");
		bottone_Impostazioni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Impostazioni.setBounds(806, 205, 130, 50);
		pannello_Principale.add(bottone_Impostazioni);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setBounds(0, 409, 1044, 52);
		pannello_Navigazione.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("Home");
		bottone_Home.setEnabled(false);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 89, 30);
		pannello_Navigazione.add(bottone_Home);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setEnabled(false);
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(109, 11, 89, 30);
		pannello_Navigazione.add(bottone_Indietro);
		
		JLabel etichetta_Orario = new JLabel("------");
		etichetta_Orario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Orario.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Orario.setBounds(412, 11, 220, 30);
		pannello_Navigazione.add(etichetta_Orario);
		
		JButton bottone_Logout = new JButton("Logout");
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startLogin();
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}
}
