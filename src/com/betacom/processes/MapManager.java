package com.betacom.processes;

import java.util.Map;
import java.util.HashMap;

import com.betacom.interfaces.GeneralProcess;

public class MapManager implements GeneralProcess{

	@Override
	public boolean execute() throws Exception {
		System.out.println("\n" + "Begin Map Manager");
		Map<String, String> map = createMap();
		
		System.out.println("numero elementi della map:" + map.size());
		
		return false;
	}
	
	private Map<String, String> createMap(){
		Map<String, String> map = new HashMap<String,String>();
		
		map.put("k1", "v1");
		map.put("k2", "v2");
		map.put("k3", "v3");
		map.put("k4", "v4");
		map.put("k5", "v5");
		map.put("k6", "v6");
		map.put("k7", "v7");
		map.put("k8", "v8");
		map.put("k9", "v9");
		map.put("k10", "v10");
		
		return map;
	}

}
