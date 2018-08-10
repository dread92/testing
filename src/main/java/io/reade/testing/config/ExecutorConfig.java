package io.reade.testing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
public class ExecutorConfig {
    @Bean
    public Executor asyncExecutor() {
            ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
            executor.setCorePoolSize(8);
            executor.setMaxPoolSize(8);
            executor.setQueueCapacity(500);
            executor.setThreadNamePrefix("GithubLookup-");
            executor.initialize();
            return executor;
    }
}
