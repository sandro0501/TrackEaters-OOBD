package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;

public class Aggiungi_Modifica_Caso extends JFrame {

	private JPanel contentPane;
	private JTextField dataPositivitatextField;

	public Aggiungi_Modifica_Caso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Aggiungi_Modifica_Tavolata.class.getResource("/resources/icon.png")));
		setTitle("SecuRisto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton annullaButton = new JButton("Annulla");
		annullaButton.setBounds(84, 379, 117, 40);
		contentPane.add(annullaButton);
		
		JButton aggiungiButton = new JButton("Aggiungi");
		aggiungiButton.setBounds(284, 379, 117, 40);
		contentPane.add(aggiungiButton);
		
		JLabel aggiungiCasoLabel = new JLabel("AGGIUNGI CASO");
		aggiungiCasoLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		aggiungiCasoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		aggiungiCasoLabel.setBounds(137, 23, 209, 40);
		contentPane.add(aggiungiCasoLabel);
		
		JComboBox ruolo_comboBox = new JComboBox();
		ruolo_comboBox.setBounds(92, 92, 300, 20);
		contentPane.add(ruolo_comboBox);
		
		JComboBox numeroDocumento_comboBox = new JComboBox();
		numeroDocumento_comboBox.setBounds(92, 147, 300, 20);
		contentPane.add(numeroDocumento_comboBox);
		
		dataPositivitatextField = new JTextField();
		dataPositivitatextField.setBounds(92, 206, 300, 20);
		contentPane.add(dataPositivitatextField);
		dataPositivitatextField.setColumns(10);
		
		JTextArea note_textArea = new JTextArea();
		note_textArea.setBounds(92, 267, 300, 82);
		contentPane.add(note_textArea);
		
		JLabel ruoloLabel = new JLabel("Ruolo");
		ruoloLabel.setBounds(92, 78, 46, 14);
		contentPane.add(ruoloLabel);
		
		JLabel numeroDocumentoLabel = new JLabel("Numero documento");
		numeroDocumentoLabel.setBounds(92, 131, 111, 14);
		contentPane.add(numeroDocumentoLabel);
		
		JLabel dataPositivitaLabel = new JLabel("Data positivit\u00E0");
		dataPositivitaLabel.setBounds(92, 193, 111, 14);
		contentPane.add(dataPositivitaLabel);
		
		JLabel noteLabel = new JLabel("Note");
		noteLabel.setBounds(92, 253, 46, 14);
		contentPane.add(noteLabel);
	}
}
