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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class GestioneCasiCovidFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private DefaultTableModel modelloTabella = new DefaultTableModel();
	private JTable tabellaCasiCovid;
	private JScrollPane scrollPaneTabellaCasiCovid;
		
	public GestioneCasiCovidFrame(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("TrackEaters - Gestione casi COVID ristorante");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestioneCasiCovidFrame.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_GestioneCasiCovid = new JLabel("");
		etichetta_GestioneCasiCovid.setIcon(new ImageIcon(GestioneCasiCovidFrame.class.getResource("/resources/gestioneCasiCovidTitle.png")));
		etichetta_GestioneCasiCovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_GestioneCasiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_GestioneCasiCovid.setBounds(387, 28, 490, 52);
		pannello_Principale.add(etichetta_GestioneCasiCovid);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setForeground(new Color(0, 0, 128));
		pannello_Navigazione.setBackground(new Color(176, 196, 222));
		pannello_Navigazione.setBounds(0, 597, 1264, 84);
		pannello_Navigazione.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
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
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		c.mostraDataEOra(lblDataEOra);
		
		JButton bottone_TracciamentoCaso = new JButton("");
		bottone_TracciamentoCaso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabellaCasiCovid.getSelectedRow()!=-1) {
					setVisible(false);
					//c.startModificaCasoCovidFrame(proprietario);
					
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
			}
		});
		bottone_TracciamentoCaso.setIcon(new ImageIcon(GestioneCasiCovidFrame.class.getResource("/resources/btnTracciamento.png")));
		bottone_TracciamentoCaso.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_TracciamentoCaso.setBounds(124, 503, 160, 60);
		pannello_Principale.add(bottone_TracciamentoCaso);
		
		JButton bottone_Aggiungi = new JButton("");
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startAggiungiCasoCovidFrame(proprietario);
				c.riempiComboBoxAvventoriGestioneCasiCovid(proprietario);
			}
		});
		bottone_Aggiungi.setIcon(new ImageIcon(GestioneCasiCovidFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(408, 503, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("");
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (tabellaCasiCovid.getSelectedRow()!=-1) {
					setVisible(false);
					c.startModificaCasoCovidFrame(proprietario);
					c.riempiCampiModificaCasoPage(proprietario);
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
			}
		});
		bottone_Modifica.setIcon(new ImageIcon(GestioneCasiCovidFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(692, 503, 160, 60);
		pannello_Principale.add(bottone_Modifica);
		
		JLabel lblElimina = new JLabel("<html>Sei sicuro di voler eliminare il caso selezionato?<br/>Verranno cancellate tutte le informazioni ad esso collegate.</html>");
		lblElimina.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton bottone_Elimina = new JButton("");
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tabellaCasiCovid.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblElimina) == 0) {
						c.deleteCaso();
						c.mostraGestioneCasiCovidFrame(proprietario);
					}
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
			}
		});
		bottone_Elimina.setIcon(new ImageIcon(GestioneCasiCovidFrame.class.getResource("/resources/btnElimina.png")));
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(976, 503, 160, 60);
		pannello_Principale.add(bottone_Elimina);

		setTabellaCasiCovid();
	}
	
	private void setTabellaCasiCovid() {
		scrollPaneTabellaCasiCovid = new JScrollPane();
		scrollPaneTabellaCasiCovid.setViewportBorder(null);
		scrollPaneTabellaCasiCovid.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTabellaCasiCovid.setBounds(10, 119, 1244, 346);
		scrollPaneTabellaCasiCovid.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaCasiCovid);
		tabellaCasiCovid = new JTable();
		tabellaCasiCovid.setForeground(new Color(0, 0, 128));
		tabellaCasiCovid.setBackground(Color.WHITE);
		tabellaCasiCovid.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		modelloTabella.addColumn("Num.");
		modelloTabella.addColumn("Codice caso");
		modelloTabella.addColumn("Data registrazione");
		modelloTabella.addColumn("N.CID");
		modelloTabella.addColumn("Stato caso");
		modelloTabella.addColumn("Note");
		tabellaCasiCovid.setModel(modelloTabella);
		
		tabellaCasiCovid.getTableHeader().setAlignmentX(CENTER_ALIGNMENT);
		tabellaCasiCovid.getTableHeader().setBackground(new Color(0, 0, 128));
		tabellaCasiCovid.getTableHeader().setForeground(Color.WHITE);
		tabellaCasiCovid.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		tabellaCasiCovid.getTableHeader().setReorderingAllowed(false);
		tabellaCasiCovid.setSelectionBackground(new Color(245, 245, 220));
		tabellaCasiCovid.setRowHeight(30);
		tabellaCasiCovid.setDefaultEditor(Object.class, null);
		tabellaCasiCovid.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTabellaCasiCovid.setViewportView(tabellaCasiCovid);
		
	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	
	public DefaultTableModel getModel() {
		return modelloTabella;
	}
	
	public void setModel(DefaultTableModel model) {
		this.modelloTabella = model;
	}

	public JTable getTabellaCasiRistorante() {
		return tabellaCasiCovid;
	}
}