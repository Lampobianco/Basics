package com.betacom.processes;

import java.util.Optional;

import com.betacom.interfaces.GeneralProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class OptionalManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin Optional Manager");
		
		String t = null;
		Optional<String> vuoto = Optional.empty(); // optional vuoto
		Optional<String> nome = Optional.of("Pippo"); // carica un valore differente da quello vuoto 
		
		String valore = null;
		
		Optional<String> opt = Optional.ofNullable(valore); // carica qualsiasi valore anche null
		
		
		return false;
	}

}
