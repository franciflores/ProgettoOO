package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuOperazioni extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MenuOperazioni(final Controller controller) {
		setResizable(false);
		setTitle("Menu Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAzioni = new JLabel("\"qui metteremo 'benvenuto x' con il nome dell'utente\"");
		lblAzioni.setBounds(10, 5, 414, 18);
		lblAzioni.setFont(new Font("Gill Sans Nova", Font.BOLD, 14));
		contentPane.add(lblAzioni);
		
		JButton btnCreaTartaruga = new JButton("Nuova Tartaruga");
		btnCreaTartaruga.setBounds(140, 59, 143, 25);
		btnCreaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowTartarugaFrame();
			}
		});
		btnCreaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaTartaruga);
		
		JButton btnCreaVasca =new JButton("Nuova Vasca");
		btnCreaVasca.setBounds(3, 59, 135, 25);
		btnCreaVasca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowVascaFrame();
			}
		});
		btnCreaVasca.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaVasca);
		
		JLabel lblOperazioni = new JLabel("Operazioni");
		lblOperazioni.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOperazioni.setBounds(182, 34, 83, 18);
		contentPane.add(lblOperazioni);
		
		JButton btnCompilaCartella = new JButton("Compila Cartella");
		btnCompilaCartella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaCartella();
			}
		});
		btnCompilaCartella.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCompilaCartella.setBounds(285, 59, 146, 25);
		contentPane.add(btnCompilaCartella);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoAlLogin();
			}
		});
		btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnLogOut.setBounds(316, 214, 89, 23);
		contentPane.add(btnLogOut);
	}
}
