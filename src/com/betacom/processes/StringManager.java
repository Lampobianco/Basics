package com.betacom.processes;

import com.betacom.interfaces.GeneralProcess;

public class StringManager implements GeneralProcess {

    @Override
    public boolean execute() {
        System.out.println("\n" + "** Begin String Manager **");
        
        String name = "Giancarlo";
        StringBuilder sb = new StringBuilder();
        sb.append("Buongiorno");
        sb.append(", ");
        sb.append("sono ");
        sb.append(name);
        
        String res = sb.toString();
        System.out.println(res);
        
        
        String n  = "francese";
        res = String.format("Il mio nome è %s, e sono %s", name, n);
        System.out.println(res);
        
        if("Giancarlo".equalsIgnoreCase(name)) {
        	
        	System.out.println("Found");
        	
        }
        
        if(res.contains("sono")) {
        	
        	System.out.println("Parola presente nella stringa");
        	
        }else {
        	
        	System.out.println("Parola non trovata !");
        	
        }
        
        String t = "   ".trim();
        if(t.isEmpty()) {
        	
        	System.out.println("La stringa è vuota !");
        	
        }
        
        String p1 = "Samsung";
        String p2 = "Samu111";
        int result = p2.compareTo(p1);
        
        System.out.println("Risultato comparazione -> " + result); // controllare il risultato, non sembra corretto, da 2 lettere differenti ma non è così
        
        // ricordarsi il vari parse int o parse double per fare le trsformazioni tra tipi di dati, andare a controllare bene online
        
        
        /*
         * 
         * split serve per suddividere una stringa in base ad un carattere ricorrente in essa e trasformarla in un array
         * 
         * */
        
        String parameters = "token1, token2, token3, token4";
        String[] tokens = parameters.split(",");
        for(String it : tokens) {
        	
        	System.out.println("-> " + it.trim());
        	
        }
        
        
        /*
         * 
         * Substring
         * 
         * */
        
        System.out.println(res.indexOf("G"));
        System.out.println(res.substring(res.indexOf("G"), res.indexOf(",")));
        
        
        
        return false; 
    }
}