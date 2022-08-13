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
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

import controller.Controller;
import javax.swing.ImageIcon;

public class Homepage_Proprietario extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	
	public Homepage_Proprietario(Controller c) {
		
		theController = c;
				
		setResizable(false);
		setTitle("TrackEaters - Homepage Proprietario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage_Proprietario.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_TracciamentoContattiCovid = new JLabel("");
		etichetta_TracciamentoContattiCovid.setIcon(new ImageIcon(Homepage_Proprietario.class.getResource("/resources/lblTracciamento.png")));
		etichetta_TracciamentoContattiCovid.setForeground(new Color(0, 0, 128));
		etichetta_TracciamentoContattiCovid.setBounds(260, 142, 744, 55);
		etichetta_TracciamentoContattiCovid.setFont(new Font("Segoe UI", Font.BOLD, 30));
		etichetta_TracciamentoContattiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		pannello_Principale.add(etichetta_TracciamentoContattiCovid);
		
		JButton bottone_IMieiRistoranti = new JButton("I miei ristoranti");
		bottone_IMieiRistoranti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistoranti();
				
			}
		});
		bottone_IMieiRistoranti.setBounds(422, 224, 420, 60);
		bottone_IMieiRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pannello_Principale.add(bottone_IMieiRistoranti);
		
		JButton bottone_Manager = new JButton("Manager");
		bottone_Manager.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startManager();
			}
		});
		bottone_Manager.setBounds(422, 315, 420, 60);
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
		bottone_Statistiche.setBounds(422, 406, 420, 60);
		pannello_Principale.add(bottone_Statistiche);
		
		JButton bottone_Impostazioni = new JButton("Impostazioni");
		bottone_Impostazioni.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startImpostazioni();
			}
		});
		
		bottone_Impostazioni.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Impostazioni.setBounds(422, 497, 420, 60);
		pannello_Principale.add(bottone_Impostazioni);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setForeground(new Color(0, 0, 128));
		pannello_Navigazione.setBackground(new Color(176, 196, 222));
		pannello_Navigazione.setBounds(0, 597, 1264, 84);
		pannello_Navigazione.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setEnabled(false);
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(191, 11, 160, 60);
		pannello_Navigazione.add(bottone_Indietro);
		
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
		bottone_Logout.setBounds(1094, 11, 160, 60);
		pannello_Navigazione.add(bottone_Logout);
		
		JButton bottone_Home = new JButton("Home");
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setEnabled(false);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel etichetta_Orario = new JLabel("------");
		etichetta_Orario.setBounds(552, 26, 149, 30);
		pannello_Navigazione.add(etichetta_Orario);
		etichetta_Orario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Orario.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblBenvenuto = new JLabel("Benvenuto su TrackEaters,\r\n");
		lblBenvenuto.setForeground(new Color(0, 0, 128));
		lblBenvenuto.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		lblBenvenuto.setBounds(29, 26, 310, 40);
		pannello_Principale.add(lblBenvenuto);
		
		JLabel lblNomeCognome = new JLabel("Nome Cognome\r\n");
		lblNomeCognome.setForeground(new Color(0, 0, 128));
		lblNomeCognome.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNomeCognome.setBounds(29, 64, 338, 39);
		pannello_Principale.add(lblNomeCognome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setIcon(new ImageIcon(Homepage_Proprietario.class.getResource("/resources/usericon.png")));
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblUsername.setBounds(980, 28, 274, 40);
		pannello_Principale.add(lblUsername);
		
		JLabel lblNomeCognome_1_1 = new JLabel("mail@mail.it");
		lblNomeCognome_1_1.setIcon(new ImageIcon(Homepage_Proprietario.class.getResource("/resources/mailicon.png")));
		lblNomeCognome_1_1.setForeground(new Color(0, 0, 128));
		lblNomeCognome_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblNomeCognome_1_1.setBounds(980, 63, 274, 40);
		pannello_Principale.add(lblNomeCognome_1_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Homepage_Proprietario.class.getResource("/resources/restaurantImage.png")));
		lblNewLabel.setBounds(34, 224, 333, 333);
		pannello_Principale.add(lblNewLabel);
	}
}
