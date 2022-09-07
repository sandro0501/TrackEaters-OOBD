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

public class ModificaTavoloFrame extends JFrame {

	private JPanel pannello_Principale;
	private JSpinner campo_NumeroAvventori;
	private JLabel etichetta_Codice;
	private Controller theController;

	
	public ModificaTavoloFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Modifica tavolo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Tavolo = new JLabel("");
		etichetta_Tavolo.setIcon(new ImageIcon(ModificaTavoloFrame.class.getResource("/resources/modificaTavoloTitle.png")));
		etichetta_Tavolo.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolo.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolo.setBounds(10, 11, 504, 60);
		pannello_Principale.add(etichetta_Tavolo);
		
		etichetta_Codice = new JLabel("");
		etichetta_Codice.setIcon(null);
		etichetta_Codice.setForeground(new Color(0, 0, 128));
		etichetta_Codice.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 18));
		etichetta_Codice.setBounds(165, 233, 328, 75);
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
		
		JButton bottone_Modifica = new JButton("");
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler modificare le informazioni del tavolo?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) 
				{
					int numeroAvventori = (Integer)campo_NumeroAvventori.getValue();
					c.updateTavolo(numeroAvventori);
					setVisible(false);
					c.mostraGestioneTavoliFrame();
				}
			}
		});

		bottone_Modifica.setIcon(new ImageIcon(ModificaTavoloFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.setBounds(333, 422, 160, 60);
		pannello_Principale.add(bottone_Modifica);
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare le modifiche al tavolo?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneTavoliFrame();
		}
	}

	public JLabel getEtichetta_Codice() {
		return etichetta_Codice;
	}

	public JSpinner getCampo_NumeroAvventori() {
		return campo_NumeroAvventori;
	}
}