package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controller;

public class GestionePersonaleFrame extends JFrame {
	
	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private JLabel etichetta_ristorante;
	private JTable tabellaCamerieri;
	private JTable tabellaManager;
	private JScrollPane scrollPaneTabellaCamerieri;
	private JScrollPane scrollPaneTabellaManager;
	private DefaultTableModel modelloTabellaCamerieri = new DefaultTableModel();
	private DefaultTableModel modelloTabellaManager = new DefaultTableModel();
	


	public GestionePersonaleFrame(Controller c) {
		
		theController = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionePersonaleFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Gestione personale");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		etichetta_ristorante = new JLabel("");
		etichetta_ristorante.setIcon(new ImageIcon(GestionePersonaleFrame.class.getResource("/resources/Camerieri_Title.png")));
		etichetta_ristorante.setForeground(new Color(0, 0, 127));
		etichetta_ristorante.setFont(new Font("Segoe UI", Font.ITALIC, 27));
		etichetta_ristorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_ristorante.setBounds(41, 11, 1170, 40);
		pannello_Principale.add(etichetta_ristorante);
		
		
		JButton bottone_Aggiungi = new JButton("");
		bottone_Aggiungi.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabellaCamerieri.getSelectedRow()!=-1) {
					setVisible(false);
					c.startAggiungiCameriereFrame(true);
				} else if(tabellaManager.getSelectedRow()!=-1) {
					setVisible(false);
					c.startAggiungiManagerFrame();
				} else {
					c.mostraErroreSelezionePersonale(pannello_Principale);
				}
				
			}
		});
		
		JLabel etichetta_Manager = new JLabel("");
		etichetta_Manager.setIcon(new ImageIcon(GestionePersonaleFrame.class.getResource("/resources/managersTitle.png")));
		etichetta_Manager.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Manager.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Manager.setBounds(387, 255, 490, 40);
		pannello_Principale.add(etichetta_Manager);
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(196, 503, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("");
		bottone_Modifica.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabellaCamerieri.getSelectedRow()!=-1) {
					setVisible(false);
					c.startModificaCameriereFrame(true);
				} else if(tabellaManager.getSelectedRow()!=-1) {
					setVisible(false);
					c.startModificaManagerFrame();
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
			}
		});
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(552, 503, 160, 60);
		pannello_Principale.add(bottone_Modifica);
		
		JLabel lblElimina = new JLabel("<html>Sei sicuro di voler eliminare il lavoratore selezionato?<br/>Verranno cancellate tutte le informazioni ad esso collegate.</html>");
		lblElimina.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton bottone_Elimina = new JButton("");
		bottone_Elimina.setIcon(new ImageIcon(RistorantiProprietarioFrame.class.getResource("/resources/btnElimina.png")));
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(tabellaCamerieri.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblElimina) == 0){
						c.eliminaCameriere(tabellaCamerieri.getModel().getValueAt(tabellaCamerieri.getSelectedRow(), 0).toString());
						c.mostraGestionePersonaleFrame();
						c.riempiTabellaCamerieriPerGestionePersonale();
						c.riempiTabellaManagerRistorantePerGestionePersonale(); 
					}
				} else if(tabellaManager.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblElimina) == 0){
						c.eliminaManager(tabellaManager.getModel().getValueAt(tabellaManager.getSelectedRow(), 0).toString());
						c.mostraGestionePersonaleFrame();
						c.riempiTabellaCamerieriPerGestionePersonale();
						c.riempiTabellaManagerRistorantePerGestionePersonale();
					}
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
			}
		});
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(908, 503, 160, 60);
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
		
		setTabellaCamerieri();
		setTabellaManager();
		
	}
	
	private void setTabellaCamerieri() {
		scrollPaneTabellaCamerieri = new JScrollPane();
		scrollPaneTabellaCamerieri.setViewportBorder(null);
		scrollPaneTabellaCamerieri.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPaneTabellaCamerieri.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
		scrollPaneTabellaCamerieri.setBounds(10, 56, 1244, 188);
		scrollPaneTabellaCamerieri.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaCamerieri);
		tabellaCamerieri = new JTable();
		tabellaCamerieri.setForeground(new Color(0, 0, 128));
		tabellaCamerieri.setBackground(Color.WHITE);
		tabellaCamerieri.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		tabellaCamerieri.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		modelloTabellaCamerieri.addColumn("N.CID");
		modelloTabellaCamerieri.addColumn("Nome");
		modelloTabellaCamerieri.addColumn("Cognome");
		modelloTabellaCamerieri.addColumn("Data di nascita");
		modelloTabellaCamerieri.addColumn("Sesso");
		modelloTabellaCamerieri.addColumn("Citta' nascita");
		modelloTabellaCamerieri.addColumn("Provincia nascita");
		modelloTabellaCamerieri.addColumn("Citta' residenza");
		modelloTabellaCamerieri.addColumn("Provincia residenza");
		modelloTabellaCamerieri.addColumn("Telefono");
		modelloTabellaCamerieri.addColumn("Email");
		modelloTabellaCamerieri.addColumn("Ristorante");
		tabellaCamerieri.setModel(modelloTabellaCamerieri);
		
		
		tabellaCamerieri.getColumnModel().getColumn(0).setPreferredWidth(100);
		tabellaCamerieri.getColumnModel().getColumn(1).setPreferredWidth(100);
		tabellaCamerieri.getColumnModel().getColumn(2).setPreferredWidth(100);
		tabellaCamerieri.getColumnModel().getColumn(3).setPreferredWidth(150);
		tabellaCamerieri.getColumnModel().getColumn(4).setPreferredWidth(100);
		tabellaCamerieri.getColumnModel().getColumn(5).setPreferredWidth(150);
		tabellaCamerieri.getColumnModel().getColumn(6).setPreferredWidth(50);
		tabellaCamerieri.getColumnModel().getColumn(7).setPreferredWidth(150);
		tabellaCamerieri.getColumnModel().getColumn(8).setPreferredWidth(50);
		tabellaCamerieri.getColumnModel().getColumn(9).setPreferredWidth(150);
		tabellaCamerieri.getColumnModel().getColumn(10).setPreferredWidth(200);
		tabellaCamerieri.getColumnModel().getColumn(11).setPreferredWidth(150);

		
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
		
	}
	
	private void setTabellaManager() {
		scrollPaneTabellaManager = new JScrollPane();
		scrollPaneTabellaManager.setViewportBorder(null);
		scrollPaneTabellaManager.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTabellaManager.setBounds(10, 298, 1244, 180);
		scrollPaneTabellaManager.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaManager);
		tabellaManager = new JTable();
		tabellaManager.setForeground(new Color(0, 0, 128));
		tabellaManager.setBackground(Color.WHITE);
		tabellaManager.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		modelloTabellaManager.addColumn("Username");
		modelloTabellaManager.addColumn("Nome");
		modelloTabellaManager.addColumn("Cognome");
		modelloTabellaManager.addColumn("Email");
		modelloTabellaManager.addColumn("Telefono");
		modelloTabellaManager.addColumn("Ristorante");
		tabellaManager.setModel(modelloTabellaManager);
		tabellaManager.getTableHeader().setAlignmentX(CENTER_ALIGNMENT);
		tabellaManager.getTableHeader().setBackground(new Color(0, 0, 128));
		tabellaManager.getTableHeader().setForeground(Color.WHITE);
		tabellaManager.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		tabellaManager.getTableHeader().setReorderingAllowed(false);
		tabellaManager.setSelectionBackground(new Color(245, 245, 220));
		tabellaManager.setRowHeight(30);
		tabellaManager.setDefaultEditor(Object.class, null);
		tabellaManager.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabellaManager.setColumnSelectionAllowed(true);
		scrollPaneTabellaManager.setViewportView(tabellaManager);
	}
	
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}
	
	public JTable getTabellaCamerieri() {
		return tabellaCamerieri;
	}

	public void setTabellaCamerieri(JTable tabellaCamerieri) {
		this.tabellaCamerieri = tabellaCamerieri;
	}
	
	public JTable getTabellaManager() {
		return tabellaManager;
	}

	public void setTabellaManager(JTable tabellaManager) {
		this.tabellaManager = tabellaManager;
	}
	
	public DefaultTableModel getModelCamerieri() {
		return modelloTabellaCamerieri;
	}
	
	public void setModelCamerieri(DefaultTableModel model) {
		this.modelloTabellaCamerieri = model;
	}
	
	public DefaultTableModel getModelManager() {
		return modelloTabellaManager;
	}
	
	public void setModelManager(DefaultTableModel model) {
		this.modelloTabellaManager = model;
	}

	
}

