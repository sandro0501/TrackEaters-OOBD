package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.util.Locale;

import controller.Controller;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;

public class AggiungiTavoloFrame extends JFrame {

	private JPanel pannello_Principale;
	private JSpinner campo_NumeroAvventori;
	private Controller theController;

	
	public AggiungiTavoloFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Aggiungi tavolo alla sala");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Tavolo = new JLabel("");
		etichetta_Tavolo.setIcon(new ImageIcon(AggiungiTavoloFrame.class.getResource("/resources/aggiungiTavoloTitle.png")));
		etichetta_Tavolo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolo.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolo.setBounds(10, 11, 504, 60);
		pannello_Principale.add(etichetta_Tavolo);
		
		JLabel etichetta_Codice = new JLabel("<html>* il Codice Tavolo verr\u00E0 assegnato automaticamente<br> dopo l'insermento.</html>");
		etichetta_Codice.setIcon(null);
		etichetta_Codice.setForeground(new Color(0, 0, 128));
		etichetta_Codice.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		etichetta_Codice.setBounds(21, 233, 481, 75);
		pannello_Principale.add(etichetta_Codice);
		
		JLabel etichetta_NumeroAvventori = new JLabel("Numero avventori");
		etichetta_NumeroAvventori.setIcon(new ImageIcon(AggiungiSalaFrame.class.getResource("/resources/capienzaIcon.png")));
		etichetta_NumeroAvventori.setForeground(new Color(0, 0, 128));
		etichetta_NumeroAvventori.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_NumeroAvventori.setBounds(165, 147, 278, 27);
		pannello_Principale.add(etichetta_NumeroAvventori);
		
		campo_NumeroAvventori = new JSpinner();
		campo_NumeroAvventori.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		campo_NumeroAvventori.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_NumeroAvventori.setBounds(165, 179, 193, 27);
		((DefaultEditor)campo_NumeroAvventori.getEditor()).getTextField().setEditable(false);
		pannello_Principale.add(campo_NumeroAvventori);
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnnullaDialog(c);
			}
		});
		bottone_Annulla.setBounds(20, 422, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("");
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler inserire il nuovo tavolo alla sala?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) 
				{
					int numeroAvventori = (Integer)campo_NumeroAvventori.getValue();
					c.insertTavolo(numeroAvventori);
					setVisible(false);
					c.mostraGestioneTavoliFrame();
				}
			}
		});

		bottone_Aggiungi.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setBounds(333, 422, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare l'inserimento del nuovo tavolo alla sala?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneTavoliFrame();
		}
	}
}