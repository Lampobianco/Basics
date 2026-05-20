package com.betacom;

import java.util.Map;
import java.util.Scanner;

import com.betacom.exeption.AcademyExeption;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.processes.AnonimusManager;
import com.betacom.processes.BaseManager;
import com.betacom.processes.BuilderManager;
import com.betacom.processes.CarManager;
import com.betacom.processes.CollectionManager;
import com.betacom.processes.DateManager;
import com.betacom.processes.EnumManager;
import com.betacom.processes.ExeptionManager;
import com.betacom.processes.InnerManager;
import com.betacom.processes.InterfacesManager;
import com.betacom.processes.JsonManager;
import com.betacom.processes.ListManager;
import com.betacom.processes.LogManager;
import com.betacom.processes.LombokManager;
import com.betacom.processes.MapManager;
import com.betacom.processes.SequenzialManager;
import com.betacom.processes.StreamManager;
import com.betacom.processes.StringManager;

public class MainProcess {

	private static final Map<String, GeneralProcess> PROCESSES = Map.ofEntries(
			Map.entry("base",       new BaseManager()),
			Map.entry("enum",       new EnumManager()),
			Map.entry("car",        new CarManager()),
			Map.entry("date",       new DateManager()),
			Map.entry("exeption",   new ExeptionManager()),
			Map.entry("animal",     new InterfacesManager()),
			Map.entry("list",       new ListManager()),
			Map.entry("string",     new StringManager()),
			Map.entry("map",        new MapManager()),
			Map.entry("collection", new CollectionManager()),
			Map.entry("sequenzial", new SequenzialManager()),
			Map.entry("stream",     new StreamManager()),
			Map.entry("anonimus",   new AnonimusManager()),
			Map.entry("json",       new JsonManager()),
			Map.entry("inner",      new InnerManager()),
			Map.entry("builder",      new BuilderManager()),
			Map.entry("lombok",      new LombokManager()),
			Map.entry("log",         new LogManager())
	);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("Inserisci il processo da avviare: ");
		String selection = scanner.nextLine().trim();

		System.out.println("*** Main Process is Running -> " + selection + " ***");

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