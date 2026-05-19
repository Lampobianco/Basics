package com.betacom.objects.cars;

public abstract class Car {
	
	private String model;
	private String color;
	private int maxSpeed;
	
	public abstract void brakes();
	public abstract void accellerate();
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getMaxSpeed() {
		return maxSpeed;
	}
	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}
	
	

}
