package com.betacom.objects.animals;

import com.betacom.interfaces.Animal;
import com.betacom.interfaces.Predator;

public class Lion implements Predator, Animal{

	@Override
	public void attack() {
		System.out.println("Il leone ruggisce");
		
	}

}
