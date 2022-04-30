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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomepageProprietario extends JFrame {

	private JPanel HomepageProprietarioPane;
	private controller theController = new controller();

	
	public HomepageProprietario(controller c) {
		theController = c;
		
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(HomepageProprietario.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		HomepageProprietarioPane = new JPanel();
		HomepageProprietarioPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HomepageProprietarioPane);
		HomepageProprietarioPane.setLayout(null);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Navigation_panel.setBounds(0, 409, 1044, 52);
		HomepageProprietarioPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.homeProprietario();
			}
		});
		HomeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HomeButton.setBounds(10, 11, 89, 30);
		Navigation_panel.add(HomeButton);
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.back();
			}
		});
		IndietroButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		IndietroButton.setBounds(109, 11, 89, 30);
		Navigation_panel.add(IndietroButton);
		
		JLabel OrarioLabel = new JLabel("------");
		OrarioLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		OrarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OrarioLabel.setBounds(412, 11, 220, 30);
		Navigation_panel.add(OrarioLabel);
		
		JButton LogoutButton_2 = new JButton("Logout");
		LogoutButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.logout();			
			}
		});
		LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton_2.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton_2);
		
		JTextPane BenvenutoNomeCognomeTxtPane = new JTextPane();
		BenvenutoNomeCognomeTxtPane.setEditable(false);
		BenvenutoNomeCognomeTxtPane.setBackground(SystemColor.control);
		BenvenutoNomeCognomeTxtPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		BenvenutoNomeCognomeTxtPane.setText("Benvenuto\r\nNome Cognome\r\nusername - mail@mail.it");
		BenvenutoNomeCognomeTxtPane.setBounds(10, 11, 200, 72);
		HomepageProprietarioPane.add(BenvenutoNomeCognomeTxtPane);
		
		JLabel GestioneCasiCovid19Label = new JLabel("GESTIONE CASI COVID-19");
		GestioneCasiCovid19Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		GestioneCasiCovid19Label.setHorizontalAlignment(SwingConstants.CENTER);
		GestioneCasiCovid19Label.setBounds(273, 94, 497, 52);
		HomepageProprietarioPane.add(GestioneCasiCovid19Label);
		
		JButton IMieiRistorantiButton = new JButton("I miei ristoranti");
		IMieiRistorantiButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		IMieiRistorantiButton.setBounds(60, 205, 130, 50);
		HomepageProprietarioPane.add(IMieiRistorantiButton);
		
		JButton PersonaleButton = new JButton("Personale");
		PersonaleButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		PersonaleButton.setBounds(264, 205, 130, 50);
		HomepageProprietarioPane.add(PersonaleButton);
		
		JButton StatisticheButton = new JButton("Statistiche");
		StatisticheButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		StatisticheButton.setBounds(468, 205, 130, 50);
		HomepageProprietarioPane.add(StatisticheButton);
		
		JButton RegistraCasoButton = new JButton("Registra caso");
		RegistraCasoButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		RegistraCasoButton.setBounds(672, 205, 130, 50);
		HomepageProprietarioPane.add(RegistraCasoButton);
		
		JButton ImpostazioniButton = new JButton("Impostazioni");
		ImpostazioniButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		ImpostazioniButton.setBounds(876, 205, 130, 50);
		HomepageProprietarioPane.add(ImpostazioniButton);
	}
}
