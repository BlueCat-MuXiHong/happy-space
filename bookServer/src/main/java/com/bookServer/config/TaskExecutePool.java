package com.bookServer.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义创建线程池
 */
@Configuration
@EnableAsync
public class TaskExecutePool {
    @Bean("test")
    public Executor myTaskAsyncPool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(6); //核心线程数
        executor.setMaxPoolSize(8);  //最大线程数
        executor.setQueueCapacity(12); //队列大小
        executor.setKeepAliveSeconds(16); //线程最大空闲时间
        executor.setThreadNamePrefix("async-Executor-"); //指定用于新创建的线程名称的前缀。
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); // 拒绝策略（一共四种，此处省略）
        executor.initialize();
        return executor;
    }
}