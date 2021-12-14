package com.sheduller.shedullerwithquartz.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
@Configuration
@Data
@ConfigurationProperties(prefix = "test")
public class Jobs {
    List<Job> jobs;
        @Configuration
        @Data
        @ConfigurationProperties(prefix = "test.jobs")
        public static class Job {
            DatabaseConfiguration connection;
            String name;
            String surname;
            long delay;
            String fileName;
            String query;
                @Data
                @ToString
                @Configuration
                @ConfigurationProperties(prefix = "test.jobs.connection")
                public static class DatabaseConfiguration {
                    private String driver;
                    private String host;
                    private int port;
                    private String userName;
                    private String password;
                    private String databaseName;
                }
    }
}
