package com.betacom.objects;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RapportoCliente {
	private Integer idRapporto;
	private String descrizione;
	private Integer idCliente;
	private Integer idDipendente;
	private Integer prova;
	
	
}
