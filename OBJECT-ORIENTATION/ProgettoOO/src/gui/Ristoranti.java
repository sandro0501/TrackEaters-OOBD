package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JScrollBar;
import java.awt.Toolkit;
import controller.Controller;

public class Ristoranti extends JFrame {

	private JPanel pannello_Principale;
	private JTable tabella_Ristornati;
	private Controller theController;

	public Ristoranti(Controller c) {
		
		theController=c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ristoranti.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_NomeECognome = new JLabel("\"Nome\" \"Cognome\"");
		etichetta_NomeECognome.setFont(new Font("Tahoma", Font.PLAIN, 11));
		etichetta_NomeECognome.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_NomeECognome.setBounds(277, 18, 490, 20);
		pannello_Principale.add(etichetta_NomeECognome);
		
		JLabel etichetta_IMieiRistoranti = new JLabel("I MIEI RISTORANTI");
		etichetta_IMieiRistoranti.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_IMieiRistoranti.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_IMieiRistoranti.setBounds(277, 45, 490, 52);
		pannello_Principale.add(etichetta_IMieiRistoranti);
		
		tabella_Ristornati = new JTable();
		tabella_Ristornati.setColumnSelectionAllowed(true);
		tabella_Ristornati.setCellSelectionEnabled(true);
		tabella_Ristornati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabella_Ristornati.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Ristornati.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Denominazione", "Indirizzo", "Telefono", "Citt\u00E0", "Provincia", "CAP", "Email", "Sito Web"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, String.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tabella_Ristornati.getColumnModel().getColumn(0).setPreferredWidth(110);
		tabella_Ristornati.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabella_Ristornati.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabella_Ristornati.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabella_Ristornati.getColumnModel().getColumn(4).setPreferredWidth(65);
		tabella_Ristornati.getColumnModel().getColumn(5).setPreferredWidth(55);
		tabella_Ristornati.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabella_Ristornati.setBackground(Color.WHITE);
		tabella_Ristornati.setBounds(10, 124, 1007, 223);
		pannello_Principale.add(tabella_Ristornati);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 223);
		pannello_Principale.add(scrollBar);
		
		JButton bottone_Gestisci = new JButton("Gestisci");
		bottone_Gestisci.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startRistorante(true);
			}
		});
		bottone_Gestisci.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Gestisci.setBounds(120, 358, 110, 40);
		pannello_Principale.add(bottone_Gestisci);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(350, 358, 110, 40);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("Modifica");
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(580, 358, 110, 40);
		pannello_Principale.add(bottone_Modifica);
		
		JButton bottone_Elimina = new JButton("Elimina");
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(810, 358, 110, 40);
		pannello_Principale.add(bottone_Elimina);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setBounds(0, 409, 1044, 52);
		pannello_Navigazione.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("Home");
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 89, 30);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setEnabled(false);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startHomepage_Proprietario();
			}
		});
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(109, 11, 89, 30);
		pannello_Navigazione.add(bottone_Indietro);
		
		JLabel etichetta_Orario = new JLabel("------");
		etichetta_Orario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Orario.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Orario.setBounds(412, 11, 220, 30);
		pannello_Navigazione.add(etichetta_Orario);
		
		JButton bottone_Logout = new JButton("Logout");
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startLogin();
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}
}
