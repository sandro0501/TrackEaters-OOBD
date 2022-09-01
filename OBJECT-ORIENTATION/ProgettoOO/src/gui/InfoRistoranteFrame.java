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
		
	public JTable getTabellaCamerieri() {
		return tabellaCamerieri;
	}

	public void setTabellaCamerieri(JTable tabellaCamerieri) {
		this.tabellaCamerieri = tabellaCamerieri;
	}
	
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
				c.mostraGestisciRistoranteFrame();
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
				c.mostraGestisciRistoranteFrame();
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
		this.mostraDataEOra();
		setTabellaRistoranti();

	}

	private void setTabellaRistoranti() {
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
		modelloTabella.addColumn("Documento");
		modelloTabella.addColumn("Nome");
		modelloTabella.addColumn("Cognome");
		modelloTabella.addColumn("Data nascita");
		modelloTabella.addColumn("Sesso");
		modelloTabella.addColumn("Città nascita");
		modelloTabella.addColumn("Provincia nascita");
		modelloTabella.addColumn("Città residenza");
		modelloTabella.addColumn("Provincia residenza");
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
		
		JLabel etichettaNome = new JLabel("Nome: ");
		etichettaNome.setForeground(new Color(0, 0, 127));
		etichettaNome.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaNome.setBounds(36, 69, 270, 30);
		pannello_Principale.add(etichettaNome);
		
		JLabel etichettaIndirizzo = new JLabel("Indirizzo:");
		etichettaIndirizzo.setForeground(new Color(0, 0, 127));
		etichettaIndirizzo.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaIndirizzo.setBounds(36, 135, 317, 30);
		pannello_Principale.add(etichettaIndirizzo);
		
		JLabel etichettaCittà = new JLabel("Città:");
		etichettaCittà.setForeground(new Color(0, 0, 127));
		etichettaCittà.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaCittà.setBounds(394, 135, 304, 30);
		pannello_Principale.add(etichettaCittà);
		
		JLabel etichettaProvincia = new JLabel("Provincia:");
		etichettaProvincia.setForeground(new Color(0, 0, 127));
		etichettaProvincia.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaProvincia.setBounds(748, 135, 297, 30);
		pannello_Principale.add(etichettaProvincia);
		
		JLabel etichettaCap = new JLabel("Cap:");
		etichettaCap.setForeground(new Color(0, 0, 127));
		etichettaCap.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaCap.setBounds(1083, 135, 155, 30);
		pannello_Principale.add(etichettaCap);
		
		JLabel etichettaTelefono = new JLabel("Telefono:");
		etichettaTelefono.setForeground(new Color(0, 0, 127));
		etichettaTelefono.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaTelefono.setBounds(36, 205, 304, 30);
		pannello_Principale.add(etichettaTelefono);
		
		JLabel etichettaEmail = new JLabel("Email:");
		etichettaEmail.setForeground(new Color(0, 0, 127));
		etichettaEmail.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaEmail.setBounds(394, 205, 304, 30);
		pannello_Principale.add(etichettaEmail);
		
		JLabel etichettaSitoWeb = new JLabel("Sito Web");
		etichettaSitoWeb.setForeground(new Color(0, 0, 127));
		etichettaSitoWeb.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichettaSitoWeb.setBounds(748, 205, 371, 30);
		pannello_Principale.add(etichettaSitoWeb);
		
		JLabel etichettaCamerieri = new JLabel("Camerieri");
		etichettaCamerieri.setHorizontalAlignment(SwingConstants.CENTER);
		etichettaCamerieri.setBounds(497, 295, 270, 30);
		pannello_Principale.add(etichettaCamerieri);
	}
	
	public void setModel(DefaultTableModel model) {
		this.modelloTabella = model;
	}

	public DefaultTableModel getModel() {
		return modelloTabella;
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
