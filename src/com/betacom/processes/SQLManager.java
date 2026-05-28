package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.services.ServiceQuery;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SQLManager implements GeneralProcess {

	@Override
	public boolean execute() throws Exception {
		log.info("Begin SQL Manager");

		new ServiceQuery().executeQuery();

		return false;
	}

}
