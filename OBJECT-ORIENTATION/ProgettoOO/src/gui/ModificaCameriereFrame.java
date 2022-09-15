package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.Controller;
import javax.swing.ImageIcon;
import java.awt.Color;

public class ModificaCameriereFrame extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_DataNascita;
	private JTextField campo_NumeroDocumento;
	private JTextField campo_CittaNatale;
	private JTextField campo_CittaResidenza;
	private JTextField campo_Telefono;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JComboBox comboBox_Sesso;
	private JComboBox comboBox_ProvinciaNatale;
	private JComboBox comboBox_ProvinciaResidenza;
	private JComboBox comboBox_Ristorante;
	private Controller theController;

	
	public ModificaCameriereFrame(Controller c, boolean proprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaCameriereFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Modifica cameriere");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 720);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		campo_Nome = new JTextField();
		campo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Nome.setBounds(10, 74, 316, 27);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cognome.setBounds(10, 136, 316, 27);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_DataNascita = new JTextField();
		campo_DataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_DataNascita.setBounds(10, 198, 188, 27);
		pannello_Principale.add(campo_DataNascita);
		campo_DataNascita.setColumns(10);
		
		comboBox_Sesso = new JComboBox();
		comboBox_Sesso.setModel(new DefaultComboBoxModel(new String[] {"Maschio", "Femmina", "Altro"}));
		comboBox_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_Sesso.setBounds(222, 198, 104, 27);
		pannello_Principale.add(comboBox_Sesso);
		
		campo_NumeroDocumento = new JTextField();
		campo_NumeroDocumento.setEditable(false);
		campo_NumeroDocumento.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_NumeroDocumento.setBounds(10, 260, 316, 27);
		pannello_Principale.add(campo_NumeroDocumento);
		campo_NumeroDocumento.setColumns(10);
		
		campo_CittaNatale = new JTextField();
		campo_CittaNatale.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_CittaNatale.setBounds(10, 322, 188, 27);
		pannello_Principale.add(campo_CittaNatale);
		campo_CittaNatale.setColumns(10);
		
		comboBox_ProvinciaNatale = new JComboBox();
		comboBox_ProvinciaNatale.setModel(new DefaultComboBoxModel(new String[] {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "ROMA", "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT", "ALTRO"}));
		comboBox_ProvinciaNatale.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_ProvinciaNatale.setBounds(222, 322, 104, 27);
		pannello_Principale.add(comboBox_ProvinciaNatale);
		
		campo_CittaResidenza = new JTextField();
		campo_CittaResidenza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_CittaResidenza.setBounds(10, 384, 188, 27);
		pannello_Principale.add(campo_CittaResidenza);
		campo_CittaResidenza.setColumns(10);
		
		comboBox_ProvinciaResidenza = new JComboBox();
		comboBox_ProvinciaResidenza.setModel(new DefaultComboBoxModel(new String[] {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "ROMA", "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT", "ALTRO"}));
		comboBox_ProvinciaResidenza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_ProvinciaResidenza.setBounds(222, 386, 104, 27);
		pannello_Principale.add(comboBox_ProvinciaResidenza);
		
		campo_Email = new JTextField();
		campo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Email.setBounds(10, 446, 316, 27);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Telefono.setBounds(10, 508, 316, 27);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		comboBox_Ristorante = new JComboBox();
		comboBox_Ristorante.setModel(new DefaultComboBoxModel<String>(c.riempiComboRistoranti().toArray(new String[0])));
		comboBox_Ristorante.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_Ristorante.setBounds(10, 568, 316, 27);
		pannello_Principale.add(comboBox_Ristorante);
		
		JLabel etichetta_Cameriere = new JLabel("CAMERIERE");
		etichetta_Cameriere.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Cameriere.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Cameriere.setBounds(133, 11, 257, 30);
		pannello_Principale.add(etichetta_Cameriere);
		
		JLabel etichetta_Nome = new JLabel("Nome (*)");
		etichetta_Nome.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/usericon.png")));
		etichetta_Nome.setForeground(new Color(0, 0, 127));
		etichetta_Nome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Nome.setBounds(10, 49, 223, 27);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome (*)");
		etichetta_Cognome.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/usericon.png")));
		etichetta_Cognome.setForeground(new Color(0, 0, 127));
		etichetta_Cognome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cognome.setBounds(10, 111, 223, 27);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_DataNascita = new JLabel("Data di nascita (*)");
		etichetta_DataNascita.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/DataEOraIcon.png")));
		etichetta_DataNascita.setForeground(new Color(0, 0, 127));
		etichetta_DataNascita.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_DataNascita.setBounds(10, 173, 223, 27);
		pannello_Principale.add(etichetta_DataNascita);
		
		JLabel etichetta_Sesso = new JLabel("Sesso (*)");
		etichetta_Sesso.setForeground(new Color(0, 0, 127));
		etichetta_Sesso.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Sesso.setBounds(222, 174, 199, 27);
		pannello_Principale.add(etichetta_Sesso);
		
		JLabel etichetta_NumeroDocumento = new JLabel("Numero Documento (*)");
		etichetta_NumeroDocumento.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/usericon.png")));
		etichetta_NumeroDocumento.setForeground(new Color(0, 0, 127));
		etichetta_NumeroDocumento.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_NumeroDocumento.setBounds(10, 235, 238, 27);
		pannello_Principale.add(etichetta_NumeroDocumento);
		
		JLabel etichetta_CittaNatale = new JLabel("Città natale (*)");
		etichetta_CittaNatale.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/cityIcon.png")));
		etichetta_CittaNatale.setForeground(new Color(0, 0, 127));
		etichetta_CittaNatale.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_CittaNatale.setBounds(10, 297, 188, 27);
		pannello_Principale.add(etichetta_CittaNatale);
		
		JLabel etichetta_ProvinciaNatale = new JLabel("Provincia natale (*)");
		etichetta_ProvinciaNatale.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/capIcon.png")));
		etichetta_ProvinciaNatale.setForeground(new Color(0, 0, 127));
		etichetta_ProvinciaNatale.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_ProvinciaNatale.setBounds(222, 298, 199, 27);
		pannello_Principale.add(etichetta_ProvinciaNatale);
		
		JLabel etichetta_CittaResidenza = new JLabel("Città residenza  (*)");
		etichetta_CittaResidenza.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/cityIcon.png")));
		etichetta_CittaResidenza.setForeground(new Color(0, 0, 127));
		etichetta_CittaResidenza.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_CittaResidenza.setBounds(10, 359, 188, 27);
		pannello_Principale.add(etichetta_CittaResidenza);
		
		JLabel etichetta_ProvinciaResidenza = new JLabel("Provincia residenza (*)");
		etichetta_ProvinciaResidenza.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/capIcon.png")));
		etichetta_ProvinciaResidenza.setForeground(new Color(0, 0, 127));
		etichetta_ProvinciaResidenza.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_ProvinciaResidenza.setBounds(222, 361, 216, 27);
		pannello_Principale.add(etichetta_ProvinciaResidenza);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/mailicon.png")));
		etichetta_Email.setForeground(new Color(0, 0, 127));
		etichetta_Email.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Email.setBounds(10, 421, 223, 27);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Telefono = new JLabel("Telefono (*)");
		etichetta_Telefono.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/telephoneIcon.png")));
		etichetta_Telefono.setForeground(new Color(0, 0, 127));
		etichetta_Telefono.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Telefono.setBounds(10, 483, 223, 27);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel lblCampoNomeEmpty = new JLabel("");
		lblCampoNomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNomeEmpty.setBounds(344, 73, 180, 27);
		pannello_Principale.add(lblCampoNomeEmpty);
		
		JLabel lblCampoCognomeEmpty = new JLabel("");
		lblCampoCognomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCognomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCognomeEmpty.setBounds(344, 135, 180, 27);
		pannello_Principale.add(lblCampoCognomeEmpty);
		
		JLabel lblCampoDataDiNascitaEmpty = new JLabel("");
		lblCampoDataDiNascitaEmpty.setForeground(new Color(47, 79, 79));
		lblCampoDataDiNascitaEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoDataDiNascitaEmpty.setBounds(344, 198, 180, 27);
		pannello_Principale.add(lblCampoDataDiNascitaEmpty);
		
		JLabel lblCampoNumeroDocumentoEmpty = new JLabel("");
		lblCampoNumeroDocumentoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNumeroDocumentoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNumeroDocumentoEmpty.setBounds(344, 260, 180, 27);
		pannello_Principale.add(lblCampoNumeroDocumentoEmpty);
		
		JLabel lblCampoNataleEmpty = new JLabel("");
		lblCampoNataleEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNataleEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNataleEmpty.setBounds(344, 322, 180, 27);
		pannello_Principale.add(lblCampoNataleEmpty);
		
		JLabel lblCampoResidenzaEmpty = new JLabel("");
		lblCampoResidenzaEmpty.setForeground(new Color(47, 79, 79));
		lblCampoResidenzaEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoResidenzaEmpty.setBounds(344, 384, 180, 27);
		pannello_Principale.add(lblCampoResidenzaEmpty);
		
		
		
		JLabel etichetta_Ristorante = new JLabel("Ristorante (*)");
		etichetta_Ristorante.setForeground(new Color(0, 0, 127));
		etichetta_Ristorante.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Ristorante.setBounds(10, 546, 223, 27);
		pannello_Principale.add(etichetta_Ristorante);
		
		JLabel lblCampoTelefonoEmpty = new JLabel("");
		lblCampoTelefonoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoTelefonoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoTelefonoEmpty.setBounds(344, 508, 180, 27);
		pannello_Principale.add(lblCampoTelefonoEmpty);
		
		JLabel lblCampoRistoranteEmpty = new JLabel("");
		lblCampoRistoranteEmpty.setForeground(new Color(47, 79, 79));
		lblCampoRistoranteEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoRistoranteEmpty.setBounds(344, 568, 180, 27);
		pannello_Principale.add(lblCampoRistoranteEmpty);
		
		JButton bottone_Aggiungi = new JButton("");
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler inserire il nuovo Cameriere?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
					lblCampoNumeroDocumentoEmpty.setText("* Campo obbligatorio");
					lblCampoDataDiNascitaEmpty.setText("* Campo obbligatorio");
					lblCampoNataleEmpty.setText("* Campo obbligatorio");
					lblCampoResidenzaEmpty.setText("* Campo obbligatorio");
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else if(campo_Nome.getText().trim().isEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_Cognome.getText().trim().isEmpty()) {
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_DataNascita.getText().trim().isEmpty()) {
					lblCampoDataDiNascitaEmpty.setText("* Campo obbligatorio");
				} else if (campo_NumeroDocumento.getText().trim().isEmpty()) {
					lblCampoNumeroDocumentoEmpty.setText("* Campo obbligatorio");
				} else if (campo_CittaNatale.getText().trim().isEmpty()) {
					lblCampoNataleEmpty.setText("* Campo obbligatorio");
				} else if (campo_CittaResidenza.getText().trim().isEmpty()) {
					lblCampoResidenzaEmpty.setText("* Campo obbligatorio");
				} else if(campo_Telefono.getText().trim().isEmpty()) {
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else {
					
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) {
						c.updateCameriere(campo_NumeroDocumento.getText(), campo_Nome.getText(), campo_Cognome.getText(), campo_DataNascita.getText(), comboBox_Sesso.getSelectedItem().toString(), campo_CittaNatale.getText(), comboBox_ProvinciaNatale.getSelectedItem().toString(), campo_CittaResidenza.getText(), comboBox_ProvinciaResidenza.getSelectedItem().toString(), campo_Telefono.getText(), campo_Email.getText(),comboBox_Ristorante.getSelectedItem().toString());
						flushTextfields();
						setVisible(false);
						c.startGestionePersonale();
						c.riempiTabllaCamerieriGestione();
						c.riempiTabllaManagerGestione();
					}
				}
			}
		});
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(AggiungiCameriereFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					if(proprietario) {
						setVisible(false);
						c.startGestionePersonale();
						c.riempiTabllaCamerieriGestione();
						c.riempiTabllaManagerGestione();
					}
				}
			}
		});
		bottone_Annulla.setBounds(24, 607, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		bottone_Aggiungi.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setBounds(337, 607, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
	}
	
	
	public JTextField getCampo_Nome() {
		return campo_Nome;
	}


	public void setCampo_Nome(JTextField campo_Nome) {
		this.campo_Nome = campo_Nome;
	}


	public JTextField getCampo_DataNascita() {
		return campo_DataNascita;
	}


	public void setCampo_DataNascita(JTextField campo_DataNascita) {
		this.campo_DataNascita = campo_DataNascita;
	}


	public JTextField getCampo_NumeroDocumento() {
		return campo_NumeroDocumento;
	}


	public void setCampo_NumeroDocumento(JTextField campo_NumeroDocumento) {
		this.campo_NumeroDocumento = campo_NumeroDocumento;
	}


	public JTextField getCampo_CittaNatale() {
		return campo_CittaNatale;
	}


	public void setCampo_CittaNatale(JTextField campo_CittaNatale) {
		this.campo_CittaNatale = campo_CittaNatale;
	}


	public JTextField getCampo_CittaResidenza() {
		return campo_CittaResidenza;
	}


	public void setCampo_CittaResidenza(JTextField campo_CittaResidenza) {
		this.campo_CittaResidenza = campo_CittaResidenza;
	}


	public JTextField getCampo_Telefono() {
		return campo_Telefono;
	}


	public void setCampo_Telefono(JTextField campo_Telefono) {
		this.campo_Telefono = campo_Telefono;
	}


	public JTextField getCampo_Email() {
		return campo_Email;
	}


	public void setCampo_Email(JTextField campo_Email) {
		this.campo_Email = campo_Email;
	}


	public JTextField getCampo_Cognome() {
		return campo_Cognome;
	}


	public void setCampo_Cognome(JTextField campo_Cognome) {
		this.campo_Cognome = campo_Cognome;
	}


	public JComboBox getComboBox_Sesso() {
		return comboBox_Sesso;
	}


	public void setComboBox_Sesso(JComboBox comboBox_Sesso) {
		this.comboBox_Sesso = comboBox_Sesso;
	}


	public JComboBox getComboBox_ProvinciaNatale() {
		return comboBox_ProvinciaNatale;
	}


	public void setComboBox_ProvinciaNatale(JComboBox comboBox_ProvinciaNatale) {
		this.comboBox_ProvinciaNatale = comboBox_ProvinciaNatale;
	}


	public JComboBox getComboBox_ProvinciaResidenza() {
		return comboBox_ProvinciaResidenza;
	}


	public void setComboBox_ProvinciaResidenza(JComboBox comboBox_ProvinciaResidenza) {
		this.comboBox_ProvinciaResidenza = comboBox_ProvinciaResidenza;
	}


	public JComboBox getComboBox_Ristorante() {
		return comboBox_Ristorante;
	}


	public void setComboBox_Ristorante(JComboBox comboBox_Ristorante) {
		this.comboBox_Ristorante = comboBox_Ristorante;
	}


	public void flushTextfields() {
		campo_CittaNatale.setText("");
		campo_CittaResidenza.setText("");
		campo_Cognome.setText("");
		campo_DataNascita.setText("");
		campo_Email.setText("");
		campo_Nome.setText("");
		campo_NumeroDocumento.setText("");
		campo_Telefono.setText("");
	}
	
	public boolean areTextfieldsEmpty() {
		return campo_CittaNatale.getText().trim().isEmpty() &&
		campo_CittaResidenza.getText().trim().isEmpty() &&
		campo_Cognome.getText().trim().isEmpty() &&
		campo_DataNascita.getText().trim().isEmpty() &&
		campo_Email.getText().trim().isEmpty() &&
		campo_Nome.getText().trim().isEmpty() &&
		campo_NumeroDocumento.getText().trim().isEmpty() &&
		campo_Telefono.getText().trim().isEmpty();
	}
}
