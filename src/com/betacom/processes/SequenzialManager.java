package com.betacom.processes;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.betacom.interfaces.GeneralProcess;

public class SequenzialManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		
		System.out.println("Begin Sequenzial Manager");
		
		String filePath ="C://Users//lodan//Desktop//Sequenze/fileToRead.txt";
		String filePath2 ="C://Users//lodan//Desktop//Sequenze/fileToWrite.txt";
		
		List<String> records = readFile(filePath);
		for(String record : records) {
			System.out.println(record);
		}
		
		List <String> write = new ArrayList<String>();
		write.add("Scritto da programma java");
		write.add("Parola 1");
		write.add("Parola 2");
		write.add("Parola 3");
		write.add("Parola 4");
		write.add("Parola 5");
		write.add("Parola 6");
		write.add("Parola 7");
		write.add("Parola 8");
		
		System.out.println("Numero di righe scritte -> " + writeFile(write, filePath2));
		System.out.println();
		System.out.println("Numero di righe scritte -> " + writeFile(write, filePath2, false));
		
		return false;
	}
	
	private List<String> readFile(String path){
		List<String> r = new ArrayList<String>();
		try (BufferedReader reader = new BufferedReader(new FileReader(path))){ // il try chiude automaticamente il file senza il finally
			// permette di aprire un file, quando si apre un file si deve chiudere, ma
			// fatto come ho soprascritto posso evitare fdi chuudere il file
			String line = reader.readLine(); // dentro line avrò la prima riga
			while(line != null) {
				r.add(line); // carico il risultato in line
				line = reader.readLine();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		return r;
	}

	private int writeFile(List<String> input, String path) throws IOException {
		int num = 0;
		File f = new File(path);
		
		if(f.exists()) {
			System.out.println("File -> " + path + " exists");
			f.delete();
		}
		try (FileWriter o = new FileWriter(f)){
			for(String rec : input) {
				o.write(rec);
				o.write("\n");
				num++;
			}
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		return num;
	}
	
	private int writeFile(List<String> input, String path, boolean mode) throws IOException {
		/*
		 * mode = true -> extend file
		 * mode = false -> file replace
		 * 
		 * */
		int num = 0;
		
		try (FileWriter o = new FileWriter(path, mode)){
			for(String rec : input) {
				o.write(rec);
				o.write("\n");
				num++;
			}
		}catch(IOException e) {
			System.err.println(e.getMessage());
		}
		return num;
	}
}
