package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

import controller.Controller;

public class Aggiungi_Caso extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_DataPositivita;
	private Controller theController;

	public Aggiungi_Caso(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Tavolata.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Caso = new JLabel("CASO");
		etichetta_Caso.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Caso.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Caso.setBounds(137, 23, 209, 40);
		pannello_Principale.add(etichetta_Caso);
		
		JLabel etichetta_Ruolo = new JLabel("Ruolo");
		etichetta_Ruolo.setBounds(92, 78, 46, 14);
		pannello_Principale.add(etichetta_Ruolo);
		
		JLabel etichetta_NumeroDocumento = new JLabel("Numero documento");
		etichetta_NumeroDocumento.setBounds(92, 131, 111, 14);
		pannello_Principale.add(etichetta_NumeroDocumento);
		
		JLabel etichetta_DataPositivita = new JLabel("Data positivit\u00E0");
		etichetta_DataPositivita.setBounds(92, 193, 111, 14);
		pannello_Principale.add(etichetta_DataPositivita);
		
		JLabel etichetta_Note = new JLabel("Note");
		etichetta_Note.setBounds(92, 253, 46, 14);
		pannello_Principale.add(etichetta_Note);
		
		JComboBox comboBox_Ruolo = new JComboBox();
		comboBox_Ruolo.setBounds(92, 92, 300, 20);
		pannello_Principale.add(comboBox_Ruolo);
		
		JComboBox comboBox_NumeroDocumento = new JComboBox();
		comboBox_NumeroDocumento.setBounds(92, 147, 300, 20);
		pannello_Principale.add(comboBox_NumeroDocumento);
		
		campo_DataPositivita = new JTextField();
		campo_DataPositivita.setBounds(92, 206, 300, 20);
		pannello_Principale.add(campo_DataPositivita);
		campo_DataPositivita.setColumns(10);
		
		JTextArea areaDiTesto_Note = new JTextArea();
		areaDiTesto_Note.setBounds(92, 267, 300, 82);
		pannello_Principale.add(areaDiTesto_Note);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startCasi(proprietario);
				}
			}
		});
		bottone_Annulla.setBounds(84, 379, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Conferma = new JButton("Conferma");
		bottone_Conferma.setBounds(284, 379, 117, 40);
		pannello_Principale.add(bottone_Conferma);
	}
}
