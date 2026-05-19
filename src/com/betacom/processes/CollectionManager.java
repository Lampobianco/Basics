package com.betacom.processes;

import java.util.*;

import com.betacom.enums.Department;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.company.Employee;


public class CollectionManager implements GeneralProcess{

	@Override
	public boolean execute() {
		System.out.println("\n" + "Begin CollectionManager");
		
		
		
		return false;
	}
	
	private void executeList() {
		
		List<Employee> em1 = new ArrayList<Employee>();
		
		em1.add(new Employee("Paolo", "Rossi", true, 3000, Department.LOGISTICS));
		em1.add(new Employee("Giulio", "Verdi", true, 3500, Department.IT));
		em1.add(new Employee("Chiara", "Bianchi", false, 2000, Department.PRODUCTION));
		em1.add(new Employee("Giulia", "Rossi", true, 4000, Department.IT));
		
		listEmployee(em1, "Appena Creato");
		
		System.out.println("** Item 5 **");
		System.out.println(em1.get(5));
		
	}
	
	
	private void listEmployee(List<Employee> em, String title) {
		
		System.out.println("************" + title + "*************");
		int pos = 0;
		for(Employee it : em) {
			
			System.out.println(pos + " - " + it);
			
		}
		
	}

}
