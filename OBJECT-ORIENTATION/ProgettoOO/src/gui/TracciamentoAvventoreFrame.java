package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextPane;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import controller.Controller;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TracciamentoAvventoreFrame extends JFrame {

	private JPanel pannello_Principale;
	private Controller theController;
	private JLabel lblDataEOra;
	private JLabel lblNumeroCartaDidentita;
	private JLabel lblNome;
	private JLabel lblCognome;
	private JLabel lblDataDiNascita;
	private JLabel lblSesso;
	private JLabel lblCittaDiNascita;
	private JLabel lblProvinciaDiNascita;
	private JLabel lblCittaDiResidenza;
	private JLabel lblProvinciaDiResidenza;
	private JLabel lblTelefono;
	private JLabel lblEmail;
	private JLabel lblTemperaturaRegistrata;
	private JLabel lblProvvistoDiGreenpass;
		
	public TracciamentoAvventoreFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setTitle("TrackEaters - Tracciamento avventore positivo");
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestioneCasiCovidFrame.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_GestioneCasiCovid = new JLabel("");
		etichetta_GestioneCasiCovid.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/tracciamentoAvventoretitle.png")));
		etichetta_GestioneCasiCovid.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_GestioneCasiCovid.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_GestioneCasiCovid.setBounds(387, 11, 490, 52);
		pannello_Principale.add(etichetta_GestioneCasiCovid);
		
		JPanel pannello_Navigazione = new JPanel();
		pannello_Navigazione.setForeground(new Color(0, 0, 128));
		pannello_Navigazione.setBackground(new Color(176, 196, 222));
		pannello_Navigazione.setBounds(0, 597, 1264, 84);
		pannello_Navigazione.setBorder(new LineBorder(new Color(119, 136, 153), 2));
		pannello_Principale.add(pannello_Navigazione);
		pannello_Navigazione.setLayout(null);
		
		JButton bottone_Home = new JButton("");
		bottone_Home.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);				
				c.mostraGestioneRistoranteFrame();
			}
		});
		bottone_Home.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnHome.png")));
		bottone_Home.setBounds(10, 11, 160, 60);
		pannello_Navigazione.add(bottone_Home);
		bottone_Home.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JButton bottone_Indietro = new JButton("");
		bottone_Indietro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.mostraGestioneCasiCovidFrame(isProprietario);
			}
		});
		bottone_Indietro.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnIndietro.png")));
		bottone_Indietro.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Indietro.setBounds(191, 11, 160, 60);
		pannello_Navigazione.add(bottone_Indietro);
		
		JButton bottone_Logout = new JButton("");
		bottone_Logout.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/btnLogout.png")));
		bottone_Logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraLogoutDialog(c);
			}
		});
		bottone_Logout.setFont(new Font("Tahoma", Font.BOLD, 12));
		bottone_Logout.setBounds(1094, 11, 160, 60);
		pannello_Navigazione.add(bottone_Logout);
		
		lblDataEOra = new JLabel("");
		lblDataEOra.setIcon(new ImageIcon(HomepageProprietarioFrame.class.getResource("/resources/DataEOraIcon.png")));
		lblDataEOra.setForeground(new Color(0, 0, 128));
		lblDataEOra.setBounds(420, 11, 429, 60);
		pannello_Navigazione.add(lblDataEOra);
		lblDataEOra.setFont(new Font("Segoe UI", Font.BOLD, 25));
		lblDataEOra.setHorizontalAlignment(SwingConstants.CENTER);
		c.mostraDataEOra(lblDataEOra);
		
		lblNumeroCartaDidentita = new JLabel("Numero carta d'identita': ");
		lblNumeroCartaDidentita.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblNumeroCartaDidentita.setForeground(new Color(0, 0, 128));
		lblNumeroCartaDidentita.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNumeroCartaDidentita.setBounds(76, 91, 523, 27);
		pannello_Principale.add(lblNumeroCartaDidentita);
		
		lblNome = new JLabel("Nome: ");
		lblNome.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblNome.setForeground(new Color(0, 0, 128));
		lblNome.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNome.setBounds(76, 161, 523, 27);
		pannello_Principale.add(lblNome);
		
		lblCognome = new JLabel("Cognome: ");
		lblCognome.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblCognome.setForeground(new Color(0, 0, 128));
		lblCognome.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCognome.setBounds(76, 231, 523, 27);
		pannello_Principale.add(lblCognome);
		
		lblDataDiNascita = new JLabel("Data di nascita: ");
		lblDataDiNascita.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/iconCalendar.png")));
		lblDataDiNascita.setForeground(new Color(0, 0, 128));
		lblDataDiNascita.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblDataDiNascita.setBounds(76, 301, 523, 27);
		pannello_Principale.add(lblDataDiNascita);
		
		lblSesso = new JLabel("Sesso: ");
		lblSesso.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblSesso.setForeground(new Color(0, 0, 128));
		lblSesso.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblSesso.setBounds(76, 371, 523, 27);
		pannello_Principale.add(lblSesso);
		
		lblCittaDiNascita = new JLabel("Citta' di nascita: ");
		lblCittaDiNascita.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/cityIcon.png")));
		lblCittaDiNascita.setForeground(new Color(0, 0, 128));
		lblCittaDiNascita.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCittaDiNascita.setBounds(76, 441, 475, 27);
		pannello_Principale.add(lblCittaDiNascita);
		
		lblProvinciaDiNascita = new JLabel("Provincia di nascita: ");
		lblProvinciaDiNascita.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/cityIcon.png")));
		lblProvinciaDiNascita.setForeground(new Color(0, 0, 128));
		lblProvinciaDiNascita.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblProvinciaDiNascita.setBounds(76, 511, 523, 27);
		pannello_Principale.add(lblProvinciaDiNascita);
		
		lblCittaDiResidenza = new JLabel("Citta' di residenza: ");
		lblCittaDiResidenza.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/cityIcon.png")));
		lblCittaDiResidenza.setForeground(new Color(0, 0, 128));
		lblCittaDiResidenza.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblCittaDiResidenza.setBounds(666, 91, 523, 27);
		pannello_Principale.add(lblCittaDiResidenza);
		
		lblProvinciaDiResidenza = new JLabel("Provincia di residenza: ");
		lblProvinciaDiResidenza.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/cityIcon.png")));
		lblProvinciaDiResidenza.setForeground(new Color(0, 0, 128));
		lblProvinciaDiResidenza.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblProvinciaDiResidenza.setBounds(666, 161, 523, 27);
		pannello_Principale.add(lblProvinciaDiResidenza);
		
		lblTelefono = new JLabel("Telefono: ");
		lblTelefono.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/telephoneIcon.png")));
		lblTelefono.setForeground(new Color(0, 0, 128));
		lblTelefono.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTelefono.setBounds(666, 231, 523, 27);
		pannello_Principale.add(lblTelefono);
		
		lblEmail = new JLabel("Email: ");
		lblEmail.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/mailicon.png")));
		lblEmail.setForeground(new Color(0, 0, 128));
		lblEmail.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblEmail.setBounds(666, 301, 523, 27);
		pannello_Principale.add(lblEmail);
		
		lblTemperaturaRegistrata = new JLabel("Temperatura registrata: ");
		lblTemperaturaRegistrata.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblTemperaturaRegistrata.setForeground(new Color(0, 0, 128));
		lblTemperaturaRegistrata.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblTemperaturaRegistrata.setBounds(666, 371, 523, 27);
		pannello_Principale.add(lblTemperaturaRegistrata);
		
		lblProvvistoDiGreenpass = new JLabel("Provvisto di Greenpass: ");
		lblProvvistoDiGreenpass.setIcon(new ImageIcon(TracciamentoAvventoreFrame.class.getResource("/resources/usericon.png")));
		lblProvvistoDiGreenpass.setForeground(new Color(0, 0, 128));
		lblProvvistoDiGreenpass.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblProvvistoDiGreenpass.setBounds(666, 441, 523, 27);
		pannello_Principale.add(lblProvvistoDiGreenpass);

	}
	
	private void mostraLogoutDialog(Controller c) {
		JLabel lblLogout = new JLabel("Sei sicuro di voler uscire?");
		lblLogout.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if(JOptionPane.showConfirmDialog(pannello_Principale, lblLogout)==0) {
			setVisible(false);
			c.startLoginFrame();
		}
	}

	public JLabel getLblDataEOra() {
		return lblDataEOra;
	}

	public JLabel getLblNumeroCartaDidentita() {
		return lblNumeroCartaDidentita;
	}

	public JLabel getLblNome() {
		return lblNome;
	}

	public JLabel getLblCognome() {
		return lblCognome;
	}

	public JLabel getLblDataDiNascita() {
		return lblDataDiNascita;
	}

	public JLabel getLblSesso() {
		return lblSesso;
	}

	public JLabel getLblCittaDiNascita() {
		return lblCittaDiNascita;
	}

	public JLabel getLblProvinciaDiNascita() {
		return lblProvinciaDiNascita;
	}

	public JLabel getLblCittaDiResidenza() {
		return lblCittaDiResidenza;
	}

	public JLabel getLblProvinciaDiResidenza() {
		return lblProvinciaDiResidenza;
	}

	public JLabel getLblTelefono() {
		return lblTelefono;
	}

	public JLabel getLblEmail() {
		return lblEmail;
	}

	public JLabel getLblTemperaturaRegistrata() {
		return lblTemperaturaRegistrata;
	}

	public JLabel getLblProvvistoDiGreenpass() {
		return lblProvvistoDiGreenpass;
	}
}