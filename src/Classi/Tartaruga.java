package Classi;

public class Tartaruga {
	
	private String idTartaruga;
	private String nomeTartaruga;
	private CartellaMedica cartellaTartaruga;
	
	public Tartaruga(String idTartaruga, String nomeTartaruga) {
		super();
		this.idTartaruga = idTartaruga;
		this.nomeTartaruga = nomeTartaruga;
	}

	public String getIdTartaruga() {
		return idTartaruga;
	}

	public void setIdTartaruga(String idTartaruga) {
		this.idTartaruga = idTartaruga;
	}

	public String getNomeTartaruga() {
		return nomeTartaruga;
	}

	public void setNomeTartaruga(String nomeTartaruga) {
		this.nomeTartaruga = nomeTartaruga;
	}

	public CartellaMedica getCartellaTartaruga() {
		return cartellaTartaruga;
	}

}
