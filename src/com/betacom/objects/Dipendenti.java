package com.betacom.objects;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
public class Dipendenti {
	private String idDipendente;
	private String nome;
	private String cognome;
	private LocalDate dataAssunzione;
	private String telefono;
	private String mansione;
	private double stipendio;
	private String idUfficio;
	private String code;
}
