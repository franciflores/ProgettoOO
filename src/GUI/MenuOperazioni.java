package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class MenuOperazioni extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public MenuOperazioni(final Controller controller) {
		setResizable(false);
		setTitle("Menu Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnCreaCentro = new JButton("Nuovo Centro");
		btnCreaCentro.setFont(new Font("Verdana", Font.PLAIN, 13));
		btnCreaCentro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowCentroFrame();
			}
		});
		
		JLabel lblAzioni = new JLabel("Azioni");
		lblAzioni.setFont(new Font("Verdana", Font.BOLD, 14));
		GridBagConstraints gbc_lblAzioni = new GridBagConstraints();
		gbc_lblAzioni.insets = new Insets(0, 0, 5, 5);
		gbc_lblAzioni.gridx = 4;
		gbc_lblAzioni.gridy = 0;
		contentPane.add(lblAzioni, gbc_lblAzioni);
		
		JButton btnCreaTartaruga = new JButton("Nuova Tartaruga");
		btnCreaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowTartarugaFrame();
			}
		});
		btnCreaTartaruga.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCreaTartaruga = new GridBagConstraints();
		gbc_btnCreaTartaruga.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreaTartaruga.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreaTartaruga.gridx = 1;
		gbc_btnCreaTartaruga.gridy = 1;
		contentPane.add(btnCreaTartaruga, gbc_btnCreaTartaruga);
		GridBagConstraints gbc_btnCreaCentro = new GridBagConstraints();
		gbc_btnCreaCentro.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreaCentro.insets = new Insets(0, 0, 5, 0);
		gbc_btnCreaCentro.gridwidth = 4;
		gbc_btnCreaCentro.gridx = 6;
		gbc_btnCreaCentro.gridy = 1;
		contentPane.add(btnCreaCentro, gbc_btnCreaCentro);
		
		JButton btnCreaVasca =new JButton("Nuova Vasca");
		btnCreaVasca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowVascaFrame();
			}
		});
		btnCreaVasca.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCreaVasca = new GridBagConstraints();
		gbc_btnCreaVasca.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreaVasca.insets = new Insets(0, 0, 0, 5);
		gbc_btnCreaVasca.gridx = 1;
		gbc_btnCreaVasca.gridy = 2;
		contentPane.add(btnCreaVasca, gbc_btnCreaVasca);
		
		JButton btnCreaPersonale = new JButton("Nuovo Addetto");
		btnCreaPersonale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowAddettoFrame();
			}
		});
		btnCreaPersonale.setFont(new Font("Verdana", Font.PLAIN, 13));
		GridBagConstraints gbc_btnCreaPersonale = new GridBagConstraints();
		gbc_btnCreaPersonale.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCreaPersonale.gridwidth = 4;
		gbc_btnCreaPersonale.gridx = 6;
		gbc_btnCreaPersonale.gridy = 2;
		contentPane.add(btnCreaPersonale, gbc_btnCreaPersonale);
	}

}
