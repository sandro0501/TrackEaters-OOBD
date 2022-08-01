package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import controller.Controller;

public class Aggiungi_Modifica_Tavolo extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_CapienzaTavolo;
	private Controller theController;

	public Aggiungi_Modifica_Tavolo(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Aggiungi_Modifica_Tavolata.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		pannello_Principale = new JPanel();
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Tavolo = new JLabel("TAVOLO");
		etichetta_Tavolo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolo.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolo.setBounds(137, 36, 209, 40);
		pannello_Principale.add(etichetta_Tavolo);
		
		JLabel etichetta_CapienzaTavolo = new JLabel("Capienza avventori");
		etichetta_CapienzaTavolo.setBounds(162, 158, 100, 14);
		pannello_Principale.add(etichetta_CapienzaTavolo);
		
		campo_CapienzaTavolo = new JTextField();
		campo_CapienzaTavolo.setBounds(162, 182, 160, 20);
		pannello_Principale.add(campo_CapienzaTavolo);
		campo_CapienzaTavolo.setColumns(10);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.setBounds(84, 379, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("Conferma");
		bottone_Aggiungi.setBounds(284, 379, 117, 40);
		pannello_Principale.add(bottone_Aggiungi);
	}

}