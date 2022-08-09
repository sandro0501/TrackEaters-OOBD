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

import controller.Controller;

public class Sale extends JFrame {

	private JPanel pannello_Principale;
	private JTable tabella_Sale;
	private Controller theController;

	public Sale(Controller c, boolean proprietario) {
		
		theController = c;
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ristoranti.class.getResource("/resources/icon.png")));
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
		
		JLabel etichetta_Sale = new JLabel("SALE");
		etichetta_Sale.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Sale.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Sale.setBounds(277, 50, 490, 52);
		pannello_Principale.add(etichetta_Sale);
		
		String[] nomeColonne = {"Denominazione", "Indirizzo", "Telefono", "Citt\u00E0", "Provincia", "CAP", "Email", "Sito Web"};
		Object[][] dati = {{"prova", "prova", "prova", "prova", "prova", "prova", "prova", "prova"}, 
				{"prova", "prova", "prova", "prova", "prova", "prova", "prova", "prova"}};
		
		tabella_Sale = new JTable(dati, nomeColonne);
		tabella_Sale.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabella_Sale.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Sale.getColumnModel().getColumn(0).setPreferredWidth(110);
		tabella_Sale.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabella_Sale.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabella_Sale.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabella_Sale.getColumnModel().getColumn(4).setPreferredWidth(65);
		tabella_Sale.getColumnModel().getColumn(5).setPreferredWidth(55);
		tabella_Sale.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabella_Sale.setBackground(Color.WHITE);
		tabella_Sale.setBounds(10, 124, 1007, 223);
		
		JScrollPane scrollPane_Tabella = new JScrollPane(tabella_Sale);
		scrollPane_Tabella.setBounds(10, 124, 1007, 223);
		pannello_Principale.add(scrollPane_Tabella);
		
		JButton bottone_VisualizzaTavoli = new JButton("Visualizza tavoli");
		bottone_VisualizzaTavoli.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (tabella_Sale.getSelectedRow()!=-1) {
					setVisible(false);
					c.startTavoli(proprietario);
				} else {
					JOptionPane.showMessageDialog(pannello_Principale, "Nessuna sala selezionata!");
				}
			}
		});
		bottone_VisualizzaTavoli.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_VisualizzaTavoli.setBounds(107, 358, 127, 40);
		pannello_Principale.add(bottone_VisualizzaTavoli);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		if (proprietario) {
			bottone_Aggiungi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					c.startAggiungiSala(proprietario);
				}
			});
		} else {
			bottone_Aggiungi.setEnabled(false);
		}
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(341, 358, 127, 40);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("Modifica");
		if (proprietario) {
			bottone_Modifica.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					c.startModificaSala(proprietario);
				}
			});
		} else {
			bottone_Modifica.setEnabled(false);
		}
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(575, 358, 127, 40);
		pannello_Principale.add(bottone_Modifica);
		
		JButton bottone_Elimina = new JButton("Elimina");
		if (!proprietario) {
			bottone_Elimina.setEnabled(false);
		}
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(809, 358, 127, 40);
		pannello_Principale.add(bottone_Elimina);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setBounds(0, 409, 1044, 52);
		pannello_Navigazione.setBorder(new LineBorder(new Color(0, 0, 0)));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("Home");
		if(proprietario) {
			bottone_Home.addActionListener(new ActionListener() {
				public void actionPerformed (ActionEvent e) {
					setVisible(false);
					c.startHomepageProprietario();
				}
			});
		} else {
			bottone_Home.setEnabled(false);
		}
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Home.setBounds(10, 11, 89, 30);
		pannello_Navigazione.add(bottone_Home);
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!proprietario) {
					setVisible(false);
					c.startRistorante(proprietario);
				} else {
					setVisible(false);
					c.startRistorante(proprietario);
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
					c.startLogin();
				}
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}

}
