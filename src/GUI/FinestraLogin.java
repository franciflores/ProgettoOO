package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Classi.Controller;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
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

@SuppressWarnings("serial")
public class FinestraLogin extends JFrame {

	private JPanel contentPane;
	private Controller controller;
	private JTextField textFieldMatricola;
	private JPasswordField passwordFieldMatricola;

	/**
	 * Create the frame.
	 * @param controller 
	 */
	
	public FinestraLogin(Controller c) {
		setResizable(false);
		controller = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{212, 0, 212, 0};
		gbl_contentPane.rowHeights = new int[]{62, 62, 62, 62, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblBenvenuto = new JLabel("Esegui il Login");
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 17));
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblBenvenuto = new GridBagConstraints();
		gbc_lblBenvenuto.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenvenuto.gridx = 1;
		gbc_lblBenvenuto.gridy = 0;
		contentPane.add(lblBenvenuto, gbc_lblBenvenuto);
		
		JLabel lblMatricola = new JLabel("Matricola");
		lblMatricola.setToolTipText("");
		lblMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblMatricola = new GridBagConstraints();
		gbc_lblMatricola.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricola.gridx = 0;
		gbc_lblMatricola.gridy = 1;
		contentPane.add(lblMatricola, gbc_lblMatricola);
		
		textFieldMatricola = new JTextField();
		textFieldMatricola.setToolTipText("Inserisci Matricola");
		lblMatricola.setLabelFor(textFieldMatricola);
		textFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		textFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldMatricola.setColumns(10);
		GridBagConstraints gbc_textFieldMatricola = new GridBagConstraints();
		gbc_textFieldMatricola.gridwidth = 2;
		gbc_textFieldMatricola.ipadx = 99;
		gbc_textFieldMatricola.weighty = 1.0;
		gbc_textFieldMatricola.weightx = 2.0;
		gbc_textFieldMatricola.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldMatricola.gridx = 1;
		gbc_textFieldMatricola.gridy = 1;
		contentPane.add(textFieldMatricola, gbc_textFieldMatricola);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Verdana", Font.PLAIN, 14));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 2;
		contentPane.add(lblPassword, gbc_lblPassword);
		
		passwordFieldMatricola = new JPasswordField();
		lblPassword.setLabelFor(passwordFieldMatricola);
		passwordFieldMatricola.setFont(new Font("Verdana", Font.PLAIN, 14));
		passwordFieldMatricola.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_passwordFieldMatricola = new GridBagConstraints();
		gbc_passwordFieldMatricola.gridwidth = 2;
		gbc_passwordFieldMatricola.ipadx = 99;
		gbc_passwordFieldMatricola.insets = new Insets(0, 0, 5, 0);
		gbc_passwordFieldMatricola.gridx = 1;
		gbc_passwordFieldMatricola.gridy = 2;
		contentPane.add(passwordFieldMatricola, gbc_passwordFieldMatricola);
		
		JButton btnConferma = new JButton("Accedi");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*Aggiungere il controllo sull'accesso per mostrare il Menu*/
				controller.ShowMenu();
			}
		});
		btnConferma.setFont(new Font("Verdana", Font.PLAIN, 14));
		GridBagConstraints gbc_btnConferma = new GridBagConstraints();
		gbc_btnConferma.gridx = 2;
		gbc_btnConferma.gridy = 3;
		contentPane.add(btnConferma, gbc_btnConferma);
	}

}
