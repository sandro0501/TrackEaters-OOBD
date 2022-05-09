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
		setBounds(100, 100, 1060, 500);
		InformazioniRistorantePane = new JPanel();
		InformazioniRistorantePane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(InformazioniRistorantePane);
		InformazioniRistorantePane.setLayout(null);
	
	JPanel Navigation_panel = new JPanel();
	Navigation_panel.setBounds(0, 409, 1044, 52);
	Navigation_panel.setBorder(new LineBorder(new Color(0, 0, 0)));
	InformazioniRistorantePane.add(Navigation_panel);
	Navigation_panel.setLayout(null);
	
	JButton HomeButton = new JButton("Home");
	HomeButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(flag) {
				c.startLoginProprietario();
				setVisible(false);
			} else {
				c.startLoginManager(flag)
			}
			
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
	
	}

}
