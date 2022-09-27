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

public class ModificaManagerFrame extends JFrame {

	private JPanel pannello_Principale;
	private JTextField campo_Nome;
	private JTextField campo_Telefono;
	private JTextField campo_Email;
	private JTextField campo_Cognome;
	private JComboBox comboBox_Ristorante;
	private JPasswordField password_Password;
	private Controller theController;
	private JTextField campo_Username;

	
	public ModificaManagerFrame(Controller c) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaManagerFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Modifica manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Manager = new JLabel("");
		etichetta_Manager.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/modificaManagerTitle.png")));
		etichetta_Manager.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Manager.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Manager.setBounds(10, 11, 504, 60);
		pannello_Principale.add(etichetta_Manager);
		
		JLabel etichetta_Username = new JLabel("Username (*)");
		etichetta_Username.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/usericon.png")));
		etichetta_Username.setForeground(new Color(0, 0, 127));
		etichetta_Username.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Username.setBounds(10, 126, 223, 27);
		pannello_Principale.add(etichetta_Username);
		
		JLabel etichetta_Nome = new JLabel("Nome (*)");
		etichetta_Nome.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/usericon.png")));
		etichetta_Nome.setForeground(new Color(0, 0, 127));
		etichetta_Nome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Nome.setBounds(10, 191, 223, 27);
		pannello_Principale.add(etichetta_Nome);
		
		JLabel etichetta_Cognome = new JLabel("Cognome (*)");
		etichetta_Cognome.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/usericon.png")));
		etichetta_Cognome.setForeground(new Color(0, 0, 127));
		etichetta_Cognome.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cognome.setBounds(10, 257, 223, 27);
		pannello_Principale.add(etichetta_Cognome);
		
		JLabel etichetta_Email = new JLabel("Email");
		etichetta_Email.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/mailicon.png")));
		etichetta_Email.setForeground(new Color(0, 0, 127));
		etichetta_Email.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Email.setBounds(10, 323, 223, 27);
		pannello_Principale.add(etichetta_Email);
		
		JLabel etichetta_Password = new JLabel("Password (*)");
		etichetta_Password.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/passwordicon.png")));
		etichetta_Password.setForeground(new Color(0, 0, 127));
		etichetta_Password.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Password.setBounds(10, 389, 223, 27);
		pannello_Principale.add(etichetta_Password);
		
		JLabel etichetta_Telefono = new JLabel("Telefono (*)");
		etichetta_Telefono.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/telephoneIcon.png")));
		etichetta_Telefono.setForeground(new Color(0, 0, 127));
		etichetta_Telefono.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Telefono.setBounds(10, 451, 223, 27);
		pannello_Principale.add(etichetta_Telefono);
		
		JLabel etichetta_Ristorante = new JLabel("Ristorante");
		etichetta_Ristorante.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/restaurantIcon.png")));
		etichetta_Ristorante.setForeground(new Color(0, 0, 127));
		etichetta_Ristorante.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Ristorante.setBounds(10, 517, 223, 27);
		pannello_Principale.add(etichetta_Ristorante);
		
		campo_Username = new JTextField();
		campo_Username.setEditable(false);
		campo_Username.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Username.setColumns(10);
		campo_Username.setBounds(10, 153, 316, 27);
		pannello_Principale.add(campo_Username);
		
		campo_Nome = new JTextField();
		campo_Nome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Nome.setBounds(10, 216, 316, 27);
		pannello_Principale.add(campo_Nome);
		campo_Nome.setColumns(10);
		
		campo_Cognome = new JTextField();
		campo_Cognome.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cognome.setBounds(10, 282, 316, 27);
		pannello_Principale.add(campo_Cognome);
		campo_Cognome.setColumns(10);
		
		campo_Email = new JTextField();
		campo_Email.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Email.setBounds(10, 348, 316, 27);
		pannello_Principale.add(campo_Email);
		campo_Email.setColumns(10);
		
		password_Password = new JPasswordField();
		password_Password.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		password_Password.setBounds(10, 414, 316, 27);
		pannello_Principale.add(password_Password);
		
		campo_Telefono = new JTextField();
		campo_Telefono.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Telefono.setBounds(10, 476, 316, 27);
		pannello_Principale.add(campo_Telefono);
		campo_Telefono.setColumns(10);
		
		comboBox_Ristorante = new JComboBox();
		comboBox_Ristorante.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		comboBox_Ristorante.setBounds(10, 542, 316, 27);
		comboBox_Ristorante.setModel(new DefaultComboBoxModel<String>(c.riempiComboBoxRistoranti().toArray(new String[0])));
		pannello_Principale.add(comboBox_Ristorante);
		
