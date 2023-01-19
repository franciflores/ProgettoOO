package Eccezioni;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EccezioneLogin extends Exception{
	
	String messaggioErrore;

    public EccezioneLogin(String messaggio) {
        super(messaggio);
        messaggioErrore = messaggio;
    }
    
    public void MostraJDialogErroreScelta(JFrame finestraCorrente) {
    	JOptionPane.showMessageDialog(finestraCorrente,  messaggioErrore, "Attenzione", JOptionPane.OK_OPTION);
    }


}
