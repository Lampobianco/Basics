package com.betacom.objects.animals;

import java.util.ArrayList;

import com.betacom.interfaces.Animal;
import com.betacom.interfaces.Predator;
import com.betacom.interfaces.Prey;

public class MainAnimals {

	public static void main(String[] args) {
		
		Lion l1 = new Lion();
		Gazelle g1 = new Gazelle();
		Fish f1 = new Fish();
		
		ArrayList<Animal> animals = new ArrayList<Animal>();
		
		animals.add(l1);
		animals.add(f1);
		animals.add(new Gazelle());
		
		
		
		//l1.attack();
		//g1.fear();
		//f1.attack();
		//f1.fear();

		
		for (Animal it : animals) {
			
			identificazion(it);
			
		}
		
	}
	
	private static void identificazion(Animal a) { 
		// è un metodo che verifica se l'animale passato è una preda o un predatore e chiama un metodo specifico
		
		if(a instanceof Prey) {
			
			Prey p = (Prey) a;
			p.fear();
			
		}
		
		if(a instanceof Predator) {
			
			Predator p = (Predator) a;
			p.attack();
			
		}
		
	}

}
