package com.example.fanckyspringbootstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
//@EnableConfigurationProperties
public class FanckySpringBootStarterApplication {

    public static void main(String[] args) {
        SpringApplication.run(FanckySpringBootStarterApplication.class, args);
    }

}
