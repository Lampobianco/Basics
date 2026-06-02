package com.betacom.utils;

import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.betacom.exeption.AcademyExeption;
import com.betacom.singleton.SQLConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class GestioneSQL {

	/*
	 * Elenco tabelle del database corrente
	 */
	public List<String> tableList() {
		log.debug("table list for {}", SQLConfiguration.getInstance().retriveDBName());
		List<String> tables = new ArrayList<>();
		try {
			DatabaseMetaData dbMD = SQLConfiguration.getInstance().getConnection().getMetaData();
			ResultSet res = dbMD.getTables(SQLConfiguration.getInstance().retriveDBName(), null, null, null);
			while (res.next()) tables.add(res.getString("TABLE_NAME"));
		} catch (SQLException e) {
			log.error("Error in tableList: {}", e.getMessage());
		}
		return tables;
	}

	/*
	 * Query senza parametri — restituisce lista di righe come Map<colonna, valore>
	 */
	public List<Map<String, Object>> list(String query) throws AcademyExeption {
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(query);
			ResultSet res = cmd.executeQuery();
			log.debug("After resultSet");
			return resultsetToList(res);
		} catch (Exception e) {
			throw new AcademyExeption("List error: " + e.getMessage());
		}
	}

	/*
	 * Query con parametri — i ? vengono sostituiti con i valori di params
	 */
	public List<Map<String, Object>> list(String query, Object[] params) throws AcademyExeption {
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(query);
			createset(cmd, params);
			ResultSet res = cmd.executeQuery();
			log.debug("After resultSet");
			return resultsetToList(res);
		} catch (Exception e) {
			throw new AcademyExeption("List error: " + e.getMessage());
		}
	}

	/*
	 * Query che ritorna un singolo oggetto (es. findById)
	 */
	public Map<String, Object> get(String query, Object[] params) throws AcademyExeption {
		try {
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(query);
			createset(cmd, params);
			ResultSet res = cmd.executeQuery();
			return resultsetToMap(res);
		} catch (Exception e) {
			throw new AcademyExeption("Get error: " + e.getMessage());
		}
	}

	/*
	 * Count senza parametri
	 */
	public Long count(String query) throws AcademyExeption {
		try {
			String queryCount = "select count(*) as numero from (" + query + ") as numero";
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(queryCount);
			ResultSet res = cmd.executeQuery();
			res.next();
			return res.getLong("numero");
		} catch (Exception e) {
			throw new AcademyExeption("Count error: " + e.getMessage());
		}
	}

	/*
	 * Count con parametri
	 */
	public Long count(String query, Object[] params) throws AcademyExeption {
		try {
			String queryCount = "select count(*) as numero from (" + query + ") as numero";
			PreparedStatement cmd = SQLConfiguration.getInstance().getConnection().prepareStatement(queryCount);
			createset(cmd, params);
			ResultSet res = cmd.executeQuery();
			res.next();
			return res.getLong("numero");
		} catch (Exception e) {
			throw new AcademyExeption("Count error: " + e.getMessage());
		}
	}

	/*
	 * Insert/Update/Delete — pk=true ritorna la chiave generata, pk=false il numero di righe
	 */
	public int save(String query, Object[] params, boolean pk) throws AcademyExeption {
		int ret = 0;
		try {
			PreparedStatement cmd = pk
					? SQLConfiguration.getInstance().getConnection().prepareStatement(query, Statement.RETURN_GENERATED_KEYS)
					: SQLConfiguration.getInstance().getConnection().prepareStatement(query);
			createset(cmd, params);
			ret = cmd.executeUpdate();
			if (pk) {
				ResultSet generatedKeys = cmd.getGeneratedKeys();
				if (generatedKeys.next()) ret = generatedKeys.getInt(1);
			}
		} catch (Exception e) {
			throw new AcademyExeption("Save error: " + e.getMessage());
		}
		return ret;
	}

	/*
	 * Carica i parametri nel PreparedStatement tramite ricorsione
	 */
	private PreparedStatement createset(PreparedStatement cmd, Object[] params) throws SQLException {
		createset(cmd, params, 0);
		return cmd;
	}

	private void createset(PreparedStatement cmd, Object[] params, int index) throws SQLException {
		if (index >= params.length) return;
		cmd.setObject(index + 1, params[index]);
		createset(cmd, params, index + 1);
	}

	/*
	 * Converte un ResultSet in lista di Map<colonna, valore>
	 */
	private List<Map<String, Object>> resultsetToList(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int columns = meta.getColumnCount();
		List<Map<String, Object>> rows = new ArrayList<>();
		while (rs.next()) {
			Map<String, Object> row = new HashMap<>();
			for (int i = 1; i <= columns; i++)
				row.put(meta.getColumnLabel(i), rs.getObject(i));
			rows.add(row);
		}
		return rows;
	}

	/*
	 * Converte un ResultSet in una singola Map<colonna, valore>
	 */
	private Map<String, Object> resultsetToMap(ResultSet rs) throws SQLException {
		ResultSetMetaData meta = rs.getMetaData();
		int columns = meta.getColumnCount();
		if (!rs.next()) return null;
		Map<String, Object> row = new HashMap<>();
		for (int i = 1; i <= columns; i++)
			row.put(meta.getColumnLabel(i), rs.getObject(i));
		return row;
	}

}
