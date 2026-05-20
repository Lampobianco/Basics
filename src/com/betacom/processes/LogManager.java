package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogManager implements GeneralProcess{

	private static final Logger logger = LoggerFactory.getLogger(LogManager.class);
	
	@Override
	public boolean execute() throws Exception {
		
		logger.info("Begin Log Manager");
		
		String nome = "Mario";
		int eta = 13;
		
		logger.debug("Utente Trovato --> {} con età --> {} ", nome, eta);
		
		logger.warn("Attenzione età vicina al limite --> {}", eta);
		
		try {
			int risultato = 10/0;
		}catch (Exception e){
			logger.error("Errore nel calcolo --> {}", e.getMessage());
		}
		
		
	
		return false;
	}

}
