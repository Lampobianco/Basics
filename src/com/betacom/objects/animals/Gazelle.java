package com.betacom.objects.animals;

import com.betacom.interfaces.Animal;
import com.betacom.interfaces.Prey;

public class Gazelle implements Prey, Animal{

	@Override
	public void fear() {
		System.out.println("La gazzella fugge dal leone");
		
	}

}