		JLabel lblCampoUsernameEmpty = new JLabel("");
		lblCampoUsernameEmpty.setForeground(new Color(47, 79, 79));
		lblCampoUsernameEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoUsernameEmpty.setBounds(343, 153, 180, 27);
		pannello_Principale.add(lblCampoUsernameEmpty);
		
		JLabel lblCampoNomeEmpty = new JLabel("");
		lblCampoNomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoNomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoNomeEmpty.setBounds(343, 216, 180, 27);
		pannello_Principale.add(lblCampoNomeEmpty);
		
		JLabel lblCampoCognomeEmpty = new JLabel("");
		lblCampoCognomeEmpty.setForeground(new Color(47, 79, 79));
		lblCampoCognomeEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoCognomeEmpty.setBounds(343, 282, 180, 27);
		pannello_Principale.add(lblCampoCognomeEmpty);
		
		JLabel lblCampoPasswordEmpty = new JLabel("");
		lblCampoPasswordEmpty.setForeground(new Color(47, 79, 79));
		lblCampoPasswordEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoPasswordEmpty.setBounds(344, 414, 180, 27);
		pannello_Principale.add(lblCampoPasswordEmpty);
		
		JLabel lblCampoTelefonoEmpty = new JLabel("");
		lblCampoTelefonoEmpty.setForeground(new Color(47, 79, 79));
		lblCampoTelefonoEmpty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 14));
		lblCampoTelefonoEmpty.setBounds(343, 476, 180, 27);
		pannello_Principale.add(lblCampoTelefonoEmpty);
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.showConfirmDialog(pannello_Principale, "Sei sicuro di voler annullare?")==0) {
					setVisible(false);
					c.mostraGestionePersonaleFrame();
					c.riempiTabellaCamerieriPerGestionePersonale();
					c.riempiTabellaManagerRistorantePerGestionePersonale();
				}
			}
		});
		bottone_Annulla.setBounds(24, 607, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Modifica = new JButton("");
		JLabel lblConferma = new JLabel("Sei sicuro di voler modificare il Manager?");
		lblConferma.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Modifica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(areTextfieldsEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
					lblCampoPasswordEmpty.setText("* Campo obbligatorio");
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else if(campo_Nome.getText().trim().isEmpty()) {
					lblCampoNomeEmpty.setText("* Campo obbligatorio");
				} else if(campo_Cognome.getText().trim().isEmpty()) {
					lblCampoCognomeEmpty.setText("* Campo obbligatorio");
				} else if (password_Password.getText().trim().isEmpty()) {
					lblCampoPasswordEmpty.setText("* Campo obbligatorio");
				} else if(campo_Telefono.getText().trim().isEmpty()) {
					lblCampoTelefonoEmpty.setText("* Campo obbligatorio");
				} else {
					
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblConferma)==0) {
						c.modificaManager(campo_Username.getText(), password_Password.getText(), campo_Nome.getText(), campo_Cognome.getText(), campo_Telefono.getText(), campo_Email.getText(), comboBox_Ristorante.getSelectedItem().toString());
						flushTextfields();
						setVisible(false);
						c.mostraGestionePersonaleFrame();
						c.riempiTabellaCamerieriPerGestionePersonale();
						c.riempiTabellaManagerRistorantePerGestionePersonale();
					}
				}
			}
		});
		bottone_Modifica.setIcon(new ImageIcon(ModificaManagerFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Modifica.setBounds(337, 607, 160, 60);
		pannello_Principale.add(bottone_Modifica);
		
		
	}
	
	public JComboBox getComboBox_Ristorante() {
		return comboBox_Ristorante;
	}

	public void setComboBox_Ristorante(JComboBox comboBox_Ristorante) {
		this.comboBox_Ristorante = comboBox_Ristorante;
	}

	public JTextField getCampo_Username() {
		return campo_Username;
	}

	public void setCampo_Username(JTextField campo_Username) {
		this.campo_Username = campo_Username;
	}

	public JPanel getPannello_Principale() {
		return pannello_Principale;
	}

	public void setPannello_Principale(JPanel pannello_Principale) {
		this.pannello_Principale = pannello_Principale;
	}

	public JTextField getCampo_Nome() {
		return campo_Nome;
	}

	public void setCampo_Nome(JTextField campo_Nome) {
		this.campo_Nome = campo_Nome;
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


	public JPasswordField getPassword_Password() {
		return password_Password;
	}

	public void setPassword_Password(JPasswordField password_Password) {
		this.password_Password = password_Password;
	}

	public void flushTextfields() {
		campo_Cognome.setText("");
		campo_Nome.setText("");
		campo_Telefono.setText("");
		password_Password.setText("");
	}
	
	public boolean areTextfieldsEmpty() {
		return	campo_Cognome.getText().trim().isEmpty() &&
				campo_Nome.getText().trim().isEmpty() &&
				campo_Telefono.getText().trim().isEmpty() &&
				password_Password.getText().trim().isEmpty();
	}
}