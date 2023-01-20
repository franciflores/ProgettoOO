package GUI;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;

public class FinestraCiboDato extends JFrame {

	JSpinner spinnerPesce;
	JSpinner spinnerGamberetti;
	JSpinner spinnerAlici;
	JSpinner spinner;
	JFrame finestraCorrente = this;
	JSpinner spinner1Pesce1;
	JSpinner spinner1Gamberetti1;
	JSpinner spinner1Alici1;
	JSpinner spinnerGamberetti_1;
	JSpinner spinner_1;
	private JPanel contentPane;

	
	/**
	 * Create the frame.
	 */
	public FinestraCiboDato(final Controller c) {
		setTitle("ch s magn sta tartarug");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 261);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInformazioni = new JLabel("Informazoni sul cibo dato e consumato:");
		lblInformazioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformazioni.setBounds(10, 5, 414, 14);
		panel.add(lblInformazioni);
		
		JCheckBox lblPesce = new JCheckBox("Pesce");
		lblPesce.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e,spinnerPesce);
			}
		});
		lblPesce.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce.setBounds(66, 26, 78, 22);
		panel.add(lblPesce);
		
		spinnerPesce = new JSpinner();
		spinnerPesce.setBounds(67, 55, 78, 20);
		panel.add(spinnerPesce);
		spinnerPesce.setEnabled(false);
		
		JCheckBox chckbxGamberetti = new JCheckBox("Gamberetti");
		chckbxGamberetti.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e,spinnerGamberetti);
			}
		});
		chckbxGamberetti.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti.setBounds(155, 26, 78, 23);
		panel.add(chckbxGamberetti);
		
		
		spinnerGamberetti = new JSpinner();
		spinnerGamberetti.setBounds(155, 55, 78, 20);
		panel.add(spinnerGamberetti);
		spinnerGamberetti.setEnabled(false);
		
		JCheckBox chckbxAlici = new JCheckBox("Alici");
		chckbxAlici.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerAlici);
			}
		});
		chckbxAlici.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici.setBounds(243, 26, 78, 23);
		panel.add(chckbxAlici);
		
		spinnerAlici = new JSpinner();
		spinnerAlici.setBounds(243, 55, 78, 20);
		panel.add(spinnerAlici);
		spinnerAlici.setEnabled(false);
		
		JCheckBox chckbxVegetali = new JCheckBox("Vegetali");
		chckbxVegetali.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner);
			}
		});
		chckbxVegetali.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali.setBounds(327, 26, 78, 23);
		panel.add(chckbxVegetali);
		
		spinner = new JSpinner();
		spinner.setBounds(331, 55, 78, 20);
		panel.add(spinner);
		spinner.setEnabled(false);
		
		JLabel lblNewLabel = new JLabel("(Grammi)");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 147, 55, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Dato:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 30, 50, 14);
		panel.add(lblNewLabel_1);
		
		JCheckBox lblPesce1 = new JCheckBox("Pesce");
		lblPesce1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce1.setBounds(66, 26, 78, 22);
		panel.add(lblPesce1);
		
		spinner1Pesce1 = new JSpinner();
		spinner1Pesce1.setBounds(66, 144, 78, 20);
		panel.add(spinner1Pesce1);
		spinner1Pesce1.setEnabled(false);
		
		JCheckBox chckbxGamberetti1 = new JCheckBox("Gamberetti");
		chckbxGamberetti1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti1.setBounds(1105, 26, 78, 23);
		panel.add(chckbxGamberetti1);
		
		spinner1Gamberetti1 = new JSpinner();
		spinner1Gamberetti1.setBounds(1105, 105, 78, 20);
		panel.add(spinner1Gamberetti1);
		spinner1Gamberetti1.setEnabled(false);
		
		JCheckBox chckbxAlici1 = new JCheckBox("Alici");
		chckbxAlici1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici1.setBounds(243, 26, 78, 23);
		panel.add(chckbxAlici1);
		
		spinner1Alici1 = new JSpinner();
		spinner1Alici1.setBounds(243, 144, 78, 20);
		panel.add(spinner1Alici1);
		spinner1Alici1.setEnabled(false);
		
		JCheckBox chckbxVegetali1 = new JCheckBox("Vegetali");
		chckbxVegetali1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali1.setBounds(327, 26, 78, 23);
		panel.add(chckbxVegetali1);
		
		JLabel lblGrammi1 = new JLabel("(Grammi)");
		lblGrammi1.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrammi1.setBounds(10, 58, 55, 14);
		panel.add(lblGrammi1);
		
		
		JLabel lblMangiati = new JLabel("Mangiato:");
		lblMangiati.setHorizontalAlignment(SwingConstants.CENTER);
		lblMangiati.setBounds(15, 119, 50, 17);
		panel.add(lblMangiati);
		
		spinnerGamberetti_1 = new JSpinner();
		spinnerGamberetti_1.setBounds(155, 144, 78, 20);
		panel.add(spinnerGamberetti_1);
		spinnerGamberetti_1.setEnabled(false);
		
		spinner_1 = new JSpinner();
		spinner_1.setBounds(331, 144, 78, 20);
		panel.add(spinner_1);
		spinner_1.setEnabled(false);
		
		JCheckBox lblPesce_1 = new JCheckBox("Pesce");
		lblPesce_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner1Pesce1);
			}
		});
		lblPesce_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesce_1.setBounds(66, 115, 78, 22);
		panel.add(lblPesce_1);
		
		JCheckBox chckbxGamberetti_1 = new JCheckBox("Gamberetti");
		chckbxGamberetti_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinnerGamberetti_1);
			}
		});
		chckbxGamberetti_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxGamberetti_1.setBounds(155, 116, 78, 23);
		panel.add(chckbxGamberetti_1);
		
		JCheckBox chckbxAlici_1 = new JCheckBox("Alici");
		chckbxAlici_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner1Alici1);
			}
		});
		chckbxAlici_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxAlici_1.setBounds(243, 116, 78, 23);
		panel.add(chckbxAlici_1);
		
		JCheckBox chckbxVegetali_1 = new JCheckBox("Vegetali");
		chckbxVegetali_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				CambiaStato(e, spinner_1);
			}
		});
		chckbxVegetali_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxVegetali_1.setBounds(331, 116, 78, 23);
		panel.add(chckbxVegetali_1);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				c.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setBounds(10, 184, 89, 23);
		panel.add(btnAnnulla);
		
		JButton btnContinua = new JButton("Inserisci");
		btnContinua.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				c.RitornoMenu(finestraCorrente);
			}
		});
		btnContinua.setBounds(335, 184, 89, 23);
		panel.add(btnContinua);
	}
	
	public void CambiaStato(ItemEvent e, Component spinner) {
	if(e.getStateChange()==1)
		spinner.setEnabled(true);
	else
		spinner.setEnabled(false);
	}
}
