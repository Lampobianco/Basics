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
			if(input == null)
				throw new AcademyExeption("File sql.properties non trovato nel classpath");
			prop.load(input);
			log.info("Configurazione SQL caricata correttamente");
		} catch(IOException e) {
			throw new AcademyExeption(e.getMessage());
		}
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

	// Getter per le proprietà
	public String getUrl()    { return prop.getProperty("url");    }
	public String getUser()   { return prop.getProperty("user");   }
	public String getPwd()    { return prop.getProperty("pwd");    }
	public String getDriver() { return prop.getProperty("driver"); }

}
