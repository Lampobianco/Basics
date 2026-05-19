package com.betacom.processes;

import com.betacom.enums.Department;
import com.betacom.exeption.AcademyExeption;
import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.company.Employee;

import java.util.ArrayList;
import java.util.List;

public class ListManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "** Begin ListManager **");
		
		List<Employee> lI = load();
		listImpiegati(lI, "Dopo creazione");
		
		System.out.println();
		System.out.println("*** item 5 ***" +lI.get(5));
		try {
			System.out.println("item cancellato :" + removeFromImpiegati(lI, 5));
			listImpiegati(lI, "Dopo cancellazione");
			System.out.println("item cancellato :" + removeFromImpiegati(lI, "Pulico"));
			listImpiegati(lI, "Dopo cancellazione di Pulico");
		} catch (AcademyExeption  e) {
			System.err.println(e.getMessage());
		}
		lI.add(new Employee("Giusi", "Smalloco", "F", 1700.0, "IT"));
		listImpiegati(lI, "Dopo add Smalloco");
		
		increaseSalary(lI, "IT", 1.5);
		listImpiegati(lI, "Dopo increase Salary di 1.5");

		return false;
	}

	private List<Employee> load(){
		List<Employee> emplyees = new ArrayList<Employee>();
		
		emplyees.add(new Employee("Gianni", "Verdi", "M", 1800.0, "IT"));
		emplyees.add(new Employee("Marco", "Lavulla", "M", 1600.0, "IT"));
		emplyees.add(new Employee("Gianni", "Danco", "M", 1700.0, "PRODUZIONE"));
		emplyees.add(new Employee("Anna", "Bella", "F", 1300.0, "LOGISTICA"));
		emplyees.add(new Employee("Beatice", "Bellona", "F", 1400.0, "PRODUZIONE"));
		emplyees.add(new Employee("Marco", "Grande", "M", 2000.0, "IT"));
		emplyees.add(new Employee("Mirko", "Pulico", "M", 1800.0, "PRODUZIONE"));
		emplyees.add(new Employee("Daniel", "Andorua", "M", 1500.0, "LOGISTICA"));
		emplyees.add(new Employee("Nicolo", "Danke", "M", 1400.0, "PRODUZIONE"));
		emplyees.add(new Employee("Daniela", "Ciamplu", "F", 1900.0, "IT"));
		emplyees.add(new Employee("Angelina", "Billico", "F", 2100.0, "LOGISTICA"));
		emplyees.add(new Employee("Eric", "Lapiero", "M", 1100.0, "PRODUZIONE"));
		emplyees.add(new Employee("Piero", "Ponte", "M", 1500.0, "IT"));
		emplyees.add(new Employee("Maria", "Filippo", "F", 1600.0, "LOGISTICA"));
		emplyees.add(new Employee("Cecilia", "Marcella", "F", 1400));
		
		return emplyees;
	}
	
	private void listImpiegati(List<Employee> lI, String title) {
		System.out.println("************ " + title + " ******************");
		int pos = 0;
		for (Employee it:lI) {
			System.out.println(pos + " - " + it);
			pos++;
		}
	}
	
	private Employee removeFromImpiegati(List<Employee> lI, int pos) throws AcademyExeption{
		if (pos >= lI.size()) 
			throw new AcademyExeption("pos invalido:" + pos + " max:" + lI.size());
		
		Employee r = lI.get(pos);
		lI.remove(pos);
		return r;
	}
	private Employee removeFromImpiegati(List<Employee> lI, String cognome) throws AcademyExeption{
		int pos = 0;
		for (Employee it:lI) {
			if (cognome.equals(it.getSurname()))
				return removeFromImpiegati(lI, pos);
			pos++;
		}
		throw new AcademyExeption("cognome " + cognome + " non trovato dentro la lista");
	}
	private void increaseSalary(List<Employee> lI, String reparto, double f){
		for (Employee it:lI) {
			if (it.getDepartment() == Department.valueOf(reparto))
				it.setSalary(it.getSalary() * f);
		}
	}

}
