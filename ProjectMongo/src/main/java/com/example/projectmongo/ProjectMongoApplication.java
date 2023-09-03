package com.example.projectmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.example.projectmongo.repository.mongodb")
public class ProjectMongoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProjectMongoApplication.class, args);
    }

}
