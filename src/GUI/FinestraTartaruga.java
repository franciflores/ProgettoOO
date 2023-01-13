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
import java.awt.BorderLayout;

public class FinestraTartaruga extends JFrame {
	private Controller controller;
	private JFrame finestraCorrente;
	/**
	 * Create the frame.
	 */
	public FinestraTartaruga(Controller c, int panelDaAttivare) {
		controller = c;
		finestraCorrente = this;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		if(panelDaAttivare==0) {
			JPanel NuovaTartaruga = new JPanel();
			getContentPane().add(NuovaTartaruga, BorderLayout.CENTER);
			NuovaTartaruga.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Inserimento di una nuova Tartaruga nel centro");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 5, 414, 24);
			NuovaTartaruga.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Inserisci");
			btnNewButton.setBounds(173, 227, 96, 23);
			NuovaTartaruga.add(btnNewButton);
		}
				else{
			JPanel VecchiaTartaruga = new JPanel();
			getContentPane().add(VecchiaTartaruga, BorderLayout.CENTER);
			VecchiaTartaruga.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("Riammissione di una Tartaruga");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setBounds(10, 5, 414, 14);
			VecchiaTartaruga.add(lblNewLabel);
			
			JButton btnNewButton = new JButton("Inserisci");
			btnNewButton.setBounds(176, 227, 89, 23);
			VecchiaTartaruga.add(btnNewButton);
		}
	}
}
