package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.controller;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import javax.swing.border.EtchedBorder;
import java.awt.Cursor;
import javax.swing.JScrollBar;

public class IMieiRistoranti extends JFrame {

	private JPanel contentPane;
	private controller theController;
	private JTable RistornatiTable;

	public IMieiRistoranti(controller c) {
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel IMieiRistorantiLabel = new JLabel("I MIEI RISTORANTI");
		IMieiRistorantiLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		IMieiRistorantiLabel.setHorizontalAlignment(SwingConstants.CENTER);
		IMieiRistorantiLabel.setBounds(277, 11, 490, 52);
		contentPane.add(IMieiRistorantiLabel);
		
		JLabel NomeECognomeLabel = new JLabel("\"Nome\" \"Cognome\"");
		NomeECognomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		NomeECognomeLabel.setBounds(277, 74, 490, 20);
		contentPane.add(NomeECognomeLabel);
		
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
		contentPane.add(RistornatiTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 256);
		contentPane.add(scrollBar);
	}
}
