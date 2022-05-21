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

public class ModificaSala extends JFrame {

	private JPanel contentPane;
	private JTextField denominazioneField;
	private JTextField capienzaAvventoriField;
	private JTextField dimensioneMqField;

	public ModificaSala() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(AggiungiTavolata.class.getResource("/resources/icon.png")));
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
		
		JButton modificaButton = new JButton("Modifica");
		modificaButton.setBounds(284, 379, 117, 40);
		contentPane.add(modificaButton);
		
		JLabel modificaSalaLabel = new JLabel("MODIFICA SALA");
		modificaSalaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		modificaSalaLabel.setHorizontalAlignment(SwingConstants.CENTER);
		modificaSalaLabel.setBounds(137, 23, 209, 40);
		contentPane.add(modificaSalaLabel);
		
		JLabel denominazioneLabel = new JLabel("Denominazione");
		denominazioneLabel.setBounds(92, 78, 109, 14);
		contentPane.add(denominazioneLabel);
		
		JLabel capienzaAvventoriLabel = new JLabel("Capienza avventori");
		capienzaAvventoriLabel.setBounds(92, 131, 109, 14);
		contentPane.add(capienzaAvventoriLabel);
		
		denominazioneField = new JTextField();
		denominazioneField.setBounds(92, 91, 300, 20);
		contentPane.add(denominazioneField);
		denominazioneField.setColumns(10);
		
		capienzaAvventoriField = new JTextField();
		capienzaAvventoriField.setColumns(10);
		capienzaAvventoriField.setBounds(92, 144, 300, 20);
		contentPane.add(capienzaAvventoriField);
		
		JLabel lblDimensionemq = new JLabel("Dimensione (Mq)");
		lblDimensionemq.setBounds(92, 189, 109, 14);
		contentPane.add(lblDimensionemq);
		
		dimensioneMqField = new JTextField();
		dimensioneMqField.setColumns(10);
		dimensioneMqField.setBounds(92, 202, 300, 20);
		contentPane.add(dimensioneMqField);
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setBounds(92, 255, 46, 14);
		contentPane.add(lblTipo);
		
		JComboBox tipo_comboBox = new JComboBox();
		tipo_comboBox.setBounds(92, 269, 300, 20);
		contentPane.add(tipo_comboBox);
	}
}