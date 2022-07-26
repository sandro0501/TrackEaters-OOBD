package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;

public class Ristorante extends JFrame {

	private JPanel HomepageManagerPane;
	private Controller theController;

	
	
	public Ristorante(Controller c) {
		setResizable(false);
		theController = c;
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Ristorante.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		HomepageManagerPane = new JPanel();
		HomepageManagerPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HomepageManagerPane);
		HomepageManagerPane.setLayout(null);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		Navigation_panel.setBounds(0, 409, 1044, 52);
		HomepageManagerPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HomeButton.setBounds(10, 11, 89, 30);
		Navigation_panel.add(HomeButton);
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		IndietroButton.setBounds(109, 11, 89, 30);
		Navigation_panel.add(IndietroButton);
		
		JLabel OrarioLabel = new JLabel("\"Data & Ora\"");
		OrarioLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		OrarioLabel.setHorizontalAlignment(SwingConstants.CENTER);
		OrarioLabel.setBounds(412, 11, 220, 30);
		Navigation_panel.add(OrarioLabel);
		
		JButton LogoutButton_2 = new JButton("Logout");
		LogoutButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.login();			
			}
		});
		LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton_2.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton_2);
		
		JTextPane InfoManagerTxtPane = new JTextPane();
		InfoManagerTxtPane.setEditable(false);
		InfoManagerTxtPane.setBackground(SystemColor.control);
		InfoManagerTxtPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		InfoManagerTxtPane.setText("Manager: \"Nome\" \"Cognome\"\r\n\"Telefono\"\r\n\"Email\"");
		InfoManagerTxtPane.setBounds(10, 11, 236, 72);
		HomepageManagerPane.add(InfoManagerTxtPane);
		
		JLabel GestioneCasiCovid19Label = new JLabel("TRACCIAMENTO CONTATTI COVID-19");
		GestioneCasiCovid19Label.setFont(new Font("Tahoma", Font.BOLD, 20));
		GestioneCasiCovid19Label.setHorizontalAlignment(SwingConstants.CENTER);
		GestioneCasiCovid19Label.setBounds(278, 66, 490, 52);
		HomepageManagerPane.add(GestioneCasiCovid19Label);
		
		JButton InformazioniRistorantiButton = new JButton("Informazioni \r\nRistorante");
		InformazioniRistorantiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				c.startInformazioniRistorante();
				setVisible(false);
			}
		});
		InformazioniRistorantiButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		InformazioniRistorantiButton.setBounds(133, 205, 170, 50);
		HomepageManagerPane.add(InformazioniRistorantiButton);
		
		JButton SaleButton = new JButton("Sale");
		SaleButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		SaleButton.setBounds(436, 205, 170, 50);
		HomepageManagerPane.add(SaleButton);
		
		JButton CamerieriButton = new JButton("Camerieri");
		CamerieriButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		CamerieriButton.setBounds(739, 205, 170, 50);
		HomepageManagerPane.add(CamerieriButton);
		
		JButton StatisticheButton = new JButton("Statistiche ");
		StatisticheButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		StatisticheButton.setBounds(234, 314, 170, 50);
		HomepageManagerPane.add(StatisticheButton);
		
		JButton ImpostazioniButton = new JButton("Casi");
		ImpostazioniButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		ImpostazioniButton.setBounds(638, 314, 170, 50);
		HomepageManagerPane.add(ImpostazioniButton);
		
		JLabel RistoranteLabel = new JLabel("RISTORANTE: \"Denominazione\"");
		RistoranteLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		RistoranteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		RistoranteLabel.setBounds(325, 35, 393, 20);
		HomepageManagerPane.add(RistoranteLabel);
	}
}
