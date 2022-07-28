package GUI;

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

public class Tavolate extends JFrame {

	private JPanel pannello_Principale;
	private JTable tabella_Tavolate;

	public Tavolate() {
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
		
		JLabel etichetta_Tavolate = new JLabel("TAVOLATE");
		etichetta_Tavolate.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolate.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolate.setBounds(277, 50, 490, 52);
		pannello_Principale.add(etichetta_Tavolate);
		
		tabella_Tavolate = new JTable();
		tabella_Tavolate.setColumnSelectionAllowed(true);
		tabella_Tavolate.setCellSelectionEnabled(true);
		tabella_Tavolate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		tabella_Tavolate.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabella_Tavolate.setModel(new DefaultTableModel(
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
		tabella_Tavolate.getColumnModel().getColumn(0).setPreferredWidth(110);
		tabella_Tavolate.getColumnModel().getColumn(1).setPreferredWidth(110);
		tabella_Tavolate.getColumnModel().getColumn(2).setPreferredWidth(85);
		tabella_Tavolate.getColumnModel().getColumn(3).setPreferredWidth(90);
		tabella_Tavolate.getColumnModel().getColumn(4).setPreferredWidth(65);
		tabella_Tavolate.getColumnModel().getColumn(5).setPreferredWidth(55);
		tabella_Tavolate.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		tabella_Tavolate.setBackground(Color.WHITE);
		tabella_Tavolate.setBounds(10, 124, 1007, 223);
		pannello_Principale.add(tabella_Tavolate);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(1017, 124, 17, 223);
		pannello_Principale.add(scrollBar);
		
		JButton bottone_VisualizzaAvventori = new JButton("Visualizza avventori");
		bottone_VisualizzaAvventori.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_VisualizzaAvventori.setBounds(82, 358, 158, 40);
		pannello_Principale.add(bottone_VisualizzaAvventori);
		
		JButton bottone_Aggiungi = new JButton("Aggiungi");
		bottone_Aggiungi.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Aggiungi.setBounds(322, 358, 158, 40);
		pannello_Principale.add(bottone_Aggiungi);
		
		JButton bottone_Modifica = new JButton("Modifica");
		bottone_Modifica.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Modifica.setBounds(562, 358, 158, 40);
		pannello_Principale.add(bottone_Modifica);
		
		JButton bottone_Elimina = new JButton("Elimina");
		bottone_Elimina.setFont(new Font("Tahoma", Font.PLAIN, 12));
		bottone_Elimina.setBounds(802, 358, 158, 40);
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
		
		JButton bottone_Indietro = new JButton("Indietro");
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(109, 11, 89, 30);
		pannello_Navigazione.add(bottone_Indietro);
		
		JLabel etichetta_Orario = new JLabel("------");
		etichetta_Orario.setFont(new Font("Tahoma", Font.BOLD, 12));
		etichetta_Orario.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Orario.setBounds(412, 11, 220, 30);
		pannello_Navigazione.add(etichetta_Orario);
		
		JButton bottone_Logout = new JButton("Logout");
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(945, 11, 89, 30);
		pannello_Navigazione.add(bottone_Logout);
	}
}
