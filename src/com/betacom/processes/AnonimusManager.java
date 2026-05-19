
package com.betacom.processes;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.betacom.interfaces.Azione;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.company.Employee;

public class AnonimusManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Anonimus class");
		
		Azione a = new Azione() {

			@Override
			public void esegui(String param) {
				System.out.println("Azione eseguita con parametro  -> " + param);
				
			}
			
		};
		
		a.esegui("mio parametro");
		
		// interfaccia funzionale ha solo un metodo
		
		/*
		 * trasformazione in lambda
		 * 
		 * */
		
		Azione l = (param) -> {
			System.out.println("Azione eseguita con parametro  -> " + param);
			System.out.println("Esegui secondo  -> ");
		};
		
		l.esegui("Secondo");
		
		/*
		 * Esempio con il sort senz lambda
		 * 
		 * */
		
		// vedere quekllo del prof
		
		
		return false;
	}

}
