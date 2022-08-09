package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;

import controller.Controller;

public class Aggiungi_Tavolata extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_DataArrivo;
	private JTextField campo_OraArrivo;
	private JTextField campo_OraUscita;
	private Controller theController;

	public Aggiungi_Tavolata(Controller c, boolean proprietario) {
		
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
		
		JLabel etichetta_Tavolata = new JLabel("TAVOLATA");
		etichetta_Tavolata.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolata.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolata.setBounds(137, 36, 209, 40);
		pannello_Principale.add(etichetta_Tavolata);
		
		JLabel etichetta_DataArrivo = new JLabel("Data Arrivo");
		etichetta_DataArrivo.setBounds(84, 129, 100, 14);
		pannello_Principale.add(etichetta_DataArrivo);
		
		JLabel etichetta_OraArrivo = new JLabel("Ora Arrivo");
		etichetta_OraArrivo.setBounds(84, 203, 100, 14);
		pannello_Principale.add(etichetta_OraArrivo);
		
		JLabel etichetta_OraUscita = new JLabel("Ora Uscita");
		etichetta_OraUscita.setBounds(301, 203, 100, 14);
		pannello_Principale.add(etichetta_OraUscita);
		
		JLabel etichetta_cameriereAssociato = new JLabel("Cameriere associato");
		etichetta_cameriereAssociato.setBounds(84, 282, 150, 14);
		pannello_Principale.add(etichetta_cameriereAssociato);
		
		campo_DataArrivo = new JTextField();
		campo_DataArrivo.setBounds(84, 143, 160, 20);
		pannello_Principale.add(campo_DataArrivo);
		campo_DataArrivo.setColumns(10);
		
		campo_OraArrivo = new JTextField();
		campo_OraArrivo.setBounds(84, 217, 100, 20);
		pannello_Principale.add(campo_OraArrivo);
		campo_OraArrivo.setColumns(10);
		
		campo_OraUscita = new JTextField();
		campo_OraUscita.setBounds(301, 217, 100, 20);
		pannello_Principale.add(campo_OraUscita);
		campo_OraUscita.setColumns(10);
		
		JComboBox comboBox_CameriereAssociato = new JComboBox();
		comboBox_CameriereAssociato.setBounds(84, 296, 316, 22);
		pannello_Principale.add(comboBox_CameriereAssociato);
		
		JButton bottone_Annulla = new JButton("Annulla");
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.startTavolate(proprietario);
				}
			}
		});
		bottone_Annulla.setBounds(84, 379, 117, 40);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("Conferma");
		bottone_Aggiungi.setBounds(284, 379, 117, 40);
		pannello_Principale.add(bottone_Aggiungi);
	}

}
