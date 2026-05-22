package com.betacom.others;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.betacom.utils.Utilities;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyFirstThread implements Runnable{

	@Override
	public void run() {
		log.debug("Sono dentro il Thgread --> My First Thread");
		
		for(int i = 0; i <= 20; i++) {
			log.debug("Runnable in esecuzione item {}", i);
		}
		
		log.debug("My First Thread Ended at {}", Utilities.dateToString(LocalDateTime.now()));
		
	}

}
