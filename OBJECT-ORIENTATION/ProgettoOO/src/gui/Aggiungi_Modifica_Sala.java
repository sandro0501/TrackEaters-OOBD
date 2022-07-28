package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Aggiungi_Modifica_Sala extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Denominazione;
	private JTextField campo_CapienzaAvventori;
	private JTextField campo_DimensioneMq;

	public Aggiungi_Modifica_Sala() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Aggiungi_Modifica_Tavolata.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Sala = new JLabel("SALA");
		etichetta_Sala.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Sala.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Sala.setBounds(137, 23, 209, 40);
		pannello_Principale.add(etichetta_Sala);
		
		JLabel etichetta_Denominazione = new JLabel("Denominazione");
		etichetta_Denominazione.setBounds(92, 110, 109, 14);
		pannello_Principale.add(etichetta_Denominazione);
		
		JLabel etichetta_CapienzaAvventori = new JLabel("Capienza avventori");
		etichetta_CapienzaAvventori.setBounds(92, 163, 109, 14);
		pannello_Principale.add(etichetta_CapienzaAvventori);
		
		JLabel etichetta_DimensioneMq = new JLabel("Dimensione (Mq)");
		etichetta_DimensioneMq.setBounds(92, 221, 109, 14);
		pannello_Principale.add(etichetta_DimensioneMq);
		
		JLabel etichetta_Tipo = new JLabel("Tipo");
		etichetta_Tipo.setBounds(92, 287, 46, 14);
		pannello_Principale.add(etichetta_Tipo);
		
		campo_Denominazione = new JTextField();
		campo_Denominazione.setBounds(92, 123, 300, 20);
		pannello_Principale.add(campo_Denominazione);
		campo_Denominazione.setColumns(10);
		
		campo_CapienzaAvventori = new JTextField();
		campo_CapienzaAvventori.setColumns(10);
		campo_CapienzaAvventori.setBounds(92, 176, 300, 20);
		pannello_Principale.add(campo_CapienzaAvventori);
		
		campo_DimensioneMq = new JTextField();
		campo_DimensioneMq.setColumns(10);
		campo_DimensioneMq.setBounds(92, 234, 300, 20);
		pannello_Principale.add(campo_DimensioneMq);
		
		JComboBox comboBox_Tipo = new JComboBox();
		comboBox_Tipo.setBounds(92, 301, 300, 20);
		pannello_Principale.add(comboBox_Tipo);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setBounds(84, 379, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Conferma = new JButton("Conferma");
		bottone_Conferma.setBounds(284, 379, 117, 40);
		pannello_Principale.add(bottone_Conferma);
	}
}
