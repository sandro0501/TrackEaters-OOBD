package GUI;

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
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controller.Controller;

public class Sale extends JFrame {

	private JPanel TavolataPane;
	private Controller theController;
	private JTable SaleTable;

	public Sale(Controller c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ristoranti.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		TavolataPane = new JPanel();
		TavolataPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(TavolataPane);
		TavolataPane.setLayout(null);
		
		JLabel tavolateLabel = new JLabel("SALE");
		tavolateLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		tavolateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tavolateLabel.setBounds(277, 50, 490, 52);
		TavolataPane.add(tavolateLabel);
		
		JLabel RistoranteLabel = new JLabel("Ristorante: \"Denominazione\"");
		RistoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		RistoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RistoranteLabel.setBounds(277, 28, 490, 20);
		TavolataPane.add(RistoranteLabel);
		
		SaleTable = new JTable();
		SaleTable.setColumnSelectionAllowed(true);
		SaleTable.setCellSelectionEnabled(true);
		SaleTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		SaleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		SaleTable.setModel(new DefaultTableModel(
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
		SaleTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		SaleTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		SaleTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		SaleTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		SaleTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		SaleTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		SaleTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		SaleTable.setBackground(Color.WHITE);
		SaleTable.setBounds(10, 124, 1007, 223);
		TavolataPane.add(SaleTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 223);
		TavolataPane.add(scrollBar);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBounds(0, 409, 1044, 52);
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		TavolataPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
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
		
		JButton VisualizzaTavoliButton = new JButton("Visualizza tavoli");
		VisualizzaTavoliButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		VisualizzaTavoliButton.setBounds(107, 358, 127, 40);
		TavolataPane.add(VisualizzaTavoliButton);
		
		JButton AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		AggiungiButton.setBounds(341, 358, 127, 40);
		TavolataPane.add(AggiungiButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModificaButton.setBounds(575, 358, 127, 40);
		TavolataPane.add(ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		EliminaButton.setBounds(809, 358, 127, 40);
		TavolataPane.add(EliminaButton);
	}

}
