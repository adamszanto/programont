package com.example.coinmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class CoinManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoinManagerApplication.class, args);
    }

}
