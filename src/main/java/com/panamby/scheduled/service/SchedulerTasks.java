package com.panamby.scheduled.service;

import java.time.LocalTime;
import java.util.concurrent.Executor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerTasks {
	
	@Qualifier("task1Executor")
	@Autowired
	private Executor task1Executor;

	@Async("task1Executor")
	@Scheduled(fixedDelay = 5000)
	public void schedulerTask1(){
		
		task1Executor.execute(() -> {
			
			log.info("Started task1Executor {}", LocalTime.now());
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				log.error(e.getMessage());
			}
			log.info("Finished task1Executor {}", LocalTime.now());			
		});	
	}

	@Async("task2Executor")
	@Scheduled(fixedDelay = 10000)
	public void schedulerTask2(){
		
		log.info("Started task2Executor {}", LocalTime.now());
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.info("Finished task2Executor {}", LocalTime.now());		
	}

	@Async("task3Executor")
	@Scheduled(fixedDelay = 10000)
	public void schedulerTask3(){
		
		log.info("Started task3Executor {}", LocalTime.now());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.info("Finished task3Executor {}", LocalTime.now());		
	}
	
	@Async("task4Executor")
	@Scheduled(fixedDelay = 10000)
	public void schedulerTask4(){
		
		log.info("Started task4Executor {}", LocalTime.now());
		try {
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			log.error(e.getMessage());
		}
		log.info("Finished task4Executor {}", LocalTime.now());		
	}
}
