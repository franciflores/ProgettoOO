package Classi;

public class CartellaMedica {
	
	private int identificativoCartella;
	private Tartaruga tartarugaAssociata;

	
	/*L'esistenza di una cartella medica e' assocciata ad una tartaruga,
	 * mentre una tartaruga puo' ancora non avere una cartella medica associata ad essa.*/
	public CartellaMedica(Tartaruga tartarugaAssociata) {
		super();
		this.tartarugaAssociata = tartarugaAssociata;
	}

	public int getIdentificativoCartella() {
		return identificativoCartella;
	}

	public void setIdentificativoCartella(int identificativoCartella) {
		this.identificativoCartella = identificativoCartella;
	}
	
	public void Rilascia_Chiudi() {
		/*Possibile idea, ottenere l'id della tartaruga magari che si vuole eliminare ed eseguire una nuova query*/
		/*L'eliminazione potrebbe essere fatta lato DB
		 * quindi eseguire una query*/
	}
	
	public void Morta_Chiudi() {
		
	}

}
