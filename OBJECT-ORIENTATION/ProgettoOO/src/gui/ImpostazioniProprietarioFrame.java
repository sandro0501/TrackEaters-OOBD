package gui;


import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

import controller.Controller;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ImpostazioniProprietarioFrame extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Username;
	private JTextField campo_Nome;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JPasswordField password_Password;
	private JPasswordField password_ConfermaPassword;
	private Controller theController;

	public ImpostazioniProprietarioFrame(Controller c) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Impostazioni Proprietario");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Impostazioni = new JLabel("");
		etichetta_Impostazioni.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/TitleImpostazioniProprietarioFrame.png")));
		etichetta_Impostazioni.setForeground(new Color(0, 0, 128));
		etichetta_Impostazioni.setFont(new Font("Segoe UI", Font.BOLD, 30));
		etichetta_Impostazioni.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Impostazioni.setBounds(10, 23, 504, 60);
		pannello_Principale.add(etichetta_Impostazioni);
		
		JLabel etichetta_Nome = new JLabel("Nome (*)");
		etichetta_Nome.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/usericon.png")));
		etichetta_Nome.setForeground(new Color(0, 0, 128));
		etichetta_Nome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Nome.setBounds(24, 124, 223, 27);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome (*)");
		etichetta_Cognome.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/usericon.png")));
		etichetta_Cognome.setForeground(new Color(0, 0, 128));
		etichetta_Cognome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cognome.setBounds(24, 194, 223, 27);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/mailicon.png")));
		etichetta_Email.setForeground(new Color(0, 0, 128));
		etichetta_Email.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Email.setBounds(24, 334, 320, 27);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Username = new JLabel("Username (*)");
		etichetta_Username.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/usericon.png")));
		etichetta_Username.setForeground(new Color(0, 0, 128));
		etichetta_Username.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Username.setBounds(24, 264, 223, 27);
		pannello_Principale.add(etichetta_Username);
		
		JLabel etichetta_Password = new JLabel("Password (*)");
		etichetta_Password.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/passwordicon.png")));
		etichetta_Password.setForeground(new Color(0, 0, 128));
		etichetta_Password.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Password.setBounds(24, 404, 223, 27);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_ConfermaPassword = new JLabel("Conferma password (*)");
		etichetta_ConfermaPassword.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/passwordicon.png")));
		etichetta_ConfermaPassword.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_ConfermaPassword.setForeground(new Color(0, 0, 128));
		etichetta_ConfermaPassword.setBounds(24, 498, 223, 27);
		pannello_Principale.add(etichetta_ConfermaPassword);
		
		JLabel lblCampoNomeEmpty = new JLabel("");
		lblCampoNomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNomeEmpty.setBounds(264, 157, 180, 27);
		pannello_Principale.add(lblCampoNomeEmpty);
		
		JLabel lblCampoCognomeEmpty = new JLabel("");
		lblCampoCognomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCognomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCognomeEmpty.setBounds(264, 224, 180, 27);
		pannello_Principale.add(lblCampoCognomeEmpty);
		
		JLabel lblCampoUsernameEmpty = new JLabel("");
		lblCampoUsernameEmpty.setForeground(new Color(47, 79, 79));
		lblCampoUsernameEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoUsernameEmpty.setBounds(264, 294, 180, 27);
		pannello_Principale.add(lblCampoUsernameEmpty);
		
		JLabel lblCampoPasswordEmpty = new JLabel("");
		lblCampoPasswordEmpty.setForeground(new Color(47, 79, 79));
		lblCampoPasswordEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoPasswordEmpty.setBounds(264, 434, 180, 27);
		pannello_Principale.add(lblCampoPasswordEmpty);
		
		JLabel lblCampoConfermaPasswordEmpty = new JLabel("");
		lblCampoConfermaPasswordEmpty.setForeground(new Color(47, 79, 79));
		lblCampoConfermaPasswordEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoConfermaPasswordEmpty.setBounds(264, 528, 250, 27);
		pannello_Principale.add(lblCampoConfermaPasswordEmpty);
		
		JLabel lblDescrizioneImpostazioni = new JLabel("Aggiorna i tuoi dati");
		lblDescrizioneImpostazioni.setForeground(new Color(0, 0, 128));
		lblDescrizioneImpostazioni.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 15));
		lblDescrizioneImpostazioni.setBounds(157, 80, 210, 32);
		pannello_Principale.add(lblDescrizioneImpostazioni);
		
		campo_Nome = new JTextField();
		campo_Nome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoNomeEmpty.setText("");
			}
		});
		campo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Nome.setBounds(24, 154, 230, 27);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoCognomeEmpty.setText("");
			}
		});
		campo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cognome.setBounds(24, 224, 230, 27);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campo_Email.setBounds(24, 364, 343, 27);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		password_ConfermaPassword = new JPasswordField();
		password_ConfermaPassword.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password_ConfermaPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoConfermaPasswordEmpty.setText("");
			}
		});
		password_ConfermaPassword.setBounds(24, 528, 230, 27);
		pannello_Principale.add(password_ConfermaPassword);
		
		password_Password = new JPasswordField();
		password_Password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password_Password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoPasswordEmpty.setText("");	
			}
		});
		password_Password.setBounds(24, 434, 230, 27);
		pannello_Principale.add(password_Password);
		
		campo_Username = new JTextField();
		campo_Username.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblCampoUsernameEmpty.setText("");
			}
		});
		campo_Username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Username.setColumns(10);
		campo_Username.setBounds(24, 294, 230, 27);
		pannello_Principale.add(campo_Username);
		
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnnullaDialog(c);
			}
		});
		bottone_Annulla.setBounds(24, 607, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		
		JButton bottone_Conferma = new JButton("");
		JLabel lblConferma = new JLabel("Sei sicuro di voler confermare le modifiche?");
		lblConferma.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Conferma.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
					lblCampoUsernameEmpty.setText("* Campo obbligatorio");
					lblCampoPasswordEmpty.setText("* Campo obbligatorio");
					lblCampoConfermaPasswordEmpty.setText("* Campo obbligatorio");
				} else if(campo_Nome.getText().trim().isEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_Cognome.getText().trim().isEmpty()) {
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_Username.getText().trim().isEmpty()) {
					lblCampoUsernameEmpty.setText("* Campo obbligatorio");
				} else if(password_Password.getText().trim().isEmpty()) {
					lblCampoPasswordEmpty.setText("* Campo obbligatorio");
				} else if(password_ConfermaPassword.getText().trim().isEmpty()) {
					lblCampoConfermaPasswordEmpty.setText("* Campo obbligatorio");
				} else if(!password_Password.getText().trim().equals(password_ConfermaPassword.getText().trim())) {
					lblCampoConfermaPasswordEmpty.setText("Le due password non corrispondono!");
				} else {
					
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblConferma)==0) {
						c.updateProprietario(campo_Nome.getText(), campo_Cognome.getText(), campo_Username.getText(), campo_Email.getText(), password_Password.getText());
						flushTextfields();
						setVisible(false);
						c.startHomepageProprietarioFrame();
					}
				}
			}
		});
		bottone_Conferma.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/ConfermaBtn.png")));
		bottone_Conferma.setBounds(337, 607, 160, 60);
		pannello_Principale.add(bottone_Conferma);
		
		JLabel lblDescrizionePassword = new JLabel("* Deve contenere almeno 8 caratteri, una lettera e un numero");
		lblDescrizionePassword.setForeground(new Color(0, 0, 128));
		lblDescrizionePassword.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 13));
		lblDescrizionePassword.setBounds(24, 458, 449, 27);
		pannello_Principale.add(lblDescrizionePassword);
	}
	
	private void flushTextfields() {
		campo_Nome.setText("");
		campo_Cognome.setText("");
		campo_Username.setText("");
		campo_Email.setText("");
		password_Password.setText("");
		password_ConfermaPassword.setText("");
	}

	private boolean areTextfieldsEmpty() {
		return 	campo_Nome.getText().trim().isEmpty() && 
				campo_Cognome.getText().trim().isEmpty() && 
				campo_Username.getText().trim().isEmpty() && 
				password_Password.getText().trim().isEmpty() && 
				password_ConfermaPassword.getText().trim().isEmpty();
	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.startHomepageProprietarioFrame();
		}
	}

}
