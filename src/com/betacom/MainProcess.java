package com.betacom;

import java.io.File;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.betacom.exeption.AcademyExeption;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainProcess {

	/*
	 * La mappa viene costruita AUTOMATICAMENTE a runtime:
	 * non serve piu aggiungere manualmente ogni nuovo Manager.
	 * Basta creare la classe nel package "com.betacom.processes"
	 * e implementare GeneralProcess -- il resto lo fa loadProcesses().
	 */
	private static final Map<String, GeneralProcess> PROCESSES = loadProcesses();

	/**
	 * Scansiona il package dei processi a runtime e costruisce la mappa.
	 *
	 * Come funziona passo per passo:
	 *   1. Trova la cartella del package sul filesystem tramite il ClassLoader
	 *   2. Carica ogni file .class come classe Java
	 *   3. Controlla se la classe implementa GeneralProcess
	 *   4. Ricava la chiave dal nome della classe:
	 *        "BaseManager"       --> "base"
	 *        "LogManager"        --> "log"
	 *        "ReflectionManager" --> "reflection"
	 *   5. Crea un'istanza con il costruttore senza parametri
	 *   6. Aggiunge la coppia chiave/istanza alla mappa
	 */
	private static Map<String, GeneralProcess> loadProcesses() {

		Map<String, GeneralProcess> map = new HashMap<>();
		String packageName = "com.betacom.processes";

		try {
			// Trasforma "com.betacom.processes" in "com/betacom/processes"
			String packagePath = packageName.replace('.', '/');

			// Chiede al ClassLoader dove si trova fisicamente il package
			URL packageUrl = ClassLoader.getSystemClassLoader().getResource(packagePath);
			if (packageUrl == null) {
				System.err.println("[ERRORE] Package non trovato: " + packageName);
				return map;
			}

			File packageDir = new File(packageUrl.toURI());
			File[] files = packageDir.listFiles();
			if (files == null) return map;

			for (File file : files) {

				// Considera solo i file .class
				// Salta le inner class (contengono "$" nel nome, es. "Foo$Bar.class")
				if (!file.getName().endsWith(".class")) continue;
				if (file.getName().contains("$"))       continue;

				// Ricostruisce il nome completo della classe ed la carica
				String className = packageName + "." + file.getName().replace(".class", "");
				Class<?> cls = Class.forName(className);

				// Controlla i requisiti:
				// - deve implementare GeneralProcess
				// - non deve essere un'interfaccia
				// - non deve essere una classe astratta
				if (!GeneralProcess.class.isAssignableFrom(cls)) continue;
				if (cls.isInterface())                            continue;
				if (Modifier.isAbstract(cls.getModifiers()))     continue;

				// Ricava la chiave rimuovendo il suffisso "Manager" e mettendo in minuscolo
				// Esempio: "ReflectionManager" --> "reflection"
				String key = cls.getSimpleName().replace("Manager", "").toLowerCase();

				// Crea l'istanza usando il costruttore senza parametri
				GeneralProcess instance = (GeneralProcess) cls.getDeclaredConstructor().newInstance();
				map.put(key, instance);
			}

		} catch (Exception e) {
			System.err.println("[ERRORE] Caricamento processi fallito: " + e.getMessage());
		}

		// Restituisce la mappa come non modificabile (sicurezza)
		return Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {

		// Stampa tutti i processi caricati automaticamente
		log.info("Processi disponibili: {}", PROCESSES.keySet());

		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserisci il processo da avviare: ");
		String selection = scanner.nextLine().trim();

		log.info("Main Process is Ready to Execute {} at {} *****", selection, Utilities.dateToString(LocalDateTime.now()));

		try {
			GeneralProcess gp = PROCESSES.get(selection);

			if (gp == null)
				throw new AcademyExeption("Processo non previsto: " + selection);

			gp.execute();
			System.out.println("\n*** Processo Terminato con Successo ! ***");

		} catch (Exception e) {
			System.err.println("\nErrore durante l'esecuzione -> " + e.getMessage());
		} finally {
			scanner.close();
		}
	}
}
