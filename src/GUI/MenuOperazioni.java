package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
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
import java.awt.Button;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;

public class MenuOperazioni extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 * @param nomeAddetto 
	 */
	public MenuOperazioni(final Controller controller, String nomeAddetto,String ruoloAddetto) {
		setResizable(false);
		setTitle("Menu Operazioni");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAzioni = new JLabel("Benvenuto " + nomeAddetto);
		lblAzioni.setHorizontalAlignment(SwingConstants.CENTER);
		lblAzioni.setBounds(10, 5, 464, 18);
		lblAzioni.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(lblAzioni);

		JButton btnNuovaTartaruga = new JButton("Nuova Tartaruga");
		btnNuovaTartaruga.setBounds(10, 63, 141, 21);
		btnNuovaTartaruga.addActionListener(new ActionListener() {
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent e) {
				//Cambiare con un setter questa Variabile
				controller.SceltaPanel = controller.DialogTartarughe();
				if((Integer)controller.SceltaPanel==0 || (Integer)controller.SceltaPanel==1)
					try {
						controller.ShowTartarugaFrame();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
		});
		btnNuovaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		contentPane.add(btnNuovaTartaruga);

		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.RitornoAlLogin();
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnLogOut.setBounds(397, 195, 77, 18);
		contentPane.add(btnLogOut);

		JButton btnOperatore = new JButton("Cibo per Vasca");
		btnOperatore.setFont(new Font("Tahoma", Font.PLAIN, 10));
		if(ruoloAddetto.equals("Medico"))
			btnOperatore.setEnabled(false);
		btnOperatore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ApriFinestraCibo();
			}
		});
		btnOperatore.setBounds(10, 158, 141, 21);
		contentPane.add(btnOperatore);
		
		JButton btnAggiornaCartella = new JButton("Aggiorna Cartella");
		btnAggiornaCartella.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAggiornaCartella.setBounds(171, 157, 141, 23);
		contentPane.add(btnAggiornaCartella);
		if(!ruoloAddetto.equals("Medico")) {
			btnAggiornaCartella.setEnabled(false);}
		
		
		JButton btnModificaTartaruga = new JButton("Modifica Tartaruga");
		btnModificaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnModificaTartaruga.setBounds(333, 63, 141, 21);
		contentPane.add(btnModificaTartaruga);
		btnModificaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaFinestraModifica();
			}
		});
			
		
		JButton btnListaTartarughe = new JButton("Lista Tartaruga");
		btnListaTartarughe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaFinestraListaTartarugheCentro();
			}
		});
		btnListaTartarughe.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnListaTartarughe.setBounds(171, 62, 141, 22);
		contentPane.add(btnListaTartarughe);
		
		JLabel lblOperazioniTart = new JLabel("Operazioni Tartarughe");
		lblOperazioniTart.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperazioniTart.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperazioniTart.setBounds(10, 34, 464, 18);
		contentPane.add(lblOperazioniTart);
		
		JButton btnStoriaTartaruga = new JButton("Storia Tartaruga");
		btnStoriaTartaruga.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaFinestraStoriaTartarughe();
			}
		});
		btnStoriaTartaruga.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnStoriaTartaruga.setBounds(50, 95, 141, 23);
		contentPane.add(btnStoriaTartaruga);
		
		JButton btnStatistiche = new JButton("Statistiche Tartarughe");
		btnStatistiche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaFinestraStatistiche();
			}
		});
		btnStatistiche.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnStatistiche.setBounds(293, 95, 141, 23);
		contentPane.add(btnStatistiche);
		
		JButton btnRilascia = new JButton("Rilascia Tartaruga");
		btnRilascia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRilascia.setBounds(333, 157, 141, 23);
		if(!ruoloAddetto.equals("Ricercatore"))
			btnRilascia.setEnabled(false);
		contentPane.add(btnRilascia);
		
		JLabel lblOperazioniVasche = new JLabel("Operatore\\Tecnico");
		lblOperazioniVasche.setHorizontalAlignment(SwingConstants.CENTER);
		lblOperazioniVasche.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblOperazioniVasche.setBounds(10, 129, 141, 18);
		contentPane.add(lblOperazioniVasche);
		
		JLabel lblMedico = new JLabel("Medico");
		lblMedico.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedico.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMedico.setBounds(171, 129, 141, 18);
		contentPane.add(lblMedico);
		
		JLabel lblRicercatore = new JLabel("Ricercatore");
		lblRicercatore.setHorizontalAlignment(SwingConstants.CENTER);
		lblRicercatore.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRicercatore.setBounds(333, 128, 141, 18);
		contentPane.add(lblRicercatore);
		btnRilascia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.CreaRilascio();
			}
		});
		
		btnAggiornaCartella.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.ShowCartellaFrame();
			}
		});
	}
}
