package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JRadioButton;

import controller.Controller;

public class Casi extends JFrame {

	private JPanel pannello_Principale;
	private JTable tabella_Casi;
	private Controller theController;
	
	public Casi(Controller c, boolean proprietario) {
		
		theController = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(RistorantiProprietarioFrame.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Ristorante = new JLabel("Ristorante: \"Denominazione\"");
		etichetta_Ristorante.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Ristorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Ristorante.setBounds(277, 28, 490, 20);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel etichetta_Casi = new JLabel("CASI");
		etichetta_Casi.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Casi.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Casi.setBounds(277, 50, 490, 52);
		pannello_Principale.add(etichetta_Casi);
		
		String[] nomeColonne = {"Denominazione", "Indirizzo", "Telefono", "Citt\u00E0", "Provincia", "CAP", "Email", "Sito Web"};
		Object[][] dati = {{"prova", "prova", "prova", "prova", "prova", "prova", "prova", "prova"}, 
				{"prova", "prova", "prova", "prova", "prova", "prova", "prova", "prova"}};
		
		tabella_Casi = new JTable(dati, nomeColonne);
		tabella_Casi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabella_Casi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Casi.getColumnModel().getColumn(0).setPreferredWidth(110);
		tabella_Casi.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabella_Casi.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabella_Casi.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabella_Casi.getColumnModel().getColumn(4).setPreferredWidth(65);
		tabella_Casi.getColumnModel().getColumn(5).setPreferredWidth(55);
		tabella_Casi.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabella_Casi.setBackground(Color.WHITE);
		tabella_Casi.setBounds(10, 124, 1007, 223);
		
		JScrollPane scrollPane_Tabella = new JScrollPane(tabella_Casi);
		scrollPane_Tabella.setBounds(10, 124, 1007, 223);
		pannello_Principale.add(scrollPane_Tabella);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startAggiungiCaso(proprietario);
			}
		});
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(82, 358, 158, 40);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("Modifica");
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startModificaAvventore(proprietario);
			}
		});
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(322, 358, 158, 40);
		pannello_Principale.add(bottone_Modifica);
		
		JButton bottone_Elimina = new JButton("Elimina");
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(562, 358, 158, 40);
		pannello_Principale.add(bottone_Elimina);
		
		JRadioButton radioButton_Risolto = new JRadioButton("Risolto");
		radioButton_Risolto.setBounds(802, 358, 158, 40);
		pannello_Principale.add(radioButton_Risolto);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setBounds(0, 409, 1044, 52);
		pannello_Navigazione.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("Home");
		bottone_Home.addActionListener(new ActionListener () {
			public void actionPerformed (ActionEvent e) {
				setVisible(false);
				c.startHomepageProprietarioFrame();
			}
		});
		if (!proprietario) {
			bottone_Home.setEnabled(false);
		}
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 89, 30);
		pannello_Navigazione.add(bottone_Home);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.addActionListener(new ActionListener () {
			public void actionPerformed(ActionEvent e) {
				if(!proprietario) {
					setVisible(false);
					c.startHomepageProprietarioFrame();
				} else {
					setVisible(false);
					c.startHomepageGestioneRistoranteFrame(proprietario);
				}
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
				if(JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler uscire?")==0) {
					setVisible(false);
					c.startLoginFrame();
				}
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}
}
