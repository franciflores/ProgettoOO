package Eccezioni;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EccezioneValoreNumerico extends Exception{
	
	String messaggioErrore;

    public EccezioneValoreNumerico(String messaggio) {
        super(messaggio);
        messaggioErrore = messaggio;
    }
    
    public void MostraJDialogErrore(JFrame finestraCorrente) {
    	JOptionPane.showMessageDialog(finestraCorrente, messaggioErrore, "Attenzione", JOptionPane.OK_OPTION);
    }

}
