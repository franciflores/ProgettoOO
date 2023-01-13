package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
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
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class MenuOperazioni extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MenuOperazioni(final Controller controller) {
		setResizable(false);
		setTitle("Menu Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAzioni = new JLabel("\"qui metteremo 'benvenuto x' con il nome dell'utente\"");
		lblAzioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblAzioni.setBounds(10, 5, 464, 18);
		lblAzioni.setFont(new Font("Gill Sans Nova", Font.BOLD, 14));
		contentPane.add(lblAzioni);
		
		JButton btnNuovaTartaruga = new JButton("Nuova Tartaruga");
		btnNuovaTartaruga.setBounds(151, 59, 171, 25);
		btnNuovaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cambiare con un setter questa Variabile
				controller.SceltaPanel = controller.DialogTartarughe();
				controller.ShowTartarugaFrame();
			}
		});
		btnNuovaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnNuovaTartaruga);
		
		JButton btnCreaVasca = new JButton("Nuova Vasca");
		btnCreaVasca.setEnabled(false);
		btnCreaVasca.setBounds(10, 59, 135, 25);
		btnCreaVasca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowVascaFrame();
			}
		});
		btnCreaVasca.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaVasca);
		
		JLabel lblOperazioni = new JLabel("Operazioni");
		lblOperazioni.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOperazioni.setBounds(200, 34, 83, 18);
		contentPane.add(lblOperazioni);
		
		JButton btnCompilaCartella = new JButton("Compila Cartella");
		btnCompilaCartella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaCartella();
			}
		});
		btnCompilaCartella.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCompilaCartella.setBounds(328, 59, 146, 25);
		contentPane.add(btnCompilaCartella);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoAlLogin();
			}
		});
		btnLogOut.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnLogOut.setBounds(370, 320, 89, 23);
		contentPane.add(btnLogOut);
	}


	public void ApriOptionPaneTartaruga() {
	}
}