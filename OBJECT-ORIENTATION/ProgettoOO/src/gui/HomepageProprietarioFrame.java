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
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

import controller.Controller;
import javax.swing.ImageIcon;

public class HomepageProprietarioFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblNomeCognome;
	private JLabel lblUsername;
	private JLabel lblEmail;
	private JLabel lblDataEOra;
	
	
	public HomepageProprietarioFrame(Controller c) {
		
		theController = c;
				
		setResizable(false);
		setTitle("TrackEaters - Homepage Proprietario");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageProprietarioFrame.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_TracciamentoContattiCovid = new JLabel("");
		etichetta_TracciamentoContattiCovid.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/lblTracciamento.png")));
		etichetta_TracciamentoContattiCovid.setForeground(new Color(0, 0, 128));
		etichetta_TracciamentoContattiCovid.setBounds(260, 142, 744, 55);
		etichetta_TracciamentoContattiCovid.setFont(new Font("Segoe UI", Font.BOLD, 30));
		etichetta_TracciamentoContattiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		pannello_Principale.add(etichetta_TracciamentoContattiCovid);
		
		JButton bottone_IMieiRistoranti = new JButton("");
		bottone_IMieiRistoranti.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnIMieiRistoranti.png")));
		bottone_IMieiRistoranti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistorantiProprietarioFrame();
				
			}
		});
		bottone_IMieiRistoranti.setBounds(422, 224, 420, 60);
		bottone_IMieiRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pannello_Principale.add(bottone_IMieiRistoranti);
		
		JButton bottone_GestionePersonale = new JButton("");
		bottone_GestionePersonale.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnGestionePersonale.png")));
		bottone_GestionePersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startGestionePersonale();
				c.riempiTabllaCamerieriGestione();
				c.riempiTabllaManagerGestione();
			}
		});
		bottone_GestionePersonale.setBounds(422, 315, 420, 60);
		bottone_GestionePersonale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		pannello_Principale.add(bottone_GestionePersonale);
		
		JButton bottone_Statistiche = new JButton("");
		bottone_Statistiche.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnStatistiche.png")));
		bottone_Statistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startStatistiche(true, true);
			}
		});
		bottone_Statistiche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Statistiche.setBounds(422, 406, 420, 60);
		pannello_Principale.add(bottone_Statistiche);
		
		JButton bottone_Impostazioni = new JButton("");
		bottone_Impostazioni.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnImpostazioni.png")));
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
		
		JButton bottone_Indietro = new JButton("");
		bottone_Indietro.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnIndietro.png")));
		bottone_Indietro.setEnabled(false);
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(191, 11, 160, 60);
		pannello_Navigazione.add(bottone_Indietro);
		
		JButton bottone_Logout = new JButton("");
		bottone_Logout.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnLogout.png")));
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraLogoutDialog(c);
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(1094, 11, 160, 60);
		pannello_Navigazione.add(bottone_Logout);
		
		JButton bottone_Home = new JButton("");
		bottone_Home.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnHome.png")));
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setEnabled(false);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel lblBenvenuto = new JLabel("Benvenuto su TrackEaters,\r\n");
		lblBenvenuto.setForeground(new Color(0, 0, 128));
		lblBenvenuto.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		lblBenvenuto.setBounds(29, 26, 310, 40);
		pannello_Principale.add(lblBenvenuto);
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		c.mostraDataEOra(lblDataEOra);
		
		lblNomeCognome = new JLabel("");
		lblNomeCognome.setForeground(new Color(0, 0, 128));
		lblNomeCognome.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblNomeCognome.setBounds(29, 64, 338, 39);
		pannello_Principale.add(lblNomeCognome);
		
		lblUsername = new JLabel("");
		lblUsername.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/usericon.png")));
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblUsername.setBounds(980, 28, 274, 40);
		pannello_Principale.add(lblUsername);
		
		lblEmail = new JLabel("");
		lblEmail.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/mailicon.png")));
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 15));
		lblEmail.setBounds(980, 63, 274, 40);
		pannello_Principale.add(lblEmail);
		
		JLabel lblImageRestaurant = new JLabel("");
		lblImageRestaurant.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/restaurantImage.png")));
		lblImageRestaurant.setBounds(34, 224, 333, 333);
		pannello_Principale.add(lblImageRestaurant);
	}
	
	public void setLblNomeCognome(String nome, String cognome) {
		lblNomeCognome.setText(nome+" "+cognome);
	}
	
	public void setLblUsername(String username) {
		lblUsername.setText(username);
	}
	
	public void setLblEmail(String email) {
		lblEmail.setText(email);
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	
}
