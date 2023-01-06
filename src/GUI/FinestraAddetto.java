package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.Choice;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinestraAddetto extends JFrame {

	private JPanel contentPane;
	private JFrame frameCorrente;
	private JTextField textFieldCognome;
	private JTextField textFieldNome;

	/**
	 * Create the frame.
	 */
	public FinestraAddetto(final Controller controller) {
		setTitle("Crea Addetto");
		frameCorrente = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblInsericiAddetto = new JLabel("Inserici i dati dell'Addetto");
		lblInsericiAddetto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblInsericiAddetto.setBounds(115, 0, 200, 18);
		contentPane.add(lblInsericiAddetto);
		
		JLabel lblNomeAddetto = new JLabel("Nome Addetto");
		lblNomeAddetto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblNomeAddetto.setBounds(57, 41, 102, 16);
		contentPane.add(lblNomeAddetto);
		
		JLabel lblCognomeAddetto = new JLabel("Cognome Addetto");
		lblCognomeAddetto.setFont(new Font("Verdana", Font.PLAIN, 12));
		lblCognomeAddetto.setBounds(57, 74, 114, 16);
		contentPane.add(lblCognomeAddetto);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(frameCorrente);
			}
		});
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 12));
		btnAnnulla.setBounds(10, 216, 111, 25);
		contentPane.add(btnAnnulla);
		
		JButton btnContinua = new JButton("Continua");
		btnContinua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Query sul DB e verifica dei campi*/
				if(textFieldCognome.getText().length() > 0) {
					//Query sul DB
				}
				else {
					JOptionPane.showMessageDialog(frameCorrente, "Cognome obbligatorio!", "Attenzione", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnContinua.setFont(new Font("Verdana", Font.BOLD, 12));
		btnContinua.setBounds(315, 216, 111, 25);
		contentPane.add(btnContinua);
		
		textFieldCognome = new JTextField();
		textFieldCognome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldCognome.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldCognome.setColumns(10);
		textFieldCognome.setBounds(288, 71, 116, 22);
		contentPane.add(textFieldCognome);
		
		textFieldNome = new JTextField();
		textFieldNome.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNome.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(288, 38, 116, 22);
		contentPane.add(textFieldNome);
	}

}
