package com.betacom.objects.company;

public class EmployeeStream {
	private String nome;
	private String cognome;
	
	
	
	public EmployeeStream(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
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

	@Override
	public String toString() {
		return "EmployeeStream [nome=" + nome + ", cognome=" + cognome + "]";
	}
	
	

}
