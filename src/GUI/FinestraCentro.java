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
import java.awt.Choice;
import java.awt.Toolkit;

public class FinestraCentro extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldPartitaIva;
	private JTextField textFieldNomeCentro;
	private JTextField textFieldIndirizzo;
	private String[] tipologieDisponibili = {"SPA", "SRL", "No-Profit", "SRLS", "Altro"};

	/**
	 * Create the frame.
	 */
	public FinestraCentro(final Controller controller) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fraes\\Documents\\GitHub\\ProgettoOO\\icona\\tortoise-icon-5.jpg"));
		finestraCorrente = this;
		setTitle("Crea Centro");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsericiIDati = new JLabel("Inserici i dati del Centro");
		lblInsericiIDati.setFont(new Font("Verdana", Font.BOLD, 14));
		lblInsericiIDati.setBounds(115, 11, 187, 18);
		contentPane.add(lblInsericiIDati);
		
		JLabel lblPartitaIva = new JLabel("Partita Iva");
		lblPartitaIva.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPartitaIva.setBounds(57, 52, 102, 16);
		contentPane.add(lblPartitaIva);
		
		textFieldPartitaIva = new JTextField();
		textFieldPartitaIva.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPartitaIva.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldPartitaIva.setColumns(10);
		textFieldPartitaIva.setBounds(288, 49, 116, 22);
		contentPane.add(textFieldPartitaIva);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 227, 111, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Query sul DB e verifica dei campi*/
				if(textFieldNomeCentro.getText().length() > 0) {
					//Query sul DB
				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Nome centro obbligatorio!", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 227, 111, 25);
		contentPane.add(btnContinua);
		
		JLabel lblNomeCentro = new JLabel("Nome Centro");
		lblNomeCentro.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNomeCentro.setBounds(57, 85, 102, 16);
		contentPane.add(lblNomeCentro);
		
		textFieldNomeCentro = new JTextField();
		textFieldNomeCentro.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomeCentro.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNomeCentro.setColumns(10);
		textFieldNomeCentro.setBounds(288, 82, 116, 22);
		contentPane.add(textFieldNomeCentro);
		
		JLabel lblIndirizzoCentro = new JLabel("Indirizzo Centro");
		lblIndirizzoCentro.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblIndirizzoCentro.setBounds(57, 115, 102, 16);
		contentPane.add(lblIndirizzoCentro);
		
		textFieldIndirizzo = new JTextField();
		textFieldIndirizzo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldIndirizzo.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldIndirizzo.setColumns(10);
		textFieldIndirizzo.setBounds(288, 112, 116, 22);
		contentPane.add(textFieldIndirizzo);
		
		JLabel lblTipologia = new JLabel("Tipologia Centro");
		lblTipologia.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblTipologia.setBounds(57, 142, 103, 16);
		contentPane.add(lblTipologia);
		
		Choice choiceAzienda = new Choice();
		choiceAzienda.setBounds(288, 140, 116, 20);
		
		/*Riempimento del menu a scelta*/
		for (String sceltaDisponibile : tipologieDisponibili)
			choiceAzienda.add(sceltaDisponibile);
		
		contentPane.add(choiceAzienda);
	}
}
