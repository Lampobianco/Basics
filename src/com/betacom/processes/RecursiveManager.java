package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RecursiveManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin Recursive Manager");
		
		int number = 3, result = 0;
		
		result = factorial(number);
		log.debug("Fattoriale di {} = {}", number, result);
		
		return false;
	}
	
	private int factorial(int n) {
		log.debug("Fattoriale {}", n);
		if(n != 0) {
			return n = n * factorial(n - 1);
		}else {
			return 1;
		}
		
	}

}
