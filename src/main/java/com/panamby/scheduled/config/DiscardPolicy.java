package com.panamby.scheduled.config;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DiscardPolicy implements RejectedExecutionHandler {
	
    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    	log.info("Agendamento rejeitado: " + r.toString());
    }
}
