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
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import controller.Controller;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AggiungiAvventoreFrame extends JFrame {

	private Controller theController;
	private JPanel pannello_Principale;
	private JTextField campo_NumCid;
	private JTextField campo_Nome;
	private JTextField campo_Cognome;
	private JDateChooser campo_DataNascita;
	private JComboBox campo_Sesso;
	private JTextField campo_CittaNascita;
	private JTextField campo_CittaResidenza;
	private JComboBox campo_ProvNascita;
	private JComboBox campo_ProvResidenza;
	private JTextField campo_Telefono;
	private JTextField campo_Email;
	private JSpinner campo_Temperatura;
	private JComboBox campo_Greenpass;

	public AggiungiAvventoreFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaAvventoreFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Gestione Sale e Tavolate - Aggiungi avventore");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1130, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Avventori = new JLabel("");
		etichetta_Avventori.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/aggiungiAvventoreTitle.png")));
		etichetta_Avventori.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Avventori.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Avventori.setBounds(305, 11, 504, 60);
		pannello_Principale.add(etichetta_Avventori);
		
		JLabel etichetta_NumCid = new JLabel("Numero carta identita' (*)");
		etichetta_NumCid.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_NumCid.setForeground(new Color(0, 0, 128));
		etichetta_NumCid.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_NumCid.setBounds(20, 82, 316, 27);
		pannello_Principale.add(etichetta_NumCid);
		
		JLabel etichetta_Nome = new JLabel("Nome (*)");
		etichetta_Nome.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_Nome.setForeground(new Color(0, 0, 128));
		etichetta_Nome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Nome.setBounds(20, 152, 223, 27);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome (*)");
		etichetta_Cognome.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_Cognome.setForeground(new Color(0, 0, 128));
		etichetta_Cognome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cognome.setBounds(20, 222, 223, 27);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_DataNascita = new JLabel("Data di nascita (*)");
		etichetta_DataNascita.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/iconCalendar.png")));
		etichetta_DataNascita.setForeground(new Color(0, 0, 128));
		etichetta_DataNascita.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_DataNascita.setBounds(20, 292, 188, 27);
		pannello_Principale.add(etichetta_DataNascita);
		
		JLabel etichetta_Sesso = new JLabel("Sesso (*)");
		etichetta_Sesso.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_Sesso.setForeground(new Color(0, 0, 128));
		etichetta_Sesso.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Sesso.setBounds(20, 362, 223, 27);
		pannello_Principale.add(etichetta_Sesso);
		
		JLabel etichetta_CittaNascita = new JLabel("Citt\u00E0 nascita (*)");
		etichetta_CittaNascita.setForeground(new Color(0, 0, 128));
		etichetta_CittaNascita.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_CittaNascita.setBounds(20, 432, 172, 27);
		pannello_Principale.add(etichetta_CittaNascita);
		
		JLabel etichetta_ProvNascita = new JLabel("Provincia (*)");
		etichetta_ProvNascita.setForeground(new Color(0, 0, 128));
		etichetta_ProvNascita.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_ProvNascita.setBounds(228, 430, 172, 27);
		pannello_Principale.add(etichetta_ProvNascita);
		
		JLabel etichetta_CittaResidenza = new JLabel("Citt\u00E0 residenza (*)");
		etichetta_CittaResidenza.setForeground(new Color(0, 0, 128));
		etichetta_CittaResidenza.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_CittaResidenza.setBounds(20, 501, 172, 27);
		pannello_Principale.add(etichetta_CittaResidenza);
		
		JLabel etichetta_ProvinciaResidenza = new JLabel("Provincia (*)");
		etichetta_ProvinciaResidenza.setForeground(new Color(0, 0, 128));
		etichetta_ProvinciaResidenza.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_ProvinciaResidenza.setBounds(228, 501, 172, 27);
		pannello_Principale.add(etichetta_ProvinciaResidenza);
		
		JLabel etichetta_Telefono = new JLabel("Telefono (*)");
		etichetta_Telefono.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/telephoneIcon.png")));
		etichetta_Telefono.setForeground(new Color(0, 0, 128));
		etichetta_Telefono.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Telefono.setBounds(576, 82, 223, 27);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_Temperatura = new JLabel("Temperatura corporea (\u00B0)");
		etichetta_Temperatura.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_Temperatura.setForeground(new Color(0, 0, 128));
		etichetta_Temperatura.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Temperatura.setBounds(576, 222, 263, 27);
		pannello_Principale.add(etichetta_Temperatura);
		
		JLabel etichetta_Greenpass = new JLabel("Possiede Greenpass?");
		etichetta_Greenpass.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/usericon.png")));
		etichetta_Greenpass.setForeground(new Color(0, 0, 128));
		etichetta_Greenpass.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Greenpass.setBounds(576, 292, 223, 27);
		pannello_Principale.add(etichetta_Greenpass);
		
		JLabel lblCampoNumcidEmpty = new JLabel("");
		lblCampoNumcidEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNumcidEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNumcidEmpty.setBounds(344, 112, 180, 27);
		pannello_Principale.add(lblCampoNumcidEmpty);
		
		JLabel lblCampoNomeEmpty = new JLabel("");
		lblCampoNomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNomeEmpty.setBounds(344, 182, 180, 27);
		pannello_Principale.add(lblCampoNomeEmpty);
		
		JLabel lblCampoCognomeEmpty = new JLabel("");
		lblCampoCognomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCognomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCognomeEmpty.setBounds(344, 252, 180, 27);
		pannello_Principale.add(lblCampoCognomeEmpty);
		
		JLabel lblCampoCittaNascitaEmpty = new JLabel("");
		lblCampoCittaNascitaEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCittaNascitaEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCittaNascitaEmpty.setBounds(344, 460, 180, 27);
		pannello_Principale.add(lblCampoCittaNascitaEmpty);
		
		JLabel lblCampoCittaResidenzaEmpty = new JLabel("");
		lblCampoCittaResidenzaEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCittaResidenzaEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCittaResidenzaEmpty.setBounds(344, 529, 180, 27);
		pannello_Principale.add(lblCampoCittaResidenzaEmpty);
		
		JLabel lblCampoTelefonoEmpty = new JLabel("");
		lblCampoTelefonoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoTelefonoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoTelefonoEmpty.setBounds(900, 112, 180, 27);
		pannello_Principale.add(lblCampoTelefonoEmpty);
		
		JLabel lblImmagineAvventori = new JLabel("");
		lblImmagineAvventori.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/avventoriImage.png")));
		lblImmagineAvventori.setBounds(501, 362, 333, 333);
		pannello_Principale.add(lblImmagineAvventori);
		
		campo_NumCid = new JTextField();
		campo_NumCid.setToolTipText("Deve contenere al massimo 9 caratteri");
		campo_NumCid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoNumcidEmpty.setText("");
			}
		});
		campo_NumCid.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_NumCid.setBounds(20, 112, 316, 27);
		pannello_Principale.add(campo_NumCid);
		campo_NumCid.setColumns(10);
		
		campo_Nome = new JTextField();
		campo_Nome.setToolTipText("Nome avventore");
		campo_Nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoNomeEmpty.setText("");
			}
		});
		campo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Nome.setBounds(22, 182, 314, 27);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setToolTipText("Cognome avventore");
		campo_Cognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCognomeEmpty.setText("");
			}
		});
		campo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cognome.setBounds(22, 252, 314, 27);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		Date date = new Date();
		campo_DataNascita = new JDateChooser();
		campo_DataNascita.setToolTipText("Scegliere una data di nascita");
		campo_DataNascita.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_DataNascita.setDate(date);
		campo_DataNascita.setDateFormatString("dd/MM/yyyy");
		campo_DataNascita.setBounds(20, 322, 188, 27);
		pannello_Principale.add(campo_DataNascita);
		
		campo_Sesso = new JComboBox();
		campo_Sesso.setModel(new DefaultComboBoxModel(new String[] {"Maschio", "Femmina", "Non specificato"}));
		campo_Sesso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Sesso.setBounds(20, 392, 188, 27);
		pannello_Principale.add(campo_Sesso);
		
		campo_CittaNascita = new JTextField();
		campo_CittaNascita.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCittaNascitaEmpty.setText("");
			}
		});
		campo_CittaNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_CittaNascita.setColumns(10);
		campo_CittaNascita.setBounds(20, 462, 188, 27);
		pannello_Principale.add(campo_CittaNascita);
		
		campo_ProvNascita = new JComboBox();
		campo_ProvNascita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_ProvNascita.setModel(new DefaultComboBoxModel(new String[] {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "ROMA", "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT", "ALTRO"}));
		campo_ProvNascita.setSelectedItem("NA");
		campo_ProvNascita.setBounds(232, 460, 104, 27);
		pannello_Principale.add(campo_ProvNascita);
		
		campo_CittaResidenza = new JTextField();
		campo_CittaResidenza.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCittaResidenzaEmpty.setText("");
			}
		});
		campo_CittaResidenza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_CittaResidenza.setColumns(10);
		campo_CittaResidenza.setBounds(20, 532, 188, 27);
		pannello_Principale.add(campo_CittaResidenza);
		
		campo_ProvResidenza = new JComboBox();
		campo_ProvResidenza.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_ProvResidenza.setModel(new DefaultComboBoxModel(new String[] {"AG", "AL", "AN", "AO", "AQ", "AR", "AP", "AT", "AV", "BA", "BT", "BL", "BN", "BG", "BI", "BO", "BZ", "BS", "BR", "CA", "CL", "CB", "CI", "CE", "CT", "CZ", "CH", "CO", "CS", "CR", "KR", "CN", "EN", "FM", "FE", "FI", "FG", "FC", "FR", "GE", "GO", "GR", "IM", "IS", "SP", "LT", "LE", "LC", "LI", "LO", "LU", "MC", "MN", "MS", "MT", "VS", "ME", "MI", "MO", "MB", "NA", "NO", "NU", "OG", "OT", "OR", "PD", "PA", "PR", "PV", "PG", "PU", "PE", "PC", "PI", "PT", "PN", "PZ", "PO", "RG", "RA", "RC", "RE", "RI", "RN", "ROMA", "RO", "SA", "SS", "SV", "SI", "SR", "SO", "TA", "TE", "TR", "TO", "TP", "TN", "TV", "TS", "UD", "VA", "VE", "VB", "VC", "VR", "VV", "VI", "VT", "ALTRO"}));
		campo_ProvResidenza.setSelectedItem("NA");
		campo_ProvResidenza.setBounds(228, 532, 104, 27);
		pannello_Principale.add(campo_ProvResidenza);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setToolTipText("Sono ammesse cifre numeriche ed il carattere +");
		campo_Telefono.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoTelefonoEmpty.setText("");
			}
		});
		campo_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Telefono.setColumns(10);
		campo_Telefono.setBounds(576, 112, 316, 27);
		pannello_Principale.add(campo_Telefono);
		
		campo_Email = new JTextField();
		campo_Email.setToolTipText("Deve rispettare la forma 'example@mail.domain'");
		campo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Email.setColumns(10);
		campo_Email.setBounds(576, 182, 316, 27);
		pannello_Principale.add(campo_Email);
		
		double min = 35.0;
	    double value = 35.0;
	    double max = 42.0;
	    double stepSize = 0.1;
	    SpinnerNumberModel model = new SpinnerNumberModel(value, min, max, stepSize);
		campo_Temperatura = new JSpinner(model);
		campo_Temperatura.setToolTipText("La temperatura e' espressa in gradi Celsius da 35 a 42 ");
	    JSpinner.NumberEditor editor = (JSpinner.NumberEditor)campo_Temperatura.getEditor();
	    DecimalFormat format = editor.getFormat();
		campo_Temperatura.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		((DefaultEditor)campo_Temperatura.getEditor()).getTextField().setEditable(false);
		campo_Temperatura.setBounds(578, 252, 186, 27);
		pannello_Principale.add(campo_Temperatura);
		
		campo_Greenpass = new JComboBox();
		campo_Greenpass.setToolTipText("Indicare se l'avventore \u00E8 provvisto di certificazione (Vero o Falso)");
		campo_Greenpass.setModel(new DefaultComboBoxModel(new String[] {"V", "F"}));
		campo_Greenpass.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Greenpass.setBounds(576, 322, 188, 27);
		pannello_Principale.add(campo_Greenpass);
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnnullaDialog(c);
			}
		});
		bottone_Annulla.setBounds(24, 607, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("");
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler inserire il nuovo avventore alla tavolata?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) {
					lblCampoNumcidEmpty.setText("* Campo obbligatorio");
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
					lblCampoCittaNascitaEmpty.setText("* Campo obbligatorio");
					lblCampoCittaResidenzaEmpty.setText("* Campo obbligatorio");
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else if(campo_NumCid.getText().trim().isEmpty()) {
					lblCampoNumcidEmpty.setText("* Campo obbligatorio");
				} else if(campo_Nome.getText().trim().isEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_Cognome.getText().trim().isEmpty()) {
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
				} else if (campo_CittaNascita.getText().trim().isEmpty()) {
					lblCampoCittaNascitaEmpty.setText("* Campo obbligatorio");
				} else if (campo_CittaResidenza.getText().trim().isEmpty()) {
					lblCampoCittaResidenzaEmpty.setText("* Campo obbligatorio");
				} else if(campo_Telefono.getText().trim().isEmpty()) {
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else {
					
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) {
				
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String dataNascita = dateFormat.format(campo_DataNascita.getDate());
						
						c.insertAvventore(	isProprietario,
											campo_NumCid.getText(),
											campo_Nome.getText(),
											campo_Cognome.getText(),
											dataNascita,
											campo_Sesso.getSelectedItem().toString(),
											campo_CittaNascita.getText(),
											campo_ProvNascita.getSelectedItem().toString(),
											campo_CittaResidenza.getText(),
											campo_ProvResidenza.getSelectedItem().toString(),
											campo_Telefono.getText(),
											campo_Email.getText(),
											Double.parseDouble(campo_Temperatura.getValue().toString()),
											campo_Greenpass.getSelectedItem().toString().charAt(0));
			
						flushTextfields();
						setVisible(false);
						c.mostraGestioneAvventoriFrame();
					}
				}
			}
		});

		bottone_Aggiungi.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setBounds(930, 607, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
		
		JLabel etichetta_Email = new JLabel("Email\r\n");
		etichetta_Email.setIcon(new ImageIcon(AggiungiAvventoreFrame.class.getResource("/resources/mailicon.png")));
		etichetta_Email.setForeground(new Color(0, 0, 128));
		etichetta_Email.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Email.setBounds(576, 152, 223, 27);
		pannello_Principale.add(etichetta_Email);
		
		
	}
	
	private void flushTextfields() {
		campo_NumCid.setText("");
		campo_Nome.setText("");
		campo_Cognome.setText("");
		campo_CittaNascita.setText("");
		campo_CittaResidenza.setText("");
		campo_Telefono.setText("");
	}
	
	private boolean areTextfieldsEmpty() {
		return 	campo_NumCid.getText().trim().isEmpty() && 
				campo_Nome.getText().trim().isEmpty() && 
				campo_Cognome.getText().trim().isEmpty() && 
				campo_CittaNascita.getText().trim().isEmpty() &&
				campo_CittaResidenza.getText().trim().isEmpty() &&
				campo_Telefono.getText().trim().isEmpty();
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare l'inserimento dell'avventore alla tavolata?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneAvventoriFrame();
		}
	}
}
