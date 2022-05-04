package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
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
import java.awt.Toolkit;

public class Personale extends JFrame {

	private JPanel PersonalePane;
	private JTable PersonaleTable;
	private Controller theController;
	
	public Personale(Controller c) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(IMieiRistoranti.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		PersonalePane = new JPanel();
		PersonalePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(PersonalePane);
		PersonalePane.setLayout(null);
		
		JLabel PersonaleLabel = new JLabel("PERSONALE");
		PersonaleLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		PersonaleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		PersonaleLabel.setBounds(277, 35, 490, 52);
		PersonalePane.add(PersonaleLabel);
		
		PersonaleTable = new JTable();
		PersonaleTable.setColumnSelectionAllowed(true);
		PersonaleTable.setCellSelectionEnabled(true);
		PersonaleTable.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		PersonaleTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PersonaleTable.setModel(new DefaultTableModel(
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
		PersonaleTable.getColumnModel().getColumn(0).setPreferredWidth(110);
		PersonaleTable.getColumnModel().getColumn(1).setPreferredWidth(110);
		PersonaleTable.getColumnModel().getColumn(2).setPreferredWidth(85);
		PersonaleTable.getColumnModel().getColumn(3).setPreferredWidth(90);
		PersonaleTable.getColumnModel().getColumn(4).setPreferredWidth(65);
		PersonaleTable.getColumnModel().getColumn(5).setPreferredWidth(55);
		PersonaleTable.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		PersonaleTable.setBackground(Color.WHITE);
		PersonaleTable.setBounds(10, 124, 1007, 223);
		PersonalePane.add(PersonaleTable);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 223);
		PersonalePane.add(scrollBar);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBounds(0, 409, 1044, 52);
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		PersonalePane.add(Navigation_panel);
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
		
		JButton LogoutButton = new JButton("Logout");
		LogoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.login();			
			}
		});
		LogoutButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton);
		
		JButton AggiungiButton = new JButton("Aggiungi");
		AggiungiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.startRegistrazione();
				setVisible(false);
			}
		});
		AggiungiButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		AggiungiButton.setBounds(178, 358, 110, 40);
		PersonalePane.add(AggiungiButton);
		
		JButton ModificaButton = new JButton("Modifica");
		ModificaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		ModificaButton.setBounds(466, 358, 110, 40);
		PersonalePane.add(ModificaButton);
		
		JButton EliminaButton = new JButton("Elimina");
		EliminaButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		EliminaButton.setBounds(754, 358, 110, 40);
		PersonalePane.add(EliminaButton);
	}

}
