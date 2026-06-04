package com.betacom.dao;

import com.betacom.exeption.AcademyExeption;
import com.betacom.objects.RapportoCliente;
import com.betacom.singleton.SQLConfiguration;
import com.betacom.utils.GestioneSQL;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RapportoClienteDao {

	private GestioneSQL db = new GestioneSQL();
	
	public int delete(Integer id) throws Exception {
		if (id == null)
			throw new AcademyExeption("Id non caricata");
		Object[] params = new Object[]{id};
		String query = "delete from rapporto_cliente where id_rapporto = ?";
		return db.save(query, params, false);
	}

	public int insert(String queryName, RapportoCliente rc) throws Exception {
		String query = SQLConfiguration.getInstance().getQuery(queryName);
		Object[] params = new Object[]{
			rc.getDescrizione(),
			rc.getIdCliente(),
			rc.getIdDipendente()
		};
		return db.save(query, params, true);
	}
	
	
	
	
	

}
