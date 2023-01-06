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

public class FinestraVasca extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
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
	}
}
