package gui;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

import controller.Controller;

public class ModificaRistoranteFrame extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Denominazione;
	private JTextField campo_Indirizzo;
	private JTextField campo_Telefono;
	private JTextField campo_Citta;
	private JTextField campo_Cap;
	private JTextField campo_SitoWeb;
	private JTextField campo_Email;
	private JComboBox campo_Provincia;
	private Controller theController;

	
	public ModificaRistoranteFrame(Controller c) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Modifica ristorante");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Ristorante = new JLabel("");
		etichetta_Ristorante.setIcon(new ImageIcon(ModificaRistoranteFrame.class.getResource("/resources/TitleModificaRistorante.png")));
		etichetta_Ristorante.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Ristorante.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Ristorante.setBounds(10, 11, 504, 60);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel etichetta_Denominazione = new JLabel("Denominazione (*)");
		etichetta_Denominazione.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/restaurantIcon.png")));
		etichetta_Denominazione.setForeground(new Color(0, 0, 128));
		etichetta_Denominazione.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Denominazione.setBounds(20, 82, 223, 27);
		pannello_Principale.add(etichetta_Denominazione);
		
		JLabel etichetta_Indirizzo = new JLabel("Indirizzo (*)");
		etichetta_Indirizzo.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/addressIcon.png")));
		etichetta_Indirizzo.setForeground(new Color(0, 0, 128));
		etichetta_Indirizzo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Indirizzo.setBounds(20, 152, 223, 27);
		pannello_Principale.add(etichetta_Indirizzo);
		
		JLabel etichetta_Telefono = new JLabel("Telefono (*)");
		etichetta_Telefono.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/telephoneIcon.png")));
		etichetta_Telefono.setForeground(new Color(0, 0, 128));
		etichetta_Telefono.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Telefono.setBounds(20, 222, 223, 27);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_Citta = new JLabel("Citt\u00E0 (*)");
		etichetta_Citta.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/cityIcon.png")));
		etichetta_Citta.setForeground(new Color(0, 0, 128));
		etichetta_Citta.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Citta.setBounds(20, 292, 172, 27);
		pannello_Principale.add(etichetta_Citta);
		
		JLabel etichetta_Provincia = new JLabel("Provincia (*)");
		etichetta_Provincia.setForeground(new Color(0, 0, 128));
		etichetta_Provincia.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Provincia.setBounds(232, 292, 172, 27);
		pannello_Principale.add(etichetta_Provincia);
		
		JLabel etichetta_Cap = new JLabel("CAP (*)");
		etichetta_Cap.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/capIcon.png")));
		etichetta_Cap.setForeground(new Color(0, 0, 128));
		etichetta_Cap.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cap.setBounds(20, 362, 223, 27);
		pannello_Principale.add(etichetta_Cap);
		
		JLabel etichetta_Email = new JLabel("Email ");
		etichetta_Email.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/mailicon.png")));
		etichetta_Email.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Email.setForeground(new Color(0, 0, 128));
		etichetta_Email.setBounds(20, 437, 223, 27);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_SitoWeb = new JLabel("Sito web ");
		etichetta_SitoWeb.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/websiteIcon.png")));
		etichetta_SitoWeb.setForeground(new Color(0, 0, 128));
		etichetta_SitoWeb.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_SitoWeb.setBounds(20, 506, 223, 27);
		pannello_Principale.add(etichetta_SitoWeb);
		
		JLabel lblCampoDenominazioneEmpty = new JLabel("");
		lblCampoDenominazioneEmpty.setForeground(new Color(47, 79, 79));
		lblCampoDenominazioneEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoDenominazioneEmpty.setBounds(344, 112, 180, 27);
		pannello_Principale.add(lblCampoDenominazioneEmpty);
		
		JLabel lblCampoIndirizzoEmpty = new JLabel("");
		lblCampoIndirizzoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoIndirizzoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoIndirizzoEmpty.setBounds(344, 182, 180, 27);
		pannello_Principale.add(lblCampoIndirizzoEmpty);
		
		JLabel lblCampoTelefonoEmpty = new JLabel("");
		lblCampoTelefonoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoTelefonoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoTelefonoEmpty.setBounds(344, 252, 180, 27);
		pannello_Principale.add(lblCampoTelefonoEmpty);
		
		JLabel lblCampoCittaEmpty = new JLabel("");
		lblCampoCittaEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCittaEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCittaEmpty.setBounds(344, 322, 180, 27);
		pannello_Principale.add(lblCampoCittaEmpty);
		
		JLabel lblCampoCapEmpty = new JLabel("");
		lblCampoCapEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCapEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCapEmpty.setBounds(218, 392, 180, 27);
		pannello_Principale.add(lblCampoCapEmpty);
		
		
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
		
		campo_Indirizzo = new JTextField();
		campo_Indirizzo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoIndirizzoEmpty.setText("");
			}
		});
		campo_Indirizzo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Indirizzo.setBounds(22, 182, 314, 27);
		pannello_Principale.add(campo_Indirizzo);
		campo_Indirizzo.setColumns(10);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setToolTipText("Sono ammesse cifre numeriche ed il carattere +");
		campo_Telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoTelefonoEmpty.setText("");
			}
		});
		campo_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Telefono.setBounds(22, 252, 314, 27);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		campo_Citta = new JTextField();
		campo_Citta.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCittaEmpty.setText("");
			}
		});
		campo_Citta.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Citta.setColumns(10);
		campo_Citta.setBounds(20, 322, 188, 27);
		pannello_Principale.add(campo_Citta);

		campo_Provincia = new JComboBox();
		campo_Provincia.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Provincia.setModel(new DefaultComboBoxModel(new String[] {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "ROMA", "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT", "ALTRO"}));
		campo_Provincia.setSelectedItem("NA");
		campo_Provincia.setBounds(232, 322, 104, 27);
		pannello_Principale.add(campo_Provincia);
		
		campo_Cap = new JTextField();
		campo_Cap.setToolTipText("Sono ammesse al massimo 5 cifre numeriche.");
		campo_Cap.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCapEmpty.setText("");
			}
		});
		campo_Cap.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cap.setBounds(20, 392, 188, 27);
		pannello_Principale.add(campo_Cap);
		campo_Cap.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setToolTipText("Deve rispettare la forma 'example@mail.domain'");
		campo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Email.setBounds(20, 467, 316, 27);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		campo_SitoWeb = new JTextField();
		campo_SitoWeb.setToolTipText("Deve rispettare la forma 'www.example.domain'");
		campo_SitoWeb.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_SitoWeb.setBounds(20, 536, 316, 27);
		pannello_Principale.add(campo_SitoWeb);
		campo_SitoWeb.setColumns(10);
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnnullaDialog(c);
			}
		});
		bottone_Annulla.setBounds(24, 607, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Modifica = new JButton("");
		JLabel lblModifica = new JLabel("Sei sicuro di voler modificare le informazioni del ristorante?");
		lblModifica.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) {
					lblCampoDenominazioneEmpty.setText("* Campo obbligatorio");
					lblCampoIndirizzoEmpty.setText("* Campo obbligatorio");
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
					lblCampoCittaEmpty.setText("* Campo obbligatorio");
					lblCampoCapEmpty.setText("* Campo obbligatorio");
				} else if(campo_Denominazione.getText().trim().isEmpty()) {
					lblCampoDenominazioneEmpty.setText("* Campo obbligatorio");
				} else if(campo_Indirizzo.getText().trim().isEmpty()) {
					lblCampoIndirizzoEmpty.setText("* Campo obbligatorio");
				} else if(campo_Telefono.getText().trim().isEmpty()) {
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else if (campo_Citta.getText().trim().isEmpty()) {
					lblCampoCittaEmpty.setText("* Campo obbligatorio");
				} else if (campo_Cap.getText().trim().isEmpty()) {
					lblCampoCapEmpty.setText("* Campo obbligatorio");
				} else {
					
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblModifica)==0) {
						c.updateRistorante(campo_Denominazione.getText(),
											campo_Indirizzo.getText(),
											campo_Telefono.getText(),
											campo_Citta.getText(),
											campo_Provincia.getSelectedItem().toString(),
											campo_Cap.getText(),
											campo_Email.getText(),
											campo_SitoWeb.getText());
						flushTextfields();
						setVisible(false);
						c.startRistorantiProprietarioFrame();
					}
				}
			}
		});
		bottone_Modifica.setIcon(new ImageIcon(ModificaRistoranteFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.setBounds(337, 607, 160, 60);
		pannello_Principale.add(bottone_Modifica);
	}
	
	private void flushTextfields() {
		campo_Denominazione.setText("");
		campo_Indirizzo.setText("");
		campo_Telefono.setText("");
		campo_Citta.setText("");
		campo_Cap.setText("");
		campo_SitoWeb.setText("");
		campo_Email.setText("");
	}
	
	private boolean areTextfieldsEmpty() {
		return 	campo_Denominazione.getText().trim().isEmpty() && 
				campo_Indirizzo.getText().trim().isEmpty() && 
				campo_Telefono.getText().trim().isEmpty() && 
				campo_Citta.getText().trim().isEmpty() &&
				campo_Cap.getText().trim().isEmpty();
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare le modifiche al ristorante?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.startRistorantiProprietarioFrame();
		}
	}

	public JTextField getCampo_Denominazione() {
		return campo_Denominazione;
	}

	public JTextField getCampo_Indirizzo() {
		return campo_Indirizzo;
	}

	public JTextField getCampo_Telefono() {
		return campo_Telefono;
	}

	public JTextField getCampo_Citta() {
		return campo_Citta;
	}

	public JTextField getCampo_Cap() {
		return campo_Cap;
	}

	public JTextField getCampo_SitoWeb() {
		return campo_SitoWeb;
	}

	public JTextField getCampo_Email() {
		return campo_Email;
	}

	public JComboBox getCampo_Provincia() {
		return campo_Provincia;
	}
	
	

}

