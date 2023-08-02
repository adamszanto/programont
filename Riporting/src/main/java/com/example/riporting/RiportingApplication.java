package com.example.riporting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "riport")
public class RiportingApplication {
    public static void main(String[] args) {
        SpringApplication.run(RiportingApplication.class, args);

    }

}
