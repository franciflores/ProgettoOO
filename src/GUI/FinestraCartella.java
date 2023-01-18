package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class FinestraCartella extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;

	/**
	 * Create the frame.
	 */
	public FinestraCartella(final Controller controller) {
		setTitle("Crea Cartella Medica");
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 222);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Di quale tartaruga vuoi compilare la cartella?\r\n");
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBenvenuto.setBounds(37, 11, 367, 18);
		contentPane.add(lblBenvenuto);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 147, 111, 25);
		contentPane.add(btnAnnulla);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(313, 147, 111, 25);
		contentPane.add(btnContinua);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setMaximumRowCount(100);
		comboBox.setBounds(162, 70, 111, 22);
		contentPane.add(comboBox); //con una query sql si devono ottenere i nomi o targhe delle tartarughe in cura al centro
		
		/*JPanel CompilaCartella = new JPanel();
		getContentPane().add(CompilaCartella, BorderLayout.CENTER);
		CompilaCartella.setLayout(null);*/
		
		
		}	
	}

	

