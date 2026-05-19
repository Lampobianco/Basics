package com.betacom.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

import com.betacom.exeption.AcademyExeption;

public class Utilities { // spesso questa classe la si duplica tra vari progetti
	
	private final static String PATTERN_DATE = " d/M/yyyy:ss ";
	
	/*
	 * 
	 * trasforma la data in uno string formattato
	 * 
	 * */
	
	
	public static String dateToString(LocalDateTime myDate) {
		return dateToString(PATTERN_DATE,myDate);
	}
	
	public static String dateToString(String pattern, LocalDateTime myDate) { // pattern = formattazione data, myDate = ora locale
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN); // trasforma la data nel formato che si vuole
		return myDate.format(formatter);
	}
	
	public static String dateToString(String pattern, LocalDate myDate) { 
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN); 
		return myDate.format(formatter);
		
	}
	
	public static LocalDate stringToDate(String pattern, String myDate) throws AcademyExeption{
		LocalDate r = null;
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, Locale.ITALIAN);
			r =  LocalDate.parse(myDate, formatter);
			
		} catch (DateTimeParseException e) {
			throw new AcademyExeption("Formato della data invalido -> " + myDate + "\n" + "Formato previsto -> " + pattern);
		}
		return r;
	}
	
	
	public static String dateToString(LocalDate myDate) { 
		return dateToString(PATTERN_DATE, myDate);
	}

	

	
}
