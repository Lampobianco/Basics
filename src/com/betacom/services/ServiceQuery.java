package com.betacom.services;

import java.util.List;

import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceQuery {

	private GestioneSQL db = new GestioneSQL();

	public void executeQuery() {
		log.info("ExecuteQuery ...");
		List<String> tN = db.tableList();
		tN.forEach(t -> log.debug("table : {}", t));
	}

}
