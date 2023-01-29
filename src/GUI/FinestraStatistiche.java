package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Classi.Controller;
import Classi.Tartaruga;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class FinestraStatistiche extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldDataInizio;
	private JTextField textFieldDataFine;
	private JLabel lblTartMorte;
	private JLabel lblTartRilasciate;
	private JScrollPane scrollPane;
	private JButton btnAnnulla;
	private JButton btnContinua;
	private JTable tabella;
	private JFrame finestraCorrente;
	private JLabel lblTartAmmesse;

	/**
	 * Create the frame.
	 */
	public FinestraStatistiche(final Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fraes\\Documents\\GitHub\\ProgettoOO\\icona\\tortoise-icon-5.jpg"));
		setTitle("Finestra Statistiche");
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 709, 452);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDataInizio = new JLabel("Data Inizio");
		lblDataInizio.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDataInizio.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataInizio.setBounds(24, 37, 109, 14);
		contentPane.add(lblDataInizio);
		
		JLabel lblDataFine = new JLabel("Data Fine");
		lblDataFine.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblDataFine.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataFine.setBounds(405, 39, 109, 14);
		contentPane.add(lblDataFine);
		
		textFieldDataInizio = new JTextField();
		textFieldDataInizio.setToolTipText("YYYY-MM-DD");
		textFieldDataInizio.setBounds(143, 34, 96, 20);
		contentPane.add(textFieldDataInizio);
		textFieldDataInizio.setColumns(10);
		
		textFieldDataFine = new JTextField();
		textFieldDataFine.setToolTipText("YYYY-MM-DD");
		textFieldDataFine.setColumns(10);
		textFieldDataFine.setBounds(524, 36, 96, 20);
		contentPane.add(textFieldDataFine);
		
		lblTartMorte = new JLabel("Tartarughe Morte:");
		lblTartMorte.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTartMorte.setBounds(10, 121, 161, 18);
		contentPane.add(lblTartMorte);
		
		lblTartRilasciate = new JLabel("Tartarughe Rilasciate:");
		lblTartRilasciate.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTartRilasciate.setBounds(488, 121, 185, 18);
		contentPane.add(lblTartRilasciate);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 231, 663, 127);
		contentPane.add(scrollPane);
		
		tabella = new JTable();
		scrollPane.setViewportView(tabella);
		
		btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 377, 111, 25);
		contentPane.add(btnAnnulla);
		
		lblTartAmmesse = new JLabel("Tartarughe Ammesse:");
		lblTartAmmesse.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTartAmmesse.setBounds(250, 121, 185, 18);
		contentPane.add(lblTartAmmesse);
		
		final JLabel lblCiboVersato = new JLabel("Cibo Versato (g):");
		lblCiboVersato.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCiboVersato.setBounds(10, 189, 229, 18);
		contentPane.add(lblCiboVersato);
		
		final JLabel lblCiboMangiato = new JLabel("Cibo Mangiato (g):");
		lblCiboMangiato.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblCiboMangiato.setBounds(250, 189, 245, 18);
		contentPane.add(lblCiboMangiato);
		
		btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean dataValida = dataValida(textFieldDataInizio, textFieldDataFine);
				
				if(dataValida) {

					/*Elimina i vecchi valori*/
					lblTartMorte.setText("Tartarughe Morte:");
					lblTartAmmesse.setText("Tartarughe Ammesse:");
					lblTartRilasciate.setText("Tartarughe Rilasciate:");
					lblCiboVersato.setText("Cibo Versato (g):");
					lblCiboMangiato.setText("Cibo Mangiato (g):");
					
					
					/*Valori per le JLabel dinamiche*/
					Integer nAmmesse = controller.tartarugheAmmesseDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					Integer nRilasciate = controller.tartarugheRilasciateDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					Integer nMorte = controller.tartarugheMorteDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					
					Integer ciboVersato = controller.getCiboVersatoDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					Integer ciboMangiato = controller.getCiboMangiatoDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					
					lblTartMorte.setText(lblTartMorte.getText() + nMorte);
					lblTartAmmesse.setText(lblTartAmmesse.getText() + nAmmesse);
					lblTartRilasciate.setText(lblTartRilasciate.getText() + nRilasciate);
					lblCiboVersato.setText(lblCiboVersato.getText() + ciboVersato);
					lblCiboMangiato.setText(lblCiboMangiato.getText() + ciboMangiato);
					
					/**Creazione tabella con info delle tartarughe ammesse in questo intervallo di date**/
					/*Lista per conservare cio' che otteniamo dal DB*/
					ArrayList<Tartaruga> listaTartarugheDB = new ArrayList<Tartaruga>();
					
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
			        
			        listaTartarugheDB =  controller.getTartarugheByDateDB(textFieldDataInizio.getText(), textFieldDataFine.getText());
					 
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
					JOptionPane.showMessageDialog(finestraCorrente, "Date non valide", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(562, 377, 111, 25);
		contentPane.add(btnContinua);
		
		
	}
	
	public boolean dataValida(JTextField dataInizio, JTextField dataFine) {
		boolean valido = false;
		
		/*Caselle riempite*/
		if(dataInizio.getText().length() == 10 && dataFine.getText().length() == 10) {
			
			/*Controllo se e' formato YYYY-MM-DD*/
			if((dataInizio.getText().charAt(4) == '-' && dataInizio.getText().charAt(7) == '-')
					&& (dataFine.getText().charAt(4) == '-' && dataFine.getText().charAt(7) == '-')) {
				
				
				/*Controllo sulle Date*/
				Integer annoInizio = Integer.parseInt(dataInizio.getText().substring(0, 4));
				Integer annoFine = Integer.parseInt(dataFine.getText().substring(0, 4));
				Integer meseInizio = Integer.parseInt(dataInizio.getText().substring(5, 7));
				Integer meseFine = Integer.parseInt(dataFine.getText().substring(5, 7));
				Integer giornoInizio = Integer.parseInt(dataInizio.getText().substring(8, 10));
				Integer giornoFine = Integer.parseInt(dataFine.getText().substring(8, 10));
				
				/*Stesso anno? Controllo sul mese*/
				if(annoInizio == annoFine) {
					/*Stesso mese? Controllo sui giorni*/
					if(meseInizio == meseFine && giornoInizio <= giornoFine) {
						valido = true;
					}
				}
				/*Anni diversi, non ho bisogno degli altri controlli*/
				else if(annoInizio < annoFine) {
					valido = true;
				}
				
			}
		}
		
		return valido;
	}
}
