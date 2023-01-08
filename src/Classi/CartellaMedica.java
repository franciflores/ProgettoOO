package Classi;

public class CartellaMedica {
	
	private int identificativoCartella;
	private Tartaruga tartarugaAssociata;
	private String specieTartaruga;
	private float lunghezzaTartaruga;
	private float larghezzaTartaruga;
	private float pesoTartaruga;
	private String luogoRitrovamento;

	
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

	public Tartaruga getTartarugaAssociata() {
		return tartarugaAssociata;
	}

	public void setTartarugaAssociata(Tartaruga tartarugaAssociata) {
		this.tartarugaAssociata = tartarugaAssociata;
	}

	public String getSpecieTartaruga() {
		return specieTartaruga;
	}

	public void setSpecieTartaruga(String specieTartaruga) {
		this.specieTartaruga = specieTartaruga;
	}

	public float getLunghezzaTartaruga() {
		return lunghezzaTartaruga;
	}

	public void setLunghezzaTartaruga(float lunghezzaTartaruga) {
		this.lunghezzaTartaruga = lunghezzaTartaruga;
	}

	public float getLarghezzaTartaruga() {
		return larghezzaTartaruga;
	}

	public void setLarghezzaTartaruga(float larghezzaTartaruga) {
		this.larghezzaTartaruga = larghezzaTartaruga;
	}

	public float getPesoTartaruga() {
		return pesoTartaruga;
	}

	public void setPesoTartaruga(float pesoTartaruga) {
		this.pesoTartaruga = pesoTartaruga;
	}

	public String getLuogoRitrovamento() {
		return luogoRitrovamento;
	}

	public void setLuogoRitrovamento(String luogoRitrovamento) {
		this.luogoRitrovamento = luogoRitrovamento;
	}
	
	

}
