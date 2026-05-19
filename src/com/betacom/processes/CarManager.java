package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.cars.BMW;
import com.betacom.objects.cars.Fiat500;

public class CarManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "** Begin Car Manager **");
		
		Fiat500 fiat1 = new Fiat500();
		fiat1.setColor("Nero");
		fiat1.setMaxSpeed(230);
		fiat1.setModel("Fiat 500");
		
		fiat1.accellerate();
		fiat1.brakes();
		
		BMW bmw1 = new BMW();
		bmw1.setColor("Red");
		bmw1.setMaxSpeed(350);
		bmw1.setModel("BMW M3");
		
		bmw1.accellerate();
		bmw1.brakes();
		
			
		System.out.println("\n" + "Specifiche Automobili ");
		System.out.println("\n" + "Modello : " + fiat1.getModel() + "\n" + "Colore: " + fiat1.getColor() + "\n" + "Velocità Massima : " + fiat1.getMaxSpeed());
		System.out.println("\n" + "Modello : " + bmw1.getModel() + "\n" + "Colore: " + bmw1.getColor() + "\n" + "Velocità Massima : " + bmw1.getMaxSpeed());
		
		return false;
	}

}
