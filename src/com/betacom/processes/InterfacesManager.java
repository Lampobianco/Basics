package com.betacom.processes;

import java.util.ArrayList;

import com.betacom.interfaces.Animal;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.interfaces.Predator;
import com.betacom.interfaces.Prey;
import com.betacom.objects.animals.Fish;
import com.betacom.objects.animals.Gazelle;
import com.betacom.objects.animals.Lion;

public class InterfacesManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "** Begin Interfaces Manager **");
		
		ArrayList<Animal> lA = new ArrayList<Animal>();
		lA.add(new Gazelle());
		lA.add(new Lion());
		lA.add(new Fish());
		
		for (Animal it:lA) {
			identification(it);
		}

		
		return false;
	}

	private  void identification(Animal o) {
		if (o instanceof Prey) {
			Prey obj = (Prey)o;
			obj.fear();
		}
		if (o instanceof Predator) {
			Predator obj = (Predator)o;
			obj.attack();
		}
	}

}
