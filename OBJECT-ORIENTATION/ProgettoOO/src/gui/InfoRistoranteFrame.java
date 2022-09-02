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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class InfoRistoranteFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private DefaultTableModel modelloTabella = new DefaultTableModel();
	private JScrollPane scrollPaneTabellaCamerieri;
	private JTable tabellaCamerieri;
	private JLabel etichettaNome;
	private JLabel etichettaIndirizzo;
	private JLabel etichettaCitta;
	private JLabel etichettaProvincia;
	private JLabel etichettaCap;
	private JLabel etichettaTelefono;
	private JLabel etichettaEmail;
	private JLabel etichettaSitoWeb;
	
	public InfoRistoranteFrame(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("TrackEaters - Informazioni Ristorante");
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
		
		JButton bottone_Indietro = new JButton("");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.mostraGestioneRistoranteFrame();
			}
		});
		bottone_Indietro.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnIndietro.png")));
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
		bottone_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.mostraGestioneRistoranteFrame();
			}
		});
		bottone_Home.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnHome.png")));
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		c.mostraDataEOra(lblDataEOra);
		
		etichettaNome = new JLabel("denominazione");
		etichettaNome.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/restaurantIcon.png")));
		etichettaNome.setForeground(new Color(0, 0, 127));
		etichettaNome.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaNome.setBounds(36, 91, 851, 30);
		pannello_Principale.add(etichettaNome);
		
		etichettaIndirizzo = new JLabel("indirizzo");
		etichettaIndirizzo.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/addressIcon.png")));
		etichettaIndirizzo.setForeground(new Color(0, 0, 127));
		etichettaIndirizzo.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaIndirizzo.setBounds(36, 131, 469, 30);
		pannello_Principale.add(etichettaIndirizzo);
		
		etichettaCitta = new JLabel("citta");
		etichettaCitta.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/cityIcon.png")));
		etichettaCitta.setForeground(new Color(0, 0, 127));
		etichettaCitta.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaCitta.setBounds(522, 131, 292, 30);
		pannello_Principale.add(etichettaCitta);
		
		etichettaProvincia = new JLabel("provincia");
		etichettaProvincia.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/cityIcon.png")));
		etichettaProvincia.setForeground(new Color(0, 0, 127));
		etichettaProvincia.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaProvincia.setBounds(839, 131, 200, 30);
		pannello_Principale.add(etichettaProvincia);
		
		etichettaCap = new JLabel("cap");
		etichettaCap.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/capIcon.png")));
		etichettaCap.setForeground(new Color(0, 0, 127));
		etichettaCap.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaCap.setBounds(1049, 131, 161, 30);
		pannello_Principale.add(etichettaCap);
		
		etichettaTelefono = new JLabel("telefono");
		etichettaTelefono.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/telephoneIcon.png")));
		etichettaTelefono.setForeground(new Color(0, 0, 127));
		etichettaTelefono.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaTelefono.setBounds(36, 171, 696, 30);
		pannello_Principale.add(etichettaTelefono);
		
		etichettaEmail = new JLabel("email");
		etichettaEmail.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/mailicon.png")));
		etichettaEmail.setForeground(new Color(0, 0, 127));
		etichettaEmail.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaEmail.setBounds(36, 211, 682, 30);
		pannello_Principale.add(etichettaEmail);
		
		etichettaSitoWeb = new JLabel("sitoweb");
		etichettaSitoWeb.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/websiteIcon.png")));
		etichettaSitoWeb.setForeground(new Color(0, 0, 127));
		etichettaSitoWeb.setFont(new Font("Segoe UI", Font.BOLD, 22));
		etichettaSitoWeb.setBounds(36, 251, 798, 30);
		pannello_Principale.add(etichettaSitoWeb);
		
		setTabellaCamerieri();

	}

	private void setTabellaCamerieri() {
		scrollPaneTabellaCamerieri = new JScrollPane();
		scrollPaneTabellaCamerieri.setViewportBorder(null);
		scrollPaneTabellaCamerieri.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTabellaCamerieri.setBounds(10, 336, 1244, 250);
		scrollPaneTabellaCamerieri.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaCamerieri);
		tabellaCamerieri = new JTable();
		tabellaCamerieri.setForeground(new Color(0, 0, 128));
		tabellaCamerieri.setBackground(Color.WHITE);
		tabellaCamerieri.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		modelloTabella.addColumn("N.CID");
		modelloTabella.addColumn("Nome");
		modelloTabella.addColumn("Cognome");
		modelloTabella.addColumn("Data nascita");
		modelloTabella.addColumn("Sesso");
		modelloTabella.addColumn("Citta' nascita");
		modelloTabella.addColumn("Prov. nascita");
		modelloTabella.addColumn("Citta' residenza");
		modelloTabella.addColumn("Prov. residenza");
		modelloTabella.addColumn("Telefono");
		modelloTabella.addColumn("Email");
		tabellaCamerieri.setModel(modelloTabella);
		tabellaCamerieri.getTableHeader().setAlignmentX(CENTER_ALIGNMENT);
		tabellaCamerieri.getTableHeader().setBackground(new Color(0, 0, 128));
		tabellaCamerieri.getTableHeader().setForeground(Color.WHITE);
		tabellaCamerieri.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		tabellaCamerieri.getTableHeader().setReorderingAllowed(false);
		tabellaCamerieri.setSelectionBackground(new Color(245, 245, 220));
		tabellaCamerieri.setRowHeight(30);
		tabellaCamerieri.setDefaultEditor(Object.class, null);
		tabellaCamerieri.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTabellaCamerieri.setViewportView(tabellaCamerieri);
		
		JLabel etichetta_InfoRistorante = new JLabel("");
		etichetta_InfoRistorante.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/InformazioniRistorante_Title.png")));
		etichetta_InfoRistorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_InfoRistorante.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_InfoRistorante.setBounds(387, 28, 490, 52);
		pannello_Principale.add(etichetta_InfoRistorante);
		
		JLabel etichetta_InfoRistorante_1 = new JLabel("");
		etichetta_InfoRistorante_1.setIcon(new ImageIcon(InfoRistoranteFrame.class.getResource("/resources/Camerieri_Title.png")));
		etichetta_InfoRistorante_1.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_InfoRistorante_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_InfoRistorante_1.setBounds(387, 280, 490, 52);
		pannello_Principale.add(etichetta_InfoRistorante_1);
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	
	public void setModel(DefaultTableModel model) {
		this.modelloTabella = model;
	}

	public DefaultTableModel getModel() {
		return modelloTabella;
	}
	
	public JTable getTabellaCamerieri() {
		return tabellaCamerieri;
	}

	public void setTabellaCamerieri(JTable tabellaCamerieri) {
		this.tabellaCamerieri = tabellaCamerieri;
	}
	
	
	public void setNome(String nomeRistorante) {
		etichettaNome.setText("Denominazione: "+ nomeRistorante);
	}
	
	public void setIndirizzo(String indirizzoRistorante) {
		etichettaIndirizzo.setText("Indirizzo: "+ indirizzoRistorante);
	}
	
	public void setCitta(String cittaRistorante) {
		etichettaCitta.setText("Citta\': "+ cittaRistorante);
	}
	
	public void setProvincia(String provinciaRistorante) {
		etichettaProvincia.setText("Provincia: "+ provinciaRistorante);
	}
	
	public void setCap(String capRistorante) {
		etichettaCap.setText("Cap: "+ capRistorante);
	}
	
	public void setTelefono(String telefonoRistorante) {
		etichettaTelefono.setText("Telefono: "+ telefonoRistorante);
	}
	
	public void setEmail(String emailRistorante) {
		etichettaEmail.setText("Email: "+ emailRistorante);
	}
	
	public void setSitoWeb(String sitoWebRistorante) {
		etichettaSitoWeb.setText("Sito Web: "+ sitoWebRistorante);
	}
}
