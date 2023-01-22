package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Controller;
import Classi.Tartaruga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class FinestraListaTartarugheCentro extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldCodCentro;
	private JTable tabella;

	/**
	 * Create the frame.
	 */
	public FinestraListaTartarugheCentro(final Controller controller) {
		setTitle("Tartarughe di un Centro");
		finestraCorrente = this;
		tabella = new JTable();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrizione = new JLabel("Inserisci il codice di un centro");
		lblDescrizione.setBounds(113, 27, 206, 46);
		lblDescrizione.setToolTipText("");
		lblDescrizione.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblDescrizione);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setBounds(10, 225, 111, 25);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		contentPane.add(btnAnnulla);
		
		textFieldCodCentro = new JTextField();
		textFieldCodCentro.setBounds(418, 40, 151, 22);
		textFieldCodCentro.setColumns(10);
		contentPane.add(textFieldCodCentro);			
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.setBounds(562, 225, 111, 25);
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/*Lista per conservare cio' che otteniamo dal DB*/
				ArrayList<Tartaruga> listaTartarugheDB = new ArrayList<Tartaruga>();
				
				/*Array monodimensionale in cui salviamo unariga alla volta*/
				Object[] valoriRighe = new Object[12];
				
				/*Ottieni il riferiemnto alla tabella modello che usa JTable*/
			    DefaultTableModel modelloTabella = (DefaultTableModel) tabella.getModel();
			    
			    /*Setta i nomi delle colonne*/
			    modelloTabella.addColumn("Targa");
			    modelloTabella.addColumn("Nome");
			    modelloTabella.addColumn("Specie");
			    modelloTabella.addColumn("Larghezza");
			    modelloTabella.addColumn("Peso");
			    modelloTabella.addColumn("Stato Becco");
			    modelloTabella.addColumn("Stato Coda");
			    modelloTabella.addColumn("Stato Collo");
			    modelloTabella.addColumn("Stato Naso");
		        modelloTabella.addColumn("Stato Occhi");
		        modelloTabella.addColumn("Stato Pinne");
		        modelloTabella.addColumn("Stato Testa");
		        
		        tabella.setEditingColumn(NORMAL);

				
				if(textFieldCodCentro.getText().length() > 0) {
					/*Verificare mediante Dao se il centro esiste, se si' farsi ritornare la lista delle tartarughe e mostrarle mediante una JTable
					 * altrimenti, eccezione*/

					 listaTartarugheDB =  controller.getTartarugheByCentroDB(textFieldCodCentro.getText()); 
					 
					 for(Tartaruga t : listaTartarugheDB) {

						  valoriRighe[0] = t.getTarga();
						  valoriRighe[1] = t.getNomeTartaruga();
						  valoriRighe[2] = t.getCartellaTartaruga().getSpecieTartaruga();
						  valoriRighe[3] = t.getCartellaTartaruga().getLarghezzaTartaruga();
						  //valoriRighe[4] = t.getCartellaTartaruga().getLunghezzaTartaruga();
						  valoriRighe[4] = t.getCartellaTartaruga().getPesoTartaruga();
						  valoriRighe[5] = t.getDescrizioneStatoBecco();
						  valoriRighe[6] = t.getDescrizioneStatoCoda();
						  valoriRighe[7] = t.getDescrizioneStatoCollo();
						  valoriRighe[8] = t.getDescrizioneStatoNaso();
						  valoriRighe[9] = t.getDescrizioneStatoOcchi();
						  valoriRighe[10] = t.getDescrizioneStatoPinne();
						  valoriRighe[11] = t.getDescrizioneStatoTesta();
						  
						  modelloTabella.addRow(valoriRighe);
						  
					 }	     	 
				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Il campo non puo' essere vuoto", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		

		
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		contentPane.add(btnContinua);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 104, 663, 96);
		contentPane.add(scrollPane);
		
		tabella = new JTable();
		scrollPane.setViewportView(tabella);
	}
}
