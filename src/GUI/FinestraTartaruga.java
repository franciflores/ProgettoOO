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

	private JPanel PanelSceltaTartaruga;
	private Controller controller;
	private JFrame finestraCorrente;
	/**
	 * Create the frame.
	 */
	public FinestraTartaruga(Controller c) {
		controller = c;
		finestraCorrente = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		PanelSceltaTartaruga = new JPanel();
		PanelSceltaTartaruga.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(PanelSceltaTartaruga);
		PanelSceltaTartaruga.setLayout(null);
		
		JLabel lblBenvenuto = new JLabel("Scegliere il tipo di inserimento");
		lblBenvenuto.setHorizontalAlignment(SwingConstants.CENTER);
		lblBenvenuto.setFont(new Font("Verdana", Font.BOLD, 14));
		lblBenvenuto.setBounds(10, 11, 414, 18);
		PanelSceltaTartaruga.add(lblBenvenuto);
	}
}
