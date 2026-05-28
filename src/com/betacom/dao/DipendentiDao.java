package com.betacom.dao;

import com.betacom.utils.GestioneSQL;

public class DipendentiDao {
	private GestioneSQL db = new GestioneSQL();
	
	public List<Dipendenti> findAll() throws Exeption{
		
		return r.stream()
				.map (d -> Dipendenti.builder())
				.idDipendente((Integer)d.get("id_employee")) // il nome va messo quello che c'è sul db
				.nome(d.get("name").toString)
				.build()
				.toList();
	}
	// da terminare con tutti i valori della tabella che per ora non esiste
	
}
