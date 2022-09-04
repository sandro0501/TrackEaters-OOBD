package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import java.awt.Toolkit;
import controller.Controller;
import dto.Ristorante;
import oracledaoimplementation.RistoranteOracleImplementation;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class RistorantiProprietarioFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private DefaultTableModel modelloTabella = new DefaultTableModel();
	private JTable tabellaRistoranti;
	private JScrollPane scrollPaneTabellaRistoranti;

	public RistorantiProprietarioFrame(Controller c) {
		
		theController=c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RistorantiProprietarioFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - I miei ristoranti");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_IMieiRistoranti = new JLabel("");
		etichetta_IMieiRistoranti.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/lblIMieiRistoranti.png")));
		etichetta_IMieiRistoranti.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_IMieiRistoranti.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_IMieiRistoranti.setBounds(387, 28, 490, 52);
		pannello_Principale.add(etichetta_IMieiRistoranti);
		
		JButton bottone_Gestisci = new JButton("");
		bottone_Gestisci.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnGestisci.png")));
		bottone_Gestisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tabellaRistoranti.getSelectedRow() != -1) {
					setVisible(false);
					c.startHomepageGestioneRistoranteFrame(true);
					c.setHomepageGestioneRistorante(true);
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
			
			}
		});
		bottone_Gestisci.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Gestisci.setBounds(124, 503, 160, 60);
		pannello_Principale.add(bottone_Gestisci);
		
		JButton bottone_Aggiungi = new JButton("");
		bottone_Aggiungi.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					c.startAggiungiRistoranteFrame();
			}
		});
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(408, 503, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("");
		bottone_Modifica.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tabellaRistoranti.getSelectedRow()!=-1) {
					setVisible(false);
					c.startModificaRistoranteFrame();
					c.riempiCampiModificaRistorantePage();
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
				
			}
		});
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(692, 503, 160, 60);
		pannello_Principale.add(bottone_Modifica);
		
		JLabel lblElimina = new JLabel("<html>Sei sicuro di voler eliminare il ristorante selezionato?<br/>Verranno cancellate tutte le informazioni ad esso collegate.</html>");
		lblElimina.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton bottone_Elimina = new JButton("");
		bottone_Elimina.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnElimina.png")));
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tabellaRistoranti.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblElimina) == 0) {
						c.deleteRistorante(	tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 0).toString(), 	//denominazione 
										 	tabellaRistoranti.getModel().getValueAt(tabellaRistoranti.getSelectedRow(), 1).toString());	//indirizzo
					}
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
			}
		});
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(976, 503, 160, 60);
		pannello_Principale.add(bottone_Elimina);
		
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
		
		JLabel lblUsername = new JLabel("");
		lblUsername.setForeground(new Color(0, 0, 128));
		lblUsername.setFont(new Font("Segoe UI", Font.BOLD, 22));
		lblUsername.setBounds(10, 11, 274, 40);
		pannello_Principale.add(lblUsername);
		
		setTabellaRistoranti();

	}

	private void setTabellaRistoranti() {
		scrollPaneTabellaRistoranti = new JScrollPane();
		scrollPaneTabellaRistoranti.setViewportBorder(null);
		scrollPaneTabellaRistoranti.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTabellaRistoranti.setBounds(10, 119, 1244, 346);
		scrollPaneTabellaRistoranti.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaRistoranti);
		tabellaRistoranti = new JTable();
		tabellaRistoranti.setForeground(new Color(0, 0, 128));
		tabellaRistoranti.setBackground(Color.WHITE);
		tabellaRistoranti.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		modelloTabella.addColumn("Denominazione");
		modelloTabella.addColumn("Indirizzo");
		modelloTabella.addColumn("Telefono");
		modelloTabella.addColumn("Citta'");
		modelloTabella.addColumn("Provincia");
		modelloTabella.addColumn("CAP");
		modelloTabella.addColumn("Email");
		modelloTabella.addColumn("Sito Web");
		tabellaRistoranti.setModel(modelloTabella);
		tabellaRistoranti.getTableHeader().setAlignmentX(CENTER_ALIGNMENT);
		tabellaRistoranti.getTableHeader().setBackground(new Color(0, 0, 128));
		tabellaRistoranti.getTableHeader().setForeground(Color.WHITE);
		tabellaRistoranti.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		tabellaRistoranti.getTableHeader().setReorderingAllowed(false);
		tabellaRistoranti.setSelectionBackground(new Color(245, 245, 220));
		tabellaRistoranti.setRowHeight(30);
		tabellaRistoranti.setDefaultEditor(Object.class, null);
		tabellaRistoranti.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTabellaRistoranti.setViewportView(tabellaRistoranti);
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	
	public JTable getTabellaRistoranti() {
		return tabellaRistoranti;
	}

	public void setTabellaRistoranti(JTable tabellaRistoranti) {
		this.tabellaRistoranti = tabellaRistoranti;
	}
	
	public DefaultTableModel getModel() {
		return modelloTabella;
	}
	
	public void setModel(DefaultTableModel model) {
		this.modelloTabella = model;
	}
}
