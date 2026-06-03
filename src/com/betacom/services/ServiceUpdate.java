package com.betacom.services;

import com.betacom.dao.ClientiDao;
import com.betacom.objects.Cliente;
import com.betacom.singleton.SQLConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ServiceUpdate {

	private ClientiDao dao = new ClientiDao();

	public void executeUpdate() {
		log.info("Begin ServiceUpdate");
		SQLConfiguration.getInstance().setAutocommit();
		int pk = insertClient();
		int rc = updateCliente(pk);
		rc = deleteCliente(pk);
	}

	private int insertClient() {
		log.debug("Insert nuovo cliente");
		int rc = 0;
		Cliente cli = Cliente.builder()
				.denominazione("Nuovo cliente srl")
				.pIva("109283837")
				.indirizzo("Via dell'insert 12 Torino")
				.telefono("11222333")
				.build();
		try {
			rc = dao.insert("update.clienti.insert", cli);
			log.debug("Insert nuovo cliente pk generata: {}", rc);
		} catch (Exception e) {
			log.error("Errore insert cliente: {}", e.getMessage());
		}
		return rc;
	}

	private int updateCliente(int pk) {
		log.debug("Update cliente id: {}", pk);
		int rc = 0;
		Cliente cli = new Cliente();
		cli.setIdCliente(pk);
		cli.setDenominazione("Updated srl");
		cli.setTelefono("99991233");
		try {
			rc = dao.update("update.clienti.update", cli);
			log.debug("Cliente {} aggiornato, righe: {}", pk, rc);
		} catch (Exception e) {
			log.error("Errore update cliente: {}", e.getMessage());
		}
		return rc;
	}

	private int deleteCliente(int pk) {
		log.debug("Delete cliente id: {}", pk);
		int rc = 0;
		try {
			rc = dao.delete(pk);
			log.debug("Cliente {} eliminato, righe: {}", pk, rc);
		} catch (Exception e) {
			log.error("Errore delete cliente: {}", e.getMessage());
		}
		return rc;
	}
}
