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
import Controller.Controller;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Component;
import javax.swing.Box;

public class Homepage_Proprietario extends JFrame {

	private JPanel HomepageProprietarioPane;
	private Controller theController = new Controller();

	
	public Homepage_Proprietario(Controller c) {
		theController = c;
		
		setResizable(false);
		setTitle("SecuRisto");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Homepage_Proprietario.class.getResource("/resources/icon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 500);
		HomepageProprietarioPane = new JPanel();
		HomepageProprietarioPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(HomepageProprietarioPane);
		HomepageProprietarioPane.setLayout(null);
		
		JPanel Navigation_panel = new JPanel();
		Navigation_panel.setBounds(0, 409, 1044, 52);
		Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		HomepageProprietarioPane.add(Navigation_panel);
		Navigation_panel.setLayout(null);
		
		JButton HomeButton = new JButton("Home");
		HomeButton.setEnabled(false);
		HomeButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		HomeButton.setBounds(10, 11, 89, 30);
		Navigation_panel.add(HomeButton);
		
		JButton IndietroButton = new JButton("Indietro");
		IndietroButton.setEnabled(false);
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
				c.login();			
			}
		});
		LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		LogoutButton_2.setBounds(945, 11, 89, 30);
		Navigation_panel.add(LogoutButton_2);
		
		JTextPane BenvenutoNomeCognomeTxtPane = new JTextPane();
		BenvenutoNomeCognomeTxtPane.setBounds(10, 11, 200, 72);
		BenvenutoNomeCognomeTxtPane.setEditable(false);
		BenvenutoNomeCognomeTxtPane.setBackground(SystemColor.control);
		BenvenutoNomeCognomeTxtPane.setFont(new Font("Tahoma", Font.BOLD, 12));
		BenvenutoNomeCognomeTxtPane.setText("Benvenuto\r\nNome Cognome\r\nusername - mail@mail.it");
		HomepageProprietarioPane.add(BenvenutoNomeCognomeTxtPane);
		
		JLabel TracciamentoContattiCovid19Label = new JLabel("TRACCIAMENTO CONTATTI COVID-19");
		TracciamentoContattiCovid19Label.setBounds(273, 94, 490, 52);
		TracciamentoContattiCovid19Label.setFont(new Font("Tahoma", Font.BOLD, 15));
		TracciamentoContattiCovid19Label.setHorizontalAlignment(SwingConstants.CENTER);
		HomepageProprietarioPane.add(TracciamentoContattiCovid19Label);
		
		JButton IMieiRistorantiButton = new JButton("I miei ristoranti");
		IMieiRistorantiButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				c.startI_MieiRistorantiProprietario();
			}
		});
		IMieiRistorantiButton.setBounds(350, 205, 130, 50);
		IMieiRistorantiButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		HomepageProprietarioPane.add(IMieiRistorantiButton);
		
		JButton PersonaleButton = new JButton("Personale");
		PersonaleButton.setBounds(584, 205, 130, 50);
		PersonaleButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		HomepageProprietarioPane.add(PersonaleButton);
	}
}
