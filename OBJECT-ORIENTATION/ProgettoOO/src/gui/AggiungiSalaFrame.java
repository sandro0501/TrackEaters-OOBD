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

public class AggiungiSalaFrame extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Denominazione;
	private JSpinner campo_CapienzaAvventori;
	private JSpinner campo_DimensioneMq;
	private JComboBox campo_TipologiaSala;
	private Controller theController;

	
	public AggiungiSalaFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaAvventoreFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Aggiungi sala ristorante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Sala = new JLabel("");
		etichetta_Sala.setIcon(new ImageIcon(AggiungiSalaFrame.class.getResource("/resources/aggiungiSala_title.png")));
		etichetta_Sala.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Sala.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Sala.setBounds(10, 11, 504, 60);
		pannello_Principale.add(etichetta_Sala);
		
		JLabel etichetta_Denominazione = new JLabel("Denominazione (*)");
		etichetta_Denominazione.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/restaurantIcon.png")));
		etichetta_Denominazione.setForeground(new Color(0, 0, 128));
		etichetta_Denominazione.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Denominazione.setBounds(20, 82, 223, 27);
		pannello_Principale.add(etichetta_Denominazione);
		
		JLabel etichetta_Capienza = new JLabel("Capienza avventori ");
		etichetta_Capienza.setIcon(new ImageIcon(AggiungiSalaFrame.class.getResource("/resources/capienzaIcon.png")));
		etichetta_Capienza.setForeground(new Color(0, 0, 128));
		etichetta_Capienza.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Capienza.setBounds(20, 152, 223, 27);
		pannello_Principale.add(etichetta_Capienza);
		
		JLabel etichetta_DimensioneMq = new JLabel("Dimensione (mq)");
		etichetta_DimensioneMq.setIcon(new ImageIcon(AggiungiSalaFrame.class.getResource("/resources/dimensioneIcon.png")));
		etichetta_DimensioneMq.setForeground(new Color(0, 0, 128));
		etichetta_DimensioneMq.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_DimensioneMq.setBounds(20, 222, 223, 27);
		pannello_Principale.add(etichetta_DimensioneMq);
		
		JLabel etichetta_TipologiaSala = new JLabel("Tipologia ");
		etichetta_TipologiaSala.setIcon(new ImageIcon(AggiungiSalaFrame.class.getResource("/resources/tipologiaIcon.png")));
		etichetta_TipologiaSala.setForeground(new Color(0, 0, 128));
		etichetta_TipologiaSala.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_TipologiaSala.setBounds(20, 292, 172, 27);
		pannello_Principale.add(etichetta_TipologiaSala);
		
		JLabel lblCampoDenominazioneEmpty = new JLabel("");
		lblCampoDenominazioneEmpty.setForeground(new Color(47, 79, 79));
		lblCampoDenominazioneEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoDenominazioneEmpty.setBounds(344, 112, 180, 27);
		pannello_Principale.add(lblCampoDenominazioneEmpty);
		
		campo_Denominazione = new JTextField();
		campo_Denominazione.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoDenominazioneEmpty.setText("");
			}
		});
		campo_Denominazione.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Denominazione.setBounds(20, 112, 316, 27);
		pannello_Principale.add(campo_Denominazione);
		campo_Denominazione.setColumns(10);
		
		campo_CapienzaAvventori = new JSpinner();
		campo_CapienzaAvventori.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		campo_CapienzaAvventori.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_CapienzaAvventori.setBounds(20, 182, 193, 27);
		((DefaultEditor)campo_CapienzaAvventori.getEditor()).getTextField().setEditable(false);
		pannello_Principale.add(campo_CapienzaAvventori);
		
		campo_DimensioneMq = new JSpinner();
		campo_DimensioneMq.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		campo_DimensioneMq.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_DimensioneMq.setBounds(20, 252, 193, 27);
		((DefaultEditor)campo_DimensioneMq.getEditor()).getTextField().setEditable(false);
		pannello_Principale.add(campo_DimensioneMq);

		campo_TipologiaSala = new JComboBox();
		campo_TipologiaSala.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_TipologiaSala.setModel(new DefaultComboBoxModel(new String[] {"Interna","Esterna"}));
		campo_TipologiaSala.setSelectedItem("Interna");
		campo_TipologiaSala.setBounds(20, 322, 134, 27);
		pannello_Principale.add(campo_TipologiaSala);
		
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
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler inserire la nuova sala?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) 
				{
					lblCampoDenominazioneEmpty.setText("* Campo obbligatorio");
				} 
				else 
				{
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) 
					{
						int capienzaAvventori = (Integer)campo_CapienzaAvventori.getValue();
						int dimensioneMq = (Integer)campo_DimensioneMq.getValue();
						
						c.aggiungiSala(campo_Denominazione.getText(),capienzaAvventori,dimensioneMq,campo_TipologiaSala.getSelectedItem().toString());
						flushTextfields();
						setVisible(false);
						c.mostraGestioneSaleETavolateFrame();
					}
				}
			}
		});

		bottone_Aggiungi.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setBounds(333, 422, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
	}
	
	private void flushTextfields() {
		campo_Denominazione.setText("");
	}
	
	private boolean areTextfieldsEmpty() {
		return 	campo_Denominazione.getText().trim().isEmpty();
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare l'inserimento della nuova sala?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneSaleETavolateFrame();
		}
	}
}