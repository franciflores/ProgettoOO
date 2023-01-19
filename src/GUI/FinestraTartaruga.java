package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneValoreNumerico;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;

public class FinestraTartaruga extends JFrame {
	private Controller controller;
	//private ItemEvent x;
	private JFrame finestraCorrente;
	private JTextField textTarghetta;
	private JTextField textFieldSpecie;
	private JSpinner jSpinnerLunghezza;
	private JSpinner jSpinnerLarghezza;
	private JSpinner jSpinnerPeso;
	private JTextField textLuogo;
	private JTextField textLuogoRitrovamento;
	private JSpinner jSpinnerPesoRitrovamento;
	private JSpinner jSpinnerLunghezzaRitrovamento;
	private JTextField textFieldSpecieRitrovamento;
	private JSpinner jSpinnerLarghezzaRitrovamento;
	/**
	 * Create the frame.
	 */
	public FinestraTartaruga(Controller c, int panelDaAttivare,JFrame finestraPrecedente) {
		setTitle("Inserimento Tartaruga nel Sistema");
		controller = c;
		finestraCorrente = this;
		final JFrame finestraPrec = finestraPrecedente;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 559);

		if(panelDaAttivare==1) {
			JPanel NuovaTartaruga = new JPanel();
			getContentPane().add(NuovaTartaruga, BorderLayout.CENTER);
			NuovaTartaruga.setLayout(null);

			JLabel lblUpperTesto = new JLabel("Inserimento di una nuova Tartaruga nel centro");
			lblUpperTesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblUpperTesto.setBounds(10, 5, 414, 24);
			NuovaTartaruga.add(lblUpperTesto);

			JLabel lblSpecie = new JLabel("Specie");
			lblSpecie.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpecie.setBounds(10, 115, 95, 14);
			NuovaTartaruga.add(lblSpecie);

			textFieldSpecie = new JTextField();
			textFieldSpecie.setBounds(115, 112, 309, 20);
			NuovaTartaruga.add(textFieldSpecie);
			textFieldSpecie.setColumns(10);

			JLabel lblLunghezza = new JLabel("Lunghezza (cm)");
			lblLunghezza.setHorizontalAlignment(SwingConstants.CENTER);
			lblLunghezza.setBounds(10, 65, 95, 14);
			NuovaTartaruga.add(lblLunghezza);

			jSpinnerLunghezza = new JSpinner();
			jSpinnerLunghezza.setBounds(115, 62, 309, 20);
			NuovaTartaruga.add(jSpinnerLunghezza);

			JLabel lblLarghezza = new JLabel("Larghezza (cm)");
			lblLarghezza.setHorizontalAlignment(SwingConstants.CENTER);
			lblLarghezza.setBounds(10, 90, 95, 14);
			NuovaTartaruga.add(lblLarghezza);

			jSpinnerLarghezza = new JSpinner();
			jSpinnerLarghezza.setBounds(115, 87, 309, 20);
			NuovaTartaruga.add(jSpinnerLarghezza);

			JLabel lblPeso = new JLabel("Peso (g)");
			lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
			lblPeso.setBounds(10, 40, 95, 14);
			NuovaTartaruga.add(lblPeso);

			jSpinnerPeso = new JSpinner();
			jSpinnerPeso.setBounds(115, 37, 309, 20);
			NuovaTartaruga.add(jSpinnerPeso);

			JLabel lblLuogoRitrovamento = new JLabel("Luogo del Ritrovamento ");
			lblLuogoRitrovamento.setHorizontalAlignment(SwingConstants.CENTER);
			lblLuogoRitrovamento.setBounds(10, 140, 414, 14);
			NuovaTartaruga.add(lblLuogoRitrovamento);

			JButton btnNewButton = new JButton("Annulla");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.FinestraPrecedente(finestraCorrente, finestraPrec);
				}
			});
			btnNewButton.setBounds(10, 486, 89, 23);
			NuovaTartaruga.add(btnNewButton);

			textLuogo = new JTextField();
			textLuogo.setBounds(10, 157, 414, 112);
			NuovaTartaruga.add(textLuogo);
			textLuogo.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Esprimere un giudizio sulle condizioni di salute della Tartaruga:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(10, 280, 414, 14);
			NuovaTartaruga.add(lblNewLabel_2);

			JLabel lblTestaN = new JLabel("Testa");
			lblTestaN.setHorizontalAlignment(SwingConstants.CENTER);
			lblTestaN.setBounds(10, 305, 53, 14);
			NuovaTartaruga.add(lblTestaN);

			JComboBox comboBoxTestaN = new JComboBox();
			comboBoxTestaN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxTestaN.setMaximumRowCount(5);
			comboBoxTestaN.setBounds(73, 301, 351, 22);
			NuovaTartaruga.add(comboBoxTestaN);


			JLabel lblOcchiN = new JLabel("Occhi");
			lblOcchiN.setHorizontalAlignment(SwingConstants.CENTER);
			lblOcchiN.setBounds(10, 330, 46, 14);
			NuovaTartaruga.add(lblOcchiN);

			JComboBox comboBoxOcchiN = new JComboBox();
			comboBoxOcchiN.setMaximumRowCount(5);
			comboBoxOcchiN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxOcchiN.setBounds(73, 326, 351, 22);
			NuovaTartaruga.add(comboBoxOcchiN);

			JLabel lblNasoN = new JLabel("Naso");
			lblNasoN.setHorizontalAlignment(SwingConstants.CENTER);
			lblNasoN.setBounds(10, 355, 46, 14);
			NuovaTartaruga.add(lblNasoN);

			JComboBox comboBoxNasoN = new JComboBox();
			comboBoxNasoN.setMaximumRowCount(5);
			comboBoxNasoN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxNasoN.setBounds(73, 351, 351, 22);
			NuovaTartaruga.add(comboBoxNasoN);

			JLabel lblBeccoN = new JLabel("Becco");
			lblBeccoN.setHorizontalAlignment(SwingConstants.CENTER);
			lblBeccoN.setBounds(10, 380, 46, 14);
			NuovaTartaruga.add(lblBeccoN);

			JComboBox comboBoxBeccoN = new JComboBox();
			comboBoxBeccoN.setMaximumRowCount(5);
			comboBoxBeccoN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxBeccoN.setBounds(73, 376, 351, 22);
			NuovaTartaruga.add(comboBoxBeccoN);

			JLabel lblColloN = new JLabel("Collo");
			lblColloN.setHorizontalAlignment(SwingConstants.CENTER);
			lblColloN.setBounds(10, 405, 46, 14);
			NuovaTartaruga.add(lblColloN);

			JComboBox comboBoxColloN = new JComboBox();
			comboBoxColloN.setMaximumRowCount(5);
			comboBoxColloN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxColloN.setBounds(73, 401, 351, 22);
			NuovaTartaruga.add(comboBoxColloN);

			JLabel lblPinneN = new JLabel("Pinne");
			lblPinneN.setHorizontalAlignment(SwingConstants.CENTER);
			lblPinneN.setBounds(10, 430, 46, 14);
			NuovaTartaruga.add(lblPinneN);

			JComboBox comboBoxPinneN = new JComboBox();
			comboBoxPinneN.setMaximumRowCount(5);
			comboBoxPinneN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxPinneN.setBounds(73, 426, 351, 22);
			NuovaTartaruga.add(comboBoxPinneN);

			JLabel lblCodaN = new JLabel("Coda");
			lblCodaN.setHorizontalAlignment(SwingConstants.CENTER);
			lblCodaN.setBounds(10, 455, 46, 14);
			NuovaTartaruga.add(lblCodaN);

			JComboBox comboBoxCodaN = new JComboBox();
			comboBoxCodaN.setMaximumRowCount(5);
			comboBoxCodaN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxCodaN.setBounds(73, 451, 351, 22);
			NuovaTartaruga.add(comboBoxCodaN);
			

			//Per ora invece di inserire la tartaruga torna al menu
			JButton btnProsegui = new JButton("Conferma");
			btnProsegui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Double valorePeso;
						Double lunghezza;
						Double larghezza;
						
						valorePeso = Double.parseDouble(jSpinnerPeso.getValue().toString());
						lunghezza = Double.parseDouble(jSpinnerLunghezza.getValue().toString());
						larghezza = Double.parseDouble(jSpinnerLarghezza.getValue().toString());
						
						if(valorePeso <= 0 || lunghezza <= 0 || larghezza <= 0) {
							throw new EccezioneValoreNumerico("Non posso esistere valore negativi o prossimi allo 0");
						}
						
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(finestraCorrente, "Inserisci solo un valore numerico!", "Attenzione", JOptionPane.OK_OPTION);
					} catch (EccezioneValoreNumerico e1) {
						e1.MostraJDialogErrore(finestraCorrente);
					}
				}
			});
			btnProsegui.setBounds(328, 486, 96, 23);
			NuovaTartaruga.add(btnProsegui);
		}

		else if(panelDaAttivare==0){
			JPanel VecchiaTartaruga = new JPanel();
			getContentPane().add(VecchiaTartaruga, BorderLayout.CENTER);
			VecchiaTartaruga.setLayout(null);

			JLabel lblLabelTitolo = new JLabel("Targhetta della Tartaruga da riammettere:");
			lblLabelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLabelTitolo.setBounds(10, 11, 414, 14);
			VecchiaTartaruga.add(lblLabelTitolo);

			textTarghetta = new JTextField();
			textTarghetta.setBounds(10, 32, 414, 20);
			VecchiaTartaruga.add(textTarghetta);

			JButton btnAnnulla = new JButton("Annulla");
			btnAnnulla.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.FinestraPrecedente(finestraCorrente, finestraPrec);
				}
			});
			btnAnnulla.setBounds(10, 490, 89, 23);
			VecchiaTartaruga.add(btnAnnulla);

			JLabel lblCosaCambiare = new JLabel("Cosa va cambiato?");
			lblCosaCambiare.setHorizontalAlignment(SwingConstants.CENTER);
			lblCosaCambiare.setBounds(10, 63, 414, 14);
			VecchiaTartaruga.add(lblCosaCambiare);

			JCheckBox chckbxPeso = new JCheckBox("Peso (g)");
			chckbxPeso.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,jSpinnerPesoRitrovamento);
				}
			});
			chckbxPeso.setBounds(10, 84, 110, 23);
			VecchiaTartaruga.add(chckbxPeso);

			JCheckBox chckbxLunghezza = new JCheckBox("Lunghezza (cm)");
			chckbxLunghezza.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,jSpinnerLunghezzaRitrovamento);
				}
			});
			chckbxLunghezza.setBounds(10, 110, 120, 23);
			VecchiaTartaruga.add(chckbxLunghezza);
			
			JCheckBox chckbxLarghezza = new JCheckBox("Larghezza (cm)");
			chckbxLarghezza.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,jSpinnerLarghezzaRitrovamento);
				}
			});
			chckbxLarghezza.setBounds(10, 136, 120, 23);
			VecchiaTartaruga.add(chckbxLarghezza);

			JCheckBox chckbxSpecie = new JCheckBox("Specie");
			chckbxSpecie.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,textFieldSpecieRitrovamento);
				}
			});
			chckbxSpecie.setBounds(10, 162, 110, 23);
			VecchiaTartaruga.add(chckbxSpecie);

			JLabel lblDescrizioneLuogo = new JLabel("Dov'è stata ritrovata la tartaruga?");
			lblDescrizioneLuogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescrizioneLuogo.setBounds(10, 192, 414, 14);
			VecchiaTartaruga.add(lblDescrizioneLuogo);

			textLuogoRitrovamento = new JTextField();
			textLuogoRitrovamento.setBounds(10, 217, 414, 52);
			VecchiaTartaruga.add(textLuogoRitrovamento);
			textLuogoRitrovamento.setColumns(10);

			jSpinnerPesoRitrovamento = new JSpinner();
			jSpinnerPesoRitrovamento.setEnabled(false);
			jSpinnerPesoRitrovamento.setBounds(136, 88, 288, 20);
			VecchiaTartaruga.add(jSpinnerPesoRitrovamento);

			jSpinnerLunghezzaRitrovamento = new JSpinner();
			jSpinnerLunghezzaRitrovamento.setModel(new SpinnerNumberModel(0, null, 10000, 1));
			jSpinnerLunghezzaRitrovamento.setEnabled(false);
			jSpinnerLunghezzaRitrovamento.setBounds(136, 111, 288, 20);
			VecchiaTartaruga.add(jSpinnerLunghezzaRitrovamento);

			textFieldSpecieRitrovamento = new JTextField();
			textFieldSpecieRitrovamento.setEnabled(false);
			textFieldSpecieRitrovamento.setBounds(136, 162, 288, 20);
			VecchiaTartaruga.add(textFieldSpecieRitrovamento);
			textFieldSpecieRitrovamento.setColumns(10);

			jSpinnerLarghezzaRitrovamento = new JSpinner();
			jSpinnerLarghezzaRitrovamento.setModel(new SpinnerNumberModel(0, null, 10000, 1));
			jSpinnerLarghezzaRitrovamento.setEnabled(false);
			jSpinnerLarghezzaRitrovamento.setBounds(136, 136, 288, 20);
			VecchiaTartaruga.add(jSpinnerLarghezzaRitrovamento);

			JLabel lblGiudizio = new JLabel("Esprimere un giudizio sulle condizioni di salute della Tartaruga:");
			lblGiudizio.setHorizontalAlignment(SwingConstants.CENTER);
			lblGiudizio.setBounds(10, 280, 414, 14);
			VecchiaTartaruga.add(lblGiudizio);

			JLabel lblTesta = new JLabel("Testa");
			lblTesta.setHorizontalAlignment(SwingConstants.CENTER);
			lblTesta.setBounds(10, 305, 53, 14);
			VecchiaTartaruga.add(lblTesta);

			JComboBox comboBoxTesta = new JComboBox();
			comboBoxTesta.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxTesta.setMaximumRowCount(5);
			comboBoxTesta.setBounds(73, 301, 351, 22);
			VecchiaTartaruga.add(comboBoxTesta);


			JLabel lblOcchi = new JLabel("Occhi");
			lblOcchi.setHorizontalAlignment(SwingConstants.CENTER);
			lblOcchi.setBounds(10, 330, 46, 14);
			VecchiaTartaruga.add(lblOcchi);

			JComboBox comboBoxOcchi = new JComboBox();
			comboBoxOcchi.setMaximumRowCount(5);
			comboBoxOcchi.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxOcchi.setBounds(73, 326, 351, 22);
			VecchiaTartaruga.add(comboBoxOcchi);

			JLabel lblNaso = new JLabel("Naso");
			lblNaso.setHorizontalAlignment(SwingConstants.CENTER);
			lblNaso.setBounds(10, 355, 46, 14);
			VecchiaTartaruga.add(lblNaso);

			JComboBox comboBoxNaso = new JComboBox();
			comboBoxNaso.setMaximumRowCount(5);
			comboBoxNaso.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxNaso.setBounds(73, 351, 351, 22);
			VecchiaTartaruga.add(comboBoxNaso);

			JLabel lblBecco = new JLabel("Becco");
			lblBecco.setHorizontalAlignment(SwingConstants.CENTER);
			lblBecco.setBounds(10, 380, 46, 14);
			VecchiaTartaruga.add(lblBecco);

			JComboBox comboBoxBecco = new JComboBox();
			comboBoxBecco.setMaximumRowCount(5);
			comboBoxBecco.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxBecco.setBounds(73, 376, 351, 22);
			VecchiaTartaruga.add(comboBoxBecco);

			JLabel lblCollo = new JLabel("Collo");
			lblCollo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCollo.setBounds(10, 405, 46, 14);
			VecchiaTartaruga.add(lblCollo);

			JComboBox comboBoxCollo = new JComboBox();
			comboBoxCollo.setMaximumRowCount(5);
			comboBoxCollo.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxCollo.setBounds(73, 401, 351, 22);
			VecchiaTartaruga.add(comboBoxCollo);

			JLabel lblPinne = new JLabel("Pinne");
			lblPinne.setHorizontalAlignment(SwingConstants.CENTER);
			lblPinne.setBounds(10, 430, 46, 14);
			VecchiaTartaruga.add(lblPinne);

			JComboBox comboBoxPinne = new JComboBox();
			comboBoxPinne.setMaximumRowCount(5);
			comboBoxPinne.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxPinne.setBounds(73, 426, 351, 22);
			VecchiaTartaruga.add(comboBoxPinne);

			JLabel lblCoda = new JLabel("Coda");
			lblCoda.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoda.setBounds(10, 455, 46, 14);
			VecchiaTartaruga.add(lblCoda);

			JComboBox comboBoxCoda = new JComboBox();
			comboBoxCoda.setMaximumRowCount(5);
			comboBoxCoda.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxCoda.setBounds(73, 451, 351, 22);
			VecchiaTartaruga.add(comboBoxCoda);
			
			JButton btnContinua = new JButton("Continua");
			btnContinua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					
					try {
						
						if(jSpinnerPesoRitrovamento.isEnabled() ) {
							Double valorePeso;
							valorePeso = Double.parseDouble(jSpinnerPesoRitrovamento.getValue().toString());
							
							if(valorePeso <= 0) {
								throw new EccezioneValoreNumerico("Non posso esistere valore negativi o prossimi allo 0");
							}
							
						}
						
						if(jSpinnerLunghezzaRitrovamento.isEnabled() ) {
							Double lunghezza;
							lunghezza = Double.parseDouble(jSpinnerLunghezzaRitrovamento.getValue().toString());
							
							if(lunghezza <= 0) {
								throw new EccezioneValoreNumerico("Non posso esistere valore negativi o prossimi allo 0");
							}
							
						}
						
						if(jSpinnerLarghezzaRitrovamento.isEnabled() ) {
							Double larghezza;
							larghezza = Double.parseDouble(jSpinnerLarghezzaRitrovamento.getValue().toString());
							
							if(larghezza <= 0) {
								throw new EccezioneValoreNumerico("Non posso esistere valore negativi o prossimi allo 0");
							}
							
						}
						
						/*Verifica finita, gli altri campi possono essere recuperati con i dovuti metodi
						 * e caricato poi tutto sul DB*/
						
						
					}
					catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(finestraCorrente, "Inserisci solo un valore numerico!", "Attenzione", JOptionPane.OK_OPTION);
					} catch (EccezioneValoreNumerico e1) {
						e1.MostraJDialogErrore(finestraCorrente);
					}

					

				}
			});
			btnContinua.setBounds(335, 490, 89, 23);
			VecchiaTartaruga.add(btnContinua);

			}

		else{
			 controller.RitornoMenu(this);
		}

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
