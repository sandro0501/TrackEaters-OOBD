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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Locale;

import controller.Controller;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import com.toedter.calendar.JDateChooser;
import javax.swing.SpinnerDateModel;
import java.util.Date;
import java.util.Calendar;

public class ModificaTavolataFrame extends JFrame {

	private JPanel pannello_Principale;
	private JDateChooser campo_DataArrivo;
	private JTextField campo_OraArrivo;
	private JTextField campo_OraUscita;
	private JComboBox campo_Cameriere;
	private JLabel etichetta_CodTavolo;
	private Controller theController;

	
	public ModificaTavolataFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Modifica_Avventori.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Modifica tavolata");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 540);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_Tavolate = new JLabel("");
		etichetta_Tavolate.setIcon(new ImageIcon(ModificaTavolataFrame.class.getResource("/resources/modificaTavolataTitle.png")));
		etichetta_Tavolate.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_Tavolate.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_Tavolate.setBounds(17, 28, 490, 52);
		pannello_Principale.add(etichetta_Tavolate);
		
		etichetta_CodTavolo = new JLabel("Tavolo:");
		etichetta_CodTavolo.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/restaurantIcon.png")));
		etichetta_CodTavolo.setForeground(new Color(0, 0, 128));
		etichetta_CodTavolo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_CodTavolo.setBounds(20, 91, 487, 27);
		pannello_Principale.add(etichetta_CodTavolo);
		
		JLabel etichetta_DataArrivo = new JLabel("Data arrivo");
		etichetta_DataArrivo.setIcon(new ImageIcon(AggiungiTavolataFrame.class.getResource("/resources/iconCalendar.png")));
		etichetta_DataArrivo.setForeground(new Color(0, 0, 128));
		etichetta_DataArrivo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_DataArrivo.setBounds(20, 141, 223, 27);
		pannello_Principale.add(etichetta_DataArrivo);
		
		JLabel etichetta_OraArrivo = new JLabel("Ora arrivo\r\n");
		etichetta_OraArrivo.setIcon(new ImageIcon(AggiungiTavolataFrame.class.getResource("/resources/iconOrologio.png")));
		etichetta_OraArrivo.setForeground(new Color(0, 0, 128));
		etichetta_OraArrivo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_OraArrivo.setBounds(20, 221, 134, 27);
		pannello_Principale.add(etichetta_OraArrivo);
		
		JLabel etichetta_OraUscita = new JLabel("Ora uscita");
		etichetta_OraUscita.setIcon(new ImageIcon(AggiungiTavolataFrame.class.getResource("/resources/iconOrologio.png")));
		etichetta_OraUscita.setForeground(new Color(0, 0, 128));
		etichetta_OraUscita.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_OraUscita.setBounds(247, 221, 134, 27);
		pannello_Principale.add(etichetta_OraUscita);
		
		JLabel etichetta_Cameriere = new JLabel("Cameriere\r\n");
		etichetta_Cameriere.setIcon(new ImageIcon(AggiungiTavolataFrame.class.getResource("/resources/iconCameriere.png")));
		etichetta_Cameriere.setForeground(new Color(0, 0, 128));
		etichetta_Cameriere.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Cameriere.setBounds(20, 271, 172, 27);
		pannello_Principale.add(etichetta_Cameriere);
		
		campo_DataArrivo = new JDateChooser();
		campo_DataArrivo.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_DataArrivo.setDateFormatString("dd/MM/yyyy");
		campo_DataArrivo.setBounds(20, 171, 193, 27);
		pannello_Principale.add(campo_DataArrivo);
		
		campo_OraArrivo = new JTextField();
		campo_OraArrivo.setEditable(false);
		campo_OraArrivo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_OraArrivo.setText("20:00:00");
		campo_OraArrivo.setBounds(140, 225, 86, 27);
		pannello_Principale.add(campo_OraArrivo);
		campo_OraArrivo.setColumns(10);
		
		campo_OraUscita = new JTextField();
		campo_OraUscita.setText("22:00:00");
		campo_OraUscita.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_OraUscita.setEditable(false);
		campo_OraUscita.setColumns(10);
		campo_OraUscita.setBounds(367, 225, 86, 27);
		pannello_Principale.add(campo_OraUscita);

		campo_Cameriere = new JComboBox();
		campo_Cameriere.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_Cameriere.setSelectedItem("");
		campo_Cameriere.setBounds(20, 301, 134, 27);
		pannello_Principale.add(campo_Cameriere);
		
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
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler modificare le informazioni della tavolata?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) 
					{
					
						DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
						String dataformattata = dateFormat.format(campo_DataArrivo.getDate());
						c.updateTavolata(isProprietario,dataformattata, campo_Cameriere.getSelectedItem().toString());
						setVisible(false);
						c.mostraGestioneTavolateFrame();
					}
				}
		});

		bottone_Aggiungi.setIcon(new ImageIcon(ModificaTavolataFrame.class.getResource("/resources/btnModifica.png")));
		bottone_Aggiungi.setBounds(333, 422, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);
		

	}
	
	private void mostraAnnullaDialog(Controller c) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare la modifica delle informazioni della tavolata?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneTavolateFrame();
		}
	}
	
	public JDateChooser getCampo_DataArrivo() {
		return campo_DataArrivo;
	}

	public JComboBox getCampo_Cameriere() {
		return campo_Cameriere;
	}

	public JLabel getEtichetta_CodTavolo() {
		return etichetta_CodTavolo;
	}
}
