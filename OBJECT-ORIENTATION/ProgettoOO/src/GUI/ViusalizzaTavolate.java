package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
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

public class ViusalizzaTavolate extends JFrame {

	private JPanel TavolataPane;
	private Controller theController;
	private JTable tavolateTable;

	public ViusalizzaTavolate(Controller c) {
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
		tavolateLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		tavolateLabel.setHorizontalAlignment(SwingConstants.CENTER);
		tavolateLabel.setBounds(277, 50, 490, 52);
		TavolataPane.add(tavolateLabel);
		
		JLabel ristoranteLabel = new JLabel("Ristorante: \"Denominazione\"");
		ristoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		ristoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ristoranteLabel.setBounds(277, 28, 490, 20);
		TavolataPane.add(ristoranteLabel);
		
		tavolateTable = new JTable();
		tavolateTable.setColumnSelectionAllowed(true);
		tavolateTable.setCellSelectionEnabled(true);
		tavolateTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tavolateTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tavolateTable.setModel(new DefaultTableModel(
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
		tavolateTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		tavolateTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		tavolateTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		tavolateTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		tavolateTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		tavolateTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		tavolateTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tavolateTable.setBackground(Color.WHITE);
		tavolateTable.setBounds(10, 124, 1007, 223);
		TavolataPane.add(tavolateTable);
		
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
		
		JButton visualizzaAvventoriButton = new JButton("Visualizza avventori");
		visualizzaAvventoriButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		visualizzaAvventoriButton.setBounds(82, 358, 158, 40);
		TavolataPane.add(visualizzaAvventoriButton);
		
		JButton aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		aggiungiButton.setBounds(322, 358, 158, 40);
		TavolataPane.add(aggiungiButton);
		
		JButton modificaButton = new JButton("Modifica");
		modificaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		modificaButton.setBounds(562, 358, 158, 40);
		TavolataPane.add(modificaButton);
		
		JButton eliminaButton = new JButton("Elimina");
		eliminaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		eliminaButton.setBounds(802, 358, 158, 40);
		TavolataPane.add(eliminaButton);
	}
}
