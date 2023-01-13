package GUI;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class FinestraTartaruga extends JFrame {
	private Controller controller;
	//private ItemEvent x;
	private JFrame finestraCorrente;
	private JTextField textFieldSpecie;
	private JTextField txtFieldLunghezza;
	private JTextField textFieldLarghezza;
	private JTextField textPeso;
	private JTextField textLuogoRitrovamento;
	private JTextField textLuogoRitrovamento_1;
	private JTextField textFieldPeso;
	private JTextField textFieldLunghezza;
	private JTextField textFieldSpecie_1;
	private JTextField textFieldLarghezza_1;
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

		/*if(panelDaAttivare==1) {
			JPanel NuovaTartaruga = new JPanel();
			getContentPane().add(NuovaTartaruga, BorderLayout.CENTER);
			NuovaTartaruga.setLayout(null);

			JLabel lblUpperTesto = new JLabel("Inserimento di una nuova Tartaruga nel centro");
			lblUpperTesto.setHorizontalAlignment(SwingConstants.CENTER);
			lblUpperTesto.setBounds(10, 5, 414, 24);
			NuovaTartaruga.add(lblUpperTesto);

			//Per ora invece di inserire la tartaruga torna al menu
			JButton btnProsegui = new JButton("Conferma");
			btnProsegui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.RitornoMenu(finestraCorrente);
				}
			});
			btnProsegui.setBounds(328, 436, 96, 23);
			NuovaTartaruga.add(btnProsegui);

			JLabel lblSpecie = new JLabel("Specie");
			lblSpecie.setHorizontalAlignment(SwingConstants.CENTER);
			lblSpecie.setBounds(10, 40, 70, 14);
			NuovaTartaruga.add(lblSpecie);

			textFieldSpecie = new JTextField();
			textFieldSpecie.setBounds(90, 37, 334, 20);
			NuovaTartaruga.add(textFieldSpecie);
			textFieldSpecie.setColumns(10);

			JLabel lblNewLabel = new JLabel("Lunghezza");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 65, 70, 14);
			NuovaTartaruga.add(lblNewLabel);

			txtFieldLunghezza = new JTextField();
			txtFieldLunghezza.setBounds(90, 62, 334, 20);
			NuovaTartaruga.add(txtFieldLunghezza);
			txtFieldLunghezza.setColumns(10);

			JLabel lblNewLabel_1 = new JLabel("Larghezza");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setBounds(10, 90, 70, 14);
			NuovaTartaruga.add(lblNewLabel_1);

			textFieldLarghezza = new JTextField();
			textFieldLarghezza.setBounds(90, 87, 334, 20);
			NuovaTartaruga.add(textFieldLarghezza);
			textFieldLarghezza.setColumns(10);

			JLabel lblPeso = new JLabel("Peso");
			lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
			lblPeso.setBounds(10, 115, 70, 14);
			NuovaTartaruga.add(lblPeso);

			textPeso = new JTextField();
			textPeso.setBounds(90, 112, 334, 20);
			NuovaTartaruga.add(textPeso);
			textPeso.setColumns(10);

			JLabel lblLuogoRitrovamento = new JLabel("Luogo del Ritrovamento ");
			lblLuogoRitrovamento.setHorizontalAlignment(SwingConstants.CENTER);
			lblLuogoRitrovamento.setBounds(10, 140, 414, 14);
			NuovaTartaruga.add(lblLuogoRitrovamento);

			JTextArea textDescrizioneSalute = new JTextArea();
			textDescrizioneSalute.setBounds(10, 213, 414, 212);
			NuovaTartaruga.add(textDescrizioneSalute);

			JButton btnNewButton = new JButton("Annulla");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.FinestraPrecedente(finestraCorrente, finestraPrec);
				}
			});
			btnNewButton.setBounds(10, 436, 89, 23);
			NuovaTartaruga.add(btnNewButton);

			textLuogoRitrovamento = new JTextField();
			textLuogoRitrovamento.setBounds(10, 157, 414, 20);
			NuovaTartaruga.add(textLuogoRitrovamento);
			textLuogoRitrovamento.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Descrivere lo stato di salute della Tartaruga:");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_2.setBounds(10, 188, 414, 14);
			NuovaTartaruga.add(lblNewLabel_2);
		}*/

		//else{
			JPanel VecchiaTartaruga = new JPanel();
			getContentPane().add(VecchiaTartaruga, BorderLayout.CENTER);
			VecchiaTartaruga.setLayout(null);

			JButton btnContinua = new JButton("Continua");
			btnContinua.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.RitornoMenu(finestraCorrente);
				}
			});
			btnContinua.setBounds(335, 490, 89, 23);
			VecchiaTartaruga.add(btnContinua);

			JLabel lblLabelTitolo = new JLabel("Targhetta della Tartaruga da riammettere:");
			lblLabelTitolo.setHorizontalAlignment(SwingConstants.CENTER);
			lblLabelTitolo.setBounds(10, 11, 414, 14);
			VecchiaTartaruga.add(lblLabelTitolo);

			textPeso = new JTextField();
			textPeso.setBounds(10, 32, 414, 20);
			VecchiaTartaruga.add(textPeso);
			textPeso.setColumns(10);

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

			JCheckBox chckbxPeso = new JCheckBox("Peso");
			chckbxPeso.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,textFieldPeso);
				}
			});
			chckbxPeso.setBounds(10, 84, 89, 23);
			VecchiaTartaruga.add(chckbxPeso);

			JCheckBox chckbxLunghezza = new JCheckBox("Lunghezza");
			chckbxLunghezza.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,textFieldLunghezza);
				}
			});
			chckbxLunghezza.setBounds(10, 110, 89, 23);
			VecchiaTartaruga.add(chckbxLunghezza);

			JCheckBox chckbxLarghezza = new JCheckBox("Larghezza");
			chckbxLarghezza.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,textFieldLarghezza_1);
				}
			});
			chckbxLarghezza.setBounds(10, 136, 89, 23);
			VecchiaTartaruga.add(chckbxLarghezza);

			JCheckBox chckbxSpecie = new JCheckBox("Specie");
			chckbxSpecie.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					StatoBottoneCambiato(e,textFieldSpecie_1);
				}
			});
			chckbxSpecie.setBounds(10, 162, 89, 23);
			VecchiaTartaruga.add(chckbxSpecie);

			JLabel lblDescrizioneLuogo = new JLabel("Dov'è stata ritrovata la tartaruga?");
			lblDescrizioneLuogo.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescrizioneLuogo.setBounds(10, 192, 414, 14);
			VecchiaTartaruga.add(lblDescrizioneLuogo);

			textLuogoRitrovamento_1 = new JTextField();
			textLuogoRitrovamento_1.setBounds(10, 217, 414, 52);
			VecchiaTartaruga.add(textLuogoRitrovamento_1);
			textLuogoRitrovamento_1.setColumns(10);

			textFieldPeso = new JTextField();
			textFieldPeso.setEnabled(false);
			textFieldPeso.setBounds(105, 88, 319, 20);
			VecchiaTartaruga.add(textFieldPeso);
			textFieldPeso.setColumns(10);

			textFieldLunghezza = new JTextField();
			textFieldLunghezza.setEnabled(false);
			textFieldLunghezza.setBounds(105, 111, 319, 20);
			VecchiaTartaruga.add(textFieldLunghezza);
			textFieldLunghezza.setColumns(10);

			textFieldSpecie_1 = new JTextField();
			textFieldSpecie_1.setEnabled(false);
			textFieldSpecie_1.setBounds(105, 162, 319, 20);
			VecchiaTartaruga.add(textFieldSpecie_1);
			textFieldSpecie_1.setColumns(10);

			textFieldLarghezza_1 = new JTextField();
			textFieldLarghezza_1.setEnabled(false);
			textFieldLarghezza_1.setBounds(105, 136, 319, 20);
			VecchiaTartaruga.add(textFieldLarghezza_1);
			textFieldLarghezza_1.setColumns(10);

			JLabel lblGiudizio = new JLabel("Esprimere un giudizio sulle condizioni di salute della Tartaruga:");
			lblGiudizio.setHorizontalAlignment(SwingConstants.CENTER);
			lblGiudizio.setBounds(10, 280, 414, 14);
			VecchiaTartaruga.add(lblGiudizio);

			JLabel lblTesta = new JLabel("Testa");
			lblTesta.setHorizontalAlignment(SwingConstants.CENTER);
			lblTesta.setBounds(10, 305, 53, 14);
			VecchiaTartaruga.add(lblTesta);

			JComboBox comboBoxTesta = new JComboBox();
			comboBoxTesta.setBounds(73, 301, 351, 22);
			VecchiaTartaruga.add(comboBoxTesta);

			JLabel lblOcchi = new JLabel("Occhi");
			lblOcchi.setHorizontalAlignment(SwingConstants.CENTER);
			lblOcchi.setBounds(10, 330, 46, 14);
			VecchiaTartaruga.add(lblOcchi);

			JComboBox comboBoxOcchi = new JComboBox();
			comboBoxOcchi.setBounds(73, 326, 351, 22);
			VecchiaTartaruga.add(comboBoxOcchi);

			JLabel lblNaso = new JLabel("Naso");
			lblNaso.setHorizontalAlignment(SwingConstants.CENTER);
			lblNaso.setBounds(10, 355, 46, 14);
			VecchiaTartaruga.add(lblNaso);

			JComboBox comboBoxNaso = new JComboBox();
			comboBoxNaso.setBounds(73, 351, 351, 22);
			VecchiaTartaruga.add(comboBoxNaso);

			JLabel lblBecco = new JLabel("Becco");
			lblBecco.setHorizontalAlignment(SwingConstants.CENTER);
			lblBecco.setBounds(10, 380, 46, 14);
			VecchiaTartaruga.add(lblBecco);

			JComboBox comboBoxBecco = new JComboBox();
			comboBoxBecco.setBounds(73, 376, 351, 22);
			VecchiaTartaruga.add(comboBoxBecco);

			JLabel lblCollo = new JLabel("Collo");
			lblCollo.setHorizontalAlignment(SwingConstants.CENTER);
			lblCollo.setBounds(10, 405, 46, 14);
			VecchiaTartaruga.add(lblCollo);

			JComboBox comboBoxCollo = new JComboBox();
			comboBoxCollo.setBounds(73, 401, 351, 22);
			VecchiaTartaruga.add(comboBoxCollo);

			JLabel lblPinne = new JLabel("Pinne");
			lblPinne.setHorizontalAlignment(SwingConstants.CENTER);
			lblPinne.setBounds(10, 430, 46, 14);
			VecchiaTartaruga.add(lblPinne);

			JComboBox comboBoxPinne = new JComboBox();
			comboBoxPinne.setBounds(73, 426, 351, 22);
			VecchiaTartaruga.add(comboBoxPinne);

			JLabel lblCoda = new JLabel("Coda");
			lblCoda.setHorizontalAlignment(SwingConstants.CENTER);
			lblCoda.setBounds(10, 455, 46, 14);
			VecchiaTartaruga.add(lblCoda);

			JComboBox comboBoxCoda = new JComboBox();
			comboBoxCoda.setBounds(73, 451, 351, 22);
			VecchiaTartaruga.add(comboBoxCoda);

		//}

		}

	public void StatoBottoneCambiato(ItemEvent Evento, JTextField barraDiTesto) {
		if(Evento.getStateChange()==1) {
			barraDiTesto.setEnabled(true);
		}
		else {
			barraDiTesto.setEnabled(false);
		}
	}
}
