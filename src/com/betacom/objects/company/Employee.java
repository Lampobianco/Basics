package com.betacom.objects.company;

import com.betacom.enums.Department;

public class Employee extends Person{
	
	private double salary;
	private Department department;

	public Employee() {}
	
	public Employee(String name, String surname, boolean gender, double salary, Department department) {
		super(name, surname, gender);
		this.salary = salary;
		this.department = department;
	}
	
	public Employee(String name, String surname, String gender, double salary, String department) {
		super(name, surname, gender);
		this.salary = salary;
		try {
			this.department = Department.valueOf(department);
		} catch (IllegalArgumentException e) {
			this.department = Department.IT;
			System.out.println("Reparto ->" + this.department.toString());
		}
	}
	
	public Employee(String name, String surname, String gender, double salary) {
		super(name, surname, gender);
		this.salary = salary;
	}
	
	
	

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	@Override
	public String toString() {
		
		String rep = "";
		
		if(department != null) {
			
			rep = "Reparto = " + department.toString();
			
		}
		
		return super.toString() + "Salario :" + this.salary + "\n" + rep + "\n";
		
		
	}
	

}
