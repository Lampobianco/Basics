package com.betacom.objects.company;

public abstract class Person {

	private String name;
	private String surname;
	private boolean gender;
	
	public Person() {};
	
	public Person(String name, String surname, boolean gender) {
		
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}
	
	public Person(String name, String surname, String gender) {
		
		this.name = name;
		this.surname = surname;
		this.gender = "M".equalsIgnoreCase(gender) ? true : false;
	}
	

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public boolean isGender() {
		return gender;
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

	@Override
	public String toString() {
		return "\n" + "Nome : " + this.name + "\n" + "Cognome : " + this.surname +  "\n" + "Sesso : " + (this.gender ? "M" : "F") + "\n";
	}
	
}
