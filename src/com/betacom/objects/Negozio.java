package com.betacom.objects;

public class Negozio {
	private int codice;
	private String proprietario;
	private String indirizzo;
	private boolean isCentroCommerciale;
	
	private Negozio() {
		super();
	}

	public static class Builder {
		private int codice;
		private String proprietario;
		private String indirizzo;
		private boolean isCentroCommerciale;
		
		public Builder() {
			
		}
		
		public Builder codice (int codice) {
			this.codice = codice;
			return this; //  ritorna il builder
		}
		
		public Builder proprieta (String proprietario) {
			this.proprietario = proprietario;
			return this; //  ritorna il builder
		}
		
		public Builder indirizzo (String indirizzo) {
			this.indirizzo = indirizzo;
			return this; //  ritorna il builder
		}
		
		public Builder isCentroCommerciale (boolean isCentroCommerciale) {
			this.isCentroCommerciale = isCentroCommerciale;
			return this; //  ritorna il builder
		}
		
		public Negozio build() {
			Negozio negozio = new Negozio();
			negozio.codice = codice;
			negozio.proprietario = proprietario;
			negozio.indirizzo = indirizzo;
			negozio.isCentroCommerciale = isCentroCommerciale;
			return negozio;
			
		}
		
	}


	public static Builder builder (){
		return new Builder();
	}
	
	
	public int getCodice() {
		return codice;
	}
	public void setCodice(int codice) {
		this.codice = codice;
	}
	public String getProprietario() {
		return proprietario;
	}
	public void setProprietario(String proprietario) {
		this.proprietario = proprietario;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public boolean isCentroCommerciale() {
		return isCentroCommerciale;
	}
	public void setCentroCommerciale(boolean isCentroCommerciale) {
		this.isCentroCommerciale = isCentroCommerciale;
	}


	@Override
	public String toString() {
		return "Negozio [codice=" + codice + ", proprietario=" + proprietario + ", indirizzo=" + indirizzo
				+ ", isCentroCommerciale=" + isCentroCommerciale + "]";
	}
	
	

}
