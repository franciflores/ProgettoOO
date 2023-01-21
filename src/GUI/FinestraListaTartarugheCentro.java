package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraListaTartarugheCentro extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldCodCentro;

	/**
	 * Create the frame.
	 */
	public FinestraListaTartarugheCentro(final Controller controller) {
		setTitle("Tartarughe di un Centro");
		finestraCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDescrizione = new JLabel("Inserisci il codice di un centro");
		lblDescrizione.setToolTipText("");
		lblDescrizione.setFont(new Font("Verdana", Font.BOLD, 12));
		lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescrizione.setBounds(10, 60, 206, 46);
		contentPane.add(lblDescrizione);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 225, 111, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textFieldCodCentro.getText().length() > 0) {
					/*Verificare mediante Dao se il centro esiste, se si' farsi ritornare la lista delle tartarughe e mostrarle mediante una JTable
					 * altrimenti, eccezione*/
				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Il campo non puo' essere vuoto", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
				

			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 225, 111, 25);
		contentPane.add(btnContinua);
		
		textFieldCodCentro = new JTextField();
		textFieldCodCentro.setColumns(10);
		textFieldCodCentro.setBounds(250, 73, 151, 22);
		contentPane.add(textFieldCodCentro);
	}
}
