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

public class IMieiRistoranti extends JFrame {

	private JPanel IMieiRistorantiPane;
	private controller theController;
	private JTable RistornatiTable;

	public IMieiRistoranti(controller c) {
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		IMieiRistorantiPane = new JPanel();
		IMieiRistorantiPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(IMieiRistorantiPane);
		IMieiRistorantiPane.setLayout(null);
		
		JLabel IMieiRistorantiLabel = new JLabel("I MIEI RISTORANTI");
		IMieiRistorantiLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		IMieiRistorantiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IMieiRistorantiLabel.setBounds(277, 11, 490, 52);
		IMieiRistorantiPane.add(IMieiRistorantiLabel);
		
		JLabel NomeECognomeLabel = new JLabel("\"Nome\" \"Cognome\"");
		NomeECognomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NomeECognomeLabel.setBounds(277, 74, 490, 20);
		IMieiRistorantiPane.add(NomeECognomeLabel);
		
		RistornatiTable = new JTable();
		RistornatiTable.setColumnSelectionAllowed(true);
		RistornatiTable.setCellSelectionEnabled(true);
		RistornatiTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		RistornatiTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		RistornatiTable.setModel(new DefaultTableModel(
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
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		RistornatiTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		RistornatiTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		RistornatiTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		RistornatiTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		RistornatiTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		RistornatiTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		RistornatiTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		RistornatiTable.setBackground(Color.WHITE);
		RistornatiTable.setBounds(10, 124, 1007, 256);
		IMieiRistorantiPane.add(RistornatiTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 256);
		IMieiRistorantiPane.add(scrollBar);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBounds(0, 409, 1044, 52);
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		IMieiRistorantiPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.setEnabled(false);
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
				c.logout();			
			}
		});
		LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton_2.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton_2);
	}
}
