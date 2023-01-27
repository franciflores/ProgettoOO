package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneCibo;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;

public class FinestraModifica extends JFrame{
	
	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public FinestraModifica (final Controller controller) {
		
		setTitle("Modifica una tartauga");
		setVisible(true);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		getContentPane().setLayout(null);
		
		JLabel lblModifica = new JLabel("Scegli l'id della tartaruga da modificare");
		lblModifica.setFont(new Font("Verdana", Font.BOLD, 11));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(86, 11, 267, 25);
		getContentPane().add(lblModifica);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(67, 47, 108, 22);
		getContentPane().add(comboBox);
		controller.getId(comboBox);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnContinua.setBounds(278, 47, 89, 23);
		getContentPane().add(btnContinua);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBounds(335, 306, 89, 23);
		getContentPane().add(btnConferma);
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(10, 306, 89, 23);
		getContentPane().add(btnAnnulla);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setBounds(101, 94, 46, 14);
		getContentPane().add(lblNome);
		
		JLabel lblSesso = new JLabel("Sesso");
		lblSesso.setVerticalAlignment(SwingConstants.CENTER);
		lblSesso.setHorizontalAlignment(SwingConstants.CENTER);
		lblSesso.setBounds(101, 123, 46, 14);
		getContentPane().add(lblSesso);
		
		JLabel lblTarga = new JLabel("Targa");
		lblTarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblTarga.setBounds(101, 156, 46, 14);
		getContentPane().add(lblTarga);
		
		JLabel lblSpecie = new JLabel("Specie");
		lblSpecie.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpecie.setBounds(101, 181, 46, 14);
		getContentPane().add(lblSpecie);
		
		JLabel lblLuogo = new JLabel("Luogo\r\n Ritrovamento");
		lblLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLuogo.setBounds(67, 206, 116, 22);
		getContentPane().add(lblLuogo);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Elimina la Tartaruga");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBounds(149, 250, 143, 23);
		getContentPane().add(chckbxNewCheckBox);
		
		textField = new JTextField();
		textField.setBounds(267, 91, 116, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(267, 120, 116, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(267, 149, 116, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(267, 178, 116, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(267, 207, 116, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		contentPane = new JPanel();
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		
	}
}
