package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.controller;
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

public class Tavolate extends JFrame {

	private JPanel TavolataPane;
	private controller theController;
	private JTable TavolataTable;

	public Tavolate(controller c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMieiRistoranti.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		TavolataPane = new JPanel();
		TavolataPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TavolataPane);
		TavolataPane.setLayout(null);
		
		JLabel tavolateLabel = new JLabel("TAVOLATE");
		tavolateLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		tavolateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tavolateLabel.setBounds(277, 50, 490, 52);
		TavolataPane.add(tavolateLabel);
		
		JLabel RistoranteLabel = new JLabel("Ristorante: \"Denominazione\"");
		RistoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		RistoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RistoranteLabel.setBounds(277, 28, 490, 20);
		TavolataPane.add(RistoranteLabel);
		
		TavolataTable = new JTable();
		TavolataTable.setColumnSelectionAllowed(true);
		TavolataTable.setCellSelectionEnabled(true);
		TavolataTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		TavolataTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		TavolataTable.setModel(new DefaultTableModel(
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
		TavolataTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		TavolataTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		TavolataTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		TavolataTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		TavolataTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		TavolataTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		TavolataTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		TavolataTable.setBackground(Color.WHITE);
		TavolataTable.setBounds(10, 124, 1007, 223);
		TavolataPane.add(TavolataTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 223);
		TavolataPane.add(scrollBar);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBounds(0, 409, 1044, 52);
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TavolataPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.startLoginProprietario();
				setVisible(false);
			}
		});
		HomeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HomeButton.setBounds(10, 11, 89, 30);
		Navigation_panel.add(HomeButton);
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.setEnabled(false);
		IndietroButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		IndietroButton.setBounds(109, 11, 89, 30);
		Navigation_panel.add(IndietroButton);
		
		JLabel OrarioLabel = new JLabel("------");
		OrarioLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		OrarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OrarioLabel.setBounds(412, 11, 220, 30);
		Navigation_panel.add(OrarioLabel);
		
		JButton LogoutButton_2 = new JButton("Logout");
		LogoutButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.login();			
			}
		});
		LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton_2.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton_2);
		
		JButton GestireButton = new JButton("Gestisci");
		GestireButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		GestireButton.setBounds(120, 358, 110, 40);
		TavolataPane.add(GestireButton);
		
		JButton AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		AggiungiButton.setBounds(350, 358, 110, 40);
		TavolataPane.add(AggiungiButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModificaButton.setBounds(580, 358, 110, 40);
		TavolataPane.add(ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		EliminaButton.setBounds(810, 358, 110, 40);
		TavolataPane.add(EliminaButton);
	}
}
