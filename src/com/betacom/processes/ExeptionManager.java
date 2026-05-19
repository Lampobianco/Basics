package com.betacom.processes;

import com.betacom.exeption.AcademyExeption;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;

public class ExeptionManager implements GeneralProcess{

	@Override
	public boolean execute() {
		System.out.println("\n" + "Begin Exeption Process");
		
		int p1 = 10;
		int p2 = 0;	
		int res = p1 / p2;
		
		User user = new User();
		user.setName("Pippo");
		user.setSurname("Rossi");
		validationUser(user);
			
		
			return false;
		}
	
	
		private void validationUser(User usr) throws AcademyExeption{
			if (usr.getName() == null)
				throw new AcademyExeption("Nome user non validato");
			if (usr.getSurname() == null)
				throw new AcademyExeption("Cognome user non validato");
			if (usr.getGender() == null)
				throw new AcademyExeption("Sesso user non validato");
			}
	
		

}
