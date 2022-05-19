package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Controller.Controller;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class AggiungiTavolata extends JFrame {

	private JPanel contentPane;
	private JTextField dataArrivoField;
	private JTextField oraArrivoField;
	private JTextField oraUscitaField;

	public AggiungiTavolata() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AggiungiTavolata.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(84, 379, 117, 40);
		contentPane.add(annullaButton);
		
		JButton aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setBounds(284, 379, 117, 40);
		contentPane.add(aggiungiButton);
		
		dataArrivoField = new JTextField();
		dataArrivoField.setBounds(84, 143, 160, 20);
		contentPane.add(dataArrivoField);
		dataArrivoField.setColumns(10);
		
		oraArrivoField = new JTextField();
		oraArrivoField.setBounds(84, 217, 100, 20);
		contentPane.add(oraArrivoField);
		oraArrivoField.setColumns(10);
		
		oraUscitaField = new JTextField();
		oraUscitaField.setBounds(301, 217, 100, 20);
		contentPane.add(oraUscitaField);
		oraUscitaField.setColumns(10);
		
		JComboBox cameriereAssociatoComboBox = new JComboBox();
		cameriereAssociatoComboBox.setBounds(84, 296, 316, 22);
		contentPane.add(cameriereAssociatoComboBox);
		
		JLabel dataArrivoLabel = new JLabel("Data Arrivo");
		dataArrivoLabel.setBounds(84, 129, 100, 14);
		contentPane.add(dataArrivoLabel);
		
		JLabel oraArrivoLabel = new JLabel("Ora Arrivo");
		oraArrivoLabel.setBounds(84, 203, 100, 14);
		contentPane.add(oraArrivoLabel);
		
		JLabel oraUscitaLabel = new JLabel("Ora Uscita");
		oraUscitaLabel.setBounds(301, 203, 100, 14);
		contentPane.add(oraUscitaLabel);
		
		JLabel cameriereAssociatoLabel = new JLabel("Cameriere associato");
		cameriereAssociatoLabel.setBounds(84, 282, 150, 14);
		contentPane.add(cameriereAssociatoLabel);
		
		JLabel aggiungiTavolataLabel = new JLabel("Aggiungi tavolata");
		aggiungiTavolataLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		aggiungiTavolataLabel.setHorizontalAlignment(SwingConstants.CENTER);
		aggiungiTavolataLabel.setBounds(137, 36, 209, 40);
		contentPane.add(aggiungiTavolataLabel);
	}

}
