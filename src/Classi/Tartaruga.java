package Classi;

public class Tartaruga {
	
	private String targa;
	private String nomeTartaruga;
	private CartellaMedica cartellaTartaruga;
	private String descrizioneStatoTesta;
	private String descrizioneStatoOcchi;
	private String descrizioneStatoNaso;
	private String descrizioneStatoBecco;
	private String descrizioneStatoCollo;
	private String descrizioneStatoPinne;
	private String descrizioneStatoCoda;
	
	public Tartaruga(String targa, String nomeTartaruga) {
		super();
		this.targa = targa;
		this.nomeTartaruga = nomeTartaruga;
	}
	
	public Tartaruga() {
	}

	public String getTarga() {
		return targa;
	}

	public void setTarga(String targa) {
		this.targa = targa;
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
	
	public void setCartellaTartaruga(CartellaMedica cartellaTartaruga) {
		this.cartellaTartaruga = cartellaTartaruga;
	}

	public String getDescrizioneStatoTesta() {
		return descrizioneStatoTesta;
	}

	public void setDescrizioneStatoTesta(String descrizioneStatoTesta) {
		this.descrizioneStatoTesta = descrizioneStatoTesta;
	}

	public String getDescrizioneStatoOcchi() {
		return descrizioneStatoOcchi;
	}

	public void setDescrizioneStatoOcchi(String descrizioneStatoOcchi) {
		this.descrizioneStatoOcchi = descrizioneStatoOcchi;
	}

	public String getDescrizioneStatoNaso() {
		return descrizioneStatoNaso;
	}

	public void setDescrizioneStatoNaso(String descrizioneStatoNaso) {
		this.descrizioneStatoNaso = descrizioneStatoNaso;
	}

	public String getDescrizioneStatoBecco() {
		return descrizioneStatoBecco;
	}

	public void setDescrizioneStatoBecco(String descrizioneStatoBecco) {
		this.descrizioneStatoBecco = descrizioneStatoBecco;
	}

	public String getDescrizioneStatoCollo() {
		return descrizioneStatoCollo;
	}

	public void setDescrizioneStatoCollo(String descrizioneStatoCollo) {
		this.descrizioneStatoCollo = descrizioneStatoCollo;
	}

	public String getDescrizioneStatoPinne() {
		return descrizioneStatoPinne;
	}

	public void setDescrizioneStatoPinne(String descrizioneStatoPinne) {
		this.descrizioneStatoPinne = descrizioneStatoPinne;
	}

	public String getDescrizioneStatoCoda() {
		return descrizioneStatoCoda;
	}

	public void setDescrizioneStatoCoda(String descrizioneStatoCoda) {
		this.descrizioneStatoCoda = descrizioneStatoCoda;
	}

}
