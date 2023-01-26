package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Controller;
import Classi.Tartaruga;
import Eccezioni.EccezioneTartaruga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FinestraStoriaTartaruga extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldTargaTart;
	private JTable tabella;
	/**
	 * Create the frame.
	 */
	public FinestraStoriaTartaruga(final Controller controller) {
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInserisciLaTarga = new JLabel("<html>Inserisci la targa di una tartaruga <br/>per mostrare la sua storia</html>");
		lblInserisciLaTarga.setToolTipText("");
		lblInserisciLaTarga.setHorizontalAlignment(SwingConstants.CENTER);
		lblInserisciLaTarga.setFont(new Font("Verdana", Font.BOLD, 12));
		lblInserisciLaTarga.setBounds(141, 37, 206, 46);
		contentPane.add(lblInserisciLaTarga);
		
		textFieldTargaTart = new JTextField();
		textFieldTargaTart.setColumns(10);
		textFieldTargaTart.setBounds(446, 50, 151, 22);
		contentPane.add(textFieldTargaTart);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 110, 663, 96);
		contentPane.add(scrollPane);
		
		tabella = new JTable();
		scrollPane.setViewportView(tabella);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(26, 225, 111, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Lista per conservare cio' che otteniamo dal DB*/
				ArrayList<Tartaruga> listaTartarugheDB = new ArrayList<Tartaruga>();
				
				boolean esistenzaTarga = false;
				
				/*Array monodimensionale in cui salviamo unariga alla volta*/
				Object[] valoriRighe = new Object[13];
				
				/*Ottieni il riferiemnto alla tabella modello che usa JTable*/
			    DefaultTableModel modelloTabella = (DefaultTableModel) tabella.getModel();
			    
			    //Setta il numero di colonne a 0
			    modelloTabella.setColumnCount(0); 
			    
			    //Setta il numero di righe a 0
			    modelloTabella.setRowCount(0);
			    
			    /*Setta i nomi delle colonne*/
			    modelloTabella.addColumn("Targa");
			    modelloTabella.addColumn("Nome");
			    modelloTabella.addColumn("Specie");
			    modelloTabella.addColumn("Larghezza");
			    modelloTabella.addColumn("Lunghezza");
			    modelloTabella.addColumn("Peso");
			    modelloTabella.addColumn("Stato Becco");
			    modelloTabella.addColumn("Stato Coda");
			    modelloTabella.addColumn("Stato Collo");
			    modelloTabella.addColumn("Stato Naso");
		        modelloTabella.addColumn("Stato Occhi");
		        modelloTabella.addColumn("Stato Pinne");
		        modelloTabella.addColumn("Stato Testa");

				
				if(textFieldTargaTart.getText().length() > 0) {
					/*Verificare mediante Dao se il centro esiste, se si' farsi ritornare la lista delle tartarughe e mostrarle mediante una JTable
					 * altrimenti, eccezione*/
					try {
						esistenzaTarga = controller.esistenzaTargaDB(textFieldTargaTart.getText());
						
						if(esistenzaTarga) {
							 listaTartarugheDB =  controller.getTartarugheByTargaDB(textFieldTargaTart.getText()); 
							 
							 for(Tartaruga t : listaTartarugheDB) {
	
								  valoriRighe[0] = t.getTarga();
								  valoriRighe[1] = t.getNomeTartaruga();
								  valoriRighe[2] = t.getCartellaTartaruga().getSpecieTartaruga();
								  valoriRighe[3] = t.getCartellaTartaruga().getLarghezzaTartaruga();
								  valoriRighe[4] = t.getCartellaTartaruga().getLunghezzaTartaruga();
								  valoriRighe[5] = t.getCartellaTartaruga().getPesoTartaruga();
								  valoriRighe[6] = t.getDescrizioneStatoBecco();
								  valoriRighe[7] = t.getDescrizioneStatoCoda();
								  valoriRighe[8] = t.getDescrizioneStatoCollo();
								  valoriRighe[9] = t.getDescrizioneStatoNaso();
								  valoriRighe[10] = t.getDescrizioneStatoOcchi();
								  valoriRighe[11] = t.getDescrizioneStatoPinne();
								  valoriRighe[12] = t.getDescrizioneStatoTesta();
								  
								  modelloTabella.addRow(valoriRighe);
								  
							 }
						}

						else {
							throw new EccezioneTartaruga("Targa non presente!");
						}
						
					}
					catch(EccezioneTartaruga e1) {
						e1.MostraJDialogErroreScelta(finestraCorrente);
					}

				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Il campo non puo' essere vuoto", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(578, 225, 111, 25);
		contentPane.add(btnContinua);
	}
}
