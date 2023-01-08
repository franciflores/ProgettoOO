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
		
		JButton btnCreaCentro = new JButton("Nuovo Centro");
		btnCreaCentro.setBounds(287, 28, 142, 25);
		btnCreaCentro.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCreaCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowCentroFrame();
			}
		});
		contentPane.setLayout(null);
		
		JLabel lblAzioni = new JLabel("Azioni");
		lblAzioni.setBounds(205, 5, 47, 18);
		lblAzioni.setFont(new Font("Verdana", Font.BOLD, 14));
		contentPane.add(lblAzioni);
		
		JButton btnCreaTartaruga = new JButton("Nuova Tartaruga");
		btnCreaTartaruga.setBounds(16, 28, 143, 25);
		btnCreaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowTartarugaFrame();
			}
		});
		btnCreaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaTartaruga);
		contentPane.add(btnCreaCentro);
		
		JButton btnCreaVasca =new JButton("Nuova Vasca");
		btnCreaVasca.setBounds(16, 58, 143, 25);
		btnCreaVasca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowVascaFrame();
			}
		});
		btnCreaVasca.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaVasca);
		
		JButton btnCreaPersonale = new JButton("Nuovo Addetto");
		btnCreaPersonale.setBounds(287, 58, 142, 25);
		btnCreaPersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowAddettoFrame();
			}
		});
		btnCreaPersonale.setFont(new Font("Verdana", Font.PLAIN, 13));
		contentPane.add(btnCreaPersonale);
		
		JLabel lblOperazioni = new JLabel("Operazioni");
		lblOperazioni.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOperazioni.setBounds(188, 115, 83, 18);
		contentPane.add(lblOperazioni);
		
		JButton btnCompilaCartella = new JButton("Compila Cartella");
		btnCompilaCartella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaCartella();
			}
		});
		btnCompilaCartella.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCompilaCartella.setBounds(10, 152, 149, 25);
		contentPane.add(btnCompilaCartella);
	}
}
