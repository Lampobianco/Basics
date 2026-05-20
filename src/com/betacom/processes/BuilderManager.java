package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Negozio;

public class BuilderManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Builder Manager");
		
		//Negozio negozio = new Negozio(12, "Mister Bean", "Via Roma, 12 Torino", false);
		//System.out.println(negozio);
		
		/*
		 * Il pattern Builder serve a migliorare l'inserimento dei valori quando 
		 * ci sono dei new, ed è molto utilizzato
		 * 
		 * */
		
		Negozio negozio  = Negozio.builder()
					.codice(22)
					.isCentroCommerciale(false)
					.indirizzo("Via Roma, 12 Torino")
					.proprieta("Mister Beam")
					.build();
		
		System.out.println(negozio);
					
		
		return false;
	}

}
