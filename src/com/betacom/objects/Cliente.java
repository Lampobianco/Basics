package com.betacom.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
	private Integer idCliente;
	private String  denominazione;
	private String  pIva;
	private String  indirizzo;
	private String  telefono;
}
