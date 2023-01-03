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

public class FinestraLogin {

	private JFrame FrameLogin;
	private JTextField textFieldMatricola;
	private JTextField textFieldPassword;
	
	//Dichiarazione finestra
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinestraLogin window = new FinestraLogin();
					window.FrameLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//Finestra Login
	public FinestraLogin() {
		initialize();
	}

	//Inizializza la Finestra
	private void initialize() {
		FrameLogin = new JFrame();
		FrameLogin.setResizable(false);
		FrameLogin.setTitle("Login");
		FrameLogin.setBounds(100, 100, 640, 480);
		FrameLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel PanelLogin = new JPanel();
		FrameLogin.getContentPane().add(PanelLogin, BorderLayout.CENTER);
		PanelLogin.setLayout(null);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(141, 159, 350, 20);
		PanelLogin.add(textFieldMatricola);
		textFieldMatricola.setColumns(10);
		
		JLabel loginTextLabel = new JLabel("Effettua il Login");
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
}
