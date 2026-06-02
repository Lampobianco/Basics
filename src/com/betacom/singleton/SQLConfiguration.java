package com.betacom.singleton;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.betacom.exeption.AcademyExeption;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SQLConfiguration {

	private static SQLConfiguration instance = null;
	private static Properties prop = new Properties();
	private Connection con = null;
	private static Properties queries = new Properties();
;
	// Costruttore privato: nessuno può fare "new SQLConfiguration()" dall'esterno
	private SQLConfiguration() {
	}

	// Unico punto di accesso all'istanza (pattern Singleton)
	public static SQLConfiguration getInstance() {
		if(instance == null) {
			instance = new SQLConfiguration();
			loadConfiguration();
		}
		return instance;
	}

	private static void loadConfiguration() {
		try {
			InputStream input = SQLConfiguration.class.getClassLoader().getResourceAsStream("sql.properties");
			if (input == null) throw new AcademyExeption("File sql.properties non trovato nel classpath");
			prop.load(input);

			input = SQLConfiguration.class.getClassLoader().getResourceAsStream("query.properties");
			if (input == null) throw new AcademyExeption("File query.properties non trovato nel classpath");
			queries.load(input);

			log.info("Configurazione SQL e query caricate correttamente");
		} catch(IOException e) {
			throw new AcademyExeption(e.getMessage());
		}
	}

	// Restituisce la query associata alla chiave nel file query.properties
	// es. getQuery("query.dipendenti") --> "select * from dipendenti"
	public String getQuery(String key) {
		return queries.getProperty(key);
	}

	// Se la connessione non esiste la crea, altrimenti restituisce quella già aperta
	public Connection getConnection() throws AcademyExeption {
		if(con == null) {
			con = openConnection();
			log.info("Nuova connessione aperta al DB --> {}", retriveDBName());
		} else {
			log.info("Connessione già attiva, riutilizzo quella esistente");
		}
		return con;
	}

	// Crea fisicamente la connessione al database
	private Connection openConnection() {
		try {
			Class.forName(getProperty("driver"));
			return DriverManager.getConnection(
					getProperty("url"),
					getProperty("user"),
					getProperty("pwd"));
		} catch(Exception e) {
			throw new AcademyExeption(e.getMessage());
		}
	}

	// Estrae il nome del database dall'URL
	// es. "jdbc:mysql://localhost:3306/db_academy" --> "db_academy"
	public String retriveDBName() {
		return getProperty("url").substring(getProperty("url").lastIndexOf("/") + 1);
	}

	// Metodo privato di accesso alle proprietà
	private String getProperty(String key) {
		return prop.getProperty(key);
	}

	// Chiude la connessione al DB
	public void closeConnection() throws AcademyExeption {
		try {
			if (con != null) { con.close(); con = null; }
		} catch (Exception e) { throw new AcademyExeption(e.getMessage()); }
	}

	// Abilita autocommit (ogni statement viene committato automaticamente)
	public void setAutocommit() throws AcademyExeption {
		try { getConnection().setAutoCommit(true); }
		catch (Exception e) { throw new AcademyExeption(e.getMessage()); }
	}

	// Disabilita autocommit — serve per gestire transazioni manuali
	public void setTransaction() throws AcademyExeption {
		try { getConnection().setAutoCommit(false); }
		catch (Exception e) { throw new AcademyExeption(e.getMessage()); }
	}

	// Conferma la transazione corrente
	public void commit() throws AcademyExeption {
		try { getConnection().commit(); }
		catch (Exception e) { throw new AcademyExeption(e.getMessage()); }
	}

	// Annulla la transazione corrente
	public void rollback() throws AcademyExeption {
		try { getConnection().rollback(); }
		catch (Exception e) { throw new AcademyExeption(e.getMessage()); }
	}

	// Getter per le proprietà
	public String getUrl()    { return prop.getProperty("url");    }
	public String getUser()   { return prop.getProperty("user");   }
	public String getPwd()    { return prop.getProperty("pwd");    }
	public String getDriver() { return prop.getProperty("driver"); }

}
