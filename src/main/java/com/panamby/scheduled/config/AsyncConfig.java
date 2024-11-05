package com.panamby.scheduled.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class AsyncConfig {

    @Bean(name = "task1Executor")
    public Executor task1Executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(1);
        executor.setThreadNamePrefix("task1Executor-");
	    executor.setRejectedExecutionHandler(new DiscardPolicy());
        executor.initialize();
        return executor;
    }

    @Bean(name = "task2Executor")
    public Executor task2Executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(1);
        executor.setThreadNamePrefix("task2Executor-");
	    executor.setRejectedExecutionHandler(new DiscardPolicy());
        executor.initialize();
        return executor;
    }

    @Bean(name = "task3Executor")
    public Executor task3Executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(1);
        executor.setThreadNamePrefix("task3Executor-");
	    executor.setRejectedExecutionHandler(new DiscardPolicy());
        executor.initialize();
        return executor;
    }

    @Bean(name = "task4Executor")
    public Executor task4Executor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(1);
        executor.setQueueCapacity(1);
        executor.setThreadNamePrefix("task4Executor-");
	    executor.setRejectedExecutionHandler(new DiscardPolicy());
        executor.initialize();
        return executor;
    }
}
