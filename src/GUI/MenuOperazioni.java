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
import java.awt.Component;
import javax.swing.Box;

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
		lblAzioni.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblAzioni);

		JButton btnNuovaTartaruga = new JButton("Nuova Tartaruga");
		btnNuovaTartaruga.setBounds(178, 61, 124, 21);
		btnNuovaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Cambiare con un setter questa Variabile
				controller.SceltaPanel = controller.DialogTartarughe();
				controller.ShowTartarugaFrame();
			}
		});
		btnNuovaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		contentPane.add(btnNuovaTartaruga);

		JLabel lblOperazioni = new JLabel("Operazioni");
		lblOperazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperazioni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperazioni.setBounds(10, 34, 464, 18);
		contentPane.add(lblOperazioni);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoAlLogin();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogOut.setBounds(397, 332, 77, 18);
		contentPane.add(btnLogOut);

		JButton btnStatoVasche = new JButton("Info sul Centro");
		btnStatoVasche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnStatoVasche.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStatoVasche.setBounds(10, 61, 117, 21);
		contentPane.add(btnStatoVasche);

		JButton btnCompilaCartelle = new JButton("Vedi Statistiche");
		btnCompilaCartelle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCompilaCartelle.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnCompilaCartelle.setBounds(350, 61, 124, 21);
		contentPane.add(btnCompilaCartelle);

		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(125, 63, 54, 19);
		contentPane.add(horizontalStrut);

		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(298, 61, 54, 19);
		contentPane.add(horizontalStrut_1);

		JLabel lblNewLabel = new JLabel("Operatore");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 93, 85, 14);
		contentPane.add(lblNewLabel);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(115, 87, 12, 263);
		contentPane.add(verticalStrut);

		JLabel lblNewLabel_1 = new JLabel("Medico");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(135, 93, 91, 14);
		contentPane.add(lblNewLabel_1);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(10, 296, 464, 18);
		contentPane.add(horizontalStrut_2);

		JLabel lblNewLabel_2 = new JLabel("Tecnico Laboratorio");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(258, 93, 94, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("Ricercatore");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(382, 93, 92, 14);
		contentPane.add(lblNewLabel_3);

		JButton btnNewButton = new JButton("che cosa fa l'operatore?");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(16, 113, 89, 23);
		contentPane.add(btnNewButton);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(236, 87, 12, 263);
		contentPane.add(verticalStrut_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(360, 93, 12, 263);
		contentPane.add(verticalStrut_2);
	}
}
