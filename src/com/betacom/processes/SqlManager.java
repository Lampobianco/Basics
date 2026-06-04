package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.services.ServiceQuery;
import com.betacom.services.ServiceUpdate;
import com.betacom.services.ServicesTransaction;
import com.betacom.singleton.SQLConfiguration;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SqlManager implements GeneralProcess {

	@Override
	public boolean execute() throws Exception {
		log.info("Begin process SQL");
		try {
			SQLConfiguration.getInstance().getConnection();
			log.debug("Connect database ok");
			//new ServiceQuery().executeQuery();
			//new ServiceUpdate().executeUpdate();
			new ServicesTransaction().executeTransaction();
			SQLConfiguration.getInstance().closeConnection();
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return false;
	}

}
