package com.betacom.utils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.singleton.SQLConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GestioneSQL {

	/*
	 * Elenco tabelle del database corrente
	 */
	public List<String> tableList() {
		log.debug("table list for {}", SQLConfiguration.getInstance().retriveDBName());
		List<String> lT = new ArrayList<String>();
		try {
			DatabaseMetaData dbMD = SQLConfiguration.getInstance().getConnection().getMetaData();
			ResultSet res = dbMD.getTables(SQLConfiguration.getInstance().retriveDBName(), null, null, null);
			while(res.next()) {
				lT.add(res.getString("TABLE_NAME"));
			}
		} catch(SQLException e) {
			log.error("Error in tableList: {}", e.getMessage());
		}
		return lT;
	}

}
