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
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class AggiungiCasoCovidFrame extends JFrame {

	private JPanel pannello_Principale;
	private JDateChooser campo_DataRegistrazioneCaso;
	private JComboBox campo_AvventorePositivo;
	private JTextPane campo_Note;
	private JComboBox campo_StatoCaso;
	private Controller theController;

	
	public AggiungiCasoCovidFrame(Controller c, boolean isProprietario) {
		
		theController = c;
		
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(ModificaAvventoreFrame.class.getResource("/resources/icon.png")));
		setTitle("TrackEaters - Aggiungi caso COVID");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 598);
		setLocationRelativeTo(null);
		pannello_Principale = new JPanel();
		pannello_Principale.setBackground(new Color(176, 196, 222));
		pannello_Principale.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pannello_Principale);
		pannello_Principale.setLayout(null);
		
		JLabel etichetta_AggiungiCaso = new JLabel("");
		etichetta_AggiungiCaso.setIcon(new ImageIcon(AggiungiCasoCovidFrame.class.getResource("/resources/aggiungiCasoTitle.png")));
		etichetta_AggiungiCaso.setFont(new Font("Tahoma", Font.BOLD, 20));
		etichetta_AggiungiCaso.setHorizontalAlignment(SwingConstants.CENTER);
		etichetta_AggiungiCaso.setBounds(17, 28, 490, 52);
		pannello_Principale.add(etichetta_AggiungiCaso);
		
		JLabel etichetta_DataRegistrazioneCaso = new JLabel("Data registrazione");
		etichetta_DataRegistrazioneCaso.setIcon(new ImageIcon(AggiungiTavolataFrame.class.getResource("/resources/iconCalendar.png")));
		etichetta_DataRegistrazioneCaso.setForeground(new Color(0, 0, 128));
		etichetta_DataRegistrazioneCaso.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_DataRegistrazioneCaso.setBounds(20, 91, 223, 27);
		pannello_Principale.add(etichetta_DataRegistrazioneCaso);
		
		JLabel etichetta_AvventorePositivo = new JLabel("Avventore positivo");
		etichetta_AvventorePositivo.setIcon(new ImageIcon(AggiungiCasoCovidFrame.class.getResource("/resources/usericon.png")));
		etichetta_AvventorePositivo.setForeground(new Color(0, 0, 128));
		etichetta_AvventorePositivo.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_AvventorePositivo.setBounds(20, 173, 215, 27);
		pannello_Principale.add(etichetta_AvventorePositivo);
		
		JLabel etichetta_StatoCaso = new JLabel("Stato del caso");
		etichetta_StatoCaso.setForeground(new Color(0, 0, 128));
		etichetta_StatoCaso.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_StatoCaso.setBounds(20, 251, 215, 27);
		pannello_Principale.add(etichetta_StatoCaso);
		
		JLabel etichetta_Note = new JLabel("Note (max 100 car.)");
		etichetta_Note.setForeground(new Color(0, 0, 128));
		etichetta_Note.setFont(new Font("Segoe UI", Font.BOLD, 18));
		etichetta_Note.setBounds(20, 331, 215, 27);
		pannello_Principale.add(etichetta_Note);
		
		campo_DataRegistrazioneCaso = new JDateChooser();
		campo_DataRegistrazioneCaso.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_DataRegistrazioneCaso.setDateFormatString("dd/MM/yyyy");
		campo_DataRegistrazioneCaso.setBounds(20, 121, 255, 27);
		Date data = new Date();
		campo_DataRegistrazioneCaso.setDate(data);
		pannello_Principale.add(campo_DataRegistrazioneCaso);

		campo_AvventorePositivo = new JComboBox();
		campo_AvventorePositivo.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		campo_AvventorePositivo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_AvventorePositivo.setSelectedItem("");
		campo_AvventorePositivo.setBounds(20, 201, 262, 27);
		pannello_Principale.add(campo_AvventorePositivo);
		
		campo_StatoCaso = new JComboBox();
		campo_StatoCaso.setModel(new DefaultComboBoxModel(new String[] {"NonRisolto", "InRisoluzione", "Risolto"}));
		campo_StatoCaso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		campo_StatoCaso.setBounds(20, 281, 262, 27);
		pannello_Principale.add(campo_StatoCaso);
		
		campo_Note = new JTextPane();
		campo_Note.setToolTipText("Annota qualcosa sul caso qui...");
		campo_Note.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		campo_Note.setBounds(20, 361, 473, 81);
		pannello_Principale.add(campo_Note);
		
		JButton bottone_Annulla = new JButton("");
		bottone_Annulla.setIcon(new ImageIcon(ImpostazioniProprietarioFrame.class.getResource("/resources/AnnulllaBtn.png")));
		bottone_Annulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostraAnnullaDialog(c,isProprietario);
			}
		});
		bottone_Annulla.setBounds(17, 488, 160, 60);
		pannello_Principale.add(bottone_Annulla);
		
		JButton bottone_Aggiungi = new JButton("");
		JLabel lblAggiungi = new JLabel("Sei sicuro di voler registrare il nuovo caso COVID?");
		lblAggiungi.setFont(new Font("Segoe UI", Font.BOLD, 15));
		bottone_Aggiungi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (JOptionPane.showConfirmDialog(pannello_Principale, lblAggiungi)==0) 
					{
						if(campo_AvventorePositivo.getSelectedItem().toString().equals("-"))
						{
							c.mostraErroreSelezioneAvventore(pannello_Principale);
						}
						else
						{
							DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
							String dataFormattata = dateFormat.format(campo_DataRegistrazioneCaso.getDate());
							String avventoreSelezionato = campo_AvventorePositivo.getSelectedItem().toString();
							String[] numCid = avventoreSelezionato.split("-");
	
							
							c.insertCasoCovid(dataFormattata,
											numCid[0].toString(),
											campo_StatoCaso.getSelectedItem().toString(),
											campo_Note.getText().toString());
							setVisible(false);
							c.mostraGestioneCasiCovidFrame(isProprietario);
						}
					
					}
				}
		});

		bottone_Aggiungi.setIcon(new ImageIcon(AggiungiRistoranteFrame.class.getResource("/resources/btnAggiungi.png")));
		bottone_Aggiungi.setBounds(330, 488, 160, 60);
		pannello_Principale.add(bottone_Aggiungi);	

	}
	
	private void mostraAnnullaDialog(Controller c, boolean proprietario) {
		JLabel lblAnnulla = new JLabel("Sei sicuro di voler annullare l'inserimento del nuovo caso COVID?");
		lblAnnulla.setFont(new Font("Segoe UI", Font.BOLD, 15));
		if (JOptionPane.showConfirmDialog(pannello_Principale, lblAnnulla)==0) {
			setVisible(false);
			c.mostraGestioneCasiCovidFrame(proprietario);
		}
	}

	public JComboBox getCampo_AvventorePositivo() {
		return campo_AvventorePositivo;
	}

}