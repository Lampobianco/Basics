package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.company.Employee;
import com.betacom.objects.company.EmployeeStream;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Stream Manager");
		
		List<Employee> l = Stream.of(
			new Employee("Paolo", "Verdi", "M", 2000),
			new Employee("Pietro", "Biachi", "M", 3000),
			new Employee("Giulia", "Rossi", "F", 2100),
			new Employee("Marco", "Marrone", "M", 1500),
			new Employee("Chiara", "Gialli", "F", 2400),
			new Employee("Giancarlo", "Neri", "M", 3400),
			new Employee("Paola", "Viola", "F", 2500)
			// il .toList si usa su operazioni finali di un servizio, perchè distrugge lo stream
			// il .collect(Collectors.toList()) prendi tutti gli elementi della lista e gli trasformi il list, in questo modo ho 2 oggetti distinti non distruggo la lista di prima
			).collect(Collectors.toList()); 
		
			l.forEach(imp -> System.out.println(imp));
			/*
			 * create stream with builder 
			 * 
			 * */
			
			Stream<String> streamBuilder = Stream.<String> builder()
					.add("Lunedi")
					.add("Martedi")
					.add("Mercoledi")
					.add("Giovedi")
					.add("Venerdi")
					.add("Sabato")
					.add("Domenica")
					.build();
			
			String[] giorni = streamBuilder.toArray(size -> new String[size]);
			
			System.out.println("Giorni lunghezza -> " + giorni.length + " giorni[4] -> " + giorni[4]);
					
			/*
			 * Creazione Random
			 * 
			 * */
			
			Random ran = new Random();
			Stream<Long> sR = Stream.generate(() -> ran.nextLong()).limit(10);
			sR.forEach(n -> System.out.println(n));
			
			/*
			 * Generazione dati primitivi
			 * 
			 * */
			
			System.out.println("Generazione dati primitivi");
			IntStream intStream = IntStream.range(3,15);
			intStream.forEach(i -> System.out.println(i));
			
			/*
			 * Filtro
			 * 
			 * */
			
			l.stream()
				.filter(im -> im.isGender()) // sono tutti i maschi, se metto ! davanti prende tutte le femmine
				.filter(im -> im.getSalary() > 2000)
				.forEach(im -> System.out.println(im));
			
			/*
			 * Map
			 * 
			 * */
			
			List<EmployeeStream> les = l.stream()
			.filter(im -> im.isGender()) // sono tutti i maschi, se metto ! davanti prende tutte le femmine
			.filter(im -> im.getSalary() > 2000)
			.map(imp -> new EmployeeStream(imp.getName(), imp.getSurname()))
			.toList();
			
			les.forEach(i -> System.out.println(i));
			
			/*
			 * Count
			 * 
			 * */
			
			long count = l.stream()
					.filter(im -> im.isGender())
					.count();
			System.out.println("Numero di donne -> " + count);
			
			/*
			 * Match
			 * 
			 * */
			
			boolean rm = l.stream()
					.filter(im -> im.isGender())
					.anyMatch(im -> im.getSalary() >5000);
			System.out.println("Result del Match -> " + rm);
		
		return false;
	}
	


}
