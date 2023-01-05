package Classi;

public class Personale {
	
	private String matricola;
	private String nome;
	private String cognome;
	
	public Personale(String matricola, String cognome) {
		super();
		this.matricola = matricola;
		this.cognome = cognome;
	}
	
	public String getMatricola() {
		return matricola;
	}
	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	
	

}
