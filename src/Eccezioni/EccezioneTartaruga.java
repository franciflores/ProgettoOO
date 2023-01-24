package Eccezioni;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EccezioneTartaruga extends Exception{
	
	String messaggioErrore;

    public EccezioneTartaruga(String messaggio) {
        super(messaggio);
        messaggioErrore = messaggio;
    }
    
    public void MostraJDialogErroreScelta(JFrame finestraCorrente) {
    	JOptionPane.showMessageDialog(finestraCorrente,  messaggioErrore, "Attenzione", JOptionPane.OK_OPTION);
    }

}
