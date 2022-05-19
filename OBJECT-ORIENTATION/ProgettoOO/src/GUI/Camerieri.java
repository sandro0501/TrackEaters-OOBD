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

public class Camerieri extends JFrame {
	
	private JPanel TavolataPane;
	private Controller theController;
	private JTable avventoriTable;

	public Camerieri(Controller c) {
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
		
		JLabel camerieriLabel = new JLabel("CAMERIERI");
		camerieriLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		camerieriLabel.setHorizontalAlignment(SwingConstants.CENTER);
		camerieriLabel.setBounds(277, 50, 490, 52);
		TavolataPane.add(camerieriLabel);
		
		JLabel ristoranteLabel = new JLabel("Ristorante: \"Denominazione\"");
		ristoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		ristoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ristoranteLabel.setBounds(277, 28, 490, 20);
		TavolataPane.add(ristoranteLabel);
		
		avventoriTable = new JTable();
		avventoriTable.setColumnSelectionAllowed(true);
		avventoriTable.setCellSelectionEnabled(true);
		avventoriTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		avventoriTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		avventoriTable.setModel(new DefaultTableModel(
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
		avventoriTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		avventoriTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		avventoriTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		avventoriTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		avventoriTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		avventoriTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		avventoriTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		avventoriTable.setBackground(Color.WHITE);
		avventoriTable.setBounds(10, 124, 1007, 223);
		TavolataPane.add(avventoriTable);
		
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
		
		JButton aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		aggiungiButton.setBounds(142, 358, 158, 40);
		TavolataPane.add(aggiungiButton);
		
		JButton modificaButton = new JButton("Modifica");
		modificaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		modificaButton.setBounds(442, 358, 158, 40);
		TavolataPane.add(modificaButton);
		
		JButton eliminaButton = new JButton("Elimina");
		eliminaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		eliminaButton.setBounds(742, 358, 158, 40);
		TavolataPane.add(eliminaButton);
	}

}
