package GUI;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.border.EmptyBorder;

import Classi.Controller;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class FinestraRilascio extends JFrame {

	private JPanel contentPane;
	private JFrame finestraCorrente;
	private JComboBox comboBox;
	
	public FinestraRilascio(final Controller controller) {
		setTitle("Rilascia una Tartaruga");
		finestraCorrente = this;
		setBounds(100, 100, 444, 234);
		contentPane = new JPanel();
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Scegli l'id della tartaruga da rilasciare");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 13));
		lblNewLabel.setBounds(10, 11, 401, 25);
		getContentPane().add(lblNewLabel);
		
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.setFont(new Font("Verdana", Font.BOLD, 11));
		btnAnnulla.setBounds(10, 152, 120, 23);
		getContentPane().add(btnAnnulla);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		JButton btnConferma = new JButton("Conferma");
		btnConferma.setFont(new Font("Verdana", Font.BOLD, 11));
		btnConferma.setBounds(291, 152, 120, 23);
		getContentPane().add(btnConferma);
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.setRilascio(comboBox.getSelectedItem());
				controller.RitornoMenu(finestraCorrente);
			}
		});
		
		comboBox = new JComboBox();
		comboBox.setBounds(123, 80, 191, 22);
		getContentPane().add(comboBox);
		controller.getIdRilascio(comboBox);
	}
}
