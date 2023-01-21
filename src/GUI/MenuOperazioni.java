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
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				//Cambiare con un setter questa Variabile
				controller.SceltaPanel = controller.DialogTartarughe();
				if((Integer)controller.SceltaPanel==0 || (Integer)controller.SceltaPanel==1)
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

		JLabel lblOperatore = new JLabel("Operatore");
		lblOperatore.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperatore.setBounds(20, 193, 85, 14);
		contentPane.add(lblOperatore);

		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBounds(115, 176, 12, 174);
		contentPane.add(verticalStrut);

		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedico.setBounds(135, 193, 91, 14);
		contentPane.add(lblMedico);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		horizontalStrut_2.setBounds(10, 296, 464, 18);
		contentPane.add(horizontalStrut_2);

		JLabel lblTecnicoLab = new JLabel("Tecnico Laboratorio");
		lblTecnicoLab.setHorizontalAlignment(SwingConstants.CENTER);
		lblTecnicoLab.setBounds(258, 193, 94, 14);
		contentPane.add(lblTecnicoLab);

		JLabel lblRicercatore = new JLabel("Ricercatore");
		lblRicercatore.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercatore.setBounds(382, 193, 92, 14);
		contentPane.add(lblRicercatore);

		JButton btnOperatore = new JButton("Cibo per Vasca");
		btnOperatore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ApriFinestraCibo();
			}
		});
		btnOperatore.setBounds(4, 213, 113, 23);
		contentPane.add(btnOperatore);

		Component verticalStrut_1 = Box.createVerticalStrut(20);
		verticalStrut_1.setBounds(236, 176, 12, 174);
		contentPane.add(verticalStrut_1);

		Component verticalStrut_2 = Box.createVerticalStrut(20);
		verticalStrut_2.setBounds(360, 176, 12, 180);
		contentPane.add(verticalStrut_2);
		
		JButton btnCompilaCartella = new JButton("Compila Cartella");
		btnCompilaCartella.setBounds(125, 213, 113, 23);
		contentPane.add(btnCompilaCartella);
		
		JButton btnTecnico = new JButton("BtnTecnico");
		btnTecnico.setBounds(245, 213, 117, 23);
		contentPane.add(btnTecnico);
		
		JButton btnRicercatore = new JButton("BtnRicercatore");
		btnRicercatore.setBounds(372, 213, 107, 23);
		contentPane.add(btnRicercatore);
		
		JButton btnModificaTartaruga = new JButton("Modifica Tartaruga ");
		btnModificaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModificaTartaruga.setBounds(178, 104, 124, 21);
		contentPane.add(btnModificaTartaruga);
		
		JButton btnStatoTartaruga = new JButton("Stato Tartaruga");
		btnStatoTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStatoTartaruga.setBounds(350, 103, 124, 21);
		contentPane.add(btnStatoTartaruga);
		
		JButton btnVediTartarughe = new JButton("Vedi Tartarughe");
		btnVediTartarughe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnVediTartarughe.setBounds(10, 103, 117, 21);
		contentPane.add(btnVediTartarughe);
		
		JButton btnListaTartarughe = new JButton("Lista Tartaruga");
		btnListaTartarughe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaFinestraListaTartarugheCentro();
			}
		});
		btnListaTartarughe.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnListaTartarughe.setBounds(10, 144, 124, 21);
		contentPane.add(btnListaTartarughe);
		btnCompilaCartella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowCartellaFrame();
			}
		});
	}
}
