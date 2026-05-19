package com.betacom.objects;

public class ObjectJson {

	private String nome;
	private String Cognome;
	private boolean sesso;
	
	
	
	public ObjectJson(String nome, String cognome, boolean sesso) {
		super();
		this.nome = nome;
		Cognome = cognome;
		this.sesso = sesso;
	}
	
	public ObjectJson() {}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognome() {
		return Cognome;
	}
	public void setCognome(String cognome) {
		Cognome = cognome;
	}
	public boolean isSesso() {
		return sesso;
	}
	public void setSesso(boolean sesso) {
		this.sesso = sesso;
	}

	@Override
	public String toString() {
		return "ObjectJson [nome=" + nome + ", Cognome=" + Cognome + ", sesso=" + sesso + "]";
	}
	
	
	
}
