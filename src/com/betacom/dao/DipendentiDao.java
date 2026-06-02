package com.betacom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;
import com.betacom.utils.Utilities;

public class DipendentiDao {

	private GestioneSQL db = new GestioneSQL();

	// Recupera tutti i dipendenti
	public List<Dipendenti> findAll() throws Exception {
		List<Map<String, Object>> r = db.list(SQLConfiguration.getInstance().getQuery("query.dipendenti"));
		return buildDipendentiList(r);
	}

	// Query generica con parametri — queryName è la chiave in query.properties
	public List<Dipendenti> findGeneric(String queryName, Object[] params) throws Exception {
		String query = SQLConfiguration.getInstance().getQuery(queryName);
		List<Map<String, Object>> r = db.list(query, params);
		return buildDipendentiList(r);
	}

	// Cerca un dipendente per ID — ritorna Optional vuoto se non trovato
	public Optional<Dipendenti> findById(Integer id) throws Exception {
		String query = SQLConfiguration.getInstance().getQuery("query.dipendenti_byId");
		Map<String, Object> d = db.get(query, new Object[]{id});
		if (d == null) return Optional.empty();
		return Optional.ofNullable(buildDipendente(d));
	}

	// Conta i risultati di una query senza parametri
	public Long count(String queryName) throws Exception {
		return db.count(SQLConfiguration.getInstance().getQuery(queryName));
	}

	// Conta i risultati di una query con parametri
	public Long count(String queryName, Object[] params) throws Exception {
		return db.count(SQLConfiguration.getInstance().getQuery(queryName), params);
	}

	// Converte una lista di Map in lista di Dipendenti
	private List<Dipendenti> buildDipendentiList(List<Map<String, Object>> r) {
		return r.stream()
				.map(this::buildDipendente)
				.collect(Collectors.toList());
	}

	// Converte una singola Map in un oggetto Dipendenti
	private Dipendenti buildDipendente(Map<String, Object> d) {
		return Dipendenti.builder()
				.idDipendente((Integer) d.get("id_dipendente"))
				.nome(d.get("nome").toString())
				.cognome(d.get("cognome").toString())
				.dataAssunzione(Utilities.dateToLocalDate(d.get("data_assunzione")))
				.telefono(d.get("telefono").toString())
				.mansione(d.get("mansione").toString())
				.stipendio(((BigDecimal) d.get("stipendio")).doubleValue())
				.idUfficio((Integer) d.get("id_ufficio"))
				.code(d.get("code").toString())
				.build();
	}
}
