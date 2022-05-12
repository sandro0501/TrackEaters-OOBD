package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import Controller.Controller;

public class InformazioniRistorante extends JFrame {

	private JPanel InformazioniRistorantePane;
	private Controller theController;

	public InformazioniRistorante(Controller c, boolean flag) {
		theController = c;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		InformazioniRistorantePane = new JPanel();
		InformazioniRistorantePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InformazioniRistorantePane);
		InformazioniRistorantePane.setLayout(null);
	
	JPanel Navigation_panel = new JPanel();
	Navigation_panel.setBounds(0, 409, 784, 52);
	Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	InformazioniRistorantePane.add(Navigation_panel);
	Navigation_panel.setLayout(null);
	
	JButton HomeButton = new JButton("Home");
	HomeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			c.startLoginProprietario();
			setVisible(false);	
		}
	});
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
	OrarioLabel.setBounds(282, 11, 220, 30);
	Navigation_panel.add(OrarioLabel);
	
	JButton LogoutButton_2 = new JButton("Logout");
	LogoutButton_2.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			c.login();			
		}
	});
	LogoutButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
	LogoutButton_2.setBounds(685, 11, 89, 30);
	Navigation_panel.add(LogoutButton_2);
	
	JPanel info_panel = new JPanel();
	info_panel.setBounds(411, 11, 363, 387);
	InformazioniRistorantePane.add(info_panel);
	info_panel.setLayout(null);
	
	JLabel DenominazioneLabel = new JLabel("Denominazione");
	DenominazioneLabel.setBounds(10, 15, 85, 20);
	info_panel.add(DenominazioneLabel);
	
	JLabel lblNewLabel_1 = new JLabel("-");
	lblNewLabel_1.setBounds(10, 35, 250, 20);
	info_panel.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel("New label");
	lblNewLabel_2.setBounds(10, 75, 85, 20);
	info_panel.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel("New label");
	lblNewLabel_3.setBounds(10, 95, 85, 20);
	info_panel.add(lblNewLabel_3);
	
	JLabel lblNewLabel_4 = new JLabel("New label");
	lblNewLabel_4.setBounds(10, 135, 85, 20);
	info_panel.add(lblNewLabel_4);
	
	JLabel lblNewLabel_1_1 = new JLabel("New label");
	lblNewLabel_1_1.setBounds(10, 155, 85, 20);
	info_panel.add(lblNewLabel_1_1);
	
	JLabel lblNewLabel_5 = new JLabel("New label");
	lblNewLabel_5.setBounds(10, 195, 85, 20);
	info_panel.add(lblNewLabel_5);
	
	JLabel lblNewLabel_1_2 = new JLabel("New label");
	lblNewLabel_1_2.setBounds(10, 215, 85, 20);
	info_panel.add(lblNewLabel_1_2);
	
	JLabel lblNewLabel_6 = new JLabel("New label");
	lblNewLabel_6.setBounds(10, 255, 85, 20);
	info_panel.add(lblNewLabel_6);
	
	JLabel lblNewLabel_1_3 = new JLabel("New label");
	lblNewLabel_1_3.setBounds(10, 275, 85, 20);
	info_panel.add(lblNewLabel_1_3);
	
	JLabel lblNewLabel_7 = new JLabel("New label");
	lblNewLabel_7.setBounds(10, 315, 85, 20);
	info_panel.add(lblNewLabel_7);
	
	JLabel lblNewLabel_1_4 = new JLabel("New label");
	lblNewLabel_1_4.setBounds(10, 335, 85, 20);
	info_panel.add(lblNewLabel_1_4);
	
	JLabel lblNewLabel_8 = new JLabel("New label");
	lblNewLabel_8.setBounds(135, 195, 85, 20);
	info_panel.add(lblNewLabel_8);
	
	JLabel lblNewLabel_1_5 = new JLabel("New label");
	lblNewLabel_1_5.setBounds(135, 215, 85, 20);
	info_panel.add(lblNewLabel_1_5);
	
	JLabel lblNewLabel_9 = new JLabel("New label");
	lblNewLabel_9.setBounds(259, 195, 85, 20);
	info_panel.add(lblNewLabel_9);
	
	JLabel lblNewLabel_1_6 = new JLabel("New label");
	lblNewLabel_1_6.setBounds(259, 215, 85, 20);
	info_panel.add(lblNewLabel_1_6);
	
	}
}
