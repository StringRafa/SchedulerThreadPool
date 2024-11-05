package com.panamby.scheduled.config;

import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
public class TaskExecutorConfig {
	
	@Qualifier("configSchedulerTask1")
	@Bean("configSchedulerTask1")
	public TaskExecutor configSchedulerTask1() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(1);
	    executor.setMaxPoolSize(1);
	    executor.setQueueCapacity(0);
	    executor.setThreadNamePrefix("configSchedulerTask1-");
	    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	    executor.initialize();
	    return executor;
	}
	
	@Qualifier("configSchedulerTask2")
	@Bean("configSchedulerTask2")
	public TaskExecutor configSchedulerTask2() {
	    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
	    executor.setCorePoolSize(1);
	    executor.setMaxPoolSize(1);
	    executor.setQueueCapacity(0);
	    executor.setThreadNamePrefix("configSchedulerTask2-");
	    executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
	    executor.initialize();
	    return executor;
	}
	
	@Qualifier("taskExecutor")
	@Bean("taskExecutor")
	public TaskExecutor taskExecutor() {
	    return new SimpleAsyncTaskExecutor();
	}
}