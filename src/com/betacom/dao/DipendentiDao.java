package com.betacom.dao;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import com.betacom.exeption.AcademyExeption;
import com.betacom.objects.Dipendenti;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;
import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DipendentiDao {

	private GestioneSQL db = new GestioneSQL();

	// Insert — ritorna la primary key generata
	public int insert(String queryName, Dipendenti dip) throws Exception {
		Object[] params = new Object[]{
			dip.getNome(),
			dip.getCognome(),
			dip.getDataAssunzione(),
			dip.getTelefono(),
			dip.getMansioni(),
			dip.getStipendio(),
			dip.getIdUfficio()
		};
		String query = SQLConfiguration.getInstance().getQuery(queryName);
		return db.save(query, params, true);
	}

	// Delete per ID
	public int delete(Integer id) throws Exception {
		if (id == null)
			throw new AcademyExeption("Id non caricata");
		Object[] params = new Object[]{id};
		String query = "delete from dipendenti where id_dipendente = ?";
		return db.save(query, params, false);
	}

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
		Object[] param = new Object[]{id};
		Map<String, Object> d = db.get(query, param);
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
				.nome((String) d.get("nome"))
				.cognome((String) d.get("cognome"))
				.dataAssunzione(Utilities.dateToLocalDate(d.get("data_assunzione")))
				.telefono((String) d.get("telefono"))
				.mansioni((String) d.get("mansioni"))
				.stipendio(((BigDecimal) d.get("stipendio")).doubleValue())
				.idUfficio((Integer) d.get("id_ufficio"))
				.build();
	}
}
