package com.betacom.processes;

import com.betacom.enums.Department;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.company.Employee;

import java.util.ArrayList;

public class EnumManager implements GeneralProcess{

	@Override
	public boolean execute() {
		
		System.out.println("\n" + "Begin enum Manager");
		
		String value = " PRODUCTION ";
		Department d1 = null;
		
		try {
			
			d1 = Department.valueOf(value);
			
		}catch (IllegalArgumentException e) {
			System.out.println("Valore non valido !");
			d1 = Department.valueOf("IT");
		}
		
		System.out.println(d1.toString());
		
		ArrayList<Employee> emplyees = new ArrayList<Employee>();
		
		emplyees.add(new Employee("Paolo", "Rossi", true, 3000, Department.LOGISTICS));
		emplyees.add(new Employee("Giulio", "Verdi", true, 3500, Department.IT));
		emplyees.add(new Employee("Chiara", "Bianchi", false, 2000, Department.PRODUCTION));
		emplyees.add(new Employee("Giulia", "Rossi", true, 4000, Department.IT));		
		
		
		for(Employee it : emplyees) {
			
			if(it.getDepartment() == Department.IT)
				System.out.println("L'impiegato : " + it.getName() + " " + it.getSurname() + " lavora al dipartimento -> " + it.getDepartment());
	
		}
		
		
		return false;
	}

}
