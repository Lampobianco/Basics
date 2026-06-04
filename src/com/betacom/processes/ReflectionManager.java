package com.betacom.processes;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

import com.betacom.interfaces.GeneralProcess;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReflectionManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		log.info("Begin Reflection Manager");
		
		String packageName = "com.betacom.objects";
		String className = "MyClassReflection";
		
		Class cl = Class.forName(packageName + "." + className);
		log.info("Class {} found", className);
		
		Constructor selectedCostructor = null;
		int constructorToSelected = 0;
		
		Constructor[] cos = cl.getConstructors();
		log.info("Numero di costruttori trovati {}", cos.length);
		
		for (Constructor cos1:cos) {
			log.info("... numero di parametri trovati per costruttore --> {} ", cos1.getParameterCount());
			if(cos1.getParameterCount() == constructorToSelected) {
				selectedCostructor = cos1;
			}
			Type[] type = cos1.getGenericParameterTypes();
			for(Type t:type) {
				log.info("........... Tipo parametro --> {}", t);
			}
		}
		
		Object myClass = null;
		if(constructorToSelected == 0) {
			log.info("Nuova istanza senza parametri");
			myClass = selectedCostructor.newInstance();
		}
		
		if(constructorToSelected == 2) {
			log.info("Nuova istanza con 2 parametri (Integer, String)");
			myClass = selectedCostructor.newInstance(10, "2 parametri");
		}
		
		if(constructorToSelected == 3) {
			log.info("Nuova istanza con 3 parametri (Integer, String, Integer)");
			myClass = selectedCostructor.newInstance(10, "3 parametri", 500);
		}
		
		log.info("Istanza creata --> {}", myClass);
		
		introspectionMethods(myClass);
		
		return false;
	}

	private void introspectionMethods(Object myClass) throws Exception {
		/*
		 * introspection methods
		 * */
		Method[] methods = myClass.getClass().getMethods();
		for (Method method:methods) {
			log.info("......... method trovato {}", method.getName());
			if("setId".equals(method.getName()))
				method.invoke(myClass, 10);
			if("setDesk".equals(method.getName()))
				method.invoke(myClass, "desc caricato con reflection");
			if("setP1".equals(method.getName()))
				method.invoke(myClass, 250);
		}
		
		String methdName = "toString";
		Method m = myClass.getClass().getMethod(methdName);
		String msg = (String) m.invoke(myClass);
		
		log.info("ToString --> {} ", msg);
		
	}
	
	
	
}

