package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FinestraVasca extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JTextField textFieldLarghezza;
	private JTextField textFieldLunghezza;
	private JTextField textFieldProfondita;
	/**
	 * Create the frame.
	 */
	public FinestraVasca(final Controller controller) {
		finestraCorrente = this;
		setTitle("Crea Vasca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
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
				/*Query sul DB e verifica dei campi*/
				/*if(textField.getText().length() > 0) {
					//Query sul DB
				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Presente almeno un campo vuoto!", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}*/
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 225, 111, 25);
		contentPane.add(btnContinua);
		
		JLabel lblCreaVasca = new JLabel("Crea una nuova vasca");
		lblCreaVasca.setFont(new Font("Verdana", Font.BOLD, 14));
		lblCreaVasca.setBounds(115, 11, 224, 14);
		contentPane.add(lblCreaVasca);
		
		JLabel lblLarghezzaVasca = new JLabel("Larghezza vasca");
		lblLarghezzaVasca.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLarghezzaVasca.setBounds(57, 52, 140, 16);
		contentPane.add(lblLarghezzaVasca);
		
		textFieldLarghezza = new JTextField();
		textFieldLarghezza.setBounds(288, 49, 116, 22);
		contentPane.add(textFieldLarghezza);
		textFieldLarghezza.setColumns(10);
		
		JLabel lblLunghezzaVasca = new JLabel("Lunghezza vasca");
		lblLunghezzaVasca.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblLunghezzaVasca.setBounds(57, 99, 140, 16);
		contentPane.add(lblLunghezzaVasca);
		
		textFieldLunghezza = new JTextField();
		textFieldLunghezza.setBounds(288, 97, 116, 22);
		contentPane.add(textFieldLunghezza);
		textFieldLunghezza.setColumns(10);
		
		JLabel lblProfonditaVasca = new JLabel("Profondita' vasca");
		lblProfonditaVasca.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblProfonditaVasca.setBounds(57, 142, 146, 16);
		contentPane.add(lblProfonditaVasca);
		
		textFieldProfondita = new JTextField();
		textFieldProfondita.setBounds(288, 140, 116, 22);
		contentPane.add(textFieldProfondita);
		textFieldProfondita.setColumns(10);
	}
}
