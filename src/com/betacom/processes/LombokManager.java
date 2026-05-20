package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.LombokObject;

public class LombokManager implements GeneralProcess {

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Lombok");

		LombokObject obj = new LombokObject();
		obj.setCognome("Rossi");
		obj.setNome("Mario");
		obj.setIndirizzo("Via Roma 1");

		System.out.println(obj.toString());

		return false;
	}

}
