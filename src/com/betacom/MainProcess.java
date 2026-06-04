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
	 * e implementare GeneralProcess e il resto lo fa loadProcesses().
	 */
	private static final Map<String, GeneralProcess> PROCESSES = loadProcesses();

	/*
	 * Scansiona il package a runtime e costruisce la mappa automaticamente.
	 * 1. Trova la cartella fisica del package tramite il ClassLoader
	 * 2. Carica ogni .class, salta interfacce e classi astratte
	 * 3. Chiave = nome senza "Manager" in minuscolo → "LogManager" = "log"
	 * 4. Crea un'istanza e la aggiunge alla mappa
	 */
	private static Map<String, GeneralProcess> loadProcesses() {

		Map<String, GeneralProcess> map = new HashMap<>();
		String pkg = "com.betacom.processes";

		try {
			URL pkgUrl = ClassLoader.getSystemClassLoader().getResource(pkg.replace('.', '/'));
			if (pkgUrl == null) { log.error("Package non trovato: {}", pkg); return map; }

			File[] classFiles = new File(pkgUrl.toURI()).listFiles();
			if (classFiles == null) return map;

			for (File file : classFiles) {

				// Salta tutto tranne i .class — ignora inner class (es. "Foo$Bar.class")
				if (!file.getName().endsWith(".class") || file.getName().contains("$")) continue;

				// Carica la classe, verifica che implementi GeneralProcess e sia concreta
				Class<?> cls = Class.forName(pkg + "." + file.getName().replace(".class", ""));
				if (!GeneralProcess.class.isAssignableFrom(cls)) continue;
				if (cls.isInterface() || Modifier.isAbstract(cls.getModifiers())) continue;

				// Deriva la chiave e crea l'istanza
				String key = cls.getSimpleName().replace("Manager", "").toLowerCase();
				map.put(key, (GeneralProcess) cls.getDeclaredConstructor().newInstance());
			}

		} catch (Exception e) {
			log.error("Caricamento processi fallito: {}", e.getMessage());
		}

		return Collections.unmodifiableMap(map);
	}

	public static void main(String[] args) {

		// Stampa tutti i processi caricati automaticamente, uno per riga
		log.info("Processi disponibili:\n{}", PROCESSES.keySet().stream()
				.sorted()
				.collect(java.util.stream.Collectors.joining("\n  - ", "  - ", "")));

		Scanner scanner = new Scanner(System.in);
		System.out.print("\n" +"Inserisci il processo da avviare: ");
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
