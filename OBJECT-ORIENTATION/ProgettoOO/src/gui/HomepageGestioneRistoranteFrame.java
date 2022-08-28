package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
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

public class HomepageGestioneRistoranteFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDenominazioneRistorante;
	private JLabel lblDataEOra;
		
	public HomepageGestioneRistoranteFrame(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("TrackEaters - Homepage Ristorante");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageProprietarioFrame.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setForeground(new Color(0, 0, 128));
		pannello_Navigazione.setBackground(new Color(176, 196, 222));
		pannello_Navigazione.setBounds(0, 597, 1264, 84);
		pannello_Navigazione.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JLabel etichetta_TracciamentoContattiCovid = new JLabel("");
		etichetta_TracciamentoContattiCovid.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/lblTracciamento.png")));
		etichetta_TracciamentoContattiCovid.setForeground(new Color(0, 0, 128));
		etichetta_TracciamentoContattiCovid.setBounds(260, 142, 744, 55);
		etichetta_TracciamentoContattiCovid.setFont(new Font("Segoe UI", Font.BOLD, 30));
		etichetta_TracciamentoContattiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		pannello_Principale.add(etichetta_TracciamentoContattiCovid);
		
		JButton bottone_Indietro = new JButton("");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistorantiProprietario();
			}
		});
		bottone_Indietro.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnIndietro.png")));
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(191, 11, 160, 60);
		pannello_Navigazione.add(bottone_Indietro);
		if(!proprietario) {
			bottone_Indietro.setEnabled(false); 
		}
		
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
		bottone_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startHomepageProprietario();
			}
		});
		bottone_Home.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnHome.png")));
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		if(!proprietario) {
			bottone_Home.setEnabled(false); 
		}
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		this.mostraDataEOra();
		
		lblDenominazioneRistorante = new JLabel("");
		lblDenominazioneRistorante.setIcon(new ImageIcon(HomepageGestioneRistoranteFrame.class.getResource("/resources/restaurantIcon.png")));
		lblDenominazioneRistorante.setForeground(new Color(0, 0, 128));
		lblDenominazioneRistorante.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 27));
		lblDenominazioneRistorante.setHorizontalAlignment(SwingConstants.LEFT);
		lblDenominazioneRistorante.setBounds(26, 22, 782, 62);
		pannello_Principale.add(lblDenominazioneRistorante);
		
		JButton bottone_InformazioniRistoranti = new JButton("");
		bottone_InformazioniRistoranti.setIcon(new ImageIcon(HomepageGestioneRistoranteFrame.class.getResource("/resources/btnInformazioniRistorante.png")));
		bottone_InformazioniRistoranti.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_InformazioniRistoranti.setBounds(422, 224, 420, 60);
		pannello_Principale.add(bottone_InformazioniRistoranti);
		
		JButton bottone_Sale = new JButton("");
		bottone_Sale.setIcon(new ImageIcon(HomepageGestioneRistoranteFrame.class.getResource("/resources/btnGestioneSaleTavolate.png")));
		bottone_Sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startSale(proprietario);
			}
		});
		bottone_Sale.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Sale.setBounds(422, 315, 420, 60);
		pannello_Principale.add(bottone_Sale);
		
		JButton bottone_Statistiche = new JButton("");
		bottone_Statistiche.setIcon(new ImageIcon(HomepageGestioneRistoranteFrame.class.getResource("/resources/btnStatistiche.png")));
		bottone_Statistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startStatistiche(proprietario, false);
			}
		});
		bottone_Statistiche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Statistiche.setBounds(422, 497, 420, 60);
		pannello_Principale.add(bottone_Statistiche);
		
		JButton bottone_Casi = new JButton("");
		bottone_Casi.setIcon(new ImageIcon(HomepageGestioneRistoranteFrame.class.getResource("/resources/btnGestioneCasiCovid.png")));
		bottone_Casi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startCasi(proprietario);
			}
		});
		bottone_Casi.setFont(new Font("Tahoma", Font.PLAIN, 11));
		bottone_Casi.setBounds(422, 406, 420, 60);
		pannello_Principale.add(bottone_Casi);
		
		JLabel lblNewLabel = new JLabel("Info Manager");
		lblNewLabel.setBounds(1050, 30, 140, 28);
		pannello_Principale.add(lblNewLabel);
		
		JLabel lblImageRestaurant = new JLabel("");
		lblImageRestaurant.setBounds(34, 224, 333, 333);
		pannello_Principale.add(lblImageRestaurant);
		
	}
	
	public void setLblDenominazioneRistorante(String denominazione) {
		lblDenominazioneRistorante.setText(denominazione);
	}
	
	public void mostraDataEOra() {
		Thread clock = new Thread() {
			public void run() {
				try {
					for(;;) {
						Calendar cal = new GregorianCalendar();
						int giorno = cal.get(Calendar.DAY_OF_MONTH);
						int mese = cal.get(Calendar.MONTH)+1;
						int anno = cal.get(Calendar.YEAR);
						int seconds = cal.get(Calendar.SECOND);
						int minutes = cal.get(Calendar.MINUTE);
						int hour = cal.get(Calendar.HOUR_OF_DAY);
						String minuti = String.format("%02d", minutes);
						String secondi = String.format("%02d", seconds);
						String ore = String.format("%02d", hour);
						
						lblDataEOra.setText(giorno+"/"+mese+"/"+anno+" - "+ore+":"+minuti+":"+secondi);
						sleep(1000);
					}
				} catch (InterruptedException e) {
					
				}
			}
		};
		clock.start();
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLogin();
		}
	}
}
