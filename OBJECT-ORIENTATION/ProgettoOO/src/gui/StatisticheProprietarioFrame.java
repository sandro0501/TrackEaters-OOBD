package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import controller.Controller;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;




public class StatisticheProprietarioFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private JDateChooser campo_DataIniziale;
	private JDateChooser campo_DataFinale;
	private JComboBox comboBox_Ristorante;
	private JComboBox comboBox_TipoStatistica;
	private JButton bottone_Conferma;
	private Image immagineStatistiche;
	private JLabel etichetta_TotaleAvventori;
	private JLabel etichetta_Interni;
	private JLabel etichetta_Esterni;
	private JLabel etichetta_Positivi;
	
	
	
	public StatisticheProprietarioFrame(Controller c) {
		
		theController = c;
		
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionePersonaleFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Statistiche");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Ristorante = new JLabel("Ristorante");
		etichetta_Ristorante.setForeground(new Color(0, 0, 128));
		etichetta_Ristorante.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Ristorante.setBounds(58, 105, 172, 27);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel etichetta_Statistica = new JLabel("Statistica");
		etichetta_Statistica.setForeground(new Color(0, 0, 128));
		etichetta_Statistica.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Statistica.setBounds(58, 198, 172, 27);
		pannello_Principale.add(etichetta_Statistica);
		
		JLabel etichetta_SelezionaDataIniziale = new JLabel("Seleziona data iniziale");
		etichetta_SelezionaDataIniziale.setForeground(new Color(0, 0, 128));
		etichetta_SelezionaDataIniziale.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_SelezionaDataIniziale.setBounds(58, 298, 200, 27);
		pannello_Principale.add(etichetta_SelezionaDataIniziale);
		
		JLabel etichetta_Statistiche = new JLabel("STATISTICHE");
		etichetta_Statistiche.setBounds(590, 36, 83, 14);
		pannello_Principale.add(etichetta_Statistiche);
		
		comboBox_TipoStatistica = new JComboBox();
		comboBox_TipoStatistica.setModel(new DefaultComboBoxModel(new String[] {"Testuale", "Grafica"}));
		comboBox_TipoStatistica.setBounds(57, 223, 200, 27);
		pannello_Principale.add(comboBox_TipoStatistica);
		
		comboBox_Ristorante = new JComboBox();
		ArrayList<String> ristoranti = new ArrayList<>();
		ristoranti.add("Tutti");
		ristoranti.addAll(c.riempiComboRistoranti());
		comboBox_Ristorante.setModel(new DefaultComboBoxModel<String>(ristoranti.toArray(new String[ristoranti.size()])));
		comboBox_Ristorante.setBounds(57, 130, 200, 27);
		pannello_Principale.add(comboBox_Ristorante);
		
		campo_DataIniziale = new JDateChooser();
		campo_DataIniziale.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_DataIniziale.setDateFormatString("dd/MM/yyyy");
		campo_DataIniziale.setBounds(57, 323, 200, 27);
		pannello_Principale.add(campo_DataIniziale);
		
		bottone_Conferma = new JButton("");
		bottone_Conferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
				String dataInizio = dateFormat.format(campo_DataIniziale.getDate());
				String dataFine = dateFormat.format(campo_DataFinale.getDate());
				if (comboBox_Ristorante.getSelectedItem().toString() == "Tutti") {
					if (comboBox_TipoStatistica.getSelectedItem().toString() == "Testuale") {
						
						c.statisticaPropretario(dataInizio, dataFine);
					}
				} else {
					if(comboBox_TipoStatistica.getSelectedItem().toString() == "Testuale") {
						
						c.statisticheRistorantiProprietario(dataInizio, dataFine, comboBox_Ristorante.getSelectedItem().toString());
					}
				}
			}
		});
		bottone_Conferma.setIcon(new ImageIcon(StatisticheProprietarioFrame.class.getResource("/resources/ConfermaBtn.png")));
		bottone_Conferma.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Conferma.setBounds(77, 505, 160, 60);
		pannello_Principale.add(bottone_Conferma);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setLayout(null);
		pannello_Navigazione.setForeground(new Color(0, 0, 128));
		pannello_Navigazione.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		pannello_Navigazione.setBackground(new Color(176, 196, 222));
		pannello_Navigazione.setBounds(0, 597, 1264, 84);
		pannello_Principale.add(pannello_Navigazione);
		
		JButton bottone_Indietro = new JButton("");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.mostraHomepageProprietarioFrame();
			}
		});
		bottone_Indietro.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnIndietro.png")));
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(191, 11, 160, 60);
		pannello_Navigazione.add(bottone_Indietro);
		
		JButton bottone_Logout = new JButton("");
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraLogoutDialog(c);
			}
		});
		bottone_Logout.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnLogout.png")));
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(1094, 11, 160, 60);
		pannello_Navigazione.add(bottone_Logout);
		
		JButton bottone_Home = new JButton("");
		bottone_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.mostraHomepageProprietarioFrame();
			}
		});
		bottone_Home.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnHome.png")));
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		c.mostraDataEOra(lblDataEOra);
		
		JLabel etichetta_SelezionaDataFinale = new JLabel("Seleziona data finale");
		etichetta_SelezionaDataFinale.setForeground(new Color(0, 0, 128));
		etichetta_SelezionaDataFinale.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_SelezionaDataFinale.setBounds(58, 398, 200, 27);
		pannello_Principale.add(etichetta_SelezionaDataFinale);
		
		campo_DataFinale = new JDateChooser();
		campo_DataFinale.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_DataFinale.setDateFormatString("dd/MM/yyyy");
		campo_DataFinale.setBounds(57, 423, 200, 27);
		pannello_Principale.add(campo_DataFinale);
		
		etichetta_TotaleAvventori = new JLabel("");
		etichetta_TotaleAvventori.setForeground(new Color(0, 0, 128));
		etichetta_TotaleAvventori.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_TotaleAvventori.setBounds(761, 136, 250, 27);
		pannello_Principale.add(etichetta_TotaleAvventori);
		
		etichetta_Interni = new JLabel("");
		etichetta_Interni.setForeground(new Color(0, 0, 128));
		etichetta_Interni.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Interni.setBounds(761, 229, 250, 27);
		pannello_Principale.add(etichetta_Interni);
		
		etichetta_Esterni = new JLabel("");
		etichetta_Esterni.setForeground(new Color(0, 0, 128));
		etichetta_Esterni.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Esterni.setBounds(761, 323, 250, 27);
		pannello_Principale.add(etichetta_Esterni);
		
		etichetta_Positivi = new JLabel("");
		etichetta_Positivi.setForeground(new Color(0, 0, 128));
		etichetta_Positivi.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Positivi.setBounds(761, 423, 250, 27);
		pannello_Principale.add(etichetta_Positivi);
		
		
		
		
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	

	public JDateChooser getCampo_DataIniziale() {
		return campo_DataIniziale;
	}

	public void setCampo_DataIniziale(JDateChooser campo_DataIniziale) {
		this.campo_DataIniziale = campo_DataIniziale;
	}

	public JComboBox getComboBox_Ristorante() {
		return comboBox_Ristorante;
	}

	public void setComboBox_Ristorante(JComboBox comboBox_Ristorante) {
		this.comboBox_Ristorante = comboBox_Ristorante;
	}

	public JComboBox getComboBox_TipoStatistica() {
		return comboBox_TipoStatistica;
	}

	public void setComboBox_TipoStatistica(JComboBox comboBox_TipoStatistica) {
		this.comboBox_TipoStatistica = comboBox_TipoStatistica;
	}

	public JButton getBottone_Conferma() {
		return bottone_Conferma;
	}

	public void setBottone_Conferma(JButton bottone_Conferma) {
		this.bottone_Conferma = bottone_Conferma;
	}

	public Image getImmagineStatistiche() {
		return immagineStatistiche;
	}

	public void setImmagineStatistiche(Image immagineStatistiche) {
		this.immagineStatistiche = immagineStatistiche;
	}

	public JLabel getEtichetta_TotaleAvventori() {
		return etichetta_TotaleAvventori;
	}

	public void setEtichetta_TotaleAvventori(JLabel etichetta_TotaleAvventori) {
		this.etichetta_TotaleAvventori = etichetta_TotaleAvventori;
	}

	public JLabel getEtichetta_Interni() {
		return etichetta_Interni;
	}

	public void setEtichetta_Interni(JLabel etichetta_Interni) {
		this.etichetta_Interni = etichetta_Interni;
	}

	public JLabel getEtichetta_Esterni() {
		return etichetta_Esterni;
	}

	public void setEtichetta_Esterni(JLabel etichetta_Esterni) {
		this.etichetta_Esterni = etichetta_Esterni;
	}

	public JLabel getEtichetta_Positivi() {
		return etichetta_Positivi;
	}

	public void setEtichetta_Positivi(JLabel etichetta_Positivi) {
		this.etichetta_Positivi = etichetta_Positivi;
	}
	
	
}
