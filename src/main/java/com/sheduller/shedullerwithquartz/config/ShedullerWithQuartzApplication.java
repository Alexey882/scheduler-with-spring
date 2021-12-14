package com.sheduller.shedullerwithquartz.config;
import com.sheduller.shedullerwithquartz.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@EnableConfigurationProperties
@ComponentScan("com.sheduller.shedullerwithquartz")
public class ShedullerWithQuartzApplication {
    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = SpringApplication.run(ShedullerWithQuartzApplication.class, args);
        var service = applicationContext.getBean("main" , MainService.class);
        service.run();
    }
}
