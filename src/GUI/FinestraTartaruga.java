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

public class FinestraTartaruga extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldNomeTartaruga;
	private JFrame finestraCorrente;
	/**
	 * Create the frame.
	 */
	public FinestraTartaruga(Controller c) {
		controller = c;
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
		
		JLabel lblNomeTartaruga = new JLabel("Nome Tartaruga");
		lblNomeTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNomeTartaruga.setBounds(57, 52, 102, 16);
		contentPane.add(lblNomeTartaruga);
		
		textFieldNomeTartaruga = new JTextField();
		textFieldNomeTartaruga.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNomeTartaruga.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNomeTartaruga.setBounds(288, 49, 116, 22);
		contentPane.add(textFieldNomeTartaruga);
		textFieldNomeTartaruga.setColumns(10);
		
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
				if(textFieldNomeTartaruga.getText().length() > 0) {
					//Query sul DB
				}
				else {
					JOptionPane.showMessageDialog(finestraCorrente, "Presente almeno un campo vuoto!", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 227, 111, 25);
		contentPane.add(btnContinua);
	}
}
