package com.betacom.services;

import java.util.List;

import com.betacom.dao.DipendentiDao;
import com.betacom.exeption.AcademyExeption;
import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceQuery {

	private GestioneSQL db  = new GestioneSQL();
	private DipendentiDao dao = new DipendentiDao();

	public void executeQuery() {
		log.info("ExecuteQuery ...");
		listAllTable();
		getAllDipendenti();
		getDipendentiWithParameters("impiegato", 4);
		getDipendentiById(5);
		getCount("query.dipendenti");
		getCount("query.dipendenti_manzione_ufficio", "impiegato", 4);
	}

	/*
	 * Stampa tutte le tabelle del database
	 */
	private void listAllTable() {
		List<String> tN = db.tableList();
		tN.forEach(t -> log.debug("table: {}", t));
	}

	/*
	 * Query senza parametri — tutti i dipendenti
	 */
	private void getAllDipendenti() {
		log.debug("getAllDipendenti — query: {}", SQLConfiguration.getInstance().getQuery("query.dipendenti"));
		try {
			List<Dipendenti> lD = dao.findAll();
			lD.forEach(d -> log.debug("{}", d));
		} catch (Exception e) {
			log.error("Errore getAllDipendenti: {}", e.getMessage());
		}
	}

	/*
	 * Query con parametri — filtra per mansione e id_ufficio
	 */
	private void getDipendentiWithParameters(String mansione, Integer ufficio) {
		log.debug("getDipendentiWithParameters — query: {}", SQLConfiguration.getInstance().getQuery("query.dipendenti_manzione_ufficio"));
		try {
			List<Dipendenti> lD = dao.findGeneric("query.dipendenti_manzione_ufficio", new Object[]{mansione, ufficio});
			lD.forEach(d -> log.debug("{}", d));
		} catch (Exception e) {
			log.error("Errore getDipendentiWithParameters: {}", e.getMessage());
		}
	}

	/*
	 * Query singolo risultato — cerca per ID
	 */
	private void getDipendentiById(Integer id) {
		log.debug("getDipendentiById — query: {}", SQLConfiguration.getInstance().getQuery("query.dipendenti_byId"));
		try {
			Dipendenti d = dao.findById(id)
					.orElseThrow(() -> new AcademyExeption("id non trovato in db: " + id));
			log.debug("{}", d);
		} catch (Exception e) {
			log.error("Errore getDipendentiById: {}", e.getMessage());
		}
	}

	/*
	 * Count senza parametri
	 */
	private void getCount(String queryName) {
		log.debug("getCount — query: {}", SQLConfiguration.getInstance().getQuery(queryName));
		try {
			log.debug("count: {}", dao.count(queryName));
		} catch (Exception e) {
			log.error("Errore getCount: {}", e.getMessage());
		}
	}

	/*
	 * Count con parametri
	 */
	private void getCount(String queryName, String mansione, Integer ufficio) {
		log.debug("getCount con parametri — query: {}", SQLConfiguration.getInstance().getQuery(queryName));
		try {
			log.debug("count con parametri: {}", dao.count(queryName, new Object[]{mansione, ufficio}));
		} catch (Exception e) {
			log.error("Errore getCount con parametri: {}", e.getMessage());
		}
	}
}
