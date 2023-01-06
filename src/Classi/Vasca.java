package Classi;

import java.util.ArrayList;

public class Vasca {
	
	private String codiceVasca;
	private ArrayList tartarughe;
	
	

	/*Non e' detto che una vasca deve contenere almeno una tartaruga
	 *può esistere una vasca vuota in un centro*/
	public Vasca() {
		super();
	}

	public String getCodiceVasca() {
		return codiceVasca;
	}

	public void setCodiceVasca(String codiceVasca) {
		this.codiceVasca = codiceVasca;
	}

	public ArrayList getTartarughe() {
		return tartarughe;
	}

	public void setTartarughe(ArrayList tartarughe) {
		this.tartarughe = tartarughe;
	}
	
	
	
	

}
