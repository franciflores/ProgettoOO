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
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class FinestraCartella extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldSpecie;
	private JTextField textFieldLuogo;

	/**
	 * Create the frame.
	 */
	public FinestraCartella(final Controller controller) {
		setTitle("Crea Cartella Medica");
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Inserici i dati della Tartaruga");
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBenvenuto.setBounds(115, 11, 224, 18);
		contentPane.add(lblBenvenuto);
		
		JLabel lblSpecieTartaruga = new JLabel("Specie Tartaruga");
		lblSpecieTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblSpecieTartaruga.setBounds(57, 52, 107, 16);
		contentPane.add(lblSpecieTartaruga);
		
		textFieldSpecie = new JTextField();
		textFieldSpecie.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSpecie.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldSpecie.setColumns(10);
		textFieldSpecie.setBounds(288, 49, 116, 22);
		contentPane.add(textFieldSpecie);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 227, 111, 25);
		contentPane.add(btnAnnulla);
		
		final JFormattedTextField TextFieldLunghezza = new JFormattedTextField();
		TextFieldLunghezza.setBounds(288, 82, 116, 20);
		contentPane.add(TextFieldLunghezza);
		
		final JFormattedTextField TextFieldLarghezza = new JFormattedTextField();
		TextFieldLarghezza.setBounds(288, 111, 116, 20);
		contentPane.add(TextFieldLarghezza);
		
		final JFormattedTextField TextFieldPeso = new JFormattedTextField();
		TextFieldPeso.setBounds(288, 141, 116, 20);
		contentPane.add(TextFieldPeso);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Float peso = Float.parseFloat(TextFieldPeso.getText());
					Float lunghezza = Float.parseFloat(TextFieldLunghezza.getText());
					Float larghezza = Float.parseFloat(TextFieldLarghezza.getText());
					
					if(TextFieldPeso.getText().length() > 0
							&& TextFieldLunghezza.getText().length() > 0
							&& TextFieldLarghezza.getText().length() > 0) {
						
						if(textFieldSpecie.getText().length() > 0) {
							controller.CreaCartella(textFieldSpecie.getText(), peso, lunghezza, larghezza);
							controller.ProceduraTerminata(finestraCorrente);
							controller.RitornoMenu(finestraCorrente);
						}
						else {
							JOptionPane.showMessageDialog(finestraCorrente, "Specie Tartaruga non puo' essere vuoto!", "Attenzione", JOptionPane.OK_OPTION);
						}

					}
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(finestraCorrente, "Inserisci un valore numerico!", "Attenzione", JOptionPane.OK_OPTION);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 227, 111, 25);
		contentPane.add(btnContinua);
		
		JLabel lblLunghezzaTartaruga = new JLabel("Lunghezza Tartaruga");
		lblLunghezzaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLunghezzaTartaruga.setBounds(57, 82, 107, 16);
		contentPane.add(lblLunghezzaTartaruga);
		
		JLabel lblLarghezzaTartaruga = new JLabel("Larghezza Tartaruga");
		lblLarghezzaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLarghezzaTartaruga.setBounds(57, 112, 107, 16);
		contentPane.add(lblLarghezzaTartaruga);
		
		JLabel lblPesoTartaruga = new JLabel("Peso Tartaruga");
		lblPesoTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblPesoTartaruga.setBounds(57, 142, 107, 16);
		contentPane.add(lblPesoTartaruga);
		
		JLabel lblLuogoTartaruga = new JLabel("Luogo Tartaruga");
		lblLuogoTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLuogoTartaruga.setBounds(57, 172, 107, 16);
		contentPane.add(lblLuogoTartaruga);
		
		textFieldLuogo = new JTextField();
		textFieldLuogo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldLuogo.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldLuogo.setColumns(10);
		textFieldLuogo.setBounds(288, 169, 116, 22);
		contentPane.add(textFieldLuogo);
		

	}
}
