package com.plexada;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan(basePackages = "com.plexada")
//@EntityScan("com.plexada.model.employee")
//@EnableJpaRepositories("com.plexada.repositories")
public class Application {
    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
    }
}
