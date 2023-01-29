package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import Eccezioni.EccezioneTartaruga;

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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ItemEvent;
import javax.swing.JSpinner;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JToggleButton;
import javax.swing.JRadioButton;
import java.awt.Toolkit;

public class FinestraTartaruga extends JFrame {
	private Controller controller;
	private ButtonGroup sesso; 
	private JFrame finestraCorrente;
	private JRadioButton rdbtnFemmina;
	private JRadioButton rdbtnMaschio;
	private JTextField textFieldSpecie;
	private JSpinner jSpinnerLunghezza;
	private JSpinner jSpinnerLarghezza;
	private JSpinner jSpinnerPeso;
	private JTextField textLuogo;
	private JTextField textFieldNome;
	private JRadioButton rdbtnFemmina1;
	private JRadioButton rdbtnMaschio1;
	private JTextField textTarga;
	private JTextField textField;
	private ArrayList<String> vascheDisponibili;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public FinestraTartaruga(Controller c,JFrame finestraPrecedente){
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fraes\\Documents\\GitHub\\ProgettoOO\\icona\\tortoise-icon-5.jpg"));
		
		setTitle("Inserimento Tartaruga nel Sistema");
		controller = c;
		vascheDisponibili = controller.recuperaVascaIdDB();
		finestraCorrente = this;
		final JFrame finestraPrec = finestraPrecedente;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 626);
		
		//if(panelDaAttivare==1) {
			JPanel NuovaTartaruga = new JPanel();
			getContentPane().add(NuovaTartaruga, BorderLayout.CENTER);
			NuovaTartaruga.setLayout(null);

