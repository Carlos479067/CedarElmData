package com.example.cedar_data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class CedarDataApplication {

    public static void main(String[] args) {
        SpringApplication.run(CedarDataApplication.class, args);
    }

}
