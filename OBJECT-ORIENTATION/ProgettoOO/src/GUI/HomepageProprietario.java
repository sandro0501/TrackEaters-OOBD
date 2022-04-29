package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import Controller.controller;

public class HomepageProprietario extends JFrame {

	private JPanel contentPane;
	private controller theController = new controller();

	
	public HomepageProprietario(controller c) {
		theController = c;
		
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageProprietario.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(0, 409, 1044, 52);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(10, 11, 89, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Indietro");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBounds(109, 11, 89, 30);
		panel.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("------");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(412, 11, 220, 30);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(945, 11, 89, 30);
		panel.add(btnNewButton_2);
		
		JTextPane txtpnBenvenutoNomeCognome = new JTextPane();
		txtpnBenvenutoNomeCognome.setEditable(false);
		txtpnBenvenutoNomeCognome.setBackground(SystemColor.control);
		txtpnBenvenutoNomeCognome.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtpnBenvenutoNomeCognome.setText("Benvenuto\r\nNome Cognome\r\nusername - mail@mail.it");
		txtpnBenvenutoNomeCognome.setBounds(10, 11, 200, 72);
		contentPane.add(txtpnBenvenutoNomeCognome);
		
		JLabel lblNewLabel_1 = new JLabel("GESTIONE CASI COVID-19");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(273, 94, 497, 52);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_3 = new JButton("I miei ristoranti");
		btnNewButton_3.setBounds(60, 205, 130, 50);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Personale");
		btnNewButton_4.setBounds(264, 205, 130, 50);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Statistiche");
		btnNewButton_5.setBounds(468, 205, 130, 50);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Registra caso");
		btnNewButton_6.setBounds(672, 205, 130, 50);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Impostazioni");
		btnNewButton_7.setBounds(876, 205, 130, 50);
		contentPane.add(btnNewButton_7);
	}
}
