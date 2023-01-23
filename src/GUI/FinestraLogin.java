package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Classi.Controller;
import Eccezioni.EccezioneLogin;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Choice;

@SuppressWarnings("serial")
public class FinestraLogin extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldMatricola;
	private JPasswordField passwordFieldMatricola;
	private JFrame finestraCorrente;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	
	public FinestraLogin(Controller c) {
		setResizable(false);
		finestraCorrente = this;
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Esegui il Login");
		lblBenvenuto.setBounds(151, 21, 140, 22);
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 17));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBenvenuto);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setBounds(54, 131, 61, 18);
		lblMatricola.setToolTipText("");
		lblMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(246, 128, 106, 24);
		textFieldMatricola.setToolTipText("Inserisci Matricola");
		lblMatricola.setLabelFor(textFieldMatricola);
		textFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMatricola.setColumns(10);
		contentPane.add(textFieldMatricola);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(54, 179, 67, 18);
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPassword);
		
		passwordFieldMatricola = new JPasswordField();
		passwordFieldMatricola.setBounds(246, 176, 106, 24);
		lblPassword.setLabelFor(passwordFieldMatricola);
		passwordFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(passwordFieldMatricola);
		
		JLabel lblTipoLogin = new JLabel("Professione");
		lblTipoLogin.setToolTipText("");
		lblTipoLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoLogin.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblTipoLogin.setBounds(54, 79, 81, 18);
		contentPane.add(lblTipoLogin);
		
		final Choice choiceProfessione = new Choice();
		choiceProfessione.setBounds(246, 77, 106, 20);
		contentPane.add(choiceProfessione);
		
		choiceProfessione.add("Medico");
		choiceProfessione.add("Tecnico");
		choiceProfessione.add("Ricercatore");
		choiceProfessione.add("Operatore");
		
		JButton btnConferma = new JButton("Accedi");
		btnConferma.setBounds(333, 211, 77, 27);
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				boolean esistenzaAddetto = false;
				
				try {
					
					String matricolaText = textFieldMatricola.getText();
					String professioneText = choiceProfessione.getSelectedItem();
					String passwordText = passwordFieldMatricola.getText();
						
					/*Aggiungere il controllo sull'accesso per mostrare il Menu*/
						
					esistenzaAddetto = controller.esistePersonaleDB(matricolaText, professioneText, passwordText);
						
					if(esistenzaAddetto) {
							
						/*Dopo aver verificato l'esistenza, recuperare il nome da poi mostrare nel menu*/
						String nomeAddetto = controller.getNomeByMatricolaDB(matricolaText);
							
						/*Per ovviare a tante Frame Menu, passiamo al controller la scelta ed in base a quest'ultima si settano i bottoni nel menu*/
						controller.AvviaMenu(nomeAddetto, professioneText);
					}
					else {
						throw new EccezioneLogin("Utente non presente, credenziali errate o professione errata!");
					}
						
				}
				catch(EccezioneLogin e1) {
					e1.MostraJDialogErroreScelta(finestraCorrente);
				}
				

				

			}
		});
		btnConferma.setFont(new Font("Verdana", Font.PLAIN, 14));
		contentPane.add(btnConferma);
		
	}
}
