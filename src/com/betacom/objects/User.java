package com.betacom.objects;

import java.time.LocalDate;

public class User {
	
	private String name;
	private String surname;
	private boolean gender;
	private LocalDate birthday;
	private LocalDate medicalReport;
	
	public User(String name, String surname, boolean gender) {
	
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	
	public User(String name, String surname, String gender) {
		
		this.name = name;
		this.surname = surname;
		this.gender = "M".equalsIgnoreCase(gender) ? true : false;
	}
	
	public User(String name, String surname, String gender, LocalDate birthday) {
		
		this.name = name;
		this.surname = surname;
		this.gender = "M".equalsIgnoreCase(gender) ? true : false;
		this.birthday = birthday;
		
	}
	
	public User(String name, String surname, String gender, int year, int month, int day) {
		
		this.name = name;
		this.surname = surname;
		this.gender = "M".equalsIgnoreCase(gender) ? true : false;
		this.birthday = LocalDate.of(year, month, day);
		
	}
	
	
	public User() {};
	

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public Boolean getGender() {
		return this.gender;
	}

	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	
	

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	
	
	
	public LocalDate getMedicalReport() {
		return medicalReport;
	}

	public void setMedicalReport(LocalDate medicalReport) {
		this.medicalReport = medicalReport;
	}

	@Override
	public String toString() {
		return "\n" + "Nome : " + this.name + "\n" + "Cognome : " + this.surname +  "\n" + "Sesso : " + (this.gender ? "M" : "F") + "\n";
	}
	
	

}
