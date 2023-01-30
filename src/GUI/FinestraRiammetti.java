package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneTartaruga;
import java.awt.Toolkit;

public class FinestraRiammetti extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textLuogoRitrovamento;
	private JSpinner jSpinnerPesoRitrovamento;
	private JSpinner jSpinnerLunghezzaRitrovamento;
	private JTextField textFieldSpecieRitrovamento;
	private JSpinner jSpinnerLarghezzaRitrovamento;
	private JTextField textFieldNomeRitrovamento;
	private JRadioButton rdbtnFemmina1;
	private JRadioButton rdbtnMaschio1;
	private JTextField textTarghetta;
	private ButtonGroup sesso; 
	private Controller controller;
	private ArrayList<String> vascheDisponibili;
	/**
	 * Create the frame.
	 */
	public FinestraRiammetti(Controller c) {
		setTitle("Finestra Riammetti");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fraes\\Documents\\GitHub\\ProgettoOO\\icona\\tortoise-icon-5.jpg"));
		finestraCorrente = this;
		controller = c;
		vascheDisponibili = controller.recuperaVascaIdDB();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 556, 635);
		JPanel VecchiaTartaruga = new JPanel();
		getContentPane().add(VecchiaTartaruga, BorderLayout.CENTER);
		VecchiaTartaruga.setLayout(null);

		JLabel lblLabelTitolo = new JLabel("Targhetta della Tartaruga da riammettere:");
		lblLabelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLabelTitolo.setBounds(10, 35, 244, 14);
		VecchiaTartaruga.add(lblLabelTitolo);

		textTarghetta = new JTextField();
		textTarghetta.setToolTipText("x-xyz");
		textTarghetta.setBounds(264, 32, 151, 20);
		VecchiaTartaruga.add(textTarghetta);

		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setBounds(20, 553, 89, 23);
		VecchiaTartaruga.add(btnAnnulla);

		JCheckBox chckbxPeso = new JCheckBox("Peso (g)");
		chckbxPeso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerPesoRitrovamento);
			}
		});
		chckbxPeso.setBounds(10, 115, 110, 23);
		VecchiaTartaruga.add(chckbxPeso);

		JCheckBox chckbxLunghezza = new JCheckBox("Lunghezza (cm)");
		chckbxLunghezza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerLunghezzaRitrovamento);
			}
		});
		chckbxLunghezza.setBounds(10, 141, 120, 23);
		VecchiaTartaruga.add(chckbxLunghezza);
		
		JCheckBox chckbxLarghezza = new JCheckBox("Larghezza (cm)");
		chckbxLarghezza.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,jSpinnerLarghezzaRitrovamento);
			}
		});
		chckbxLarghezza.setBounds(10, 167, 120, 23);
		VecchiaTartaruga.add(chckbxLarghezza);

		JCheckBox chckbxSpecie = new JCheckBox("Specie");
		chckbxSpecie.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,textFieldSpecieRitrovamento);
			}
		});
		chckbxSpecie.setBounds(10, 193, 110, 23);
		VecchiaTartaruga.add(chckbxSpecie);

		JLabel lblDescrizioneLuogo = new JLabel("Dov'e' stata ritrovata la tartaruga?");
		lblDescrizioneLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrizioneLuogo.setBounds(73, 286, 414, 14);
		VecchiaTartaruga.add(lblDescrizioneLuogo);

		textLuogoRitrovamento = new JTextField();
		textLuogoRitrovamento.setBounds(10, 312, 520, 20);
		VecchiaTartaruga.add(textLuogoRitrovamento);
		textLuogoRitrovamento.setColumns(10);

		jSpinnerPesoRitrovamento = new JSpinner();
		jSpinnerPesoRitrovamento.setEnabled(false);
		jSpinnerPesoRitrovamento.setBounds(136, 116, 394, 20);
		VecchiaTartaruga.add(jSpinnerPesoRitrovamento);

		jSpinnerLunghezzaRitrovamento = new JSpinner();
		jSpinnerLunghezzaRitrovamento.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		jSpinnerLunghezzaRitrovamento.setEnabled(false);
		jSpinnerLunghezzaRitrovamento.setBounds(136, 142, 394, 20);
		VecchiaTartaruga.add(jSpinnerLunghezzaRitrovamento);

		textFieldSpecieRitrovamento = new JTextField();
		textFieldSpecieRitrovamento.setEnabled(false);
		textFieldSpecieRitrovamento.setBounds(136, 194, 394, 20);
		VecchiaTartaruga.add(textFieldSpecieRitrovamento);
		textFieldSpecieRitrovamento.setColumns(10);

		jSpinnerLarghezzaRitrovamento = new JSpinner();
		jSpinnerLarghezzaRitrovamento.setModel(new SpinnerNumberModel(0, null, 10000, 1));
		jSpinnerLarghezzaRitrovamento.setEnabled(false);
		jSpinnerLarghezzaRitrovamento.setBounds(136, 168, 394, 20);
		VecchiaTartaruga.add(jSpinnerLarghezzaRitrovamento);

		JLabel lblGiudizio = new JLabel("Esprimere un giudizio sulle condizioni di salute della Tartaruga:");
		lblGiudizio.setHorizontalAlignment(SwingConstants.CENTER);
		lblGiudizio.setBounds(91, 343, 414, 14);
		VecchiaTartaruga.add(lblGiudizio);

		JLabel lblTesta = new JLabel("Testa");
		lblTesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblTesta.setBounds(10, 368, 53, 14);
		VecchiaTartaruga.add(lblTesta);

		final JComboBox comboBoxTesta = new JComboBox();
		comboBoxTesta.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxTesta.setMaximumRowCount(5);
		comboBoxTesta.setBounds(73, 364, 457, 22);
		VecchiaTartaruga.add(comboBoxTesta);


		JLabel lblOcchi = new JLabel("Occhi");
		lblOcchi.setHorizontalAlignment(SwingConstants.CENTER);
		lblOcchi.setBounds(10, 393, 46, 14);
		VecchiaTartaruga.add(lblOcchi);

		final JComboBox comboBoxOcchi = new JComboBox();
		comboBoxOcchi.setMaximumRowCount(5);
		comboBoxOcchi.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxOcchi.setBounds(73, 389, 457, 22);
		VecchiaTartaruga.add(comboBoxOcchi);

		JLabel lblNaso = new JLabel("Naso");
		lblNaso.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaso.setBounds(10, 418, 46, 14);
		VecchiaTartaruga.add(lblNaso);

		final JComboBox comboBoxNaso = new JComboBox();
		comboBoxNaso.setMaximumRowCount(5);
		comboBoxNaso.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxNaso.setBounds(73, 414, 457, 22);
		VecchiaTartaruga.add(comboBoxNaso);

		JLabel lblBecco = new JLabel("Becco");
		lblBecco.setHorizontalAlignment(SwingConstants.CENTER);
		lblBecco.setBounds(10, 443, 46, 14);
		VecchiaTartaruga.add(lblBecco);

		final JComboBox comboBoxBecco = new JComboBox();
		comboBoxBecco.setMaximumRowCount(5);
		comboBoxBecco.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxBecco.setBounds(73, 439, 457, 22);
		VecchiaTartaruga.add(comboBoxBecco);

		JLabel lblCollo = new JLabel("Collo");
		lblCollo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCollo.setBounds(10, 468, 46, 14);
		VecchiaTartaruga.add(lblCollo);

		final JComboBox comboBoxCollo = new JComboBox();
		comboBoxCollo.setMaximumRowCount(5);
		comboBoxCollo.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCollo.setBounds(73, 464, 457, 22);
		VecchiaTartaruga.add(comboBoxCollo);

		JLabel lblPinne = new JLabel("Pinne");
		lblPinne.setHorizontalAlignment(SwingConstants.CENTER);
		lblPinne.setBounds(10, 493, 46, 14);
		VecchiaTartaruga.add(lblPinne);

		final JComboBox comboBoxPinne = new JComboBox();
		comboBoxPinne.setMaximumRowCount(5);
		comboBoxPinne.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxPinne.setBounds(73, 489, 457, 22);
		VecchiaTartaruga.add(comboBoxPinne);

		JLabel lblCoda = new JLabel("Coda");
		lblCoda.setHorizontalAlignment(SwingConstants.CENTER);
		lblCoda.setBounds(10, 518, 46, 14);
		VecchiaTartaruga.add(lblCoda);

		final JComboBox comboBoxCoda = new JComboBox();
		comboBoxCoda.setMaximumRowCount(5);
		comboBoxCoda.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
		comboBoxCoda.setBounds(73, 514, 457, 22);
		VecchiaTartaruga.add(comboBoxCoda);
		
		JCheckBox chckbxNome = new JCheckBox("Nome");
		chckbxNome.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e, textFieldNomeRitrovamento);
			}
		});
		chckbxNome.setBounds(10, 63, 97, 23);
		VecchiaTartaruga.add(chckbxNome);
		
		JCheckBox chckbxSesso = new JCheckBox("Sesso");
		chckbxSesso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				StatoBottoneCambiato(e,rdbtnMaschio1);
				StatoBottoneCambiato(e,rdbtnFemmina1);
			}
		});
		chckbxSesso.setBounds(10, 89, 97, 23);
		VecchiaTartaruga.add(chckbxSesso);
		
		
		
		
		textFieldNomeRitrovamento = new JTextField();
		textFieldNomeRitrovamento.setEnabled(false);
		textFieldNomeRitrovamento.setColumns(10);
		textFieldNomeRitrovamento.setBounds(136, 63, 394, 20);
		VecchiaTartaruga.add(textFieldNomeRitrovamento);
		
		rdbtnMaschio1 = new JRadioButton("Maschio");
		rdbtnMaschio1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnMaschio1.setBounds(191, 89, 135, 23);
		rdbtnMaschio1.setEnabled(false);
		VecchiaTartaruga.add(rdbtnMaschio1);
		
		rdbtnFemmina1 = new JRadioButton("Femmina");
		rdbtnFemmina1.setHorizontalAlignment(SwingConstants.CENTER);
		rdbtnFemmina1.setBounds(328, 89, 151, 23);
		rdbtnFemmina1.setEnabled(false);
		VecchiaTartaruga.add(rdbtnFemmina1);

		sesso = new ButtonGroup();
		sesso.add(rdbtnFemmina1);
		sesso.add(rdbtnMaschio1);

		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confermaRiammissione(comboBoxTesta, comboBoxOcchi, comboBoxNaso, comboBoxBecco, comboBoxCollo, comboBoxPinne, comboBoxCoda);
			}
		});
		btnContinua.setBounds(441, 31, 89, 23);
		VecchiaTartaruga.add(btnContinua);
		
		JLabel lblScegliVasca = new JLabel("Scegli Vasca");
		lblScegliVasca.setHorizontalAlignment(SwingConstants.CENTER);
		lblScegliVasca.setBounds(10, 247, 143, 14);
		VecchiaTartaruga.add(lblScegliVasca);
		
		final JComboBox comboBoxVasca = new JComboBox();
		comboBoxVasca.setBounds(250, 243, 238, 22);
		VecchiaTartaruga.add(comboBoxVasca);
		for(String s : vascheDisponibili)
			comboBoxVasca.addItem(s);
		
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				InviaTartaruga(textTarghetta.getText(), textFieldNomeRitrovamento.getText(), false, false, false, comboBoxVasca.getSelectedItem().toString(), "null", controller.getCentroCorrente());
				
				String sesso = sceltaSesso(rdbtnMaschio1, rdbtnFemmina1);
				creaNuovaCartellaMedica(textFieldSpecieRitrovamento.getText(), jSpinnerPesoRitrovamento.getValue(),textLuogoRitrovamento.getText(),
						comboBoxTesta.getSelectedItem(), comboBoxOcchi.getSelectedItem() , comboBoxNaso.getSelectedItem() ,
						comboBoxCollo.getSelectedItem() , comboBoxPinne.getSelectedItem() , comboBoxCoda.getSelectedItem(),
						sesso, jSpinnerLunghezzaRitrovamento.getValue(), jSpinnerLarghezzaRitrovamento.getValue(), comboBoxBecco.getSelectedItem());
				
				associaCartellaMedicaTartaruga();
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnConferma.setBounds(428, 553, 102, 23);
		VecchiaTartaruga.add(btnConferma);
	}
	
	protected void confermaRiammissione(JComboBox comboBoxTesta, JComboBox comboBoxOcchi, JComboBox comboBoxNaso, JComboBox comboBoxBecco, JComboBox comboBoxCollo, JComboBox comboBoxPinne, JComboBox comboBoxCoda) {
		EccezioneTartaruga eccezione = new EccezioneTartaruga();
		
		String idTartarugaByTarga = controller.getIdByTarga(textTarghetta.getText());

		if(idTartarugaByTarga.length() > 0) {
			
			/*Verificare se la targa esiste e che l'attributo rilasciato del record precedente sia true*/
			boolean esistenza = controller.esistenzaTargaDB(textTarghetta.getText());
			boolean rilasciata = controller.statoRilascioTartarugaDB(textTarghetta.getText());

			if(esistenza && rilasciata) {

				//Verifica finita, gli altri campi possono essere recuperati con i dovuti metodi
				jSpinnerPesoRitrovamento.setValue(controller.getPesoById(idTartarugaByTarga));
				jSpinnerLarghezzaRitrovamento.setValue(controller.getLarghezzaById(idTartarugaByTarga));
				jSpinnerLunghezzaRitrovamento.setValue(controller.getLunghezzaById(idTartarugaByTarga));
				comboBoxTesta.setSelectedItem(controller.getTestaById(idTartarugaByTarga));
				comboBoxOcchi.setSelectedItem(controller.getOcchiById(idTartarugaByTarga));
				comboBoxNaso.setSelectedItem(controller.getNasoById(idTartarugaByTarga));
				comboBoxBecco.setSelectedItem(controller.getBeccoById(idTartarugaByTarga));
				comboBoxCollo.setSelectedItem(controller.getColloById(idTartarugaByTarga));
				comboBoxPinne.setSelectedItem(controller.getPinneById(idTartarugaByTarga));
				comboBoxCoda.setSelectedItem(controller.getCodaById(idTartarugaByTarga));
				
				/*Recupera il nome della tartaruga by id*/
				textFieldNomeRitrovamento.setText(controller.getNomeById(idTartarugaByTarga));
				
				/*Recupera la specie della tartaruga by id*/
				textFieldSpecieRitrovamento.setText(controller.getSpecieById(idTartarugaByTarga));
				
				/*Recupera il sesso della tartaruga by id*/
				String sesso = controller.getSessoById(idTartarugaByTarga);
				
				if(sesso.equals("Maschio")) {
					rdbtnMaschio1.setSelected(true);
					rdbtnFemmina1.setSelected(false);
				}
				else {
					rdbtnMaschio1.setSelected(false);
					rdbtnFemmina1.setSelected(true);
				}
			}
			else {
				JOptionPane.showMessageDialog(finestraCorrente, "Targa non esistente - Tartaruga presente ma non rilasciata, impossibile riammettere", "Attenzione", JOptionPane.OK_OPTION);
			}
		} else {
			JOptionPane.showMessageDialog(finestraCorrente, "Targa vuota!", "Attenzione", JOptionPane.OK_OPTION);
		}
			
		
	}
	
	protected void creaNuovaCartellaMedica(String specie, Object peso, String luogo, Object condTesta,
			Object condOcchi, Object condNaso, Object condCollo, Object condPinne,
			Object condCoda, String sesso, Object lunghezza, Object larghezza, Object condBecco) {
			
			EccezioneTartaruga eccezione = new EccezioneTartaruga();
			
			try
			{
				Integer valorePeso;
				valorePeso = Integer.parseInt(peso.toString());
				Integer valoreLunghezza;
				valoreLunghezza = Integer.parseInt(lunghezza.toString());
				Integer valoreLarghezza;
				valoreLarghezza = Integer.parseInt(larghezza.toString());
				
				if(!eccezione.verificaMisure(valorePeso, valoreLarghezza, valoreLunghezza)) {
					throw new EccezioneTartaruga("Non posso esistere valore negativi o prossimi allo 0");
				}
				
				/*Procedo alla query sul DB*/
				controller.CreaCartellaDB(specie, valorePeso, valoreLarghezza, valoreLunghezza, luogo,
						condTesta.toString(), condOcchi.toString(), condNaso.toString(), condCollo.toString(),
						condPinne.toString(), condCoda.toString(), sesso, condBecco.toString());
			}
			catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(finestraCorrente, "Inserisci solo un valore numerico!", "Attenzione", JOptionPane.OK_OPTION);
			} catch (EccezioneTartaruga e1) {
					e1.MostraJDialogErroreScelta(finestraCorrente);
				}
					
		
		}
	
	protected void associaCartellaMedicaTartaruga() {
		
		/*Recupera l'id dell'ultima cartella inserita e associa tale id all'ultima tartaruga inserita*/
		controller.associaCartellaMedicaTartarugaDB();
	}
	
	protected String sceltaSesso(JRadioButton rdbtnMaschio, JRadioButton rdbtnFemmina) {
		String scelta = null;
		
		if(rdbtnMaschio.isSelected()) {
			scelta = "Maschio";
		}
		else {
			scelta = "Femmina";
		}
		
		return scelta;
		
	}
	
	public void InviaTartaruga(String targa, String nome, boolean primoaccesso, boolean  morta, boolean rilasciata, String vascaid, String cartellaid, String centroid) {	

		controller.InvioTartaruga(targa, nome, primoaccesso, morta, rilasciata, vascaid, cartellaid, centroid);

}

	public void StatoBottoneCambiato(ItemEvent Evento, Object barraDiTesto) {
		if(Evento.getStateChange()==1) {
			((Component) barraDiTesto).setEnabled(true);
		}
		else {
			((Component) barraDiTesto).setEnabled(false);
		}
	}
}
