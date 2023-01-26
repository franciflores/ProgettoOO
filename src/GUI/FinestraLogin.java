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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class FinestraLogin extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldMatricola;
	private JPasswordField passwordFieldMatricola;
	private JFrame finestraCorrente;
	private JButton btnConferma;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	
	public FinestraLogin(Controller c) {
		setResizable(false);
		finestraCorrente = this;
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 208);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Esegui il Login\r\n");
		lblBenvenuto.setBounds(10, 21, 414, 22);
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 17));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblBenvenuto);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setBounds(10, 54, 121, 18);
		lblMatricola.setToolTipText("");
		lblMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setBounds(141, 54, 283, 24);
		textFieldMatricola.setToolTipText("Inserisci Matricola");
		lblMatricola.setLabelFor(textFieldMatricola);
		textFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMatricola.setColumns(10);
		contentPane.add(textFieldMatricola);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 92, 121, 18);
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblPassword);
		
		passwordFieldMatricola = new JPasswordField();
		passwordFieldMatricola.setBounds(141, 89, 283, 24);
		lblPassword.setLabelFor(passwordFieldMatricola);
		passwordFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(passwordFieldMatricola);
		
		btnConferma = new JButton("Accedi");
		btnConferma.setBounds(347, 134, 77, 27);
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckConferma();
			}
		});
		btnConferma.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPane.add(btnConferma);
		btnConferma.isDefaultButton();
	}
	
	public boolean InvioPremuto(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			return true;
			}
		return false;
		
	}
	
	public void CheckConferma() {
		boolean esistenzaAddetto = false;
		
		try {
			
			String matricolaText = textFieldMatricola.getText();
			String passwordText = passwordFieldMatricola.getText();
				
			/*Aggiungere il controllo sull'accesso per mostrare il Menu*/
				
			esistenzaAddetto = controller.esistePersonaleDB(matricolaText, passwordText);
				
			if(esistenzaAddetto) {
					
				/*Dopo aver verificato l'esistenza, recuperare il nome da poi mostrare nel menu*/
				String nomeAddetto = controller.getNomeByMatricolaDB(matricolaText);
				String ruoloAddetto = controller.getRuoloAddettoDB(matricolaText);
					
				/*Per ovviare a tante Frame Menu, passiamo al controller la scelta ed in base a quest'ultima si settano i bottoni nel menu*/
				controller.AvviaMenu(nomeAddetto, ruoloAddetto);
			}
			else {
				throw new EccezioneLogin("Utente non presente, credenziali errate o professione errata!");
			}
				
		}
		catch(EccezioneLogin e1) {
			e1.MostraJDialogErroreScelta(finestraCorrente);
		}
	}
}
