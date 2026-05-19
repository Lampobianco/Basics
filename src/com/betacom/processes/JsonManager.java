package com.betacom.processes;

import java.util.List;

import com.betacom.interfaces.GeneralProcess;
import com.betacom.objects.ObjectJson;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;





public class JsonManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("Begin Json Manager");
		
		ObjectJson usr = new ObjectJson("Giuseppe", "Bianchi", true);
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		
		/*
		 * Obj json
		 * 
		 * */
		
		String jsonString = gson.toJson(usr);
		System.out.println(jsonString);
		
		/*
		 * json to object
		 * 
		 * */
		
		ObjectJson newUser = gson.fromJson(jsonString, ObjectJson.class);
		System.out.println("Nuovo oggetto json -> " + newUser);
		
		List<ObjectJson> lU = List.of(
				new ObjectJson("Paolo", "Verdi", true),
				new ObjectJson("Giulio", "Rossi", true),
				new ObjectJson("Chiara", "Gialli", true)
				);
				
		jsonString = gson.toJson(lU);
		System.out.println("List -> " + jsonString);
		
		Type type = new TypeToken<List<ObjectJson>>(){}.getType();
		List<ObjectJson> listaDeserializzata = gson.fromJson(jsonString, type);
		System.out.println("Lista deserializzata -> " + listaDeserializzata);

		return false;
	}

}
