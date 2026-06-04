package com.betacom.objects;

import java.io.Serializable;

public class Address implements Serializable{
	/*
	 * Java autonomamente sa che questa classe è da serializzare
	 * 
	 * */

	private static final long serialVersionUID = 1L;
	
	private String street;
	private String city;
	private String name;
	private boolean gender;
	//private String description;
	private transient String password;
	
	
	
public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "Address [street=" + street + ", city=" + city + ", name=" + name + ", gender=" + gender + ", password="
				+ password + "]";
	}
	
	
	
	

}
