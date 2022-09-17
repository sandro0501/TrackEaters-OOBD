package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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

public class GestioneAvventoriFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private DefaultTableModel modelloTabella = new DefaultTableModel();
	private JTable tabellaAvventoriRistorante;
	private JScrollPane scrollPaneTabellaAvventoriRistorante;
		
	public GestioneAvventoriFrame(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("TrackEaters - Gestione Sale e Tavolate - Avventori partecipanti alla tavolata");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageProprietarioFrame.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Avventori = new JLabel("");
		etichetta_Avventori.setIcon(new ImageIcon(GestioneAvventoriFrame.class.getResource("/resources/avventoriTitle.png")));
		etichetta_Avventori.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Avventori.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Avventori.setBounds(244, 28, 776, 52);
		pannello_Principale.add(etichetta_Avventori);
		
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
				c.mostraGestioneTavolateFrame();
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

		JLabel lblCaso = new JLabel("Sei sicuro di voler segnalare l'avventore selezionato come nuovo caso COVID?");
		lblCaso.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton bottone_InserisciCasoPositivo = new JButton("");
		bottone_InserisciCasoPositivo.setIcon(new ImageIcon(GestioneAvventoriFrame.class.getResource("/resources/btnCasoCovid.png")));
		bottone_InserisciCasoPositivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabellaAvventoriRistorante.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblCaso) == 0) {
						String numCid = tabellaAvventoriRistorante.getModel().getValueAt(tabellaAvventoriRistorante.getSelectedRow(), 0).toString();
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						Date dataRegistrazione = new Date();
						String dataformattata = dateFormat.format(dataRegistrazione);
						
						c.insertCasoCovid(dataformattata, numCid, "NonRisolto", "");	
					}
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
			}
		});
		bottone_InserisciCasoPositivo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_InserisciCasoPositivo.setBounds(124, 503, 160, 60);
		pannello_Principale.add(bottone_InserisciCasoPositivo);
		
		JButton bottone_Aggiungi = new JButton("");
		bottone_Aggiungi.setIcon(new ImageIcon(GestioneSaleETavolateFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					setVisible(false);
					c.startAggiungiAvventoreFrame(proprietario);
			}
		});
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(408, 503, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
	
		
		JButton bottone_Modifica = new JButton("");
		bottone_Modifica.setIcon(new ImageIcon(GestioneSaleETavolateFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (tabellaAvventoriRistorante.getSelectedRow()!=-1) {
					setVisible(false);
					c.startModificaAvventoreFrame(proprietario);
					c.riempiCampiModificaAvventorePage();
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
				
			}
		});
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(692, 503, 160, 60);
		pannello_Principale.add(bottone_Modifica);
	
		
		JLabel lblElimina = new JLabel("<html>Sei sicuro di voler eliminare l'avventore dalla tavolata?<br/>Verranno cancellate tutte le informazioni ad esso collegate.</html>");
		lblElimina.setFont(new Font("Segoe UI", Font.BOLD, 15));
		JButton bottone_Elimina = new JButton("");
		bottone_Elimina.setIcon(new ImageIcon(GestioneSaleETavolateFrame.class.getResource("/resources/btnElimina.png")));
		bottone_Elimina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				if (tabellaAvventoriRistorante.getSelectedRow()!=-1) {
					if(JOptionPane.showConfirmDialog(pannello_Principale,lblElimina) == 0) {
						
						c.deleteAvventoreFromTavolata();
					}
				} else {
					c.mostraErroreSelezioneDialog(pannello_Principale);
				}
				
			}
		});
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(976, 503, 160, 60);
		pannello_Principale.add(bottone_Elimina);
		
		
		setTabellaAvventoriRistorante();
	}
	
	private void setTabellaAvventoriRistorante() {
		scrollPaneTabellaAvventoriRistorante = new JScrollPane();
		scrollPaneTabellaAvventoriRistorante.setViewportBorder(null);
		scrollPaneTabellaAvventoriRistorante.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPaneTabellaAvventoriRistorante.setBounds(10, 119, 1244, 346);
		scrollPaneTabellaAvventoriRistorante.getViewport().setBackground(new Color(176, 196, 222));
		pannello_Principale.add(scrollPaneTabellaAvventoriRistorante);
		tabellaAvventoriRistorante = new JTable();
		tabellaAvventoriRistorante.setForeground(new Color(0, 0, 128));
		tabellaAvventoriRistorante.setBackground(Color.WHITE);
		tabellaAvventoriRistorante.setFont(new Font("Segoe UI", Font.PLAIN, 15));
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
		modelloTabella.addColumn("Temperatura");
		modelloTabella.addColumn("Greenpass");
		tabellaAvventoriRistorante.setModel(modelloTabella);
		tabellaAvventoriRistorante.getTableHeader().setAlignmentX(CENTER_ALIGNMENT);
		tabellaAvventoriRistorante.getTableHeader().setBackground(new Color(0, 0, 128));
		tabellaAvventoriRistorante.getTableHeader().setForeground(Color.WHITE);
		tabellaAvventoriRistorante.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 15));
		tabellaAvventoriRistorante.getTableHeader().setReorderingAllowed(false);
		tabellaAvventoriRistorante.setSelectionBackground(new Color(245, 245, 220));
		tabellaAvventoriRistorante.setRowHeight(30);
		tabellaAvventoriRistorante.setDefaultEditor(Object.class, null);
		tabellaAvventoriRistorante.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTabellaAvventoriRistorante.setViewportView(tabellaAvventoriRistorante);
		
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

	public JTable getTabellaAvventoriRistorante() {
		return tabellaAvventoriRistorante;
	}
}