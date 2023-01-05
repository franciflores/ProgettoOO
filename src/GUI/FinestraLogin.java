package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextField;


import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FinestraLogin extends JFrame{

	//Dichiarazioni
	private static FinestraLogin fin = null;
	private JFrame FrameLogin;
	private JTextField textFieldMatricola;
	private JTextField textFieldPassword;

	//Inizializza la Finestra
	public void initialize() {
		FrameLogin = new JFrame();
		FrameLogin.setVisible(true);
		FrameLogin.setResizable(false);
		FrameLogin.setTitle("Login");
		FrameLogin.setBounds(100, 100, 640, 480);
		FrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel PanelLogin = new JPanel();
		PanelLogin.setVisible(true);
		FrameLogin.getContentPane().add(PanelLogin, BorderLayout.CENTER);
		PanelLogin.setLayout(null);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(141, 159, 350, 20);
		PanelLogin.add(textFieldMatricola);
		textFieldMatricola.setColumns(10);
		
		JLabel loginTextLabel = new JLabel("Effettua il Login");
		loginTextLabel.setToolTipText("non sai chi sono io ma mangio le gambe di lux nel tempo libero\r\n");
		loginTextLabel.setLabelFor(textFieldMatricola);
		loginTextLabel.setBounds(269, 134, 80, 14);
		PanelLogin.add(loginTextLabel);
		
		JLabel matricolaLabel = new JLabel("Matricola");
		matricolaLabel.setBounds(85, 162, 46, 14);
		PanelLogin.add(matricolaLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(85, 208, 46, 14);
		PanelLogin.add(passwordLabel);
		
		textFieldPassword = new JTextField();
		textFieldPassword.setBounds(141, 205, 350, 20);
		PanelLogin.add(textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(260, 236, 89, 23);
		PanelLogin.add(btnLogin);
	}
	
	//Costruttore privato (Facciamo un singleton)
	public static FinestraLogin getInstance() 
	{
		if (fin==null)
			fin = new FinestraLogin();
		return fin;
	}
}