			JLabel lblUpperTesto = new JLabel("Inserimento di una nuova Tartaruga nel centro");
			lblUpperTesto.setBounds(10, 5, 414, 24);
			lblUpperTesto.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblUpperTesto);

			JLabel lblSpecie = new JLabel("Specie");
			lblSpecie.setBounds(10, 68, 95, 14);
			lblSpecie.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblSpecie);
			
			final JComboBox comboBoxVasca = new JComboBox();
			comboBoxVasca.setBounds(186, 247, 238, 22);
			NuovaTartaruga.add(comboBoxVasca);
			for(String s : vascheDisponibili)
				comboBoxVasca.addItem(s);

			textFieldSpecie = new JTextField();
			textFieldSpecie.setBounds(115, 65, 309, 20);
			NuovaTartaruga.add(textFieldSpecie);
			textFieldSpecie.setColumns(10);

			JLabel lblLunghezza = new JLabel("Lunghezza (cm)");
			lblLunghezza.setBounds(10, 121, 95, 14);
			lblLunghezza.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblLunghezza);

			jSpinnerLunghezza = new JSpinner();
			jSpinnerLunghezza.setBounds(115, 118, 309, 20);
			NuovaTartaruga.add(jSpinnerLunghezza);

			JLabel lblLarghezza = new JLabel("Larghezza (cm)");
			lblLarghezza.setBounds(10, 146, 95, 14);
			lblLarghezza.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblLarghezza);

			jSpinnerLarghezza = new JSpinner();
			jSpinnerLarghezza.setBounds(115, 143, 309, 20);
			NuovaTartaruga.add(jSpinnerLarghezza);

			JLabel lblPeso = new JLabel("Peso (g)");
			lblPeso.setBounds(10, 96, 95, 14);
			lblPeso.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblPeso);

			jSpinnerPeso = new JSpinner();
			jSpinnerPeso.setBounds(115, 93, 309, 20);
			NuovaTartaruga.add(jSpinnerPeso);

			JLabel lblLuogoRitrovamento = new JLabel("Luogo del Ritrovamento ");
			lblLuogoRitrovamento.setBounds(10, 292, 414, 14);
			lblLuogoRitrovamento.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblLuogoRitrovamento);

			JButton btnNewButton = new JButton("Annulla");
			btnNewButton.setBounds(10, 553, 89, 23);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					controller.FinestraPrecedente(finestraCorrente, finestraPrec);
				}
			});
			NuovaTartaruga.add(btnNewButton);

			textLuogo = new JTextField();
			textLuogo.setBounds(10, 312, 414, 24);
			NuovaTartaruga.add(textLuogo);
			textLuogo.setColumns(10);

			JLabel lblNewLabel_2 = new JLabel("Esprimere un giudizio sulle condizioni di salute della Tartaruga:");
			lblNewLabel_2.setBounds(10, 347, 414, 14);
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblNewLabel_2);

			JLabel lblTestaN = new JLabel("Testa");
			lblTestaN.setBounds(10, 372, 53, 14);
			lblTestaN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblTestaN);

			final JComboBox comboBoxTestaN = new JComboBox();
			comboBoxTestaN.setBounds(73, 368, 351, 22);
			comboBoxTestaN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			comboBoxTestaN.setMaximumRowCount(5);
			NuovaTartaruga.add(comboBoxTestaN);


			JLabel lblOcchiN = new JLabel("Occhi");
			lblOcchiN.setBounds(10, 397, 46, 14);
			lblOcchiN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblOcchiN);

			final JComboBox comboBoxOcchiN = new JComboBox();
			comboBoxOcchiN.setBounds(73, 393, 351, 22);
			comboBoxOcchiN.setMaximumRowCount(5);
			comboBoxOcchiN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxOcchiN);

			JLabel lblNasoN = new JLabel("Naso");
			lblNasoN.setBounds(10, 422, 46, 14);
			lblNasoN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblNasoN);

			final JComboBox comboBoxNasoN = new JComboBox();
			comboBoxNasoN.setBounds(73, 418, 351, 22);
			comboBoxNasoN.setMaximumRowCount(5);
			comboBoxNasoN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxNasoN);

			JLabel lblBeccoN = new JLabel("Becco");
			lblBeccoN.setBounds(10, 447, 46, 14);
			lblBeccoN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblBeccoN);

			final JComboBox comboBoxBeccoN = new JComboBox();
			comboBoxBeccoN.setBounds(73, 443, 351, 22);
			comboBoxBeccoN.setMaximumRowCount(5);
			comboBoxBeccoN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxBeccoN);

			JLabel lblColloN = new JLabel("Collo");
			lblColloN.setBounds(10, 472, 46, 14);
			lblColloN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblColloN);

			final JComboBox comboBoxColloN = new JComboBox();
			comboBoxColloN.setBounds(73, 468, 351, 22);
			comboBoxColloN.setMaximumRowCount(5);
			comboBoxColloN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxColloN);

			JLabel lblPinneN = new JLabel("Pinne");
			lblPinneN.setBounds(10, 497, 46, 14);
			lblPinneN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblPinneN);

			final JComboBox comboBoxPinneN = new JComboBox();
			comboBoxPinneN.setBounds(73, 493, 351, 22);
			comboBoxPinneN.setMaximumRowCount(5);
			comboBoxPinneN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxPinneN);

			JLabel lblCodaN = new JLabel("Coda");
			lblCodaN.setBounds(10, 522, 46, 14);
			lblCodaN.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblCodaN);

			final JComboBox comboBoxCodaN = new JComboBox();
			comboBoxCodaN.setBounds(73, 518, 351, 22);
			comboBoxCodaN.setMaximumRowCount(5);
			comboBoxCodaN.setModel(new DefaultComboBoxModel(new String[] {"Perfetta", "Buona", "Con ferite superficiali", "Con ferite profonde", "Compromesso"}));
			NuovaTartaruga.add(comboBoxCodaN);
			
			
			JLabel lblNome = new JLabel("Nome");
			lblNome.setBounds(10, 43, 95, 14);
			lblNome.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblNome);
			
			textFieldNome = new JTextField();
			textFieldNome.setBounds(115, 40, 309, 20);
			NuovaTartaruga.add(textFieldNome);
			textFieldNome.setColumns(10);
			
			JLabel lblNewLabel = new JLabel("Sesso");
			lblNewLabel.setBounds(10, 174, 89, 14);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblNewLabel);
			
			rdbtnMaschio = new JRadioButton("Maschio");
			rdbtnMaschio.setBounds(115, 170, 154, 23);
			rdbtnMaschio.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(rdbtnMaschio);
			
			rdbtnFemmina = new JRadioButton("Femmina");
			rdbtnFemmina.setBounds(274, 170, 154, 23);
			rdbtnFemmina.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(rdbtnFemmina);
			
			sesso = new ButtonGroup();
			sesso.add(rdbtnMaschio);
			sesso.add(rdbtnFemmina);
			
			textTarga = new JTextField();
			textTarga.setBounds(186, 196, 238, 20);
			textTarga.setColumns(10);
			NuovaTartaruga.add(textTarga);
			
			//Per ora invece di inserire la tartaruga torna al menu
			JButton btnProsegui = new JButton("Conferma");
			btnProsegui.setBounds(328, 553, 96, 23);
			btnProsegui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String nuovaTarga = AggiungiPrefissoCentro(textTarga.getText());
					InviaTartaruga(nuovaTarga, textFieldNome.getText(), true, false, false, comboBoxVasca.getSelectedItem().toString(), "null", controller.getCentroCorrente());
					
					String sesso = sceltaSesso(rdbtnMaschio, rdbtnFemmina);
					creaNuovaCartellaMedica(textFieldSpecie.getText(), jSpinnerPeso.getValue(),textLuogo.getText(),
							comboBoxTestaN.getSelectedItem(), comboBoxOcchiN.getSelectedItem() , comboBoxNasoN.getSelectedItem() ,
							comboBoxColloN.getSelectedItem() , comboBoxPinneN.getSelectedItem() , comboBoxCodaN.getSelectedItem(),
							sesso, jSpinnerLunghezza.getValue(), jSpinnerLarghezza.getValue(), comboBoxBeccoN.getSelectedItem());
					
					associaCartellaMedicaTartaruga();
					controller.RitornoMenu(finestraCorrente);
				}


			});
			NuovaTartaruga.add(btnProsegui);
			
			JLabel lblNuovaTarga = new JLabel("Nuova Targa");
			lblNuovaTarga.setBounds(10, 200, 89, 14);
			lblNuovaTarga.setHorizontalAlignment(SwingConstants.CENTER);
			NuovaTartaruga.add(lblNuovaTarga);
			
			JLabel lblScegliVasca = new JLabel("Scegli Vasca");
			lblScegliVasca.setHorizontalAlignment(SwingConstants.CENTER);
			lblScegliVasca.setBounds(10, 251, 89, 14);
			NuovaTartaruga.add(lblScegliVasca);
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

		private String AggiungiPrefissoCentro(String targaNuova) {
			
			String prefissoCentro = controller.getCentroCorrente();
			String nuovaTarga = prefissoCentro.concat("-").concat(targaNuova);
			
			return nuovaTarga;
			
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
	
	public void InviaTartaruga(String targa, String nome, boolean primoaccesso, boolean  morta, boolean rilasciata, String vascaid, String cartellaid, String centroid) {	

			controller.InvioTartaruga(targa, nome, primoaccesso, morta, rilasciata, vascaid, cartellaid, centroid);

	}
}
