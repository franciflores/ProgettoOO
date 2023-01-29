package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneCibo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Toolkit;

public class FinestraCiboDato extends JFrame {

	JSpinner spinnerPesce;
	JSpinner spinnerGamberetti;
	JSpinner spinnerAlici;
	JSpinner spinnerVerdura;
	JFrame finestraCorrente = this;
	JSpinner spinner1Pesce1;
	JSpinner spinner1Gamberetti1;
	JSpinner spinner1Alici1;
	JSpinner spinnerGamberetti_1;
	JSpinner spinnerVerdura_1;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public FinestraCiboDato(final Controller controller, final String matricolaPersonale) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fraes\\Documents\\GitHub\\ProgettoOO\\icona\\tortoise-icon-5.jpg"));
		setTitle("Finestra Cibo");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 316);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 277);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInformazioni = new JLabel("Informazoni sul cibo dato e consumato:");
		lblInformazioni.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblInformazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformazioni.setBounds(10, 11, 414, 14);
		panel.add(lblInformazioni);
		
		final JCheckBox lblPesce = new JCheckBox("Pesce");
		lblPesce.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e,spinnerPesce);
			}
		});
		lblPesce.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce.setBounds(66, 85, 78, 22);
		panel.add(lblPesce);
		
		spinnerPesce = new JSpinner();
		spinnerPesce.setBounds(67, 114, 78, 20);
		panel.add(spinnerPesce);
		spinnerPesce.setEnabled(false);
		
		final JCheckBox chckbxGamberetti = new JCheckBox("Gamberetti");
		chckbxGamberetti.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e,spinnerGamberetti);
			}
		});
		chckbxGamberetti.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti.setBounds(155, 85, 78, 23);
		panel.add(chckbxGamberetti);
		
		
		spinnerGamberetti = new JSpinner();
		spinnerGamberetti.setBounds(155, 114, 78, 20);
		panel.add(spinnerGamberetti);
		spinnerGamberetti.setEnabled(false);
		
		final JCheckBox chckbxAlici = new JCheckBox("Alici");
		chckbxAlici.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerAlici);
			}
		});
		chckbxAlici.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici.setBounds(243, 85, 78, 23);
		panel.add(chckbxAlici);
		
		spinnerAlici = new JSpinner();
		spinnerAlici.setBounds(243, 114, 78, 20);
		panel.add(spinnerAlici);
		spinnerAlici.setEnabled(false);
		
		final JCheckBox chckbxVegetali = new JCheckBox("Vegetali");
		chckbxVegetali.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerVerdura);
			}
		});
		chckbxVegetali.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali.setBounds(327, 85, 78, 23);
		panel.add(chckbxVegetali);
		
		spinnerVerdura = new JSpinner();
		spinnerVerdura.setBounds(331, 114, 78, 20);
		panel.add(spinnerVerdura);
		spinnerVerdura.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("(Grammi)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 206, 55, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dato:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 89, 50, 14);
		panel.add(lblNewLabel_1);
		
		JCheckBox lblPesce1 = new JCheckBox("Pesce");
		lblPesce1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce1.setBounds(66, 85, 78, 22);
		panel.add(lblPesce1);
		
		spinner1Pesce1 = new JSpinner();
		spinner1Pesce1.setBounds(66, 203, 78, 20);
		panel.add(spinner1Pesce1);
		spinner1Pesce1.setEnabled(false);
		
		JCheckBox chckbxGamberetti1 = new JCheckBox("Gamberetti");
		chckbxGamberetti1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti1.setBounds(1105, 85, 78, 23);
		panel.add(chckbxGamberetti1);
		
		spinner1Gamberetti1 = new JSpinner();
		spinner1Gamberetti1.setBounds(1105, 164, 78, 20);
		panel.add(spinner1Gamberetti1);
		spinner1Gamberetti1.setEnabled(false);
		
		JCheckBox chckbxAlici1 = new JCheckBox("Alici");
		chckbxAlici1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici1.setBounds(243, 85, 78, 23);
		panel.add(chckbxAlici1);
		
		spinner1Alici1 = new JSpinner();
		spinner1Alici1.setBounds(243, 203, 78, 20);
		panel.add(spinner1Alici1);
		spinner1Alici1.setEnabled(false);
		
		JCheckBox chckbxVegetali1 = new JCheckBox("Vegetali");
		chckbxVegetali1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali1.setBounds(327, 85, 78, 23);
		panel.add(chckbxVegetali1);
		
		JLabel lblGrammi1 = new JLabel("(Grammi)");
		lblGrammi1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblGrammi1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrammi1.setBounds(10, 117, 55, 14);
		panel.add(lblGrammi1);
		
		
		JLabel lblMangiati = new JLabel("Mangiato:");
		lblMangiati.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangiati.setBounds(15, 178, 50, 17);
		panel.add(lblMangiati);
		
		spinnerGamberetti_1 = new JSpinner();
		spinnerGamberetti_1.setBounds(155, 203, 78, 20);
		panel.add(spinnerGamberetti_1);
		spinnerGamberetti_1.setEnabled(false);
		
		spinnerVerdura_1 = new JSpinner();
		spinnerVerdura_1.setBounds(331, 203, 78, 20);
		panel.add(spinnerVerdura_1);
		spinnerVerdura_1.setEnabled(false);
		
		final JCheckBox lblPesce_1 = new JCheckBox("Pesce");
		lblPesce_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner1Pesce1);
			}
		});
		lblPesce_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce_1.setBounds(66, 174, 78, 22);
		panel.add(lblPesce_1);
		
		final JCheckBox chckbxGamberetti_1 = new JCheckBox("Gamberetti");
		chckbxGamberetti_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerGamberetti_1);
			}
		});
		chckbxGamberetti_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti_1.setBounds(155, 175, 78, 23);
		panel.add(chckbxGamberetti_1);
		
		final JCheckBox chckbxAlici_1 = new JCheckBox("Alici");
		chckbxAlici_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner1Alici1);
			}
		});
		chckbxAlici_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici_1.setBounds(243, 175, 78, 23);
		panel.add(chckbxAlici_1);
		
		final JCheckBox chckbxVegetali_1 = new JCheckBox("Vegetali");
		chckbxVegetali_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerVerdura_1);
			}
		});
		chckbxVegetali_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali_1.setBounds(331, 175, 78, 23);
		panel.add(chckbxVegetali_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setBounds(10, 243, 89, 23);
		panel.add(btnAnnulla);
		
		final JComboBox comboBoxIdVasca = new JComboBox();
		comboBoxIdVasca.setBounds(243, 36, 162, 22);
		controller.getIdVasca(comboBoxIdVasca);
		panel.add(comboBoxIdVasca);
		
		JLabel lblVasca = new JLabel("Seleziona Codice Vasca");
		lblVasca.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblVasca.setBounds(43, 40, 171, 14);
		panel.add(lblVasca);
		
		JButton btnContinua = new JButton("Inserisci");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
		        LocalDate dataObj = LocalDate.now();
		        DateTimeFormatter formattazioneData = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        String data = dataObj.format(formattazioneData);
				
				try {
					/*Pesce dato e mangiato? Caricare la quantita sul DB*/
					if(lblPesce.isSelected() && lblPesce_1.isSelected()) {
						
						int valueDato = (Integer) spinnerPesce.getValue();
						int valueMangiato = (Integer) spinner1Pesce1.getValue();
						
						if(valueDato > 0 && valueMangiato >= 0) {
							if(controlloQuantitaGiusta(valueMangiato, valueDato)) {
								controller.inserisciCiboDB("pesce", valueDato, valueMangiato, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
						
					}
					/*Solamente Pesce dato? Caricare la quantita sul DB*/
					else if(lblPesce.isSelected()) {
						int valueDato = (Integer) spinnerPesce.getValue();
						
						if(valueDato > 0) {
							if(controlloQuantitaGiusta(0, valueDato)) {
								controller.inserisciCiboDB("pesce", valueDato, 0, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					
					/*Gamberetti dato e mangiato? Caricare la quantita sul DB*/
					if(chckbxGamberetti.isSelected() && chckbxGamberetti_1.isSelected()) {
						
						int valueDato = (Integer) spinnerGamberetti.getValue();
						int valueMangiato = (Integer) spinnerGamberetti_1.getValue();
						
						if(valueDato > 0 && valueMangiato >= 0) {
							if(controlloQuantitaGiusta(valueMangiato, valueDato)) {
								controller.inserisciCiboDB("gamberetti", valueDato, valueMangiato, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					/*Solamente Gamberetti dato? Caricare la quantita sul DB*/
					else if(chckbxGamberetti.isSelected()) {
						int valueDato = (Integer) spinnerGamberetti.getValue();
						if(valueDato > 0) {
							if(controlloQuantitaGiusta(0, valueDato)) {
								controller.inserisciCiboDB("gamberetti", valueDato, 0, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					
					/*Alici dato e mangiato? Caricare la quantita sul DB*/
					if(chckbxAlici.isSelected() && chckbxAlici_1.isSelected()) {
						
						int valueDato = (Integer) spinnerAlici.getValue();
						int valueMangiato = (Integer) spinner1Alici1.getValue();
						if(valueDato > 0 && valueMangiato >= 0) {
							if(controlloQuantitaGiusta(valueMangiato, valueDato)) {
								controller.inserisciCiboDB("alici", valueDato, valueMangiato, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					/*Solamente Alici dato? Caricare la quantita sul DB*/
					else if(chckbxAlici.isSelected()) {
						int valueDato = (Integer) spinnerAlici.getValue();
						if(valueDato > 0) {
							if(controlloQuantitaGiusta(0, valueDato)) {
								controller.inserisciCiboDB("alici", valueDato, 0, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					
					/*Vegetali dato e mangiato? Caricare la quantita sul DB*/
					if(chckbxVegetali.isSelected() && chckbxVegetali_1.isSelected()) {
						
						int valueDato = (Integer) spinnerVerdura.getValue();
						int valueMangiato = (Integer) spinnerVerdura_1.getValue();
						if(valueDato > 0 && valueMangiato >= 0) {
							if(controlloQuantitaGiusta(valueMangiato, valueDato)) {
								controller.inserisciCiboDB("vegetali", valueDato, valueMangiato, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					/*Solamente Vegetali dato? Caricare la quantita sul DB*/
					else if(chckbxVegetali.isSelected()) {
						int valueDato = (Integer) spinnerVerdura.getValue();
						if(valueDato > 0) {
							if(controlloQuantitaGiusta(0, valueDato)) {
								controller.inserisciCiboDB("vegetali", valueDato, 0, comboBoxIdVasca.getSelectedItem().toString(), data, matricolaPersonale);
							}
						}
						else {
							throw new EccezioneCibo("Cibo dato non puo' essere 0 o assumere valore negativo; Cibo mangiato non puo' essere negativo");
						}
					}
					
					if(JOptionPane.showConfirmDialog(finestraCorrente, "Ritornare al Menu?","Inserimento completato", JOptionPane.OK_OPTION) == 0)
						controller.RitornoMenu(finestraCorrente);
				}
				catch(EccezioneCibo e1) {
					e1.MostraJDialogErrore(finestraCorrente);
				}
			}
		});
		btnContinua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnContinua.setBounds(335, 243, 89, 23);
		panel.add(btnContinua);
	}
	
	public boolean controlloQuantitaGiusta(int ciboMangiato, int ciboVersato) {
		if(ciboMangiato > ciboVersato) {
			JOptionPane.showMessageDialog(finestraCorrente, "E' stato mangiato troppo cibo rispetto a quello dato!", "Attenzione", JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void CambiaStato(ItemEvent e, Component spinner) {
	if(e.getStateChange()==1)
		spinner.setEnabled(true);
	else
		spinner.setEnabled(false);
	}
}
