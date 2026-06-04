package com.betacom.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
		if (cli.getIdCliente() == null)
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
		params.add(cli.getIdCliente());

		log.debug("SQL generata: {}", query);
		return db.save(query.toString(), params.toArray(), false);
	}

	// Delete per ID
	public int delete(Integer id) throws Exception {
		if (id == null) throw new AcademyExeption("Id non caricato");
		return db.save("delete from clienti where id_cliente = ?", new Object[]{id}, false);
	}
	
	// Recupera tutti i clienti
	public List<Cliente> findAll() throws Exception {
		String query = SQLConfiguration.getInstance().getQuery("query.clienti");
		List<Map<String, Object>> lC = db.list(query);
		return lC.stream()
				.map(c -> Cliente.builder()
						.idCliente((Integer) c.get("id_cliente"))
						.denominazione(c.get("denominazione").toString())
						.pIva(c.get("p_iva").toString())
						.indirizzo(c.get("indirizzo").toString())
						.telefono(c.get("telefono").toString())
						.build())
				.collect(Collectors.toList());
	}

	
	public Optional<Cliente> findById(Integer id) throws Exception {
		String query = SQLConfiguration.getInstance().getQuery("query.clienti_byId");
		Object[] params = new Object[]{id};
		Map<String, Object> c = db.get(query, params);
		if (c == null) return Optional.empty();
		return Optional.ofNullable(Cliente.builder()
				.idCliente((Integer) c.get("id_cliente"))
				.denominazione(c.get("denominazione").toString())
				.pIva(c.get("p_iva").toString())
				.indirizzo(c.get("indirizzo").toString())
				.telefono(c.get("telefono").toString())
				.build());
	}

}
