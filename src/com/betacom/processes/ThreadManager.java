package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.others.MyFirstThread;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin Thread Manager");
		
		Thread t = new Thread(new MyFirstThread());
		
		t.start();
		log.debug("Thread start ...");
		
		log.debug("Thread Managr is ended");
		
		return false;
	}

}
