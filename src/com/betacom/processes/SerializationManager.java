package com.betacom.processes;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Address;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SerializationManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.debug("Begin Serialization Manager");
		
		Address address = new Address();
		address.setCity("Roma");
		address.setName("Giulio Verdi");
		address.setGender(true);
		address.setStreet("Via Roma, 34");
		
		try(FileOutputStream fout = new FileOutputStream("C://Users//lodan//Desktop//Test//address.txt")){
			ObjectOutputStream objOutStream = new ObjectOutputStream(fout);
			objOutStream.writeObject(address);
			objOutStream.flush();
			objOutStream.flush();
			
			log.debug("Object Created --> {}", address);
		}catch (IOException e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
