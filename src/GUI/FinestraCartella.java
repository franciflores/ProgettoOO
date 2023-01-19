package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class FinestraCartella extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldDataChiusura;
	private JSpinner jSpinnerLunghezza;
	private JSpinner jSpinnerLarghezza;
	private JSpinner jSpinnerPeso;
	private JCheckBox chckbxPeso;
	private JCheckBox chckbxLarghezza;
	private JCheckBox chckbxLunghezza;
	private JComboBox comboBoxTesta;
	private JComboBox comboBoxOcchi;
	private JComboBox comboBoxNaso;
	private JComboBox comboBoxBecco;
	private JComboBox comboBoxCollo;
	private JComboBox comboBoxPinne;
	private JComboBox comboBoxCoda;

	/**
	 * Create the frame.
	 */
	public FinestraCartella(final Controller controller) {
		setTitle("Compila la Cartella Medica");
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 580);
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
		btnAnnulla.setBounds(13, 505, 111, 25);
		contentPane.add(btnAnnulla);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnConferma.setFont(new Font("Verdana", Font.BOLD, 12));
		btnConferma.setBounds(313, 505, 111, 25);
		contentPane.add(btnConferma);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setMaximumRowCount(100);
		comboBox.setBounds(71, 40, 136, 22);
		contentPane.add(comboBox); //con una query sql si devono ottenere i nomi o targhe delle tartarughe in cura al centro
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(281, 40, 103, 23);
		contentPane.add(btnContinua);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccendiCheck(e,chckbxPeso, chckbxLarghezza, chckbxLunghezza);
				AccendiBox(e, comboBoxTesta, comboBoxOcchi, comboBoxNaso, comboBoxBecco, comboBoxCollo, comboBoxPinne, comboBoxCoda);
			}
		});
		
		chckbxPeso = new JCheckBox("Peso (g)");
		chckbxPeso.setEnabled(false);
		chckbxPeso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerPeso);
			}
		});
		chckbxPeso.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxPeso.setBounds(71, 79, 97, 23);
		contentPane.add(chckbxPeso);
		
		chckbxLarghezza = new JCheckBox("Larghezza (cm)");
		chckbxLarghezza.setEnabled(false);
		chckbxLarghezza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerLarghezza);
			}
		});
		chckbxLarghezza.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxLarghezza.setBounds(71, 105, 136, 23);
		contentPane.add(chckbxLarghezza);
		
		chckbxLunghezza = new JCheckBox("Lunghezza (cm)");
		chckbxLunghezza.setEnabled(false);
		chckbxLunghezza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerLunghezza);
			}
		});
		chckbxLunghezza.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxLunghezza.setBounds(71, 131, 136, 23);
		contentPane.add(chckbxLunghezza);
		
		jSpinnerPeso = new JSpinner();
		jSpinnerPeso.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		jSpinnerPeso.setEnabled(false);
		jSpinnerPeso.setBounds(281, 81, 103, 20);
		contentPane.add(jSpinnerPeso);
		
		jSpinnerLarghezza = new JSpinner();
		jSpinnerLarghezza.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		jSpinnerLarghezza.setEnabled(false);
		jSpinnerLarghezza.setBounds(281, 107, 103, 20);
		contentPane.add(jSpinnerLarghezza);
		
		jSpinnerLunghezza = new JSpinner();
		jSpinnerLunghezza.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		jSpinnerLunghezza.setEnabled(false);
		jSpinnerLunghezza.setBounds(281, 133, 103, 20);
		contentPane.add(jSpinnerLunghezza);
		
		JLabel lblTesta = new JLabel("Testa");
		lblTesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTesta.setBounds(13, 178, 53, 14);
		contentPane.add(lblTesta);

		comboBoxTesta = new JComboBox();
		comboBoxTesta.setEnabled(false);
		comboBoxTesta.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxTesta.setMaximumRowCount(5);
		comboBoxTesta.setBounds(71, 174, 351, 22);
		contentPane.add(comboBoxTesta);


		JLabel lblOcchi = new JLabel("Occhi");
		lblOcchi.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcchi.setBounds(13, 209, 53, 14);
		contentPane.add(lblOcchi);

		comboBoxOcchi = new JComboBox();
		comboBoxOcchi.setEnabled(false);
		comboBoxOcchi.setMaximumRowCount(5);
		comboBoxOcchi.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxOcchi.setBounds(71, 205, 351, 22);
		contentPane.add(comboBoxOcchi);

		JLabel lblNaso = new JLabel("Naso");
		lblNaso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaso.setBounds(13, 240, 53, 14);
		contentPane.add(lblNaso);

		comboBoxNaso = new JComboBox();
		comboBoxNaso.setEnabled(false);
		comboBoxNaso.setMaximumRowCount(5);
		comboBoxNaso.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxNaso.setBounds(71, 236, 351, 22);
		contentPane.add(comboBoxNaso);

		JLabel lblBecco = new JLabel("Becco");
		lblBecco.setHorizontalAlignment(SwingConstants.CENTER);
		lblBecco.setBounds(13, 271, 53, 14);
		contentPane.add(lblBecco);

		comboBoxBecco = new JComboBox();
		comboBoxBecco.setEnabled(false);
		comboBoxBecco.setMaximumRowCount(5);
		comboBoxBecco.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxBecco.setBounds(71, 267, 351, 22);
		contentPane.add(comboBoxBecco);

		JLabel lblCollo = new JLabel("Collo");
		lblCollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollo.setBounds(13, 302, 53, 14);
		contentPane.add(lblCollo);

		comboBoxCollo = new JComboBox();
		comboBoxCollo.setEnabled(false);
		comboBoxCollo.setMaximumRowCount(5);
		comboBoxCollo.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCollo.setBounds(71, 298, 351, 22);
		contentPane.add(comboBoxCollo);

		JLabel lblPinne = new JLabel("Pinne");
		lblPinne.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinne.setBounds(13, 333, 53, 14);
		contentPane.add(lblPinne);

		comboBoxPinne = new JComboBox();
		comboBoxPinne.setEnabled(false);
		comboBoxPinne.setMaximumRowCount(5);
		comboBoxPinne.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxPinne.setBounds(71, 329, 351, 22);
		contentPane.add(comboBoxPinne);

		JLabel lblCoda = new JLabel("Coda");
		lblCoda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoda.setBounds(13, 364, 53, 14);
		contentPane.add(lblCoda);

		comboBoxCoda = new JComboBox();
		comboBoxCoda.setEnabled(false);
		comboBoxCoda.setMaximumRowCount(5);
		comboBoxCoda.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCoda.setBounds(71, 360, 351, 22);
		contentPane.add(comboBoxCoda);
		
		JCheckBox chckbxDataChiusura = new JCheckBox("Data Chiusura");
		chckbxDataChiusura.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxDataChiusura.setBounds(71, 403, 136, 23);
		contentPane.add(chckbxDataChiusura);
		
		textFieldDataChiusura = new JTextField();
		textFieldDataChiusura.setBounds(281, 405, 103, 20);
		contentPane.add(textFieldDataChiusura);
		textFieldDataChiusura.setColumns(10);
		
		JLabel lblChiusura = new JLabel("Specificare il motivo della chiusura");
		lblChiusura.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiusura.setFont(new Font("Verdana", Font.BOLD, 14));
		lblChiusura.setBounds(58, 438, 313, 18);
		contentPane.add(lblChiusura);
		
		JCheckBox chckbxRilasciata = new JCheckBox("Tartaruga Rilasciata");
		chckbxRilasciata.setFont(new Font("Verdana", Font.PLAIN, 11));
		chckbxRilasciata.setBounds(37, 465, 159, 23);
		contentPane.add(chckbxRilasciata);
		
		JCheckBox chckbxDeceduta = new JCheckBox("Tartaruga Deceduta");
		chckbxDeceduta.setFont(new Font("Verdana", Font.PLAIN, 11));
		chckbxDeceduta.setBounds(241, 465, 143, 23);
		contentPane.add(chckbxDeceduta);
		}	
	
	public void StatoBottoneCambiato(ItemEvent Evento, Object JOggetto) {
		if(Evento.getStateChange()==1) {
			((JSpinner) JOggetto).setEnabled(true);
		}
		else {
			((JSpinner) JOggetto).setEnabled(false);
		}
	}
	public void AccendiCheck(ActionEvent Evento, JCheckBox Check1, JCheckBox Check2, JCheckBox Check3){
		if(Evento.ACTION_PERFORMED==1001) {
			((Component) Check1).setEnabled(true);
			((Component) Check2).setEnabled(true);
			((Component) Check3).setEnabled(true);
		}
	}
	public void AccendiBox(ActionEvent Evento, JComboBox Box1, JComboBox Box2, JComboBox Box3, JComboBox Box4, JComboBox Box5, JComboBox Box6, JComboBox Box7){
		if(Evento.ACTION_PERFORMED==1001) {
			((Component) Box1).setEnabled(true);
			((Component) Box2).setEnabled(true);
			((Component) Box3).setEnabled(true);
			((Component) Box4).setEnabled(true);
			((Component) Box5).setEnabled(true);
			((Component) Box6).setEnabled(true);
			((Component) Box7).setEnabled(true);
		}
}
	//public void AccendiLabel(ActionEvent Evento, Object Lab1, Object Lab2, Object Lab3, Object Lab4, Object Lab5, Object Lab6, Object Lab7)
	//public void AccendiChiusura(ActionEvent Evento, Object CheckData, Object Testo, Object LabChiusura, Object CheckR, Object CheckD)
	}

	

