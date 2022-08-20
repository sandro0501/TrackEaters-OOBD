package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import controller.Controller;

public class Homepage_Ristorante extends JFrame {

	private JPanel pannello_Principale;	
	private Controller theController;
		
	public Homepage_Ristorante(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage_Ristorante.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JTextPane testo_ManagerNomeCognome = new JTextPane();
		testo_ManagerNomeCognome.setEditable(false);
		testo_ManagerNomeCognome.setBackground(SystemColor.control);
		testo_ManagerNomeCognome.setFont(new Font("Tahoma", Font.BOLD, 12));
		testo_ManagerNomeCognome.setText("Manager: \"Nome\" \"Cognome\"\r\n\"Telefono\"\r\n\"Email\"");
		testo_ManagerNomeCognome.setBounds(10, 11, 236, 72);
		pannello_Principale.add(testo_ManagerNomeCognome);
		
		JLabel etichetta_Ristorante = new JLabel("RISTORANTE: \"Denominazione\"");
		etichetta_Ristorante.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Ristorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Ristorante.setBounds(325, 35, 393, 20);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel etichetta_TracciamentoCasiCovid = new JLabel("TRACCIAMENTO CONTATTI COVID-19");
		etichetta_TracciamentoCasiCovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_TracciamentoCasiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_TracciamentoCasiCovid.setBounds(278, 66, 490, 52);
		pannello_Principale.add(etichetta_TracciamentoCasiCovid);
		
		JButton bottone_InformazioniRistoranti = new JButton("Informazioni \r\nRistorante");
		bottone_InformazioniRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_InformazioniRistoranti.setBounds(133, 205, 170, 50);
		pannello_Principale.add(bottone_InformazioniRistoranti);
		
		JButton bottone_Sale = new JButton("Sale");
		bottone_Sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startSale(proprietario);
			}
		});
		bottone_Sale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Sale.setBounds(436, 205, 170, 50);
		pannello_Principale.add(bottone_Sale);
		
		JButton bottone_Camerieri = new JButton("Camerieri");
		bottone_Camerieri.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startCamerieri(proprietario);
			}
		});
		bottone_Camerieri.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Camerieri.setBounds(739, 205, 170, 50);
		pannello_Principale.add(bottone_Camerieri);
		
		JButton bottone_Statistiche = new JButton("Statistiche ");
		bottone_Statistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startStatistiche(proprietario, false);
			}
		});
		bottone_Statistiche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Statistiche.setBounds(234, 314, 170, 50);
		pannello_Principale.add(bottone_Statistiche);
		
		JButton bottone_Casi = new JButton("Casi");
		bottone_Casi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startCasi(proprietario);
			}
		});
		bottone_Casi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Casi.setBounds(638, 314, 170, 50);
		pannello_Principale.add(bottone_Casi);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannello_Navigazione.setBounds(0, 409, 1044, 52);
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("Home");
		bottone_Home.addActionListener(new ActionListener( ) {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startHomepageProprietario();
			}
		});
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 89, 30);
		pannello_Navigazione.add(bottone_Home);
		if (!proprietario) {
			bottone_Home.setEnabled(false);
		}
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistorantiProprietario();
			}
		});
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(109, 11, 89, 30);
		pannello_Navigazione.add(bottone_Indietro);
		if (!proprietario) {
			bottone_Indietro.setEnabled(false);
		}
		
		JLabel etichetta_Orario = new JLabel("\"Data & Ora\"");
		etichetta_Orario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Orario.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Orario.setBounds(412, 11, 220, 30);
		pannello_Navigazione.add(etichetta_Orario);
		
		JButton bottone_Logout = new JButton("Logout");
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler uscire?")==0) {
					setVisible(false);
					c.startLogin();
				}
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}
}
