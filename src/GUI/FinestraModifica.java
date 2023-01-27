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

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class FinestraModifica extends JFrame{
	
	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField txtNome;
	private JTextField txtTarga;
	private JTextField txtSpecie;
	private JTextField txtLuogo;
	private JCheckBox chckbxNome;
	private JCheckBox chckbxSesso;
	private JCheckBox chckbxTarga;
	private JCheckBox chckbxSpecie;
	private JCheckBox chckbxLuogo;
	private JCheckBox chckbxElimina;
	private JComboBox comboBox;
	private ButtonGroup group;
	private JRadioButton rdbtnMaschio;
	private JRadioButton rdbtnFemmina;
	
	
	public FinestraModifica (final Controller controller) {
		
		setTitle("Modifica una tartauga");
		setVisible(true);
		finestraCorrente=this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 379);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		
		JLabel lblModifica = new JLabel("Scegli l'id della tartaruga da modificare");
		lblModifica.setFont(new Font("Verdana", Font.BOLD, 11));
		lblModifica.setHorizontalAlignment(SwingConstants.CENTER);
		lblModifica.setBounds(86, 11, 267, 25);
		getContentPane().add(lblModifica);
		
		comboBox = new JComboBox();
		comboBox.setBounds(67, 47, 108, 22);
		getContentPane().add(comboBox);
		controller.getId(comboBox);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnContinua.setBounds(278, 47, 89, 23);
		getContentPane().add(btnContinua);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccendiCheck(e, chckbxNome, chckbxSesso, chckbxTarga, chckbxSpecie, chckbxLuogo);
				AccendiCheckElimina(e, chckbxElimina);
				txtNome.setText(controller.getNomeById(comboBox.getSelectedItem()));
				txtTarga.setText(controller.getTargaById(comboBox.getSelectedItem()));
				txtSpecie.setText(controller.getSpecieById(comboBox.getSelectedItem()));
				controller.selezionaBottone(comboBox.getSelectedItem(), rdbtnMaschio, rdbtnFemmina);
				txtLuogo.setText(controller.getLuogoById(comboBox.getSelectedItem()));
			}
		});
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setBounds(335, 306, 89, 23);
		getContentPane().add(btnConferma);
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setNomeTarga(comboBox.getSelectedItem(), txtNome.getText(), txtTarga.getText());
				controller.setSessoSpecieLuogo(comboBox.getSelectedItem(),txtSpecie.getText(), txtLuogo.getText(), rdbtnMaschio, rdbtnFemmina);
				inizioElimina(chckbxElimina, controller);
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(10, 306, 89, 23);
		getContentPane().add(btnAnnulla);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		chckbxNome = new JCheckBox("Nome");
		chckbxNome.setEnabled(false);
		chckbxNome.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxNome.setBounds(67, 94, 108, 14);
		getContentPane().add(chckbxNome);
		chckbxNome.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,txtNome);
			}
		});
		
		chckbxSesso = new JCheckBox("Sesso");
		chckbxSesso.setEnabled(false);
		chckbxSesso.setVerticalAlignment(SwingConstants.CENTER);
		chckbxSesso.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSesso.setBounds(67, 123, 108, 14);
		getContentPane().add(chckbxSesso);
		chckbxSesso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiatoBottoni(e,rdbtnMaschio, rdbtnFemmina);
			}
		});
		
		chckbxTarga = new JCheckBox("Targa");
		chckbxTarga.setEnabled(false);
		chckbxTarga.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxTarga.setBounds(67, 152, 108, 14);
		getContentPane().add(chckbxTarga);
		chckbxTarga.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,txtTarga);
			}
		});
		
		chckbxSpecie = new JCheckBox("Specie");
		chckbxSpecie.setEnabled(false);
		chckbxSpecie.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxSpecie.setBounds(67, 181, 108, 14);
		getContentPane().add(chckbxSpecie);
		chckbxSpecie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,txtSpecie);
			}
		});
		
		chckbxLuogo = new JCheckBox("Luogo\r\n Ritrovamento");
		chckbxLuogo.setEnabled(false);
		chckbxLuogo.setHorizontalAlignment(SwingConstants.LEFT);
		chckbxLuogo.setBounds(67, 206, 131, 22);
		getContentPane().add(chckbxLuogo);
		chckbxLuogo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,txtLuogo);
			}
		});
		
		chckbxElimina = new JCheckBox("Elimina la Tartaruga");
		chckbxElimina.setEnabled(false);
		chckbxElimina.setFont(new Font("Tahoma", Font.BOLD, 11));
		chckbxElimina.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxElimina.setBounds(149, 250, 143, 23);
		getContentPane().add(chckbxElimina);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(267, 91, 116, 20);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		txtTarga = new JTextField();
		txtTarga.setEnabled(false);
		txtTarga.setBounds(267, 149, 116, 20);
		getContentPane().add(txtTarga);
		txtTarga.setColumns(10);
		
		txtSpecie = new JTextField();
		txtSpecie.setEnabled(false);
		txtSpecie.setBounds(267, 178, 116, 20);
		getContentPane().add(txtSpecie);
		txtSpecie.setColumns(10);
		
		txtLuogo = new JTextField();
		txtLuogo.setEnabled(false);
		txtLuogo.setBounds(267, 207, 116, 20);
		getContentPane().add(txtLuogo);
		txtLuogo.setColumns(10);
		
		rdbtnMaschio = new JRadioButton("Maschio");
		rdbtnMaschio.setBounds(255, 119, 69, 23);
		rdbtnMaschio.setEnabled(false);
		getContentPane().add(rdbtnMaschio);
		
		rdbtnFemmina = new JRadioButton("Femmina");
		rdbtnFemmina.setEnabled(false);
		rdbtnFemmina.setBounds(326, 119, 69, 23);
		getContentPane().add(rdbtnFemmina);
		
		group = new ButtonGroup();
		group.add(rdbtnFemmina);
		group.add(rdbtnMaschio);
	}
	
		public void AccendiCheck(ActionEvent Evento, JCheckBox Lab1, JCheckBox Lab2, JCheckBox Lab3, JCheckBox Lab4, JCheckBox Lab5){
			if(Evento.ACTION_PERFORMED==1001) {
				Lab1.setEnabled(true);
				Lab2.setEnabled(true);
				Lab3.setEnabled(true);
				Lab4.setEnabled(true);
				Lab5.setEnabled(true);
			}
		}
		
	
		public void AccendiCheckElimina (ActionEvent Evento, JCheckBox check) {
			if(Evento.ACTION_PERFORMED==1001) {
				check.setEnabled(true);
		}
		}
		
		public void StatoBottoneCambiato(ItemEvent Evento, JTextField JOggetto) {
			if(Evento.getStateChange()==1) {
				JOggetto.setEnabled(true);
			}
			else {
				JOggetto.setEnabled(false);
			}
		}
		
		public void StatoBottoneCambiatoBottoni(ItemEvent Evento, JRadioButton btn1, JRadioButton btn2) {
			if(Evento.getStateChange()==1) {
				btn1.setEnabled(true);
				btn2.setEnabled(true);
			}
			else {
				btn1.setEnabled(false);
				btn2.setEnabled(false);
			}
		}
		
		
		public void inizioElimina(JCheckBox check, Controller controller) {
			if (check.isSelected()){
				controller.eliminaTartaruga(comboBox.getSelectedItem());
			}
		}
}

