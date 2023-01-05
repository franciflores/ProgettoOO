package Classi;

public class Centro {
	
	private String codiceFiscaleAziendale;
	private String nomeCentro;
	private String indirizzoCentro;
	private String tipologiaAzienda;
	
	public Centro(String codiceFiscaleAziendale, String nomeCentro, String indirizzoCentro) {
		super();
		this.codiceFiscaleAziendale = codiceFiscaleAziendale;
		this.nomeCentro = nomeCentro;
		this.indirizzoCentro = indirizzoCentro;
	}

	public String getCodiceFiscaleAziendale() {
		return codiceFiscaleAziendale;
	}

	public void setCodiceFiscaleAziendale(String codiceFiscaleAziendale) {
		this.codiceFiscaleAziendale = codiceFiscaleAziendale;
	}

	public String getNomeCentro() {
		return nomeCentro;
	}

	public void setNomeCentro(String nomeCentro) {
		this.nomeCentro = nomeCentro;
	}

	public String getIndirizzoCentro() {
		return indirizzoCentro;
	}

	public void setIndirizzoCentro(String indirizzoCentro) {
		this.indirizzoCentro = indirizzoCentro;
	}

	public String getTipologiaAzienda() {
		return tipologiaAzienda;
	}

	public void setTipologiaAzienda(String tipologiaAzienda) {
		this.tipologiaAzienda = tipologiaAzienda;
	}
	
	

}
