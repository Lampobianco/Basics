package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.Inner;

public class InnerManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Inner Manager");
		
		Inner inner = new Inner();
		inner.setFatherClass("Siamo nella classe padre");
		inner.setNumero(3);

		System.out.println("Class inner -> " + inner.getFatherClass() + " numero -> " + inner.getNumero());

		Inner.Figlio figlio = inner.setInstanceFiglio();
		figlio.setNumero2(22);
		figlio.setFiglioClass("Siamo nella classe figlio");

		System.out.println("Class figlio -> " + figlio.getFiglioClass());
		System.out.println("Numero fiflio ->" + figlio.displayNumber());
		
		Inner.Figlio.Nipote nipote = figlio.setInstanceNipote();
		nipote.setNipoteClass("Sono nella classe Nipote");
		nipote.setNumero3(500);
		
		System.out.println("Class nipote -> " + nipote.displayNumberNipote());
		System.out.println("Numero nipote ->" + nipote.displayNumberNipote());

		nipote.setName("Paolo");
		nipote.setSurname("Verdi");
		nipote.setGender(true);
		System.out.println(nipote.getName() + " " + nipote.getSurname() + " " + nipote.getGender());
		
		return false;
	}
	

}
