package com.betacom.objects.animals;

import com.betacom.interfaces.Animal;
import com.betacom.interfaces.Predator;
import com.betacom.interfaces.Prey;

public class Fish implements Prey, Predator, Animal{

	@Override
	public void fear() {
		System.out.println("Il pesce fugge dai predatori");
		
	}

	@Override
	public void attack() {
		System.out.println("Il pesce attacca");
		
	}

}
