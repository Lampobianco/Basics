package com.betacom.dao;

import java.util.ArrayList;
import java.util.List;

import com.betacom.exeption.AcademyExeption;
import com.betacom.objects.Cliente;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ClientiDao {

	private GestioneSQL db = new GestioneSQL();

	// Insert — ritorna la primary key generata
	public int insert(String queryName, Cliente cli) throws Exception {
		Object[] params = new Object[]{
			cli.getDenominazione(),
			cli.getPIva(),
			cli.getIndirizzo(),
			cli.getTelefono()
		};
		String query = SQLConfiguration.getInstance().getQuery(queryName);
		return db.save(query, params, true);
	}

	// Update dinamico — aggiorna solo i campi non null
	public int update(String queryName, Cliente cli) throws Exception {
		if (cli.getIdCliento() == null)
			throw new AcademyExeption("Primary key non caricata per un update");

		StringBuilder query = new StringBuilder("UPDATE clienti SET ");
		List<Object> params = new ArrayList<>();
		List<String> fields = new ArrayList<>();

		if (cli.getDenominazione() != null) { fields.add("denominazione = ?"); params.add(cli.getDenominazione()); }
		if (cli.getPIva()          != null) { fields.add("p_iva = ?");         params.add(cli.getPIva()); }
		if (cli.getIndirizzo()     != null) { fields.add("indirizzo = ?");     params.add(cli.getIndirizzo()); }
		if (cli.getTelefono()      != null) { fields.add("telefono = ?");      params.add(cli.getTelefono()); }

		if (fields.isEmpty()) throw new AcademyExeption("Nessun campo da aggiornare");

		query.append(String.join(", ", fields));
		query.append(" ");
		query.append(SQLConfiguration.getInstance().getQuery(queryName));
		params.add(cli.getIdCliento());

		log.debug("SQL generata: {}", query);
		return db.save(query.toString(), params.toArray(), false);
	}

	// Delete per ID
	public int delete(Integer id) throws Exception {
		if (id == null) throw new AcademyExeption("Id non caricato");
		return db.save("delete from clienti where id_cliento = ?", new Object[]{id}, false);
	}
}
