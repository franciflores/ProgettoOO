package Eccezioni;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class EccezioneTartaruga extends Exception{
	
	String messaggioErrore;
	
    public EccezioneTartaruga() {
    }

    public EccezioneTartaruga(String messaggio) {
        super(messaggio);
        messaggioErrore = messaggio;
    }
    
    public void MostraJDialogErroreScelta(JFrame finestraCorrente) {
    	JOptionPane.showMessageDialog(finestraCorrente,  messaggioErrore, "Attenzione", JOptionPane.OK_OPTION);
    }
    
    public boolean verificaMisure(Integer valorePeso, Integer valoreLarghezza, Integer valoreLunghezza) {
    	/*Assumiamo che i valori siano validi*/
    	boolean verifica = true;
    	
    	if(valorePeso <= 6 || valoreLarghezza <= 5 || valoreLunghezza <= 5) {
    		verifica = false;
    	}
    	
    	return verifica;
    }
    
    public boolean verificaMisurePeso(Double peso) {
    	/*Assumiamo che i valori siano validi*/
    	boolean verifica = true;
    	
    	if(peso <= 6) {
    		verifica = false;
    	}
    	
    	return verifica;
    }
    
    public boolean verificaMisureLarghezza( Double larghezza) {
    	/*Assumiamo che i valori siano validi*/
    	boolean verifica = true;
    	
    	if(larghezza <= 5) {
    		verifica = false;
    	}
    	
    	return verifica;
    }
    
    public boolean verificaMisureLunghezza(Double lunghezza) {
    	/*Assumiamo che i valori siano validi*/
    	boolean verifica = true;
    	
    	if(lunghezza <= 5) {
    		verifica = false;
    	}
    	
    	return verifica;
    }

}
