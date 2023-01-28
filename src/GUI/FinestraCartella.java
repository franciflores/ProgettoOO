package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneTartaruga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class FinestraCartella extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JLabel lblDataChiusura;
	private JSpinner jSpinnerLunghezza;
	private JSpinner jSpinnerLarghezza;
	private JSpinner jSpinnerPeso;
	private JCheckBox chckbxPeso;
	private JCheckBox chckbxLarghezza;
	private JCheckBox chckbxLunghezza;
	private JComboBox comboBox;
	private JComboBox comboBoxTesta;
	private JComboBox comboBoxOcchi;
	private JComboBox comboBoxNaso;
	private JComboBox comboBoxBecco;
	private JComboBox comboBoxCollo;
	private JComboBox comboBoxPinne;
	private JComboBox comboBoxCoda;
	private JLabel lblTesta;
	private JLabel lblOcchi;
	private JLabel lblNaso;
	private JLabel lblBecco;
	private JLabel lblCollo;
	private JLabel lblPinne;
	private JLabel lblCoda;
	private JCheckBox chckbxChiudiCartella;
	private JLabel lblChiusura;
	private JRadioButton btnRilasciata;
	private JRadioButton btnDeceduta;
	private ButtonGroup buttonGroup;
	private String data;

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
				try {
					Double valorePeso;
					Double lunghezza;
					Double larghezza;
					EccezioneTartaruga eccezione = new EccezioneTartaruga();
					
					valorePeso = Double.parseDouble(jSpinnerPeso.getValue().toString());
					lunghezza = Double.parseDouble(jSpinnerLunghezza.getValue().toString());
					larghezza = Double.parseDouble(jSpinnerLarghezza.getValue().toString());
					
					if(eccezione.verificaMisure(valorePeso, lunghezza, larghezza)) {
						controller.setPesoLarghezzaLunghezzaCartella(comboBox.getSelectedItem(), jSpinnerPeso, jSpinnerLarghezza, jSpinnerLunghezza);
						controller.setValutazioneCartella(comboBox.getSelectedItem(), comboBoxTesta, comboBoxOcchi, comboBoxNaso, comboBoxCollo, comboBoxBecco, comboBoxPinne, comboBoxCoda);
						chiudiCartellaData(e, btnDeceduta, btnRilasciata, data, controller);
						controller.RitornoMenu(finestraCorrente);
					}
					else {
						throw new EccezioneTartaruga("Non posso esistere valore negativi o prossimi allo 0");
					}

				}
				catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(finestraCorrente, "Inserisci solo un valore numerico!", "Attenzione", JOptionPane.OK_OPTION);
				}catch(EccezioneTartaruga e1) {
					e1.MostraJDialogErroreScelta(finestraCorrente);
				}

			}
		});
		btnConferma.setFont(new Font("Verdana", Font.BOLD, 12));
		btnConferma.setBounds(313, 505, 111, 25);
		contentPane.add(btnConferma);
		
		comboBox = new JComboBox();
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 12));
		comboBox.setMaximumRowCount(100);
		controller.getId(comboBox);
		comboBox.setBounds(71, 40, 136, 22);
		contentPane.add(comboBox); 
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(281, 40, 103, 23);
		contentPane.add(btnContinua);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccendiCheck(e,chckbxPeso, chckbxLarghezza, chckbxLunghezza);
				AccendiBox(e, comboBoxTesta, comboBoxOcchi, comboBoxNaso, comboBoxBecco, comboBoxCollo, comboBoxPinne, comboBoxCoda);
				AccendiLabel(e, lblTesta, lblOcchi, lblNaso, lblBecco, lblCollo, lblPinne, lblCoda);
				AccendiChiusura(e, chckbxChiudiCartella);
				jSpinnerPeso.setValue(controller.getPesoById(comboBox.getSelectedItem()));
				jSpinnerLarghezza.setValue(controller.getLarghezzaById(comboBox.getSelectedItem()));
				jSpinnerLunghezza.setValue(controller.getLunghezzaById(comboBox.getSelectedItem()));
				comboBoxTesta.setSelectedItem(controller.getTestaById(comboBox.getSelectedItem()));
				comboBoxOcchi.setSelectedItem(controller.getOcchiById(comboBox.getSelectedItem()));
				comboBoxNaso.setSelectedItem(controller.getNasoById(comboBox.getSelectedItem()));
				comboBoxBecco.setSelectedItem(controller.getBeccoById(comboBox.getSelectedItem()));
				comboBoxCollo.setSelectedItem(controller.getColloById(comboBox.getSelectedItem()));
				comboBoxPinne.setSelectedItem(controller.getPinneById(comboBox.getSelectedItem()));
				comboBoxCoda.setSelectedItem(controller.getCodaById(comboBox.getSelectedItem()));
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
		
		lblTesta = new JLabel("Testa");
		lblTesta.setEnabled(false);
		lblTesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTesta.setBounds(13, 178, 53, 14);
		contentPane.add(lblTesta);

		comboBoxTesta = new JComboBox();
		comboBoxTesta.setEnabled(false);
		comboBoxTesta.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxTesta.setMaximumRowCount(5);
		comboBoxTesta.setBounds(71, 174, 351, 22);
		contentPane.add(comboBoxTesta);


		lblOcchi = new JLabel("Occhi");
		lblOcchi.setEnabled(false);
		lblOcchi.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcchi.setBounds(13, 209, 53, 14);
		contentPane.add(lblOcchi);

		comboBoxOcchi = new JComboBox();
		comboBoxOcchi.setEnabled(false);
		comboBoxOcchi.setMaximumRowCount(5);
		comboBoxOcchi.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxOcchi.setBounds(71, 205, 351, 22);
		contentPane.add(comboBoxOcchi);

		lblNaso = new JLabel("Naso");
		lblNaso.setEnabled(false);
		lblNaso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaso.setBounds(13, 240, 53, 14);
		contentPane.add(lblNaso);

		comboBoxNaso = new JComboBox();
		comboBoxNaso.setEnabled(false);
		comboBoxNaso.setMaximumRowCount(5);
		comboBoxNaso.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxNaso.setBounds(71, 236, 351, 22);
		contentPane.add(comboBoxNaso);

		lblBecco = new JLabel("Becco");
		lblBecco.setEnabled(false);
		lblBecco.setHorizontalAlignment(SwingConstants.CENTER);
		lblBecco.setBounds(13, 271, 53, 14);
		contentPane.add(lblBecco);

		comboBoxBecco = new JComboBox();
		comboBoxBecco.setEnabled(false);
		comboBoxBecco.setMaximumRowCount(5);
		comboBoxBecco.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxBecco.setBounds(71, 267, 351, 22);
		contentPane.add(comboBoxBecco);

		lblCollo = new JLabel("Collo");
		lblCollo.setEnabled(false);
		lblCollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollo.setBounds(13, 302, 53, 14);
		contentPane.add(lblCollo);

		comboBoxCollo = new JComboBox();
		comboBoxCollo.setEnabled(false);
		comboBoxCollo.setMaximumRowCount(5);
		comboBoxCollo.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCollo.setBounds(71, 298, 351, 22);
		contentPane.add(comboBoxCollo);

		lblPinne = new JLabel("Pinne");
		lblPinne.setEnabled(false);
		lblPinne.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinne.setBounds(13, 333, 53, 14);
		contentPane.add(lblPinne);

		comboBoxPinne = new JComboBox();
		comboBoxPinne.setEnabled(false);
		comboBoxPinne.setMaximumRowCount(5);
		comboBoxPinne.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxPinne.setBounds(71, 329, 351, 22);
		contentPane.add(comboBoxPinne);

		lblCoda = new JLabel("Coda");
		lblCoda.setEnabled(false);
		lblCoda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoda.setBounds(13, 364, 53, 14);
		contentPane.add(lblCoda);

		comboBoxCoda = new JComboBox();
		comboBoxCoda.setEnabled(false);
		comboBoxCoda.setMaximumRowCount(5);
		comboBoxCoda.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCoda.setBounds(71, 360, 351, 22);
		contentPane.add(comboBoxCoda);
		
		chckbxChiudiCartella = new JCheckBox("Chiudi la Cartella");
		chckbxChiudiCartella.setEnabled(false);
		chckbxChiudiCartella.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				ChiudiCartella(e,lblDataChiusura, lblChiusura, btnRilasciata, btnDeceduta);
			}
		});
		chckbxChiudiCartella.setFont(new Font("Verdana", Font.BOLD, 11));
		chckbxChiudiCartella.setBounds(45, 403, 136, 23);
		contentPane.add(chckbxChiudiCartella);
		
		LocalDate dataObj = LocalDate.now();
        DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        data = dataObj.format(formattazioneData);
		
		lblDataChiusura = new JLabel(data);
		lblDataChiusura.setVisible(false);
		lblDataChiusura.setFont(new Font("Verdana", Font.BOLD, 11));
		lblDataChiusura.setBounds(285, 405, 86, 18);
		contentPane.add(lblDataChiusura);
		
		
		lblChiusura = new JLabel("Specificare il motivo della chiusura");
		lblChiusura.setVisible(false);
		lblChiusura.setHorizontalAlignment(SwingConstants.CENTER);
		lblChiusura.setFont(new Font("Verdana", Font.BOLD, 14));
		lblChiusura.setBounds(58, 438, 313, 18);
		contentPane.add(lblChiusura);
		
		btnRilasciata = new JRadioButton("Tartaruga Rilasciata");
		btnRilasciata.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnRilasciata.setBounds(37, 465, 159, 23);
		btnRilasciata.setVisible(false);
		contentPane.add(btnRilasciata);
		
		btnDeceduta = new JRadioButton("Tartaruga Deceduta");
		btnDeceduta.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnDeceduta.setBounds(241, 465, 143, 23);
		btnDeceduta.setVisible(false);
		contentPane.add(btnDeceduta);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(btnDeceduta);
		buttonGroup.add(btnRilasciata);
		}	
	
	public void StatoBottoneCambiato(ItemEvent Evento, JSpinner JOggetto) {
		if(Evento.getStateChange()==1) {
			JOggetto.setEnabled(true);
		}
		else {
			JOggetto.setEnabled(false);
		}
	}
	public void AccendiCheck(ActionEvent Evento, JCheckBox Check1, JCheckBox Check2, JCheckBox Check3){
		if(Evento.ACTION_PERFORMED==1001) {
			Check1.setEnabled(true);
			Check2.setEnabled(true);
			Check3.setEnabled(true);
		}
	}
	public void AccendiBox(ActionEvent Evento, JComboBox Box1, JComboBox Box2, JComboBox Box3, JComboBox Box4, JComboBox Box5, JComboBox Box6, JComboBox Box7){
		if(Evento.ACTION_PERFORMED==1001) {
			Box1.setEnabled(true);
			Box2.setEnabled(true);
			Box3.setEnabled(true);
			Box4.setEnabled(true);
			Box5.setEnabled(true);
			Box6.setEnabled(true);
			Box7.setEnabled(true);
		}
}
	public void AccendiLabel(ActionEvent Evento, JLabel Lab1, JLabel Lab2,JLabel Lab3, JLabel Lab4, JLabel Lab5,JLabel Lab6, JLabel Lab7){
		if(Evento.ACTION_PERFORMED==1001) {
			Lab1.setEnabled(true);
			Lab2.setEnabled(true);
			Lab3.setEnabled(true);
			Lab4.setEnabled(true);
			Lab5.setEnabled(true);
			Lab6.setEnabled(true);
			Lab7.setEnabled(true);
		}
	}
	public void AccendiChiusura(ActionEvent Evento, JCheckBox CheckData) {
		if(Evento.ACTION_PERFORMED==1001) {
			CheckData.setEnabled(true);
		}
	}
	public void ChiudiCartella(ItemEvent Evento, JLabel JOggetto, JLabel JEtichetta, JRadioButton btn1, JRadioButton btn2) {
		if(Evento.getStateChange()==1) {
			JOggetto.setVisible(true);
			JEtichetta.setVisible(true);
			btn1.setVisible(true);
			btn2.setVisible(true);
		}
		else {
			JOggetto.setVisible(false);
			JEtichetta.setVisible(false);
			btn1.setVisible(false);
			btn2.setVisible(false);
		}
	}
	
	
	public void chiudiCartellaData (ActionEvent evento, JRadioButton btn1, JRadioButton btn2, String data, Controller controller) {
		if (btn1.isSelected()) {
			controller.setDataChiusura(comboBox.getSelectedItem(), data);
			controller.setMorte(comboBox.getSelectedItem());
		} else if (btn2.isSelected()) {
			controller.setDataChiusura(comboBox.getSelectedItem(), data);
		}
	
	}
}


