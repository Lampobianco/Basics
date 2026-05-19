package com.betacom.processes;

import java.time.*;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.User;
import com.betacom.utils.Utilities;

import java.time.LocalDateTime;

public class DateManager implements GeneralProcess{ // gestione delle date in java ottimizzate
	
	/*
	 * 
	 * oggi si usa una API
	 * 
	 * */
	
	private final static String PATTERN_DATE = " d/M/yyyy ";
	private final static String PATTER_DATE_ESTESO = "E d/M/yyyy HH:mm:ss";
	

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "** Begin Date Manager **");
		
		LocalDateTime ora = LocalDateTime.now();
		
		String r = String.format("La data di oggi è -> %s ", Utilities.dateToString(PATTERN_DATE, ora));
		System.out.println(r);
		
		r = String.format("La data e l'ora di oggi sono -> %s ", Utilities.dateToString(PATTER_DATE_ESTESO, ora));
		System.out.println(r);
		
		//LocalDate birthday = LocalDate.parse("1998-06-11");
		//System.out.println(birthday);
		
		User u1 = new User("Anna", "Verdi","F", Utilities.stringToDate(PATTERN_DATE, "11/06/1998"));
		System.out.println(u1);
		
		u1 = new User("Gianni", "Laverdura", "M", 2000, 12, 12);
		System.out.println(u1);
		
System.out.println("Data nascita :" + Utilities.dateToString(PATTERN_DATE, u1.getBirthday()));
		
		int plusGiorni = 25;
		u1.setBirthday(u1.getBirthday().plusDays(plusGiorni));
		
		System.out.println("Data modificata :" + Utilities.dateToString(PATTERN_DATE, u1.getBirthday()));
		

		u1.setMedicalReport(Utilities.stringToDate(PATTERN_DATE, "10/05/2025"));
		System.out.println(u1);
		
		int meseDiValidita = 12;
		LocalDate endDate = u1.getMedicalReport().plusMonths(meseDiValidita);
		
		if (LocalDate.now().isAfter(endDate))
			System.out.println("Certificato medico scaduto. date fine validita :" + 
						Utilities.dateToString(PATTERN_DATE, endDate));
		else 
			System.out.println("Certificato medico valido fino " + Utilities.dateToString(PATTERN_DATE, endDate));
		
		return false;
	}

}
